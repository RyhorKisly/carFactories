package model.specialConfiguration;

import model.enums.specialConfigurationEnums.BMWDiscBrakesEnums;
import model.enums.specialConfigurationEnums.BMWFuelTypeEnums;

public class BMWSpecialConfigurations implements CarSpecialConfiguration {

    private BMWDiscBrakesEnums discBrakes;
    private BMWFuelTypeEnums fuelType;

    public BMWSpecialConfigurations(BMWDiscBrakesEnums discBrakes, BMWFuelTypeEnums fuelType) {
        this.discBrakes = discBrakes;
        this.fuelType = fuelType;
    }

    public BMWDiscBrakesEnums getDiscBrakes() {
        return discBrakes;
    }

    public BMWFuelTypeEnums getFuelType() {
        return fuelType;
    }

}
