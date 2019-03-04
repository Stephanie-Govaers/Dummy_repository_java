package be.pxl.computerstore.hardware;

public class WebCam extends Peripheral {
    private int frameRate;

    public WebCam(String vendor, String name, double price, int frameRate) {
        super(vendor, name, price);
        this.frameRate = frameRate;
    }

    public int getFrameRate() {
        return frameRate;
    }

    @Override
    public String getFullDescription() {
        StringBuilder description = new StringBuilder(super.getFullDescription());
        description.append("\nFrame rate = ").append(frameRate).append(" fps");
        return description.toString();
    }
}
