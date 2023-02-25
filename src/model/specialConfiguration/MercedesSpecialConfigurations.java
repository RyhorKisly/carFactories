package model.specialConfiguration;


import model.enums.specialConfigurationEnums.MercedesWheelDriveEnums;

public class MercedesSpecialConfigurations implements CarSpecialConfiguration {
    private MercedesWheelDriveEnums wheelDrive;

    public MercedesSpecialConfigurations(MercedesWheelDriveEnums wheelDrive) {
        this.wheelDrive = wheelDrive;
    }

    public MercedesWheelDriveEnums getWheelDrive() {
        return wheelDrive;
    }
}
