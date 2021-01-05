package Namamdaro;
import java.util.Scanner;
public class Scan {
		String[] array = {"0","1","2","3","4","5","6","7","8","9"};
		String p;
	
	public void scanner() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		 p = sc.nextLine();
		System.out.println("입력한 값은 :"+p+" 입니다");
		
		 rnqns(p);
		
		
		
	}
	
	public void rnqns(String p) {
		for(int i = 0; i<p.length();i++) {
			String sub = p.substring(i,i+1);
			for(int j =0; j<array.length;j++) {
			if (array[j].contains(sub)){
				System.out.println("숫자입니다.");
				
			}
			}
		}
//		Integer.parseInt(p);
//		return p;
	}
	
}
