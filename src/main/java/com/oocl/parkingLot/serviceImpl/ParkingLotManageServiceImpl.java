package com.oocl.parkingLot.serviceImpl;

import com.oocl.parkingLot.ParkingLotApplication;
import com.oocl.parkingLot.Util.GenerateUtil;
import com.oocl.parkingLot.model.Order;
import com.oocl.parkingLot.model.ParkingBoy;
import com.oocl.parkingLot.model.ParkingLot;
import com.oocl.parkingLot.model.Receipt;
import com.oocl.parkingLot.service.ParkingLotManageService;
import org.springframework.stereotype.Service;

import javax.rmi.CORBA.Util;
import java.util.List;

@Service("parkingLotManageService")
public class ParkingLotManageServiceImpl implements ParkingLotManageService {
    private List<ParkingLot> parkingLotList = ParkingLotApplication.allParkingLot();
    private List<ParkingBoy> parkingBoyList = ParkingLotApplication.allParkingBoy();
    private List<Order> orderList = ParkingLotApplication.allOrder();
    @Override
    public List<ParkingLot> findAllParkingLot() {
        return parkingLotList;
    }

    @Override
    public List<ParkingBoy> findAllParkingBoy() {
        return parkingBoyList;
    }

    @Override
    public ParkingLot giveParkingLotToParkingBoy(Integer parkingBoyId, ParkingLot parkingLot) {
       for(int i =0;i<parkingLotList.size();i++){
           if(parkingLotList.get(i).getId()==parkingLot.getId()){
               parkingLotList.get(i).setParkingBoyId(parkingBoyId);
               return parkingLotList.get(i);
           }
       }
        return null;
    }

    @Override
    public List<ParkingLot> addParkingLot(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
        return parkingLotList;
    }

    @Override
    public List<ParkingBoy> addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoyList.add(parkingBoy);
        return parkingBoyList;
    }

    @Override
    public Receipt getReceipt() {
      Receipt receipt = new Receipt();
      receipt.setId(GenerateUtil.genenerateUUID());
        return receipt;
    }

    @Override
    public Order addOrder(Order order) {
        orderList.add(order);
        return order;
    }
}
