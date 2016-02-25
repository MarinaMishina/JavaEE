
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
@Table(name = "tlf_numbers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TlfNumbers.findAll", query = "SELECT t FROM TlfNumbers t"),
    @NamedQuery(name = "TlfNumbers.findById", query = "SELECT t FROM TlfNumbers t WHERE t.id = :id"),
    @NamedQuery(name = "TlfNumbers.findByE164Number", query = "SELECT t FROM TlfNumbers t WHERE t.e164Number = :e164Number"),
    @NamedQuery(name = "TlfNumbers.findByCode", query = "SELECT t FROM TlfNumbers t WHERE t.code = :code"),
    @NamedQuery(name = "TlfNumbers.findByTelNum1", query = "SELECT t FROM TlfNumbers t WHERE t.telNum1 = :telNum1"),
    @NamedQuery(name = "TlfNumbers.findByTelNum2", query = "SELECT t FROM TlfNumbers t WHERE t.telNum2 = :telNum2"),
    @NamedQuery(name = "TlfNumbers.findByTelNum3", query = "SELECT t FROM TlfNumbers t WHERE t.telNum3 = :telNum3"),
    @NamedQuery(name = "TlfNumbers.findByPriceNumber", query = "SELECT t FROM TlfNumbers t WHERE t.priceNumber = :priceNumber"),
    @NamedQuery(name = "TlfNumbers.findByMonthPriceNumber", query = "SELECT t FROM TlfNumbers t WHERE t.monthPriceNumber = :monthPriceNumber")})
public class TlfNumbers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "e164_number")
    private String e164Number;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "tel_num1")
    private String telNum1;
    @Basic(optional = false)
    @Column(name = "tel_num2")
    private String telNum2;
    @Basic(optional = false)
    @Column(name = "tel_num3")
    private String telNum3;
    @Basic(optional = false)
    @Column(name = "price_number")
    private double priceNumber;
    @Basic(optional = false)
    @Column(name = "month_price_number")
    private double monthPriceNumber;
    @OneToMany(mappedBy = "numberId", fetch = FetchType.LAZY)
    private List<TlfClientNumbers> tlfClientNumbersList;

    public TlfNumbers() {
    }

    public TlfNumbers(Integer id) {
        this.id = id;
    }

    public TlfNumbers(Integer id, String e164Number, String code, String telNum1, String telNum2, String telNum3, double priceNumber, double monthPriceNumber) {
        this.id = id;
        this.e164Number = e164Number;
        this.code = code;
        this.telNum1 = telNum1;
        this.telNum2 = telNum2;
        this.telNum3 = telNum3;
        this.priceNumber = priceNumber;
        this.monthPriceNumber = monthPriceNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getE164Number() {
        return e164Number;
    }

    public void setE164Number(String e164Number) {
        this.e164Number = e164Number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTelNum1() {
        return telNum1;
    }

    public void setTelNum1(String telNum1) {
        this.telNum1 = telNum1;
    }

    public String getTelNum2() {
        return telNum2;
    }

    public void setTelNum2(String telNum2) {
        this.telNum2 = telNum2;
    }

    public String getTelNum3() {
        return telNum3;
    }

    public void setTelNum3(String telNum3) {
        this.telNum3 = telNum3;
    }

    public double getPriceNumber() {
        return priceNumber;
    }

    public void setPriceNumber(double priceNumber) {
        this.priceNumber = priceNumber;
    }

    public double getMonthPriceNumber() {
        return monthPriceNumber;
    }

    public void setMonthPriceNumber(double monthPriceNumber) {
        this.monthPriceNumber = monthPriceNumber;
    }

    @XmlTransient
    public List<TlfClientNumbers> getTlfClientNumbersList() {
        return tlfClientNumbersList;
    }

    public void setTlfClientNumbersList(List<TlfClientNumbers> tlfClientNumbersList) {
        this.tlfClientNumbersList = tlfClientNumbersList;
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
        if (!(object instanceof TlfNumbers)) {
            return false;
        }
        TlfNumbers other = (TlfNumbers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.binatel.bill.common.TlfNumbers[ id=" + id + " ]";
    }
    
}
