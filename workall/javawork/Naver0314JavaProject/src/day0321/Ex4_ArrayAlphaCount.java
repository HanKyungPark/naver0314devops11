package day0321;

import java.util.Scanner;

public class Ex4_ArrayAlphaCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 영어문장을 입력하면 알파벳 기준으로 각각의 갯수를 출력하시오
		 * Have a Nice Day!!!!
		 * 
		 * 'A' -> 0번지 증가
		 * 'B' -> 1번지 증가
		 * A:3    B:0....Z:0
		 */
		Scanner sc=new Scanner(System.in);
		System.out.println("영문 문장을 입력하세요");
		String msg =sc.nextLine();
		int []alpha=new int[26];

		for(int i=0;i<msg.length();i++)
		{
			char ch = msg.toUpperCase().charAt(i);//대문자로 변경후 i번지 글자 얻기
			if(ch>='A' && ch<='Z')
				alpha[ch -'A']++;
		}
		System.out.println("** 알파벳별 갯수 구하기 **");
		for(int i=0;i<alpha.length;i++)
		{
			System.out.printf("%c:%d\t",(char)('A'+i),alpha[i]);
			if((i+1)%5==0)
				System.out.println();
		}




	}

}
