package Day0326;

public class Ex12_Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {3,5,7,10};
		for (int i=0;i<=arr.length;i++)
		{	
			try {
				System.out.println(i+";"+arr[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				//e.printStackTrace();
				System.out.println("배열 인덱스 오류 : "+e.getMessage());
			} 	
		}
		System.out.println("** 종료 **");
	}

}
