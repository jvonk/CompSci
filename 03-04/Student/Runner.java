public class Runner
{
	public static void main(String[] args)
	{
	
		
		
		double[][] temps = new double[][]{
			  { 95.5, 100.0, 100.0, 100.0, 100.0, 110.3},
			  { 0.0, 50.0, 50.0, 50.0, 50.0, 0.0 },
			  { 0.0, 40.0, 40.0, 40.0, 40.0, 0.0 },
			  { 0.0, 20.0, 20.0, 20.0, 20.0, 0.0 },
			  { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, }
			};
		
		TemperatureGrid tg = new TemperatureGrid(temps);
		
		System.out.println("Testing for Part A");
		System.out.println(tg.testA(2, 3));
		System.out.println(tg.testA(1, 1));
		System.out.println(tg.testA(0, 2));
		System.out.println(tg.testA(1, 3));
		System.out.println();
		
		System.out.println("Testing for Part B");
		System.out.println("Old Table");
		tg.printTable();
		
		System.out.println("New Table");
		boolean result = tg.updateAllTemps(0);
		tg.printTable();
		System.out.println("Within Tolerence = " + result );
		
		
	}
}
