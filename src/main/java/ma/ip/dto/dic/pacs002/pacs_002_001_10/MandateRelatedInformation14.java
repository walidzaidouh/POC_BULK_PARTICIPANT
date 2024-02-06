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
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour MandateRelatedInformation14 complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="MandateRelatedInformation14">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MndtId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}Max35Text" minOccurs="0"/>
 *         &lt;element name="DtOfSgntr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}ISODate" minOccurs="0"/>
 *         &lt;element name="AmdmntInd" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}TrueFalseIndicator" minOccurs="0"/>
 *         &lt;element name="AmdmntInfDtls" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}AmendmentInformationDetails13" minOccurs="0"/>
 *         &lt;element name="ElctrncSgntr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}Max1025Text" minOccurs="0"/>
 *         &lt;element name="FrstColltnDt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}ISODate" minOccurs="0"/>
 *         &lt;element name="FnlColltnDt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}ISODate" minOccurs="0"/>
 *         &lt;element name="Frqcy" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}Frequency36Choice" minOccurs="0"/>
 *         &lt;element name="Rsn" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}MandateSetupReason1Choice" minOccurs="0"/>
 *         &lt;element name="TrckgDays" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}Exact2NumericText" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MandateRelatedInformation14", propOrder = {
    "mndtId",
    "dtOfSgntr",
    "amdmntInd",
    "amdmntInfDtls",
    "elctrncSgntr",
    "frstColltnDt",
    "fnlColltnDt",
    "frqcy",
    "rsn",
    "trckgDays"
})
public class MandateRelatedInformation14 {

    @XmlElement(name = "MndtId")
    protected String mndtId;
    @XmlElement(name = "DtOfSgntr")
    protected XMLGregorianCalendar dtOfSgntr;
    @XmlElement(name = "AmdmntInd")
    protected Boolean amdmntInd;
    @XmlElement(name = "AmdmntInfDtls")
    protected AmendmentInformationDetails13 amdmntInfDtls;
    @XmlElement(name = "ElctrncSgntr")
    protected String elctrncSgntr;
    @XmlElement(name = "FrstColltnDt")
    protected XMLGregorianCalendar frstColltnDt;
    @XmlElement(name = "FnlColltnDt")
    protected XMLGregorianCalendar fnlColltnDt;
    @XmlElement(name = "Frqcy")
    protected Frequency36Choice frqcy;
    @XmlElement(name = "Rsn")
    protected MandateSetupReason1Choice rsn;
    @XmlElement(name = "TrckgDays")
    protected String trckgDays;

    /**
     * Obtient la valeur de la propri�t� mndtId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMndtId() {
        return mndtId;
    }

    /**
     * D�finit la valeur de la propri�t� mndtId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMndtId(String value) {
        this.mndtId = value;
    }

    /**
     * Obtient la valeur de la propri�t� dtOfSgntr.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtOfSgntr() {
        return dtOfSgntr;
    }

    /**
     * D�finit la valeur de la propri�t� dtOfSgntr.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtOfSgntr(XMLGregorianCalendar value) {
        this.dtOfSgntr = value;
    }

    /**
     * Obtient la valeur de la propri�t� amdmntInd.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAmdmntInd() {
        return amdmntInd;
    }

    /**
     * D�finit la valeur de la propri�t� amdmntInd.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAmdmntInd(Boolean value) {
        this.amdmntInd = value;
    }

    /**
     * Obtient la valeur de la propri�t� amdmntInfDtls.
     * 
     * @return
     *     possible object is
     *     {@link AmendmentInformationDetails13 }
     *     
     */
    public AmendmentInformationDetails13 getAmdmntInfDtls() {
        return amdmntInfDtls;
    }

    /**
     * D�finit la valeur de la propri�t� amdmntInfDtls.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendmentInformationDetails13 }
     *     
     */
    public void setAmdmntInfDtls(AmendmentInformationDetails13 value) {
        this.amdmntInfDtls = value;
    }

    /**
     * Obtient la valeur de la propri�t� elctrncSgntr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElctrncSgntr() {
        return elctrncSgntr;
    }

    /**
     * D�finit la valeur de la propri�t� elctrncSgntr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElctrncSgntr(String value) {
        this.elctrncSgntr = value;
    }

    /**
     * Obtient la valeur de la propri�t� frstColltnDt.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFrstColltnDt() {
        return frstColltnDt;
    }

    /**
     * D�finit la valeur de la propri�t� frstColltnDt.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFrstColltnDt(XMLGregorianCalendar value) {
        this.frstColltnDt = value;
    }

    /**
     * Obtient la valeur de la propri�t� fnlColltnDt.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFnlColltnDt() {
        return fnlColltnDt;
    }

    /**
     * D�finit la valeur de la propri�t� fnlColltnDt.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFnlColltnDt(XMLGregorianCalendar value) {
        this.fnlColltnDt = value;
    }

    /**
     * Obtient la valeur de la propri�t� frqcy.
     * 
     * @return
     *     possible object is
     *     {@link Frequency36Choice }
     *     
     */
    public Frequency36Choice getFrqcy() {
        return frqcy;
    }

    /**
     * D�finit la valeur de la propri�t� frqcy.
     * 
     * @param value
     *     allowed object is
     *     {@link Frequency36Choice }
     *     
     */
    public void setFrqcy(Frequency36Choice value) {
        this.frqcy = value;
    }

    /**
     * Obtient la valeur de la propri�t� rsn.
     * 
     * @return
     *     possible object is
     *     {@link MandateSetupReason1Choice }
     *     
     */
    public MandateSetupReason1Choice getRsn() {
        return rsn;
    }

    /**
     * D�finit la valeur de la propri�t� rsn.
     * 
     * @param value
     *     allowed object is
     *     {@link MandateSetupReason1Choice }
     *     
     */
    public void setRsn(MandateSetupReason1Choice value) {
        this.rsn = value;
    }

    /**
     * Obtient la valeur de la propri�t� trckgDays.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrckgDays() {
        return trckgDays;
    }

    /**
     * D�finit la valeur de la propri�t� trckgDays.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrckgDays(String value) {
        this.trckgDays = value;
    }

}
