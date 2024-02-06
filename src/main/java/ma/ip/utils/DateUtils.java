package ma.ip.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateUtils {


    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

    /**
     * This method allows to Date to LocalDate
     *
     * @param dateToConvert
     * @return
     */
    public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }


    /**
     * This method allows to convert LocalDate to Date
     *
     * @param dateToConvert
     * @return
     */
    public static Date convertToDateViaInstant(LocalDate dateToConvert) {
        return Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    /**
     * This method allows to convert DateTime to Date without Time
     *
     * @param date
     * @return
     */
    public static Date convertToDateWithoutTime(Date date) {
        Date result  = date;

        SimpleDateFormat formatter = new SimpleDateFormat(
                "dd/MM/yyyy");
        try {
            result = formatter.parse(formatter.format(date));
        } catch (ParseException e) {
            LOGGER.error("Erreur ParseException : ",e);
        }
        return result;
    }


    /**
     * This method allows to convert a Date to XmlGregorianCalendar.
     *
     * @return
     */
    public static XMLGregorianCalendar convertToXmlGregorianCalendar(Date date) {

        GregorianCalendar cal = new GregorianCalendar();
        XMLGregorianCalendar xmlGregCal = null;
        try {
            cal.setTime(date);
            xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (Exception e) {
            DateUtils.LOGGER.error("Error {}", e.getMessage());
        }
        return xmlGregCal;
    }

    /**
     * This method allows to convert a String to XmlGregorianCalendar.
     *
     * @return
     */
    public static XMLGregorianCalendar convertToXmlGregorianCalendar(String dateAsString) {

        XMLGregorianCalendar xmlGregCal = null;
        try {
            xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateAsString);
        } catch (Exception e) {
            DateUtils.LOGGER.error("Error {}", e.getMessage());
        }
        return xmlGregCal;
    }


    /**
     * Date To String
     *
     * @param datetime
     * @return
     */
    public static String dts(Date datetime, String pattern) {
        DateFormat formatter = new SimpleDateFormat(pattern);
        if (datetime == null) {
            return null;
        }
        return formatter.format(datetime);
    }

    public static boolean isWeekend(Date date) {

        // get Calendar instance
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // get Day of week for the passed LocalDate
        return (calendar.get(Calendar.DAY_OF_WEEK) == 1)
                || (calendar.get(Calendar.DAY_OF_WEEK) == 7);

    }

   /* *//**
     * This method allows to convert a String to XmlGregorianCalendar.
     *
     * @return
     *//*
    public static XMLGregorianCalendar convertToXgcWithOutTime(Date date) {

        GregorianCalendar cal = new GregorianCalendar();
        XMLGregorianCalendar xmlGregCal = null;
        try {
            cal.setTime(date);
            xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            xmlGregCal.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
        } catch (Exception e) {
            DateUtils.LOGGER.error("Error {}", e.getMessage());
        }
        return xmlGregCal;
    }

*/

    public static LocalDateTime getDateTimeFromTimestamp(long timestamp) {
        if (timestamp == 0)
            return null;
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), TimeZone
                .getDefault().toZoneId());
    }
}
