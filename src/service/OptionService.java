package service;

import model.cars.AbstractCar;
import model.enums.Options;

import java.util.Set;

public class OptionService implements Service<Set<Options>> {

    @Override
    public AbstractCar changeCar(AbstractCar car, Set<Options> options) {
        car.setOptions(options);
        return car;
    }

    public AbstractCar addOption(AbstractCar car, Options option) {
        car.addOption(option);
        return car;
    }

    public AbstractCar removeOption(AbstractCar car, Options option) {
        if (!car.removeOption(option)) {
            System.out.println("Option not installed and can not be removed.");
        }
        return car;
    }

}
