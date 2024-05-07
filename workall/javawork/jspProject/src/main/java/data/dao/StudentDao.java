package data.dao;

import data.dto.StudentDto;
import db.Common.MySqlCnnect;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class StudentDao {
    MySqlCnnect db = new MySqlCnnect();

    //추가
    public void insertStudent(StudentDto dto) {
        String sql = "insert into mystudent (name,blood,license,java,spring,html,writeday)values(?,?,?,?,?,?,now())";
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = db.getConnection();

        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getBlood());
            pstmt.setString(3, String.valueOf(dto.getLicense()));
            pstmt.setInt(4, dto.getJava());
            pstmt.setInt(5, dto.getSpring());
            pstmt.setInt(6, dto.getHtml());

            //실행
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println("insert 오류 :" + e.getMessage());
        } finally {
            db.dbclose(pstmt, conn);
        }
    }

    //목록출력
    public List<StudentDto> getAllStundent() {
        List<StudentDto> list = new Vector<StudentDto>();
        String sql = "select * from mystudent order by num";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn = db.getConnection();

        try {
            pstmt = conn.prepareStatement(sql);
            //실행
            rs = pstmt.executeQuery();
            while (rs.next()) {
                StudentDto dto = new StudentDto();

                dto.setNum(rs.getInt("num"));
                dto.setName(rs.getString("name"));
                dto.setBlood(rs.getString("blood"));
                dto.setLicense(rs.getString("license").charAt(0));
                dto.setJava(rs.getInt("java"));
                dto.setSpring(rs.getInt("spring"));
                dto.setHtml(rs.getInt("html"));
                dto.setWriteday(rs.getTimestamp("writeday"));
                list.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("select 오류:" + e.getMessage());
        } finally {
            db.dbclose(rs, pstmt, conn);
        }
        return list;
    }

    //디테일
    public StudentDto getData(int num) {
        StudentDto dto = new StudentDto();
        String sql = "select * from mystudent where num=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn = db.getConnection();


        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto.setNum(rs.getInt("num"));
                dto.setName(rs.getString("name"));
                dto.setLicense(rs.getString("license").charAt(0));
                dto.setJava(rs.getInt("java"));
                dto.setSpring(rs.getInt("spring"));
                dto.setHtml(rs.getInt("html"));
                dto.setWriteday(rs.getTimestamp("writeday"));
                dto.setBlood(rs.getString("blood"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbclose(rs, pstmt, conn);
        }
        return dto;
    }

    public void deleteStudent(int num) {
        String sql = "delete from mystudent where num=?";
        Connection conn = null;
        conn = db.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbclose(pstmt, conn);
        }
    }



    //업데이트
    public void updateStudent(StudentDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update mystudent set name=?,blood=?,license=?,java=?,spring=?,html=?,writeday=now() where num=?";
        conn = db.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getBlood());
            pstmt.setString(3, String.valueOf(dto.getLicense()));
            pstmt.setInt(4, dto.getJava());
            pstmt.setInt(5, dto.getSpring());
            pstmt.setInt(6, dto.getHtml());
            pstmt.setInt(7, dto.getNum());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbclose(pstmt, conn);
        }
    }
}