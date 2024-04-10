package day0408;

import com.google.protobuf.Enum;
import db.common.DbConnect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Ex2_DbSawon extends JFrame {
	DbConnect db=new DbConnect();
	JTable table;
	DefaultTableModel tableModel;
	JTextField tfName,tfscore;
	JButton btnAdd,btnDel;
	JComboBox<String> cbResult,cbBuseo;
	JRadioButton []rb=new JRadioButton[3];



	int orderIndex=1;
	int buseoIndex=1;


	public Ex2_DbSawon(String title){
		super(title);
		this.setLocation(100, 100);
		this.setSize(500, 500);
		this.getContentPane().setBackground(new Color(93, 199, 187)); // 배경색 변경 ..
		//this.getContentPane().setBackground(Color.CYAN);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 ..
		this.initDesign();
		this.setVisible(true);
	}
	public void writeSawon() {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		if (orderIndex == 1 && buseoIndex == 1)//둘다 전체인경우
			sql = "select * from sawon order by num";
		else if (orderIndex != 1 && buseoIndex == 1)//성별은 선택,부서는 전체
			sql = "select * from sawon where gender=? order by num";
		else if (orderIndex == 1 && buseoIndex != 1)//성별은 전체 부서는 선택
			sql = "select * from sawon where buseo=? order by num";
		else //부서,성별 모두 선택한경우
			sql = "select * from sawon where buseo=? and gender=? order by num";

		try {
			try {
				pstmt = conn.prepareStatement(sql);
				if (orderIndex != 1 && buseoIndex == 1)
					pstmt.setString(1, orderIndex == 2 ? "남자" : orderIndex == 3 ? "여자" : "");
				else if (orderIndex == 1 && buseoIndex != 1)
					pstmt.setString(1, buseoIndex == 2 ? "홍보부" : buseoIndex == 3 ? "교육부" : buseoIndex == 4 ? "인사부" : "");
				else if (orderIndex != 1 && buseoIndex != 1) {
					pstmt.setString(1, buseoIndex == 2 ? "홍보부" : buseoIndex == 3 ? "교육부" : buseoIndex == 4 ? "인사부" : "");
					pstmt.setString(2, orderIndex == 2 ? "남자" : orderIndex == 3 ? "여자" : "");
				}

				//실행
				rs = pstmt.executeQuery();
				//처음 시작시 데이타 삭제후 추가
				tableModel.setRowCount(0);
				while (rs.next()) {
					Vector<String> data = new Vector<>();
					data.add(rs.getString("num"));
					data.add(rs.getString("name"));
					data.add(rs.getString("score"));
					data.add(rs.getString("gender"));
					data.add(rs.getString("buseo"));

					//행추가
					tableModel.addRow(data);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(pstmt, conn, rs);
			}
		} catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

        public void initDesign(){
		JPanel p1=new JPanel();
		p1.add(new JLabel("이름"));
		tfName = new JTextField(5);
		p1.add(tfName);
		p1.add(new JLabel("score"));
		tfscore = new JTextField(5);
		p1.add(tfscore);

		String[] gender = {"남자", "여자"};
		cbResult = new JComboBox<String>(gender);
		p1.add(new JLabel("출력순서"));
		p1.add(cbResult);

		String[] inbuseo = {"홍보부", "교육부","인사부"};
		cbBuseo = new JComboBox<String>(inbuseo);
		p1.add(new JLabel("출력순서"));
		p1.add(cbBuseo);

		this.add("North", p1);
		//////////////////////
		String[] title = {"시퀀스", "이름", "점수","성별", "부서"};
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable((tableModel));
		this.add("Center", new JScrollPane(table));
		/////////

		JPanel p2 = new JPanel();
		btnAdd = new JButton("추가");
		btnDel = new JButton("삭제");
		p2.add(btnAdd);
		p2.add(btnDel);

		String[] outbuseo = {"홍보부", "교육부","인사부"};
		cbResult = new JComboBox<>(outbuseo);
		cbResult.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				buseoIndex=cbResult.getSelectedIndex()+1;
				writeSawon();
			}
		});

		p2.add(new JLabel("출력순서"));
		p2.add(cbResult);

		ButtonGroup gb=new ButtonGroup();
		String []g2= {"전체","남자","여자"};

			for(int i=0;i<rb.length;i++)
			{
				rb[i]=new JRadioButton(g2[i], i==0?true:false);
				gb.add(rb[i]);
				p2.add(rb[i]);

				final int idx=i;
				//라디오버튼 이벤트
				rb[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						orderIndex=idx+1;
						writeSawon();
					}
				});
			}

		this.add("South", p2);
		//////////////////////

		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfName.getText().length()==0)
					return;
				if (tfscore.getText().length()==0)
					return;

				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				String sql = "insert into sawon values (null,?,?,?,?)";

				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, tfName.getText());
					pstmt.setInt(2, Integer.parseInt(tfscore.getText()));
					pstmt.setString(3,gender[cbResult.getSelectedIndex()]);
					pstmt.setString(4,inbuseo[cbBuseo.getSelectedIndex()]);

					pstmt.execute();
					tfName.setText("");
					tfscore.setText("");

					writeSawon();

				} catch (SQLException se) {
					se.printStackTrace();
				}finally {
					db.dbClose(pstmt,conn);
				}

			}
		});
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(Ex2_DbSawon.this, "삭제할 행을 선택해주세요");
					return;
				}
				String num=table.getValueAt(row,0).toString();
				String sql = "delete from sawon where num=?";
				Connection conn = db.getConnection();
				PreparedStatement pstmt=null;
				try{
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, num);
					pstmt.execute();

					writeSawon();
				}catch (SQLException se2){
					se2.printStackTrace();
					db.dbClose(pstmt,conn);
				}
			}
		});

		writeSawon();



	}


	public static void main(String[] args) {
		Ex2_DbSawon a = new Ex2_DbSawon("기본창");
	}
}
