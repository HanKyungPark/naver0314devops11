package day0405;

import java.sql.*;
import java.util.Scanner;

public class Ex11OraclePersom {
    static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
    static  final String ORACLE_URL="jdbc:oracle:thin:@db.bmops.kro.kr:1521/xe"; //본인
    //static  final String ORACLE_URL="jdbc:oracle:thin:@192.168.0.59:1521/xe"; //강사pc오라클
    static final String USERNAME="ParkHanKyung";
    static final String PASSWORD="a1234";

    public Ex11OraclePersom() {
        try {
            Class.forName(ORACLE_DRIVER);
            //System.out.println("오라클 드라이버 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("오라클 드라이버 실패 :" + e.getMessage());
        }
    }

    public void insertPerson(String name,String blood,int age)
    {
        String sql="insert into person values (seq_test.nextval,?,?,?,sysdate)";
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            conn = DriverManager.getConnection(ORACLE_URL, USERNAME, PASSWORD);
            pstmt = conn.prepareStatement(sql);

            //? 3개 바인딩
            pstmt.setString(1, name);
            pstmt.setString(2, blood);
            pstmt.setInt(3, age);

            //실행
            pstmt.execute();

            System.out.println("데이타가 추가되었습니다!");
        } catch (SQLException e) {

        }finally {
            try {
                pstmt.close();
                conn.close();
            }catch (SQLException|NullPointerException e) {

            }
        }
    }
    public void writePerson()
    {
        String sql="""
            select pnum,pname,page||'세' page,upper(pblood) ||'형'pblood,
            to_char(ipsaday,'yyyy-mm-dd hh:mi') ipsaday from person order by pnum asc
            """;

        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try {
            conn = DriverManager.getConnection(ORACLE_URL, USERNAME, PASSWORD);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            System.out.println("\t ** Persom Table**\n");
            System.out.println("시퀀스\t이름\t혈액형\t나이\t입사일");
            System.out.println("=".repeat(40));

            while (rs.next())
            {
                int pnum = rs.getInt("pnum");
                String pname = rs.getString("pname");
                String page =rs.getString("page");
                String pblood = rs.getString("pblood");
                String ipsaday = rs.getString("ipsaday");

                System.out.println(pnum+"\t"+pname+"\t"+pblood+"\t"+page+"\t"+ipsaday);

            }

        } catch (SQLException e) {

        }finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            }catch (SQLException|NullPointerException e) {

            }
        }
    }
    public static void main(String[] args) {
        Ex11OraclePersom ex11=new Ex11OraclePersom();
        Scanner sc = new Scanner(System.in);
        int menu=0;
        String name,blood;
        int age;

        while (true)
        {
            System.out.println("1.데이타 추가 2.전체출력 3.종료");
            menu = Integer.parseInt(sc.nextLine());
            switch (menu)
            {
                case 1:
                    System.out.println("이름입력");
                    name=sc.nextLine();
                    System.out.println("혈액형은?");
                    blood = sc.nextLine();
                    System.out.println("나이는?");
                    age = Integer.parseInt(sc.nextLine());

                    ex11.insertPerson(name, blood, age);
                    break;
                case 2:
                    ex11.writePerson();
                    break;
                default:
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0);
            }
            System.out.println();
        }

    }
}



















