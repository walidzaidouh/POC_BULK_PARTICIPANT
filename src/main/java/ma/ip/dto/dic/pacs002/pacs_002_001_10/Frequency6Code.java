//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2021.09.09 � 02:08:37 PM CEST 
//


package ma.ip.dto.dic.pacs002.pacs_002_001_10;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour Frequency6Code.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="Frequency6Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="YEAR"/>
 *     &lt;enumeration value="MNTH"/>
 *     &lt;enumeration value="QURT"/>
 *     &lt;enumeration value="MIAN"/>
 *     &lt;enumeration value="WEEK"/>
 *     &lt;enumeration value="DAIL"/>
 *     &lt;enumeration value="ADHO"/>
 *     &lt;enumeration value="INDA"/>
 *     &lt;enumeration value="FRTN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Frequency6Code")
@XmlEnum
public enum Frequency6Code {

    YEAR,
    MNTH,
    QURT,
    MIAN,
    WEEK,
    DAIL,
    ADHO,
    INDA,
    FRTN;

    public String value() {
        return name();
    }

    public static Frequency6Code fromValue(String v) {
        return valueOf(v);
    }

}
