import java.util.*;
import java.io.BufferedInputStream;
import static java.lang.Math.*;
public class LongCom{
	public static void main(String[]args){
		Task a=new Task();
		a.solve();
	}
}

class Task{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private int mx=5000;
	private int [][]dp=new int[mx][mx];
	private int [][]s=new int[mx][mx];
	private int t,n,m;
	public void solve(){
		t=input.nextInt();
		int ca=1;
		while(t-->0){
			n=input.nextInt();
			m=input.nextInt();
			input.nextLine();
			String s1=input.nextLine();
			String s2=input.nextLine();
			s1=" "+s1.replaceAll("[ ]+","");
			s2=" "+s2.replaceAll("[ ]+","");

			fundp(s1,s2);
			System.out.println("Case "+ca++);
			System.out.println(dp[n][m]);
			lcs(n,m,s1,s);
		}
		
	}

	private void lcs(int i,int j,String str,int [][]b){
		if(i==0||j==0)return;
		if(b[i][j]==1){
			lcs(i-1,j-1,str,b);
			System.out.print(str.charAt(i));
		}
		else if(b[i][j]==2){
			lcs(i-1,j,str,b);
		}
		else lcs(i,j-1,str,b);
	}

	private void fundp(String s1,String s2){
	
		System.out.println(s1);
		int len1=s1.length()-1;
		int len2=s2.length()-1;
		for(int i=1;i<=len1;i++)dp[i][0]=0;
		for(int j=1;j<=len2;j++)dp[0][j]=0;

		for(int i=1;i<=len1;i++){
			for(int j=1;j<=len2;j++){
				if(s1.charAt(i)==s2.charAt(j)){
					dp[i][j]=dp[i-1][j-1]+1;
					s[i][j]=1;

				}
				else if(dp[i-1][j]>=dp[i][j-1]){
					dp[i][j]=dp[i-1][j];
					s[i][j]=2;
				}
				else {
					dp[i][j]=dp[i][j-1];
					s[i][j]=3;
				}
			}
		}
	}
}