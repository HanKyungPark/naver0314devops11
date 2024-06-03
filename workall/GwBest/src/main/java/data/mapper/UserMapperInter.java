package data.mapper;


import data.dto.UserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapperInter {
    @Insert("insert into user (id,passwd,birthday,hp,gender,name,addr) values( #{id},#{passwd},#{birthday},#{hp},#{gender},#{name},#{addr})")
    public void insertUser(UserDto dto);



}
