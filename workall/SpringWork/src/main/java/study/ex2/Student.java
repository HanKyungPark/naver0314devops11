package study.ex2;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //final 이나 Nonnull 이 붙은 멤버변수만 생성자 주입
public class Student {
    private String schoolName;
    @NonNull
    MyInfo myInfo;

//    public Student(MyInfo info) {
//        myInfo=info;
//    }

    //학교명은 setter 주입
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public void show()
    {
        System.out.println(myInfo);//toString호출
        System.out.println("학교명 : "+schoolName);

    }
}
