package com.radkoff26.springchatasynctask.controllers;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.radkoff26.springchatasynctask.domain.dto.QueueMessage;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/send")
@Log4j2
public class RabbitMQController {
    private final AmqpTemplate amqpTemplate;

    public RabbitMQController(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void postMessage(@RequestBody QueueMessage body) {
        log.info("In controller: " + body);
        amqpTemplate.convertAndSend("tasks", body);
    }
}
