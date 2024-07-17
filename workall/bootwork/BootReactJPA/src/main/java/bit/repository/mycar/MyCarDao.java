package bit.mycar.repository;

import bit.mycar.data.MycarDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MyCarDao {

    private MyCarDaoInter myCarDaoInter;

    public List<MycarDto> getAllDatas() {
        return myCarDaoInter.findAll(Sort.by(Sort.Direction.DESC,"num"));//번호의 내림차순
    }

    public void insertMycar(MycarDto dto) {
        myCarDaoInter.save(dto);
    }

    public void deleteMycar(Long num) {
        myCarDaoInter.deleteById(num);
    }

    public MycarDto getData(Long num) {
        return myCarDaoInter.getReferenceById(num);
    }

    //수정-구입일,사진,등록일 제외수정
    public void updateMycar(MycarDto dto) {
        myCarDaoInter.save(dto);//num포함으로 수정
    }
}
