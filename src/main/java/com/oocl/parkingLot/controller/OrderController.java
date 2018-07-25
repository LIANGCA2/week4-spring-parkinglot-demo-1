package com.oocl.parkingLot.controller;

import com.oocl.parkingLot.model.Order;
import com.oocl.parkingLot.model.ParkingBoy;
import com.oocl.parkingLot.model.Receipt;
import com.oocl.parkingLot.service.OrderService;
import com.oocl.parkingLot.service.ParkingBoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ParkingBoyService parkingBoyService;

    @GetMapping("receipt")
    public Receipt getReceipt(){
        return orderService.getReceipt();
    }


    @PostMapping("order")
    public Order addOrder(@RequestBody Order order) throws Exception {
        return orderService.addOrder(order);
    }
    @GetMapping("order")
    public List<Order> getValidOrder(){
        return orderService.getValidOrder();
    }
    @PutMapping("order/{orderId}")
    public Order updateorderStatus(@PathVariable String orderId,@RequestBody ParkingBoy parkingBoy) throws Exception {
        return parkingBoyService.parkCar(orderId,parkingBoy);

    }
}
