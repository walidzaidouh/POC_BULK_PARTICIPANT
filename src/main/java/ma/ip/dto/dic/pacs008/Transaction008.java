package ma.ip.dto.dic.pacs008;

import lombok.Getter;
import lombok.Setter;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

@Getter
@Setter
public class Transaction008 {
    private String instrId;
    private String endToEndId;
    private String txId;
    private String uetr;
    private String clrSysRef;
    private String svcLvl_Cd;
    private String lclInstrm_Prtry;
    private String ctgyPurp_Prtry;
    private BigDecimal amount;
    private String currency;
    private XMLGregorianCalendar intrBkSttlmDt;
    private String sttlmTmReq_CLSTm;
    private XMLGregorianCalendar accptnDtTm;
    private String instdAmt;
    private String xchgRate;
    private String chrgBr;
    private String chrgsInf_Amt;
    private String chrgsInf_Agt;
    private String bicSender;
    private String instgAgt_Prtry;
    private String codeBankSender;
    private String bicReceiver;
    private String instdAgt_Prtry;
    private String codeBankReceiver;
    private String fullNameSender;
    private String debetor_PstlAdr;
    private String debetor_CtcDtls;
    private String debetor_Id;
    private String debetor_CtryOfRes;
    private String debetor_BirthDt;
    private String debetor_CtryOfBirth;
    private String debetor_CityOfBirth;
    private String debetorAcct_IBAN;
    private String ribReceiver;
    private String codeDbAgt;
    private String codeCdAgt;
    private String fullNameReceiver;
    private String cdtr_PstlAdr;
    private String cdtr_CtcDtls;
    private String cdtrAcct_IBAN;
    private String ribSender;
    private String instrForCdtAgt;
    private String ustrd;
    private String tp;


    public String toString() {

        return "Bank Prtry [" + codeBankSender + "]  Bic  [ " + bicSender  + "] " +
                " TxId " + txId +
                " InstrId " + instrId +
                " ClrSysRef" + clrSysRef ;
    }
}
