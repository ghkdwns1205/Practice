package Namamdaro;

public class Skill {
	String pasive = "";
	String q = "";
	String w = "";
	String e = "";
	String r = "";

	public Skill(int p) {
		switch(p) {
		case 1: System.out.println("가렌의 스킬은");
		this.pasive = "인내심";
		this.q = "결정타";
		this.w = "용기";
		this.e = "심판";
		this.r = "데마시아의 정의";
		System.out.println(pasive);
		System.out.println(q);
		System.out.println(w);
		System.out.println(e);
		System.out.println(r);
		break;
		case 2: System.out.println("갈리오의 스킬은");
		this.pasive = "석상의 강타";
		this.q = "전장의 돌풍";
		this.w = "듀란드의 방패";
		this.e = "정의의 주먹";
		this.r = "영웅출현";
		System.out.println(pasive);
		System.out.println(q);
		System.out.println(w);
		System.out.println(e);
		System.out.println(r);
		break;
		case 3: System.out.println("갱플랭크의 스킬은");
		this.pasive = "불의 심판";
		this.q = "혀어어어업상";
		this.w = "괴혈병 치료";
		this.e = "화약통";
		this.r = "포탄 세례";
		System.out.println(pasive);
		System.out.println(q);
		System.out.println(w);
		System.out.println(e);
		System.out.println(r);
		break;
		case 4: System.out.println("그라가스의 스킬은");
		this.pasive = "서비스 시간";
		this.q = "술통 굴리기";
		this.w = "취중 분노";
		this.e = "몸통 박치기";
		this.r = "술탄 폭발";
		System.out.println(pasive);
		System.out.println(q);
		System.out.println(w);
		System.out.println(e);
		System.out.println(r);
		break;
		case 5: System.out.println("그레이브즈의 스킬은");
		this.pasive = "새로운 운명";
		this.q = "화약 역류";
		this.w = "연막탄";
		this.e = "빨리 뽑기";
		this.r = "무고한 희생자";
		System.out.println(pasive);
		System.out.println(q);
		System.out.println(w);
		System.out.println(e);
		System.out.println(r);
		break;
		}
	}
}
