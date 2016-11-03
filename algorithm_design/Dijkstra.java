import java.util.*;
import java.io.BufferedInputStream;
import static java.lang.Math.*;
public class Dijkstra{
	public static void main(String[]args){
		Task a=new Task();
		a.solve();
	}
}

class Task{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private final int mx=250;
	private final Integer inf=Integer.MAX_VALUE-1000;
	private int [][]m=new int[mx][mx];
	private boolean []vist=new boolean[mx];
	private int []dis=new int[mx];
	private int []pre=new int[mx];

	public void solve(){
		int cases=1;
		while(input.hasNext()){
			init();
			int n=input.nextInt();
			buildMap(n);
			int s=input.nextInt();
			int e=input.nextInt();
			dijkstra(s-1,n);
			System.out.println("Case "+cases++);
			System.out.println("The least distance fromd "+s+"->"+e+" is "+dis[e-1]);
			printp(n-1);
		}
	}

	private void buildMap(int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int t=input.nextInt();
				if(t>0)m[i][j]=t;
			}
		}
	}

	private void init(){
		for(int i=0;i<mx;i++){
			Arrays.fill(m[i],inf);
		}
	}

	private void printp(int p){
		int len=0;
		int []ans=new int[mx];
        while(p!=0){
            ans[len++] = p;
            p = pre[p];
		}
        System.out.print("the path is 1");
        for(int i=len-1;i>=0;i--){
        	System.out.print("->"+(ans[i]+1));
        }
        System.out.println();
            
	}

	private void dijkstra(int s,int n){
		for(int i=0;i<n;i++){
			vist[i]=false;
			dis[i]=inf;
			if(i!=s&&m[s][i]!=inf)pre[i]=s;
       		else pre[i]=-1;
		}
		dis[s]=0;
		for(int i=0; i<n;i++){
	        int x=0;
	        int min_dis=inf;
	        for (int j=0;j<n;j++){
	            if (!vist[j]&&dis[j]<=min_dis){
	                x=j;
	                min_dis=dis[j];
	            }
	        }
	        vist[x]=true;
	        if(min_dis==inf)break;
	        for (int j=0; j<n;j++){
	        	if(dis[j]>dis[x]+m[x][j]){
	        		pre[j]=x;
	        		dis[j]=dis[x]+m[x][j];
	        	}
	        }
    	}
    	
	}
}

