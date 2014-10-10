package gui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.SudokuSolver;


public class Window extends JFrame{
	
	public Window(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 800);
		setLocationRelativeTo(null);
		setTitle("Simple Sudoku Solver");
		
		
		JPanel parentPanel = new JPanel(new BorderLayout(5, 5));
		
		JPanel top = new JPanel();
		Grid center = new Grid();
		JPanel bottom = new JPanel();
		
		
		//LABELS
		JLabel label = new JLabel("Sudoku Solver");
		label.setFont(label.getFont().deriveFont(24.0f));
		top.add(label);
		
		
		
		//BUTTONS
		JButton solveButton = new JButton();
		solveButton.setText("Solve");
		solveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					int[][] data = center.getData();
					SudokuSolver solver = new SudokuSolver(data);
					solver.printGrid();
					System.out.println();
					solver.solve();
					solver.printGrid();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		JButton quitButton = new JButton();
		quitButton.setText("Quit");
		quitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		
		
		
		JButton clearButton = new JButton();
		clearButton.setText("Clear");
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				center.clearAll();
			}
		});
		
		
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
