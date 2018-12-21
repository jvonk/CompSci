public class Runner{
   public static void main(String args[]){
        int num1;
        int num2;
        int num3;
         
        //Version A
         
        //1) 10 Points - Constructors and Instance Variables
        System.out.println("\n\n1) Constructors and Instance Variables");
        //The class Final1 has an instance String variable called myName
        //The initialization constructor sets up myName
        //The default sets the instance variable, myName  to "World".
        Final1 myObject = new Final1("rm522");
        Final1 myObjectDefault = new Final1();
         
        //Prints out  "Hello " + myName given through the initialization constructor
        //Prints out  "Hello " + myName given through the default constructor
        //Method - printHello() : void
        System.out.print("Initialization: ");
        myObject.printHello();
        System.out.print("Default: ");
        myObjectDefault.printHello();
         
     
         
        //2) 10 Points - Number operations and the Math library
        //Given the formula for c of the pythagorean theorem
        //c is the square root of a^2 + b^2 
        //return the calculation of c given a and b using the Math Library for square root and power.
        //Method - getC(int, int) : double
        System.out.println("\n\n2) Number operations and the Math library");
        int a = (int) (Math.random() * 9) + 1;
        int b = (int) (Math.random() * 9) + 1;
        System.out.println("Find c:");
        System.out.println("a: " + a + ", b: " + b);
        double cValue = myObject.getC(a, b);
        System.out.println(cValue);
         
         
 
        //3) 10 Points - Logical Operator and Modulus
        System.out.println("\n\n3) Logical Operator and Modulus");
        //Using Logical Operator test if at least 2 of the 3 numbers are even
        //Return true if they are and false otherwise.
        //Method - checkAll(int, int, int) : boolean
        num1 = (int) (Math.random() * 4);
        num2 = (int) (Math.random() * 4);
        num3 = (int) (Math.random() * 4);
        System.out.println("num1: " +num1 + ", num2: " + num2 + ", num3 " + num3);
        boolean check = myObject.checkAll(num1, num2, num3);
        System.out.println("result:" + check);
         
         
        //4) 10 Points - Random Numbers
        //Method getRandomInt(int, int) : int
        System.out.println("\n\n4) Random Numbers");
        int min = (int) (Math.random() * 101);
        int max = (int) (Math.random() * 101) + min;
        System.out.println("min: " +min + ", max: " + max);
        //Return a random number between min and max inclusive.
        int randNum = myObject.getRandomInt(min, max);
        System.out.println("randNum: " + randNum);
         
         
        //5) 10 Points - Switch and if-else
        //Method - getIfElse(int, int) : int
        //Method - printSwitch(int) : void
        System.out.println("\n\n5) switch if-else-if");
        num1 = (int) (Math.random() * 9);
        num2 = (int) (Math.random() * 9);
        System.out.println("num1: " + num1 + ", num2: " + num2);
         
        //Use if-else-if. If two of them are the same return 5. If one of them is a 7, return 3. Otherwise return 0. 
        int result = myObject.getIfElse(num1, num2);
        System.out.println("if-else-if result: " + result);
         
        //Use a switch for num2. Given 1 print "cat", Given 2 print "dog", Given 3 print "chicken", Given anything else print "not valid"
        System.out.print("switch result: ");
        myObject.printSwitch(num2);
         
         
        //6) 10 Points - While loop
        System.out.println("\n\n6) while loop");
        //You must use a while loop
        //You will print counting down from num1 to num2 (inclusive) by 1 assuming num1 is always greater than num2.
        //Method - countWhile(int,int) : void
        num2 = (int) (Math.random() * 11);
        num1 = (int) (Math.random() * 11) + 11;
        System.out.println("num1: " + num1 + ", num2: " + num2);
        myObject.countWhile(num1, num2);
         
         
        //7) 10 Points - For Loop 
        System.out.println("\n\n7) for loop 1");
        //You must use a for loop. Return the factorial.
        //That means multiplying all the numbers from 1 to that number inclusive.
        //Method - getFactorial(int) : int
        num1 = (int) (Math.random() * 6 + 1);
        System.out.println("num1: "  + num1);
        int factorial = myObject.getFactorial(num1);
        System.out.println("factorial: " + factorial);
         
         
        //8) 10 Points - For Loop
        System.out.println("\n\n8) for loop 2");
        //You must use a for loop. Return the summation.
        //That means adding all the numbers from 1 to that number inclusive.
        //Method - getSummation(int) : int
        num1 = (int) (Math.random() * 6 + 1);
        System.out.println("num1: "  + num1);
        int summation = myObject.getSummation(num1);
        System.out.println("summmation:" +summation);
         
         
         
         
        //9) 10 Points - Array Exercise 1
        //Find the summation of an array with the exception of the number 13.
        //That means to add all the numbers in the array.
        //Method - getSummation(int[]) : int
        System.out.println("\n\n9) Array 1");
        int[] array1 = {4,3,13,5,6};
        int[] array2 = {4,1,5,2,9};
         
        int result1 = myObject.getSummation(array1);
        System.out.println("result1:"+result1);
         
        int result2 = myObject.getSummation(array2);
        System.out.println("result2:"+result2);
         
         
        //10) 10 Points - Array Exercise 2
        //Return true of all the elements are either a 1 or a 5.
        //Method - check15(int[]) : boolean
        System.out.println("\n\n10) Array 2");
        int[] array3 = {1,3,1,5,1};  //->false
        int[] array4 = {1,1,5,1,5};  //->true
         
        boolean result3 = myObject.check15(array3);
        System.out.println("result3:"+result3);
         
        boolean result4 = myObject.check15(array4);
        System.out.println("result4:"+result4);
         
         
 
   }//End Main 
}//End Class