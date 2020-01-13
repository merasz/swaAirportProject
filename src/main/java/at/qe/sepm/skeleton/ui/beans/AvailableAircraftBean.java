package at.qe.sepm.skeleton.ui.beans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.services.AircraftService;


@ManagedBean
@ApplicationScoped
public class AvailableAircraftBean {
	private AircraftService aircraftService;
	
	
	private Set<Aircraft> availableAircraftList;
	
	@PostConstruct
	public void init() {

		
	}


	public AircraftService getAircraftService() {
		return aircraftService;
	}

	public void setAircraftService(AircraftService aircraftService) {
		this.aircraftService = aircraftService;
	}

	public Set<Aircraft> getAvailableAircraftList() {
		return availableAircraftList;
	}

	public void setAvailableAircraftList(Set<Aircraft> availableAircraftList) {
		this.availableAircraftList = availableAircraftList;
	}
	
	
}
