import model.cars.AudiCar;
import model.cars.BMWCar;
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

import java.util.HashSet;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        ColourService serviceColor = new ColourService();
        WheelSizeService serviceWheels = new WheelSizeService();
        OptionService serviceOption = new OptionService();

        FactoryBMW factoryBMW = new FactoryBMW(
                BMWColourEnums.values(),
                BMWModelEnums.values(),
                BMWWheelSizeEnums.values(),
                BMWEngineVolumeEnums.values(),
                BMWDiscBrakesEnums.values(),
                BMWFuelTypeEnums.values()
        );
        FactoryAudi factoryAudi = new FactoryAudi(
                AudiColoursEnums.values(),
                AudiModelEnums.values(),
                AudiWheelSizeEnums.values(),
                AudiEngineVolumeEnums.values(),
                AudiTransmissionEnums.values()
        );
        FactoryMercedes factoryMercedes = new FactoryMercedes(
                MercedesColoursEnums.values(),
                MercedesModelEnums.values(),
                MercedesWheelSizeEnums.values(),
                MercedesEngineVolumeEnums.values(),
                MercedesWheelDriveEnums.values()
        );

        ShowRoom showRoom = new ShowRoom(
                serviceColor,
                serviceWheels,
                serviceOption,
                factoryMercedes,
                factoryAudi,
                factoryBMW
        );

        showRoom.printFactoryBMWSetup();
        System.out.println();
        showRoom.printFactoryAudiSetup();
        System.out.println();
        showRoom.printFactoryMercedesSetup();

        System.out.println();
        BMWCar bmw = showRoom.orderBMW(
                BMWModelEnums.SERIES3,
                BMWEngineVolumeEnums.SMALL_1_2,
                BMWColourEnums.VIOLET,
                BMWWheelSizeEnums.SMALL_18,
                new HashSet<>(),
                BMWDiscBrakesEnums.ALL_WHEELS,
                BMWFuelTypeEnums.DIESEL);
        System.out.println();
        AudiCar audi = showRoom.orderAudi(
                AudiModelEnums.A4,
                AudiEngineVolumeEnums.MEDIUM_2_6,
                AudiColoursEnums.RED,
                AudiWheelSizeEnums.MEDIUM_18,
                new HashSet<>(List.of(Options.LEATHER_SEATS)),
                AudiTransmissionEnums.AUTOMATIC);
        System.out.println();
        MercedesCar mercedes = showRoom.orderMercedes(
                MercedesModelEnums.CLASS_C,
                MercedesEngineVolumeEnums.BIG_3_4,
                MercedesColoursEnums.GREY, MercedesWheelSizeEnums.BIG_24,
                new HashSet<>(),
                MercedesWheelDriveEnums.ALL);

        showRoom.changeColorBMW(bmw, BMWColourEnums.ORANGE);
        showRoom.changeWheelsAudi(audi, AudiWheelSizeEnums.VERY_SMALL_16);
        showRoom.addOption(bmw, Options.WINDSHIELD_HEATING);
        showRoom.addOption(bmw, Options.LEATHER_SEATS);
        showRoom.deleteOption(bmw, Options.WINDSHIELD_HEATING);

        System.out.println("\n");
        System.out.println("Полученный автомобиль BMW: \n" + bmw.toString());
        System.out.println("Полученный автомобиль Audi: \n" + audi.toString());
        System.out.println("Полученный автомобиль Mercedes: \n" + mercedes.toString());


    }
}
