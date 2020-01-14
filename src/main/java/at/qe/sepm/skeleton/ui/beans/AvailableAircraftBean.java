package at.qe.sepm.skeleton.ui.beans;

import java.util.ArrayList;
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
import at.qe.sepm.skeleton.services.AircraftService;
import at.qe.sepm.skeleton.ui.controllers.AircraftListController;


@ManagedBean
@Scope("prototype")
public class AvailableAircraftBean {
	@Autowired
	private AircraftService aircraftService;
	
	
	private List<String> availableAircraftList;
	
	@PostConstruct
	public void init() {
		availableAircraftList = new ArrayList<>();
		List<Aircraft> temp = new ArrayList<>();
		temp.addAll(aircraftService.getAllAircrafts());
		for (Aircraft val : temp) {
			availableAircraftList.add(val.getAircraftId());
		}
		
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
