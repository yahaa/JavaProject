import java.util.*;
import java.io.BufferedInputStream;
import static java.lang.Math.*;


public class Tiaoma{
	public static void main(String[]args){
		Task a=new Task();
		a.solve();
		
	}
}

class Task{
	private int [][]map=new int[8][8];
	private int [][]vist=new int[8][8];
	private int [][]dis=new int[8][8];
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private int []di={-2,-2,-1,-1,1,1,2,2};
	private int []dj={-1,1,-2,2,-2,2,-1,1};
	private int mx=Integer.MAX_VALUE;
	private Map<Character,Integer>index=new TreeMap<Character,Integer>();

	public Task(){
		int a=97;
		int b=49;
		for(int i=0;i<8;i++){
			index.put((char)(a+i),i);
			index.put((char)(b+i),i);
		}
		
	}


	private void init(){
		for(int i=0;i<8;i++){
			Arrays.fill(vist[i],0);
		}
		mx=Integer.MAX_VALUE;
	}
	public void solve(){
		while(input.hasNext()){
			init();
			String s1=input.next();
			String s2=input.next();
			
			int x1=index.get(s1.charAt(1));
			int x2=index.get(s2.charAt(1));
			int y1=index.get(s1.charAt(0));
			int y2=index.get(s2.charAt(0));
			
			
			vist[x1][y1]=1;
			for(int i=0;i<8;i++){
				int tx=x1+di[i];
				int ty=y1+dj[i];
				dfs(x2,y2,tx,ty,1);
			}
			System.out.print(s1+"==>"+s2+": ");
			System.out.println(mx+" moves");
			// System.out.println(bfs(x2,y2,x1,y1)+" moves");
			
		}

	}

	

	private void dfs(int aimx,int aimy,int x,int y,int step){
		if(!can(x,y))return;
		if(step>mx)return;
		if(x==aimx&&y==aimy){
			mx=min(mx,step);
			return;
		}
		vist[x][y]=1;
		for(int i=0;i<8;i++){
			int tx=x+di[i];
			int ty=y+dj[i];
			dfs(aimx,aimy,tx,ty,step+1);
		}
		vist[x][y]=0;
	}

	private int bfs(int aimx,int aimy,int x,int y){
		for(int i=0;i<8;i++){
			Arrays.fill(dis[i],0);
			Arrays.fill(vist[i],0);
		}
		Queue<Point>qu=new LinkedList<Point>();
		qu.offer(new Point(x,y));
		vist[x][y]=1;
		while(!qu.isEmpty()){
			Point t=qu.poll();
			for(int i=0;i<8;i++){
				int tx=t.x+di[i];
				int ty=t.y+dj[i];
				if(can(tx,ty)){
					dis[tx][ty]=dis[t.x][t.y]+1;
					qu.offer(new Point(tx,ty));
					vist[tx][ty]=1;
				}
			}
		}

		return dis[aimx][aimy];
	}

	private boolean can(int x,int y){
		if(x<0||x>=8||y<0||y>=8||vist[x][y]==1)return false;
		return true;
	}
}

class Point{
	public int x, y;
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
}