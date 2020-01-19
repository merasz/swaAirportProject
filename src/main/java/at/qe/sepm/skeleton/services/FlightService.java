package at.qe.sepm.skeleton.services;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.model.Flight;
import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.repositories.AircraftRepository;
import at.qe.sepm.skeleton.repositories.FlightRepository;
import at.qe.sepm.skeleton.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

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
    private AircraftRepository aircraftRepository;
    
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
    @PreAuthorize("hasAuthority('ADMIN')")
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
    
    @PreAuthorize("hasAuthority('ADMIN')")
    public int getRandomNumber(int lengthOfPersonalList) {
    	Random randomGenerator = new Random();
    	int pickElement = randomGenerator.nextInt(lengthOfPersonalList);
    	return pickElement;
    }
    
    public Collection<User> assignPersonal(List<User> personal, int requiredPersonal, Flight flight) {
    	Date flightDeparture = flight.getDepartureTime();
    	Date flightArrival = flight.getArrivalTime();
    	User tempUser;
    	List<User> availablePersonal = new ArrayList<>();
    	List<User> executingPersonal = new ArrayList<>();
    	for (int i = 0; i <= requiredPersonal; i++) {
    		tempUser = personal.get(i);
    		if(tempUser.getAvailable(tempUser.calculateBreak(tempUser.getLastFlight(), flightDeparture), 
    				tempUser.calculateHoursWithNewFlight(tempUser.getHoursWorkedWeek(),flight.getFlightTimeInHours()),
    				tempUser.getHasHoliday()))
    			availablePersonal.add(tempUser);
    	}
//    	hier am besten ersteller des fluges ein prompt ausgeben dass kein personal vorhanden ist und flug erstellung abbrechen
    	if(availablePersonal.size() < requiredPersonal) {
    		System.out.println("Kein Personal vorhanden für diesen Flug!");
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
    
    @PreAuthorize("hasAuthority('ADMIN')")
    public void assignPersonalToFlight(Flight flight) {
    	List<User> boardcrew = new ArrayList<>();
    	List<User> pilots = new ArrayList<>();
    	List<User> pilotsExecutingFlight = new ArrayList<>();
    	List<User> boardcrewExecuting = new ArrayList<>();
    	
    	boardcrew.addAll(userService.getBoardcrew());
    	pilots.addAll(userService.getAllPilots());
    	
    	boardcrewExecuting.addAll(assignPersonal(boardcrew, boardcrew.size(), flight));
    	pilotsExecutingFlight.addAll(assignPersonal(pilots, pilots.size(), flight));
    	
    	flight.setAssignedBoardpersonal(boardcrewExecuting);
    	flight.setAssignedPilots(pilotsExecutingFlight);
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    public Flight saveFlight(Flight flight) {
        if (flight.isNew()) {
            flight.setCreateDate(new Date());
            flight.setDateFlight(flight.getDepartureTime());
            flight.setScheduledAircraft(aircraftService.loadAircraft(flight.getScheduledAircraftId()));
            flight.setFlightTime();
//            assignPersonalToFlight(flight);
        } else {
            flight.setUpdateDate(new Date());
            flight.setUpdateFlight(getAuthenticatedUser());
        }
        return flightRepository.save(flight);
    }

    /**
     * Deletes the flight.
     *
     * @param flight the flight to delete
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteFlight(Flight flight) {
        flightRepository.delete(flight);
        // :TODO: write some audit log stating who and when this flight was permanently deleted.
    }

    private Flight getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return flightRepository.findFirstByFlightId(auth.getName());
    }
    
    
}
