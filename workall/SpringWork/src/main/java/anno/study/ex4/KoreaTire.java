package anno.study.ex4;

import org.springframework.stereotype.Component;

@Component //koreaTire 가 아이디가 된다
public class KoreaTire implements Tire
{
    @Override
    public String getTireName() {
        return "한국타이어";
    }
}
