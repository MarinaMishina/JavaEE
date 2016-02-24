/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.binatel.bill.common;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "lang_msg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LangMsg.findAll", query = "SELECT l FROM LangMsg l"),
    @NamedQuery(name = "LangMsg.findById", query = "SELECT l FROM LangMsg l WHERE l.id = :id"),
    @NamedQuery(name = "LangMsg.findByLang", query = "SELECT l FROM LangMsg l WHERE l.lang = :lang"),
    @NamedQuery(name = "LangMsg.findByLangCode", query = "SELECT l FROM LangMsg l WHERE l.langCode = :langCode")})
public class LangMsg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "lang")
    private String lang;
    @Basic(optional = false)
    @Column(name = "lang_code")
    private short langCode;
    @OneToMany(mappedBy = "langMsg", fetch = FetchType.LAZY)
    private List<ContractClient> contractClientList;

    public LangMsg() {
    }

    public LangMsg(Integer id) {
        this.id = id;
    }

    public LangMsg(Integer id, String lang, short langCode) {
        this.id = id;
        this.lang = lang;
        this.langCode = langCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public short getLangCode() {
        return langCode;
    }

    public void setLangCode(short langCode) {
        this.langCode = langCode;
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
        if (!(object instanceof LangMsg)) {
            return false;
        }
        LangMsg other = (LangMsg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.binatel.bill.common.LangMsg[ id=" + id + " ]";
    }
    
}
