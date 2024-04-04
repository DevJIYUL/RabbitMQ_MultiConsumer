package org.example.receiver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.receiver.dto.MessageDto;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;



@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiverService {
    @RabbitListener(queues = "sample.queue")
    public void receiveMessage(MessageDto msg){
        System.out.println(msg);
        log.info("Message receive : ",msg.getTitle()+" "+msg.getContent());
    }
    @RabbitListener(queues = "sample.queue")
    public void receive2Message(MessageDto msg){
        System.out.println(msg);
        log.info("Message receive 2222: ",msg.getTitle()+" "+msg.getContent());
    }
}
