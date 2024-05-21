package member.dao;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.dto.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDao {

    //@Autowired

    @NonNull
    private SqlSession session;

    private String namespace ="member.dao.MemberDao.";

    public int getTotalCount() {
        return session.selectOne(namespace+"memberTotalCount");
    }

    public int getSearchId(String searchid) {
        return session.selectOne(namespace + "selectIdCheck", searchid);
    }

    public void insertMember(MemberDto dto) {
        session.insert(namespace + "insertMember", dto);

    }

    public List<MemberDto> getAllMembers() {
        return session.selectList(namespace+"selectAllMembers");
    }
}
