package study;

import java.sql.*;

public class test1 {
    static final String MYSQL_DRIVER="com.mysql.jdbc.Driver";
    static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?severTinezone=UTC";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";

    public test1(){
        try{
            Class.forName(MYSQL_DRIVER);
            System.out.println("Mysql8 드라이버 성공");
        }catch(ClassNotFoundException e){
            System.out.println("Mysql 드라이버 오류:"+e.getMessage());
        }
    }
    public static void showTitle() {
        System.out.println("=".repeat(40));
        System.out.println("시퀀스\t이름\t성별\t부서\t점수");
        System.out.println("=".repeat(40));
    }
    public void writeSawon() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;//select문 일경우에만 필요한 클래스
        String sql = "select * from sawon order by num";
        try{
            //URL,user명과 비번이 모두 맞으면 Connection 을 얻는다
            conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
            System.out.println("mysql 서버에 연결 성공");

            showTitle();

            stmt=conn.createStatement();//sql을 실행하기 위한 statement 얻기
            rs=stmt.executeQuery(sql);//select 문일경우는 무조건 executQuery로 실행한다
            while (rs.next()) {

                //데이타를 가져올떄는 컬럼번호 또는 컬럼명으로 가져오면 된다.
                int num = rs.getInt("num");
                String name = rs.getString("name");
                int score = rs.getInt("score");
                String gender = rs.getString("gender");
                String buseo = rs.getString("buseo");

                System.out.println(num + "\t" + name + "\t" + gender + "\t" + buseo + "\t" + score);
            }



        } catch (SQLException e) {
            System.out.println("URL,USERNAME,PASSWORD 확인:"+e.getMessage());
        }finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException | NumberFormatException e) {
                    e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        test1 test = new test1();
            test.writeSawon();
    }
}
