package ma.ip.dto.dic.pacs002;

import lombok.Getter;
import lombok.Setter;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

@Getter
@Setter
public class PaymentTransaction {

    private String orgnlMsgId;
    private String orgnlMsgNmId;
    private XMLGregorianCalendar orgnlCreDtTm;
    private String originalInstrId;
    private String orgnlEndToEndId;
    private String orgnlTxId;
    private String orgnlUETR;
    private String txSts;
    private String rsn;
    private List<String> addtlInf;
    private XMLGregorianCalendar accptncDtTm;
    private String clrSysRef;
    private String instgAgt;
    private String instdAgt;
    private String instgAgt_BicFi;
    private String instgAgt_Prtry;
    private String instgAgt_MbrId;
    private String instdAgt_BicFi;
    private String instdAgt_Prtry;
    private String instdAgt_MbrId;
    private String orgnlTxRef;
    private String splmtryData;

    public String toString(){
        return "Bank Prtry [" + instdAgt_MbrId  + "] " +
                " BIC [" + instdAgt_BicFi + "] " +
                " instgAgt_MbrId [" + instgAgt_MbrId + "] " +
                " instdAgt_Prtry [" + instdAgt_Prtry + "] " +
                " TxId " + orgnlTxId +
                " ClrSysRef" + clrSysRef;
    }
}
