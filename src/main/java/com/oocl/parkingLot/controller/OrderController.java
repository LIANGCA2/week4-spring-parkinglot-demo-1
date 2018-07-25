package com.oocl.parkingLot.controller;

import com.oocl.parkingLot.model.Order;
import com.oocl.parkingLot.model.Receipt;
import com.oocl.parkingLot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("receipt")
    public Receipt getReceipt(){
        return orderService.getReceipt();
    }


    @PostMapping("order")
    public Order addOrder(@RequestBody Order order) throws Exception {
        return orderService.addOrder(order);
    }
    @GetMapping("order")
    public List<Order> getOrderByStatus(){
        return orderService.getOrderByStatus();
    }
}
