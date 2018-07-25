"# week4-spring-parkinglot-demo-1" 
##1.创建parkingLot
```java
path:/parkinglots
request:{ParkingLot}
response:{List<ParkingLot>}
controller:
@PostMapping("parkinglots")
    public List<ParkingLot> addParkingLot(@RequestBody ParkingLot parkingLot){
        return parkingLotManageService.addParkingLot(parkingLot);
    }
```
##2.创建parkingBoy
```java
path:/parkingBoys
requset:{ParkingBoy}
response:{List<ParkingBoy>}
controller:
@PostMapping("parkingBoys")
    public List<ParkingBoy> addParking(@RequestBody ParkingBoy parkingBoy){
        return parkingLotManageService.addParkingBoy(parkingBoy);
    }

```
##3.更新管理parkinglot的parkingBoy
```java
path:/parkingBoys/{parkingBoyId}/parkingLots
requset:{ParkingLot}
response:{ParkingLot}
@PostMapping("parkingBoys/{parkingBoyId}/parkingLots")
    public ParkingLot updateParkingLot(@PathVariable Integer parkingBoyId, @RequestBody ParkingLot parkingLot){
        try {
            return parkingLotManageService.giveParkingLotToParkingBoy(parkingBoyId,parkingLot);
        }catch (Exception e){
            System.out.println("fail to update");
            return null;
        }

    }
```

   