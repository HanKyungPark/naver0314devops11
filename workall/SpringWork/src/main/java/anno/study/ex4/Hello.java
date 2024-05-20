package anno.study.ex4;


//@Component //xml에 자동등록 이경우는 클래스이름이 곧 아이디가 된다(단 첫글자는 소문자로 변경)

import org.springframework.stereotype.Component;

@Component("h")
public class Hello {

    public void showMessage()
    {
        System.out.println("Hello class 가 가진 메소드 입니다");
    }
}
