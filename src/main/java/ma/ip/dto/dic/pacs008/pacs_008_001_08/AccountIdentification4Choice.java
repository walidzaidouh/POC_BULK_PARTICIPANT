
package ma.ip.dto.dic.pacs008.pacs_008_001_08;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour AccountIdentification4Choice complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="AccountIdentification4Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="IBAN" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}IBAN2007Identifier"/>
 *         &lt;element name="Othr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}GenericAccountIdentification1"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountIdentification4Choice", propOrder = {
    "iban",
    "othr"
})
public class AccountIdentification4Choice {

    @XmlElement(name = "IBAN")
    protected String iban;
    @XmlElement(name = "Othr")
    protected GenericAccountIdentification1 othr;

    /**
     * Obtient la valeur de la propriété iban.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBAN() {
        return iban;
    }

    /**
     * Définit la valeur de la propriété iban.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBAN(String value) {
        this.iban = value;
    }

    /**
     * Obtient la valeur de la propriété othr.
     * 
     * @return
     *     possible object is
     *     {@link   GenericAccountIdentification1 }
     *     
     */
    public GenericAccountIdentification1 getOthr() {
        return othr;
    }

    /**
     * Définit la valeur de la propriété othr.
     * 
     * @param value
     *     allowed object is
     *     {@link   GenericAccountIdentification1 }
     *     
     */
    public void setOthr(GenericAccountIdentification1 value) {
        this.othr = value;
    }

}
