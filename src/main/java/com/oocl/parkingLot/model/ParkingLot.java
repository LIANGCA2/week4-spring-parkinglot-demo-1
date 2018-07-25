package com.oocl.parkingLot.model;

public class ParkingLot {
    private Integer id;
    private Integer parkingBoyId;

    public ParkingLot() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParkingBoyId() {
        return parkingBoyId;
    }

    public void setParkingBoyId(Integer parkingBoyId) {
        this.parkingBoyId = parkingBoyId;
    }

    public ParkingLot(Integer id, Integer parkingBoyId) {
        this.id = id;
        this.parkingBoyId = parkingBoyId;
    }
}
