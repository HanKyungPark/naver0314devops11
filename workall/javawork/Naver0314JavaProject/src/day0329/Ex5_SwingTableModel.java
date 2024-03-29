package day0329;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class Ex5_SwingTableModel extends JFrame {
    JLabel lblTitle;
    JTable table;
    DefaultTableModel tableModel;
    JButton btnDelete;
    public Ex5_SwingTableModel(String title){
        super(title);
        this.setLocation(100, 100);
        this.setSize(500, 300);
        //this.getContentPane().setBackground(new Color(93, 199, 187)); // 배경색 변경 ..
        //this.getContentPane().setBackground(Color.CYAN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 ..
        this.initDesign();
        this.setVisible(true);
    }
    public void initDesign(){
        lblTitle = new JLabel("Student Information", JLabel.CENTER); // 제목달기
        lblTitle.setFont(new Font("KoPub돋움체",Font.BOLD, 30));
        this.add("North", lblTitle);

        //테이블을 행객수 0, 제목만 넣어서 생성후 Center 에 추가
        String []title = {"이름","나이","Java","Spring","Html","총점","평균"};
        tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);
        this.add("Center", new JScrollPane(table));
        this.addStudentFile();
        this.process();

        //삭제버튼 생성및 이벤트
        btnDelete = new JButton("학생정보 삭제하기");
        this.add("South", btnDelete);

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=table.getSelectedRow();
                System.out.println(row);//선택을 안했을경우 -1 발생

                if (row==-1)
                    JOptionPane.showMessageDialog(Ex5_SwingTableModel.this, "먼저 삭제할 행을 선택해주세요");
                else
                    tableModel.removeRow(row);
            }
        });

    }
    public void process(){
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            // 각 행마다 3과목의 점수를 읽어서 int 로 변환
            int java = Integer.parseInt(table.getValueAt(i, 2).toString());
            int spring = Integer.parseInt(table.getValueAt(i, 3).toString());
            int html = Integer.parseInt(table.getValueAt(i, 4).toString());

            
            int tot = java + spring + html; // tot = 총점 구하기
            table.setValueAt(tot, i, 5); // 5번 열에 출력
            double avg = tot/3.0; // avg = 평균 구하기
            table.setValueAt(avg, i, 6); // 6번 열에 출력
        }
    }
    public void addStudentFile(){
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("/Users/jeenukjung/Desktop/naver0314/Student.txt");
            br = new BufferedReader(fr);
            while (true){
                String line = br.readLine();
                if(line == null) break;
                String []data = line.split(",");
                tableModel.addRow(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾지 못하였습니다.");
        } catch (IOException e) {
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException|NullPointerException e) {
            }
        }
    }
    public static void main(String[] args) {
        Ex5_SwingTableModel a = new Ex5_SwingTableModel("기본창");
    }
}
