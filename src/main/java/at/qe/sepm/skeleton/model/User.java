package at.qe.sepm.skeleton.model;

import java.io.Serializable;
import at.qe.sepm.skeleton.model.Holiday;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.domain.Persistable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Entity representing users.
 *
 * This class is part of the skeleton project provided for students of the
 * courses "Software Architecture" and "Software Engineering" offered by the
 * University of Innsbruck.
 */
@Entity
public class User implements Persistable<String>, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 200)
    private String username;

    @ManyToOne(optional = false)
    private User createUser;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @ManyToOne(optional = true)
    private User updateUser;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    boolean enabled;
    private String jobTitle;
    private Date lastFlight;
    private Double hoursWorkedWeek;
    private Boolean hasHoliday;
    private Boolean available;
    private int remainingHoliday;


    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "User_UserRole")
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;



    public void addToRoles(){

        Set<UserRole> temp = new HashSet<UserRole>();

        // all users are automatically employees
        temp.add(UserRole.EMPLOYEE);

        //

        if(this.jobTitle.equals("Admin")){
            temp.add(UserRole.ADMIN);
        }

        if(this.jobTitle.equals("Manager")){
            temp.add(UserRole.MANAGER);
        }


        setRoles(temp);

    }

    public int getRemainingHoliday() {
        return remainingHoliday;
    }

    public void setRemainingHoliday(int remainingHoliday) {
        this.remainingHoliday = remainingHoliday;
    }





    public Boolean getAvailable(Boolean breakTime, Boolean calculateHoursWwithNewFlight, Boolean hasHoliday) {

        if((breakTime == true) && (calculateHoursWwithNewFlight == false) && (hasHoliday == false)){return true;}
        return false;
    }

    public Boolean calculateBreak(Date lastFlight, Date currentFlight){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastFlight);
        calendar.add(Calendar.HOUR_OF_DAY, 12);

        if(calendar.getTime().compareTo(currentFlight) < 0){return false;}

        return true;

    }

    public Boolean calculateHoursWwithNewFlight(Double hoursWorkedWeek, Double flightTime){

        if(hoursWorkedWeek + flightTime >= 40){return false;}
        return true;
    }

    public Double getHoursWorkedWeek() { return hoursWorkedWeek; }

    public void setHoursWorkedWeek(Double hoursWorkedWeek) { this.hoursWorkedWeek = hoursWorkedWeek; }

    public Boolean getHasHoliday() { return hasHoliday; }


    /**
     * TODO: correct this setter!
     * @param hasHoliday
     */
    public void setHasHoliday(Boolean hasHoliday) { this.hasHoliday = hasHoliday; }

    public void setLastFlight(Date date){this.lastFlight = date;}

    public Date getLastFlight(){return lastFlight;}

    public String getJobTitle(){return jobTitle;}

    public void setJobTitle(String jobTitle){this.jobTitle = jobTitle;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {

        this.roles = roles;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(User updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return username;
    }

    @Override
    public String getId() {
        return getUsername();
    }

    public void setId(String id) {
        setUsername(id);
    }

    @Override
    public boolean isNew() {
        return (null == createDate);
    }

}
