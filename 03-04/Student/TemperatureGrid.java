public class TemperatureGrid
{
	/** A two-dimensional array of temperature values, initialized in the constructor (not shown)
	* Guaranteed not to be null
	*/
	private double[][] temps;
	
	public TemperatureGrid(double[][] temps)
	{
		this.temps = temps;
	}
	
	public double testA(int row, int col)
	{
		return computeTemp(row, col);
	}
	
	/** Computes and returns a new temperature value for the given location.
	* @param row a valid row index in temps
	* @param col a valid column index in temps
	* @return the new temperature for temps[row][col]
	*- The new temperature for any element in the border of the array is the
	*same as the old temperature.
	*- Otherwise, the new temperature is the average of the four adjacent entries.
	* Postcondition: temps is unchanged.
	*/
	private double computeTemp(int row, int col) { /* to be implemented in part (a) */
		if (row==0||col==0||row==temps.length-1||col==temps[row].length-1) return temps[row][col];
		return (temps[row+1][col] + temps[row-1][col] + temps[row][col+1] + temps[row][col-1])/4;
	}
	
	
	/** Updates all values in temps and returns a boolean that indicates whether or not all the
	* new values were within tolerance of the original values.
	* @param tolerance a double value >= 0
	* @return true if all updated temperatures are within tolerance of the original values;
	* false otherwise.
	* Postcondition: Each value in temps has been updated with a new value based on the
	*corresponding call to computeTemp.
	*/
	public boolean updateAllTemps(double tolerance) { /* to be implemented in part (b) */
		boolean within = true;
		double[][] better = new double[temps.length][];
		for (int i = 0; i < temps.length; i++) {
			better[i]=new double[temps[0].length];
			for (int j = 0; j < temps[0].length; j++) {
				double val = computeTemp(i, j);
				if (Math.abs(temps[i][j]-val)>=tolerance) within=false;
				better[i][j] = val;
			}
		}
		temps=better;
		return within;
	}
	
	public void printTable()
	{
		for(int r=0; r<temps.length; r++)
		{
			for(int c=0; c<temps[r].length; c++)
			{
				System.out.print(temps[r][c] + "\t");
			}
			System.out.println();
		}
	}
	
	// There may be instance variables, constructors, and methods that are not shown.
}
