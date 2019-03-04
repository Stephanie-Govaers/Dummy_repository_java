package be.pxl.computerstore.hardware;

import be.pxl.computerstore.util.TooManyPeripheralsException;

import be.pxl.computerstore.util.Computable;

public class ComputerSystem implements Computable {
	public static final int MAX_PERIPHERAL = 3;
	private ComputerCase computerCase;
	private Processor processor;
	private HardDisk hardDisk;
	private int numberOfPeripherals = 0;
	private Peripheral[] peripherals = new Peripheral[MAX_PERIPHERAL];
	
	public ComputerCase getComputerCase() {
		return computerCase;
	}
	public void setComputerCase(ComputerCase computerCase) {
		this.computerCase = computerCase;
	}
	public Processor getProcessor() {
		return processor;
	}
	public void setProcessor(Processor processor) {
		this.processor = processor;
	}
	
	
	public void addPeripheral(Peripheral peripheral) throws TooManyPeripheralsException {
		if (numberOfPeripherals >= MAX_PERIPHERAL) {
			throw new TooManyPeripheralsException("You cannot add extra peripherals.");
		}
		peripherals[numberOfPeripherals++] = peripheral;
	}

	public HardDisk getHardDisk() {
		return hardDisk;
	}

	private int getNextPeripheralIndex() {
		for(int i=0; i < MAX_PERIPHERAL; i++) {
			if (peripherals[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	public int getNumberOfPeripherals() {
		return numberOfPeripherals;
	}
	
	
	public Peripheral[] getPeripherals() {
		return peripherals;
	}

	public void setHardDisk(HardDisk hardDisk) {
		this.hardDisk = hardDisk;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		if (computerCase != null) {
			description.append("Computercase:\n");
			description.append(computerCase);
		}
		if (processor != null) {
			description.append("Processor:\n");
			description.append(processor);
		}
		int counter = 1;
		for(Peripheral peripheral: peripherals) {
			if (peripheral != null) {
				description.append("Randapparaat " + counter + ":\n");
				description.append(peripheral);
				counter++;
			}
		}
		description.append("TOTAAL EXCL.: ").append(totalPriceExcl()).append("\n");
		description.append("TOTAAL INCL.: ").append(totalPriceIncl()).append("\n");
		return description.toString();
	}
	@Override
	public double totalPriceExcl() {
		double sum = 0;

		sum += computerCase == null? 0 : computerCase.getPrice();

	
		if (processor != null) {
			sum += processor.getPrice();
		}

		if (hardDisk != null) {
			sum += hardDisk.getPrice();
		}

		for(Peripheral peripheral: peripherals) {
			if (peripheral != null) {
				sum += peripheral.getPrice();
			}
		}
		return Math.round(sum * 100) / 100.0;
	}
}
