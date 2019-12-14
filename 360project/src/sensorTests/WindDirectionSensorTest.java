/**
 * TCSS 360 Project
 */
package sensorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sensors.WindDirectionSensor;

/**
 * This class tests the WindDirectionSensor class.
 * 
 * @author Sean Smith
 * @version 12/13/2019
 */
class WindDirectionSensorTest {
	/**
	 * Sensor used for testing.
	 */
	private WindDirectionSensor myWindDirectionSensor;

	/**
	 * Sets up WindDirectionSensor object before tests.
	 */
	@BeforeEach
	public void setUp() {
		myWindDirectionSensor = new WindDirectionSensor();
	}

	/**
	 * Test method for {@link sensors.WindDirectionSensor#WindDirectionSensor()}.
	 */
	@Test
	public final void testWindDirectionSensor() {
		assertTrue(myWindDirectionSensor.getData() > -1 && myWindDirectionSensor.getData() < 4);
	}

	/**
	 * Test method for {@link sensors.WindDirectionSensor#getData()}.
	 */
	@Test
	public final void testGetData() {
		int max = myWindDirectionSensor.getData();
		int min = myWindDirectionSensor.getData();
		for (int i = 0; i < 1000; i++) {
			int y = myWindDirectionSensor.getData();
			if (y > max) {
				max = y;
			}
			if (y < min) {
				min = y;
			}
		}
		assertTrue(min > -1 && max < 4);
	}

	/**
	 * Test method for {@link sensors.WindDirectionSensor#test()}.
	 */
	@Test
	public final void testTest() {
		boolean bool = true;
		for (int i = 0; i < 1000; i++) {
			myWindDirectionSensor.getData();
			if (myWindDirectionSensor.test() == true) {
				bool = false;
			}
		}
		assertTrue(bool);
		// Test() should NEVER fail as these sensors are given random data with bounds,
		// preventing them
		// from failing.
	}

}