package anno.study.ex4;

import org.springframework.stereotype.Component;

@Component //xml 에 canadaTire 로 등록
public class CanadaTire  implements Tire{
    @Override
    public String getTireName() {
        return "캐나다타이어";
    }
}
