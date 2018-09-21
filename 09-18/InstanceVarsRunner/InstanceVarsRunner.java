public class InstanceVarsRunner{
   public static void main(String[] args){
      //(1) What is the name of the reference variable?
	  //it is "test"
      InstanceVars test = new InstanceVars();
 
      //(2) What does this print?
	  //It prints 0
      test.print();
 
      //(3) What happens to the variable answer of the InstanceVars class after you call test.add()?
	  //answer is set to 8+3
      test.add();
 
      //(4) What is the final result?
	  //It is 11
      test.print();
       
   }
}