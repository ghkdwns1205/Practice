package Java01_05;

import java.util.Scanner;

public class Exam_array {
	public static void main(String[] args) {
		Exam[] exams = new Exam[3];
		//exams[0]~exams[2]
//		Exam_list list = new Exma_list();
		
//		Exam_list.init(list)
		Scanner scan = new Scanner(System.in);
		int menu;
		boolean keepLoop = true;

		while (keepLoop) {
			System.out.println("----------------------------------------------------------");
			System.out.println("|         메인 메뉴                   | ");
			System.out.println("----------------------------------------------------------");
			System.out.println("\t1. 성적입력 ");
			System.out.println("\t2. 성적출력 ");
			System.out.println("\t3. 종료 ");
			System.out.println("\t선택> ");
			menu = scan.nextInt();

			switch (menu) {
			case 1:
				input_list(exams);
				break;
			case 2:
				//print_list(exams);
				print_list(exams);
				
				break;
			case 3:

				break;

			default:
				System.out.println("잘못된 값을 입력하셨습니다 1~3 까지의 숫자를 입력해주세요.");
			}
		}
	}
	private static void print_list(Exam[] exams,int count) {
		print_list(exams,count);
	}
	private static void print_list(Exam[] exams) {// 출력
		System.out.println("----------------------------------------------------------");
		System.out.println("|           성적 출력                  | ");
		System.out.println("----------------------------------------------------------");
		System.out.println();
		for (int i = 0; i < 3; i++) {

			Exam exam = exams[i];
			int kor = exam.Kor;
			int eng = exam.Eng;
			int math = exam.Math;
			
			int total = kor + eng + math;
			double avg = total / 3.0;

			System.out.printf("국어 : %d\n", kor);
			System.out.printf("영어 : %d\n", eng);
			System.out.printf("수학 : %d\n", math);

			System.out.printf("총점 : %d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("----------------------------------------------------------");
		}
	}

	private static void input_list(Exam[] exams) { // 입력
		int kor;
		int eng;
		int math;
		Scanner scan = new Scanner(System.in);
		System.out.println("----------------------------------------------------------");
		System.out.println("|         성적 입력                    | ");
		System.out.println("----------------------------------------------------------");
		System.out.println();

		for (int i = 0; i < 3; i++) {

			do {
				System.out.printf("국어 : ");
				kor = scan.nextInt();
				if (kor < 0 || 100 < kor)
					System.out.println("국어 성적은 0~100까지의 범위만 입력해주세요.");
			} while (kor < 0 || 100 < kor);

			System.out.println("----------------------------------------------------------");

			do {
				System.out.printf("영어 : ");
				eng = scan.nextInt();
				if (eng < 0 || 100 < eng)
					System.out.println("영어 성적은 0~100까지의 범위만 입력해주세요.");
			} while (eng < 0 || 100 < eng);
			System.out.println("----------------------------------------------------------");

			do {
				System.out.printf("수학 : ");
				math = scan.nextInt();
				if (math < 0 || 100 < math)
					System.out.println("수학 성적은 0~100까지의 범위만 입력해주세요.");
			} while (math < 0 || 100 < math);
			System.out.println("----------------------------------------------------------");

			Exam exam = new Exam();

			exam.Kor = kor;
			exam.Eng = eng;
			exam.Math = math;

			exams[i] = exam;
		}
	}

	public static void print(Exam exam) {

	}

	public static void input(Exam exam) {
	}
}