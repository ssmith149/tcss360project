package console;

import javax.swing.*;

/**
 * The main class used to run the Vantage Vue GUI
 * 
 * @author Jerry Springer
 * @version 12/13/2019
 */
public class Main {

	// Runs the Vantage Vue GUI
	public static void main(String args[]) {
		SwingUtilities.invokeLater(() -> new WirelessConsole().createAndDisplayGui());
	}
}
