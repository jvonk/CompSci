import java.util.Scanner;
 
public class NextLineIssue {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
         
        System.out.print("Enter an integer :: ");
        int num = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Enter a sentence :: ");
        String sentence = keyboard.nextLine();
        System.out.println(sentence);
         
        //What is the problem when running this code?
		//It skips over the nextLine unless yu enter something after the integer, and then you still miss the text. If you press enter and then a letter, it crashes. 
		//Only happens if you capture something prior.
    }
}