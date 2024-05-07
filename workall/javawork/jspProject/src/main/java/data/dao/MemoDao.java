package data.dao;

import data.dto.MemoDto;
import db.Common.MySqlCnnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class MemoDao {
    MySqlCnnect connect = new MySqlCnnect();

    public void insertMemo(MemoDto dto) {
        Connection conn = connect.getConnection();
        PreparedStatement ps = null;
        String sql="insert into mymemo (uploadphoto,title,content,writeday) values (?,?,?,now())";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getUploadPhoto());
            ps.setString(2, dto.getTitle());
            ps.setString(3, dto.getContent());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connect.dbclose(ps, conn);
            }
        }
    }

    public List<MemoDto> getAllMemo() {
        List<MemoDto> list = new Vector<MemoDto>();
        Connection conn = connect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql="select * from mymemo order by num desc";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                MemoDto dto = new MemoDto();
                dto.setNum(rs.getInt("num"));
                dto.setUploadPhoto(rs.getString("uploadPhoto"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriteday(rs.getTimestamp("writeday"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.dbclose(rs, ps, conn);
        }
        return list;
    }

    public MemoDto getData(int num) {
        MemoDto dto = new MemoDto();
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM myMemo where num=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto.setNum(rs.getInt("num"));
                dto.setUploadPhoto(rs.getString("uploadPhoto"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriteday(rs.getTimestamp("writeday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.dbclose(rs, pstmt, conn);
        }
        return dto;
    }
}

