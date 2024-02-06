package ma.ip.utils;



import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlUtils {

    public static String readNamespaceMessageType(String namespace) {
        Pattern p = Pattern.compile(".*:\\s*(.*)");
        Matcher m = p.matcher(namespace);

        return m.find() ? m.group(1) : null;
    }


    public static XMLGregorianCalendar toXMLDate(String stringDate) throws DatatypeConfigurationException {
        XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(
                GregorianCalendar.from(LocalDate.parse(stringDate).atStartOfDay(ZoneOffset.UTC)));

        return xgc;
    }


    public static InputStream getFileFromResource(String fileName) {
        ClassLoader classLoader = XmlUtils.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }
        return inputStream;
    }
}
