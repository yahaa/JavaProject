package com.zihua.chatRoom;
import com.zihua.test.QQFrame;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 * Created by zihua on 16-10-7.
 */

public class LoginWin {
    private JFrame f = null;
    private JTextField username = new JTextField(10);
    private JPasswordField password = new JPasswordField(10);
    private JLabel user = null;
    private JLabel pwd = null;
    private JButton login = null;
    private JButton register = null;
    private JLabel blank1 = null;
    private JLabel blank2 = null;
    private JMenuBar menuBar = null;

    public LoginWin(){
        try{
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();

            f = new JFrame("登录");
            menuBar = createMenus();
            f.setJMenuBar(menuBar);
            user = new JLabel("用 名：");
            pwd = new JLabel("密 码：");
            login = new JButton("登录");
            register = new JButton("注册");
            login.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
            login.setForeground(Color.white);
            register.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
            register.setForeground(Color.white);

            login.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    String user=username.getText();
                    String pass=new String(password.getPassword());
                    System.out.println(user);
                    System.out.println(pass);
                    if(user.compareTo("yahaa")==0&&pass.compareTo("123")==0){
                        JOptionPane.showMessageDialog(null, "登录成功，欢迎您：" + username.getText());
                        //f.setVisible(false);
                        ChatHall a=new ChatHall(username.getText());
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "用户名密码错误，请重新输入");
                        return;
                    }

                }

            });

            register.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    username.setText("");
                    password.setText("");
                }
            });

        }catch(Exception e){
            e.printStackTrace();
        }

        JPanel center=new JPanel(new GridLayout(3,1));

        JLabel image=new JLabel();

        JPanel p = new JPanel();
        GridLayout tt=new GridLayout(2,1,0,0);
        p.setLayout(tt);

        JPanel pname=new JPanel();
        user.setSize(20,20);
        username.setSize(60,20);
        pname.add(user);
        pname.add(username);
        JPanel ppass=new JPanel();
        pwd.setSize(20,20);
        password.setSize(40,20);
        ppass.add(pwd);
        ppass.add(password);
        p.add(pname);
        p.add(ppass);

        JLabel image2=new JLabel();

        center.add(image);
        center.add(p);
        center.add(image2);

        JPanel bt = new JPanel();
        bt.setLayout(new GridLayout(1, 2));
        bt.add(login);
        bt.add(register);

        f.add(center,BorderLayout.CENTER);
        f.add(bt,BorderLayout.SOUTH);
        f.setSize(new Dimension(500,600));
        f.setUndecorated(true);
        f.setVisible(true);
        f.setBounds(300, 100, 500, 350);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


    public JMenuBar createMenus() {
        JMenuItem mi;
        JMenuBar menuBar = new JMenuBar();
        menuBar.getAccessibleContext().setAccessibleName("工具栏");

        JMenu fileMenu = (JMenu) menuBar.add(new JMenu("文件"));
        createMenuItem(fileMenu, "新建", "FileMenu.about_mnemonic", "新建文件",null);
        createMenuItem(fileMenu, "保存", "FileMenu.about_mnemonic", "保存文件",null);
        createMenuItem(fileMenu, "删除", "FileMenu.about_mnemonic", "删除文件",null);
        createMenuItem(fileMenu, "另存为...", "FileMenu.about_mnemonic", "另存为...",null);
        fileMenu.addSeparator();
        JMenu editMenu = (JMenu) menuBar.add(new JMenu("编辑"));
        createMenuItem(editMenu, "字体大小", "FileMenu.about_mnemonic", "字体大小",null);
        createMenuItem(editMenu, "颜色", "FileMenu.about_mnemonic", "颜色",null);
        createMenuItem(editMenu, "格式", "FileMenu.about_mnemonic", "格式",null);
        fileMenu.addSeparator();
        editMenu.addSeparator();
        return menuBar;
    }

    public JMenuItem createMenuItem(JMenu menu, String label, String mnemonic,
                                    String accessibleDescription, Action action){
        JMenuItem mi = (JMenuItem) menu.add(new JMenuItem(label));
        mi.setMnemonic(mnemonic.charAt(0));
        mi.getAccessibleContext().setAccessibleDescription(accessibleDescription);
        mi.addActionListener(action);
        if(action == null) {
            mi.setEnabled(false);
        }
        return mi;
    }

    public static void main(String[] args){
        UIManager.put("RootPane.setupButtonVisible",false);
        new LoginWin();
    }
}



