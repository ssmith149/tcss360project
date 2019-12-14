/**
 * TCSS 360 Project
 */
package sensorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sensors.RainSensor;

/**
 * This class tests the RainSensor class.
 * 
 * @author Sean Smith
 * @version 12/13/2019
 */
class RainSensorTest {
	/**
	 * Sensor used for testing.
	 */
	private RainSensor myRainSensor;

	/**
	 * Sets up RainSensor object before tests.
	 */
	@BeforeEach
	public void setUp() {
		myRainSensor = new RainSensor();
	}

	/**
	 * Test method for {@link sensors.RainSensor#RainSensor()}.
	 */
	@Test
	public final void testRainSensor() {
		assertTrue(myRainSensor.getData() > -1 && myRainSensor.getData() < 101);
	}

	/**
	 * Test method for {@link sensors.RainSensor#getData()}.
	 */
	@Test
	public final void testGetData() {
		int max = myRainSensor.getData();
		int min = myRainSensor.getData();
		for (int i = 0; i < 1000; i++) {
			int y = myRainSensor.getData();
			if (y > max) {
				max = y;
			}
			if (y < min) {
				min = y;
			}
		}
		assertTrue(min > -1 && max < 101);
	}

	/**
	 * Test method for {@link sensors.RainSensor#test()}.
	 */
	@Test
	public final void testTest() {
		boolean bool = true;
		for (int i = 0; i < 1000; i++) {
			myRainSensor.getData();
			if (myRainSensor.test() == true) {
				bool = false;
			}
		}
		assertTrue(bool);
		// Test() should NEVER fail as these sensors are given random data with bounds,
		// preventing them
		// from failing.
	}

}