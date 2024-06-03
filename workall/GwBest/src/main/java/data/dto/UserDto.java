package data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Alias("UserDto")
public class UserDto {
    private String passwd;
    private String birthday;
    private int gender;
    private String hp;
    private String addr;
    private String id;
}
