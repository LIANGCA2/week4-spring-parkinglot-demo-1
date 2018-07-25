package com.oocl.parkingLot.service;

import com.oocl.parkingLot.model.Order;
import com.oocl.parkingLot.model.Receipt;

import java.util.List;

public interface OrderService {

    Receipt getReceipt();

    Order addOrder(Order order) throws Exception;

    List<Order> getOrderByStatus();
}
