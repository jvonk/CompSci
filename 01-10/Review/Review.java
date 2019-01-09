public class Review {
    private int[] nums;
    public Review (int len) {
        nums = new int[len];
        for (int i = 0; i < nums.length; i++) nums[i] = (int)(Math.random()*101+1);
    }
    public void printArray() {
        for(int num: nums) System.out.println(num);
    }
    public int getLargest() {
        int max = Integer.MIN_VALUE;
        for(int num: nums) max = Math.max(max, num);
        return max;
    }
}