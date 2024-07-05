package mycar.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Timestamp;

@Entity
@Table(name = "mycar_comment")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties
public class MyCarCommentDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    //    은행 서비스에서 사용자(TABLE_USER) 가 1개 이상의 계좌(TABLE_ACCOUNT)를 가질수 있다고 가정할경우
    //    TABLE_USER입장에서 ONETOMANY보면 이고, TABLE_ACCOUNT입장에서 보면 MANYTOONE이다
    @ManyToOne
    @JoinColumn(name = "num")
    @OnDelete(action = OnDeleteAction.CASCADE)//부모테이블의 데이타를 지우면 댓글은 자동삭제
    private MycarDto mycar;


    @Column(length=200)//아예 생략시 255가 된다.
    private String comment;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    @Column(updatable = false) //수정시 제외컬럼
    @CreationTimestamp //엔티티가 생성되는 시점의 시간이 자동등록
    private Timestamp writeday;

}
