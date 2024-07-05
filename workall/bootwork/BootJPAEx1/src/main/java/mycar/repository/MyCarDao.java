package mycar.repository;

import lombok.AllArgsConstructor;
import mycar.data.MycarDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MyCarDao {

    private MyCarDaoInter daoInter;
    private MycarCommentDaoInter daoCommentInter;

    //db저장
    public void insertCar(MycarDto dto) {
        daoInter.save(dto);//num 타입이 포함되어있을경우 자동으로 update 실행, 없을경우 자동으로 insert 실행
    }

    //전체 목록 출력
    public List<MycarDto> getAllCars() {



        //return daoInter.findAll(); // 추가된 순서로 반환
        return daoInter.findAll(Sort.by(Sort.Direction.DESC, "carprice"));//가격이 비싼순
        //return daoInter.findAll(Sort.by(Sort.Direction.ASC,"carname"));//자동차명의 오름차순
    }

    public MycarDto getData(Long num) {
        return daoInter.getReferenceById(num);
    }

    public void updateCar(MycarDto dto) {
        if (dto.getCarphoto().equals("no"))
            //daoInter.updateMycarNoPhoto(dto.getNum(), dto.getCarname(), dto.getCarprice(), dto.getCarcolor());

            daoInter.updateMycarNoPhoto(dto);
        else
            daoInter.save(dto);//num이 포함되어있을경우 모든컬럼 수정
    }

    public void deleteCar(Long num) {
        daoInter.deleteById(num);
    }

    //전체 갯수 구하기
    public Long getTotalCount() {

        return daoInter.count();
    }

    //페이지 출력
    public Page<MycarDto> getAllCars(Pageable pageable) {

        List<MycarDto> list = daoInter.findAll();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setCommentcount(daoCommentInter.getMycarCommentList(list.get(i).getNum()).size());
        }
        return daoInter.findAll(pageable);//페이지에 필요한만큼만 데이타 반환
    }


}
