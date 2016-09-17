import java.util.*;
public class Zuhe{
	private int [][]g=new int[3][3];
	private int [][]vi=new int[3][3];
	private int []ans=new int[10];
	private int []di={-2,-2,-1,-1,-1,-1,0,0,1,1,1,1,2,2};
	private int []dj={-1,1,-2,-1,0,1,2,-1,1,-2,-1,0,1,2,-1,1};
	private int tt=0;

	private void find(int x,int y,int len,int cur){
		if(x<0||x>=3||y<0||y>=3||vi[x][y]==1)return;
		if(cur==len){
			tt++;
			return;
		}
		vi[x][y]=1;
		for(int i=0;i<14;i++){
			int tx=x+di[i];
			int ty=y+dj[i];
			find(tx,ty,len,cur+1);
		}
	}
	public void solve(){
		for(int len=2;len<=9;len++){
			int tans=0;
			tt=0;
			find(0,0,len,0);
			tans+=4*tt;
			tt=0;
			find(0,1,len,0);
			tans+=tt;
			tt=0;
			find(1,1,len,0);
			tans+=4*tt;
			ans[len]=tans;
		}
	}
}