import java.util.*;
import java.io.BufferedInputStream;
import java.math.*;
import static java.lang.Math.*;
public class Main{
	public static void main(String[]args){
		A320 a=new A320();
		a.solve();
	}
}

class A96{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	public void solve(){
		while(input.hasNext()){
			String s=input.next();
			s=s.replaceAll("0000000","*");
			s=s.replaceAll("1111111","*");
			if(s.contains("*"))System.out.println("YES");
			else System.out.println("NO");
		}
	}
}

class A112{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	public void solve(){
		String a=input.nextLine();
		String b=input.nextLine();
		if(a.compareToIgnoreCase(b)<0)System.out.println(-1);
		else if(a.compareToIgnoreCase(b)==0)System.out.println(0);
		else System.out.println(1);
	}
}

class A339{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	public void solve(){
		int []a=new int[1000];
		String s=input.nextLine();
		int t=0;
		for(int i=0;i<s.length();i++){
			if(Character.isDigit(s.charAt(i))){
				a[t++]=s.charAt(i)-'0';
			}
		}
		Arrays.sort(a,0,t);
		for(int i=0;i<t-1;i++){
			System.out.print(a[i]+"+");
		}
		System.out.println(a[t-1]);
	}
}

class B508{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	public void solve(){
		StringBuilder s;
		s=new StringBuilder(input.nextLine());
		boolean ok=false;
		int n=s.length();
		int m=s.charAt(n-1)-'0';
		for(int i=0;i<n;i++){
			if(ok)break;
			int t=s.charAt(i)-'0';
			if(t%2==0&&t<m){
				Character tc=s.charAt(i);
				s.setCharAt(i,s.charAt(n-1));
				s.setCharAt(n-1,tc);
				ok=true;
			}
		}

		if(ok){
			System.out.println(s);
		}
		else {
			for(int i=n-2;i>=0;i--){
				int t=s.charAt(i)-'0';
				if(t%2==0){
					Character tc=s.charAt(i);
					s.setCharAt(i,s.charAt(n-1));
					s.setCharAt(n-1,tc);
					ok=true;
					break;
				}
			}
			if(ok)System.out.println(s);
			else System.out.println(-1);
		}
	}
}

class A352{
	Scanner input=new Scanner(new BufferedInputStream(System.in));
	public void solve(){
		int n=input.nextInt();
		int t,t5=0,t0=0;
		for(int i=0;i<n;i++){
			t=input.nextInt();
			if(t==5)t5++;
			if(t==0)t0++;
		}
		if(t0==0)System.out.println(-1);
		else if(t5>=9){
			int tt=t5/9;
			while(tt-->0)
				for(int i=0;i<9;i++)System.out.print(5);
			for(int i=0;i<t0;i++)System.out.print(0);
			System.out.println();
		}
		else System.out.println(0);
	}
}

class A629{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private int [][]a=new int[105][105];
	private String []s=new String[105];

	public void solve(){
		int n=input.nextInt();
		input.nextLine();
		for(int i=0;i<n;i++){
			s[i]=input.nextLine();
			Arrays.fill(a[i],0);
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(s[i].charAt(j)=='C'){
					a[i][n]++;
					a[n][j]++;
				}
			}
		}
		int ans=0;
		for(int i=0;i<n;i++){
			ans+=a[i][n]*(a[i][n]-1)/2;
			ans+=a[n][i]*(a[n][i]-1)/2;
		}
		System.out.println(ans);
	}
}

class A320{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));

	public void solve(){
		String s=input.nextLine();
		s=s.replaceAll("[^14]","&");
		s=s.replaceAll("144","---");
		s=s.replaceAll("14","--");
		s=s.replaceAll("1","-");
		s=s.replaceAll("[-]","");
		if(s.length()==0)System.out.println("YES");
		else System.out.println("NO");
	}
}