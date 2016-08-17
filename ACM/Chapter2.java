
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
	private int max=33000;
	int []a=new int[max];

	public void init(){
		Arrays.fill(a,1);
		for(int i=2;i<max;i++){
				if(a[i]==1){
					for(int j=i+i;j<n;j+=i){
						a[j]=0;
					}
				}
			}
	}

	public void solve(){
		int t=input.nextInt();
		init();
		while(t-->0){
			int n=input.nextInt();
			int ans=0;
			int b[]=new int[n];
			Arrays.fill(b,0);
			for(int i=2;i<=n;i++){
				if(a[i]==1 && n%a[i]==0){
					int t=i;
					while(t<=n){
						b[t]=1;
						t+=i;
					}
				}
				else ans++;
			}
			
			System.out.println(ans);
		}
		
	}
}


