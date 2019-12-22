package at.qe.sepm.skeleton.services;


import at.qe.sepm.skeleton.model.Holiday;
import at.qe.sepm.skeleton.repositories.HolidayRepository;
import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Service for accessing and manipulating holiday data.
 *
 * This class is part of the skeleton project provided for students of the
 * courses "Software Architecture" and "Software Engineering" offered by the
 * University of Innsbruck.
 */
@Component
@Scope("application")
public class HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

    /**
     * Returns a collection of all holidays.
     *
     * @return
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    public Collection<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }

    public Collection <Holiday> getHolidayByUser(String username){return holidayRepository.findByUsername(username);}



    /**
     * Loads a single holiday identified by its holidayname.
     *
     * @param holidayname the holidayname to search for
     * @return the holiday with the given holidayname
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('EMPLOYEE') or hasAuthority('MANAGER')")
    public Holiday loadHoliday(Long id) {
        return holidayRepository.findFirstById(id);
    }




    /**
     * Saves the holiday. This method will also set {@link Holiday#createDate} for new
     * entities or {@link Holiday#updateDate} for updated entities. The holiday
     * requesting this operation will also be stored as {@link Holiday#createDate}
     * or {@link Holiday#updateHoliday} respectively.
     *
     * @param holiday the holiday to save
     * @return the updated holiday
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('EMPLOYEE') or hasAuthority('MANAGER')")
    public Holiday saveHoliday(Holiday holiday) {
        if (holiday.isNew()) {
            holiday.setCreateDate(new Date());

        } else {
            holiday.setUpdateDate(new Date());

        }
        return holidayRepository.save(holiday);
    }


    /**
     * Deletes the holiday.
     *
     * @param holiday the holiday to delete
     */

    public void deleteHoliday(Holiday holiday) {
        holidayRepository.delete(holiday);
        // :TODO: write some audit log stating who and when this holiday was permanently deleted.
    }



}
