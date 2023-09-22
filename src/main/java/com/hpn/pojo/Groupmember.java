/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author defaultuser0
 */
@Entity
@Table(name = "groupmember")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupmember.findAll", query = "SELECT g FROM Groupmember g"),
    @NamedQuery(name = "Groupmember.findById", query = "SELECT g FROM Groupmember g WHERE g.id = :id"),
    @NamedQuery(name = "Groupmember.findByRoleingroup", query = "SELECT g FROM Groupmember g WHERE g.roleingroup = :roleingroup")})
public class Groupmember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "roleingroup")
    private String roleingroup;
    @JoinColumn(name = "teamgroup_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Teamgroup teamgroupId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Groupmember() {
    }

    public Groupmember(Integer id) {
        this.id = id;
    }

    public Groupmember(Integer id, String roleingroup) {
        this.id = id;
        this.roleingroup = roleingroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleingroup() {
        return roleingroup;
    }

    public void setRoleingroup(String roleingroup) {
        this.roleingroup = roleingroup;
    }

    public Teamgroup getTeamgroupId() {
        return teamgroupId;
    }

    public void setTeamgroupId(Teamgroup teamgroupId) {
        this.teamgroupId = teamgroupId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupmember)) {
            return false;
        }
        Groupmember other = (Groupmember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hpn.pojo.Groupmember[ id=" + id + " ]";
    }
    
}
