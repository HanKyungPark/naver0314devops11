package day0325;

abstract class Animal2{
	public void breathe(){
		System.out.println("숨을 쉽니다..");
	}
	public abstract void sound();
}
class Dog2 extends Animal2{
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
class Cat2 extends Animal2{
	@Override
	public void sound() {
		System.out.println("야옹");
	}
}
public class Ex11_Book328 {
	public static void animalSound(Animal2 animal2){
		animal2.sound();
	}
	public static void main(String[] args) {
		Dog2 dog2 = new Dog2();
		dog2.sound();
		Cat2 cat2 = new Cat2();
		cat2.sound();

		animalSound(new Dog2());
		animalSound(new Cat2());
	}
}
