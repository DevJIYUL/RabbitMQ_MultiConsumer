package org.example.sender.service;

import lombok.RequiredArgsConstructor;
import org.example.sender.dto.MessageDto;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Sender {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(MessageDto messageDto){
4        rabbitTemplate.convertAndSend("sample.exchange", "sample.key.#", messageDto, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                MessageProperties props = message.getMessageProperties();
                props.setHeader("__TypeId__","org.example.receiver.dto.MessageDto");
                return message;
            }
        });
    }
}
