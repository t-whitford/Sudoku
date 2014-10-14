package main;


public class SudokuSolver {
	
	private int[][] grid = new int[9][9]; 

	/**
	 * @param sudoku - a 9 x 9 grid containing all known numbers in the grid.
	 */
	public SudokuSolver(int[][] sudoku) {
		super();
		this.grid = sudoku;
	}

	/**
	 * Solves the sudoku. Access it using .getGrid() 
	 * @return True if the sudoku has been solved, false if it failed
	 */
	public boolean solve()
	{
		//Check known inputs are valid - attempt to stop hanging
		if(!checkUserInputs())
			return false;

		
		//Always copy arrays!
		int[][] newgrid = new int[9][9];
		for(int a = 0; a < 9; a++)
			for(int b = 0; b < 9; b++)
				newgrid[a][b] = grid[a][b];
		
		SudokuSolver temp = new SudokuSolver(newgrid);
		
		//Start recursive call
		temp = temp.solveRecursively();
		
		//If !null return true - solved
		if(temp != null)
		{
			grid = temp.getGrid();
			return true;
		}
		
		return false;
	}
	
	/**
	 * Checks all the user inputs as to whether or not they break any rules in the current grid.
	 * This does not guarantee the grid is solvable.
	 * @return True if all user inputs are valid with current known grid.
	 */
	private boolean checkUserInputs() {
		
		for(int x = 0; x < 9; x++)
		{
			for(int y = 0; y < 9; y++)
			{
				if(grid[x][y] != 0)
				{
					boolean isValid = isValid(grid[x][y], x, y);
					if(!isValid)
						return false;
				}
			}
		}
		return true;
	}

	/**
	 * Recursive method to brute-force the result.
	 * 
	 * @return The completed object or null if cannot be found
	 */
	private SudokuSolver solveRecursively()
	{		
		//Find empty spot
		//Find first valid number
		//Add it call method again
		//If returns null, try next number
		//If returns object, result found - return object
		
		//Max depth < 90 - no memory worry.
		
		
		for(int x = 0; x < 9; x++)
		{
			for(int y = 0; y < 9; y++)
			{
				if(grid[x][y] == 0)
				{
					for(int i = 1; i < 10; i++)
					{
						if(isValid(i, x, y))
						{
							//Create array copy
							int[][] newgrid = new int[9][9];
							for(int a = 0; a < 9; a++)
								for(int b = 0; b < 9; b++)
									newgrid[a][b] = grid[a][b];
							
							SudokuSolver newSolver = new SudokuSolver(newgrid);
							newSolver.add(i, x, y);
							newSolver = newSolver.solveRecursively();
							if(newSolver != null)
								return newSolver;
						}
					}
					return null;
				}
				//First return
				if(x == 8 && y == 8)
					return this;
			}
		}
		return null;
	}
	
	/**
	 * Utility class to add a single number to the grid.
	 * @param i The number to add
	 * @param x x position in the grid
	 * @param y y position in the grid
	 */
	private void add(int i, int x, int y) {

		grid[x][y] = i;
		
	}

	/**
	 * 
	 * @param i Number to check
	 * @param x x position
	 * @param y y position
	 * @return false if i already is in the line, column or 3x3 grid. True otherwise 
	 */
	private boolean isValid(int i, int x, int y)
	{
//		if(grid[x][y] != 0)
//			return false;
		if(inRow(i, x, y) || inGrid(i, x, y) || inColumn(i, x, y))
			return false;
		return true;
	}

	/**
	 * 
	 * @param i Number to check
	 * @param x x position
	 * @param y y position
	 * @return Whether i already exists in the row
	 */
	private boolean inRow(int i, int x, int y) {
		
		for(int j = 0; j < 9; j++)
		{
			if(y != j && grid[x][j] == i)
				return true;
		}
		
		return false;
		
	}

	/**
	 * 
	 * @param i Number to check
	 * @param x x position
	 * @param y y position
	 * @return Whether i already is in the grid
	 */
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

	/**
	 * 
 	 * @param i Number to check
	 * @param x x position
	 * @param y y position @return
	 * @return Whether i already exists in the column
	 */
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
		System.out.println(toString());
	}

	/**
	 * Converts the grid into a readable string (Lines of 9)
	 */
	@Override
	public String toString()
	{
		String string = "";
		for(int[] row: grid)
		{
			for(int num: row)
			{
				if(num == 0)
					string = string + ("- ");
				else
					string = string + (num + " ");
			}
			string = string + "\n"; 
		}
		return string;
	}
	
	/**
	 * @return The grid in it's current state
	 */
	public int[][] getGrid() {
		return grid;
	}
}
