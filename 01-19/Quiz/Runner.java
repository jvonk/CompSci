public class Runner {
	public static void main (String[] args) {
		StringTest st = new StringTest("tom.smith@mvla.net");
		String res = st.getName();
		System.out.println(res);
		System.out.println((res=st.getDomain()));
		System.out.println(st); 
	}
}