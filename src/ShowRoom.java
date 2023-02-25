import model.cars.AudiCar;
import model.cars.BMWCar;
import model.cars.AbstractCar;
import model.cars.MercedesCar;
import model.enums.Options;
import model.enums.colours.AudiColoursEnums;
import model.enums.colours.BMWColourEnums;
import model.enums.colours.MercedesColoursEnums;
import model.enums.engineVolumes.AudiEngineVolumeEnums;
import model.enums.engineVolumes.BMWEngineVolumeEnums;
import model.enums.engineVolumes.MercedesEngineVolumeEnums;
import model.enums.models.AudiModelEnums;
import model.enums.models.BMWModelEnums;
import model.enums.models.MercedesModelEnums;
import model.enums.specialConfigurationEnums.AudiTransmissionEnums;
import model.enums.specialConfigurationEnums.BMWDiscBrakesEnums;
import model.enums.specialConfigurationEnums.BMWFuelTypeEnums;
import model.enums.specialConfigurationEnums.MercedesWheelDriveEnums;
import model.enums.wheelSizes.AudiWheelSizeEnums;
import model.enums.wheelSizes.BMWWheelSizeEnums;
import model.enums.wheelSizes.MercedesWheelSizeEnums;
import factories.FactoryAudi;
import factories.FactoryBMW;
import factories.FactoryMercedes;
import service.ColourService;
import service.OptionService;
import service.WheelSizeService;
import model.specialConfiguration.AudiSpecialConfigurations;
import model.specialConfiguration.BMWSpecialConfigurations;
import model.specialConfiguration.MercedesSpecialConfigurations;

import java.util.Set;

public class ShowRoom {

    private final ColourService serviceColor;
    private final WheelSizeService serviceWheels;
    private final OptionService serviceOption;
    private final FactoryMercedes factoryMercedes;
    private final FactoryAudi factoryAudi;
    private final FactoryBMW factoryBMW;

    public ShowRoom(
            ColourService serviceColor,
            WheelSizeService serviceWheels,
            OptionService serviceOption,
            FactoryMercedes factoryMercedes,
            FactoryAudi factoryAudi,
            FactoryBMW factoryBMW
    ) {
        this.serviceColor = serviceColor;
        this.serviceWheels = serviceWheels;
        this.serviceOption = serviceOption;
        this.factoryMercedes = factoryMercedes;
        this.factoryAudi = factoryAudi;
        this.factoryBMW = factoryBMW;
    }

    public MercedesCar orderMercedes(
            MercedesModelEnums model,
            MercedesEngineVolumeEnums engineVolume,
            MercedesColoursEnums colour,
            MercedesWheelSizeEnums wheelSize,
            Set<Options> option,
            MercedesWheelDriveEnums wheelDrive
    ) {
        return (MercedesCar) factoryMercedes.createCar(
                model,
                engineVolume,
                colour,
                wheelSize,
                option,
                new MercedesSpecialConfigurations(wheelDrive)
        );
    }

    public AudiCar orderAudi(
            AudiModelEnums model,
            AudiEngineVolumeEnums engineVolume,
            AudiColoursEnums colour,
            AudiWheelSizeEnums wheelSize,
            Set<Options> option,
            AudiTransmissionEnums transmission) {
        return (AudiCar) factoryAudi.createCar(
                model, engineVolume, colour, wheelSize, option, new AudiSpecialConfigurations(transmission));
    }

    public BMWCar orderBMW(
            BMWModelEnums model,
            BMWEngineVolumeEnums engineVolume,
            BMWColourEnums colour,
            BMWWheelSizeEnums wheelSize,
            Set<Options> options,
            BMWDiscBrakesEnums discBrakes,
            BMWFuelTypeEnums fuelType) {
        return (BMWCar) factoryBMW.createCar(
                model, engineVolume, colour, wheelSize, options, new BMWSpecialConfigurations(discBrakes, fuelType));
    }

    public void changeColorBMW(BMWCar bmw, BMWColourEnums colourBMW) {
        serviceColor.changeCar(bmw, colourBMW);
    }
    public void changeColorAudi(AudiCar audi, AudiColoursEnums colourAudi) {
        serviceColor.changeCar(audi, colourAudi);
    }
    public void changeColorMercedes(MercedesCar mercedes, MercedesColoursEnums colourMercedes) {
        serviceColor.changeCar(mercedes, colourMercedes);
    }

    public void changeWheelsBMW(BMWCar bmw, BMWWheelSizeEnums wheelSizeBMW) {
        serviceWheels.changeCar(bmw, wheelSizeBMW);
    }
    public void changeWheelsAudi(AudiCar audi, AudiWheelSizeEnums wheelSizeAudi) {
        serviceWheels.changeCar(audi, wheelSizeAudi);
    }
    public void changeWheelsMercedes(MercedesCar mercedes, MercedesWheelSizeEnums wheelSizeMercedes) {
        serviceWheels.changeCar(mercedes, wheelSizeMercedes);
    }


    public void addOption(AbstractCar car, Options option) {
        serviceOption.addOption(car, option);
    }

    public void deleteOption(AbstractCar car, Options option) {
        serviceOption.removeOption(car, option);
    }

    public void printFactoryBMWSetup() {
        System.out.println(factoryBMW.getConfigurations());
    }

    public void printFactoryAudiSetup() {
        System.out.println(factoryAudi.getConfigurations());
    }

    public void printFactoryMercedesSetup() {
        System.out.println(factoryMercedes.getConfigurations());
    }

}