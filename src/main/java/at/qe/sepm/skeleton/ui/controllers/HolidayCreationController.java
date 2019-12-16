package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.Holiday;
import at.qe.sepm.skeleton.services.HolidayService;
import at.qe.sepm.skeleton.services.UserService;
import at.qe.sepm.skeleton.ui.beans.SessionInfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Date;
import java.text.ParseException;
import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.repositories.UserRepository;



/**
 Controller for the creation of holidays
 **/

@Component
@Scope("view")
public class HolidayCreationController{

    @Autowired
    private HolidayService holidayService;
    private UserService userService;

    private UserRepository userRepository;


    /**
     * Creates a new holiday
     */
    private Holiday holiday = new Holiday();

    public boolean setNewHoliday() throws ParseException{

        this.holiday.setUsername("");
        this.holiday.setHolidayFrom(null);
        this.holiday.setHolidayUntil(null);
        this.holiday.setHolidayDays("16/12/2019", "16/12/2019");



        return true;

    }

    /**
     * Returns the currently displayed holiday
     * @return
     */

    public Holiday getHoliday(){ return holiday;}

    /**
     * Action to save the currently displayed holiday
     */
    public void doSaveHoliday() {

        holiday = this.holidayService.saveHoliday(holiday);
    }


}