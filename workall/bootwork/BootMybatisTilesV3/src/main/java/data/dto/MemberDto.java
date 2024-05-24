package data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@NoArgsConstructor//디폴트생성자
@Data//getter,setter
@Alias("MemberDto")//dto별칭
@Builder//setter 데이터 넣기
@AllArgsConstructor//파라미터 전체를 받는 생성자
public class MemberDto {
    private int num;
    private String name;
    private String myid;
    private String passwd;
    private String addr;
    private String hp;
    private String email;
    private String photo;
    private String birthday;
    private Timestamp gaipday;
}
