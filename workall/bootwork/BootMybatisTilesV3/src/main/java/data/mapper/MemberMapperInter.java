package data.mapper;

import data.dto.MemberDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapperInter {
    @Select("select count(*) from memberdb")
    public int getTotalCount();

    @Select("select count(*) from memberdb where myid=#{searchid}")
    public int getIdCheckCount(String searchid);

    @Insert("""
            insert into memberdb(name,myid,passwd,addr,hp,email,photo,
                     birthday,gaipday) values (#{name},#{myid},#{passwd},#{addr},
                                   #{hp},#{email},#{photo},#{birthday},now())
            """)

    public void insertMember(MemberDto dto);

    @Select("select * from memberdb order by num desc")
    public List<MemberDto> getAllMembers();

    @Select("select * from memberdb where num=#{num}")
    public MemberDto getData(int num);

    @Select("select * from memberdb where myid=#{myid}")
    public MemberDto getDatabyid(String myid);

    @Update("update memberdb set photo=#{photo} where num=#{num}")
    public void updateMember(Map<String, Object> map);

    @Update("update memberdb set name=#{name},addr=#{addr},hp=#{hp},email=#{email} where num=#{num}")
    public void updateMember2(MemberDto dto);

    @Delete("delete from memberdb where num=#{num}")
    public void deleteMember(int num);

    @Select("select count(*) from memberdb where num=#{num} and passwd=#{passwd}")
    public int getMemberCount(int num, String passwd);

    @Select(" select count(*) from memberdb where myid=#{myid} and passwd=#{pass}")
    public int isLoginCheck(String myid, String pass);
}
