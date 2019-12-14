/*
 * TCSS 360 Project 4
 */
package sensors;

/**
 * Contains all of the sensors and polls sensors when requested
 * 
 * @author Sean Smith
 * @version 12/12/2019
 */
public class SensorSuite {
	/**
	 * Sensor that gather temperature information.
	 */
	private Thermometer myTherm;
	/**
	 * Sensor that gathers wind speed data.
	 */
	private WindSpeedSensor myWindSensor;
	/**
	 * Sensor that gathers percentage precipitation/
	 */
	private RainSensor myRainSensor;
	/**
	 * Sensor that gathers humidity percentage.
	 */
	private HumiditySensor myHumiditySensor;

	/**
	 * Initalizes all of the sensors and constructs all necessary objects.
	 */
	public SensorSuite() {
		myTherm = new Thermometer();
		myWindSensor = new WindSpeedSensor();
		myRainSensor = new RainSensor();
		myHumiditySensor = new HumiditySensor();
	}

	/**
	 * Polls all of the sensors and returns a weather report with that data
	 * 
	 * @return A weather report containing all of the data gathered from the
	 *         sensors.
	 */
	public WeatherReport collectData() {
		return new WeatherReport(myTherm.getData(), myHumiditySensor.getData(), myWindSensor.getData(),
				myRainSensor.getData());

	}
}
