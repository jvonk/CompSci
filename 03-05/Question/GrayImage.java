public class GrayImage {
    public static final int BLACK = 0;
    public static final int WHITE = 255;


    /**
     * The 2-dimensional representation of this image. Guaranteed not to be null.
     * All values in the array are within the range [BLACK, WHITE], inclusive.
     */
    private int[][] pixelValues;

    public GrayImage(int[][] pixelValues) {
        this.pixelValues = pixelValues;
    }


    /**
     * @return the total number of white pixels in this image.
     * Postcondition: this image has not been changed.
     */
    public int countWhitePixels() {  /* to be implemented in part (a) */
        int sum = 0;
        for (int i = 0; i < pixelValues.length; i++) {
            for (int j = 0; j < pixelValues[i].length; j++) {
                if (pixelValues[i][j] == WHITE) sum++;
            }
        }
        return sum;
    }

    public void processImage() {  /* to be implemented in part (b) */
        int[][] better = new int[pixelValues.length][pixelValues[0].length];
        for (int i = 0; i < pixelValues.length; i++) {
            for (int j = 0; j < pixelValues[i].length; j++) {
                better[i][j]=Math.max(BLACK, pixelValues[i][j]-(i<pixelValues.length-2&&j<pixelValues[i].length-2?pixelValues[i+2][j+2]:0));
            }
        }
        pixelValues=better;
    }

    public void printPixels() {
        for (int row = 0; row < pixelValues.length; row++) {
            for (int col = 0; col < pixelValues[row].length; col++) {
                System.out.print(pixelValues[row][col] + "\t");
            }
            System.out.println("");
        }
    }
}