package data.mapper;

import data.dto.ReBoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReboardMapperInter {
    public int getMaxNum();

    public void updateRestep(Map<String, Integer> map);//regroup,restep

    public void insertBoard(ReBoardDto dto);
    public int getTotalCount();

    public List<ReBoardDto> getPaginList(Map<String, Integer> map);//start,perpage

    public void updateReadcount(int num);

    public ReBoardDto getData(int num);

    public void updateBoard(ReBoardDto dto);

    public void deleteBoard(int num);

    

}
