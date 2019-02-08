import java.util.*;
public class Runner {
	public static void main (String[] args) {
		ArrayListQuiz2 aq = new ArrayListQuiz2();
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(1234, "John"));
		studentList.add(new Student(3333, "Jen"));
		studentList.add(new Student(1111, "Jose"));
		studentList.add(new Student(4321, "Jane"));
		aq.printList(studentList);
		aq.scramble(studentList);
		aq.printList(studentList);
		aq.sort(studentList);
		aq.printList(studentList);
	}
}