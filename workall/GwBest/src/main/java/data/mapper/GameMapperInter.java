package data.mapper;

import data.dto.GameDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GameMapperInter {

    @Insert("insert into upload (id,photo1,name1,photo2,name2,subject) values( #{id},#{photo1},#{name1},#{photo2},#{name2},#{subject})")
    public void insertgame(GameDto dto);
}
