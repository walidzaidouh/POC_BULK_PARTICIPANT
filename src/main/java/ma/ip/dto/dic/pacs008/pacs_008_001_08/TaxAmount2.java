


package ma.ip.dto.dic.pacs008.pacs_008_001_08;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour TaxAmount2 complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="TaxAmount2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Rate" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}PercentageRate" minOccurs="0"/>
 *         &lt;element name="TaxblBaseAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="TtlAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="Dtls" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}TaxRecordDetails2" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxAmount2", propOrder = {
    "rate",
    "taxblBaseAmt",
    "ttlAmt",
    "dtls"
})
public class TaxAmount2 {

    @XmlElement(name = "Rate")
    protected BigDecimal rate;
    @XmlElement(name = "TaxblBaseAmt")
    protected   ActiveOrHistoricCurrencyAndAmount taxblBaseAmt;
    @XmlElement(name = "TtlAmt")
    protected   ActiveOrHistoricCurrencyAndAmount ttlAmt;
    @XmlElement(name = "Dtls")
    protected List<  TaxRecordDetails2> dtls;

    /**
     * Obtient la valeur de la propriété rate.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * Définit la valeur de la propriété rate.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRate(BigDecimal value) {
        this.rate = value;
    }

    /**
     * Obtient la valeur de la propriété taxblBaseAmt.
     * 
     * @return
     *     possible object is
     *     {@link   ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public   ActiveOrHistoricCurrencyAndAmount getTaxblBaseAmt() {
        return taxblBaseAmt;
    }

    /**
     * Définit la valeur de la propriété taxblBaseAmt.
     * 
     * @param value
     *     allowed object is
     *     {@link   ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setTaxblBaseAmt(  ActiveOrHistoricCurrencyAndAmount value) {
        this.taxblBaseAmt = value;
    }

    /**
     * Obtient la valeur de la propriété ttlAmt.
     * 
     * @return
     *     possible object is
     *     {@link   ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public   ActiveOrHistoricCurrencyAndAmount getTtlAmt() {
        return ttlAmt;
    }

    /**
     * Définit la valeur de la propriété ttlAmt.
     * 
     * @param value
     *     allowed object is
     *     {@link   ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setTtlAmt(  ActiveOrHistoricCurrencyAndAmount value) {
        this.ttlAmt = value;
    }

    /**
     * Gets the value of the dtls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dtls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDtls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link   TaxRecordDetails2 }
     * 
     * 
     */
    public List<TaxRecordDetails2> getDtls() {
        if (dtls == null) {
            dtls = new ArrayList<TaxRecordDetails2>();
        }
        return this.dtls;
    }

}
