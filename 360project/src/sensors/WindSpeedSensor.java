/*
 * TCSS 360 Project 4
 */
package sensors;

import java.util.Random;

/**
 * Sensor that polls current Wind Speed
 * 
 * @author Sean Smith
 * @version 12/12/2019
 */
public class WindSpeedSensor implements sensor {

	/**
	 * Value of Wind Speed when sensor was last called
	 */
	private int currentWindSpeed;
	/**
	 * Random object to generate new sensor values
	 */
	private Random myRandom;

	/**
	 * Constructs the sensor object, assigns random WindSpeed.
	 */
	public WindSpeedSensor() {
		myRandom = new Random();
		currentWindSpeed = myRandom.nextInt(60);
	}

	@Override
	public int getData() {
		// We are using random data so we want some fluctuation.
		currentWindSpeed = myRandom.nextInt(3) + currentWindSpeed - myRandom.nextInt(3);
		while (currentWindSpeed > 70 || currentWindSpeed < 0) {
			currentWindSpeed = myRandom.nextInt(3) + currentWindSpeed - myRandom.nextInt(3);
		}
		return currentWindSpeed;
	}

	@Override
	public boolean test() {
		boolean malfunction = true;
		if (currentWindSpeed < 71 && currentWindSpeed > -1) {
			malfunction = false;
		}
		return malfunction;

	}

}