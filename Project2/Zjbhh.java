package Project2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zjbhh {
    public static void main(String[] args) {
        JFrame jFrame1 = new JFrame();
        jFrame1.setTitle("赵俊博对你的爱");
        jFrame1.setAlwaysOnTop(true);
        jFrame1.setLocationRelativeTo(null);
        jFrame1.setSize(400,400);
        jFrame1.setLayout(null);
        jFrame1.setDefaultCloseOperation(3);
        JButton jButton1 = new JButton("有本事点我啊");
        jButton1.setBounds(100,100,200,50);
        jFrame1.getContentPane().add(jButton1);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame2 = new JFrame();
                jFrame2.setSize(300,300);
                jFrame2.setAlwaysOnTop(true);
                jFrame2.setLocationRelativeTo(null);
                jFrame2.setLayout(null);
                jFrame2.setDefaultCloseOperation(3);
                JLabel jLabel = new JLabel("我是你爸爸");
                JButton jButton2 = new JButton();
                jFrame2.setVisible(true);
            }
        });
        jFrame1.setVisible(true);
    }
}
