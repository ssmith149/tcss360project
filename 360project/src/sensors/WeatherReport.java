/*
 * TCSS 360
 */
package sensors;

/**
 * Immutable class for storing weather data
 * 
 * @author Sean Smith
 * @version 12/12/2019
 */
public class WeatherReport {
	/**
	 * Reported temperature
	 */
	private int myTemp;
	/**
	 * Reported humidity
	 */
	private int myHumidity;
	/**
	 * Reported wind speed
	 */
	private int myWindSpeed;
	/**
	 * Reported rainfall
	 */
	private int myRainfall;

	/**
	 * Constructs a Weather Report object to hold data
	 * 
	 * @param temp      current temperature
	 * @param humid     current humidity
	 * @param windspeed current windSpeed
	 * @param rainfall  current rainfall %
	 */
	public WeatherReport(int temp, int humid, int windspeed, int rainfall) {
		myTemp = temp;
		myHumidity = humid;
		myWindSpeed = windspeed;
		myRainfall = rainfall;
	}

	/**
	 * Returns data contained in weather report as an arrray
	 * 
	 * @return an array containing all of stored data.
	 */
	public int[] getData() {
		int[] temp = { myTemp, myHumidity, myWindSpeed, myRainfall };
		return temp;

	}

}
