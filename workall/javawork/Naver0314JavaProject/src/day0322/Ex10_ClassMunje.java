package day0322;


class Member
{
	private String name;
	private String hp;
	private String addr;
	
	//생성자	
	Member()
	{	
		this("박한경","112","서울");
		
	}
	
	Member(String name)
	{
		this();
	}
	Member(String name,String hp)
	{
		this.name=name;
		this.hp=hp;
	}
	
	
	Member(String name,String hp,String addr)
	{
		this.name=name;
		this.hp=hp;
		this.addr=addr;
	}
	
	
	//setter
	public void setName(String name)
	{
		this.name=name;
	}
	public void setHp(String hp)
	{
		this.hp=hp;
	}
	public void setAddr(String addr)
	{
		this.addr=addr;
	}
	//getter
	public String getName()
	{
		return name;
	}
	public String getHp()
	{
		return hp;
	}
	public String getAddr()
	{
		return addr;
	}
	
	
	
}
public class Ex10_ClassMunje {
	public static void writeMember(Member m)
	{
		System.out.printf("이름은?%s\n",m.getName());
		System.out.printf("전화번호는?%s\n",m.getHp());
		System.out.printf("사는곳은?%s\n\n",m.getAddr());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Member m1=new Member();
		Member m2=new Member("이강인");
		Member m3=new Member("손흥민","010-2222-3333");
		Member m4=new Member("Candy","010-444-5555","제주도");
		
		System.out.println("** 멤버 명단 출력 **");
		writeMember(m1);
		writeMember(m2);
		writeMember(m3);
		writeMember(m4);
		
		System.out.println("** m1 멤버의 값 변경하기 **");
		m1.setName("이영자");
		m1.setHp("011-2323-6767");
		m1.setAddr("부산");
		
		writeMember(m1);
	}

}
