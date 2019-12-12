package at.qe.sepm.skeleton.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.domain.Persistable;


@Entity
public class Flight implements Persistable<String>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @Column(length = 50)
	private String flightId;
	private String iataFrom;
	private String iataTo;
	private Date departureTimeFlight;
	private Date arrivalTimeFlight;
	private Date dateFlight;
	private List<Pilot> assignedPilotsFlight;
	private List<Boardpersonal> assignedBoardpersonalFlight;
	private int numberOfPassengers;
	private Aircraft usedAircraftFlight;
	
	public Flight(String iataFrom, String iataTo, Date departureTimeFlight, Date arrivalTimeFlight, Date dateFlight,
			List<Pilot> assignedPilotsFlight, List<Boardpersonal> assignedBoardpersonalFlight, int numberOfPassengers,
			Aircraft usedAircraftFlight) {
		this.iataFrom = iataFrom;
		this.iataTo = iataTo;
		this.departureTimeFlight = departureTimeFlight;
		this.arrivalTimeFlight = arrivalTimeFlight;
		this.dateFlight = dateFlight;
		this.assignedPilotsFlight = assignedPilotsFlight;
		this.assignedBoardpersonalFlight = assignedBoardpersonalFlight;
		this.numberOfPassengers = numberOfPassengers;
		this.usedAircraftFlight = usedAircraftFlight;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getIataFrom() {
		return iataFrom;
	}

	public void setIataFrom(String iataFrom) {
		this.iataFrom = iataFrom;
	}

	public String getIataTo() {
		return iataTo;
	}

	public void setIataTo(String iataTo) {
		this.iataTo = iataTo;
	}

	public Date getDepartureTimeFlight() {
		return departureTimeFlight;
	}

	public void setDepartureTimeFlight(Date departureTimeFlight) {
		this.departureTimeFlight = departureTimeFlight;
	}

	public Date getArrivalTimeFlight() {
		return arrivalTimeFlight;
	}

	public void setArrivalTimeFlight(Date arrivalTimeFlight) {
		this.arrivalTimeFlight = arrivalTimeFlight;
	}

	public Date getDateFlight() {
		return dateFlight;
	}

	public void setDateFlight(Date dateFlight) {
		this.dateFlight = dateFlight;
	}

	public List<Pilot> getAssignedPilotsFlight() {
		return assignedPilotsFlight;
	}

	public void setAssignedPilotsFlight(List<Pilot> assignedPilotsFlight) {
		this.assignedPilotsFlight = assignedPilotsFlight;
	}

	public List<Boardpersonal> getAssignedBoardpersonalFlight() {
		return assignedBoardpersonalFlight;
	}

	public void setAssignedBoardpersonalFlight(List<Boardpersonal> assignedBoardpersonalFlight) {
		this.assignedBoardpersonalFlight = assignedBoardpersonalFlight;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	public Aircraft getUsedAircraftFlight() {
		return usedAircraftFlight;
	}

	public void setUsedAircraftFlight(Aircraft usedAircraftFlight) {
		this.usedAircraftFlight = usedAircraftFlight;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
