package day0328;

import javax.swing.*;
import java.awt.*;

public class Ex5_SwingCanvas extends JFrame {
	myDraw draw = new myDraw();
	public Ex5_SwingCanvas(String title){
		super(title);
		this.setLocation(100, 100);
		this.setSize(500, 500);
		//this.getContentPane().setBackground(new Color(93, 199, 187)); // 배경색 변경 ..
		//this.getContentPane().setBackground(Color.CYAN);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 ..
		this.initDesign();
		this.setVisible(true);
	}
	// Canvas 를 상속 받는 내부 클래스
	static class myDraw extends Canvas{
		String foodImage1 = "/Users/hankyung/Desktop/naver0314/workall/image/음식사진/11.jpg";
		String foodImage2 = "/Users/hankyung/Desktop/naver0314/workall/image/음식사진/9.jpg";
		// 처음 시작시, 그리고 프레임 크기 변경시에는 자동 호출
		// 그 외에는 강제호출 (repaint)
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.magenta);
			g.drawOval(30,30,100,100); // 테두리만 있는 동그라미
			g.setColor(Color.pink);
			g.fillOval(150, 30, 100, 100); // 색이 채워진 동그라미

			g.setColor(new Color(8, 207, 7));
			g.drawRect(30, 150, 100, 100);// 테두리만 있는 정사각형 r
			g.setColor(new Color(239,136,58));
			g.fillRect(150,150,100,100);
			g.setColor(new Color(30, 100, 50));

			g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			g.drawString("Good Day", 50,350);
			g.setFont(new Font("맑은고딕", Font.BOLD, 30));
			g.drawString("안녕하세요", 250,350);

			Image image1 = new ImageIcon(foodImage1).getImage();
			g.drawImage(image1, 300, 10, 130, 130, this);

			Image image2 = Toolkit.getDefaultToolkit().getImage(foodImage2);
			g.drawImage(image2, 300, 150, 130, 130, this);
		}
	}
	public void initDesign(){
		// 기본 레이아웃을 Center 에 Canvas 추가
		this.add("Center",draw);
	}
	public static void main(String[] args) {
		Ex5_SwingCanvas a = new Ex5_SwingCanvas("Swing Canvas");
	}
}
