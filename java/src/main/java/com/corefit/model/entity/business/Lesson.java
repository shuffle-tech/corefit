package com.corefit.model.entity.business;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.shuffle.generic.core.dao.GenericDTOBase;

@Entity
@Table(name = "LESSON", schema = "public", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_LESSON" }) })
public class Lesson extends GenericDTOBase {

    /**
     * Serialization
     */
    private static final long serialVersionUID = 6006794061008249661L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_LESSON" )
    private Long ID;

    @Column(name = "IDI_TYPE")
    private int type;

    @Column(name = "IDI_STATUS")
    private int status;

    @Column(name = "IS_DUO")
    private boolean duo;

    @Column(name = "DS_CANCEL_REASON")
    private String cancelReason;

    @Column(name = "DT_CANCELED")
    private Date canceledHour;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Student.class)
    @OrderBy("ID")
    private Set<Student> students;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "ID_USER", insertable = true, updatable = true)
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Weekday.class)
    @JoinColumn(name = "ID_WEEKDAY", insertable = true, updatable = true)
    private Weekday weekDay;

    /*************************************************************************/

    @Override
    public Long getID() {
        return ID;
    }

    @Override
    public void setID(Long iD) {
        ID = iD;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isDuo() {
        return duo;
    }

    public void setDuo(boolean duo) {
        this.duo = duo;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public Date getCanceledHour() {
        return canceledHour;
    }

    public void setCanceledHour(Date canceledHour) {
        this.canceledHour = canceledHour;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Weekday getWeekday() {
        return weekDay;
    }

    public void setWeekday(Weekday weekDay) {
        this.weekDay = weekDay;
    }

}
