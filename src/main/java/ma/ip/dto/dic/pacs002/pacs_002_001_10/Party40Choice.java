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
 * <p>Classe Java pour Party40Choice complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Party40Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Pty" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}PartyIdentification135"/>
 *         &lt;element name="Agt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}BranchAndFinancialInstitutionIdentification6"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Party40Choice", propOrder = {
    "pty",
    "agt"
})
public class Party40Choice {

    @XmlElement(name = "Pty")
    protected PartyIdentification135 pty;
    @XmlElement(name = "Agt")
    protected BranchAndFinancialInstitutionIdentification6 agt;

    /**
     * Obtient la valeur de la propri�t� pty.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification135 }
     *     
     */
    public PartyIdentification135 getPty() {
        return pty;
    }

    /**
     * D�finit la valeur de la propri�t� pty.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification135 }
     *     
     */
    public void setPty(PartyIdentification135 value) {
        this.pty = value;
    }

    /**
     * Obtient la valeur de la propri�t� agt.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getAgt() {
        return agt;
    }

    /**
     * D�finit la valeur de la propri�t� agt.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.agt = value;
    }

}
