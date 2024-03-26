package Day0326;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Ex16_FileReaderMemo {
	static final String FILENAME2="/Users/hankyung/Desktop/naver0314/memo1.txt";

	static public void readMemo2()
	{
		BufferedReader br=null;
		FileReader fr=null;

		try {
			fr = new FileReader(FILENAME2);
			System.out.println("파일을 읽습니당");
			br = new BufferedReader(fr);
			while (true) {
				String line = br.readLine();
				if (line == null) break;
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("파일을 찾을 수 없습니다");
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readMemo2();
	}
}
