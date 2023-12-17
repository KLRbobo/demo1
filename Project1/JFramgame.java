package Project1;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class JFramgame extends JFrame implements KeyListener, ActionListener {
    //创建菜单选项条目的对象
    JMenuItem regameItem = new JMenuItem("重新游戏");
    JMenuItem relogonItem = new JMenuItem("重新登录");
    JMenuItem exitItem = new JMenuItem("退出游戏");
    JMenuItem aboutItem = new JMenuItem("公众号");

    int step = 0;
    int win[][] = new int[][]{
                 {1,2,3},
                 {4,5,6},
                 {7,8,9},
            };
    //构造器
    String path = "D:\\java\\SprintPractice\\puzzlegame\\image\\girl\\girl1\\";
    public JFramgame (){
       //初始化游戏
        initJFram();
        //初始化菜单
        initJmenu();
        //初始化数据
        initData();
        //初始化图片
        initimage();

        this.setVisible(true);

    }
    //创建二维数组
    int data[][] = new int[4][4];
    //记录空白方块的位置
    int x = 0;
    int y = 0;
    //初始化数据
    private void initData() {
        int arr1[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        Random r = new Random();
        for (int i = 0; i < arr1.length; i++) {
            int e = r.nextInt(arr1.length);
            int t = arr1[i];
            arr1[i] = arr1[e];
            arr1[e] = t;
        }
        int e = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr1[e]==16){
                    x = i;
                    y = j;
                }
                data[i][j] = arr1[e];
                e++;
            }
        }
    }

    //初始化图片设置
    private void initimage() {
        this.getContentPane().removeAll();

        if (winner()){
            JLabel jLabel = new JLabel(new ImageIcon("D:\\java\\SprintPractice\\images\\else\\win.jpg"));
            jLabel.setBounds(250,250,150,150);
            this.getContentPane().add(jLabel);
        }

        JLabel jLabel1 = new JLabel("步数：" + step);
        jLabel1.setBounds(50,50,100,20);
        this.getContentPane().add(jLabel1);

        //外循环---每一行
        for (int i = 0; i < 4; i++) {
            //内循环-----每一列
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon(path+num+".jpg"));
                jLabel.setBounds(105*j+150,105*i+180,105,105);
                //增添边框
                if (num != 16){jLabel.setBorder(new BevelBorder(0));}
                this.getContentPane().add(jLabel);

            }
        }
        //添加背景图片
        JLabel BlackGround = new JLabel(new ImageIcon("D:\\java\\SprintPractice\\puzzlegame\\image\\background.png"));
        BlackGround.setBounds(10,10,700,700);
        this.getContentPane().add(BlackGround);//this.getLayeredPane().add(jLabel1);

        //刷新图片
        this.getContentPane().repaint();

    }

    //初始化游戏主界面
    private void initJFram(){
        this.setSize(800,800);
        this.setTitle("拼图游戏");
        this.setDefaultCloseOperation(3);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        //增添监听事件
        this.addKeyListener(this);
    }
    //初始化菜单设置
    private void initJmenu(){
        JMenuBar jMenuBar = new JMenuBar();
        JMenu functionjMenu = new JMenu("功能");
        JMenu aboutjMenu = new JMenu("关于我们");
        functionjMenu.add(regameItem);
        functionjMenu.add(relogonItem);
        functionjMenu.add(exitItem);
        aboutjMenu.add(aboutItem);
        jMenuBar.add(functionjMenu);
        jMenuBar.add(aboutjMenu);
        this.setJMenuBar(jMenuBar);

        regameItem.addActionListener(this);
        relogonItem.addActionListener(this);
        exitItem.addActionListener(this);
        aboutItem.addActionListener(this);

    }
    private boolean winner(){
        for (int i = 0; i < win.length; i++) {
            for (int j = 0; j < win[i].length; j++) {
                if (win[i][j] != data[i][j]){return false;}
            }
        }
        return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (winner()){return;}
        int code = e.getKeyCode();
        if (code == 65){
            this.getContentPane().removeAll();
            JLabel jLabel = new JLabel(new ImageIcon("D:\\java\\SprintPractice\\puzzlegame\\image\\girl\\girl1\\all.jpg"));
            jLabel.setBounds(180,180,500,500);
            this.getContentPane().add(jLabel);
            JLabel BlackGround = new JLabel(new ImageIcon("D:\\java\\SprintPractice\\puzzlegame\\image\\background.png"));
            BlackGround.setBounds(60,70,700,700);
            this.getContentPane().add(BlackGround);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (winner()){
            return;
        }
        int code = e.getKeyCode();
        if (code == 37){
            if (y == 3){return;}
            System.out.println("向左移动");
            int t = data[x][y];
            data[x][y] = data[x][y+1];
            data[x][y+1] = t;
            y++;
            step++;
        } else if (code == 38) {
            if (x == 3){return;}
            System.out.println("向上移动");
            int t = data[x][y];
            data[x][y] = data[x+1][y];
            data[x+1][y] = t;
            x++;
            step++;
        } else if (code == 39) {
            if (y == 0){return;}
            System.out.println("向右移动");
            int t = data[x][y];
            data[x][y] = data[x][y-1];
            data[x][y-1] = t;
            y--;
            step++;
        } else if (code == 40) {
            if (x == 0){return;}
            System.out.println("向下移动");
            int t = data[x][y];
            data[x][y] = data[x-1][y];
            data[x-1][y] = t;
            x--;
            step++;
        } else if (code == 87) {
            data = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}
            };
        }

        initimage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == regameItem){
            System.out.println("重新游戏");
            //步数清零
            step = 0;
            //打乱顺序
            initData();
            //添加图片
            initimage();

        } else if (source == relogonItem) {
            System.out.println("重新登录");
            this.setVisible(false);
            new JframLogon();
        } else if (source == exitItem) {
            System.exit(1);
        } else if (source == aboutItem) {
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("D:\\java\\SprintPractice\\images\\else\\myself.jpg"));
            jDialog.add(jLabel);
            jDialog.setBounds(200,200,700,700);
            jDialog.setAlwaysOnTop(true);
            jDialog.setModal(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setVisible(true);
        }
    }
}
