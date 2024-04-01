package day0401;

public class Ex1_Thrread extends Thread{
    private String ThreadName;
    private int count;

    public Ex1_Thrread(String ThreadName, int count) {
        this.ThreadName=ThreadName;
        this.count=count;
    }
    @Override
    public void run(){
        for (int i = 0; i <= count; i++) {
            System.out.println(ThreadName+":"+i);
        }
        super.run();
    }
    public static void main(String[] args) {
        Ex1_Thrread ex1 = new Ex1_Thrread("1번쓰레드", 300);
        Ex1_Thrread ex2 = new Ex1_Thrread("2번쓰레드", 300);
        Ex1_Thrread ex3 = new Ex1_Thrread("3번쓰레드", 300);
        ex1.start();
        ex2.start();
        ex3.start();

    }
}
