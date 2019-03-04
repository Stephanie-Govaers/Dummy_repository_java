package be.pxl.computerstore.hardware;

public enum ComputerComponentTypes {
    COMPUTER_CASES("Computer Cases"),
    PROCESSORS("Processors"),
    HARD_DISK_DRIVES("Hard Disk Drives"),
    PERIPHERALS("Peripherals");

    private String displayName;

    ComputerComponentTypes(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }
}
