public class Loop {
    private int min;
    private int max;

    public Loop(int in, int ax) {
        min = in;
        max = ax;
    }

    public void countWhile() {
        int count = min;
        while (count <= max) {
            System.out.println(count++);
        }
    }

    public int getSum() {
        int total = 0;
        int count = min;
        do {
            total += count++;
        } while (count < max);
        return total;
    }
}