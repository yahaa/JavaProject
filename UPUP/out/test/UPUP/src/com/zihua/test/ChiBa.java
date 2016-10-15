package com.zihua.test;

import javax.swing.*;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

/**
 * Created by zihua on 16-10-1.
 */
public class ChiBa extends JFrame{
    private JSplitPane jsp;
    private JList jList;
    private JLabel jLable;

    public ChiBa(){
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
            //列表
            String[] word = {"haha", "xixi", "hehehe", "kakaka"};
            jList = new JList(word);
            //图片
            jLable = new JLabel(new ImageIcon("Images/2.jpg"));

            jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jList, jLable);
            jsp.setOneTouchExpandable(true);
            //设置布局

            //添加组件
            this.add(jsp);
            //设置大小
            this.setSize(400, 300);
            this.setLocation(200, 200);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[]args){

        UIManager.put("RootPane.setupButtonVisible",false);
        ChiBa a=new ChiBa();
    }

}
