package data.dao;

import data.dto.ShopDto;
import db.Common.MySqlCnnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class ShopDao {
    MySqlCnnect connect = new MySqlCnnect();

    public void insertShop(ShopDto dto)
    {
        Connection conn=null;
        PreparedStatement pstmt=null;

        String sql="insert into myshop (sname,sprice,scount,scolor,sphoto,writeday) values(?,?,?,?,?,now()) ";
        conn=connect.getConnection();//db연결
        try {
            pstmt=conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1,dto.getSname());
            pstmt.setInt(2, dto.getSprice());
            pstmt.setInt(3, dto.getScount());
            pstmt.setString(4, dto.getScolor());
            pstmt.setString(5, dto.getSphoto());
            //실행
            pstmt.execute();

        }catch (SQLException e){
            System.out.println("insert 오류:"+e.getMessage());
        }finally {
            connect.dbclose(pstmt,conn);
        }
    }

    public List<ShopDto> getShopDatas(){
        List<ShopDto> list=new Vector<ShopDto>();
            Connection conn=null;
            PreparedStatement pstmt=null;
            ResultSet rs=null;
            String sql="select * from myshop order by shopidx desc";

            conn=connect.getConnection();
      try {
          pstmt = conn.prepareStatement(sql);
          rs = pstmt.executeQuery();
          while (rs.next()) {
              ShopDto dto=new ShopDto();

              dto.setShopidx(rs.getString("shopidx"));
              dto.setSname(rs.getString("sname"));
              dto.setSprice(rs.getInt("sprice"));
              dto.setScount(rs.getInt("scount"));
              dto.setScolor(rs.getString("scolor"));
              dto.setSphoto(rs.getString("sphoto"));
              dto.setWriteday(rs.getTimestamp("writeday"));

              //list 추가
              list.add(dto);

          }
      }catch (SQLException e){
          System.out.println("select 오류 :"+e.getMessage());
      }finally {
          connect.dbclose(rs,pstmt,conn);
      }
            return list;
        }
        public ShopDto getSangpum(int shopidx){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from myshop where shopidx=?";

        ShopDto dto=new ShopDto();
        conn=connect.getConnection();
            try {
                pstmt = conn.prepareStatement(sql);
                //바인딩
                pstmt.setInt(1, shopidx);
                //실행
                rs=pstmt.executeQuery();
                if (rs.next()) {
                    dto.setShopidx(rs.getString("shopidx"));
                    dto.setSname(rs.getString("sname"));
                    dto.setSprice(rs.getInt("sprice"));
                    dto.setScount(rs.getInt("scount"));
                    dto.setScolor(rs.getString("scolor"));
                    dto.setSphoto(rs.getString("sphoto"));
                    dto.setWriteday(rs.getTimestamp("writeday"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                connect.dbclose(pstmt,conn);
            }
            return dto;
        }

    //수정
    public void updateShop(ShopDto dto) {
        String sql="update myshop set sname=?,scolor=?,sprice=?,scount=?,sphoto=?,where shopidx=?";
    }
    //삭제
    public void deleteShop(int shopidx) {
        String sql="delete from myshop where shopidx=?";
    }
    }

