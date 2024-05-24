package data.service;

import data.dto.MemberDto;
import data.mapper.MemberMapperInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Memberservice {
    @Autowired
    private MemberMapperInter memInter;

    public int getTotalCount() {
        return memInter.getTotalCount();
    }

    public int getIdCheckCount(String searchid) {
        return memInter.getIdCheckCount(searchid);
    }

    public void insertMember(MemberDto dto) {
        memInter.insertMember(dto);
    }

    public List<MemberDto> getAllMembers() {
        return memInter.getAllMembers();
    }

    public MemberDto getData(int num){
        return memInter.getData(num);
    }

    public void updateMember(int num, String photo) {
        Map<String, Object> map = new HashMap<>();
        map.put("num", num);
        map.put("photo", photo);
        memInter.updateMember(map);
    }

    public void updateMember2(MemberDto dto) {
        memInter.updateMember2(dto);
    }

    public boolean inEqualPassCheck(int num, String passwd) {
        Map<String,Object> map = new HashMap<>();
        map.put("num", num);
        map.put("passwd", passwd);
        return  memInter.getMemberCount(num,passwd) == 1;
    }


    public void deleteMember(int num) {
        memInter.deleteMember(num);
    }

}
