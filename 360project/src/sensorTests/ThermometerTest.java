/**
 * TCSS 360 Project
 */
package sensorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sensors.Thermometer;

/**
 * This class tests the thermometer class.
 * 
 * @author Sean Smith
 * @version 12/13/2019
 */
class ThermometerTest {
	/**
	 * Thermometer used for testing
	 */
	private Thermometer myTherm;

	/**
	 * Sets up thermometer object before tests.
	 */
	@BeforeEach
	public void setUp() {
		myTherm = new Thermometer();
	}

	/**
	 * Test method for {@link sensors.Thermometer#Thermometer()}.
	 */
	@Test
	public final void testThermometer() {
		assertTrue(myTherm.getData() > -41 && myTherm.getData() < 121);
	}

	/**
	 * Test method for {@link sensors.Thermometer#getData()}.
	 */
	@Test
	public final void testGetData() {
		int max = myTherm.getData();
		int min = myTherm.getData();
		for (int i = 0; i < 1000; i++) {
			int y = myTherm.getData();
			if (y > max) {
				max = y;
			}
			if (y < min) {
				min = y;
			}
		}
		assertTrue(min > -41 && max < 121);
	}

	/**
	 * Test method for {@link sensors.Thermometer#test()}.
	 */
	@Test
	final void testTest() {
		boolean bool = true;
		for (int i = 0; i < 500; i++) {
			myTherm.getData();
			if (myTherm.test() == true) {
				bool = false;
			}
		}
		assertTrue(bool);
		// Test() should NEVER fail as these sensors are given random data with bounds,
		// preventing them
		// from failing.
	}

}
