package data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Alias("GameDto")
public class GameDto {
    private String id;
    private String photo1;
    private String name1;
    private String photo2;
    private String name2;
    private String subject;

}
