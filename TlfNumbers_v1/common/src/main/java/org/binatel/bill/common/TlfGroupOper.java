/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.binatel.bill.common;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marina
 */
@Entity
@Table(name = "tlf_group_oper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TlfGroupOper.findAll", query = "SELECT t FROM TlfGroupOper t"),
    @NamedQuery(name = "TlfGroupOper.findById", query = "SELECT t FROM TlfGroupOper t WHERE t.id = :id"),
    @NamedQuery(name = "TlfGroupOper.findByGroupName", query = "SELECT t FROM TlfGroupOper t WHERE t.groupName = :groupName"),
    @NamedQuery(name = "TlfGroupOper.findByAllowLoss", query = "SELECT t FROM TlfGroupOper t WHERE t.allowLoss = :allowLoss"),
    @NamedQuery(name = "TlfGroupOper.findByDescription", query = "SELECT t FROM TlfGroupOper t WHERE t.description = :description")})
public class TlfGroupOper implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "group_name")
    private String groupName;
    @Basic(optional = false)
    @Column(name = "allow_loss")
    private double allowLoss;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tlfGroupId", fetch = FetchType.LAZY)
    private List<ContractClient> contractClientList;

    public TlfGroupOper() {
    }

    public TlfGroupOper(Integer id) {
        this.id = id;
    }

    public TlfGroupOper(Integer id, String groupName, double allowLoss) {
        this.id = id;
        this.groupName = groupName;
        this.allowLoss = allowLoss;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public double getAllowLoss() {
        return allowLoss;
    }

    public void setAllowLoss(double allowLoss) {
        this.allowLoss = allowLoss;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<ContractClient> getContractClientList() {
        return contractClientList;
    }

    public void setContractClientList(List<ContractClient> contractClientList) {
        this.contractClientList = contractClientList;
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
        if (!(object instanceof TlfGroupOper)) {
            return false;
        }
        TlfGroupOper other = (TlfGroupOper) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.binatel.bill.common.TlfGroupOper[ id=" + id + " ]";
    }
    
}
