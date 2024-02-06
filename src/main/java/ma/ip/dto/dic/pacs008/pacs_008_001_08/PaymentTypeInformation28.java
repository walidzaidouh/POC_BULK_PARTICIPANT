


package ma.ip.dto.dic.pacs008.pacs_008_001_08;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour PaymentTypeInformation28 complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="PaymentTypeInformation28">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InstrPrty" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}Priority2Code" minOccurs="0"/>
 *         &lt;element name="ClrChanl" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}ClearingChannel2Code" minOccurs="0"/>
 *         &lt;element name="SvcLvl" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}ServiceLevel8Choice" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LclInstrm" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}LocalInstrument2Choice" minOccurs="0"/>
 *         &lt;element name="CtgyPurp" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}CategoryPurpose1Choice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTypeInformation28", propOrder = {
    "instrPrty",
    "clrChanl",
    "svcLvl",
    "lclInstrm",
    "ctgyPurp"
})
public class PaymentTypeInformation28 {

    @XmlElement(name = "InstrPrty")
    protected   Priority2Code instrPrty;
    @XmlElement(name = "ClrChanl")
    protected   ClearingChannel2Code clrChanl;
    @XmlElement(name = "SvcLvl")
    protected List<  ServiceLevel8Choice> svcLvl;
    @XmlElement(name = "LclInstrm")
    protected   LocalInstrument2Choice lclInstrm;
    @XmlElement(name = "CtgyPurp")
    protected   CategoryPurpose1Choice ctgyPurp;

    /**
     * Obtient la valeur de la propriété instrPrty.
     * 
     * @return
     *     possible object is
     *     {@link   Priority2Code }
     *     
     */
    public   Priority2Code getInstrPrty() {
        return instrPrty;
    }

    /**
     * Définit la valeur de la propriété instrPrty.
     * 
     * @param value
     *     allowed object is
     *     {@link   Priority2Code }
     *     
     */
    public void setInstrPrty(  Priority2Code value) {
        this.instrPrty = value;
    }

    /**
     * Obtient la valeur de la propriété clrChanl.
     * 
     * @return
     *     possible object is
     *     {@link   ClearingChannel2Code }
     *     
     */
    public   ClearingChannel2Code getClrChanl() {
        return clrChanl;
    }

    /**
     * Définit la valeur de la propriété clrChanl.
     * 
     * @param value
     *     allowed object is
     *     {@link   ClearingChannel2Code }
     *     
     */
    public void setClrChanl(  ClearingChannel2Code value) {
        this.clrChanl = value;
    }

    /**
     * Gets the value of the svcLvl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the svcLvl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSvcLvl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link   ServiceLevel8Choice }
     * 
     * 
     */
    public List<  ServiceLevel8Choice> getSvcLvl() {
        if (svcLvl == null) {
            svcLvl = new ArrayList<  ServiceLevel8Choice>();
        }
        return this.svcLvl;
    }

    /**
     * Obtient la valeur de la propriété lclInstrm.
     * 
     * @return
     *     possible object is
     *     {@link   LocalInstrument2Choice }
     *     
     */
    public   LocalInstrument2Choice getLclInstrm() {
        return lclInstrm;
    }

    /**
     * Définit la valeur de la propriété lclInstrm.
     * 
     * @param value
     *     allowed object is
     *     {@link   LocalInstrument2Choice }
     *     
     */
    public void setLclInstrm(  LocalInstrument2Choice value) {
        this.lclInstrm = value;
    }

    /**
     * Obtient la valeur de la propriété ctgyPurp.
     * 
     * @return
     *     possible object is
     *     {@link   CategoryPurpose1Choice }
     *     
     */
    public   CategoryPurpose1Choice getCtgyPurp() {
        return ctgyPurp;
    }

    /**
     * Définit la valeur de la propriété ctgyPurp.
     * 
     * @param value
     *     allowed object is
     *     {@link   CategoryPurpose1Choice }
     *     
     */
    public void setCtgyPurp(CategoryPurpose1Choice value) {
        this.ctgyPurp = value;
    }

}
