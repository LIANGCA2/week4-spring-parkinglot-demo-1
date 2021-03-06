package com.oocl.parkingLot.serviceImpl;

import com.oocl.parkingLot.ParkingLotApplication;
import com.oocl.parkingLot.Util.GenerateUtil;
import com.oocl.parkingLot.model.Order;
import com.oocl.parkingLot.model.Receipt;
import com.oocl.parkingLot.service.OrderService;
import com.oocl.parkingLot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("orderService")
public class OrderServiceImpl  implements OrderService {
    @Autowired
    private ParkingLotService parkingLotService;
    private List<Order> orderList = ParkingLotApplication.allOrder();
    private List<Receipt> receiptList = ParkingLotApplication.allReceipt();
    @Override
    public Receipt getReceipt() {
        Receipt receipt = new Receipt();
        receipt.setId(GenerateUtil.genenerateUUID());
        receiptList.add(receipt);
        return receipt;
    }

    @Override
    public Order addOrder(Order order) throws Exception {
        String ReceiptId = order.getReceiptId();
        int i = 0;
        for(i = 0;i<receiptList.size();i++){
            if(receiptList.get(i).getId().equals(ReceiptId)){
                order.setId(GenerateUtil.genenerateUUID());
                order.setStatus(false);
                orderList.add(order);
                return order;
            }
        }

        throw new Exception("该小票不存在");
    }

    @Override
    public List<Order> getValidOrder() {
        return orderList.stream().filter(item->!item.getStatus()).collect(Collectors.toList());
    }

    @Override
    public Boolean updateOrder(String orderId,Integer parkingLotId) throws Exception {
        List<Order> validOrder =getValidOrder();
        for(int i =0;i<validOrder.size();i++){
            if(validOrder.get(i).getId().equals(orderId)){
                Order order = validOrder.get(i);
                order.setStatus(true);
                order.setParkingLotId(parkingLotId);
               return true;
            }
        }
        throw new Exception("没有该订单");
    }

    @Override
    public Order findOrderById(String orderId) {
        return orderList.stream().filter(item->item.getId().equals(orderId)).collect(Collectors.toList()).get(0);
    }

    @Override
    public String deleteReceipt(String receiptId) throws Exception {

        Order orderByReceipt = findOrderByReceipt(receiptId);
        if(findReceipt(receiptId)){
            parkingLotService.unpark(orderByReceipt.getParkingLotId());
            for(int i = 0;i<receiptList.size();i++){
                if(receiptList.get(i).getId().equals(receiptId)){
                    receiptList.remove(i);
                    break;
                }
            }
            return "取车成功";
        }
        else{
            throw new Exception("无效的小票");
        }
    }

    private Order findOrderByReceipt(String receiptId) throws Exception {
         if(orderList.stream().filter(item->item.getReceiptId().equals(receiptId)).collect(Collectors.toList()).size()>0){
            return orderList.stream().filter(item->item.getReceiptId().equals(receiptId)).collect(Collectors.toList()).get(0);
         }else{
             throw new Exception("没有该订单");
         }
    }

    private boolean findReceipt(String receiptId) {
        return receiptList.stream().filter(item->item.getId().equals(receiptId)).collect(Collectors.toList()).size()>0;
    }
}
