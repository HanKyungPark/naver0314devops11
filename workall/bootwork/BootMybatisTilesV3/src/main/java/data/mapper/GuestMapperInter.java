package data.mapper;

import data.dto.GuestDto;
import data.dto.GuestPhotoDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GuestMapperInter {

    public void insertGuest(GuestDto dto);
    public void insertGuestPhoto(GuestPhotoDto dto);

}
