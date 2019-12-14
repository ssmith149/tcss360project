/**
 * TCSS 360 Project
 */
package sensorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sensors.WindSpeedSensor;

/**
 * This class tests the WindSpeedSensor class.
 * 
 * @author Sean Smith
 * @version 12/13/2019
 */
class WindSpeedSensorTest {
	/**
	 * Wind sensor object being tested.
	 */
	private WindSpeedSensor myWindSensor;

	/**
	 * Sets up WindSpeedSensor object before tests.
	 */
	@BeforeEach
	public void setUp() {
		myWindSensor = new WindSpeedSensor();
	}

	/**
	 * Test method for {@link sensors.WindSpeedSensor#WindSpeedSensor()}.
	 */
	@Test
	public final void testWindSpeedSensor() {
		assertTrue(myWindSensor.getData() > -1 && myWindSensor.getData() < 71);
	}

	/**
	 * Test method for {@link sensors.WindSpeedSensor#getData()}.
	 */
	@Test
	public final void testGetData() {
		int max = myWindSensor.getData();
		int min = myWindSensor.getData();
		for (int i = 0; i < 1000; i++) {
			int y = myWindSensor.getData();
			if (y > max) {
				max = y;
			}
			if (y < min) {
				min = y;
			}
		}
		assertTrue(min > -1 && max < 71);
	}

	/**
	 * Test method for {@link sensors.WindSpeedSensor#test()}.
	 */
	@Test
	public final void testTest() {
		boolean bool = true;
		for (int i = 0; i < 500; i++) {
			myWindSensor.getData();
			if (myWindSensor.test() == true) {
				bool = false;
			}
		}
		assertTrue(bool);
		// Test() should NEVER fail as these sensors are given random data with bounds,
		// preventing them
		// from failing.
	}

}