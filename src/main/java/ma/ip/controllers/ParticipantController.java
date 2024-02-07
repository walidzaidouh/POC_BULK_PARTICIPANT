package ma.ip.controllers;

import lombok.AllArgsConstructor;
import ma.ip.dto.ParticipantPayloadDTO;
import ma.ip.dto.responses.ReceiveMessageResponseDto;
import ma.ip.services.ReceiverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/participant")
@AllArgsConstructor
public class ParticipantController {

    private ReceiverService receiverService;

    @PostMapping(value = "/receive", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<ReceiveMessageResponseDto> receive(@RequestBody ParticipantPayloadDTO participantPayloadDTO)  {
        return ResponseEntity.ok(receiverService.receive(participantPayloadDTO.getContent(), participantPayloadDTO.getFlowEnum()));
    }


}
