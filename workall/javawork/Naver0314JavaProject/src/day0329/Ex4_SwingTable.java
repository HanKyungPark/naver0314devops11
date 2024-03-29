package day0329;

import javax.swing.*;
import java.awt.*;

public class Ex4_SwingTable extends JFrame {
	JTable table;
	JLabel lblMessage;

	public Ex4_SwingTable(String title){
		super(title);
		this.setLocation(100, 100);
		this.setSize(300, 300);
		this.getContentPane().setBackground(new Color(93, 199, 187)); // 배경색 변경 ..
		//this.getContentPane().setBackground(Color.CYAN);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 ..
		this.initDesign();
		this.setVisible(true);
	}
	public void initDesign(){
	String []title={"이름","나이","혈액형","핸드폰","주소"};
	String [][]data={
			{"이영자","32세","B","010-1234-1234","서울"},
			{"강호동","45세","O","010.3434-3434","부산"},
			{"유재석","29세","AB","010-2222-3333","제주도"},
			{"제니","23세","A","010-5454-5454","뉴욕"}
		};
		table = new JTable(data, title);
		//상단에 제목 출력
		this.add("North",new JLabel("701 멤버 현황",JLabel.CENTER));
		//프레임의 센타에 추가
		this.add("Center",new JScrollPane(table));//테이블도 스크롤바가 생겨야 한다(제목포함)
		//메세지 라벨을 South 에 추가
		lblMessage = new JLabel("결과 나올곳..", JLabel.CENTER);
		lblMessage.setFont(new Font("",Font.BOLD,20));
		this.add("South", lblMessage);
	}
	public static void main(String[] args) {
		Ex4_SwingTable a = new Ex4_SwingTable("테이블");
	}
}
