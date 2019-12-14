/**
 * TCSS 360 Project
 */
package sensorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sensors.SensorSuite;

/**
 * This class tests the WirelessRouter class.
 * 
 * @author Sean Smith
 * @version 12/13/2019
 */
class SensorSuiteTest {
	/**
	 * Sensor suite object used for testing methods.
	 */
	private SensorSuite mySuite;

	/**
	 * Sets up sensor suite object for testing.
	 */
	@BeforeEach
	public void setUp() {
		mySuite = new SensorSuite();
	}

	/**
	 * Test method for {@link sensors.SensorSuite#collectData()}.
	 */
	@Test
	public final void testCollectData() {
		int arr[] = mySuite.collectData().getData();
		assertAll("Multiple tests failed", 
				() -> assertTrue(arr[0] > -41 && arr[0] < 121),
				() -> assertTrue(arr[1] > -1 && arr[1] < 101), 
				() -> assertTrue(arr[2] > -1 && arr[2] < 71),
				() -> assertTrue(arr[3] > -1 && arr[3] < 101),
				() -> assertTrue(arr[4] > -1 && arr[4] < 4)

		);
	}

}
