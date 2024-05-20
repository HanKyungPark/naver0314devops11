package anno.study.ex5;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Data
@Component
public class Sawon {
    @Value("김창인")
    private String name;
    @Value("비트캠프")
    private String addr;
    @Value("19")
    private int age;

}
