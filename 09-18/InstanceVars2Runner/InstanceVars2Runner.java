public class InstanceVars2Runner{
    public static void main(String[] args){
        int num1 = 1002;
        InstanceVars2 test = new InstanceVars2();
 
        //(1) What is the difference between the two lines of code below?
		//The first one refrences the variable in the InstanceVars2Runner class and the second refrences the one in the InstanceVars2 class
        //(2) What is the result?
		//The first one outputs 1002 and the second outputs 8
        System.out.println(num1);
        System.out.println(test.num1);
        System.out.println();
         
        //(3) Uncomment and describe what you think is happening below? Why?
		//In this code, it first prints the name wich is "defualt" and then changes it because it is public to "John" and then prints it again getting "John"
        System.out.println(test.userName);
        test.userName = "John";
        System.out.println(test.userName);
        System.out.println();
         
        //(4) Describe what you think is happening below?
		//test.add() sets test.answer to 8+3 = 11 and then test.print() prints the answer as 11
        test.add();
        test.print();
        System.out.println();
         
        //(5) Which line(s) does not work? why?  Uncomment the lines below to test.
		//the last one because test.answer is private so you cannot access it.
        System.out.println( test.num1 );
        System.out.println( test.num2 );
        //System.out.println( test.answer );
         
        //(6) Does it print 5 or 11? Why?
		//It prints 11 because it set test.num1 and test.num2 to 2 and 3 respectively and the sum is not 5 because it never test.add() them
        test.num1 = 2;
        test.num2 = 3;
        test.print();
        System.out.println();
         
        //(7) Does it print 5 or 11? Why?
		//11 because now it actually adds test.num1 and test.num2 to get 5 and prints that.  
        test.add();
        test.print();
        System.out.println();
    }
}