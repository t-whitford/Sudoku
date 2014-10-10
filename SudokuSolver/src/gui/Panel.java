package gui;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Panel extends JPanel{
	
	Row[] rows;
	
	Panel(){

		rows = new Row[9];
		
		for(Row row: rows)
		{
			row = new Row();
			add(row);
		}
				
	}

}
