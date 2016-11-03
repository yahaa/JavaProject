import java.util.*;
import static java.lang.Math.*;
public class JZM{
	public static void main(String[]args){
		Task a=new Task();
		a.solve();
	}
}

class Task{
	private Scanner input=new Scanner(System.in);
	private final int mx=1000;
	private int [][]dp=new int[mx][mx];
	private int [][]s=new int[mx][mx];
	private int []m=new int[mx+1];
	private int n;

	public void solve(){
		int tt=1;
		while(input.hasNext()){
			for(int i=0;i<=n;i++)dp[i][i]=0;
			n=input.nextInt();
			for(int i=0;i<=n;i++)m[i]=input.nextInt();
				for(int len=2;len<=n;len++){
				for(int i=1;i<=n-len+1;i++){
					int j=i+len-1;
					s[i][j]=i;
					dp[i][j]=dp[i+1][j]+m[i-1]*m[i]*m[j];
					for(int k=i+1;k<j;k++){
						int t=dp[i][k]+dp[k+1][j]+m[i-1]*m[k]*m[j];
						if(t<dp[i][j]){
							dp[i][j]=t;
							s[i][j]=k;
						}
					}
				}
			}
			System.out.println("Case "+tt++);
			System.out.println(dp[1][n]);
			track(1,n,s);
			System.out.println();
		}

	}

	private void track(int i,int j,int [][]s){
		if(i==j){
			System.out.print("A"+i);
			return;
		}
		if(i!=1||j!=n)System.out.print("(");
		track(i,s[i][j],s);
		track(s[i][j]+1,j,s);
		if(i!=1||j!=n)System.out.print(")");
	}
}

