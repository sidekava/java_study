package part2.ex3.데이터구조화;

import java.util.Scanner;

/*
 * 개념단위의 데이타를 entity라 한다.
 * 아래는 추측
 * 즉 데이터의 본질
 * 부가 데이터가 아닌 본 데이터
 * 
 * */

public class StruturedProgram{
	
	/*
	 * 구조적인 프로그래밍으로 변경함으로써 거시적인 형태로 변해서 한 눈에 구조를 파악할 수 있다.
	 * 
	 */
	
	//전역변수는 static을 붙인다.
	
    public static void main(String[] args) {
    	
    	int[] korList = new int[3];
    	int[] engList = new int[3];
    	int[] mathList = new int[3];

    	//국어, 영어, 수학을 포괄하는 더 큰 단위의 데이터
    	Exam exam = new Exam();
    	exam.kor = 30;
    	exam.eng = 30;
    	exam.math = 30;
    	
    	
    	int menu;
        boolean keepLoop = true;			
		

		
		while(keepLoop)
		{

			menu = inputMenu();
	        
	        switch(menu) {	        
	        case 1:
	        	inputKors(korList);
	        	inputEngs(engList);
		        break;
	        case 2:
		        printKors(korList);
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
    
    static int inputMenu() {
        Scanner scan = new Scanner(System.in);
		System.out.println("┌───────────────────────────┐");
        System.out.println("│           메인 메뉴                   │");
        System.out.println("└───────────────────────────┘");
        System.out.println("\t1. 성적입력 ");
        System.out.println("\t2. 성적출력 ");
        System.out.println("\t3. 종료 ");
        System.out.println("\t선택> ");
        int menu = scan.nextInt();
        
        return menu;
    }
    
    static void printKors(int[] kors) {
        int total = 0;
        float avg;
        
    	for(int i=0; i<3; i++)
        	total += kors[i];
        
        avg = total / 3.0f;
        
        System.out.println("┌───────────────────────────┐");
        System.out.println("│           성적  출력                   │");
        System.out.println("└───────────────────────────┘");
        System.out.println();		        
       
        for(int i=0;i<3;i++)
        	System.out.printf("국어 %d : %3d\n", 3-i, kors[i]);	        	
        	        
        System.out.printf("총점 : %3d\n", total);
        System.out.printf("평균 : %6.2f\n", avg);
        System.out.println("─────────────────────────────");
    	
    }
    
    static void inputKors(int[] kors) {
        Scanner scan = new Scanner(System.in);
        //scan은 구지 main함수와 공유할 필요가 없기에 각각 선언한다.
        int kor;
    	
    	System.out.println("┌───────────────────────────┐");
        System.out.println("│           성적  입력                   │");
        System.out.println("└───────────────────────────┘");
        System.out.println();
       		        
        for(int i=0; i<3; i++) {
	        do {
		        System.out.printf("국어%d : ", i+1);
		        kor = scan.nextInt();
	        
		        if(kor < 0 || 100 < kor)
		        	System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
		        
	        }while(kor < 0 || 100 < kor);
        
	        kors[i] = kor;
        }
        
        System.out.println("─────────────────────────────");
    	    
    }
    
    
}