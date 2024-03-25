package day0325;

public class Employee {
	private String Name;
	private String Position;
	private int Age;
	private int Gibon;
	private int Sudang;
	public Employee()
	{
		this("한경","사장",1500);
	}
	public Employee(String name, String position, int age)
	{
		
		this.Name = name;
		this.Position = position;
		this.Age = age;
	}
	
	public Employee(String name, int age) {
		super();
		Name = name;
		Age = age;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getGibon() {
		return Gibon;
	}
	public void setGibon(int gibon) {
		Gibon = gibon;
	}
	public int getSudang() {
		return Sudang;
	}
	public void setSudang(int sudang) {
		Sudang = sudang;
	}
	public void setPay(int Gibon ,int Sudang) {
		this.Gibon=Gibon;
		this.Sudang=Sudang;
	}
	public void setSawon(String Name, String Position, int Age) {
		this.Name=Name;
		this.Position=Position;
		this.Age=Age;
	}
	
	public int getNetPay() {
		return Gibon+Sudang;
	}
	
	
	
	
	
	
	
	
	
	}

