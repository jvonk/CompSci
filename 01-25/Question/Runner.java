public class Runner
{
	public static void main(String args[])
	{
		Horse[] horseArray = new Horse[7];
		horseArray[0] = new AHorse("Trigger", 1340);
		horseArray[2] = new AHorse("Silver", 1210);
		horseArray[3] = new AHorse("Lady", 1575);
		horseArray[5] = new AHorse("Patches", 1350);
		horseArray[6] = new AHorse("Duke", 1410);
		HorseBarn sweetHome = new HorseBarn(horseArray);
		
		//Testing for Part A
		System.out.println("\nTesting for part A");
		sweetHome.showBarn();
		System.out.println("Location of Trigger: " + sweetHome.findHorseSpace("Trigger") );
		System.out.println("Location of Silver: " + sweetHome.findHorseSpace("Silver") );
		System.out.println("Location of Coco: " + sweetHome.findHorseSpace("Coco") );
		
		
		Horse[] horseArray2 = new Horse[7];
		horseArray2[0] = new AHorse("Trigger", 1340);
		horseArray2[2] = new AHorse("Silver", 1210);
		horseArray2[5] = new AHorse("Patches", 1350);
		horseArray2[6] = new AHorse("Duke", 1410);
		sweetHome = new HorseBarn(horseArray2);
		
		//Testing for Part B
		System.out.println("\nTesting for part B");
		System.out.println("Before consolidate:");
		sweetHome.showBarn();
		System.out.println("After consolidate:");
		sweetHome.consolidate();
		sweetHome.showBarn();

	}
}
