package factories;

import model.cars.AudiCar;
import model.cars.AbstractCar;
import model.enums.Options;
import model.enums.colours.AudiColoursEnums;
import model.enums.engineVolumes.AudiEngineVolumeEnums;
import model.enums.models.AudiModelEnums;
import model.enums.specialConfigurationEnums.AudiTransmissionEnums;
import model.enums.wheelSizes.AudiWheelSizeEnums;
import factories.AbstractFactory;
import model.specialConfiguration.AudiSpecialConfigurations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

public class FactoryAudi extends
        AbstractFactory<
                AudiModelEnums,
                AudiEngineVolumeEnums,
                AudiColoursEnums,
                AudiWheelSizeEnums,
                AudiSpecialConfigurations> {

    private final AudiTransmissionEnums[] transmission;

    public FactoryAudi(
            AudiColoursEnums[] colour,
            AudiModelEnums[] model,
            AudiWheelSizeEnums[] wheelSize,
            AudiEngineVolumeEnums[] engineVolume,
            AudiTransmissionEnums[] transmission
    ) {
        super(colour, model, wheelSize, engineVolume);
        this.transmission = transmission;
        fillStorageWithCars();
    }

    @Override
    public AbstractCar createCar(
            AudiModelEnums model,
            AudiEngineVolumeEnums engineVolume,
            AudiColoursEnums colour,
            AudiWheelSizeEnums wheelSize,
            Set<Options> option,
            AudiSpecialConfigurations AudiSpecialConfiguration
    ) {
        AudiCar audi = (AudiCar) getCarFromStorage(model, engineVolume, colour, wheelSize,
                option);
        if (audi != null) {
            System.out.println("Audi was taken from storage");
            if (audi.getColour() != colour) {
                audi.setColour(colour);
                System.out.println("Audi color has been changed according to the order");
            }
            if (audi.getWheelSize() != wheelSize) {
                audi.setWheelSize(wheelSize);
                System.out.println("Audi wheelSize has been changed according to the order");
            }
            if (!audi.getOptions().equals(option)) {
                audi.setOptions(option);
                System.out.println("Audi options have been changed according to the order");
            }
            if (audi.getTransmission() != AudiSpecialConfiguration.getTransmission()) {
                audi.setTransmission(AudiSpecialConfiguration.getTransmission());
                System.out.println("Audi Transmission has been changed according to the order ");
            }
            return audi;
        }
        return new AudiCar(
                model,
                engineVolume,
                colour,
                wheelSize,
                option,
                AudiSpecialConfiguration.getTransmission()
        );
    }

    public String getConfigurations() {
        return format(
                "-------FactoryAudi has next setups:------- " +
                        "\ncolors: %s; " +
                        "\nmodels: %s; " +
                        "\nwheelSizes: %s; " +
                        "\nengineVolumes: %s; " +
                        "\ntransmission: %s",
                Arrays.toString(AudiColoursEnums.values()),
                Arrays.toString(AudiModelEnums.values()),
                Arrays.toString(AudiWheelSizeEnums.values()),
                Arrays.toString(AudiEngineVolumeEnums.values()),
                Arrays.toString(transmission)
        );
    }

    public void fillStorageWithCars() {
        AudiCar audi = new AudiCar(
                AudiModelEnums.A4,
                AudiEngineVolumeEnums.MEDIUM_2_6,
                AudiColoursEnums.RED,
                AudiWheelSizeEnums.VERY_SMALL_16,
                new HashSet<>(),
                AudiTransmissionEnums.AUTOMATIC
        );
        addCarToStorage(audi);
        Set<Options> option = new HashSet<>();
        option.add(Options.REAR_VIEW_CAMERA);
        audi = new AudiCar(
                AudiModelEnums.A8,
                AudiEngineVolumeEnums.MEDIUM_2_6,
                AudiColoursEnums.BLUE,
                AudiWheelSizeEnums.MEDIUM_18,
                option,
                AudiTransmissionEnums.MANUAL);
        addCarToStorage(audi);
    }


}
