package com.corefit.model.entity.business;

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
@Table(name = "HOUR", schema = "public", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID"  }) })
public class Hour extends GenericDTOBase {

    /**
     * Serialization
     */
    private static final long serialVersionUID = -2934455521503134223L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_HOUR")
    private Long ID;

    @Column(name = "HR_INITIAL")
    private String initial;

    @Column(name = "HR_FINALE")
    private String finale;

    @Column(name = "IDI_STATUS")
    private int status;

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

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getFinale() {
        return finale;
    }

    public void setFinale(String finale) {
        this.finale = finale;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Weekday getWeekday() {
        return weekDay;
    }

    public void setWeekday(Weekday weekDay) {
        this.weekDay = weekDay;
    }

}
