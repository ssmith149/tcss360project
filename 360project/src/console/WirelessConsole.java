package console;

//package model;
import javax.swing.*;

import sensors.WirelessRouter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * The Gui for the Vantage Vue Console.
 * 
 * @author Jerry Springer
 * @author Tyler Jackson
 * @version 12/13/2019
 */
public class WirelessConsole {

	/** The main panel. */
	private JPanel mainPanel;

	/** The Sensor Suite. */
	private WirelessRouter wirelessRouter;

	/**
	 * Creates and initialises the Gui.
	 */
	/**
	 * This will store each of the most recent weather data.
	 */
	private int[] report;
	/**
	 * This will display the date, time and temperature for the UI
	 */
	private JLabel label;
	/**
	 * This will store the forecast value for the next day.
	 */
	private int predict;

	public WirelessConsole() {
		wirelessRouter = new WirelessRouter();
		mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));
		initGui();
	}

	/**
	 * Initializes the Gui
	 */
	private void initGui() {
		report = wirelessRouter.requestData().getData();
		Random rand = new Random();
		label = new JLabel("<html>" + getDate() + " " + report[0] + "F<br/>" + getTime() + "</html>",
				SwingConstants.CENTER);

		/**
		 * This will simulate predicting the forcast for the next day.
		 */
		if (rand.nextBoolean()) {
			predict = report[0] + rand.nextInt(5);
		} else {
			predict = report[0] - rand.nextInt(5);
		}

		// Adds a simple forecast display
		mainPanel.add(label);

		// This will refresh the UI and add the most recent weather data from the
		// sensors.
		mainPanel.add(createButton("Update", actionEvent -> {
			report = wirelessRouter.requestData().getData();
			if (rand.nextBoolean()) {
				predict = report[0] + rand.nextInt(5);
			} else {
				predict = report[0] - rand.nextInt(5);
			}
			label.setText("<html>" + getDate() + " " + report[0] + "F<br/>" + getTime() + "</html>");

			mainPanel.repaint();
			mainPanel.revalidate();
			// reValidate();
		}));
		// Add forecast button
		mainPanel.add(createButton("View Forecast", actionEvent -> {
			showMessageDialog("Forecast",
					getDate() + " " + getTime() + "\nThe expected forecast for tomorrow is " + predict + "F");
		}));

		// Add windspeed button
		mainPanel.add(createButton("View Wind Speed", actionEvent -> {
			showMessageDialog("Wind Speed", getDate() + " " + getTime() + "\nWind: " + report[2] + "MPH");
		}));

		// Add humidity button
		mainPanel.add(createButton("View Humidity", actionEvent -> {
			showMessageDialog("Humidity", getDate() + " " + getTime() + "\nHumidity: " + report[1] + "%");
		}));

		// Add wind direction button
		mainPanel.add(createButton("View Wind Direction", actionEvent -> {
			showMessageDialog("Wind Direction", getDate() + " " + getTime() + "\n Wind Direction: N");
		}));

		// Add rainfall button
		mainPanel.add(createButton("View Rainfall", actionEvent -> {
			showMessageDialog("Rainfall", getDate() + " " + getTime() + "\nRainfall: " + report[3] + "in.");
		}));
	}

	/**
	 * Creates and displays the GUI.
	 */
	public void createAndDisplayGui() {
		JFrame frame = new JFrame("Vantage Vue");
		frame.setMinimumSize(new Dimension(360, 360));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.setLocationByPlatform(true);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Creates a JButton with a given name and action listener.
	 * 
	 * @param name           the name of the button that till be displayed.
	 * @param actionListener the action listener that is invoked when clicked.
	 * @return the created button.
	 */
	private JButton createButton(String name, ActionListener actionListener) {
		JButton button = new JButton(name);
		button.addActionListener(actionListener);
		return button;
	}

	/**
	 * Generates a plain message JOptionPane dialog to the main panel.
	 * 
	 * @param title   the title of the dialog.
	 * @param message the message of the dialog.
	 */
	private void showMessageDialog(String title, String message) {
		JOptionPane.showMessageDialog(mainPanel, message, title, JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * Gets the current date.
	 * 
	 * @return the current date.
	 */
	private String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return dtf.format(LocalDate.now());
	}

	/**
	 * Gets the current time.
	 * 
	 * @return the current time.
	 */
	private String getTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm a");
		return dtf.format(LocalDateTime.now());
	}
}
