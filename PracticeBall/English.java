package PracticeBall;

public interface English {
    public  default void English() {
        System.out.println("说英语");
        show();
        show1();//最好用静态调用静态
    }
    public static void im(){
        show1();
    }
    private  void show(){
        System.out.println("展示一下");
    }
    private static void show1(){
        System.out.println("展示两下");
    }
}
