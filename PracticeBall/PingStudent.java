package PracticeBall;

public class PingStudent extends ballStyle implements English{
    public PingStudent() {
    }

    public PingStudent(String name, int age) {
        super(name, age);
    }

    @Override
    public void work() {
        System.out.println("学打乒乓球");
    }

}
