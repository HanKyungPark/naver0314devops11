package day0325;

public class Shop {
	private String sang;
	private int su;
	private int dan;


	public Shop()
	{
		this("이름없음",1,1000);
	}
	public Shop(String sang)
	{
		this(sang,1,1000);
	}
	public Shop(int su, int dan)
	{
		this("이름없음",su,dan);
	}
	public Shop(String sang,int su,int dan)
	{
		this.sang=sang;
		this.su=su;
		this.dan=dan;
	}

	//setter
	public void setSang(String sang)
	{
		this.sang=sang;
	}
	public void setSu(int su)
	{
		this.su=su;
	}
	public void setDan(int dan)
	{
		this.dan=dan;
	}
	public void setSangpum(String sang,int su,int dan)
	{
		setSang(sang);
		setSu(su);
		setDan(dan);
	}

	//getter

	public String getSang()
	{
		return sang;
	}
	public int getSu()
	{
		return su;
	}
	public int getDan()
	{
		return dan;
	}

















}
