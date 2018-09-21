import java.util.Scanner;
import java.util.Random;

public class Trivia {
    public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		int score = 0;
		System.out.print("What do you want to do? geography or math? ");
		String answer = keyboard.next();
		int ans = 0;
		if (answer.equals("math")){
			double a = (int)(Math.random()*((10-1)+1))+1;
			double b = (int)(Math.random()*((10-1)+1))+1;
			System.out.print("What is the area of a triangle with height "+a+" and length "+b+"? ");
			double answ = keyboard.nextDouble();
			if ( answ == a*b/2.0 ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			a = (int)(Math.random()*((10-1)+1))+1;
			b = (int)(Math.random()*((4-1)+1))+1;
			System.out.print("What is "+a+" to the power of "+b+"? ");
			ans = keyboard.nextInt();
			if ( ans == Math.pow(a, b) ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			a = (int)(Math.random()*((10-1)+1))+1;
			b = (int)(Math.random()*((4-1)+1))+1;
			System.out.print("What is "+a+" times "+b+"? ");
			ans = keyboard.nextInt();
			if ( ans == a*b ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			a = (int)(Math.random()*((10-1)+1))+1;
			b = (int)(Math.random()*((4-1)+1))+1;
			System.out.print("What is "+a+" plus "+b+"? ");
			ans = keyboard.nextInt();
			if ( ans == a+b ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			a = (int)(Math.random()*((10-1)+1))+1;
			b = (int)(Math.random()*((4-1)+1))+1;
			System.out.print("What is "+a+" minus "+b+"? ");
			ans = keyboard.nextInt();
			if ( ans == a-b ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			a = (int)(Math.random()*((10-1)+1))+1;
			b = (int)(Math.random()*((3-1)+1))+1;
			System.out.print("What is "+a+" times "+b+" times "+b+"? ");
			ans = keyboard.nextInt();
			if ( ans == a*b*b ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			a = (int)(Math.random()*((10-1)+1))+1;
			b = (int)(Math.random()*((4-1)+1))+1;
			System.out.print("What is "+a+" plus "+b+" plus "+b+"? ");
			ans = keyboard.nextInt();
			if ( ans == a+b+b ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			a = (int)(Math.random()*((10-1)+1))+1;
			b = (int)(Math.random()*((4-1)+1))+1;
			System.out.print("What is the average of "+a+" and "+b+"? ");
			answ = keyboard.nextDouble();
			if ( answ == (a+b)*0.5 ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			a = (int)(Math.random()*((10-1)+1))+1;
			b = (int)(Math.random()*((4-1)+1))+1;
			System.out.print("What is "+a+" plus "+b+" plus "+b+" plus "+b+"? ");
			ans = keyboard.nextInt();
			if ( ans == a+b+b+b ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			a = (int)(Math.random()*((10-1)+1))+1;
			b = (int)(Math.random()*((3-1)+1))+1;
			System.out.print("What is "+a+" times "+b+" times "+b+" times "+b+"? ");
			ans = keyboard.nextInt();
			if ( ans == a*b*b*b ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			
		} else if (answer.equals("geography")) {
			System.out.print("What is the capital of France? ");
			answer = keyboard.next();
			if ( answer.equals("Paris") ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			System.out.print("What is the capital of California? ");
			answer = keyboard.next();
			if ( answer.equals("Sacremento") ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			System.out.print("What is the capital of Oregon? ");
			answer = keyboard.next();
			if ( answer.equals("Salem") ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			System.out.print("What is the capital of Spain? ");
			answer = keyboard.next();
			if ( answer.equals("Madrid") ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			System.out.print("What is the capital of England? ");
			answer = keyboard.next();
			if ( answer.equals("London") ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			System.out.print("What is the capital of Nevada? ");
			answer = keyboard.next();
			if ( answer.equals("Carson City") ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			System.out.print("What is the capital of Tennesse? ");
			answer = keyboard.next();
			if ( answer.equals("Nashville") ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			System.out.print("What is the capital of Texas? ");
			answer = keyboard.next();
			if ( answer.equals("Austin") ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			System.out.print("What is the capital of Connecticut? ");
			answer = keyboard.next();
			if ( answer.equals("New Haven") ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
			System.out.print("What is the capital of Massachusetts? ");
			answer = keyboard.next();
			if ( answer.equals("Boston") ){
				System.out.println("good job");
				score++;
			} else {
				System.out.println("sorry wrong answer ");
			}
		} else {
			System.out.println("THATS NOT RIGHT YOU IDIOT");
		}
		System.out.println(score+" answers were right out of 10");
	}
}