package gui;
import java.awt.Component;
import java.awt.Container;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Grid extends JPanel{
	
	Row[] rows;
	
	Grid(){

		rows = new Row[9];
		
		for(Row row: rows)
		{
			row = new Row();
			add(row);
		}
				
	}
	
	public void clearAll()
	{
		Component[] comps = this.getComponents();
		for(Component comp: comps)
		{
			((Row) comp).clearAll();
		}
	}
	
	
	public int[][] getData() throws IOException
	{
		int[][] data = new int[9][9];
		
		Component[] comps = this.getComponents();
		for(int i = 0; i < 9; i++)
		{
			data[i] = ((Row)comps[i]).getData();
		}
		
		return data;
	}

	public void setData(int[][] grid) {
		
		Component[] comps = this.getComponents();
		for(int i = 0; i < 9; i++)
		{
			((Row) comps[i]).setData(grid[i]);
		}
		
	}

}
