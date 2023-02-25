package factories;

import model.cars.AbstractCar;
import model.enums.*;
import model.specialConfiguration.CarSpecialConfiguration;
import model.enums.colours.CarColour;
import model.enums.engineVolumes.CarEngineVolume;
import model.enums.models.CarModel;
import model.enums.wheelSizes.CarWheelSize;

import java.util.*;

import static java.lang.String.format;

public abstract class AbstractFactory<
        M extends CarModel,
        E extends CarEngineVolume,
        C extends CarColour,
        W extends CarWheelSize,
        S extends CarSpecialConfiguration> {

    private final CarColour[] colour;
    private final CarModel[] model;
    private final CarWheelSize[] wheelSize;
    private final CarEngineVolume[] engineVolume;
    private final List<AbstractCar> storage = new ArrayList<>();

    public AbstractFactory(
            CarColour[] colour,
            CarModel[] model,
            CarWheelSize[] wheelSize,
            CarEngineVolume[] engineVolume
    ) {
        this.colour = colour;
        this.model = model;
        this.wheelSize = wheelSize;
        this.engineVolume = engineVolume;
    }

    public abstract AbstractCar createCar(
            M model,
            E engineVolume,
            C colour,
            W wheelSize,
            Set<Options> option,
            S specialConfiguration
    );


    public void addCarToStorage(AbstractCar car) {
        synchronized (storage) {
            storage.add(car);
        }
    }

    public AbstractCar getCarFromStorage(
            CarModel model,
            CarEngineVolume engineVolume,
            CarColour color,
            CarWheelSize wheelSize,
            Set<Options> option
    ) {
        synchronized (storage) {
            Iterator<AbstractCar> iterator = storage.listIterator();
            AbstractCar car = null;
            while (iterator.hasNext()) {
                AbstractCar temp = iterator.next();
                if (temp.getModel() == model && temp.getEngineVolume() == engineVolume) {
                    if (car == null) {
                        car = temp;
                        iterator.remove();
                        continue;
                    }
                    if (temp.getColour() == color && car.getColour() != color) {
                        iterator.remove();
                        car = temp;
                        continue;
                    }
                    if (temp.getWheelSize() == wheelSize && car.getWheelSize() != wheelSize) {
                        iterator.remove();
                        car = temp;
                        continue;
                    }
                    if (temp.getOptions().equals(option) && !car.getOptions().equals(option)) {
                        iterator.remove();
                        car = temp;
                    }
                }
            }
            return car;
        }
    }

    public String getConfigurations() {
        return format(
                Arrays.toString(colour),
                Arrays.toString(model),
                Arrays.toString(wheelSize),
                Arrays.toString(engineVolume)
        );
    }

    public abstract void fillStorageWithCars();

}
