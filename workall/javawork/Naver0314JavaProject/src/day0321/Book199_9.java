package day0321;

import java.util.Scanner;

public class Book199_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int inwon=0;
		int max = 0;
		int sum=0;
		int [] score=new int[0];
		String su;
		double avg;


		Loop:
			while(true) {
				System.out.println("-".repeat(47));
				System.out.println("1.학생수 | 2.점수입력 | 3. 점수리스트 | 4.분석 | 5.종료");
				System.out.println("-".repeat(47));
				su=sc.nextLine();
				switch(su)
				{
				case "1":
					System.out.printf("학생수> ");
					inwon=Integer.parseInt(sc.nextLine());
					score=new int[inwon];
					break;
					
				case "2":
					System.out.printf("점수입력");
					for(int i=0;i<score.length;i++)
					{
						score[i]=Integer.parseInt(sc.nextLine());
					}
					break;
				case"3":
					for(int i=0;i<score.length;i++)
					{
						System.out.printf("점수 :%d\n",score[i]);
					}
					break;
				case"4":
					for(int i=0;i<score.length;i++)
					{
						if(max < score[i])
						{
							max = score[i];
						}
						sum+=score[i];
					}
					avg= sum/(double)score.length;
					System.out.printf("평균점수는 : %f\n",avg);
					System.out.printf("최고점수는 : %d\n",max);
					
					break;
					
				case "5":
					break Loop;
				}
				
			}
	}
}



