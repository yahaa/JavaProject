package com.zihua.test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zihua on 16-10-1.
 */
public class QQFrame extends JFrame {
    private JTextArea jtexta;
    private JScrollPane jScrollPane;

    private JPanel jPanel;
    private JComboBox jcbox;
    private JTextField jField;
    private JButton sendB;

    public QQFrame(){
        //设置文本框
        jtexta=new JTextArea();
        jScrollPane=new JScrollPane(jtexta);
        //设置发送框
        jPanel=new JPanel();
        String []word={"zihua","haha","kaka"};
        jcbox=new JComboBox(word);
        jField=new JTextField(10);
        sendB=new JButton("发送");
        //在发送框panel 中插入组件
        jPanel.add(jcbox);
        jPanel.add(jField);
        jPanel.add(sendB);
        //把组件放入Frame
        this.add(jScrollPane);
        this.add(jPanel, BorderLayout.SOUTH);

        //窗体设置
        this.setTitle("QQ");
        this.setIconImage(new ImageIcon("Images/qqIcon.jpg").getImage());
        this.setSize(400,300);
        this.setLocation(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    //public static void main(String[]args){
   // }

}
