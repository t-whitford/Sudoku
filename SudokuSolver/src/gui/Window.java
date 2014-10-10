package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.SudokuSolver;


public class Window extends JFrame{
	
	public JLabel errorLabel;
	Grid center;
	
	public Window(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 800);
		setLocationRelativeTo(null);
		setTitle("Simple Sudoku Solver");
		
		
		
		JPanel parentPanel = new JPanel(new BorderLayout(5, 5));
		
		JPanel top = new JPanel();
		BoxLayout box = new BoxLayout(top, BoxLayout.Y_AXIS);
		top.setLayout(box);
		
		center = new Grid();
		JPanel bottom = new JPanel();
		
		
		//LABELS
		JLabel label = new JLabel("Sudoku Solver");
		label.setFont(label.getFont().deriveFont(24.0f));
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		top.add(label);
		
		errorLabel = new JLabel();
		errorLabel.setForeground(Color.RED);
		errorLabel.setText("");
		errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		errorLabel.setPreferredSize(new Dimension(60, 20));
		top.add(errorLabel);
		
		
		//BUTTONS
		JButton solveButton = new JButton();
		solveButton.setText("Solve");
		solveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					int[][] data = center.getData();
					SudokuSolver solver = new SudokuSolver(data);
					boolean solved = solver.solve();
					if(solved){
						center.setData(solver.getGrid());
						errorLabel.setText("");
					}
					else
						setErrorMessage("Cannot Solve");
					
				} catch (IOException e1) {
					e1.printStackTrace();
					setErrorMessage("Non-valid input");
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
				clearAll();
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
	

	protected void clearAll() {

		center.clearAll();
		errorLabel.setText("");
	}


	protected void setErrorMessage(String error) {
		
		errorLabel.setText(error);
		
	}


	public static void main(String[] args)
	{
		Window w = new Window();
	}

}
