package game.dice;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {

	public  void load() {
		JFrame frame = new JFrame("Dice Game");
		frame.setLayout(new BorderLayout());
		JPanel inputPanel = new JPanel();
		JPanel outputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton clickmeButton = new JButton("Keep All");
		JTextField outputText = new JTextField();
		JTextField inputText = new JTextField();
		inputText.setPreferredSize( new Dimension(375 ,24 ) );
		outputPanel.setLayout(new GridLayout());

		outputText.setEditable(false);

		inputPanel.add(inputText);
		inputPanel.add(clickmeButton);

		outputPanel.add(outputText);
		frame.add(outputPanel, BorderLayout.NORTH);
		frame.add(inputPanel, BorderLayout.SOUTH);

		frame.setSize(500, 500);// 400 width and 500 height
		frame.setVisible(true);// making the frame visible

	}

}
