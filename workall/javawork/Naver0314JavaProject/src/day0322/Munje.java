package day0322;

import java.util.Scanner;

class Account
{
	private String payNum;
	private String owner;
	private int balance;

	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner =owner;
	}
	public Account(String payNum, int balance, String owner)
	{
		this.payNum =payNum;
		this.balance = balance;
		this.owner = owner;
	}
	public String getpayNum()
	{
		return payNum;
	}
	public void setpayNum(String payNum)
	{
		this.payNum = payNum;
	}
	public int getBalance()
	{
		return balance;
	}
	public void setBalance(int balance)
	{
		if(balance < 0) return;
		this.balance = balance;
	}


}

public class Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account[] accounts = new Account[100];
		Scanner sc = new Scanner(System.in);
		int p = 0;
		while(true)
		{
			System.out.println("-----------------");
			System.out.println("1.계좌 생성 | 2. 계좌 목록 | 3.예금 | 4. 출금 | 5.종료");
			System.out.print("선택>");
			int sel = sc.nextInt();
			if (sel == 5)break;
			if(sel==1)
			{
				sc.nextLine();
				System.out.println("-------");
				System.out.println("계좌 생성");
				System.out.println("-------");
				System.out.print("계좌번호 : ");
				String payNum = sc.nextLine();
				System.out.print("계좌주 : ");
				String owner = sc.nextLine();
				System.out.print("초기 입금액 : ");
				int balance = sc.nextInt();
				accounts[p] = new Account(payNum,balance,owner);
				System.out.println("결과 : 계좌가 생성되었습니다");
				p++;
			}
			else if(sel==2)
			{
				System.out.println("---------");
				System.out.println("계좌목록");
				System.out.println("---------");
				for(int i=0; i<p;i++)
				{
					System.out.println(accounts[i].getpayNum()+"\t"+accounts[i].getOwner()+"\t"
							+accounts[i].getBalance());
				}
			}else if(sel==3)
			{
				sc.nextLine();
				System.out.println("--------");
				System.out.println("예금");
				System.out.println("--------");
				System.out.print("계좌번호 : ");
				String payNum = sc.nextLine();
				System.out.print("예금액 : ");
				int balance = sc.nextInt();
				for(int i=0; i<p;i++)
					if(accounts[i].getpayNum().equals(payNum))
					{
						accounts[i].setBalance(accounts[i].getBalance()+balance);
						break;
					}
			}else if(sel==4)
		{
			sc.nextLine();
			System.out.println("--------");
			System.out.println("예금");
			System.out.println("--------");
			System.out.print("계좌번호 : ");
			String payNum = sc.nextLine();
			System.out.print("출금액 : ");
			int balance = sc.nextInt();
			for(int i=0; i<p;i++)
			{
				if(accounts[i].getpayNum().equals(payNum)){
                    accounts[i].setBalance(accounts[i].getBalance()-balance);
                    break;
			}
		}
	} 
}
	}
}
   




















