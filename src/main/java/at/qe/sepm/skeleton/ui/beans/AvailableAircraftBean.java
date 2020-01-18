package at.qe.sepm.skeleton.ui.beans;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.model.Flight;
import at.qe.sepm.skeleton.repositories.FlightRepository;
import at.qe.sepm.skeleton.services.AircraftService;
import at.qe.sepm.skeleton.services.FlightService;
import at.qe.sepm.skeleton.ui.controllers.AircraftListController;
import net.bytebuddy.asm.Advice.Local;

@ManagedBean
@Scope("request")
public class AvailableAircraftBean {
	@Autowired
	private AircraftService aircraftService;
	
	@Autowired
	private FlightService flightService;
	
	
	private List<String> availableAircraftList;
	
	@PostConstruct
	public void init() {
		availableAircraftList = new ArrayList<>();
		Collection<Aircraft> temp = new HashSet<>();
		temp.addAll(validate(aircraftService.getAllAircrafts()));
		for (Aircraft val : temp)
			availableAircraftList.add(val.getAircraftId());
	}


	private Collection<? extends Aircraft> validate(Collection<Aircraft> allAircrafts) {
		//gives me all aircrafts back where the capacity is in range
		Collection<Aircraft> availableAircrafts = new HashSet<>();
		List<Flight> allFlights = new ArrayList<>();
		allFlights.addAll(flightService.getAllFlights());


		
		for (Aircraft aircraft : allAircrafts)
			if(!aircraft.isScheduled())
				availableAircrafts.add(aircraft);
		return availableAircrafts;
	}


	public AircraftService getAircraftService() {
		return aircraftService;
	}

	public void setAircraftService(AircraftService aircraftService) {
		this.aircraftService = aircraftService;
	}

	public List<String> getAvailableAircraftList() {
		return availableAircraftList;
	}

	public void setAvailableAircraftList(List<String> availableAircraftList) {
		this.availableAircraftList = availableAircraftList;
	}
	
	
}
