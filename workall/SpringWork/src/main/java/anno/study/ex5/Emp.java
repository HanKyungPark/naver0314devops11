package anno.study.ex5;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Emp {
    @NonNull
    private Sawon sawon;
    @Value("비트701")
    private String empName;
    @Value("03-14")
    private String ipsaday;

    public void sawonInfo() {
        System.out.println("**사원 정보 **");
        System.out.println("입사일  : "+ipsaday);
        System.out.println("회사명 : "+empName);
        System.out.println("사원명 :" + sawon.getName());
        System.out.println("주소 :"+sawon.getAddr());
        System.out.println("나이 :"+sawon.getAge());
    }
}
