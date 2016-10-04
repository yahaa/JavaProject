
import java.awt.Color;  
import java.awt.Dimension;  
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Stack;

import javax.swing.JFrame;  
import javax.swing.JPanel;
public class BoardCover {

	public static void main(String []args){
		UI ui=new UI();
	}
}

class UI extends JFrame{
	private Graphics g;
	private MenuBar mb;
	private int n;
	public static boolean ok=true;
	private final int D=20;

	public UI(){
		init(5);
	}
	public  void init(int k){
		//基本参数
		n=1<<k;
		this.setTitle("棋盘覆盖");
		this.setSize(new Dimension(680,710));
		this.setResizable(false);
		this.setDefaultCloseOperation(3);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		//添加面板
		MyPanel pboard=new MyPanel(k,D);
		this.add(pboard);
		this.setVisible(true);
		this.setBackground(new  Color(0xb3,0xb3,0xb3));
		//添加菜单
		mb=new MenuBar();
		Menu op=new Menu("Operate");
		MenuItem start=new MenuItem("Start");
		MenuItem clear=new MenuItem("Clear");
		op.add(start);
		op.add(clear);
		mb.add(op);
	
		this.setMenuBar(mb);
		g=pboard.getGraphics();
		MouseAction lis=new MouseAction(pboard);
		pboard.addMouseListener(lis);
		MyAL ml=new MyAL(pboard);
		start.addActionListener(ml);
		clear.addActionListener(ml);
		
	}
}



class MyPanel extends JPanel{
	private int n;
	private int D=20;
	private int sx,sy;
	private Integer [][]map=new Integer[33][33];
	public MyPanel(){
		n=2;
		init();
	}
	
	public MyPanel(int k,int d){
		n=1<<k;
		D=d;
		init();
	}
	
	public void init(){
		this.setLayout(null);
		this.setBackground(new Color(0xF7,0xF7,0xF7));
		this.setBounds(0,0,n*D+40,n*D+40);
		for(int i=0;i<=32;i++)
			Arrays.fill(map[i],0);
		sx=1;
		sy=1;
	}
	
	public void setSXY(int x,int y){
		sx=x;
		sy=y;
	}
	
	public int getSX(){
		return sx;
	}
	
	public int getSY(){
		return sy;
	}
	
	public Integer getMap(int x,int y){
		return map[x][y];
	}
	public void setMap(int x,int y,int v){
		map[x][y]=v;
	}
	
	@Override
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		super.paint(g);
		for(int i=0;i<=n;i++){
			int x1=20+i*D;
			int y1=20;
			int x2=x1;
			int y2=y1+(n)*D;
			g.drawLine(x1, y1, x2, y2);
			x1=20;
			x2=20+(n)*D;
			y1=20+i*D;
			y2=y1;
			g.drawLine(x1, y1, x2, y2);
		}
	}
	
}


class MyAL implements ActionListener{
	private Color []colors=new Color[6];
	private MyPanel p;
	private Graphics g;
	int [][]dir= { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 0 } };
	int title = 0;
	Stack<Integer>sta=new Stack<Integer>();
	public MyAL(MyPanel p){
		this.p=p;
		while(!sta.isEmpty())sta.pop();
		g=p.getGraphics();
		initColor();
	}
	
	private void initColor(){
		colors[0]=new Color(0x0,0x0,0x0);
		colors[1]=new Color(0xD6,0xD6,0x08);
		colors[2]=new Color(0x71,0xF3,0x50);
		colors[3]=new Color(0xEE,0x11,0x11);
		colors[4]=new Color(0x49,0xC8,0xC8);
		colors[5]=new Color(209,167,78);
	}
	
	public void actionPerformed(ActionEvent e){
		String cmd=e.getActionCommand();
		if(cmd.equals("Start")){
			cover(0,0,p.getSX()-1,p.getSY()-1,32);
		}
		if(cmd.equals("Clear")){
			clear();
		}
			
    }
	
	public void clear(){
		UI.ok=true;
		g.clearRect(p.getSX()*20+2, p.getSY()*20+29, 17, 17);
		while(!sta.isEmpty()){
			int x=sta.pop();
			int y=x%10000;
			x=(x-y)/10000;
			g.clearRect(x*20+2, y*20+29, 17, 17);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		p.setSXY(1, 1);
	}
	
	
	
	private void setColor(int style, int r, int c) {
		title++;
		for (int i = 0; i < 4; i++)
			if (i == style) { 
				for (int j = 0; j < 4; j++)
					if (i != j){
						int x=r + dir[j][0]+1;
						int y=c + dir[j][1]+1;
						g.setColor(colors[i+1]);
						g.fillRect(x*20+2,y*20+29,20-3, 20-3);
						sta.push(x*10000+y);
						try {
							Thread.sleep(30);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
			}
	}

	private void cover(int startR, int startC, int dr, int dc, int size) {
		if (size == 1)return;
		int s = size / 2;
		int rr = (dr >= startR + s)?1:0;
		int cc = (dc >= startC + s)?1:0;
		for (int i = 0; i < 4; i++) {
			if (dir[i][0] == rr && dir[i][1] == cc) {
				setColor(i, startR + s - 1, startC + s - 1);

				for (int j = 0; j < 4; j++) {
					if (j == i)
						cover(startR + s * dir[j][0], startC + s * dir[j][1],dr, dc, s);
					else {
						cover(startR + s * dir[j][0], startC + s * dir[j][1],
							startR + s - 1 + dir[j][0],
							startC + s - 1 + dir[j][1], s);
					}
				}
			}
		}
	}

}


class MouseAction extends MouseAdapter {
	private Graphics g;
	private MyPanel p;
	private Color []colors=new Color[6];
	
	
	public MouseAction(MyPanel p){
		this.g=p.getGraphics();
		this.p=p;
		initColor();
	}
	
	private void initColor(){
		colors[0]=new Color(0x0,0x0,0x0);
		colors[1]=new Color(0xD6,0xD6,0x08);
		colors[2]=new Color(0x71,0xF3,0x50);
		colors[3]=new Color(0xEE,0x11,0x11);
		colors[4]=new Color(0x49,0xC8,0xC8);
		colors[5]=new Color(209,167,78);
	}
	
	public int correctXY(int x) {  
        x = x / 20;  
        return x;
    }  
	
	public void mouseClicked(MouseEvent e){
		if(UI.ok){
			UI.ok=false;
			int x=correctXY(e.getX());
			int y=correctXY(e.getY());
			p.setMap(x, y, -1);
			p.setSXY(x, y);
			g.setColor(colors[p.getMap(x, y)+1]);
			g.fillRect(x*20+2,y*20+29,17, 17);
		}
		
	}
	
}
