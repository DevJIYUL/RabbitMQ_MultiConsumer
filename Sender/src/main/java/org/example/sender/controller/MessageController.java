package org.example.sender.controller;

import lombok.RequiredArgsConstructor;
import org.example.sender.dto.MessageDto;
import org.example.sender.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class MessageController {

    private final Sender sender;
    @PostMapping("/send")
    public MessageDto PostMessage(){

        sender.sendMessage(new MessageDto("메세지 send","Testing data"));
        return new MessageDto("메세지 send","Testing data");
    }
}
