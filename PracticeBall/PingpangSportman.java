package PracticeBall;

import com.sun.security.jgss.GSSUtil;

public class PingpangSportman extends ballStyle implements English{
    public PingpangSportman() {
    }

    public PingpangSportman(String name, int age) {
        super(name, age);
    }

    @Override
    public void work() {
        System.out.println("教打乒乓球");
    }
}
