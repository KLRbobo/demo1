package PracticeBall;

public class BasketStudent extends ballStyle{
    public BasketStudent() {
    }

    public BasketStudent(String name, int age) {
        super(name, age);
    }

    @Override
    public void work() {
        System.out.println("学打篮球");
    }
}
