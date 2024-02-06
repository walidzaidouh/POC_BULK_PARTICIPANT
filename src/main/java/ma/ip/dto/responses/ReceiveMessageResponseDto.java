package ma.ip.dto.responses;

import lombok.Getter;
import lombok.Setter;
import ma.ip.enums.FlowEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
public class ReceiveMessageResponseDto extends GenericResponse{


    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiveMessageResponseDto.class);

    private FlowEnum flowEnum;
    private String msgId;
    private String NbOfTxs;
    private String txsId;
    private boolean isValid;


    public String toString() {
        return " message " + flowEnum + " msgId " + msgId + " NbOfTxs " + NbOfTxs + " txsId [ " + txsId + " ] isValid " + isValid;
    }
}
