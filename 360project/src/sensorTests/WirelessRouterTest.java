/**
 * TCSS 360 Project 1
 */
package sensorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sensors.WirelessRouter;

/**
 * This class tests the WirelessRouter class.
 * 
 * @author Sean Smith
 * @version 12/13/2019
 */
class WirelessRouterTest {
	/**
	 * Router whose methods are being tested.
	 */
	private WirelessRouter myRouter;

	/**
	 * Sets up wireless router class for testing
	 */
	@BeforeEach
	public void setUp() {
		myRouter = new WirelessRouter();
	}

	/**
	 * Test method for {@link sensors.WirelessRouter#requestData()}.
	 */
	@Test
	public final void testRequestData() {
		int arr[] = myRouter.requestData().getData();
		assertAll("Multiple tests failed", () -> assertTrue(arr[0] > -41 && arr[0] < 121),
				() -> assertTrue(arr[1] > -1 && arr[1] < 101), () -> assertTrue(arr[2] > -1 && arr[2] < 71),
				() -> assertTrue(arr[3] > -1 && arr[3] < 101)

		);
	}
}
