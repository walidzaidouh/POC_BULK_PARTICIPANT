package ma.ip.controllers;

import lombok.AllArgsConstructor;
import ma.ip.dto.responses.ReceiveMessageResponseDto;
import ma.ip.enums.FlowEnum;
import ma.ip.services.ReceiverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class SwitchController {

    private ReceiverService receiverService;

    @PostMapping(value = "/receive", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<ReceiveMessageResponseDto> receive(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "typeMsg") FlowEnum flowEnum) throws IOException {
        ReceiveMessageResponseDto response = receiverService.receive(file, flowEnum);
        return ResponseEntity.ok(response);
    }
}
