package model.cars;

import exeptions.WrongColourException;
import exeptions.WrongWheelSizeException;
import model.enums.Options;
import model.enums.colours.CarColour;
import model.enums.colours.MercedesColoursEnums;
import model.enums.engineVolumes.MercedesEngineVolumeEnums;
import model.enums.models.MercedesModelEnums;
import model.enums.specialConfigurationEnums.MercedesWheelDriveEnums;
import model.enums.wheelSizes.MercedesWheelSizeEnums;
import model.enums.wheelSizes.CarWheelSize;

import java.util.Set;

public class MercedesCar extends AbstractCar {

    private MercedesWheelDriveEnums wheelDrive;

    public MercedesCar(MercedesModelEnums model, MercedesEngineVolumeEnums engineVolume, MercedesColoursEnums color,
                       MercedesWheelSizeEnums wheelSize, Set<Options> option, MercedesWheelDriveEnums wheelDrive) {
       super (model, engineVolume, color, wheelSize, option);
        this.wheelDrive = wheelDrive;
    }

    @Override
    public void changeColor(CarColour colour) throws WrongColourException {
        if(!(colour instanceof MercedesColoursEnums)) {
            throw new WrongColourException("Passed colour not supported");
        }
        this.colour = colour;
    }

    @Override
    public void changeWheelSize(CarWheelSize wheelSize) throws WrongWheelSizeException {
        if(!(wheelSize instanceof MercedesWheelSizeEnums)) {
            throw new WrongWheelSizeException("Passed wheelSize not supported");
        }
        this.wheelSize = wheelSize;
    }

    public MercedesWheelDriveEnums getWheelDrive() {
        return wheelDrive;
    }

    public void setWheelDrive(MercedesWheelDriveEnums wheelDrive) {
        this.wheelDrive = wheelDrive;
    }


    @Override
    public String toString() {
        return "Mercedes {" +
                super.toString() +
                ", wheelDrive=" + wheelDrive +
                '}';
    }

}
