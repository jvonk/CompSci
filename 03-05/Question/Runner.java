public class Runner
{
	public static void main(String args[])
	{
		int[][] pixelValue = new int[4][5];
		pixelValue[0][0] = 255;
		pixelValue[0][1] = 184;
		pixelValue[0][2] = 178;
		pixelValue[0][3] = 84;
		pixelValue[0][4] = 129;
		pixelValue[1][0] = 84;
		pixelValue[1][1] = 255;
		pixelValue[1][2] = 255;
		pixelValue[1][3] = 130;
		pixelValue[1][4] = 84;
		pixelValue[2][0] = 78;
		pixelValue[2][1] = 255;
		pixelValue[2][2] = 0;
		pixelValue[2][3] = 0;
		pixelValue[2][4] = 78;
		pixelValue[3][0] = 84;
		pixelValue[3][1] = 130;
		pixelValue[3][2] = 255;
		pixelValue[3][3] = 130;
		pixelValue[3][4] = 84;
		
		GrayImage run1 = new GrayImage(pixelValue);
		run1.printPixels();
		
		//Testing for part A
		System.out.println("\nTesting for part A");
		System.out.println("White Pixels: " + run1.countWhitePixels() );
		
		//Testing for part B
		System.out.println("\nTesting for part B");
		run1.processImage();
		run1.printPixels();
	
	}
}