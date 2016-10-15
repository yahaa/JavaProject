package com.zihua.test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zihua on 16-10-1.
 */
public class Circle extends JFrame {
    private MyPanel mp=null;
    public Circle(){
        mp=new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[]args){
        Circle a=new Circle();
    }
}

class MyPanel extends JPanel{
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawOval(20,20,100,100);
        g.draw3DRect(20,20,30,40,true);
        g.drawString("zihua",150,140);
    }
}
