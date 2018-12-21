public class Final1 {
	private String myName;
	public Final1 () {
		myName = "World";
	}
	public Final1 (String in) {
		myName = in;
	}
	public void printHello() {
		System.out.println("Hello "+myName);
	}
	public double getC (int a, int b) {
		return Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));
	}
	public boolean checkAll (int a, int b, int c) {
		return (a%2==0&&b%2==0 || b%2==0&&c%2==0 || a%2==0&&c%2==0);
	}
	public int getRandomInt(int min, int max) {
		return (int)(Math.random()*(max-min+1)+min);
	}
	public int getIfElse (int a, int b) {
		if (a==b) return 5;
		else if (a==7||b==7) return 3;
		else return 0;
	}
	public void printSwitch(int a) {
		switch(a) {
			case 1: System.out.println("cat");
			break;
			case 2: System.out.println("dog");
			break;
			case 3: System.out.println("chicken");
			break;
			default: System.out.println("not valid");
			break;
		}
	}
	public void countWhile (int num1, int num2) {
		while (num1 >= num2) System.out.println(num1--);
	}
	public int getFactorial(int in) {
		int res = 1;
		for (int i = 2; i <= in; i++) res*=i;
		return res;
	}
	public int getSummation(int in) {
		int res = 0;
		for (int i = 0; i <= in; i++)res+=i;
		return res;
	}
	public int getSummation(int[] arr) {
		int res = 0;
		for (int i = 0; i < arr.length; i++)res+=arr[i]==13?0:arr[i];
		return res;
	}
	public boolean check15(int[] arr) {
		for(int a: arr) if (a!=1&&a!=5) return false;
		return true;
	}
}