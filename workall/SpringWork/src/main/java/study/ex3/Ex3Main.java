package study.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex3Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("appex3.xml");
        MyCart cart = context.getBean("cart", MyCart.class);
        cart.showInfo();

        MyCart cart2 = context.getBean("cart", MyCart.class);
        cart.showInfo();


        System.out.println("싱글톤인경우는 여러번 생성해도" +
                " 주소가 같고 prototype 인경우는 새로 생성할때마다 새로운 주소에 생성된다");
        System.out.println(cart.hashCode());
        System.out.println(cart2.hashCode());//주소출력



    }
}
