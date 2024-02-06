//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2021.09.09 � 02:08:37 PM CEST 
//


package ma.ip.dto.dic.pacs002.pacs_002_001_10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ClearingSystemMemberIdentification2 complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ClearingSystemMemberIdentification2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClrSysId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}ClearingSystemIdentification2Choice" minOccurs="0"/>
 *         &lt;element name="MmbId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}Max35Text"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClearingSystemMemberIdentification2", propOrder = {
    "clrSysId",
    "mmbId"
})
public class ClearingSystemMemberIdentification2 {

    @XmlElement(name = "ClrSysId")
    protected ClearingSystemIdentification2Choice clrSysId;
    @XmlElement(name = "MmbId", required = true)
    protected String mmbId;

    /**
     * Obtient la valeur de la propri�t� clrSysId.
     * 
     * @return
     *     possible object is
     *     {@link ClearingSystemIdentification2Choice }
     *     
     */
    public ClearingSystemIdentification2Choice getClrSysId() {
        return clrSysId;
    }

    /**
     * D�finit la valeur de la propri�t� clrSysId.
     * 
     * @param value
     *     allowed object is
     *     {@link ClearingSystemIdentification2Choice }
     *     
     */
    public void setClrSysId(ClearingSystemIdentification2Choice value) {
        this.clrSysId = value;
    }

    /**
     * Obtient la valeur de la propri�t� mmbId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMmbId() {
        return mmbId;
    }

    /**
     * D�finit la valeur de la propri�t� mmbId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMmbId(String value) {
        this.mmbId = value;
    }

}
