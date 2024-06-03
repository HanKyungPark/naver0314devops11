package data.service;

import data.dto.GameDto;
import data.mapper.GameMapperInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameMapperInter gameMapperInter;

    public void insertGame(GameDto dto) {
        gameMapperInter.insertgame(dto);
    }
}
