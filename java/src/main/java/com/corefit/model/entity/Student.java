package com.corefit.model.entity;

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
@Table(name = "Student", schema = "public", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID"  }) })
public class Student extends GenericDTOBase {

    /**
     * Serialization
     */
    private static final long serialVersionUID = 5376231475534271756L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID" )
    private Long ID;

    @Column(name = "DT_FINALE")
    private Date finale;

    @Column(name = "DT_CREATE")
    private Date create;

    @Column(name = "IS_SUSPENSE")
    private Boolean suspense;

    @Column(name = "NR_LEASSONS")
    private int leassonsForWeek;

    @Column(name = "NR_DISCOUNT")
    private Double discount;

    @Column(name = "IDI_TYPE")
    private int type;

    @Column(name = "DS_NAME")
    private String name;

    @Column(name = "IDI_SEX")
    private int sex;

    @Column(name = "DT_BORN")
    private Date born;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Lesson.class)
    @JoinColumn(name = "ID_LESSON", insertable = true, updatable = true)
    private Lesson lesson;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Address.class)
    @JoinColumn(name = "ID_ADDRESS", insertable = true, updatable = true)
    private Address address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Contact.class)
    @OrderBy("ID")
    private Set<Contact> contacts;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Payment.class)
    @OrderBy("ID")
    private Set<Payment> payments;

    /*************************************************************************/

    @Override
    public Long getID() {
        return ID;
    }

    @Override
    public void setID(Long iD) {
        ID = iD;
    }

    public Date getFinale() {
        return finale;
    }

    public void setFinale(Date finale) {
        this.finale = finale;
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

    public int getLeassonsForWeek() {
        return leassonsForWeek;
    }

    public void setLeassonsForWeek(int leassonsForWeek) {
        this.leassonsForWeek = leassonsForWeek;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

}
