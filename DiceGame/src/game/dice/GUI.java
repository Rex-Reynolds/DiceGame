package game.dice;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {
	private JFrame frame = new JFrame("Dice Game");
	private JPanel inputPanel = new JPanel();
	private JPanel outputPanel = new JPanel();
	private JButton clickmeButton = new JButton("Keep All");
	private JTextArea outputText = new JTextArea();
	private JTextField inputText = new JTextField();

	public void load() {

		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		inputPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		outputText.setPreferredSize(new Dimension(250, 250));
		inputText.setPreferredSize(new Dimension(375, 24));
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

	public void setOutputText(String text) {
		outputText.setText(text);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			e.consume();
		}

	}
}
