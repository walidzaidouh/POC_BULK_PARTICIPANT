


package ma.ip.dto.dic.pacs008.pacs_008_001_08;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour Contact4 complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Contact4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NmPrfx" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}NamePrefix2Code" minOccurs="0"/>
 *         &lt;element name="Nm" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}Max140Text" minOccurs="0"/>
 *         &lt;element name="PhneNb" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}PhoneNumber" minOccurs="0"/>
 *         &lt;element name="MobNb" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}PhoneNumber" minOccurs="0"/>
 *         &lt;element name="FaxNb" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}PhoneNumber" minOccurs="0"/>
 *         &lt;element name="EmailAdr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}Max2048Text" minOccurs="0"/>
 *         &lt;element name="EmailPurp" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}Max35Text" minOccurs="0"/>
 *         &lt;element name="JobTitl" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}Max35Text" minOccurs="0"/>
 *         &lt;element name="Rspnsblty" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}Max35Text" minOccurs="0"/>
 *         &lt;element name="Dept" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}Max70Text" minOccurs="0"/>
 *         &lt;element name="Othr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}OtherContact1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PrefrdMtd" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}PreferredContactMethod1Code" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Contact4", propOrder = {
    "nmPrfx",
    "nm",
    "phneNb",
    "mobNb",
    "faxNb",
    "emailAdr",
    "emailPurp",
    "jobTitl",
    "rspnsblty",
    "dept",
    "othr",
    "prefrdMtd"
})
public class Contact4 {

    @XmlElement(name = "NmPrfx")
    protected NamePrefix2Code nmPrfx;
    @XmlElement(name = "Nm")
    protected String nm;
    @XmlElement(name = "PhneNb")
    protected String phneNb;
    @XmlElement(name = "MobNb")
    protected String mobNb;
    @XmlElement(name = "FaxNb")
    protected String faxNb;
    @XmlElement(name = "EmailAdr")
    protected String emailAdr;
    @XmlElement(name = "EmailPurp")
    protected String emailPurp;
    @XmlElement(name = "JobTitl")
    protected String jobTitl;
    @XmlElement(name = "Rspnsblty")
    protected String rspnsblty;
    @XmlElement(name = "Dept")
    protected String dept;
    @XmlElement(name = "Othr")
    protected List<OtherContact1> othr;
    @XmlElement(name = "PrefrdMtd")
    protected PreferredContactMethod1Code prefrdMtd;

    /**
     * Obtient la valeur de la propriété nmPrfx.
     * 
     * @return
     *     possible object is
     *     {@link   NamePrefix2Code }
     *     
     */
    public NamePrefix2Code getNmPrfx() {
        return nmPrfx;
    }

    /**
     * Définit la valeur de la propriété nmPrfx.
     * 
     * @param value
     *     allowed object is
     *     {@link   NamePrefix2Code }
     *     
     */
    public void setNmPrfx(NamePrefix2Code value) {
        this.nmPrfx = value;
    }

    /**
     * Obtient la valeur de la propriété nm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNm() {
        return nm;
    }

    /**
     * Définit la valeur de la propriété nm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNm(String value) {
        this.nm = value;
    }

    /**
     * Obtient la valeur de la propriété phneNb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhneNb() {
        return phneNb;
    }

    /**
     * Définit la valeur de la propriété phneNb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhneNb(String value) {
        this.phneNb = value;
    }

    /**
     * Obtient la valeur de la propriété mobNb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobNb() {
        return mobNb;
    }

    /**
     * Définit la valeur de la propriété mobNb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobNb(String value) {
        this.mobNb = value;
    }

    /**
     * Obtient la valeur de la propriété faxNb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaxNb() {
        return faxNb;
    }

    /**
     * Définit la valeur de la propriété faxNb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaxNb(String value) {
        this.faxNb = value;
    }

    /**
     * Obtient la valeur de la propriété emailAdr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAdr() {
        return emailAdr;
    }

    /**
     * Définit la valeur de la propriété emailAdr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAdr(String value) {
        this.emailAdr = value;
    }

    /**
     * Obtient la valeur de la propriété emailPurp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailPurp() {
        return emailPurp;
    }

    /**
     * Définit la valeur de la propriété emailPurp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailPurp(String value) {
        this.emailPurp = value;
    }

    /**
     * Obtient la valeur de la propriété jobTitl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobTitl() {
        return jobTitl;
    }

    /**
     * Définit la valeur de la propriété jobTitl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobTitl(String value) {
        this.jobTitl = value;
    }

    /**
     * Obtient la valeur de la propriété rspnsblty.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRspnsblty() {
        return rspnsblty;
    }

    /**
     * Définit la valeur de la propriété rspnsblty.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRspnsblty(String value) {
        this.rspnsblty = value;
    }

    /**
     * Obtient la valeur de la propriété dept.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDept() {
        return dept;
    }

    /**
     * Définit la valeur de la propriété dept.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDept(String value) {
        this.dept = value;
    }

    /**
     * Gets the value of the othr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the othr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOthr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OtherContact1 }
     * 
     * 
     */
    public List<OtherContact1> getOthr() {
        if (othr == null) {
            othr = new ArrayList<OtherContact1>();
        }
        return this.othr;
    }

    /**
     * Obtient la valeur de la propriété prefrdMtd.
     * 
     * @return
     *     possible object is
     *     {@link PreferredContactMethod1Code }
     *     
     */
    public PreferredContactMethod1Code getPrefrdMtd() {
        return prefrdMtd;
    }

    /**
     * Définit la valeur de la propriété prefrdMtd.
     * 
     * @param value
     *     allowed object is
     *     {@link PreferredContactMethod1Code }
     *     
     */
    public void setPrefrdMtd(PreferredContactMethod1Code value) {
        this.prefrdMtd = value;
    }

}
