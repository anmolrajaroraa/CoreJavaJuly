package com.company.billing.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;

public class IntroScreen extends JWindow {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		IntroScreen frame = new IntroScreen();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public IntroScreen() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.WHITE);
		// Color is a class provided by Java
		// WHITE property is static
		// static means you dont need to create any object to utilise this property
		// you can directly use the property from the class
		setContentPane(contentPane);
		
		JProgressBar progressBar = new JProgressBar();
		contentPane.add(progressBar, BorderLayout.SOUTH);
	}

}
