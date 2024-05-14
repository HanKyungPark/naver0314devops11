package data.dao;

import com.mysql.cj.MysqlConnection;
import data.dto.SimpleBoardDto;
import db.Common.MySqlCnnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SimpleBoadDao {
MySqlCnnect db = new MySqlCnnect();

    public void insertBoard(SimpleBoardDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        String sql ="insert into simpleboard (writer,avata,subject,content,writeday) values (?,?,?,?,now())";

        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getWriter());
            pstmt.setString(2, dto.getAvata());
            pstmt.setString(3, dto.getSubject());
            pstmt.setString(4, dto.getContent());
            //실행
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbclose(pstmt, conn);
        }
    }

    public void updateBoard(SimpleBoardDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        String sql ="update simpleboard set writer=?,avata=?,subject=?,content=? where num=?";

        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getWriter());
            pstmt.setString(2, dto.getAvata());
            pstmt.setString(3, dto.getSubject());
            pstmt.setString(4, dto.getContent());
            pstmt.setInt(5, dto.getNum());
            //실행
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbclose(pstmt, conn);
        }
    }

    public List<SimpleBoardDto>getAllDatas(int start, int persize) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql ="select * from simpleboard order by num desc limit ?,?";
        List<SimpleBoardDto> list = new Vector<SimpleBoardDto>();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1, start);
            pstmt.setInt(2, persize);
            //실행
            rs=pstmt.executeQuery();

            while (rs.next()) {
                SimpleBoardDto dto=new SimpleBoardDto();
                dto.setNum(rs.getInt("num"));
                dto.setWriter(rs.getString("writer"));
                dto.setAvata(rs.getString("avata"));
                dto.setSubject(rs.getString("subject"));
                dto.setContent(rs.getString("content"));
                dto.setReadcount(rs.getInt("readcount"));
                dto.setChu(rs.getInt("chu"));
                dto.setWriteday(rs.getTimestamp("writeday"));

                //list 에 추가
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbclose(pstmt, conn);
        }
        return list;
    }

    public int getTotalcount () {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql ="select count(*) from simpleboard";
        int n=0;
        try {
            pstmt = conn.prepareStatement(sql);
            //실행
            rs=pstmt.executeQuery();
            if (rs.next())
                n = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbclose(rs,pstmt, conn);
        }
        return n;
    }

    public SimpleBoardDto getData(int num) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql ="select * from simpleboard where num=?";
         SimpleBoardDto dto=new SimpleBoardDto();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1, num);
            //실행
            rs=pstmt.executeQuery();

            if (rs.next()) {
                dto.setNum(rs.getInt("num"));
                dto.setWriter(rs.getString("writer"));
                dto.setAvata(rs.getString("avata"));
                dto.setSubject(rs.getString("subject"));
                dto.setContent(rs.getString("content"));
                dto.setReadcount(rs.getInt("readcount"));
                dto.setChu(rs.getInt("chu"));
                dto.setWriteday(rs.getTimestamp("writeday"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbclose(pstmt, conn);
        }
        return dto;
    }

    public void deleteBoard(int num) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        String sql ="delete from simpleboard where num=?";

        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
           pstmt.setInt(1, num);
            //실행
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbclose(pstmt, conn);
        }
    }

    public void updateReadcount(int num) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        String sql ="update simpleboard set readcount=readcount+1 where num=?";

        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1, num);
            //실행
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbclose(pstmt, conn);
        }
    }

    public void updateChu(int num) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        String sql ="update simpleboard set chu=chu+1 where num=?";

        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1, num);
            //실행
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbclose(pstmt, conn);
        }
    }

    }

