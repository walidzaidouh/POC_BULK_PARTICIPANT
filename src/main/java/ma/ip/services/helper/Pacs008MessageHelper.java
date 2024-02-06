package ma.ip.services.helper;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ma.ip.dto.dic.pacs008.Pacs008Payload;
import ma.ip.dto.dic.pacs008.Transaction008;
import ma.ip.dto.dic.pacs008.pacs_008_001_08.*;
import ma.ip.exceptions.ValidationErrorHandler;
import ma.ip.utils.DateUtils;
import ma.ip.utils.XmlUtils;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.bind.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Slf4j
public class Pacs008MessageHelper {

    private static final String PACS008_XSD_FILENAME = "pacs.008.001.08.xsd";


    /**
     * This method allows to build a Pacs 008 Document.
     *
     * @param pacs008Payload
     * @return
     */
    public Document build(Pacs008Payload pacs008Payload) {
        Document document = new Document();
        FIToFICustomerCreditTransferV08 cct = new FIToFICustomerCreditTransferV08();
        SupplementaryData1 splData = new SupplementaryData1();
        CreditTransferTransaction39 ctt = new CreditTransferTransaction39();

        GroupHeader93 grpHdr = new GroupHeader93();
        Boolean grpHdrIsPresent = Boolean.FALSE;
        if (pacs008Payload.getMsgId() != null) {
            grpHdrIsPresent = Boolean.TRUE;
            grpHdr.setMsgId(pacs008Payload.getMsgId());
        }

        if (pacs008Payload.getCreDtTm() != null) {
            grpHdrIsPresent = Boolean.TRUE;
            grpHdr.setCreDtTm(pacs008Payload.getCreDtTm());
        }

        if (pacs008Payload.getNbOfTxs() != null) {
            grpHdr.setNbOfTxs(pacs008Payload.getNbOfTxs());
            grpHdrIsPresent = Boolean.TRUE;
        }
        if (pacs008Payload.getSttlmMtd() != null) {
            grpHdrIsPresent = Boolean.TRUE;
            SettlementMethod1Code settlementMethod1Code = SettlementMethod1Code.valueOf(pacs008Payload.getSttlmMtd());
            SettlementInstruction7 sttlmMtd = new SettlementInstruction7();
            sttlmMtd.setSttlmMtd(settlementMethod1Code);
            grpHdr.setSttlmInf(sttlmMtd);
        }
        if (grpHdrIsPresent.booleanValue()) {
            cct.setGrpHdr(grpHdr);
        }

        PaymentIdentification7 pmtId = new PaymentIdentification7();
        Boolean payIdIsPresent = Boolean.FALSE;

        for (Transaction008 transaction: pacs008Payload.getTransactions()) {

            if (transaction.getInstrId() != null) {
                payIdIsPresent = Boolean.TRUE;
                pmtId.setInstrId(transaction.getInstrId());
            }

            payIdIsPresent = Boolean.TRUE;
            pmtId.setEndToEndId("NOTPROVIDED");

            if (transaction.getTxId() != null) {
                payIdIsPresent = Boolean.TRUE;
                pmtId.setTxId(transaction.getTxId());
            }
            if (transaction.getUetr() != null) {
                payIdIsPresent = Boolean.TRUE;
                pmtId.setUETR(transaction.getUetr());
            }
            if (transaction.getClrSysRef() != null) {
                payIdIsPresent = Boolean.TRUE;
                pmtId.setClrSysRef(transaction.getClrSysRef());
            }
            if (payIdIsPresent.booleanValue()) {
                ctt.setPmtId(pmtId);
            }


            PaymentTypeInformation28 pmtTpInf = new PaymentTypeInformation28();
            Boolean pmtTpInfIsPresent = Boolean.FALSE;
            if (transaction.getSvcLvl_Cd() != null) {
                pmtTpInfIsPresent = Boolean.TRUE;
                ServiceLevel8Choice svcLvl = new ServiceLevel8Choice();
                svcLvl.setCd(transaction.getSvcLvl_Cd());
                pmtTpInf.getSvcLvl().add(svcLvl);
            }

            // LclInstrm Prtry
            if (transaction.getLclInstrm_Prtry() != null) {
                pmtTpInfIsPresent = Boolean.TRUE;
                LocalInstrument2Choice lclInstrm = new LocalInstrument2Choice();
                lclInstrm.setPrtry(transaction.getLclInstrm_Prtry());
                pmtTpInf.setLclInstrm(lclInstrm);
            }

            // Ctgy Purp Prtry
            if (transaction.getCtgyPurp_Prtry() != null) {
                pmtTpInfIsPresent = Boolean.TRUE;
                CategoryPurpose1Choice ctgyPurp = new CategoryPurpose1Choice();
                ctgyPurp.setPrtry(transaction.getCtgyPurp_Prtry());
                pmtTpInf.setCtgyPurp(ctgyPurp);
            }

            if (pmtTpInfIsPresent.booleanValue()) {
                ctt.setPmtTpInf(pmtTpInf);
            }

            ActiveCurrencyAndAmount actvCurrAmnt = new ActiveCurrencyAndAmount();
            Boolean actvCurrAmntIsPresent = Boolean.FALSE;
            if (transaction.getCurrency() != null) {
                actvCurrAmntIsPresent = Boolean.TRUE;
                actvCurrAmnt.setCcy(transaction.getCurrency());
            }

            if (transaction.getAmount() != null) {
                actvCurrAmntIsPresent = Boolean.TRUE;
                actvCurrAmnt.setValue(transaction.getAmount());
            }
            if (actvCurrAmntIsPresent.booleanValue()) {
                ctt.setIntrBkSttlmAmt(actvCurrAmnt);
            }
            if (transaction.getIntrBkSttlmDt() != null) {
                ctt.setIntrBkSttlmDt(transaction.getIntrBkSttlmDt());
            }

            // ChrgBr
            if (transaction.getChrgBr() != null) {
                ChargeBearerType1Code chargeBearerType1Code = ChargeBearerType1Code.fromValue(transaction.getChrgBr());
                ctt.setChrgBr(chargeBearerType1Code);
            }

            if (transaction.getAccptnDtTm() != null) {
                ctt.setAccptncDtTm(transaction.getAccptnDtTm());
            }


            // IBAN CREDIT
            CashAccount38 cashAccountCredit = new CashAccount38();
            AccountIdentification4Choice identification4ChoiceCredit = new AccountIdentification4Choice();
            if (transaction.getCdtrAcct_IBAN() != null) {

                identification4ChoiceCredit.setIBAN(transaction.getCdtrAcct_IBAN());
                cashAccountCredit.setId(identification4ChoiceCredit);
                ctt.setCdtrAcct(cashAccountCredit);
            }

            // RIB RECEIVER
            if (transaction.getRibReceiver() != null) {
                GenericAccountIdentification1 other = new GenericAccountIdentification1();
                other.setId(transaction.getRibReceiver());
                AccountSchemeName1Choice accountSchemeName1Choice = new AccountSchemeName1Choice();
                accountSchemeName1Choice.setPrtry("RIB");
                other.setSchmeNm(accountSchemeName1Choice);
                identification4ChoiceCredit.setOthr(other);
                cashAccountCredit.setId(identification4ChoiceCredit);
                ctt.setCdtrAcct(cashAccountCredit);
            }

            // IBAN DEBIT
            CashAccount38 cashAccountDebit = new CashAccount38();
            AccountIdentification4Choice identification4ChoiceDebit = new AccountIdentification4Choice();

            // EVOL - 01/04/2022 - TP
            if (transaction.getTp() != null) {
                CashAccountType2Choice cashAccountType2Choice = new CashAccountType2Choice();
                cashAccountType2Choice.setPrtry(transaction.getTp());
                cashAccountDebit.setTp(cashAccountType2Choice);

            }

            if (transaction.getDebetorAcct_IBAN() != null) {

                identification4ChoiceDebit.setIBAN(transaction.getDebetorAcct_IBAN());
                cashAccountDebit.setId(identification4ChoiceDebit);
                ctt.setDbtrAcct(cashAccountDebit);
            }

            // RIB SENDER
            if (transaction.getRibSender() != null) {

                GenericAccountIdentification1 other = new GenericAccountIdentification1();
                AccountSchemeName1Choice accountSchemeName1Choice = new AccountSchemeName1Choice();
                accountSchemeName1Choice.setPrtry("RIB");
                other.setId(transaction.getRibSender());
                other.setSchmeNm(accountSchemeName1Choice);
                identification4ChoiceDebit.setOthr(other);
                cashAccountDebit.setId(identification4ChoiceDebit);
                ctt.setDbtrAcct(cashAccountDebit);
            }


            BranchAndFinancialInstitutionIdentification6 instgAgt = new BranchAndFinancialInstitutionIdentification6();
            FinancialInstitutionIdentification18 finInstId = new FinancialInstitutionIdentification18();
            ClearingSystemMemberIdentification2 clrSysMmbrId = new ClearingSystemMemberIdentification2();
            ClearingSystemIdentification2Choice clrSysId = new ClearingSystemIdentification2Choice();
            clrSysId.setPrtry("GSIMT");
            clrSysMmbrId.setClrSysId(clrSysId);

            if (transaction.getBicSender() != null) {
                finInstId.setBICFI(transaction.getBicSender());
            }


            if (transaction.getCodeBankSender() != null) {
                clrSysMmbrId.setMmbId(transaction.getCodeBankSender());
            }

            finInstId.setClrSysMmbId(clrSysMmbrId);
            instgAgt.setFinInstnId(finInstId);
            ctt.setInstgAgt(instgAgt);
            ctt.setDbtrAgt(instgAgt);


            BranchAndFinancialInstitutionIdentification6 instdAgt = new BranchAndFinancialInstitutionIdentification6();
            FinancialInstitutionIdentification18 finInstId2 = new FinancialInstitutionIdentification18();
            ClearingSystemMemberIdentification2 clrSysMmbrId2 = new ClearingSystemMemberIdentification2();
            ClearingSystemIdentification2Choice clrSysId2 = new ClearingSystemIdentification2Choice();
            clrSysId2.setPrtry("GSIMT");
            clrSysMmbrId2.setClrSysId(clrSysId2);

            if (transaction.getBicReceiver() != null) {
                finInstId2.setBICFI(transaction.getBicReceiver());
            }

            if (transaction.getCodeBankReceiver() != null) {
                clrSysMmbrId2.setMmbId(transaction.getCodeBankReceiver());
            }


            finInstId2.setClrSysMmbId(clrSysMmbrId2);
            instdAgt.setFinInstnId(finInstId2);
            ctt.setInstdAgt(instdAgt);

            if (StringUtils.isEmpty(transaction.getCodeCdAgt())) {
                ctt.setCdtrAgt(instdAgt);
            } else {
                ClearingSystemMemberIdentification2 clrSysMmbrSubParticipant = new ClearingSystemMemberIdentification2();
                BranchAndFinancialInstitutionIdentification6 instdAgtSubParticipant = new BranchAndFinancialInstitutionIdentification6();
                FinancialInstitutionIdentification18 finInstSubParticipant = new FinancialInstitutionIdentification18();
                clrSysMmbrSubParticipant.setMmbId(transaction.getCodeCdAgt());
                clrSysMmbrSubParticipant.setClrSysId(clrSysId2);
                finInstSubParticipant.setClrSysMmbId(clrSysMmbrSubParticipant);
                instdAgtSubParticipant.setFinInstnId(finInstSubParticipant);
                ctt.setCdtrAgt(instdAgtSubParticipant);
            }

            PartyIdentification135 partyDebitor = new PartyIdentification135();


            if (transaction.getFullNameSender() != null) {
                partyDebitor.setNm(transaction.getFullNameSender());
                ctt.setDbtr(partyDebitor);
            }

            if (transaction.getDebetor_BirthDt() != null
                    && transaction.getDebetor_CityOfBirth() != null
                    && transaction.getDebetor_CtryOfBirth() != null) {

                Party38Choice identification = new Party38Choice();
                PersonIdentification13 personneIdentification = new PersonIdentification13();

                DateAndPlaceOfBirth1 dateAndPlaceOfBirth1 = new DateAndPlaceOfBirth1();

                dateAndPlaceOfBirth1.setBirthDt(DateUtils.convertToXmlGregorianCalendar(transaction.getDebetor_BirthDt()));
                dateAndPlaceOfBirth1.setCityOfBirth(transaction.getDebetor_CityOfBirth());
                dateAndPlaceOfBirth1.setCtryOfBirth(transaction.getDebetor_CtryOfBirth());
                personneIdentification.setDtAndPlcOfBirth(dateAndPlaceOfBirth1);
                identification.setPrvtId(personneIdentification);
                partyDebitor.setId(identification);
                ctt.setDbtr(partyDebitor);
            }


            if (transaction.getDebetor_CtryOfRes() != null) {
                partyDebitor.setCtryOfRes(transaction.getDebetor_CtryOfRes());
                ctt.setDbtr(partyDebitor);
            }

            if (transaction.getDebetor_PstlAdr() != null) {
                PostalAddress24 postalAddress24 = new PostalAddress24();
                postalAddress24.getAdrLine().add(transaction.getDebetor_PstlAdr());
                partyDebitor.setPstlAdr(postalAddress24);
                ctt.setDbtr(partyDebitor);
            }

            if (transaction.getDebetor_CtcDtls() != null) {
                Contact4 contact4 = new Contact4();
                contact4.setDept(transaction.getDebetor_CtcDtls());
                partyDebitor.setCtctDtls(contact4);
                ctt.setDbtr(partyDebitor);
            }

            if (transaction.getInstrForCdtAgt() != null) {
                InstructionForCreditorAgent1 instructionForCreditorAgent1 = new InstructionForCreditorAgent1();
                instructionForCreditorAgent1.setInstrInf(transaction.getInstrForCdtAgt());
                List<InstructionForCreditorAgent1> instructionForCreditorAgent1List = new ArrayList<>();
                instructionForCreditorAgent1List.add(instructionForCreditorAgent1);
                ctt.setInstrForCdtrAgt(instructionForCreditorAgent1List);
            }

            PartyIdentification135 partyCreditor = new PartyIdentification135();
            if (transaction.getFullNameReceiver() != null) {

                partyCreditor.setNm(transaction.getFullNameReceiver());
                ctt.setCdtr(partyCreditor);
            }

            if (transaction.getCdtr_PstlAdr() != null) {
                PostalAddress24 postalAddress24 = new PostalAddress24();
                postalAddress24.getAdrLine().add(transaction.getCdtr_PstlAdr());
                partyCreditor.setPstlAdr(postalAddress24);
            }

            if (transaction.getCdtr_CtcDtls() != null) {
                Contact4 contact4 = new Contact4();
                contact4.setDept(transaction.getCdtr_CtcDtls());
                partyCreditor.setCtctDtls(contact4);
            }


            if (transaction.getInstdAmt() != null) {
                ActiveOrHistoricCurrencyAndAmount activeOrHistoricCurrencyAndAmount = new ActiveOrHistoricCurrencyAndAmount();
                activeOrHistoricCurrencyAndAmount.setValue(new BigDecimal(transaction.getInstdAmt()));
                if (transaction.getCurrency() != null) {
                    activeOrHistoricCurrencyAndAmount.setCcy(transaction.getCurrency());
                }

                ctt.setInstdAmt(activeOrHistoricCurrencyAndAmount);
            }

            if (transaction.getXchgRate() != null) {
                ctt.setXchgRate(new BigDecimal(transaction.getXchgRate()));
            }

            Charges7 charges7 = new Charges7();
            if (transaction.getChrgsInf_Amt() != null) {

                ActiveOrHistoricCurrencyAndAmount activeOrHistoricCurrencyAndAmount = new ActiveOrHistoricCurrencyAndAmount();
                activeOrHistoricCurrencyAndAmount.setValue(new BigDecimal(transaction.getChrgsInf_Amt()));
                if (transaction.getCurrency() != null) {
                    activeOrHistoricCurrencyAndAmount.setCcy(transaction.getCurrency());
                }
                charges7.setAmt(activeOrHistoricCurrencyAndAmount);

            }

            if (transaction.getChrgsInf_Agt() != null) {
                BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6 = new BranchAndFinancialInstitutionIdentification6();
                FinancialInstitutionIdentification18 financialInstitutionIdentification18 = new FinancialInstitutionIdentification18();
                financialInstitutionIdentification18.setBICFI(transaction.getChrgsInf_Agt());
                branchAndFinancialInstitutionIdentification6.setFinInstnId(financialInstitutionIdentification18);
                charges7.setAgt(branchAndFinancialInstitutionIdentification6);
            }

            if (charges7 != null && (charges7.getAgt() != null || charges7.getAmt() != null)) {
                ctt.getChrgsInf().add(charges7);
            }

            if (transaction.getUstrd() != null) {
                RemittanceInformation16 remittanceInformation16 = new RemittanceInformation16();
                remittanceInformation16.getUstrd().add(transaction.getUstrd());
                ctt.setRmtInf(remittanceInformation16);
            }


            if (ctt != null) {
                cct.getCdtTrfTxInf().add(ctt);
            }
        }

        document.setFIToFICstmrCdtTrf(cct);
        return document;
    }

    public void generate(Document document, OutputStream os) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(new Class[]{Document.class});
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty("jaxb.encoding", StandardCharsets.ISO_8859_1.name());
            if (os instanceof java.io.FileOutputStream)
                jaxbMarshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            jaxbMarshaller.marshal(document, os);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method allows to validate a pacs 008 xml.
     *
     * @param xmlString
     * @return
     */
    public ValidationErrorHandler validate(String xmlString) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        ValidationErrorHandler validatorHandler = new ValidationErrorHandler();
        try {
            Source schemaSource = new StreamSource(XmlUtils.getFileFromResource("xsd/pacs.008.001.08.xsd"));
            Schema schema = schemaFactory.newSchema(schemaSource);
            Validator validator = schema.newValidator();
            validator.setErrorHandler((ErrorHandler) validatorHandler);
            validator.validate(new StreamSource(new StringReader(xmlString)));
        } catch (SAXException | java.io.IOException e) {
            log.error("Error " + e.getLocalizedMessage());
        }
        return validatorHandler;
    }

    /**
     * This method allows to parse a pacs 008 from XML to Payload.
     *
     * @param xmlString
     * @return
     */
    public Pacs008Payload parse(String xmlString) {
        Document document;
        Pacs008Payload pacs008Payload = null;
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(new Class[]{Document.class});
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            document = (Document) JAXBIntrospector.getValue(unmarshaller.unmarshal(new StringReader(xmlString)));
            pacs008Payload = pacs008PayloadMapper(document);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return pacs008Payload;
    }

    /**
     * This method allows to convert a Document 008 to Payload.
     *
     * @param document
     */
    private Pacs008Payload pacs008PayloadMapper(Document document) {
       Pacs008Payload pacs008Payload = new Pacs008Payload();
        if (document != null || document.getFIToFICstmrCdtTrf() != null) {
            if (document.getFIToFICstmrCdtTrf().getGrpHdr() != null) {
                pacs008Payload.setMsgId(document.getFIToFICstmrCdtTrf().getGrpHdr().getMsgId());
                pacs008Payload.setCreDtTm(document.getFIToFICstmrCdtTrf().getGrpHdr().getCreDtTm());
                pacs008Payload.setNbOfTxs(document.getFIToFICstmrCdtTrf().getGrpHdr().getNbOfTxs());
                if (document.getFIToFICstmrCdtTrf().getGrpHdr().getSttlmInf() != null
                        && document.getFIToFICstmrCdtTrf().getGrpHdr().getSttlmInf().getSttlmMtd() != null) {
                    pacs008Payload.setSttlmMtd(
                            document.getFIToFICstmrCdtTrf().getGrpHdr().getSttlmInf().getSttlmMtd().toString());
                }
            }
            if (document.getFIToFICstmrCdtTrf().getCdtTrfTxInf() != null
                    && document.getFIToFICstmrCdtTrf().getCdtTrfTxInf().size() > 0) {
                for (CreditTransferTransaction39 ctt : document.getFIToFICstmrCdtTrf().getCdtTrfTxInf()) {
                    //CreditTransferTransaction39 ctt = document.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0);
                    Transaction008 transaction = new Transaction008();
                    if (ctt.getPmtId() != null) {
                        transaction.setInstrId(ctt.getPmtId().getInstrId());
                        transaction.setEndToEndId(ctt.getPmtId().getEndToEndId());
                        transaction.setTxId(ctt.getPmtId().getTxId());
                        transaction.setUetr(ctt.getPmtId().getUETR());
                        transaction.setClrSysRef(ctt.getPmtId().getClrSysRef());
                    }
                    if (ctt.getPmtTpInf() != null) {
                        if (ctt.getPmtTpInf().getSvcLvl() != null && !ctt.getPmtTpInf().getSvcLvl().isEmpty() && ctt.getPmtTpInf().getSvcLvl().get(0) != null) {
                            transaction.setSvcLvl_Cd(ctt.getPmtTpInf().getSvcLvl().get(0).getCd());
                        }
                        if (ctt.getPmtTpInf().getLclInstrm() != null && ctt.getPmtTpInf().getLclInstrm() != null) {
                            transaction.setLclInstrm_Prtry(ctt.getPmtTpInf().getLclInstrm().getPrtry());
                        }
                        if (ctt.getPmtTpInf().getCtgyPurp() != null && ctt.getPmtTpInf().getCtgyPurp().getPrtry() != null) {
                            transaction.setCtgyPurp_Prtry(ctt.getPmtTpInf().getCtgyPurp().getPrtry());
                        }
                    }
                    if (ctt.getIntrBkSttlmAmt() != null) {

                        if (ctt.getIntrBkSttlmAmt().getValue() != null) {
                            transaction.setAmount(ctt.getIntrBkSttlmAmt().getValue());
                        }
                        transaction.setCurrency(ctt.getIntrBkSttlmAmt().getCcy());
                    }

                    if (ctt.getIntrBkSttlmDt() != null) {
                        transaction.setIntrBkSttlmDt(ctt.getIntrBkSttlmDt());
                    }
                    if (ctt.getSttlmTmReq() != null && ctt.getSttlmTmReq().getCLSTm() != null) {
                        transaction.setSttlmTmReq_CLSTm(ctt.getSttlmTmReq().getCLSTm().toString());
                    }
                    if (ctt.getAccptncDtTm() != null)
                        transaction.setAccptnDtTm(ctt.getAccptncDtTm());
                    if (ctt.getInstdAmt() != null) {
                        transaction.setInstdAmt(ctt.getInstdAmt().toString());
                    }
                    if (ctt.getXchgRate() != null) {
                        transaction.setXchgRate(ctt.getXchgRate().toString());
                    }
                    if (ctt.getChrgBr() != null) {
                        transaction.setChrgBr(ctt.getChrgBr().toString());
                    }
                    if (ctt.getChrgsInf() != null && ctt.getChrgsInf().size() > 1) {
                        if (((Charges7) ctt.getChrgsInf().get(0)).getAgt() != null)
                            transaction.setChrgsInf_Agt(((Charges7) ctt.getChrgsInf().get(0)).getAgt().toString());
                        if (((Charges7) ctt.getChrgsInf().get(0)).getAmt() != null
                                && ((Charges7) ctt.getChrgsInf().get(0)).getAmt() != null) {
                            transaction
                                    .setChrgsInf_Amt(((Charges7) ctt.getChrgsInf().get(0)).getAmt().getValue().toString());
                        }
                    }
                    if (ctt.getInstgAgt() != null && ctt.getInstgAgt().getFinInstnId() != null) {
                        transaction.setBicSender(ctt.getInstgAgt().getFinInstnId().getBICFI());
                        if (ctt.getInstgAgt().getFinInstnId().getClrSysMmbId() != null) {
                            transaction
                                    .setCodeBankSender(ctt.getInstgAgt().getFinInstnId().getClrSysMmbId().getMmbId());
                            if (ctt.getInstgAgt().getFinInstnId().getClrSysMmbId().getClrSysId() != null) {
                                transaction.setInstgAgt_Prtry(
                                        ctt.getInstgAgt().getFinInstnId().getClrSysMmbId().getClrSysId().getPrtry());
                            }
                        }
                    }

                    if (ctt.getInstdAgt() != null && ctt.getInstdAgt().getFinInstnId() != null) {
                        transaction.setBicReceiver(ctt.getInstdAgt().getFinInstnId().getBICFI());
                        if (ctt.getInstdAgt().getFinInstnId().getClrSysMmbId() != null) {
                            transaction
                                    .setCodeBankReceiver(
                                            ctt.getInstdAgt().getFinInstnId().getClrSysMmbId().getMmbId());
                            if (ctt.getInstdAgt().getFinInstnId().getClrSysMmbId().getClrSysId() != null) {
                                transaction.setInstdAgt_Prtry(
                                        ctt.getInstdAgt().getFinInstnId().getClrSysMmbId().getClrSysId().getPrtry());
                            }
                        }
                    }

                    if (ctt.getDbtr() != null) {
                        transaction.setFullNameSender(ctt.getDbtr().getNm());
                        if (ctt.getDbtr().getPstlAdr() != null)
                            transaction.setDebetor_PstlAdr(ctt.getDbtr().getPstlAdr().toString());
                        if (ctt.getDbtr().getCtctDtls() != null) {
                            transaction.setDebetor_CtcDtls(ctt.getDbtr().getCtctDtls().toString());
                        }
                    }
                    if (ctt.getDbtrAcct() != null && ctt.getDbtrAcct().getId() != null) {
                        transaction.setDebetorAcct_IBAN(ctt.getDbtrAcct().getId().getIBAN());
                        if (ctt.getDbtrAcct().getId().getOthr() != null) {
                            transaction.setRibSender(ctt.getDbtrAcct().getId().getOthr().getId());
                        }
                    }

                    if (ctt.getDbtrAcct() != null && ctt.getDbtrAcct().getTp() != null) {
                        transaction.setTp(ctt.getDbtrAcct().getTp().getPrtry());
                    }

                    if (ctt.getDbtrAgt() != null && ctt.getDbtrAgt().getFinInstnId() != null) {
                        if (ctt.getDbtrAgt().getFinInstnId().getClrSysMmbId() != null) {
                            transaction.setCodeDbAgt(ctt.getDbtrAgt().getFinInstnId().getClrSysMmbId().getMmbId());
                        } else {
                            transaction.setCodeDbAgt(ctt.getDbtrAgt().getFinInstnId().getBICFI());
                        }

                    }

                    if (ctt.getCdtrAgt() != null && ctt.getCdtrAgt().getFinInstnId() != null) {
                        if (ctt.getCdtrAgt().getFinInstnId().getClrSysMmbId() != null) {
                            transaction.setCodeCdAgt(ctt.getCdtrAgt().getFinInstnId().getClrSysMmbId().getMmbId());
                        } else {
                            transaction.setCodeCdAgt(ctt.getCdtrAgt().getFinInstnId().getBICFI());
                        }
                    }

                    if (ctt.getCdtr() != null) {
                        transaction.setFullNameReceiver(ctt.getCdtr().getNm());
                    }
                    if (ctt.getCdtrAcct() != null && ctt.getCdtrAcct().getId() != null) {
                        transaction.setCdtrAcct_IBAN(ctt.getCdtrAcct().getId().getIBAN());
                        if (ctt.getCdtrAcct().getId().getOthr() != null) {
                            transaction.setRibReceiver(ctt.getCdtrAcct().getId().getOthr().getId());
                        }
                    }

                    // TODO
                    if (ctt.getInstrForCdtrAgt() != null && !ctt.getInstrForCdtrAgt().isEmpty()) {
                        if (ctt.getInstrForCdtrAgt().get(0) != null) {
                            transaction.setInstrForCdtAgt(ctt.getInstrForCdtrAgt().get(0).getInstrInf());
                        }
                    }

                    pacs008Payload.getTransactions().add(transaction);
                }
            }
        }

        return pacs008Payload;
    }


    /**
     * This method allows to convert a 008 Payload to XML.
     *
     * @param pacs008Payload
     * @return
     * @throws UnsupportedEncodingException
     */
    public String toXmlString(Pacs008Payload pacs008Payload) throws UnsupportedEncodingException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Document document = build(pacs008Payload);
        generate(document, stream);
        return stream.toString(StandardCharsets.ISO_8859_1.name());
    }
}
