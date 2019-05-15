import java.util.ArrayList;
public class Runner{
	public static void main(String[] args){
		int row = (int)(Math.random()*3+1);
		int col = (int)(Math.random()*3+1);
		int[][] matrix = new int[row][col];
		for(int r=0; r<matrix.length; r++){
			for(int c=0; c<matrix[r].length; c++){
				matrix[r][c] = (int)(Math.random()*90+10);
			}
		}
		
		ArrayList<Profile> profileList = new ArrayList<Profile>();
		profileList.add(new Professor("John", 35));
		profileList.add(new Professor("Jen", 38));
		profileList.add(new Politician("Heather", 34));
		profileList.add(new Politician("Bob", 37));
		if( (int)(Math.random()*2) == 0 ){
			profileList.add(new Politician("Carla", 35));
		}
		
		String word1 = "soup";
		String word2 = "hello";

		Test test = new Test();

		System.out.println("Print Table row:"+row+" col:"+col);
		test.printTable(matrix);
		
		System.out.println("\nFind Smallest");
		System.out.println(test.findSmallest(matrix));
		
		System.out.println("\nPrint Profile List");
		test.printProfileList(profileList);
		
		System.out.println("\nAverage Age of Profile List");
		System.out.println(test.averageAge(profileList));

		System.out.println("\nSort Profile List by Age from greatest to least");
		test.sortProfileList(profileList);
		test.printProfileList(profileList);
		
		System.out.println("\nPig Latin Test");
		System.out.println(test.getPigLatin(word1));
		System.out.println(test.getPigLatin(word2));
	}
}
