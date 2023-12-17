package Project1;

import javax.swing.*;

public class JframLogon extends JFrame {
    //注册主界面
    public JframLogon(){
       initJfram();


    }
    //初始化桌面
    public void initJfram(){
        this.setSize(550,450);
        this.setTitle("登录");
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }
    //增加背景图片
    public void initbackground(){
        JLabel background = new JLabel(new ImageIcon("D:\\java\\SprintPractice\\puzzlegame\\image\\background.png"));
        background.setBounds(10,10,400,400);
        this.getContentPane().add(background);
    }
}
