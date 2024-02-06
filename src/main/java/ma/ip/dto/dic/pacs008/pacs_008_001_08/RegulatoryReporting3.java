


package ma.ip.dto.dic.pacs008.pacs_008_001_08;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour RegulatoryReporting3 complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="RegulatoryReporting3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DbtCdtRptgInd" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}RegulatoryReportingType1Code" minOccurs="0"/>
 *         &lt;element name="Authrty" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}RegulatoryAuthority2" minOccurs="0"/>
 *         &lt;element name="Dtls" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}StructuredRegulatoryReporting3" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegulatoryReporting3", propOrder = {
    "dbtCdtRptgInd",
    "authrty",
    "dtls"
})
public class RegulatoryReporting3 {

    @XmlElement(name = "DbtCdtRptgInd")
    protected RegulatoryReportingType1Code dbtCdtRptgInd;
    @XmlElement(name = "Authrty")
    protected RegulatoryAuthority2 authrty;
    @XmlElement(name = "Dtls")
    protected List<StructuredRegulatoryReporting3> dtls;

    /**
     * Obtient la valeur de la propriété dbtCdtRptgInd.
     * 
     * @return
     *     possible object is
     *     {@link RegulatoryReportingType1Code }
     *     
     */
    public RegulatoryReportingType1Code getDbtCdtRptgInd() {
        return dbtCdtRptgInd;
    }

    /**
     * Définit la valeur de la propriété dbtCdtRptgInd.
     * 
     * @param value
     *     allowed object is
     *     {@link RegulatoryReportingType1Code }
     *     
     */
    public void setDbtCdtRptgInd(RegulatoryReportingType1Code value) {
        this.dbtCdtRptgInd = value;
    }

    /**
     * Obtient la valeur de la propriété authrty.
     * 
     * @return
     *     possible object is
     *     {@link RegulatoryAuthority2 }
     *     
     */
    public RegulatoryAuthority2 getAuthrty() {
        return authrty;
    }

    /**
     * Définit la valeur de la propriété authrty.
     * 
     * @param value
     *     allowed object is
     *     {@link RegulatoryAuthority2 }
     *     
     */
    public void setAuthrty(RegulatoryAuthority2 value) {
        this.authrty = value;
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
     * {@link StructuredRegulatoryReporting3 }
     * 
     * 
     */
    public List<StructuredRegulatoryReporting3> getDtls() {
        if (dtls == null) {
            dtls = new ArrayList<StructuredRegulatoryReporting3>();
        }
        return this.dtls;
    }

}
