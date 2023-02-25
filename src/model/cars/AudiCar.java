package model.cars;

import exeptions.WrongColourException;
import exeptions.WrongWheelSizeException;
import model.enums.Options;
import model.enums.colours.AudiColoursEnums;
import model.enums.colours.CarColour;
import model.enums.engineVolumes.AudiEngineVolumeEnums;
import model.enums.models.AudiModelEnums;
import model.enums.specialConfigurationEnums.AudiTransmissionEnums;
import model.enums.wheelSizes.AudiWheelSizeEnums;
import model.enums.wheelSizes.CarWheelSize;

import java.util.Set;

public class AudiCar extends AbstractCar {

    private AudiTransmissionEnums transmission;

    public AudiCar(AudiModelEnums model, AudiEngineVolumeEnums engineVolume, AudiColoursEnums color,
                   AudiWheelSizeEnums wheelSize, Set<Options> option, AudiTransmissionEnums transmission) {
        super(model, engineVolume, color, wheelSize, option);
        this.transmission = transmission;
    }

    public AudiTransmissionEnums getTransmission() {
        return transmission;
    }

    public void setTransmission(AudiTransmissionEnums transmission) {
        this.transmission = transmission;
    }

    @Override
    public void changeColor(CarColour colour) throws WrongColourException {
        if(!(colour instanceof AudiColoursEnums)) {
            throw new WrongColourException("Passed colour not supported");
        }
        this.colour = colour;
    }

    @Override
    public void changeWheelSize(CarWheelSize wheelSize) throws WrongWheelSizeException {
        if(!(wheelSize instanceof AudiWheelSizeEnums)) {
            throw new WrongWheelSizeException("Passed wheelSize not supported");
        }
        this.wheelSize = wheelSize;
    }

    @Override
    public String toString() {
        return "Audi {" +
                super.toString() +
                ", transmission=" + transmission +
                '}';
    }
}
