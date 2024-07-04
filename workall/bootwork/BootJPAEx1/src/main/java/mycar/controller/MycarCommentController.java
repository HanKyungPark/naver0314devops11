package mycar.controller;


import lombok.RequiredArgsConstructor;
import mycar.data.MyCarCommentDto;
import mycar.data.MycarDto;
import mycar.repository.MyCarDao;
import mycar.repository.MycarCommentDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/mycar")
public class MycarCommentController {
    private final MycarCommentDao myCarCommentDao;

    @GetMapping("/addcomment")
    public void addComment(@RequestParam("num") Long num,
                           @RequestParam("comment") String comment) {

        MycarDto dto = MycarDto.builder()
                .num(num)
                .build();
        //num=num, car..=null.....

        MyCarCommentDto Dto = MyCarCommentDto.builder()
                .comment(comment)
                .mycar(dto)
                .build();

        myCarCommentDao.insertComment(Dto);


    }

    @GetMapping("/commentlist")
    public List<MyCarCommentDto> commentList(@RequestParam("num") Long num) {
        return myCarCommentDao.getAllComments(num);
    }

    @GetMapping("/commentdelete")
    public void commentDelete(@RequestParam("idx") int idx) {
        myCarCommentDao.deleteComment(idx);
    }



}
