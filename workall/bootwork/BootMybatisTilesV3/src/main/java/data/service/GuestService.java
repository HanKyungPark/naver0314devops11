package data.service;

import data.dto.GuestDto;
import data.dto.GuestPhotoDto;
import data.mapper.GuestMapperInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

    @Autowired
    private GuestMapperInter guestMapper;

    public void insertGuest(GuestDto dto) {
        guestMapper.insertGuest(dto);

    }

    public void insertGuestPhoto(GuestPhotoDto dto) {
        guestMapper.insertGuestPhoto(dto);
    }

}
