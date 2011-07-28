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
@Table(name = "Address", schema = "public", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID"  }) })
public class Address extends GenericDTOBase {

    /**
     * Serialization
     */
    private static final long serialVersionUID = 5459325762887101179L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID" )
    private Long ID;

    @Column(name = "DS_STREET")
    private String street;

    @Column(name = "DS_NEIGHBORHOOD")
    private String neighborhood;

    @Column(name = "DS_CEP")
    private String cep;

    @Column(name = "DS_CITY")
    private String city;

    @Column(name = "DS_STATE")
    private String state;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Student.class)
    @JoinColumn(name = "ID_STUDENT", insertable = true, updatable = true)    
    private Student student;

    /*************************************************************************/

    @Override
    public Long getID() {
        return this.ID;
    }

    @Override
    public void setID(Long id) {
        this.ID = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
