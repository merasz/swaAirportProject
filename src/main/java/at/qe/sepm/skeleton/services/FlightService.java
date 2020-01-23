	package at.qe.sepm.skeleton.services;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.model.AuditLog;
import at.qe.sepm.skeleton.model.Flight;
import at.qe.sepm.skeleton.model.Holiday;
import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.repositories.AircraftRepository;
import at.qe.sepm.skeleton.repositories.AuditLogRepository;
import at.qe.sepm.skeleton.repositories.FlightRepository;
import at.qe.sepm.skeleton.repositories.UserRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Service for accessing and manipulating flight data.
 *
 * This class is part of the skeleton project provided for students of the
 * courses "Software Architecture" and "Software Engineering" offered by the
 * University of Innsbruck.
 */
@Component
@Scope("application")
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;
    
    @Autowired
    private AuditLogRepository auditLogRepository;
    
    @Autowired
    private AircraftRepository aircraftRepository;
    
    @Autowired
    private HolidayService holidayService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AircraftService aircraftService;
    /**
     * Returns a collection of all flights.
     *
     * @return
     */
    public Collection<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    /**
     * Loads a single flight identified by its flightId.
     *
     * @param flightId the flightId to search for
     * @return the flight with the given flightname
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public Flight loadFlight(String flightId) {
        return flightRepository.findFirstByFlightId(flightId);
    }
    /**
     * Saves the flight. This method will also set {@link Flight#createDate} for new
     * entities or {@link Flight#updateDate} for updated entities. The flight
     * requesting this operation will also be stored as {@link Flight#createDate}
     * or {@link Flight#updateFlight} respectively.
     *
     * @param flight the flight to save
     * @return the updated flight
     */
    
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public int getRandomNumber(int lengthOfPersonalList) {
    	Random randomGenerator = new Random();
    	int pickElement = randomGenerator.nextInt(lengthOfPersonalList);
    	return pickElement;
    }
    
    public Date parseStringdateToDate(String date) throws ParseException {
    	return (new SimpleDateFormat("yyyy-mm-dd").parse(date));    
    }
    
    public boolean betweenDate(Date start, Date end, Date depTime, Date arrTime, Flight flight) {
    	List<Date> holidayDayList = new ArrayList<>();
		Calendar from = Calendar.getInstance();
		Calendar to = Calendar.getInstance();
		
		Calendar dep = Calendar.getInstance();
		dep.setTime(depTime);
		Calendar arr = Calendar.getInstance();
		arr.setTime(arrTime);
		
		from.setTime(start);
		to.setTime(end);
		
		while(from.before(to)) {
			holidayDayList.add(from.getTime());
			from.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		Calendar personalIsAgainHomeAirport = Calendar.getInstance();
		long persHomeInMilli = arrTime.getTime();
		persHomeInMilli += 7200000;
		persHomeInMilli += flight.getFlightTimeInMilli();
		personalIsAgainHomeAirport.setTimeInMillis(persHomeInMilli);
		
		Date personalHomeTime = personalIsAgainHomeAirport.getTime();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		for (Date holi : holidayDayList) {
			if(fmt.format(holi).equals(fmt.format(depTime)) || 
					fmt.format(holi).equals(fmt.format(arrTime)) || 
						fmt.format(holi).equals(fmt.format(personalHomeTime))) {
				return true;
			}
		}
    	
    	return false;
    }
    
    public Collection<User> assignPersonal(Collection<User> personal, int requiredPersonal, Flight flight) throws ParseException {
    	Date flightDeparture = flight.getDepartureTime();
    	Date flightArrival = flight.getArrivalTime();
    	List<User> availablePersonal = new ArrayList<>();
    	List<User> executingPersonal = new ArrayList<>();
    	double tempHoursWorkedWeek;
    	
    	Collection<Flight> allFlights = getAllFlights();
    	double hoursWorked = 0;
    	
    	for (int i = 0; i < 100; i++) {
			System.out.println("in assignpers sizeboardcrew: " + personal.size());
		}
    	
    	for (User currentUser : personal) {
    		Collection<Holiday> listOfHolidays = holidayService.getHolidayByUser(currentUser.getUsername());
    		boolean userHasHolidayOnFlight = false;
    		
    		if(listOfHolidays.isEmpty()) {
    			userHasHolidayOnFlight = false;
    		}
    		else {
    			for (Holiday holiday : listOfHolidays) {
    				if(betweenDate(parseStringdateToDate(holiday.getHolidayFrom()), parseStringdateToDate(holiday.getHolidayUntil()), flightDeparture, flightArrival, flight))
    					userHasHolidayOnFlight = true;
					}
    		}
    		List<Date> weekOfInterest = currentUser.getWeekOfInterest(flight.getDepartureTime(), flight.getArrivalTime());
    		List<Flight> flightsBetween = flightRepository.findFlightsBetween(weekOfInterest.get(0), weekOfInterest.get(1));
    		hoursWorked = 0;
    		boolean isBetweenFlightBreak = false;
    		if(!(flightsBetween.isEmpty())) {
    			isBetweenFlightBreak = currentUser.calculateBreak(flightsBetween, flight);
	    		for (Flight val : flightsBetween) {
	    				if(val.getAssignedBoardpersonal().contains(currentUser))
	    					hoursWorked += val.getFlightTimeInHours()*2+12;
	    				if(val.getAssignedPilots().contains(currentUser))
	    					hoursWorked += val.getFlightTimeInHours()*2+12;
				}
	    		if(currentUser.getAvailable(isBetweenFlightBreak, currentUser.calculateHoursWithNewFlight(hoursWorked,flight.getFlightTimeInHours()), !(userHasHolidayOnFlight)))
	    			availablePersonal.add(currentUser);
    		}
    		else {
    			if(!(userHasHolidayOnFlight))
    					availablePersonal.add(currentUser);
	    	}
    	}

    	if(availablePersonal.size() < requiredPersonal) {
    		return null;
    	}
    	else {
    		while(requiredPersonal > 0) {
    			int randNum = getRandomNumber(availablePersonal.size());
    			executingPersonal.add(availablePersonal.get(randNum));
    			availablePersonal.remove(randNum);
    			--requiredPersonal;
    		}
    	}
    	return executingPersonal;
    }
    
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public void assignPersonalToFlight(Flight flight) throws ParseException {
    	Collection<User> boardcrew = userService.getBoardpersonal();
    	Collection<User> pilots = userService.getAllPilots();
    	Set<User> pilotsExecuting = new HashSet<>();
    	Set<User> boardcrewExecuting = new HashSet<>();
    	
    	boardcrewExecuting.addAll(assignPersonal(boardcrew, flight.getScheduledAircraft().getRequiredBoardpersonalAircraft(), flight));
    	if(boardcrewExecuting.isEmpty())
    		errorMessage("No available Boardcrew!", FacesMessage.SEVERITY_ERROR);
    	
    	pilotsExecuting.addAll(assignPersonal(pilots, flight.getScheduledAircraft().getRequiredPilotsAircraft(), flight));
    	if(pilotsExecuting.isEmpty())
    		errorMessage("No available Pilots!", FacesMessage.SEVERITY_ERROR);
    	
    	flight.setAssignedBoardpersonal(boardcrewExecuting);
    	flight.setAssignedPilots(pilotsExecuting);
    	
    }
    
    public void callReturnFlight(Flight returnFlight) {
    	returnFlight.setFlightId(returnFlight.getFlightId() + " Flight back");
    	String tempIataTo = returnFlight.getIataFrom();
    	returnFlight.setIataFrom(returnFlight.getIataTo());
    	returnFlight.setIataTo(tempIataTo);
    	
    	flightRepository.save(returnFlight);
    }
    

    
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public Flight saveFlight(Flight flight) throws ParseException {
    	String tempFrom = flight.getIataFrom();
    	String tempTo = flight.getIataTo();
    	String flightId = flight.getFlightId() + " 101";

        if (flight.isNew()) {
            flight.setCreateDate(new Date());
            flight.setDateFlight(flight.getDepartureTime());
            flight.setScheduledAircraft(aircraftService.loadAircraft(flight.getScheduledAircraftId()));
            flight.setFlightTime();
            assignPersonalToFlight(flight);
            flightRepository.save(flight);
        } else {
            flight.setUpdateDate(new Date());
            flight.setUpdateFlight(getAuthenticatedUser());
        }
        flight.setFlightId(flightId);
        flight.setIataFrom(tempTo);
        flight.setIataTo(tempFrom);
        flight.setNumberOfPassengers(0);
        Calendar tmp = Calendar.getInstance();
        tmp.set(2020, 2, 22, 3, 0);
        flight.setDepartureTime(tmp.getTime());
        tmp.add(Calendar.HOUR_OF_DAY, 4);
        flight.setArrivalTime(tmp.getTime());
        flightRepository.save(flight);
        return flightRepository.save(flight);
    }

    /**
     * Deletes the flight.
     *
     * @param flight the flight to delete
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public void deleteFlight(Flight flight) {
        flightRepository.delete(flight);
        // :TODO: write some audit log stating who and when this flight was permanently deleted.
    }

    private Flight getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return flightRepository.findFirstByFlightId(auth.getName());
    }
    
    public void errorMessage(String errorMsg, FacesMessage.Severity severity) {
    	FacesMessage msg = new FacesMessage(severity, errorMsg, null);
    	FacesContext.getCurrentInstance().addMessage(errorMsg, msg);
    }
    
}
