public class Distance {
    private double distance;
    public void setDistance(double x1, double y1, double x2, double y2) {
        distance=Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
    public double getDistance() {
        return distance;
    }
}