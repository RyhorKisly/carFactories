package service;

import exeptions.WrongWheelSizeException;
import model.cars.AbstractCar;
import model.enums.wheelSizes.CarWheelSize;

public class WheelSizeService implements Service<CarWheelSize> {

    @Override
    public AbstractCar changeCar(AbstractCar car, CarWheelSize wheelSize) {
        try{
            car.changeWheelSize(wheelSize);
        } catch (WrongWheelSizeException e){
            System.err.println(e.getMessage());
        }
        return car;
    }
}
