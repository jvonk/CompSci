public class WarmUp {
    private int[][] numMatrix = new int[4][5];
    public WarmUp () {
        for (int i = 0; i < numMatrix.length; i++) {
            for (int j = 0; j < numMatrix[i].length; j++) {
                numMatrix[i][j] = (int)(Math.random()*5+1);
            }
        }
    }
    public void print() {
        for (int i = 0; i < numMatrix.length; i++) {
            for (int j = 0; j < numMatrix[i].length; j++) {
                System.out.print(numMatrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public void find(int goal) {
        for (int i = 0; i < numMatrix.length; i++) {
            for (int j = 0; j < numMatrix[i].length; j++) {
                if (numMatrix[i][j]==goal) numMatrix[i][j]=99;
            }
        }
    }
}