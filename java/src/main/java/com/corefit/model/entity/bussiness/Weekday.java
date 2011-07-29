package com.corefit.model.entity.business;

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
@Table(name = "WEEKDAY", schema = "public", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID"  }) })
public class Weekday extends GenericDTOBase {

    /**
     * Serialization
     */
    private static final long serialVersionUID = -448097026108013766L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_WEEKDAY")
    private Long ID;

    @Column(name = "DS_DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "weekDay", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Hour.class)
    @OrderBy("ID")
    private Set<Hour> hours;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "ID_USER", insertable = true, updatable = true)
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Lesson.class)
    @JoinColumn(name = "ID_LESSON", insertable = true, updatable = true)
    private Lesson lesson;

    /*************************************************************************/

    @Override
    public Long getID() {
        return ID;
    }

    @Override
    public void setID(Long iD) {
        ID = iD;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Hour> getHours() {
        return hours;
    }

    public void setHours(Set<Hour> hours) {
        this.hours = hours;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

}
