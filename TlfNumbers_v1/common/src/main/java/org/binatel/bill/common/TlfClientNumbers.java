/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.binatel.bill.common;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marina
 */
@Entity
@Table(name = "tlf_client_numbers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TlfClientNumbers.findAll", query = "SELECT t FROM TlfClientNumbers t"),
    @NamedQuery(name = "TlfClientNumbers.findById", query = "SELECT t FROM TlfClientNumbers t WHERE t.id = :id"),
    @NamedQuery(name = "TlfClientNumbers.findByContractId", query = "SELECT t FROM TlfClientNumbers t WHERE t.contractId = :contractId"),
    @NamedQuery(name = "TlfClientNumbers.findByDateLink", query = "SELECT t FROM TlfClientNumbers t WHERE t.dateLink = :dateLink"),
    @NamedQuery(name = "TlfClientNumbers.findByDateUnlink", query = "SELECT t FROM TlfClientNumbers t WHERE t.dateUnlink = :dateUnlink")})
public class TlfClientNumbers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "contract_id")
    private Integer contractId;
    @Basic(optional = false)
    @Column(name = "date_link")
    private long dateLink;
    @Basic(optional = false)
    @Column(name = "date_unlink")
    private long dateUnlink;
    @JoinColumn(name = "number_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TlfNumbers numberId;

    public TlfClientNumbers() {
    }

    public TlfClientNumbers(Integer id) {
        this.id = id;
    }

    public TlfClientNumbers(Integer id, long dateLink, long dateUnlink) {
        this.id = id;
        this.dateLink = dateLink;
        this.dateUnlink = dateUnlink;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public long getDateLink() {
        return dateLink;
    }

    public void setDateLink(long dateLink) {
        this.dateLink = dateLink;
    }

    public long getDateUnlink() {
        return dateUnlink;
    }

    public void setDateUnlink(long dateUnlink) {
        this.dateUnlink = dateUnlink;
    }

    public TlfNumbers getNumberId() {
        return numberId;
    }

    public void setNumberId(TlfNumbers numberId) {
        this.numberId = numberId;
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
        if (!(object instanceof TlfClientNumbers)) {
            return false;
        }
        TlfClientNumbers other = (TlfClientNumbers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.binatel.bill.common.TlfClientNumbers[ id=" + id + " ]";
    }
    
}
