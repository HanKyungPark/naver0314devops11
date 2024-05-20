package study.ex2;

public class MyInfo {
    private String name;
    private int age;
    private String addr;

    @Override
    public String toString() {
        return "MyInfo{" + "name='" + name + '\'' + ", age=" + age + ", addr='" + addr + '\'' + '}';
    }

    public MyInfo(String name, int age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;

    }
}
