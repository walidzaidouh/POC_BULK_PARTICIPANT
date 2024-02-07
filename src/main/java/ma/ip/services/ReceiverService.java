package ma.ip.services;

import ma.ip.dto.responses.ReceiveMessageResponseDto;
import ma.ip.enums.FlowEnum;
import org.springframework.web.multipart.MultipartFile;


public interface ReceiverService {

    ReceiveMessageResponseDto receive(String content, FlowEnum typeMsg) ;

}
