public class Grade {
    double score1, score2, score3;
    public Grade(double one, double two, double three) {
        score1 = one;
        score2 = two;
        score3 = three;
    }
    public boolean checkPass() {
        return ((score1 > 90 || score2 > 90 || score3 > 90) || (score1 > 80 && score2 > 80 || score1 > 80 && score3 > 80 || score2 > 80 && score3 > 80) || (score1 >70 && score2>70 &&score3>70));
    }
}