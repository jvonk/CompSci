public class ParametersTestRunner{
    public static void main(String[] args){
       ParametersTest testObj = new ParametersTest();
        
       //(1) Describe what is happening with the two lines of code below.
       //it sets the answer to 5*7 and then prints it 
       testObj.times(5, 7);
       testObj.printAnswer();
       System.out.println();
        
       //(2)  Describe what is happening with the two lines of code below.
       //It sets answerDec to 3/2 and prints it 
       testObj.divide(3, 2);
       testObj.printAnswerDec();
       System.out.println();
        
       //(3) Describe what is happening with the two lines of code below.
       //it sets the word to "Hello Java." and prints it
       testObj.setWord("Hello Java.");
       testObj.printWord();
       System.out.println();
        
       //(4) Analyze the following 4 modifyAnswer* methods.
       //Which one of these work properly? and Why?
       //All except modifyAnswer2 and modifyAnswer4 because these have the same name for the input as the global variable answer
       testObj.modifyAnswer1(101);
       testObj.printAnswer();
        
       testObj.modifyAnswer2(102);
       testObj.printAnswer();
        
       testObj.modifyAnswer3(103);
       testObj.printAnswer();
        
       testObj.modifyAnswer4(104);
       testObj.printAnswer();
    }
}