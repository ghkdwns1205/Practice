package ClassArray;

public class A_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		C c = new C();
		B b = new B();
		String[] array = new String[4];
//		System.out.println(b.c);
//		System.out.println(b.str);
		c.Scan(b);
		
		System.out.println("str : "+ b.str);
		System.out.println("c : "+ b.c);
		
		array =b.substring(b.str, array);
		
		
			int q = Integer.parseInt(array[0]);
			int w = Integer.parseInt(array[1]);
			int e = Integer.parseInt(array[2]);
			int r = Integer.parseInt(array[3]);
			
			int sum = q+w+e+r+b.c;
			
			System.out.println(sum);
		
	}

	
}
