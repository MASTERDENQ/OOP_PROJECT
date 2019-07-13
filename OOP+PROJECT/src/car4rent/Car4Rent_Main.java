package car4rent;

import java.awt.BorderLayout;

import javax.swing.*;

public class Car4Rent_Main {

	public void start() {
		
		//Creating the Frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        
        //Creating the MenuBar and adding components
        JMenuBar menuBar = new JMenuBar();
        JMenu Home = new JMenu("HOME");
        JMenu ViewVehicle = new JMenu("View Vehicles");
        menuBar.add(Home);
        menuBar.add(ViewVehicle);
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        Home.add(open);
        Home.add(save);
        
        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter ");
        JButton enter = new JButton("ENTER");
        JButton reset = new JButton("RESET");
        panel.add(label); // Components Added using Flow Layout
        panel.add(label); // Components Added using Flow Layout
        panel.add(enter);
        panel.add(reset);
        
        // Text Area at the Center
        JTextArea textArea = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.setVisible(true);

	}

}
