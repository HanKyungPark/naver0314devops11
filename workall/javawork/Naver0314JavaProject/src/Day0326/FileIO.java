package Day0326;

import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	
	static final String FILENAME = "/Users/hankyung/Desktop/naver0314/study.txt";
	
	public static void fileWrite() {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(FILENAME);
			fw.write("Study\n");
			System.out.println("작성됨");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileWrite();

	}

}
