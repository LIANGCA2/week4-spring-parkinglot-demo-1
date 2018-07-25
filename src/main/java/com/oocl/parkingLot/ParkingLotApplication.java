package com.oocl.parkingLot;

import com.oocl.parkingLot.model.ParkingBoy;
import com.oocl.parkingLot.model.ParkingLot;
import com.oocl.parkingLot.model.Receipt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ParkingLotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingLotApplication.class, args);
	}

	@Bean
	public static List<ParkingLot> allParkingLot(){
		List<ParkingLot> parkingLotList = new ArrayList<>();
		parkingLotList.add(new ParkingLot(1,1));
		parkingLotList.add(new ParkingLot(2,1));
		parkingLotList.add(new ParkingLot(3,1));
		parkingLotList.add(new ParkingLot(4,3));
		parkingLotList.add(new ParkingLot(5,2));
		parkingLotList.add(new ParkingLot(6,3));
		return parkingLotList;
	}

	public static List<ParkingBoy> allParkingBoy(){
		List<ParkingBoy> parkingBoyList = new ArrayList<>();
		parkingBoyList.add(new ParkingBoy(1));
		parkingBoyList.add(new ParkingBoy(2));
		parkingBoyList.add(new ParkingBoy(3));
		parkingBoyList.add(new ParkingBoy(4));
		parkingBoyList.add(new ParkingBoy(5));
		parkingBoyList.add(new ParkingBoy(6));
		return parkingBoyList;
	}
	public static List<Receipt> allReceipt(){
		return new ArrayList<>();
	}
}
