package be.pxl.computerstore.hardware;

public abstract class Peripheral extends ComputerComponent {

    public Peripheral(String vendor, String name, double price) {
        super(vendor, name, price);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + super.toString();
    }

    @Override
    public String getFullDescription() {
        StringBuilder description = new StringBuilder();
        description.append("Type = ").append(getClass().getSimpleName()).append("\n");
        description.append(super.getFullDescription());
        return description.toString();
    }

}
