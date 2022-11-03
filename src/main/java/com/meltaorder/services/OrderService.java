package com.meltaorder.services;

import com.meltaorder.dto.request.OrderRequest;

public interface OrderService {
  void sendMessage(OrderRequest orderRequest);
  void sendMessage(String string);
}
