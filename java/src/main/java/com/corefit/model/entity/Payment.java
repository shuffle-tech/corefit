package com.corefit.model.entity;

import java.util.Date;

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
@Table(name = "Payment", schema = "public", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID"  }) })
public class Payment extends GenericDTOBase {

    /**
     * Serialization
     */
    private static final long serialVersionUID = 691285021238384287L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID" )
    private Long ID;

    @Column(name = "DT_PAY")
    private Date pay;

    @Column(name = "NR_VALUE_PAYED")
    private Double value;

    @Column(name = "DT_FROM_MONTH")
    private Date fromMonth;

    @Column(name = "DT_TO_MONTH")
    private Date toMonth;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Student.class)
    @JoinColumn(name = "ID_STUDENT", insertable = true, updatable = true)
    private Student student;

    /*************************************************************************/

    @Override
    public Long getID() {
        return ID;
    }

    @Override
    public void setID(Long iD) {
        ID = iD;
    }

    public Date getPay() {
        return pay;
    }

    public void setPay(Date pay) {
        this.pay = pay;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getFromMonth() {
        return fromMonth;
    }

    public void setFromMonth(Date fromMonth) {
        this.fromMonth = fromMonth;
    }

    public Date getToMonth() {
        return toMonth;
    }

    public void setToMonth(Date toMonth) {
        this.toMonth = toMonth;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
