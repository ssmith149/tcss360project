/**
 *  TCSS 360 Project
 */
package sensorTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sensors.WeatherReport;

/**
 * This class tests the WeatherReport class.
 * 
 * @author Sean Smith
 * @version 12/13/2019
 */
class WeatherReportTest {
	/**
	 * Weather report object used for testing.
	 */
	private WeatherReport myReport;

	/**
	 * Sets up a weather report that will have its methods tested.
	 */
	@BeforeEach
	public void setUp() {
		myReport = new WeatherReport(5, 6, 7, 8);
	}

	/**
	 * Test method for
	 * {@link sensors.WeatherReport#WeatherReport(int, int, int, int)}.
	 */
	@Test
	public final void testWeatherReport() {
		int arr[] = myReport.getData();
		int array[] = { 5, 6, 7, 8 };
		assertArrayEquals(array, arr);

	}

	/**
	 * Test method for {@link sensors.WeatherReport#getData()}.
	 */
	@Test
	public final void testGetData() {
		int arr[] = myReport.getData();
		int array[] = { 5, 6, 7, 8 };
		assertArrayEquals(array, arr);
	}
}
