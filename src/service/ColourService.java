package service;

import exeptions.WrongColourException;
import model.cars.AbstractCar;
import model.enums.colours.CarColour;

public class ColourService implements Service<CarColour> {

    @Override
    public AbstractCar changeCar(AbstractCar car, CarColour colour) {
        try {
            car.changeColor(colour);
        } catch (WrongColourException e) {
            System.err.println(e.getMessage());
        }
        return car;
    }
}