package ma.ip.dto.dic.pacs002;

import ma.ip.dto.dic.PayLoadMessage;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;



public class Pacs002Payload extends PayLoadMessage {
    private Long id;
    private String msgId;
    private XMLGregorianCalendar creDtTm;
    private List<PaymentTransaction> paymentTransactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public XMLGregorianCalendar getCreDtTm() {
        return creDtTm;
    }

    public void setCreDtTm(XMLGregorianCalendar creDtTm) {
        this.creDtTm = creDtTm;
    }

    public List<PaymentTransaction> getPaymentTransactions() {
        if (paymentTransactions == null){
            paymentTransactions = new ArrayList<>();
        }
        return paymentTransactions;
    }

    public void setPaymentTransactions(List<PaymentTransaction> paymentTransactions) {
        this.paymentTransactions = paymentTransactions;
    }

    public String toString() {

        return " Msg ID " + msgId +
                " At " + creDtTm;    }
}
