package at.qe.sepm.skeleton.model;

import at.qe.sepm.skeleton.model.User;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import org.springframework.data.domain.Persistable;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.Objects;
import javax.persistence.GenerationType;
import java.text.SimpleDateFormat;
import java.text.ParseException;


/**
 * Entity of a class repersenting the holiday of a user
 */


@Entity
public class Holiday implements Persistable<String>, Serializable{


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long holidayId;


    private String username;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    private String holidayFrom;
    private String holidayUntil;
    private int holidayDays;



    @ManyToOne(optional = true)
    private User updateUser;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;


    public int getHolidayDays(){return holidayDays;}

    public int setHolidayDays(String holidayFrom, String holidayUntil)throws ParseException{

        Date from = new SimpleDateFormat("dd/MM/YYYY").parse(holidayFrom);
        Date until = new SimpleDateFormat("dd/MM/YYYY").parse(holidayUntil);

        long diff = until.getTime() - from.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);

        this.holidayDays = (int)diffDays;
        return getHolidayDays();
    }




    public String getHolidayId() {
        return holidayId.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Holiday() {

    }

    public void setHolidayId(Long holidayId) {
        this.holidayId = holidayId;
    }

    public String getHolidayFrom() { return holidayFrom; }

    public void setHolidayFrom(String holidayFrom) { this.holidayFrom = holidayFrom; }

    public String getHolidayUntil() { return holidayUntil; }

    public void setHolidayUntil(String holidayUntil) { this.holidayUntil = holidayUntil; }

    @Override
    public String getId() {
        return getHolidayId().toString();
    }

    public void setId(String id) {
        setHolidayId(Long.parseLong(id));
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean isNew() {
        return (null == createDate);
    }





    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.holidayId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Holiday)) {
            return false;
        }
        final Holiday other = (Holiday) obj;
        if (!Objects.equals(this.holidayId, other.holidayId)) {
            return false;
        }
        return true;
    }


}