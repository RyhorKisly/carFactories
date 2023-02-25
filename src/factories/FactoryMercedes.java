package factories;

import model.cars.AbstractCar;
import model.cars.MercedesCar;
import model.enums.Options;
import model.enums.colours.MercedesColoursEnums;
import model.enums.engineVolumes.MercedesEngineVolumeEnums;
import model.enums.models.MercedesModelEnums;
import model.enums.specialConfigurationEnums.MercedesWheelDriveEnums;
import model.enums.wheelSizes.MercedesWheelSizeEnums;
import factories.AbstractFactory;
import model.specialConfiguration.MercedesSpecialConfigurations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

public class FactoryMercedes extends
        AbstractFactory<
                MercedesModelEnums,
                MercedesEngineVolumeEnums,
                MercedesColoursEnums,
                MercedesWheelSizeEnums,
                MercedesSpecialConfigurations> {

    private MercedesWheelDriveEnums[] wheelDrives;

    public FactoryMercedes(MercedesColoursEnums[] colour, MercedesModelEnums[] model, MercedesWheelSizeEnums[] wheelSize,
                           MercedesEngineVolumeEnums[] engineVolume, MercedesWheelDriveEnums[] wheelDrives) {
        super(colour, model, wheelSize, engineVolume);
        this.wheelDrives = wheelDrives;
        fillStorageWithCars();
    }

    @Override
    public AbstractCar createCar(MercedesModelEnums model, MercedesEngineVolumeEnums engineVolume, MercedesColoursEnums colour, MercedesWheelSizeEnums wheelSize, Set<Options> option, MercedesSpecialConfigurations mercedesSpecialConfiguration) {
        MercedesCar mercedes = (MercedesCar) getCarFromStorage(model, engineVolume, colour, wheelSize,
                option);
        if (mercedes != null) {
            System.out.println("Mercedes was taken from storage");
            if (mercedes.getColour() != colour) {
                mercedes.setColour(colour);
            }
            if (mercedes.getWheelSize() != wheelSize) {
                mercedes.setWheelSize(wheelSize);
            }
            if (!mercedes.getOptions().equals(option)) {
                mercedes.setOptions(option);
            }
            if (mercedes.getWheelDrive() != mercedesSpecialConfiguration.getWheelDrive()) {
                mercedes.setWheelDrive(mercedesSpecialConfiguration.getWheelDrive());
            }
            return mercedes;
        }
        return new MercedesCar(model, engineVolume, colour, wheelSize, option, mercedesSpecialConfiguration.getWheelDrive());
    }

    public String getConfigurations() {
        return format(
                "-------FactoryMercedes has next setups:------- \ncolors: %s; \nmodels: %s; \nwheelSizes: %s; \nengineVolumes: %s; \nwheelDrive: %s",
                Arrays.toString(MercedesColoursEnums.values()),
                Arrays.toString(MercedesModelEnums.values()),
                Arrays.toString(MercedesWheelSizeEnums.values()),
                Arrays.toString(MercedesEngineVolumeEnums.values()),
                Arrays.toString(wheelDrives)
        );
    }

    public void fillStorageWithCars() {
        MercedesCar mercedes = new MercedesCar(MercedesModelEnums.CLASS_C, MercedesEngineVolumeEnums.BIG_3_4,
                MercedesColoursEnums.GREY, MercedesWheelSizeEnums.SMALLEST_14, new HashSet<>(), MercedesWheelDriveEnums.ALL);
        addCarToStorage(mercedes);
        Set<Options> option = new HashSet<>();
        option.add(Options.LEATHER_SEATS);
        mercedes = new MercedesCar(MercedesModelEnums.CLASS_E, MercedesEngineVolumeEnums.MEDIUM_2_4,
                MercedesColoursEnums.WHITE, MercedesWheelSizeEnums.BIG_24, option, MercedesWheelDriveEnums.REAR);
        addCarToStorage(mercedes);
    }


}
