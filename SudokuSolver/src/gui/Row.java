package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Row extends JPanel{
	
	JTextField[] textFields;
	
	public Row(){
		
		textFields = new JTextField[9];
		
		for(JTextField text: textFields)
		{
			text = new JTextField(1);
			text.setFont(text.getFont().deriveFont(40.0f));
			add(text);
		}
	}
}
