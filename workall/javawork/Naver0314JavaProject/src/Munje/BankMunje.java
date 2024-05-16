package Munje;

import db.common.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class BankMunje {
    static DbConnect db = new DbConnect();

    public static void main(String[] args) throws SQLException {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from bank";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            Vector<String> data = new Vector<>();
            data.add(rs.getString("bankNum"));
            data.add(rs.getString("name"));
            data.add(rs.getString(3));
            System.out.println(data);

        }

    }
}


