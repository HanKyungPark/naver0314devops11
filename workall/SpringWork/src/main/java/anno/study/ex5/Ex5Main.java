package anno.study.ex5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex5Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("appex5.xml");

        Emp emp = (Emp) context.getBean("emp");
        emp.sawonInfo();
    }
}
