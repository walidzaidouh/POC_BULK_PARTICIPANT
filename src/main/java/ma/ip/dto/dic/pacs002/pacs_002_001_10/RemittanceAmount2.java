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
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour RemittanceAmount2 complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="RemittanceAmount2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DuePyblAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="DscntApldAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}DiscountAmountAndType1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CdtNoteAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="TaxAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}TaxAmountAndType1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AdjstmntAmtAndRsn" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}DocumentAdjustment1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RmtdAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RemittanceAmount2", propOrder = {
    "duePyblAmt",
    "dscntApldAmt",
    "cdtNoteAmt",
    "taxAmt",
    "adjstmntAmtAndRsn",
    "rmtdAmt"
})
public class RemittanceAmount2 {

    @XmlElement(name = "DuePyblAmt")
    protected ActiveOrHistoricCurrencyAndAmount duePyblAmt;
    @XmlElement(name = "DscntApldAmt")
    protected List<DiscountAmountAndType1> dscntApldAmt;
    @XmlElement(name = "CdtNoteAmt")
    protected ActiveOrHistoricCurrencyAndAmount cdtNoteAmt;
    @XmlElement(name = "TaxAmt")
    protected List<TaxAmountAndType1> taxAmt;
    @XmlElement(name = "AdjstmntAmtAndRsn")
    protected List<DocumentAdjustment1> adjstmntAmtAndRsn;
    @XmlElement(name = "RmtdAmt")
    protected ActiveOrHistoricCurrencyAndAmount rmtdAmt;

    /**
     * Obtient la valeur de la propri�t� duePyblAmt.
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getDuePyblAmt() {
        return duePyblAmt;
    }

    /**
     * D�finit la valeur de la propri�t� duePyblAmt.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setDuePyblAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.duePyblAmt = value;
    }

    /**
     * Gets the value of the dscntApldAmt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dscntApldAmt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDscntApldAmt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DiscountAmountAndType1 }
     * 
     * 
     */
    public List<DiscountAmountAndType1> getDscntApldAmt() {
        if (dscntApldAmt == null) {
            dscntApldAmt = new ArrayList<DiscountAmountAndType1>();
        }
        return this.dscntApldAmt;
    }

    /**
     * Obtient la valeur de la propri�t� cdtNoteAmt.
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getCdtNoteAmt() {
        return cdtNoteAmt;
    }

    /**
     * D�finit la valeur de la propri�t� cdtNoteAmt.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setCdtNoteAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.cdtNoteAmt = value;
    }

    /**
     * Gets the value of the taxAmt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxAmt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxAmt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxAmountAndType1 }
     * 
     * 
     */
    public List<TaxAmountAndType1> getTaxAmt() {
        if (taxAmt == null) {
            taxAmt = new ArrayList<TaxAmountAndType1>();
        }
        return this.taxAmt;
    }

    /**
     * Gets the value of the adjstmntAmtAndRsn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adjstmntAmtAndRsn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdjstmntAmtAndRsn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentAdjustment1 }
     * 
     * 
     */
    public List<DocumentAdjustment1> getAdjstmntAmtAndRsn() {
        if (adjstmntAmtAndRsn == null) {
            adjstmntAmtAndRsn = new ArrayList<DocumentAdjustment1>();
        }
        return this.adjstmntAmtAndRsn;
    }

    /**
     * Obtient la valeur de la propri�t� rmtdAmt.
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getRmtdAmt() {
        return rmtdAmt;
    }

    /**
     * D�finit la valeur de la propri�t� rmtdAmt.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setRmtdAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.rmtdAmt = value;
    }

}
