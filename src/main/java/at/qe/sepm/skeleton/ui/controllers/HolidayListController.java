package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.Holiday;
import at.qe.sepm.skeleton.services.HolidayService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Controller for the user list view.
 *
 * This class is part of the skeleton project provided for students of the
 * courses "Software Architecture" and "Software Engineering" offered by the
 * University of Innsbruck.
 */
@Component
@Scope("view")
public class HolidayListController {

    @Autowired
    private HolidayService holidayService;

    /**
     * Returns a list of all users.
     *
     * @return
     */
    public Collection<Holiday> getHolidays() {

        return holidayService.getAllHolidays();

    }





    public Collection<Holiday> getHolidayByUser(String username){

        return holidayService.getHolidayByUser(username);
    }



}