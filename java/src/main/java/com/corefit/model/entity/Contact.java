package com.corefit.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.shuffle.generic.core.dao.GenericDTOBase;

@Entity
@Table(name = "Contact", schema = "public", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID"  }) })
public class Contact extends GenericDTOBase {

    /**
     * Serialization
     */
    private static final long serialVersionUID = 5394892999467140283L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID" )
    private Long ID;

    @Column(name = "IDI_TYPE")
    private int type;

    @Column(name = "DS_DESCRIPTION")
    private String description;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Student.class)
    @JoinColumn(name = "ID_STUDENT", insertable = true, updatable = true)
    private Student student;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "ID_USER", insertable = true, updatable = true)
    private User user;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
