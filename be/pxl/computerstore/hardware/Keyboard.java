package be.pxl.computerstore.hardware;

public class Keyboard extends Peripheral {
	private KeyboardLayout layout;
	
	public Keyboard(String vendor, String name,
			double price, 
			KeyboardLayout layout) {
		super(vendor, name, price);
		setLayout(layout);
	}

	public KeyboardLayout getLayout() {
		return layout;
	}

	public void setLayout(KeyboardLayout layout) {
		this.layout = layout;
	}
}
