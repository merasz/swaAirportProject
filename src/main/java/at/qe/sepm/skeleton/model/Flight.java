package at.qe.sepm.skeleton.model;

import java.io.Serializable;
import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.services.AircraftService;
import at.qe.sepm.skeleton.model.Aircraft;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.domain.Persistable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.text.SimpleDateFormat;
/**
 * Entity representing flights.
 *
 * This class is part of the skeleton project provided for students of the
 * courses "Software Architecture" and "Software Engineering" offered by the
 * University of Innsbruck.
 */
@Entity
public class Flight implements Persistable<String>, Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 50)
    private String flightId;
    private String iataFrom;
    private String iataTo;
    private Date departureTime;
    private Date arrivalTime;
    private Date dateFlight;
    private String flightTime;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircraft_id")
    private Aircraft scheduledAircraft;

    
    
	@OneToMany
    private List<User> assignedPilots;
    @OneToMany
    private List<User> assignedBoardpersonal;
    private int numberOfPassengers;




    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @ManyToOne(optional = true)
    private Flight updateFlight;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    

    public void setFlightTime(){

        this.flightTime = calcFlightTime(this.departureTime, this.arrivalTime);

    }


    public String calcFlightTime(Date deparTime, Date arrTime){

        long dep = deparTime.getTime();
        long arr = arrTime.getTime();
        long ft = arr - dep;

        return (new SimpleDateFormat("hh:mm")).format(new Date(ft));
    }

    public Flight getUpdateFlight() {
        return updateFlight;
    }

    public void setUpdateFlight(Flight updateFlight) {
        this.updateFlight = updateFlight;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDateFlight() {
        return dateFlight;
    }

    public void setDateFlight(Date dateFlight) {
        this.dateFlight = dateFlight;
    }

    public List<User> getAssignedPilots() {
        return assignedPilots;
    }

    public void setAssignedPilots(List<User> assignedPilots) {
        this.assignedPilots = assignedPilots;
    }

    public List<User> getAssignedBoardpersonal() {
        return assignedBoardpersonal;
    }

    public void setAssignedBoardpersonal(List<User> assignedBoardpersonal) {
        this.assignedBoardpersonal = assignedBoardpersonal;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }



    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        final Flight other = (Flight) obj;
        if (!Objects.equals(this.flightId, other.flightId)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "at.qe.sepm.skeleton.model.Flight[ id=" + flightId + " ]";
    }

    @Override
    public String getId() {
        return getFlightId();
    }

    public void setId(String id) {
        setFlightId(id);
    }

    @Override
    public boolean isNew() {
        return (null == createDate);
    }


	public Aircraft getScheduledAircraft() {
		return scheduledAircraft;
	}


	public void setScheduledAircraft(Aircraft scheduledAircraft) {
		this.scheduledAircraft = scheduledAircraft;
	}


    
	
    
}