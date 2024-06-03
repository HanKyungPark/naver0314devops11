package data.mapper;

import data.dto.ResultDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResultMapperInter {
    @Insert("insert into result (result1,result2,subject) values (#{result1},#{result2},#{subject})")
    public void result(ResultDto dto);
}
