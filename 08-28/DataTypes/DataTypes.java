
public class DataTypes {
    public static void main(String args[]) {
        //(1) What type of numbers do you think
        //the variable one, two, three, and four are? 
        //(integers or decimals)
		// they are all integers
        byte one = 5;
        System.out.println(one);
          
        short two = 7;
        System.out.println(two);
          
        int three = 8;
        System.out.println(three);
          
        long four = 9;
        System.out.println(four);
          
        //(2) What type of numbers do you think the variable
        //five and six are? (integers or decimals)
		//they are all decimals
      
        float five = 5.2f;
        System.out.println(five);
          
        double six = 190.34;
        System.out.println(six);
          
          
        //(3) What data type is seven?
		// seven is a char or character
        char seven = 'c';
        System.out.println(seven);
          
        //(4) What happens if you uncomment and run this code below?
		//It doesn't work and you get a runtime error because three is an int which is a integer and 7.3 is a decimal and not an integer. 
        //three = 7.3;
        //System.out.println(three);    
          
        //(5) What does it print below?  
        //Challenge: Why doesn't it print 65?
		//Because 65 is not a char or character that is part of ASCII on the other hand, 65 stands for a character in ASCII and it prints that because seven is of type char. 
        seven = 65;
        System.out.println(seven);
          
          
        //(6) What is the output? A number or a word?
		//The output is a word because a boolean is either true or false so instead of printing 0 or 1 it prints false and true. 
        boolean eight = true;
        System.out.println(eight);
          
        //(7) What happens when you replace the variable eight with a number?
		// When you replace eight with a number, you get a runtime error because a boolean can only be assigned to true or false and takes up one bit and a number takes up more. 
        eight = false;
        System.out.println(eight); 
    }
}
