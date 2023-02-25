package model.cars;

import exeptions.WrongColourException;
import exeptions.WrongWheelSizeException;
import model.enums.Options;
import model.enums.colours.BMWColourEnums;
import model.enums.colours.CarColour;
import model.enums.engineVolumes.BMWEngineVolumeEnums;
import model.enums.models.BMWModelEnums;
import model.enums.specialConfigurationEnums.BMWDiscBrakesEnums;
import model.enums.specialConfigurationEnums.BMWFuelTypeEnums;
import model.enums.wheelSizes.BMWWheelSizeEnums;
import model.enums.wheelSizes.CarWheelSize;

import java.util.Set;

public class BMWCar extends AbstractCar {

    private BMWDiscBrakesEnums discBrakes;
    private BMWFuelTypeEnums fuelType;

    public BMWCar(BMWModelEnums model, BMWEngineVolumeEnums engineVolume, BMWColourEnums color,
                  BMWWheelSizeEnums wheelSize, Set<Options> option, BMWDiscBrakesEnums discBrakes, BMWFuelTypeEnums fuelType) {
        super(model, engineVolume, color, wheelSize, option);
        this.discBrakes = discBrakes;
        this.fuelType = fuelType;
    }

    @Override
    public void changeColor(CarColour colour) throws WrongColourException {
        if(!(colour instanceof BMWColourEnums)) {
            throw new WrongColourException("Passed colour not supported");
        }
        this.colour = colour;
    }

    @Override
    public void changeWheelSize(CarWheelSize wheelSize) throws WrongWheelSizeException {
        if(!(wheelSize instanceof BMWWheelSizeEnums)) {
            throw new WrongWheelSizeException("Passed wheelSize not supported");
        }
        this.wheelSize = wheelSize;
    }

    public BMWDiscBrakesEnums getDiscBrakes() {
        return discBrakes;
    }

    public BMWFuelTypeEnums getFuelType() {
        return fuelType;
    }
    public void setDiscBrakes(BMWDiscBrakesEnums discBrakes) {
        this.discBrakes = discBrakes;
    }
    public void setFuelType(BMWFuelTypeEnums fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "BMW {" +
                super.toString() +
                ", DiscBrakes=" + discBrakes +
                ", FuelType=" + fuelType +
                '}';
    }
}
