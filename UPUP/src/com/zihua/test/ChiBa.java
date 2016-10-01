package com.zihua.test;

import javax.swing.*;

/**
 * Created by zihua on 16-10-1.
 */
public class ChiBa extends JFrame{
    private JSplitPane jsp;
    private JList jList;
    private JLabel jLable;

    public ChiBa(){
        //列表
        String []word={"haha","xixi","hehehe","kakaka"};
        jList=new JList(word);
        //图片
        jLable=new JLabel(new ImageIcon("Images/2.jpg"));

        jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jList,jLable);
        jsp.setOneTouchExpandable(true);
        //设置布局

        //添加组件
        this.add(jsp);
        //设置大小
        this.setSize(400,300);
        this.setLocation(200,200);
        this.setVisible(true);

    }

    public static void main(String[]args){
        ChiBa a=new ChiBa();
    }

}
