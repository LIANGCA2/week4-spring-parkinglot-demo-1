package com.oocl.parkingLot.serviceImpl;

import com.oocl.parkingLot.ParkingLotApplication;
import com.oocl.parkingLot.Util.GenerateUtil;
import com.oocl.parkingLot.model.Order;
import com.oocl.parkingLot.model.Receipt;
import com.oocl.parkingLot.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("orderService")
public class OrderServiceImpl  implements OrderService {
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
    public List<Order> getOrderByStatus() {
        return orderList.stream().filter(item->!item.getStatus()).collect(Collectors.toList());
    }
}
