package model.cars;

import exeptions.WrongColourException;
import exeptions.WrongWheelSizeException;
import model.enums.Options;
import model.enums.colours.CarColour;
import model.enums.engineVolumes.CarEngineVolume;
import model.enums.models.CarModel;
import model.enums.wheelSizes.CarWheelSize;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractCar {

    private final LocalDate date = LocalDate.now();
    private final CarModel model;
    private final CarEngineVolume engineVolume;
    protected CarColour colour;
    protected CarWheelSize wheelSize;
    private Set<Options> options;


    public AbstractCar(CarModel model, CarEngineVolume engineVolume, CarColour color,
                       CarWheelSize wheelSize, Set<Options> options) {
        this.model = model;
        this.engineVolume = engineVolume;
        this.colour = color;
        this.wheelSize = wheelSize;

        if (options != null && !options.isEmpty()) {
            this.options = options;
        } else {
            this.options = new HashSet<>();
        }
    }
    public abstract void changeColor(CarColour color) throws WrongColourException;

    public abstract void changeWheelSize(CarWheelSize wheelSize) throws WrongWheelSizeException;

    public void addOption(Options option) {
        options.add(option);
    }

    public boolean removeOption(Options option) {
        return options.remove(option);
    }

    public CarColour getColour() {
        return colour;
    }

    public CarModel getModel() {
        return model;
    }

    public CarWheelSize getWheelSize() {
        return wheelSize;
    }

    public CarEngineVolume getEngineVolume() {
        return engineVolume;
    }

    public Set<Options> getOptions() {
        return options;
    }

    public void setColour(CarColour colour) {
        this.colour = colour;
    }

    public void setWheelSize(CarWheelSize wheelSize) {
        this.wheelSize = wheelSize;
    }

    public void setOptions(Set<Options> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "year=" + date.getYear() +
                ", model=" + model +
                ", engineVolume=" + engineVolume +
                ", color=" + colour +
                ", wheelSize=" + wheelSize +
                ", option=" + options;
    }

}
