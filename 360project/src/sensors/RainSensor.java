/*
 * TCSS 360 Project 4
 */
package sensors;

import java.util.Random;

/**
 * Sensor that polls current Rain %
 * 
 * @author Sean Smith
 * @version 12/12/2019
 */
public class RainSensor implements sensor {

	/**
	 * Value of Rain when sensor was last called
	 */
	private int currentRainfall;
	/**
	 * Random object to generate new sensor values
	 */
	private Random myRandom;

	/**
	 * Constructs the sensor object, assigns random Rain.
	 */
	public RainSensor() {
		myRandom = new Random();
		currentRainfall = myRandom.nextInt(100);
	}

	@Override
	public int getData() {
		// We are using random data so we want some fluctuation.
		currentRainfall = myRandom.nextInt(3) + currentRainfall - myRandom.nextInt(3);
		while (currentRainfall > 100 || currentRainfall < 0) {
			currentRainfall = myRandom.nextInt(3) + currentRainfall - myRandom.nextInt(3);
		}
		return currentRainfall;
	}

	@Override
	public boolean test() {
		boolean malfunction = true;
		if (currentRainfall < 101 || currentRainfall > -1) {
			malfunction = false;
		}
		return malfunction;

	}

}