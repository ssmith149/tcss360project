/*
 * TCSS 360 Project 1
 */
package sensors;
//comment
import java.util.Random;

/**
 * Sensor that polls current humidity
 * 
 * @author Sean Smith
 * @version 12/12/2019
 */
public class HumiditySensor implements sensor {

	/**
	 * Value of Humidity when sensor was last called
	 */
	private int currentHumidity;
	/**
	 * Random object to generate new sensor values
	 */
	private Random myRandom;

	/**
	 * Constructs the sensor object, assigns random humidity.
	 */
	public HumiditySensor() {
		myRandom = new Random();
		currentHumidity = myRandom.nextInt(100);
	}

	@Override
	public int getData() {
		// We are using random data so we want some fluctuation.
		currentHumidity = myRandom.nextInt(3) + currentHumidity - myRandom.nextInt(3);
		while (currentHumidity > 100 || currentHumidity < 0) {
			currentHumidity = myRandom.nextInt(3) + currentHumidity - myRandom.nextInt(3);
		}
		return currentHumidity;
	}

	@Override
	public boolean test() {
		boolean malfunction = true;
		if (currentHumidity < 101 && currentHumidity > -1) {
			malfunction = false;
		}
		return malfunction;

	}

}