package data.service;

import data.dto.UserDto;
import data.mapper.UserMapperInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserMapperInter uInter;

    public void insertUser(UserDto dto) {
        uInter.insertUser(dto);

    }

}
