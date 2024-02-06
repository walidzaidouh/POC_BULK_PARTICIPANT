


package ma.ip.dto.dic.pacs008.pacs_008_001_08;

import javax.xml.bind.annotation.*;


/**
 * <p>Classe Java pour Document complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FIToFICstmrCdtTrf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}FIToFICustomerCreditTransferV08"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */

@XmlRootElement(name= "Document")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
    "fiToFICstmrCdtTrf"
})
public class Document {

    @XmlElement(name = "FIToFICstmrCdtTrf", required = true)
    protected FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf;

    /**
     * Obtient la valeur de la propriété fiToFICstmrCdtTrf.
     * 
     * @return
     *     possible object is
     *     {@link FIToFICustomerCreditTransferV08 }
     *     
     */
    public FIToFICustomerCreditTransferV08 getFIToFICstmrCdtTrf() {
        return fiToFICstmrCdtTrf;
    }

    /**
     * Définit la valeur de la propriété fiToFICstmrCdtTrf.
     * 
     * @param value
     *     allowed object is
     *     {@link FIToFICustomerCreditTransferV08 }
     *     
     */
    public void setFIToFICstmrCdtTrf(FIToFICustomerCreditTransferV08 value) {
        this.fiToFICstmrCdtTrf = value;
    }

}
