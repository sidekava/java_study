package part2.ex3.데이터구조화;

import java.util.Scanner;

public class ListProgram {
	
	/*
	 * Exam[] exams = new Exam[3];
	 * 위는 Exam이란 객체가 만들어진 것이 아니다. 
	 * Exam형식의 배열 세 개가 만들어 진 것아다. 
	 * 참조 변수가 세 개 만들어 진 것이다.
	 * 그러므로 exams[0].kor = 30;이란 코드는 성립하지 못한다.
	 * 왜냐면 exams[0]은 존재하지만 exam[0]이 가리키는 참조는 없다. 
	 * 즉 exams[0]은 null이다.
	 * exams[0].kor = 30; 가 성립하려면 아래와 같이 코드를 짜야 한다.
	 * 	Exam[] exams = new Exam[3];
		exams[0] = new Exam();
		exams[0].kor = 30;
	 * 
	 */

	public static void main(String[] args) {
		ExamList list = new ExamList();
		list.exams = new Exam[3];
		list.current = 0;
		
		int menu;
        boolean keepLoop = true;			
		
		
		while(keepLoop)
		{

			menu = inputMenu();
	        
	        switch(menu) {	        
	        case 1:
	        	inputList(list);
		        break;
	        case 2:
		        printList(list);
		        break;
	        case 3:
	        	System.out.println("Bye~~");
	        	
	        	keepLoop = false;
	        	break;
	        default:
	        	System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
	       
	        }
		}   
	}
	
	private static void printList(ExamList list) {
       printList(list, list.current);
	}
	
	private static void printList(ExamList list, int size) {
		System.out.println("┌───────────────────────────┐");
		System.out.println("│           성적  출력                   │");
		System.out.println("└───────────────────────────┘");
		System.out.println();		 
		
		Exam[] exams = list.exams;
		
		for(int i = 0; i < size; i++) {
			Exam exam = exams[i];
			int kor = exam.kor;
			int eng = exam.eng;
			int math= exam.math;
			
			int total = kor + eng + math;
			float avg = total/3.0f;
			
			System.out.printf("국어 : %3d\n", exam.kor);	        	
			System.out.printf("영어 : %3d\n", exam.eng);	        	
			System.out.printf("수학 : %3d\n", exam.math);	        	
			
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("─────────────────────────────");
		}
	}

	private static void inputList(ExamList list) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("┌───────────────────────────┐");
        System.out.println("│           성적  입력                   │");
        System.out.println("└───────────────────────────┘");
        System.out.println();
        
        	
        int kor, eng, math;
        
        do {
	        System.out.printf("국어 : ");
	        kor = scan.nextInt();
        
	        if(kor < 0 || 100 < kor)
	        	System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
	        
        } while(kor < 0 || 100 < kor);
        
        do {
        	System.out.printf("영어 : ");
        	eng = scan.nextInt();
        	
        	if(eng < 0 || 100 < eng)
        		System.out.println("영어성적은 0~100까지의 범위만 입력이 가능합니다.");
        	
        } while(eng < 0 || 100 < eng);
        
        do {
        	System.out.printf("수학 : ");
        	math = scan.nextInt();
        	
        	if(math < 0 || 100 < math)
        		System.out.println("수학성적은 0~100까지의 범위만 입력이 가능합니다.");
        	
        } while(math < 0 || 100 < math);
        
        Exam exam = new Exam();
        exam.kor = kor;
        exam.eng = eng;
        exam.math = math;
        
        Exam[] exams = list.exams;
        int size = list.current;
        
    	if (exams.length == size) {
    		Exam[] temp = new Exam[size + 5];
    		for (int j = 0; j < size; j++) {
    			temp[j] = exams[j];
    		}
    		list.exams = temp;
    	}
        
        list.exams[list.current] = exam;
		list.current++;
	}

	static int inputMenu() {
        Scanner scan = new Scanner(System.in);
		System.out.println("┌───────────────────────────┐");
        System.out.println("│           메인 메뉴                   │");
        System.out.println("└───────────────────────────┘");
        System.out.println("\t1. 성적입력 ");
        System.out.println("\t2. 성적출력 ");
        System.out.println("\t3. 종료 ");
        System.out.print("\t선택> ");
        int menu = scan.nextInt(); 
        
        return menu;
    }

}
