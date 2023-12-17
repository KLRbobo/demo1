package PracticeBall;

public class BasketballSport extends ballStyle{
    public BasketballSport() {
    }

    public BasketballSport(String name, int age) {
        super(name, age);
    }

    @Override
    public void work() {
        System.out.println("教打篮球");
    }
}
