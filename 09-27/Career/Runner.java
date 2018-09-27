import java.util.Scanner;
public class Runner {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        Career p1 = new Career("John", 15, "math", "movies", "pizza");
        Career p2 = new Career("Elizabeth", 12, "english", "video games", "pizza");
        Career p3 = new Career("Macaron", 11, "french", "movies", "popcorn");
        p1.printInfo();
        p2.printInfo();
        p3.printInfo();
        loop: while (true) {
            int careerName = -1;
            while (!(careerName == 1 || careerName == 2 || careerName == 3 || careerName == 0)) {
                System.out.print("career to change (1, 2, 3) or 0 to quit: ");
                careerName = kb.nextInt();
                if (careerName == 0) {
                    break loop;
                }
            }
            System.out.print("name: ");
            String name = kb.next();
            System.out.print("age: ");
            int age = kb.nextInt();
            String subject = "";
            while(!(subject.equals("math") || subject.equals("english") || subject.equals("french"))) {
                System.out.print("subject: ");
                subject = kb.next();
            }
            String hobby = "";
            while(!(hobby.equals("movies") || hobby.equals("video"))) {
                System.out.print("hobby: ");
                hobby = kb.next();
            }
            String food = "";
            while(!(food.equals("popcorn") || food.equals("pizza"))) {
                System.out.print("food: ");
                food = kb.next();
            }
            if (careerName == 1) {
                p1.updateProfile(name, age, subject, hobby, food);
                p1.printInfo();
            } else if (careerName == 2) {
                p2.updateProfile(name, age, subject, hobby, food);
                p2.printInfo();
            } else if (careerName == 3) {
                p3.updateProfile(name, age, subject, hobby, food);
                p3.printInfo();
            }
        }
    }
}