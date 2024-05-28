package data.service;

import data.dto.BoardAnswerDto;
import data.mapper.BoardAnswerMapperInter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardAnswerService {

    private BoardAnswerMapperInter anInter;

    public void insertAnswer(BoardAnswerDto dto) {
        anInter.insertAnswer(dto);
    }
    public void deleteAnswer(int aidx) {
        anInter.deleteAnswer(aidx);
    }

    public List<BoardAnswerDto> getAnswerData(int num) {
        return anInter.getAnswerData(num);
    }
}
