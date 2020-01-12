package at.qe.sepm.skeleton.repositories;

import at.qe.sepm.skeleton.model.Aircraft;
import at.qe.sepm.skeleton.model.Flight;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository for managing {@link Flight} entities.
 *
 * This class is part of the skeleton project provided for students of the
 * courses "Software Architecture" and "Software Engineering" offered by the
 * University of Innsbruck.
 */

public interface FlightRepository extends AbstractRepository<Flight,String>{

    Flight findFirstByFlightId(String flightId);

    List<Flight> findByFlightIdContaining(String flightId);

    @Query("SELECT k FROM Flight k WHERE k.flightId =:flightId")
    List<Flight> findByFlightId(@Param("flightId") String flightId);
    
    
}
