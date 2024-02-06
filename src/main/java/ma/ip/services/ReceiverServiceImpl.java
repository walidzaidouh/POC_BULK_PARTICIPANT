package ma.ip.services;

import lombok.extern.slf4j.Slf4j;
import ma.ip.dto.dic.pacs002.Pacs002Payload;
import ma.ip.dto.dic.pacs008.Pacs008Payload;
import ma.ip.dto.responses.ReceiveMessageResponseDto;
import ma.ip.enums.FlowEnum;
import ma.ip.exceptions.ValidationErrorHandler;
import ma.ip.services.helper.Pacs002MessageHelper;
import ma.ip.services.helper.Pacs008MessageHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class ReceiverServiceImpl implements ReceiverService {

    @Value("${repo.path}")
    private String repoPath;

    @Override
    public ReceiveMessageResponseDto receive(MultipartFile file, FlowEnum flowEnum) throws IOException {
        ReceiveMessageResponseDto receiveMessageResponse = new ReceiveMessageResponseDto();
        String content = new String(file.getBytes(), StandardCharsets.ISO_8859_1).trim();

        switch (flowEnum) {
            case PACS008:
                receiveMessageResponse = this.receivePacs008(content);
                break;

            case PACS002:
                receiveMessageResponse = this.receivePacs002(content);
                break;

            case PACS028:
                // TODO
                break;

            default:
                receiveMessageResponse.setValid(false);
                receiveMessageResponse.setDescription("flow.file.message.type.not.found");
                receiveMessageResponse.setDescriptionForCustomer("flow.file.message.type.not.found");
                receiveMessageResponse.setStatusCode(String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY));
        }
        return receiveMessageResponse;
    }

    public ReceiveMessageResponseDto receivePacs008(String content){
        ReceiveMessageResponseDto message008 = new ReceiveMessageResponseDto();
        message008.setFlowEnum(FlowEnum.PACS008);
        Pacs008MessageHelper pacs008MessageHelper = new Pacs008MessageHelper();
        ValidationErrorHandler validationError = pacs008MessageHelper.validate(content);
        if (validationError.hasNoErrors()){
            message008.setValid(true);
            Pacs008Payload pacs008Payload = pacs008MessageHelper.parse(content);
            message008.setMsgId(pacs008Payload.getMsgId());
            message008.setNbOfTxs(pacs008Payload.getNbOfTxs());
            log.info(" Pacs008Payload is {}", pacs008Payload);
            if (!CollectionUtils.isEmpty(pacs008Payload.getTransactions())){
                pacs008Payload.getTransactions().forEach(transaction->{
                    log.info("    Transaction is {}", transaction);
                });
            }


            String rootDirectoryName = repoPath + File.separator + pacs008Payload.getTransactions().get(0).getCodeBankSender();
            String nestedDirectoryName = FlowEnum.PACS008.toString();

            String rootDirectoryPath = rootDirectoryName;
            String nestedDirectoryPath = rootDirectoryPath + File.separator + nestedDirectoryName;
            File rootDirectory = new File(rootDirectoryPath);
            File nestedDirectory = new File(nestedDirectoryPath);

            if (!rootDirectory.exists()) {
                if (rootDirectory.mkdir()) {
                    log.info("Root directory has been created: " + rootDirectory.getAbsolutePath());
                } else {
                    log.warn("Error creating the root directory.");
                }
            }

            if (!nestedDirectory.exists()) {
                if (nestedDirectory.mkdir()) {
                    log.info("Nested directory has been created: " + nestedDirectory.getAbsolutePath());
                } else {
                    log.warn("Error creating the nested directory.");
                }
            }

            String filePath = nestedDirectory.getAbsolutePath() + File.separator + pacs008Payload.getMsgId() + ".xml";

            try {
                File file = new File(filePath);
                if (file.createNewFile()) {
                    log.info("File has been created: " + file.getAbsolutePath());
                }

                FileWriter writer = new FileWriter(file);
                writer.write(content);
                writer.close();

                log.info("Content 008 added to the file successfully.");

            } catch (IOException e) {
                e.printStackTrace();
            }


        } else {
            message008.setValid(false);
            message008.setError(true);
            message008.setDescription("message.not.valide");
            message008.setDescriptionForCustomer("message.not.valide");
        }
        return message008;
    }

    public ReceiveMessageResponseDto receivePacs002(String content){
        ReceiveMessageResponseDto message002 = new ReceiveMessageResponseDto();
        message002.setFlowEnum(FlowEnum.PACS002);
        Pacs002MessageHelper pacs002MessageHelper = new Pacs002MessageHelper();
        ValidationErrorHandler validationError = pacs002MessageHelper.validate(content);
        if (validationError.hasNoErrors()){
            message002.setValid(true);
            Pacs002Payload pacs002Payload = pacs002MessageHelper.parse(content);
            message002.setMsgId(pacs002Payload.getMsgId());
            log.info(" Pacs002Payload is {}", pacs002Payload);
            if (!CollectionUtils.isEmpty(pacs002Payload.getPaymentTransactions())){
                pacs002Payload.getPaymentTransactions().forEach(paymentTransaction->{
                    log.info("    Transaction is {}", paymentTransaction);
                });
            }


            String rootDirectoryName = "VIRM_MASS_Switch" + File.separator + pacs002Payload.getPaymentTransactions().get(0).getInstgAgt_MbrId();
            String nestedDirectoryName = FlowEnum.PACS002.toString();

            String rootDirectoryPath = rootDirectoryName;
            String nestedDirectoryPath = rootDirectoryPath + File.separator + nestedDirectoryName;
            File rootDirectory = new File(rootDirectoryPath);
            File nestedDirectory = new File(nestedDirectoryPath);

            if (!rootDirectory.exists()) {
                if (rootDirectory.mkdir()) {
                    log.info("Root directory has been created: " + rootDirectory.getAbsolutePath());
                } else {
                    log.warn("Error creating the root directory.");
                }
            }

            if (!nestedDirectory.exists()) {
                if (nestedDirectory.mkdir()) {
                    log.info("Nested directory has been created: " + nestedDirectory.getAbsolutePath());
                } else {
                    log.warn("Error creating the nested directory.");
                }
            }

            String filePath = nestedDirectory.getAbsolutePath() + File.separator + pacs002Payload.getMsgId() + ".xml";

            try {
                File file = new File(filePath);
                if (file.createNewFile()) {
                    log.info("File has been created: " + file.getAbsolutePath());
                }

                FileWriter writer = new FileWriter(file);
                writer.write(content);
                writer.close();

                log.info("Content 002 added to the file successfully.");

            } catch (IOException e) {
                e.printStackTrace();
            }


        } else {
            message002.setValid(false);
            message002.setError(true);
            message002.setDescription("message.not.valide");
            message002.setDescriptionForCustomer("message.not.valide");
        }
        return message002;
    }

}
