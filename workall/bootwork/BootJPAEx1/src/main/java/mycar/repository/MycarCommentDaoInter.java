package mycar.repository;


import mycar.data.MyCarCommentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MycarCommentDaoInter extends JpaRepository<MyCarCommentDto,Integer> {

    //num에 해당하는 모든 댓글반환
    @Query(value = "select * from mycar_comment where num=:num order by idx desc",nativeQuery = true)
    public List<MyCarCommentDto> getMycarCommentList(@Param("num") Long num);
}



