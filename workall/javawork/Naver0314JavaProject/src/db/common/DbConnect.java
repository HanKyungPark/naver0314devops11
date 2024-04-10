package db.common;


import java.sql.*;

public class DbConnect {
    static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
    static final String USERNAME="root";
    static final String PASSWORD="1234";


    public DbConnect() {
        try {
            Class.forName(MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql8 드라이버 오류: "+e.getMessage());
        }
    }
    public Connection getConnection()
    {
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            System.out.println("Mysql 서버 연결 실패 : "+e.getMessage());
        }
        return conn;
    }



    public  void dbClose(PreparedStatement pstmt, Connection conn)
    {
        try {
            pstmt.close();
            conn.close();
        } catch (SQLException | NullPointerException e) {
            //e.printStackTrace();
        }
    }
    public  void dbClose(PreparedStatement pstmt, Connection conn,ResultSet rs)
    {
        try {
            pstmt.close();
            conn.close();
            rs.close();
        } catch (SQLException | NullPointerException e) {
            //e.printStackTrace();
        }
    }
}
