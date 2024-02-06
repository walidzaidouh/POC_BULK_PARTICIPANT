package ma.ip.dto.dic.pacs008;

import lombok.Getter;
import lombok.Setter;
import ma.ip.dto.dic.PayLoadMessage;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


public class Pacs008Payload extends PayLoadMessage {

    private String msgId;
    private XMLGregorianCalendar creDtTm;
    private String nbOfTxs;
    private String sttlmMtd;
    private List<Transaction008> transactions;

    public Pacs008Payload() {
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

    public String getNbOfTxs() {
        return nbOfTxs;
    }

    public void setNbOfTxs(String nbOfTxs) {
        this.nbOfTxs = nbOfTxs;
    }

    public String getSttlmMtd() {
        return sttlmMtd;
    }

    public void setSttlmMtd(String sttlmMtd) {
        this.sttlmMtd = sttlmMtd;
    }

    public List<Transaction008> getTransactions() {
        if (transactions == null){
            transactions = new ArrayList<>();
        }
        return transactions;
    }

    public void setTransactions(List<Transaction008> transactions) {
        this.transactions = transactions;
    }

    public String toString() {

        return " Msg ID " + msgId +
                " At " + creDtTm;
    }
}
