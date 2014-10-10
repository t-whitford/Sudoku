package gui;

import java.awt.Component;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

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

	public void clearAll() {
		Component[] comps = this.getComponents();
		for(Component comp: comps)
		{
			((JTextField) comp).setText(null);
		}
	}


	public int[] getData() throws IOException
	{
		int[] data = new int[9];

		Component[] comps = this.getComponents();
		for(int i = 0; i < 9; i++)
		{
			try {
				String in = ((JTextComponent) comps[i]).getText();

				if(in.isEmpty())
					data[i] = 0;

				else{
					Integer integer = new Integer(in);
					if(integer.intValue() < 1 || integer.intValue() > 9)
						throw new NumberFormatException();
					data[i] = integer.intValue();
				}
			} catch (NumberFormatException e) {
				System.out.println("Input error");
				throw new IOException();
			}
		}
		
		return data;
	}

	public void setData(int[] data) {
		Component[] comps = this.getComponents();
		for(int i = 0; i < 9; i++)
		{
			if(data[i] == 0)
				((JTextField)comps[i]).setText("");
			else{
				((JTextField)comps[i]).setText("" + data[i]);
			}
		}
		
	}
	
}
