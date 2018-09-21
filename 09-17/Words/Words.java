import java.util.Scanner;

public class Words {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What is a verb: ");
		String verb = keyboard.next();
		System.out.print("What is a noun: ");
		String noun = keyboard.next();
		System.out.println("The " + noun + " " + verb + "s.");
	}
}