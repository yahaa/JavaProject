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
public class ChatHall {
    JFrame f;
    MyPanel jp1;
    MyPanel jp2;
    MyPanel jp3;
    MyPanel jp4;
    public ChatHall(){
        try{
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();

            f=new JFrame("聊天室厅");
            JPanel center=new JPanel(new GridLayout(2,1));
            JPanel center1=new JPanel();
            JPanel center2=new JPanel(new GridLayout(4,1));


            JLabel picu=new JLabel(new ImageIcon("Images/destory.gif"));
            center1.add(picu);

            jp1=new MyPanel("展开群聊");
            jp2=new MyPanel("好友列表");
            jp3=new MyPanel("离线好友");
            jp4=new MyPanel("更多........");
            center2.add(jp1);
            center2.add(jp2);
            center2.add(jp3);
            center2.add(jp4);


            center.add(center1);
            center.add(center2);

            f.add(center);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(200,400);
            f.setVisible(true);
            f.setLocation(200,200);

        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[]args){
        new ChatHall();
    }


}

class MyPanel extends JPanel{
    private JButton name;
    public MyPanel(){
        name=new JButton("OK");
        this.add(name);
    }

    public MyPanel(String names){
        try{
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
            name=new JButton(names);
            name.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
            this.add(name);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


}

