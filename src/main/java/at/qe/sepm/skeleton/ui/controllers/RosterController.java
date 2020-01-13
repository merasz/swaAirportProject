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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;

@Component
@Scope("view")
public class RosterController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private SessionInfoBean infoBean;

    private ScheduleModel eventModel = new DefaultScheduleModel();


    private ScheduleEvent event = new DefaultScheduleEvent();


    @PostConstruct
    public void init() {
        Collection<Flight> flights = flightService.getAllFlights() ;
        User current = infoBean.getCurrentUser();
        
        DefaultScheduleEvent event = new DefaultScheduleEvent();

        event.setId("123");
        event.setTitle("Champions League Match");
        event.setStartDate(flights.iterator().next().getDepartureTime());
        event.setEndDate(flights.iterator().next().getArrivalTime());
        event.setDescription("Team A vs. Team B);
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
