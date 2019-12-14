package sensors;
/**
 * TCSS 360 Project 4
 */

/**
 * Interface for a basic weather sensor
 * 
 * @author Sean Smith
 * @version 1
 */
public interface sensor {
	/**
	 * Retrieves current data from sensor
	 */
	public int getData();

	/**
	 * Verifys phyiscal sensor is operating correctly
	 */
	public boolean test();
}
