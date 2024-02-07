package ma.ip.dto;

import lombok.Data;
import ma.ip.enums.FlowEnum;

import java.io.Serializable;


@Data
public class ParticipantPayloadDTO implements Serializable {

    private String content;
    private FlowEnum flowEnum;
}
