package day0401;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex4_Network {
    public static void main(String[] args) throws UnknownHostException {
        //자기 컴퓨터의 IP 와 컴퓨터이름 알아보기
        InetAddress local = InetAddress.getLocalHost();
        System.out.println("내 컴퓨터의 IP 주소 : "+local.getHostAddress());
        System.out.println("내 컴퓨터의 이름 :"+local.getHostName());
        System.out.println("=".repeat(40));

        System.out.println("Naver 의 서버컴퓨터 IP");
        InetAddress[] naverInet = InetAddress.getAllByName("www.naver.com");
        for(InetAddress inet:naverInet)
            System.out.println("Naver IP : "+inet.getHostAddress());
        System.out.println("=".repeat(40));

        System.out.println("Gogle 의 서버컴퓨터 IP");
        InetAddress[] GogleInet = InetAddress.getAllByName("www.gogle.com");
        for(InetAddress inet:GogleInet)
            System.out.println("Gogle IP : "+inet.getHostAddress());
        System.out.println("=".repeat(40));

        System.out.println("Nate 의 서버컴퓨터 IP");
        InetAddress[] NateInet = InetAddress.getAllByName("www.Nate.com");
        for(InetAddress inet:NateInet)
            System.out.println("Nate IP : "+inet.getHostAddress());


    }
}
