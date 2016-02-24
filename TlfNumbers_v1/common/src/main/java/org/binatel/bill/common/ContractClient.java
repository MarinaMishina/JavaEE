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
@Table(name = "contract_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContractClient.findAll", query = "SELECT c FROM ContractClient c"),
    @NamedQuery(name = "ContractClient.findById", query = "SELECT c FROM ContractClient c WHERE c.id = :id"),
    @NamedQuery(name = "ContractClient.findByNumber", query = "SELECT c FROM ContractClient c WHERE c.number = :number"),
    @NamedQuery(name = "ContractClient.findByDateBeginTs", query = "SELECT c FROM ContractClient c WHERE c.dateBeginTs = :dateBeginTs"),
    @NamedQuery(name = "ContractClient.findByDateEndTs", query = "SELECT c FROM ContractClient c WHERE c.dateEndTs = :dateEndTs"),
    @NamedQuery(name = "ContractClient.findByBalance", query = "SELECT c FROM ContractClient c WHERE c.balance = :balance"),
    @NamedQuery(name = "ContractClient.findByCredit", query = "SELECT c FROM ContractClient c WHERE c.credit = :credit"),
    @NamedQuery(name = "ContractClient.findByAgentAbonPercent", query = "SELECT c FROM ContractClient c WHERE c.agentAbonPercent = :agentAbonPercent"),
    @NamedQuery(name = "ContractClient.findByAgentTrafPercent", query = "SELECT c FROM ContractClient c WHERE c.agentTrafPercent = :agentTrafPercent"),
    @NamedQuery(name = "ContractClient.findByIsAvans", query = "SELECT c FROM ContractClient c WHERE c.isAvans = :isAvans"),
    @NamedQuery(name = "ContractClient.findByArchive", query = "SELECT c FROM ContractClient c WHERE c.archive = :archive")})
public class ContractClient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "number")
    private String number;
    @Basic(optional = false)
    @Column(name = "date_begin_ts")
    private int dateBeginTs;
    @Column(name = "date_end_ts")
    private Integer dateEndTs;
    @Basic(optional = false)
    @Column(name = "balance")
    private double balance;
    @Basic(optional = false)
    @Column(name = "credit")
    private double credit;
    @Basic(optional = false)
    @Column(name = "agent_abon_percent")
    private int agentAbonPercent;
    @Basic(optional = false)
    @Column(name = "agent_traf_percent")
    private int agentTrafPercent;
    @Basic(optional = false)
    @Column(name = "is_avans")
    private short isAvans;
    @Basic(optional = false)
    @Column(name = "archive")
    private short archive;
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CompanyClient companyId;
    @JoinColumn(name = "tlf_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TlfGroupOper tlfGroupId;
    @JoinColumn(name = "lang_msg", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private LangMsg langMsg;
    @JoinColumn(name = "tarif_in_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TlfTarifClient tarifInId;
    @JoinColumn(name = "tarif_out_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TlfTarifClient tarifOutId;

    public ContractClient() {
    }

    public ContractClient(Integer id) {
        this.id = id;
    }

    public ContractClient(Integer id, String number, int dateBeginTs, double balance, double credit, int agentAbonPercent, int agentTrafPercent, short isAvans, short archive) {
        this.id = id;
        this.number = number;
        this.dateBeginTs = dateBeginTs;
        this.balance = balance;
        this.credit = credit;
        this.agentAbonPercent = agentAbonPercent;
        this.agentTrafPercent = agentTrafPercent;
        this.isAvans = isAvans;
        this.archive = archive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getDateBeginTs() {
        return dateBeginTs;
    }

    public void setDateBeginTs(int dateBeginTs) {
        this.dateBeginTs = dateBeginTs;
    }

    public Integer getDateEndTs() {
        return dateEndTs;
    }

    public void setDateEndTs(Integer dateEndTs) {
        this.dateEndTs = dateEndTs;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getAgentAbonPercent() {
        return agentAbonPercent;
    }

    public void setAgentAbonPercent(int agentAbonPercent) {
        this.agentAbonPercent = agentAbonPercent;
    }

    public int getAgentTrafPercent() {
        return agentTrafPercent;
    }

    public void setAgentTrafPercent(int agentTrafPercent) {
        this.agentTrafPercent = agentTrafPercent;
    }

    public short getIsAvans() {
        return isAvans;
    }

    public void setIsAvans(short isAvans) {
        this.isAvans = isAvans;
    }

    public short getArchive() {
        return archive;
    }

    public void setArchive(short archive) {
        this.archive = archive;
    }

    public CompanyClient getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyClient companyId) {
        this.companyId = companyId;
    }

    public TlfGroupOper getTlfGroupId() {
        return tlfGroupId;
    }

    public void setTlfGroupId(TlfGroupOper tlfGroupId) {
        this.tlfGroupId = tlfGroupId;
    }

    public LangMsg getLangMsg() {
        return langMsg;
    }

    public void setLangMsg(LangMsg langMsg) {
        this.langMsg = langMsg;
    }

    public TlfTarifClient getTarifInId() {
        return tarifInId;
    }

    public void setTarifInId(TlfTarifClient tarifInId) {
        this.tarifInId = tarifInId;
    }

    public TlfTarifClient getTarifOutId() {
        return tarifOutId;
    }

    public void setTarifOutId(TlfTarifClient tarifOutId) {
        this.tarifOutId = tarifOutId;
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
        if (!(object instanceof ContractClient)) {
            return false;
        }
        ContractClient other = (ContractClient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.binatel.bill.common.ContractClient[ id=" + id + " ]";
    }
    
}
