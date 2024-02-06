package ma.ip.services.helper;

import lombok.Getter;
import lombok.Setter;
import ma.ip.dto.dic.pacs002.Pacs002Payload;
import ma.ip.dto.dic.pacs002.PaymentTransaction;
import ma.ip.dto.dic.pacs002.pacs_002_001_10.*;
import ma.ip.exceptions.ValidationErrorHandler;
import ma.ip.utils.XmlUtils;
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
import java.nio.charset.StandardCharsets;


@Getter
@Setter
public class Pacs002MessageHelper {


    private static final String PACS002_XSD_FILENAME = "pacs.002.001.10.xsd";
    private static final String JAXB_SCHEMA_LOCATION = "urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10";


    public Document build(Pacs002Payload pacs002Payload) {
        Document document = new Document();
        FIToFIPaymentStatusReportV10 fiToFIPaymentStatusReportV10 = new FIToFIPaymentStatusReportV10();

        GroupHeader91 grpHdr = new GroupHeader91();

        if (pacs002Payload.getMsgId() != null) {
            grpHdr.setMsgId(pacs002Payload.getMsgId());
        }

        if (pacs002Payload.getCreDtTm() != null) {
            grpHdr.setCreDtTm(pacs002Payload.getCreDtTm());
        }
        PaymentTransaction110 pymntTrx = new PaymentTransaction110();
        OriginalGroupInformation29 orgnlGrpInf = new OriginalGroupInformation29();

        for (PaymentTransaction paymentTransaction : pacs002Payload.getPaymentTransactions()) {

            if (paymentTransaction.getOrgnlMsgId() != null) {
                orgnlGrpInf.setOrgnlMsgId(paymentTransaction.getOrgnlMsgId());
                pymntTrx.setOrgnlGrpInf(orgnlGrpInf);
            }

            if (paymentTransaction.getOrgnlMsgNmId() != null) {
                orgnlGrpInf.setOrgnlMsgNmId(paymentTransaction.getOrgnlMsgNmId());
                pymntTrx.setOrgnlGrpInf(orgnlGrpInf);
            }

            if (paymentTransaction.getOrgnlCreDtTm() != null) {
                orgnlGrpInf.setOrgnlCreDtTm(paymentTransaction.getOrgnlCreDtTm());
                pymntTrx.setOrgnlGrpInf(orgnlGrpInf);

            }

            if (paymentTransaction.getOriginalInstrId() != null) {
                pymntTrx.setOrgnlInstrId(paymentTransaction.getOriginalInstrId());
            }

            if (paymentTransaction.getOrgnlEndToEndId() != null) {
                pymntTrx.setOrgnlEndToEndId(paymentTransaction.getOrgnlEndToEndId());
            }

            if (paymentTransaction.getOrgnlTxId() != null) {
                pymntTrx.setOrgnlTxId(paymentTransaction.getOrgnlTxId());

            }

            if (paymentTransaction.getOrgnlUETR() != null) {
                pymntTrx.setOrgnlUETR(paymentTransaction.getOrgnlUETR());
            }

            if (paymentTransaction.getTxSts() != null) {
                pymntTrx.setTxSts(paymentTransaction.getTxSts());
            }

            StatusReasonInformation12 statusReasonInfo = new StatusReasonInformation12();
            StatusReason6Choice rsn = new StatusReason6Choice();
            if (paymentTransaction.getRsn() != null) {
                rsn.setCd(paymentTransaction.getRsn());
            }
            if (paymentTransaction.getAddtlInf() != null && !paymentTransaction.getAddtlInf().isEmpty()) {
                statusReasonInfo.setAddtlInf(paymentTransaction.getAddtlInf());
            }
            if (rsn.getCd() != null) {
                statusReasonInfo.setRsn(rsn);
            }

            if (paymentTransaction.getAccptncDtTm() != null) {
                pymntTrx.setAccptncDtTm(paymentTransaction.getAccptncDtTm());
            }

            if (paymentTransaction.getClrSysRef() != null) {
                pymntTrx.setClrSysRef(paymentTransaction.getClrSysRef());
            }

            BranchAndFinancialInstitutionIdentification6 instgAgt = new BranchAndFinancialInstitutionIdentification6();
            FinancialInstitutionIdentification18 finInstId = new FinancialInstitutionIdentification18();
            ClearingSystemMemberIdentification2 clrSysMmbrId = new ClearingSystemMemberIdentification2();
            ClearingSystemIdentification2Choice clrSysId = new ClearingSystemIdentification2Choice();

            if (paymentTransaction.getInstgAgt_BicFi() != null) {
                finInstId.setBICFI(paymentTransaction.getInstgAgt_BicFi());
            }

            if (paymentTransaction.getInstgAgt_Prtry() != null) {
                clrSysId.setPrtry(paymentTransaction.getInstgAgt_Prtry());
                clrSysMmbrId.setClrSysId(clrSysId);
            }

            if (paymentTransaction.getInstgAgt_MbrId() != null) {
                clrSysMmbrId.setMmbId(paymentTransaction.getInstgAgt_MbrId());
            }
            if (clrSysMmbrId.getMmbId() != null) {
                finInstId.setClrSysMmbId(clrSysMmbrId);
            }

            instgAgt.setFinInstnId(finInstId);
            pymntTrx.setInstgAgt(instgAgt);

            BranchAndFinancialInstitutionIdentification6 instdAgt = new BranchAndFinancialInstitutionIdentification6();
            FinancialInstitutionIdentification18 finInstId2 = new FinancialInstitutionIdentification18();
            ClearingSystemMemberIdentification2 clrSysMmbrId2 = new ClearingSystemMemberIdentification2();
            ClearingSystemIdentification2Choice clrSysId2 = new ClearingSystemIdentification2Choice();

            if (paymentTransaction.getInstdAgt_BicFi() != null) {
                finInstId2.setBICFI(paymentTransaction.getInstdAgt_BicFi());
            }

            if (paymentTransaction.getInstdAgt_Prtry() != null) {
                clrSysId2.setPrtry(paymentTransaction.getInstdAgt_Prtry());
                clrSysMmbrId2.setClrSysId(clrSysId2);
            }

            if (paymentTransaction.getInstdAgt_MbrId() != null) {
                clrSysMmbrId2.setMmbId(paymentTransaction.getInstdAgt_MbrId());
            }

            if (clrSysMmbrId2.getMmbId() != null) {
                finInstId2.setClrSysMmbId(clrSysMmbrId2);
            }

            instdAgt.setFinInstnId(finInstId2);
            pymntTrx.setInstdAgt(instdAgt);


            /** if (transactionStatus.getSplmtryData() != null) {
             SupplementaryData1 suppData = new SupplementaryData1();
             suppData.setPlcAndNm(transactionStatus.getSplmtryData());
             pymntTrx.getSplmtryData().add(suppData);
             }
             **/


            if (statusReasonInfo.getRsn() != null) {
                pymntTrx.getStsRsnInf().add(statusReasonInfo);
            }
        }
        fiToFIPaymentStatusReportV10.setGrpHdr(grpHdr);
        fiToFIPaymentStatusReportV10.getTxInfAndSts().add(pymntTrx);
        document.setFIToFIPmtStsRpt(fiToFIPaymentStatusReportV10);
        return document;
    }

    public Pacs002Payload parse(String xmlString) {
        Document document;
        JAXBContext jaxbContext;
        Pacs002Payload pacs002Payload = null;

        try {
            jaxbContext = JAXBContext.newInstance(new Class[]{Document.class});
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            document = (Document) JAXBIntrospector.getValue(unmarshaller.unmarshal(new StringReader(xmlString)));
            pacs002Payload = pacs002PayloadMapper(document);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return pacs002Payload;
    }

    private Pacs002Payload pacs002PayloadMapper(Document document) {
        Pacs002Payload pacs002Payload = new Pacs002Payload();
        if (document != null || document.getFIToFIPmtStsRpt() != null) {

            if (document.getFIToFIPmtStsRpt().getGrpHdr() != null) {
                GroupHeader91 grpHdr = document.getFIToFIPmtStsRpt().getGrpHdr();
                pacs002Payload.setMsgId(grpHdr.getMsgId());
                pacs002Payload.setCreDtTm(grpHdr.getCreDtTm());
            }

            if (document.getFIToFIPmtStsRpt().getTxInfAndSts() != null &&
                    document.getFIToFIPmtStsRpt().getTxInfAndSts().size() > 0) {
                //PaymentTransaction110 pymntTrxInfo = document.getFIToFIPmtStsRpt().getTxInfAndSts().get(0);
                for (PaymentTransaction110 pymntTrxInfo : document.getFIToFIPmtStsRpt().getTxInfAndSts()) {
                    PaymentTransaction paymentTransaction = new PaymentTransaction();
                    if (pymntTrxInfo.getOrgnlGrpInf() != null) {
                        paymentTransaction.setOrgnlMsgId(pymntTrxInfo.getOrgnlGrpInf().getOrgnlMsgId());
                        paymentTransaction.setOrgnlMsgNmId(pymntTrxInfo.getOrgnlGrpInf().getOrgnlMsgNmId());
                        paymentTransaction.setOrgnlCreDtTm(pymntTrxInfo.getOrgnlGrpInf().getOrgnlCreDtTm());

                    }
                    paymentTransaction.setOriginalInstrId(pymntTrxInfo.getOrgnlInstrId());
                    paymentTransaction.setOrgnlEndToEndId(pymntTrxInfo.getOrgnlEndToEndId());
                    paymentTransaction.setOrgnlTxId(pymntTrxInfo.getOrgnlEndToEndId());
                    paymentTransaction.setTxSts(pymntTrxInfo.getTxSts());

                    if (pymntTrxInfo.getStsRsnInf() != null && !pymntTrxInfo.getStsRsnInf().isEmpty()) {
                        if (((StatusReasonInformation12) pymntTrxInfo.getStsRsnInf().get(0)).getRsn() != null) {
                            // Cd
                            if (((StatusReasonInformation12) pymntTrxInfo.getStsRsnInf().get(0)).getRsn().getCd() != null) {
                                paymentTransaction.setRsn(((StatusReasonInformation12) pymntTrxInfo.getStsRsnInf().get(0)).getRsn().getCd());
                            }
                            // Prtry
                            if (((StatusReasonInformation12) pymntTrxInfo.getStsRsnInf().get(0)).getRsn().getPrtry() != null) {
                                paymentTransaction.setRsn(((StatusReasonInformation12) pymntTrxInfo.getStsRsnInf().get(0)).getRsn().getPrtry());
                            }
                        }
                    }
                    paymentTransaction.setAccptncDtTm(pymntTrxInfo.getAccptncDtTm());
                    paymentTransaction.setClrSysRef(pymntTrxInfo.getClrSysRef());

                    if (pymntTrxInfo.getInstgAgt() != null && pymntTrxInfo.getInstgAgt().getFinInstnId() != null) {
                        paymentTransaction.setInstgAgt_BicFi(pymntTrxInfo.getInstgAgt().getFinInstnId().getBICFI());


                        if (pymntTrxInfo.getInstgAgt().getFinInstnId().getClrSysMmbId() != null) {
                            paymentTransaction.setInstgAgt_MbrId(
                                    pymntTrxInfo.getInstgAgt().getFinInstnId().getClrSysMmbId().getMmbId());

                            if (pymntTrxInfo.getInstgAgt().getFinInstnId().getClrSysMmbId().getClrSysId() != null) {
                                paymentTransaction.setInstgAgt_Prtry(
                                        pymntTrxInfo.getInstgAgt().getFinInstnId().getClrSysMmbId().getClrSysId().getCd());
                            }
                        }
                    }
                    if (pymntTrxInfo.getInstdAgt() != null && pymntTrxInfo.getInstdAgt().getFinInstnId() != null) {
                        paymentTransaction.setInstdAgt_BicFi(pymntTrxInfo.getInstdAgt().getFinInstnId().getBICFI());

                        if (pymntTrxInfo.getInstdAgt().getFinInstnId().getClrSysMmbId() != null) {
                            paymentTransaction.setInstdAgt_MbrId(
                                    pymntTrxInfo.getInstdAgt().getFinInstnId().getClrSysMmbId().getMmbId());

                            if (pymntTrxInfo.getInstdAgt().getFinInstnId().getClrSysMmbId().getClrSysId() != null) {
                                paymentTransaction.setInstdAgt_Prtry(
                                        pymntTrxInfo.getInstdAgt().getFinInstnId().getClrSysMmbId().getClrSysId().getCd());
                            }
                        }
                    }
                    paymentTransaction.setOrgnlTxId(pymntTrxInfo.getOrgnlTxId());
                    if (!pymntTrxInfo.getSplmtryData().isEmpty()) {
                        paymentTransaction
                                .setSplmtryData(((SupplementaryData1) pymntTrxInfo.getSplmtryData().get(0)).getPlcAndNm());
                    }
                    pacs002Payload.getPaymentTransactions().add(paymentTransaction);
                }
            }
        }

        return pacs002Payload;
    }

    public void generate(Document document, OutputStream os) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(new Class[]{Document.class});
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty("jaxb.encoding", StandardCharsets.ISO_8859_1.name());
            jaxbMarshaller.setProperty("jaxb.schemaLocation", "urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10");
            if (os instanceof java.io.FileOutputStream)
                jaxbMarshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            jaxbMarshaller.marshal(document, os);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public ValidationErrorHandler validate(String xmlString) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        ValidationErrorHandler validatorHandler = new ValidationErrorHandler();
        try {
            Source schemaSource = new StreamSource(XmlUtils.getFileFromResource("xsd/pacs.002.001.10.xsd"));
            Schema schema = schemaFactory.newSchema(schemaSource);
            Validator validator = schema.newValidator();
            validator.setErrorHandler((ErrorHandler) validatorHandler);
            validator.validate(new StreamSource(new StringReader(xmlString)));

        } catch (SAXException | java.io.IOException e) {
            e.printStackTrace();
        }
        return validatorHandler;
    }

    public String toXmlString(Pacs002Payload pacs002Payload) throws UnsupportedEncodingException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Document document = build(pacs002Payload);
        generate(document, stream);
        return stream.toString(StandardCharsets.ISO_8859_1.name());
    }
}
