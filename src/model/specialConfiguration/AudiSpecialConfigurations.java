package model.specialConfiguration;


import model.enums.specialConfigurationEnums.AudiTransmissionEnums;

public class AudiSpecialConfigurations implements CarSpecialConfiguration {
    private AudiTransmissionEnums transmission;

    public AudiSpecialConfigurations(AudiTransmissionEnums transmission) {
        this.transmission = transmission;
    }

    public AudiTransmissionEnums getTransmission() {
        return transmission;
    }
}
