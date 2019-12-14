/**
 * TCSS 360 Project
 */
package sensorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sensors.HumiditySensor;

/**
 * This class tests the HumiditySensor class.
 * 
 * @author Sean Smith
 * @version 12/13/2019
 */
class HumiditySensorTest {
	/**
	 * Sensor used for testing.
	 */
	private HumiditySensor myHumiditySensor;

	/**
	 * Sets up HumiditySensor object before tests.
	 */
	@BeforeEach
	public void setUp() {
		myHumiditySensor = new HumiditySensor();
	}

	/**
	 * Test method for {@link sensors.HumiditySensor#HumiditySensor()}.
	 */
	@Test
	public final void testHumiditySensor() {
		assertTrue(myHumiditySensor.getData() > -1 && myHumiditySensor.getData() < 101);
	}

	/**
	 * Test method for {@link sensors.HumiditySensor#getData()}.
	 */
	@Test
	public final void testGetData() {
		int max = myHumiditySensor.getData();
		int min = myHumiditySensor.getData();
		for (int i = 0; i < 1000; i++) {
			int y = myHumiditySensor.getData();
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
	 * Test method for {@link sensors.HumiditySensor#test()}.
	 */
	@Test
	public final void testTest() {
		boolean bool = true;
		for (int i = 0; i < 1000; i++) {
			myHumiditySensor.getData();
			if (myHumiditySensor.test() == true) {
				bool = false;
			}
		}
		assertTrue(bool);
		// Test() should NEVER fail as these sensors are given random data with bounds,
		// preventing them
		// from failing.
	}

}