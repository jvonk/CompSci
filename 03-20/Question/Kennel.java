import java.util.ArrayList;

public class Kennel
{
	private ArrayList<Pet> petList = new ArrayList<Pet>();
	
	public void add(Pet newPet) {
		petList.add(newPet);
	}
	
	public void allSpeak() {
		for (Pet p : petList) {
			System.out.println(p.getName()+" "+p.speak());
		}
	}
}