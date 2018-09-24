public class ParametersTest{
    private int answer;
    private double answerDec;
    private String word;
     
    public void printAnswer(){
        System.out.println(answer);
    }
     
    public void printAnswerDec(){
        System.out.println(answerDec);
    }
     
    public void printWord(){
        System.out.println(word);
    }
     
    public void times(int num1, int num2){
        answer = num1 * num2;
    }
     
    public void divide(double num1, double num2){
        answerDec = num1 / num2;
    }
     
    public void setWord(String wordInput){
        word = wordInput;
    }
     
    public void modifyAnswer1(int answerInput){
        answer = answerInput;
    }
     
    public void modifyAnswer2(int answer){
        answer = answer;
    }
     
    public void modifyAnswer3(int answer){
        this.answer = answer;
    }
     
    public void modifyAnswer4(int answerInput){
        answerInput = answer;
    }
     
}