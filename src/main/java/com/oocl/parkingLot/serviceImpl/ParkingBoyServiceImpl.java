package com.oocl.parkingLot.serviceImpl;

import com.oocl.parkingLot.ParkingLotApplication;
import com.oocl.parkingLot.model.Order;
import com.oocl.parkingLot.model.ParkingBoy;
import com.oocl.parkingLot.model.ParkingLot;
import com.oocl.parkingLot.service.OrderService;
import com.oocl.parkingLot.service.ParkingBoyService;
import com.oocl.parkingLot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("parkingBoyService")
public class ParkingBoyServiceImpl implements ParkingBoyService {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ParkingLotService parkingLotService;
    private List<ParkingBoy> parkingBoyList = ParkingLotApplication.allParkingBoy();

    @Override
    public List<ParkingBoy> findAllParkingBoy() {
        return parkingBoyList;
    }

    @Override
    public List<ParkingBoy> addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoyList.add(parkingBoy);
        return parkingBoyList;
    }

    @Override
    public Order parkCar(String orderId, ParkingBoy parkingBoy) throws Exception {
        ParkingLot parkingLot = parkingLotService.findNotFullParkingLot(parkingBoy);
        parkingLotService.ReduceParkingLotRemainSize(parkingLot);
        orderService.updateOrder(orderId, parkingLot.getId());

        return orderService.findOrderById(orderId);


    }
}
