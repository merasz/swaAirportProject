package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.Flight;
import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.services.FlightService;
import at.qe.sepm.skeleton.ui.beans.SessionInfoBean;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;

@Component
@Scope("view")
public class RosterController implements Serializable {

    @Autowired
    private FlightService flightService;

    @Autowired
    private SessionInfoBean infoBean;
    
    private User current;

    private ScheduleModel eventModel = new DefaultScheduleModel();

    private ScheduleEvent event = new DefaultScheduleEvent();


    @PostConstruct
    public void init() {
        Collection<Flight> flights = flightService.getAllFlights() ;
        current = infoBean.getCurrentUser();

        DefaultScheduleEvent event = new DefaultScheduleEvent();
        	
        if (current.getJobTitle() != null) {
	        if(current.getJobTitle().contentEquals("Pilot")) {
	        		for (Flight flight : flights) {
	        		if (flight.getAssignedPilots().contains(current)) {
	        			DefaultScheduleEvent event1 = new DefaultScheduleEvent();
	        			event1.setId(flight.getFlightId());
	        			event1.setTitle("Flight " + flight.getFlightId());
	        			event1.setStartDate(flight.getDepartureTime());
	        			event1.setEndDate(flight.getArrivalTime());
	        			event1.setDescription("Flight " + flight.getFlightId() + " from " +
	        				flight.getIataFrom() + " to " + flight.getIataTo() + " with Aircraft "
	        				+ flight.getScheduledAircraftId());
	        			event1.setEditable(false);
	        			
	        			eventModel.addEvent(event1);
	        		}
	        	}
	        }
	        
	        if(current.getJobTitle().contentEquals("Boardpersonal")) {
	        	for (Flight flight : flights) {
	        		if (flight.getAssignedPilots().contains(current)) {
	        			DefaultScheduleEvent event2 = new DefaultScheduleEvent();
	        			event2.setId(flight.getFlightId());
	        			event2.setTitle("Flight " + flight.getFlightId());
	        			event2.setStartDate(flight.getDepartureTime());
	        			event2.setEndDate(flight.getArrivalTime());
	        			event2.setDescription("Flight " + flight.getFlightId() + " from " +
	        				flight.getIataFrom() + " to " + flight.getIataTo() + " with Aircraft "
	        				+ flight.getScheduledAircraftId());
	        			event2.setEditable(false);
	        			
	        			eventModel.addEvent(event2);
	        		}
	        	}
	        }
        }
        
        event.setId("123");
        event.setTitle("Champions League Match");
        event.setStartDate(flights.iterator().next().getDepartureTime());
        event.setEndDate(flights.iterator().next().getArrivalTime());
        event.setDescription("Team A vs. Team B");
        event.setEditable(false);


        eventModel.addEvent(event);

    }

    public ScheduleModel getEventModel() {


        return eventModel;
    }


    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }


}
