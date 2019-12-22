package at.qe.sepm.skeleton.repositories;

import at.qe.sepm.skeleton.model.Holiday;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository for managing {@link Holiday} entities.
 *
 * This class is part of the skeleton project provided for students of the
 * courses "Software Architecture" and "Software Engineering" offered by the
 * University of Innsbruck.
 */
public interface HolidayRepository extends AbstractRepository<Holiday, Long> {

    Holiday findFirstByUsername(String username);


    @Query("SELECT u FROM Holiday u WHERE u.username = :username")
    List<Holiday> findByUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query("DELETE Holiday h WHERE h.id = :id")
    void deleteById(long id);

}