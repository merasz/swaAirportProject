package at.qe.sepm.skeleton.repositories;

import at.qe.sepm.skeleton.model.Aircraft;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository for managing Aircraft entities
 */

public interface AircraftRepository extends AbstractRepository<Aircraft, String>{

    Aircraft findFirstByAircraftId(String aircraftId);

    List<Aircraft> findByAircraftIdContaining(String aircraftId);

    //braucht keine query einfach über verfügbare liste iterieren und mittels id suchen
    List<Aircraft> findByAircraftId(@Param("aircraftId") String aircraftId);
}
