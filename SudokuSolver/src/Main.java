import java.util.Scanner;


public class Main {
	
	int[][] grid = new int[9][9]; 

	public Main(int[][] sudoku) {
		super();
		this.grid = sudoku;
	}



	private void solve() {

		boolean solved = false;
		
		while(!solved)
		{
			//For each square, try solve
			for(int x = 0; x < 9; x++)
			{
				for(int y = 0; y < 9; y++)
				{
					//System.out.println("Square: " + x +"," + y + " = " + grid[x][y]);
					if(grid[x][y] == 0)
					{
						grid[x][y] = solveSquare(x, y);
					}
				}
			}
			
			solved = isGridSolved();
		}
		
	}


	private boolean isGridSolved() {
		for(int[] row: grid)
		{
			for(int i: row)
			{
				if(i == 0)
					return false;
			}
		}
		return true;
	}



	private int solveSquare(int x, int y) {
		for(int i = 1; i < 10; i++)
		{
			if(isValid(i, x, y))
			{
				if(!fitsElsewhere(i, x, y))
				{
					return i;
				}
			}
		}
		
		return 0;
	}



	private boolean fitsElsewhere(int i, int x, int y) {
		
		boolean fitsSomewhereInRow = false;
		boolean fitsColumn = false;
		boolean fitsGrid = false;
		
		for(int j = 0; j < 9; j++)
		{
			if(j != y)
			{
				if(isValid(i, x, j))
					fitsSomewhereInRow = true;
			}
		}
		
		for(int j = 0; j < 9; j++)
		{
			if(j != x)
			{
				if(isValid(i, j, y))
					fitsColumn = true;
			}
		}
		
		for(int j = (x / 3) * 3 ; j < (x/ 3) *3 + 3; j++)
		{
			for(int k = (y / 3) * 3; k < (y /3) *3 + 3; k++)
			{
				if(j != x || k != y)
				{
					if(isValid(i, j, k))
						fitsGrid = true;
				}
			}
		}
		
		if(!fitsSomewhereInRow || !fitsColumn || !fitsGrid)
			return false;
		else
			return true;
	}


	private boolean isValid(int i, int x, int y)
	{
		if(grid[x][y] != 0)
			return false;
		if(inRow(i, x, y) || inGrid(i, x, y) || inColumn(i, x, y))
			return false;
		return true;
	}

	private boolean inRow(int i, int x, int y) {
		
		for(int j = 0; j < 9; j++)
		{
			if(y != j && grid[x][j] == i)
				return true;
		}
		
		return false;
		
	}

	private boolean inGrid(int i, int x, int y) {

		int gridX = x / 3;
		int gridY = y / 3;
		
		for(int j = gridX * 3; j < (gridX * 3) + 3; j++)
		{
			for(int k = gridY * 3; k < (gridY * 3) + 3; k++)
			{

				if(j != x && k != y)
					if(grid[j][k] == i)
						return true;
			}
		}
		return false;
	}



	private boolean inColumn(int i, int x, int y) {

		for(int j = 0; j < 9; j++)
		{
			if(j != x && grid[j][y] == i)
				return true;
		}
		return false;
	}



	public void printGrid()
	{
		for(int[] row: grid)
		{
			for(int num: row)
			{
				if(num == 0)
					System.out.print("- ");
				else
					System.out.print(num + " ");
			}
			System.out.println();
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Hello.");
		//Create grid
		int[][] sudoku = new int[9][9]; 
		
		Scanner input = new Scanner(System.in);
		
		
		for(int i = 0; i < 9; i++)
		{
			System.out.println("Please enter line " + (i+1) + " with a '-' in place of unknown numbers");
			//String in = input.next();
			String in = args[i];
			
			for(int j = 0; j < 9; j++)
			{
				int sq;
				char c = in.charAt(j);
				
				if(c != '-')
					sudoku[i][j]  = Character.getNumericValue(c);
				}
				
			}
			
		
		
		Main s = new Main(sudoku);
		
		s.printGrid();
		s.solve();
		System.out.println();
		s.printGrid();
	}
}
