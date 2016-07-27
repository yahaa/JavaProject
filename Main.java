import java.util.*;
import java.io.BufferedInputStream;
import java.util.TreeMap;
import java.util.TreeSet;
public class Main{
	public Scanner input=new Scanner(new BufferedInputStream(System.in));
	public static void main(String[]args){
		HUD5761 a=new HUD5761();
		a.solve();

	}
}

class POJ3061{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	public void solve(){
		int t=input.nextInt();
		while(t-->0){
			int n=input.nextInt();
			int s=input.nextInt();
			int []a=new int[n];
			for(int i=0;i<n;i++)a[i]=input.nextInt();
			int ans=n+1;
			int sum=0;
			int j=0,i=0;
			while(j<n){
				while(j<n&&sum<s){
					sum+=a[j++];
				}
				
				while(sum>=s){
					ans=Math.min(ans,j-i);
					sum-=a[i++];
				}
			}
	
			System.out.println((ans==n+1)?0:ans);
		}
	}
	
}

class POJ3320{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));

	public void solve(){
		int n=input.nextInt();
		TreeMap<Integer,Integer>kind=new TreeMap<Integer,Integer>();
		TreeMap<Integer,Integer>used=new TreeMap<Integer,Integer>();
		int []a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=input.nextInt();
			kind.put(a[i],1);
		}

		int total=kind.size();
		int i=0;
		int j=0;
		int ans=n;
		while(j<n){
			while(used.size()<total&&j<n){
				int value=1;
				if(used.containsKey(a[j]))value=used.get(a[j])+1;
				used.put(a[j++],value);
			}

			while(used.size()>=total){
				ans=Math.min(ans,j-i);
				if(used.get(a[i])==1){
					used.remove(a[i++]);
				}
				else {
					int value=used.get(a[i]);
					value--;
					used.put(a[i++],value);
				}

			}
		}
		System.out.println(ans);

	}
}


class CF23C{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));

	public void solve(){
		while(input.hasNext()){
			int n=input.nextInt();
			input.nextLine();
			String s=input.nextLine();
			TreeSet<Character>kind=new TreeSet<Character>();
			TreeMap<Character,Integer>used=new TreeMap<Character,Integer>();
			for(int i=0;i<s.length();i++){
				kind.add(s.charAt(i));
			}

			int total=kind.size();
			int i=0;
			int j=0;
			int ans=s.length();
			while(j<s.length()){
				while(used.size()<total&&j<s.length()){
					int value=1;
					if(used.containsKey(s.charAt(j)))value=used.get(s.charAt(j))+1;
					used.put(s.charAt(j),value);
					j++;
				}

				while(used.size()>=total){
					ans=Math.min(ans,j-i);
					if(used.get(s.charAt(i))==1)used.remove(s.charAt(i));
					else {
						int value=used.get(s.charAt(i));
						value--;
						used.put(s.charAt(i),value);
					}
					i++;
				}
			}

			System.out.println(ans);

		}

	}
}

class POJ2100{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));

	public void solve(){
		while(input.hasNext()){
			TreeMap<Long,Long>m=new TreeMap<Long,Long>();
			long sum=input.nextLong();
			long n=(long)Math.sqrt((double)sum)+1;
			long s=0;
			long i=1;
			long j=1;
			int ans=0;
			while(j<n){
				while(j<n&&s<sum){
					s+=j*j;
					j++;
				}
				while(s>=sum){
					if(s==sum){
						ans++;
						m.put(i,j);
					}
					s-=i*i;
					i++;
				}
			}

			System.out.println(ans);
			Set<Map.Entry<Long,Long>>entrys=m.entrySet();
			for(Map.Entry<Long,Long>it:entrys){
				long ii=it.getKey();
				long jj=it.getValue();
				System.out.print(jj-ii+" ");
				for(long k=ii;k<jj;k++){
					if(k!=jj-1)System.out.print(k+" ");
					else System.out.println(k);
				}
			}

		}
	}
}

class BC23A{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private long []a=new long[34];
	public void  solve(){
		for(int i=0;i<=33;i++)a[i]=(long)Math.pow(2,i);
		int t=input.nextInt();
		while(t-->0){
			long n=input.nextLong();
			int m=input.nextInt();
			int ans=0;
			if(m>=32)m=32;
			for(int i=m;i>=0;i--){
				ans+=n/a[i];
				n%=a[i];
			}
			System.out.println(ans);
		}
	}
}


class BC23D{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	int max=100000000;
	private int []a=new int[max+1];
	public void solve(){
		Arrays.fill(a,1);
		int ans=0;
		for(int i=2;i<=max;i++){
			if(a[i]==1){
				ans++;
				for(int j=i+i;j<=max;j+=i){
					a[j]=0;
				}
			}
		}
		System.out.println(ans);

	}
}


class HDU1286{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));

	private int euler(int n){  	
    	int ans=1;  
    	int i;  
    	for(i=2;i*i<=n;i++){  
    	    if(n%i==0){  
    	        n/=i;  
    	        ans*=i-1;  
    	        while(n%i==0){  
    	            n/=i;  
    	            ans*=i;  
    	        }  
    	    }  
    	}  
    	if(n>1)ans*=n-1;  
    	return ans;  
	}

	public void solve(){
		int t=input.nextInt();
		while(t-->0){
			int n=input.nextInt();
			System.out.println(euler(n));
		}
	}  
}

class POJ3276{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private int n;
	private int []f;
	private int []dir;
	private TreeMap<String,Integer>tt=new TreeMap<String,Integer>();


	public void solve(){
		tt.put("B",1);
		tt.put("F",0);
		while(input.hasNext()){
			n=input.nextInt();
			input.nextLine();
			String s;
			init();
			for(int i=0;i<n;i++){
				s=input.next();
				dir[i]=tt.get(s);
			}

			int k=1;
			int m=n;
			for(int tk=1;tk<=n;tk++){
				int tm=calc(tk);
				if(tm>=0&&m>tm){
					m=tm;
					k=tk;
				}
			}
			System.out.println(k+" "+m);
		}
	}

	private void init(){
		f=new int[n];
		dir=new int[n];
	}

	private int calc(int k){
		Arrays.fill(f,0);
		int sum=0;
		int ans=0;
		for(int i=0;i+k<=n;i++){
			if((sum+dir[i])%2==1){
				ans++;
				f[i]=1;
			}
			sum+=f[i];
			if(i-k+1>=0)sum-=f[i-k+1];
		}

		for(int i=n-k+1;i<n;i++){
			if((sum+dir[i])%2==1)return -1;
			if(i-k+1>=0)sum-=f[i-k+1];
		}
		return ans;
	}
	
}


class HUD5761{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));

	public void solve(){
		while(input.hasNext()){
			double a,v1,v2;
			a=input.nextDouble();
			v1=input.nextDouble();
			v2=input.nextDouble();
			if(a==0)System.out.println("0.00000000\n");
			else if(v1<=v2)System.out.printf("Infinity\n");
			else System.out.printf("%.10f\n",v1*a/(v1*v1-v2*v2));
		}
	}
}
