package com.zihua.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Vector;

import static java.lang.Math.*;

/**
 * Created by zihua on 16-10-2.
 */
public class GameTank1 extends JFrame {
    GamePanel gp=null;
    public GameTank1(){
        gp=new GamePanel();
        this.add(gp);
        this.addKeyListener(gp);
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[]args){
        GameTank1 game=new GameTank1();
    }
}


class GamePanel extends JPanel implements KeyListener{
    private Hero hero=null;
    private Vector<Enemy>enemys= new Vector<Enemy>();

    public GamePanel(){
        hero=new Hero(500,300,new Color(0xEB,0xA9,0x48));
        initEnemys(5);
        this.setBackground(new Color(0x99,0x99,0x99));

    }

    private void initEnemys(int n){
        while(n-->0){
            enemys.add(new Enemy(50*(n+n+3),50,new Color(0X69,0XC9,0XA3)));
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        drawBoard(g);
        hero.drawSeft(g);
        for(Enemy e:enemys) e.drawSeft(g);
    }

    public void drawBoard(Graphics g){
        Image im=Toolkit.getDefaultToolkit().getImage(GamePanel.class.getResource("wall.gif"));
        int x=340,y=510;
        for(int i=0;i<4;i++){
            g.drawImage(im,x+i*30,y,30,30,this);
        }
        for(int i=1;i<=2;i++){
            g.drawImage(im,x,y+i*30,30,30,this);
            g.drawImage(im,x+90,y+i*30,30,30,this);
        }

        Image im2=Toolkit.getDefaultToolkit().getImage(GamePanel.class.getResource(""));
        g.drawImage(im2,x+30,y+30,60,60,this);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_DOWN) hero.setY(10);
        else if(e.getKeyCode()==KeyEvent.VK_UP) hero.setY(-10);

        if(e.getKeyCode()== KeyEvent.VK_LEFT) hero.setX(-10);
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT) hero.setX(10);

        if(e.getKeyCode()==KeyEvent.VK_NUMPAD0) hero.setAngle(90);

        super.repaint();

    }

}

class Tank {
    private Color color;
    private int x,y;
    private int dix,diy;
    private double angle;
    public Tank(int x,int y,Color color){
        this.x=x;
        this.y=y;
        this.color=color;
        dix=x+15;
        diy=y-5;
        angle=90;
    }

    public void drawSeft(Graphics g){
         Graphics2D gt=(Graphics2D)g;
        int x=this.getX();
        int y=this.getY();
        gt.setColor(this.getColor());

        gt.fill3DRect(x,y,5,30,false);
        gt.fill3DRect(x+5,y+5,20,20,false);
        gt.fill3DRect(x+25,y,5,30,false);
        gt.fillOval(x+7,y+7,15,15);
        Stroke stroke = new BasicStroke(3.0F);
        gt.setStroke(stroke);
        gt.drawLine(this.getDx(),this.getDy(),x+15,y+15);
    }

    public Color getColor(){
        return color;
    }
    public void setColor(Color color){
        this.color=color;
    }


    public void setAngle(double a){
        angle+=a;
        angle%=360;
        int centx=x+15;
        int centy=y+15;
        int length=20;
        dix=centx+(int)(length*sin(PI*angle/180));
        diy=centy+(int)(length*cos(PI*angle/180));
    }

    public void setX(int x){
        this.x+=x;
        if(this.x<=0)this.x=0;
        if(this.x>=770)this.x=770;
        setAngle(0);
    }

    public void setY(int y){
        this.y+=y;
        if(this.y<=0)this.y=0;
        if(this.y>=570)this.y=570;
        setAngle(0);
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public int getDx(){
        return dix;
    }
    public int getDy(){
        return diy;
    }

}

class Hero extends Tank{
    public Hero(int x,int y,Color color){
        super(x,y,color);
    }

}

class Enemy extends Tank{
    public Enemy(int x,int y,Color color){
        super(x,y,color);
    }
}
