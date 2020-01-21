package at.qe.sepm.skeleton.services;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.model.AuditLog;
import at.qe.sepm.skeleton.model.Flight;
import at.qe.sepm.skeleton.repositories.AircraftRepository;
import at.qe.sepm.skeleton.repositories.AuditLogRepository;
import at.qe.sepm.skeleton.repositories.FlightRepository;

import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


/**
 * Service for accessing and manipulating aircraft data.
 */


@Component
@Scope("application")
public class AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;
    
    @Autowired
    private AuditLogRepository auditLogRepository;
    

    /**
     * Returns a collection of all aircrafts.
     *
     * @return
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public Collection<Aircraft> getAllAircrafts() {
        return aircraftRepository.findAll();
    }

    /**
     * Loads a single aircraft identified by its id.
     *
     * @param aircraftname the id to search for
     * @return the aircraft with the given id
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER') or principal.aircraftname eq #aircraftname")
    public Aircraft loadAircraft(String aircraftId) {
        return aircraftRepository.findFirstByAircraftId(aircraftId);
    }

    /**
     * Saves the aircraft.
     *
     * @param aircraft the aircraft to save
     * @return the updated aircraft
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public Aircraft saveAircraft(Aircraft aircraft) {

        if (aircraft.isNew()) {
            aircraft.setCreateDate(new Date());

        } else {
            aircraft.setUpdateDate(new Date());
            aircraft.setUpdateAircraft(getAuthenticatedUser());
        }
        return aircraftRepository.save(aircraft);
    }

    /**
     * Deletes the aircraft.
     *
     * @param aircraft the aircraft to delete
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public void deleteAircraft(Aircraft aircraft) {
        AuditLog auditlog = new AuditLog();
        auditlog.setDate(new Date());
        auditlog.setMessage("Aircraft: " + aircraft.getAircraftId() + " was deleted.");
        auditLogRepository.save(auditlog);
        
    	aircraftRepository.delete(aircraft);
    }

    private Aircraft getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return aircraftRepository.findFirstByAircraftId(auth.getName());
    }


}
