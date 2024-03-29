package day0329;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex1_SwingFileImage extends JFrame {
    static String PHOTO = "/Users/hankyung/Desktop/naver0314/workall/image/연예인사진/19.jpg";
    JButton btnImageOpen;
    MyPhoto myPhoto = new MyPhoto(); //캔버스 내부클래스
    public Ex1_SwingFileImage(String title){
        super(title);
        this.setLocation(100, 100);
        this.setSize(400, 500);
        //this.getContentPane().setBackground(new Color(93, 199, 187)); // 배경색 변경 ..
        //this.getContentPane().setBackground(Color.CYAN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 ..
        this.initDesign();
        this.setVisible(true);
    }
    //캔버스를 상속받는 내부클래스
    class MyPhoto extends Canvas{
        @Override
        public void paint(Graphics g) {
            super.paint(g);

            Image image = new ImageIcon(PHOTO).getImage();
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
    public void initDesign(){
        JPanel p = new JPanel();
        btnImageOpen = new JButton("이미지 불러오기");
        p.add(btnImageOpen);
        this.add("North", p);

        //캔버스는 Center 에 배치
        this.add("Center", myPhoto);

        //버튼 이벤트
        btnImageOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog dlg = new FileDialog(Ex1_SwingFileImage.this, "이미지 불러오기", FileDialog.LOAD);
                dlg.setVisible(true);
                if(dlg.getFile()==null)
                    return;//취소를 클릭시 메서드 종료
                //불러올 경로와 파일명
                PHOTO=dlg.getDirectory()+dlg.getFile();
                //캔바스의 paint 메서드 다시 호출
                myPhoto.repaint();
            }
        });
    }
    public static void main(String[] args) {
        Ex1_SwingFileImage a = new Ex1_SwingFileImage("File Image");
    }
}
