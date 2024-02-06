package ma.ip.dto.dic;

import lombok.Data;
import ma.ip.enums.FlowEnum;
import ma.ip.exceptions.ValidationError;

import java.time.LocalDateTime;
import java.util.List;

/**
 * class PayLoadMessage
 * @author WZAIDOUH
 */
@Data
public class PayLoadMessage {

    private byte[] content;

    private LocalDateTime depositTime;

    private boolean isValid;

    private String codeBankCtx;

    private FlowEnum type;

    private String canal;

    private List<ValidationError> validationErrorsList;
}
