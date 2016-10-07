package com.zihua.test;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.lnf.beautyeye.ch4_scroll.BEScrollPaneUI;
import org.jb2011.lnf.beautyeye.ch19_list.BEListUI;

import javax.swing.*;
import javax.swing.text.View;

/**
 * Created by zihua on 16-10-7.
 */
public class ViewTest {
    private JFrame frame;
    private JScrollPane jspane;

    public ViewTest(){
        JPanel pp=new JPanel();
        frame=new JFrame("JUST !");
        jspane=new JScrollPane();

        JPanel p1=new JPanel();
        JButton b1=new JButton("B1");

        p1.add(b1);

        JPanel p2=new JPanel();
        JButton b2=new JButton("B2");
        p2.add(b2);

        JPanel p3=new JPanel();
        JButton b3=new JButton("B3");
        p1.add(b3);

        jspane.add(p1);
        jspane.add(p2);
        jspane.add(p3);

        pp.add(jspane);
        frame.add(pp);
        frame.setSize(200,400);
        frame.setVisible(true);
        frame.setLocation(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public static void main(String[]args){
        new ViewTest();
    }

}
