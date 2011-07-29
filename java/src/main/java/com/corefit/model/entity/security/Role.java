package com.corefit.model.entity.security;

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

import com.corefit.model.entity.business.User;

import com.shuffle.generic.core.dao.GenericDTOBase;

@Entity
@Table(name = "USER_ROLE", schema = "public", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID"  }) })
public class Role extends GenericDTOBase {

    /**
     * Serialization
     */
    private static final long serialVersionUID = -2934455521503134223L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ROLE")
    private Long ID;

    @Column(name = "DS_ROLE")
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
