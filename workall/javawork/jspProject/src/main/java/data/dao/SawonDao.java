package data.dao;

import db.Common.MySqlCnnect;
import data.dto.SawonDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class SawonDao {
    MySqlCnnect db=new MySqlCnnect();

    //추가
    public void insertSawon(SawonDto dto) {
        String sql="insert into mysawon(name,buseo,age,addr,photo,gender,birthday) " +
                "values (?,?,?,?,?,?,?)";
        Connection conn=null;
        PreparedStatement pstmt=null;
        conn=db.getConnection();

        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getBuseo());
            pstmt.setInt(3, dto.getAge());
            pstmt.setString(4, dto.getAddr());
            pstmt.setString(5, dto.getPhoto());
            pstmt.setString(6, dto.getGender());
            pstmt.setString(7, dto.getBirthday());
            //실행
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println("insert 오류 :"+e.getMessage());
        }finally {
            db.dbclose(pstmt,conn);
        }
    }
    //업데이트
    public void updateSawon(SawonDto dto) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        String sql="update mysawon set name=?,buseo=?,age=?,addr=?,photo=?,gender=?,birthday=? where num=?";
        conn=db.getConnection();

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getBuseo());
            pstmt.setInt(3, dto.getAge());
            pstmt.setString(4, dto.getAddr());
            pstmt.setString(5, dto.getPhoto());
            pstmt.setString(6, dto.getGender());
            pstmt.setString(7, dto.getBirthday());
            pstmt.setInt(8, dto.getNum());
            pstmt.execute();
        } catch (SQLException e) {
           e.printStackTrace();
        }finally {
            db.dbclose(pstmt,conn);
        }
    }

    public void deleteSawon(int num) {
        String sql="delete from mysawon where num=?";
        Connection conn=null;
        conn=db.getConnection();
        PreparedStatement pstmt=null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            pstmt.execute();
        } catch (SQLException e) {

        }finally {
            db.dbclose(pstmt,conn);
        }
    }
    //전체출력
    public List<SawonDto> getAllSawons() {
        List<SawonDto> list = new Vector<SawonDto>();
        String sql="select * from mysawon order by name asc";
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        conn=db.getConnection();

        try {
            pstmt = conn.prepareStatement(sql);
            //실행
            rs = pstmt.executeQuery();

            while (rs.next()) {
            SawonDto dto = new SawonDto();

            //dto.setSawon(rs.getString("Sawonidx"));
            dto.setName(rs.getString("name"));
            dto.setBuseo(rs.getString("buseo"));
            dto.setAge(rs.getInt("age"));
            dto.setAddr(rs.getString("addr"));
            dto.setPhoto(rs.getString("photo"));
            dto.setGender(rs.getString("gender"));
            dto.setBirthday(rs.getString("birthday"));
            dto.setNum(rs.getInt("num"));

            list.add(dto);
            }
        }catch (SQLException e) {
            System.out.println("select 오류:"+e.getMessage());
        }finally {
            db.dbclose(pstmt,conn);
        }
        return list;
    }
    //한개반환
    public SawonDto getData(int num) {
        SawonDto dto = new SawonDto();
        String sql="select * from mysawon where num=?";
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        conn=db.getConnection();
        try {
            pstmt=conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1, num);
            //실행
            rs=pstmt.executeQuery();
            if (rs.next()) {
                dto.setName(rs.getString("name"));
                dto.setBuseo(rs.getString("buseo"));
                dto.setAge(rs.getInt("age"));
                dto.setAddr(rs.getString("addr"));
                dto.setPhoto(rs.getString("photo"));
                dto.setGender(rs.getString("gender"));
                dto.setBirthday(rs.getString("birthday"));
                dto.setNum(rs.getInt("num"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbclose(pstmt,conn);
        }
        return dto;
    }

    //성별 분석 데이타 반환
    public List<Map<String,String>> getGenderAnalysis() {
        List<Map<String,String>> list = new Vector<Map<String,String>>();
    String sql="select gender, count(*) count, avg(age) age from mySawon group by gender";
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    conn=db.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Map<String,String> map = new HashMap<String,String>();
                String gender = rs.getString("gender");
                String count = rs.getString("count");
                String age = rs.getString("age");

                //map에넣기
                map.put("gender", gender);
                map.put("count", count);
                map.put("age", age);


                //list 에 추가
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbclose(rs,pstmt,conn);
        }
        return  list;
    }
    //부서 분석 데이타 반환
    public List<Map<String,String>> getBuseoAnalysis() {
        List<Map<String,String>> list = new Vector<Map<String,String>>();
        String sql="select buseo, count(*) count, round(avg(age),1) age from mySawon group by buseo";
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        conn=db.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Map<String,String> map = new HashMap<String,String>();
                String buseo = rs.getString("buseo");
                String count = rs.getString("count");
                String age = rs.getString("age");

                //map에넣기
                map.put("buseo", buseo);
                map.put("count", count);
                map.put("age", age);

                //list 에 추가
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbclose(rs,pstmt,conn);
        }
        return  list;
    }
}
