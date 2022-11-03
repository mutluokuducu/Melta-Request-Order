package com.meltaorder.producer;

import com.meltaorder.dto.request.OrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerMQ {

  @Value("${rabbitmq.exchange.name}")
  private String exchange;

  @Value("${rabbitmq.routing.key}")
  private String routingKey;

  @Autowired
  private AmqpTemplate rabbitTemplate;

  private static final Logger LOGGER = LoggerFactory.getLogger(ProducerMQ.class);

  public void sendMessage(OrderRequest orderRequest) {
    rabbitTemplate.convertAndSend(exchange, routingKey, orderRequest);
    LOGGER.info("Send msg :" + orderRequest);

  }

  public void sendMessage(String message) {
    rabbitTemplate.convertAndSend(exchange, routingKey, message);
    LOGGER.info("Send msg :" + message);

  }
}
