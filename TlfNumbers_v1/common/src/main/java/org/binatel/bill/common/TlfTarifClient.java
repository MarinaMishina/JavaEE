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
@Table(name = "tlf_tarif_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TlfTarifClient.findAll", query = "SELECT t FROM TlfTarifClient t"),
    @NamedQuery(name = "TlfTarifClient.findById", query = "SELECT t FROM TlfTarifClient t WHERE t.id = :id"),
    @NamedQuery(name = "TlfTarifClient.findByName", query = "SELECT t FROM TlfTarifClient t WHERE t.name = :name"),
    @NamedQuery(name = "TlfTarifClient.findByDescr", query = "SELECT t FROM TlfTarifClient t WHERE t.descr = :descr")})
public class TlfTarifClient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "descr")
    private String descr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarifInId", fetch = FetchType.LAZY)
    private List<ContractClient> contractClientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarifOutId", fetch = FetchType.LAZY)
    private List<ContractClient> contractClientList1;

    public TlfTarifClient() {
    }

    public TlfTarifClient(Integer id) {
        this.id = id;
    }

    public TlfTarifClient(Integer id, String name, String descr) {
        this.id = id;
        this.name = name;
        this.descr = descr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @XmlTransient
    public List<ContractClient> getContractClientList() {
        return contractClientList;
    }

    public void setContractClientList(List<ContractClient> contractClientList) {
        this.contractClientList = contractClientList;
    }

    @XmlTransient
    public List<ContractClient> getContractClientList1() {
        return contractClientList1;
    }

    public void setContractClientList1(List<ContractClient> contractClientList1) {
        this.contractClientList1 = contractClientList1;
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
        if (!(object instanceof TlfTarifClient)) {
            return false;
        }
        TlfTarifClient other = (TlfTarifClient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.binatel.bill.common.TlfTarifClient[ id=" + id + " ]";
    }
    
}
