


package ma.ip.dto.dic.pacs008.pacs_008_001_08;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour TaxParty2 complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="TaxParty2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TaxId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}Max35Text" minOccurs="0"/>
 *         &lt;element name="RegnId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}Max35Text" minOccurs="0"/>
 *         &lt;element name="TaxTp" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}Max35Text" minOccurs="0"/>
 *         &lt;element name="Authstn" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}TaxAuthorisation1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxParty2", propOrder = {
    "taxId",
    "regnId",
    "taxTp",
    "authstn"
})
public class TaxParty2 {

    @XmlElement(name = "TaxId")
    protected String taxId;
    @XmlElement(name = "RegnId")
    protected String regnId;
    @XmlElement(name = "TaxTp")
    protected String taxTp;
    @XmlElement(name = "Authstn")
    protected   TaxAuthorisation1 authstn;

    /**
     * Obtient la valeur de la propriété taxId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxId() {
        return taxId;
    }

    /**
     * Définit la valeur de la propriété taxId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxId(String value) {
        this.taxId = value;
    }

    /**
     * Obtient la valeur de la propriété regnId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegnId() {
        return regnId;
    }

    /**
     * Définit la valeur de la propriété regnId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegnId(String value) {
        this.regnId = value;
    }

    /**
     * Obtient la valeur de la propriété taxTp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxTp() {
        return taxTp;
    }

    /**
     * Définit la valeur de la propriété taxTp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxTp(String value) {
        this.taxTp = value;
    }

    /**
     * Obtient la valeur de la propriété authstn.
     * 
     * @return
     *     possible object is
     *     {@link   TaxAuthorisation1 }
     *     
     */
    public   TaxAuthorisation1 getAuthstn() {
        return authstn;
    }

    /**
     * Définit la valeur de la propriété authstn.
     * 
     * @param value
     *     allowed object is
     *     {@link   TaxAuthorisation1 }
     *     
     */
    public void setAuthstn(  TaxAuthorisation1 value) {
        this.authstn = value;
    }

}
