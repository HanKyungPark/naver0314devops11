package data.service;

import data.dto.ResultDto;
import data.mapper.ResultMapperInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {
    @Autowired
    private ResultMapperInter resultInter;

    public void result(ResultDto dto) {
        resultInter.result(dto);
    }
}
