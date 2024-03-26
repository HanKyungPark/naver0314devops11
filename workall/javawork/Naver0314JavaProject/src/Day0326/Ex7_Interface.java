package Day0326;

interface StudyInter
{
	public void javaStudy();
	public void springStudy();
}

interface playInter
{
	public void run();
	public void game();
}

class MyStudy implements StudyInter
{

	@Override
	public void javaStudy() {
		// TODO Auto-generated method stub
		System.out.println("자바 스터디");

	}

	@Override
	public void springStudy() {
		// TODO Auto-generated method stub
		System.out.println("스프링 스터디");
	}


}

class Myplay implements playInter
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("달리기");
	}
	@Override
	public void game() {
		// TODO Auto-generated method stub

	}
}
public class Ex7_Interface {

	public static void study(StudyInter s)
	{
		s.javaStudy();
		s.springStudy();
	}
	public static void play(playInter p)
	{
		p.run();
		p.game();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		study(new MyStudy());
		play(new Myplay());

	}

}
