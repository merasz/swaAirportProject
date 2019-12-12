package at.qe.sepm.skeleton.ui.controllers;

import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Controller for the user creation view.
 *
 */
@Component
@Scope("view")
public class UserCreationController {

    @Autowired
    private UserService userService;

    /**
     * Attribute to cache the currently displayed user
     */
    private User user = new User();

    public boolean setNewUser(){

        this.user.setUsername("");
        this.user.setPassword("");
        this.user.setEmail("");
        this.user.setPhone("");
        this.user.setLastName("");
        this.user.setFirstName("");
        this.user.setEnabled(true);
        return true;

    }

    /**
     * Returns the currently displayed user.
     *
     * @return
     */
    public User getUser() { return user;
    }

    public void setUser(){
        this.user = user;
        setNewUser();
    }

    /**
     * Action to save the currently displayed user.
     */
    public void doSaveUser() {

        user = this.userService.saveUser(user);
    }





}
