import java.util.*;
public class WarmUp {
    private int[][] numMatrix;
    public WarmUp(int[][] in) {
        numMatrix=in;
    }
    public void print() {
        for (int i = 0; i < numMatrix.length; i++) {
            for (int j = 0; j < numMatrix[i].length; j++) {
                System.out.print(numMatrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public int findLargest() {
        return Arrays.stream(numMatrix).flatMapToInt(Arrays::stream).max().getAsInt();
    }
}