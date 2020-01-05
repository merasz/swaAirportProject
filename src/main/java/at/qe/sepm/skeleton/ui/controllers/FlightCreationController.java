package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.model.Flight;
import at.qe.sepm.skeleton.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Date;
import at.qe.sepm.skeleton.model.User;

/**
 Controller for the creation of flights
 **/

@Component
@Scope("view")
public class FlightCreationController{

    @Autowired
    private FlightService flightService;

    /**
     * Creates a new flight
     */
    private Flight flight = new Flight();

    public boolean setNewFlight(){

        this.flight.setFlightId("");
        this.flight.setIataFrom("");
        this.flight.setIataTo("");
        this.flight.setDepartureTime(new Date());
        this.flight.setArrivalTime(new Date());
        this.flight.setDateFlight(new Date());

        List<User> temp = null;


        this.flight.setAssignedPilots(temp);
        this.flight.setAssignedBoardpersonal(temp);

        this.flight.setNumberOfPassengers(0);


        return true;

    }

    /**
     * Returns the currently displayed flight
     * @return
     */

    public Flight getFlight(){ return flight;}

    /**
     * Action to save the currently displayed user.
     */
    public void doSaveFlight() {

        flight = this.flightService.saveFlight(flight);
    }




}