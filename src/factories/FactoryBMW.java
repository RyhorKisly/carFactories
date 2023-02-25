package factories;

import model.cars.BMWCar;
import model.cars.AbstractCar;
import model.enums.Options;
import model.enums.colours.BMWColourEnums;
import model.enums.engineVolumes.BMWEngineVolumeEnums;
import model.enums.models.BMWModelEnums;
import model.enums.specialConfigurationEnums.BMWDiscBrakesEnums;
import model.enums.specialConfigurationEnums.BMWFuelTypeEnums;
import model.enums.wheelSizes.BMWWheelSizeEnums;
import factories.AbstractFactory;
import model.specialConfiguration.BMWSpecialConfigurations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.format;

public class FactoryBMW extends
        AbstractFactory<
                BMWModelEnums,
                BMWEngineVolumeEnums,
                BMWColourEnums,
                BMWWheelSizeEnums,
                BMWSpecialConfigurations> {
    private final BMWDiscBrakesEnums[] discBrakes;
    private final BMWFuelTypeEnums[] fuelTypes;


    public FactoryBMW(BMWColourEnums[] colour, BMWModelEnums[] model, BMWWheelSizeEnums[] wheelSize,
                      BMWEngineVolumeEnums[] engineVolume, BMWDiscBrakesEnums[] discBrakes, BMWFuelTypeEnums[] fuelTypes) {
        super(colour, model, wheelSize, engineVolume);
        this.fuelTypes = fuelTypes;
        this.discBrakes = discBrakes;
        fillStorageWithCars();
    }

    @Override
    public AbstractCar createCar(
            BMWModelEnums model,
            BMWEngineVolumeEnums engineVolume,
            BMWColourEnums colour,
            BMWWheelSizeEnums wheelSize,
            Set<Options> option,
            BMWSpecialConfigurations bmwSpecialConfiguration
    ) {
        BMWCar bmw = (BMWCar) getCarFromStorage(model, engineVolume, colour, wheelSize, option);
        if (bmw != null) {
            System.out.println("BMW was taken from storage");
            if (bmw.getColour() != colour) {
                bmw.setColour(colour);
            }
            if (bmw.getWheelSize() != wheelSize) {
                bmw.setWheelSize(wheelSize);
            }
            if (!bmw.getOptions().equals(option)) {
                bmw.setOptions(option);
            }
            if (bmw.getDiscBrakes() != bmwSpecialConfiguration.getDiscBrakes()) {
                bmw.setDiscBrakes(bmwSpecialConfiguration.getDiscBrakes());
            }
            if (bmw.getFuelType() != bmwSpecialConfiguration.getFuelType()) {
                bmw.setFuelType(bmwSpecialConfiguration.getFuelType());
            }
            return bmw;
        }
        return new BMWCar(model, engineVolume, colour, wheelSize, option,
                bmwSpecialConfiguration.getDiscBrakes(), bmwSpecialConfiguration.getFuelType());
    }

    public String getConfigurations() {
        return format(
                "-------FactoryBMW has next setups:------- " +
                        "\ncolors: %s; \nmodels: %s; \nwheelSizes: %s; \nengineVolumes: %s; \nfuelTypes: %s",
                Arrays.toString(BMWColourEnums.values()),
                Arrays.toString(BMWModelEnums.values()),
                Arrays.toString(BMWWheelSizeEnums.values()),
                Arrays.toString(BMWEngineVolumeEnums.values()),
                Arrays.toString(discBrakes),
                Arrays.toString(fuelTypes)
        );
    }

    public void fillStorageWithCars() {
        BMWCar bmw = new BMWCar(BMWModelEnums.SERIES3, BMWEngineVolumeEnums.SMALL_1_2, BMWColourEnums.VIOLET,
                BMWWheelSizeEnums.SMALL_18, new HashSet<>(List.of(Options.REAR_VIEW_CAMERA)), BMWDiscBrakesEnums.FRONT, BMWFuelTypeEnums.DIESEL);
        addCarToStorage(bmw);
        Set<Options> option = new HashSet<>();
        option.add(Options.REAR_VIEW_CAMERA);
        bmw = new BMWCar(BMWModelEnums.SERIES3, BMWEngineVolumeEnums.SMALL_1_2, BMWColourEnums.BLACK,
                BMWWheelSizeEnums.BIG_22, option, BMWDiscBrakesEnums.ALL_WHEELS, BMWFuelTypeEnums.PETROL);
        addCarToStorage(bmw);
    }


}
