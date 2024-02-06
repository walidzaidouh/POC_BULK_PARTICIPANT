package ma.ip.dto.dic.pacs002.pacs_002_001_10;

import javax.xml.bind.annotation.*;


/**
 * <p>Classe Java pour Document complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FIToFIPmtStsRpt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}FIToFIPaymentStatusReportV10"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 **/
@XmlRootElement(name= "Document")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
    "fiToFIPmtStsRpt"
})
public class Document {

    @XmlElement(name = "FIToFIPmtStsRpt", required = true)
    protected FIToFIPaymentStatusReportV10 fiToFIPmtStsRpt;

    /**
     * Obtient la valeur de la propri�t� fiToFIPmtStsRpt.
     * 
     * @return
     *     possible object is
     *     {@link FIToFIPaymentStatusReportV10 }
     *     
     */
    public FIToFIPaymentStatusReportV10 getFIToFIPmtStsRpt() {
        return fiToFIPmtStsRpt;
    }

    /**
     * D�finit la valeur de la propri�t� fiToFIPmtStsRpt.
     * 
     * @param value
     *     allowed object is
     *     {@link FIToFIPaymentStatusReportV10 }
     *     
     */
    public void setFIToFIPmtStsRpt(FIToFIPaymentStatusReportV10 value) {
        this.fiToFIPmtStsRpt = value;
    }

}
