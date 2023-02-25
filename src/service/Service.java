package service;

import model.cars.AbstractCar;

public interface Service<T> {
    AbstractCar changeCar(AbstractCar car, T o);
}
