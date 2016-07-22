
import java.util.*;
import static java.lang.Math.*;
public class Chapter2{
	public static void main(String[]args){
		HDU1286 a=new HDU1286();
		a.solve();

	}
}

class NO_26{
	private Scanner input=new Scanner(System.in);

	public void solve(){
		while(input.hasNext()){
			String s=input.nextLine();
			s=s.replaceAll("[0\\.\\)]","");
			String []t=s.split("\\(");
			long a=Long.valueOf(t[0]);
			long b=Long.valueOf(t[1]);
			
			long x=a*((long)pow(10,t[1].length())-1)+b;
			long y=((long)pow(10,t[1].length())-1)*(long)pow(10,t[0].length());
			System.out.println(x);
			System.out.println(y);
			System.out.printf((x/gcd(x,y))+"/"+(y/gcd(x,y)));

		}
	}

	public long gcd(long a,long b){
		if(b==0)return a;
		return gcd(b,a%b);
	}
}

class HDU1286{
	private Scanner input=new Scanner(System.in);
	
	public void solve(){
		int t=input.nextInt();
		while(t-->0){
			int n=input.nextInt();
			int ans=0;
			for(int i=1;i<n;i++){
				if(gcd(i,n)==1)ans++;
			}
			System.out.println(ans);
		}
		
	}

	public long gcd(long a,long b){
		if(b==0)return a;
		return gcd(b,a%b);
	}
}


