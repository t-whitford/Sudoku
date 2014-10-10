package gui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Window extends JFrame{
	
	Window(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 800);
		setLocationRelativeTo(null);
		setTitle("Simple Sudoku Solver");
		
		
		JPanel parentPanel = new JPanel(new BorderLayout(5, 5));
		
		JPanel top = new JPanel();
		JPanel center = new Panel();
		JPanel bottom = new JPanel();
		
		
		JLabel label = new JLabel("Sudoku Solver");
		label.setFont(label.getFont().deriveFont(24.0f));
		top.add(label);
		
		
		//BUTTONS
		JButton solveButton = new JButton();
		solveButton.setText("Solve");
		
		JButton quitButton = new JButton();
		quitButton.setText("Quit");
		
		JButton clearButton = new JButton();
		clearButton.setText("Clear");
		
		bottom.add(solveButton);
		bottom.add(clearButton);
		bottom.add(quitButton);
		
		//BUTTONS END
		
		parentPanel.add(top, BorderLayout.PAGE_START);
		parentPanel.add(center, BorderLayout.CENTER);
		parentPanel.add(bottom, BorderLayout.PAGE_END);
		
		add(parentPanel);
		
		
		setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		Window w = new Window();
	}

}
