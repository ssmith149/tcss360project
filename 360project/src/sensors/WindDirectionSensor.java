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
public class WindDirectionSensor implements sensor {

	/**
	 * Value of Wind Direction when sensor was last called
	 */
	private int currentWindDirection;
	/**
	 * Random object to generate new sensor values
	 */
	private Random myRandom;

	/**
	 * Constructs the sensor object, assigns random WindDirection.
	 */
	public WindDirectionSensor() {
		myRandom = new Random();
		currentWindDirection = myRandom.nextInt(4);
	}

	@Override
	public int getData() {
		//Wind Direction is unlikely to change quickly
		return currentWindDirection;
	}

	@Override
	public boolean test() {
		boolean malfunction = true;
		if (currentWindDirection < 4 && currentWindDirection > -1) {
			malfunction = false;
		}
		return malfunction;

	}

}