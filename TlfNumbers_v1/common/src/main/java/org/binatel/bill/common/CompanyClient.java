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
@Table(name = "company_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompanyClient.findAll", query = "SELECT c FROM CompanyClient c"),
    @NamedQuery(name = "CompanyClient.findById", query = "SELECT c FROM CompanyClient c WHERE c.id = :id"),
    @NamedQuery(name = "CompanyClient.findByName", query = "SELECT c FROM CompanyClient c WHERE c.name = :name"),
    @NamedQuery(name = "CompanyClient.findByShortName", query = "SELECT c FROM CompanyClient c WHERE c.shortName = :shortName"),
    @NamedQuery(name = "CompanyClient.findByInn", query = "SELECT c FROM CompanyClient c WHERE c.inn = :inn"),
    @NamedQuery(name = "CompanyClient.findByKpp", query = "SELECT c FROM CompanyClient c WHERE c.kpp = :kpp"),
    @NamedQuery(name = "CompanyClient.findByOgrn", query = "SELECT c FROM CompanyClient c WHERE c.ogrn = :ogrn"),
    @NamedQuery(name = "CompanyClient.findByUrAddress", query = "SELECT c FROM CompanyClient c WHERE c.urAddress = :urAddress"),
    @NamedQuery(name = "CompanyClient.findByFactAddress", query = "SELECT c FROM CompanyClient c WHERE c.factAddress = :factAddress"),
    @NamedQuery(name = "CompanyClient.findByBankName", query = "SELECT c FROM CompanyClient c WHERE c.bankName = :bankName"),
    @NamedQuery(name = "CompanyClient.findByBankAccount", query = "SELECT c FROM CompanyClient c WHERE c.bankAccount = :bankAccount"),
    @NamedQuery(name = "CompanyClient.findByBankCorrAccount", query = "SELECT c FROM CompanyClient c WHERE c.bankCorrAccount = :bankCorrAccount"),
    @NamedQuery(name = "CompanyClient.findByBankBIK", query = "SELECT c FROM CompanyClient c WHERE c.bankBIK = :bankBIK"),
    @NamedQuery(name = "CompanyClient.findByFinPhone", query = "SELECT c FROM CompanyClient c WHERE c.finPhone = :finPhone"),
    @NamedQuery(name = "CompanyClient.findByTechPhone", query = "SELECT c FROM CompanyClient c WHERE c.techPhone = :techPhone"),
    @NamedQuery(name = "CompanyClient.findByFinContactPerson", query = "SELECT c FROM CompanyClient c WHERE c.finContactPerson = :finContactPerson"),
    @NamedQuery(name = "CompanyClient.findByTechContactPerson", query = "SELECT c FROM CompanyClient c WHERE c.techContactPerson = :techContactPerson"),
    @NamedQuery(name = "CompanyClient.findByEmail", query = "SELECT c FROM CompanyClient c WHERE c.email = :email"),
    @NamedQuery(name = "CompanyClient.findByFinEmail", query = "SELECT c FROM CompanyClient c WHERE c.finEmail = :finEmail"),
    @NamedQuery(name = "CompanyClient.findByTechEmail", query = "SELECT c FROM CompanyClient c WHERE c.techEmail = :techEmail"),
    @NamedQuery(name = "CompanyClient.findByLogin", query = "SELECT c FROM CompanyClient c WHERE c.login = :login"),
    @NamedQuery(name = "CompanyClient.findByPassword", query = "SELECT c FROM CompanyClient c WHERE c.password = :password"),
    @NamedQuery(name = "CompanyClient.findByArchive", query = "SELECT c FROM CompanyClient c WHERE c.archive = :archive")})
public class CompanyClient implements Serializable {
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
    @Column(name = "short_name")
    private String shortName;
    @Basic(optional = false)
    @Column(name = "inn")
    private String inn;
    @Basic(optional = false)
    @Column(name = "kpp")
    private String kpp;
    @Basic(optional = false)
    @Column(name = "OGRN")
    private String ogrn;
    @Basic(optional = false)
    @Column(name = "ur_address")
    private String urAddress;
    @Basic(optional = false)
    @Column(name = "fact_address")
    private String factAddress;
    @Basic(optional = false)
    @Column(name = "bank_name")
    private String bankName;
    @Basic(optional = false)
    @Column(name = "bank_account")
    private String bankAccount;
    @Basic(optional = false)
    @Column(name = "bank_corr_account")
    private String bankCorrAccount;
    @Basic(optional = false)
    @Column(name = "bank_BIK")
    private String bankBIK;
    @Basic(optional = false)
    @Column(name = "fin_phone")
    private String finPhone;
    @Basic(optional = false)
    @Column(name = "tech_phone")
    private String techPhone;
    @Column(name = "fin_contact_person")
    private String finContactPerson;
    @Column(name = "tech_contact_person")
    private String techContactPerson;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "fin_email")
    private String finEmail;
    @Column(name = "tech_email")
    private String techEmail;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "archive")
    private short archive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId", fetch = FetchType.LAZY)
    private List<ContractClient> contractClientList;

    public CompanyClient() {
    }

    public CompanyClient(Integer id) {
        this.id = id;
    }

    public CompanyClient(Integer id, String name, String shortName, String inn, String kpp, String ogrn, String urAddress, String factAddress, String bankName, String bankAccount, String bankCorrAccount, String bankBIK, String finPhone, String techPhone, String email, String login, String password, short archive) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.inn = inn;
        this.kpp = kpp;
        this.ogrn = ogrn;
        this.urAddress = urAddress;
        this.factAddress = factAddress;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.bankCorrAccount = bankCorrAccount;
        this.bankBIK = bankBIK;
        this.finPhone = finPhone;
        this.techPhone = techPhone;
        this.email = email;
        this.login = login;
        this.password = password;
        this.archive = archive;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getUrAddress() {
        return urAddress;
    }

    public void setUrAddress(String urAddress) {
        this.urAddress = urAddress;
    }

    public String getFactAddress() {
        return factAddress;
    }

    public void setFactAddress(String factAddress) {
        this.factAddress = factAddress;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankCorrAccount() {
        return bankCorrAccount;
    }

    public void setBankCorrAccount(String bankCorrAccount) {
        this.bankCorrAccount = bankCorrAccount;
    }

    public String getBankBIK() {
        return bankBIK;
    }

    public void setBankBIK(String bankBIK) {
        this.bankBIK = bankBIK;
    }

    public String getFinPhone() {
        return finPhone;
    }

    public void setFinPhone(String finPhone) {
        this.finPhone = finPhone;
    }

    public String getTechPhone() {
        return techPhone;
    }

    public void setTechPhone(String techPhone) {
        this.techPhone = techPhone;
    }

    public String getFinContactPerson() {
        return finContactPerson;
    }

    public void setFinContactPerson(String finContactPerson) {
        this.finContactPerson = finContactPerson;
    }

    public String getTechContactPerson() {
        return techContactPerson;
    }

    public void setTechContactPerson(String techContactPerson) {
        this.techContactPerson = techContactPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFinEmail() {
        return finEmail;
    }

    public void setFinEmail(String finEmail) {
        this.finEmail = finEmail;
    }

    public String getTechEmail() {
        return techEmail;
    }

    public void setTechEmail(String techEmail) {
        this.techEmail = techEmail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getArchive() {
        return archive;
    }

    public void setArchive(short archive) {
        this.archive = archive;
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
        if (!(object instanceof CompanyClient)) {
            return false;
        }
        CompanyClient other = (CompanyClient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.binatel.bill.common.CompanyClient[ id=" + id + " ]";
    }
    
}
