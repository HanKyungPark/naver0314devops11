package data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Alias("badto")
public class BoardAnswerDto {
    private int aidx;
    private int num;
    private String writer;
    private String myid;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/seoul")
    private Timestamp writeday;
}
