package day0323;

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

