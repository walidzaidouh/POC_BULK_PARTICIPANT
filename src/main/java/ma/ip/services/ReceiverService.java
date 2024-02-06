package ma.ip.services;

import ma.ip.dto.responses.ReceiveMessageResponseDto;
import ma.ip.enums.FlowEnum;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ReceiverService {

    ReceiveMessageResponseDto receive(MultipartFile file, FlowEnum typeMsg) throws IOException;

}
