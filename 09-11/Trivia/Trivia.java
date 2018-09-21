import java.util.Scanner;
import java.util.Locale;

public class Trivia {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
		System.out.print("What color is the sky? ");
		String answer = keyboard.next();
		answer = answer.toLowerCase();
		if (  answer.equals("blue") ){
			System.out.println("good job");
		} else {
			System.out.println("sorry wrong answer");
		}
		System.out.print("What color is the water? ");
		answer = keyboard.next();
		answer = answer.toLowerCase();
		if (  answer.equals("blue") ){
			System.out.println("good job");
		} else {
			System.out.println("sorry wrong answer");
		}
	}
}