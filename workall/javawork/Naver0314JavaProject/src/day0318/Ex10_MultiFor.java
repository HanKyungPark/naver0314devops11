package day0318;

public class Ex10_MultiFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=5;i++)
		{
			System.out.println("Hello");
			for(int j=1;j<=3;j++)
			{
				System.out.print("\tkitty~");
			}
			System.out.println();
		}
		System.out.println("-------------");
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=3;j++)
			{
				System.out.printf("i=%d,j=%d\n",i,j);
				break;//현재 반복문을 빠져나간다
			}
			System.out.println();

		}

		System.out.println("---------------");
		//레이블명은 마음대로 준다
		System.out.println();
		Exit:
			for(int i=1;i<=5;i++)
			{
				for(int j=1;j<=3;j++)
					System.out.printf("i=%d,j=%d\n",i,j);
				break Exit;//두개의 for문을 한번에 빠져나간다
			}
		System.out.println();




	}
}
