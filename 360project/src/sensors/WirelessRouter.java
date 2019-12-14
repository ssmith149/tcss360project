package sensors;

/**
 * This class functions to provide a communication method between the console
 * and the sensors.
 * 
 * @author Sean Smith
 * @version 12/12/2019
 *
 */
public class WirelessRouter {
	/**
	 * Sensors collecting data
	 */
	private SensorSuite mySensors;

	/**
	 * Initalizes router and sensor suite.
	 */
	public WirelessRouter() {
		mySensors = new SensorSuite();
	}

	/**
	 * Requests a weather report from the sensors
	 * 
	 * @return A weather report containing data from the sensors.
	 */
	public WeatherReport requestData() {
		return mySensors.collectData();
	}
}
