/*
 * TCSS 360
 */
package sensors;

import java.util.Random;

/**
 * Sensor that polls current tempature
 * 
 * @author Sean Smith
 * @version 12/12/2019
 */
public class Thermometer implements sensor {

	/**
	 * Value of temp when sensor was last called
	 */
	private int currentTemp;
	/**
	 * Random object to generate new sensor values
	 */
	private Random myRandom;

	/**
	 * Constructs the sensor object, assigns random temp.
	 */
	public Thermometer() {
		myRandom = new Random();
		currentTemp = myRandom.nextInt(110) - myRandom.nextInt(40);
	}

	@Override
	public int getData() {
		// We are using random data so we want some fluctuation.
		currentTemp = myRandom.nextInt(5) + currentTemp - myRandom.nextInt(5);
		while (currentTemp > 120 || currentTemp < -40) {
			currentTemp = myRandom.nextInt(5) + currentTemp - myRandom.nextInt(5);
		}
		return currentTemp;
	}

	@Override
	public boolean test() {
		boolean malfunction = true;
		if (currentTemp <= 120 && currentTemp >= -40) {
			malfunction = false;
		}
		return malfunction;

	}

}
