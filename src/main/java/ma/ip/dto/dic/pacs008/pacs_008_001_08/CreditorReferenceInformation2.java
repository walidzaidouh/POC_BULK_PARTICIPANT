


package ma.ip.dto.dic.pacs008.pacs_008_001_08;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour CreditorReferenceInformation2 complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="CreditorReferenceInformation2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}CreditorReferenceType2" minOccurs="0"/>
 *         &lt;element name="Ref" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}Max35Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditorReferenceInformation2", propOrder = {
    "tp",
    "ref"
})
public class CreditorReferenceInformation2 {

    @XmlElement(name = "Tp")
    protected CreditorReferenceType2 tp;
    @XmlElement(name = "Ref")
    protected String ref;

    /**
     * Obtient la valeur de la propriété tp.
     * 
     * @return
     *     possible object is
     *     {@link CreditorReferenceType2 }
     *     
     */
    public CreditorReferenceType2 getTp() {
        return tp;
    }

    /**
     * Définit la valeur de la propriété tp.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditorReferenceType2 }
     *     
     */
    public void setTp(CreditorReferenceType2 value) {
        this.tp = value;
    }

    /**
     * Obtient la valeur de la propriété ref.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRef() {
        return ref;
    }

    /**
     * Définit la valeur de la propriété ref.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRef(String value) {
        this.ref = value;
    }

}
