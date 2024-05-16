package db.Common;

import java.sql.*;

public class MySqlCnnect { static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?severTinezone=UTC";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";

    public MySqlCnnect() {
        try {
            Class.forName(MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("MYsql 드라이버 실패:"+e.getMessage());
        }
    }
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("MYSQL 연결 실패 :"+e.getMessage());
        }
        return conn;
    }
    public void dbclose(ResultSet rs, PreparedStatement pstmt, Connection conn)
    {
        try {
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    public void dbclose(PreparedStatement pstmt, Connection conn)
    {
        try {
            pstmt.close();
            conn.close();
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void dbclose(ResultSet rs,Statement stmt, Connection conn)
    {
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    public void dbclose(Statement stmt, Connection conn)
    {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
