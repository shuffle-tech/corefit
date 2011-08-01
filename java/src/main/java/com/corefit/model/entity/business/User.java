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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.corefit.model.entity.security.Role;

import com.shuffle.generic.core.dao.GenericDTOBase;

@Entity
@Table(name = "USER", schema = "public", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_USER"  }) })
public class User extends GenericDTOBase {

    /**
     * Serialization
     */
    private static final long serialVersionUID = -3097334890079381381L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER" )
    private Long ID;

    @Column(name = "DS_NAME")
    private String name;

    @Column(name = "DS_LOGIN")
    private String login;

    @Column(name = "DS_PASSWORD")
    private String password;

    @Column(name = "DT_CREATE")
    private Date create;

    @Column(name = "IS_SUSPENSE")
    private Boolean suspense;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Contact.class)
    @OrderBy("ID")
    private Set<Contact> contacts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Lesson.class)
    @OrderBy("ID")
    private Set<Lesson> lessons;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Weekday.class)
    @OrderBy("ID")
    private Set<Weekday> weekDays;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Role.class)
    @OrderBy("ID")
    private Set<Role> userRoles;
    /*************************************************************************/

    @Override
    public Long getID() {
        return ID;
    }

    @Override
    public void setID(Long iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Boolean getSuspense() {
        return suspense;
    }

    public void setSuspense(Boolean suspense) {
        this.suspense = suspense;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Set<Weekday> getWeekdays() {
        return weekDays;
    }

    public void setWeekdays(Set<Weekday> weekDays) {
        this.weekDays = weekDays;
    }

    public Set<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<Role> userRoles) {
        this.userRoles = userRoles;
    }
}
