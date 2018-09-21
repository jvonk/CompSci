import java.util.Scanner;
import java.util.Locale;

public class Animal {
    public static void main(String[] args){
		System.out.println("   /\\_/\\   ");
		System.out.println("  / o o \\  ");
		System.out.println(" (   \"   ) ");
		System.out.println("  \\~(*)~/  ");
		System.out.println("   // \\\\   ");
        Scanner keyboard = new Scanner(System.in);
		System.out.print("What animal is it? ");
		String answer = keyboard.next();
		answer = answer.toLowerCase();
		if (  answer.equals("cat") ){
			System.out.println("good job");
		} else {
			System.out.println("sorry wrong answer");
		}
	}
}