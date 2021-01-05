package Namamdaro;
import java.util.Scanner;


public class LOL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("챔피언을 선택해주세요");
		System.out.println("1. 가렌 2. 갈리오 3. 갱플랭크 4. 그라가스 5. 그레이브즈");
		
		
		int p = sc.nextInt();
		Champion cham = new Champion();
		cham.champ(p);
        Skill sk = new Skill(p);
       
		
	}

}
