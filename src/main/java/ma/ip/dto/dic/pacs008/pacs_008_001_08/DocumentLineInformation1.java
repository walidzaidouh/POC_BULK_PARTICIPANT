


package ma.ip.dto.dic.pacs008.pacs_008_001_08;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour DocumentLineInformation1 complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="DocumentLineInformation1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}DocumentLineIdentification1" maxOccurs="unbounded"/>
 *         &lt;element name="Desc" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}Max2048Text" minOccurs="0"/>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}RemittanceAmount3" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentLineInformation1", propOrder = {
    "id",
    "desc",
    "amt"
})
public class DocumentLineInformation1 {

    @XmlElement(name = "Id", required = true)
    protected List<DocumentLineIdentification1> id;
    @XmlElement(name = "Desc")
    protected String desc;
    @XmlElement(name = "Amt")
    protected RemittanceAmount3 amt;

    /**
     * Gets the value of the id property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the id property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentLineIdentification1 }
     * 
     * 
     */
    public List<DocumentLineIdentification1> getId() {
        if (id == null) {
            id = new ArrayList<DocumentLineIdentification1>();
        }
        return this.id;
    }

    /**
     * Obtient la valeur de la propriété desc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Définit la valeur de la propriété desc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * Obtient la valeur de la propriété amt.
     * 
     * @return
     *     possible object is
     *     {@link RemittanceAmount3 }
     *     
     */
    public RemittanceAmount3 getAmt() {
        return amt;
    }

    /**
     * Définit la valeur de la propriété amt.
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceAmount3 }
     *     
     */
    public void setAmt(RemittanceAmount3 value) {
        this.amt = value;
    }

}
