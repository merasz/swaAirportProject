package at.qe.sepm.skeleton.services;

import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.model.Holiday;
import at.qe.sepm.skeleton.repositories.HolidayRepository;
import at.qe.sepm.skeleton.repositories.UserRepository;
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

    private UserService userService;

    private UserRepository userRepository;

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


    public Collection<Holiday> testGet(){return holidayRepository.test();}


    /**
     * Loads a single holiday identified by its username.
     *
     * @param username the username to search for
     * @return the userwith the given username
     */

    public Holiday loadHoliday(String user) {
        return holidayRepository.findFirstByUsername(user);
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

    public Holiday saveHoliday(Holiday holiday) {
        if (holiday.isNew()) {
            holiday.setCreateDate(new Date());

        } else {
            holiday.setUpdateDate(new Date());

        }


        holiday.setUsername(getAuthenticatedUsername());
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

    private String getAuthenticatedUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findFirstByUsername(auth.getName()).getUsername();
    }


}
