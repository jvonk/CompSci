public class Review {
	private int[] nums;
	public Review (int in) {
		nums = new int[in];
		for (int i = 0; i < in; i++) nums[i] = (int)(Math.random()*4+2);
	}
	public void printArray() {
		for(int num : nums) System.out.println(num);
	}
}