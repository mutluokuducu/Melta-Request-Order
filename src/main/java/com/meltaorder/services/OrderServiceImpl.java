package com.meltaorder.services;

import com.meltaorder.dto.request.OrderRequest;
import com.meltaorder.producer.ProducerMQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private ProducerMQ producer;

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

  public void sendMessage(OrderRequest orderRequest) {
    producer.sendMessage(orderRequest);
    LOGGER.info("Send msg :" + orderRequest);

  }

  @Override
  public void sendMessage(String string) {
    producer.sendMessage(string);
  }
}
