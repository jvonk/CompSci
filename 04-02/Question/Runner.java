public class Runner
{
	public static void main(String args[])
	{
	
		System.out.println("Part A");
		
		
		double[] view1D = new double[12];
		view1D[0] = 0.3;
		view1D[1] = 0.7;
		view1D[2] = 0.8;
		view1D[3] = 0.4;
		view1D[4] = 1.4;
		view1D[5] = 1.1;
		view1D[6] = 0.2;
		view1D[7] = 0.5;
		view1D[8] = 0.1;
		view1D[9] = 1.6;
		view1D[10] = 0.6;
		view1D[11] = 0.9;
		SkyView sv = new SkyView(4,3,view1D);
		sv.printSky();
		
		System.out.println("\n");
		
		view1D = new double[6];
		view1D[0] = 0.3;
		view1D[1] = 0.7;
		view1D[2] = 0.8;
		view1D[3] = 0.4;
		view1D[4] = 1.4;
		view1D[5] = 1.1;
		sv = new SkyView(3,2,view1D);
		sv.printSky();
		
		
		System.out.println("\n\nPart B");
		
		view1D = new double[12];
		view1D[0] = 0.3;
		view1D[1] = 0.7;
		view1D[2] = 0.8;
		view1D[3] = 0.4;
		view1D[4] = 1.4;
		view1D[5] = 1.1;
		view1D[6] = 0.2;
		view1D[7] = 0.5;
		view1D[8] = 0.1;
		view1D[9] = 1.6;
		view1D[10] = 0.6;
		view1D[11] = 0.9;
		sv = new SkyView(4,3,view1D);
		System.out.println(sv.getAverage(1,2,0,1));
		
		
	}
}
