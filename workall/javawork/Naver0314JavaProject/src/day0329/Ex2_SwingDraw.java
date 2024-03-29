package day0329;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Ex2_SwingDraw extends JFrame implements MouseMotionListener, MouseListener {
	//초기 선 색상
	Color color=Color.green;
	int x,y,prex,prey;//곡선을 그릴 현재좌표 x,y 와 직전좌표 prex,prey



	public Ex2_SwingDraw(String title){
		super(title);
		this.setLocation(100, 100);
		this.setSize(500, 500);
		//this.getContentPane().setBackground(new Color(93, 199, 187)); // 배경색 변경 ..
		//this.getContentPane().setBackground(Color.CYAN);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 ..
		//마우스 이벤트 추가
		this.addMouseMotionListener(this);
		this.addMouseMotionListener(this);
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		//super.paint(g);

		//선색상
		g.setColor(color);

		//선굵기 지정
		Graphics2D g2=(Graphics2D)g;
		g2.setStroke(new BasicStroke(3));

		//선그리기
		//g.drawLine(10, 100, 400, 100);

		//곡선은 마우스를 드래그시 직전좌표부터 현재좌표까지 선을 그리면 곡선이 된다
		g.drawLine(prex, prey, x, y);


	}

	public void initDesign(){

	}
	public static void main(String[] args) {
		Ex2_SwingDraw a = new Ex2_SwingDraw("곡선 그리기");
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		prex=x;
		prey=y;

		//현재좌표는 다시 마우스 위치로 저장
		x=e.getX();
		y=e.getY();

		//paint 다시 호출
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
		//클릭시 x,y변경
		x=e.getX();
		y=e.getY();

		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue= (int) (Math.random() * 256);

		color = new Color(red, green, blue);
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
