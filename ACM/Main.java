import java.util.*;
import java.io.BufferedInputStream;
import java.math.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Character.*;

public class Main{
	public static void main(String[]args){
		B456 a=new B456();
		a.solve();
	}
}

class IO{

	public static Scanner input=new Scanner(new BufferedInputStream(System.in));

	public static void println(Object o){
		System.out.println(o.toString());
	}

	public static void print(Object o){
		System.out.print(o.toString());
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

class A38{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));

	public void solve(){
		int n=input.nextInt();
		int []a=new int[105];
		for(int i=0;i<n-1;i++){
			a[i]=input.nextInt();
		}
		int s=input.nextInt();
		int b=input.nextInt();
		int ans=0;
		for(int i=s-1;i<b-1;i++){
			ans+=a[i];
		}
		System.out.println(ans);
	}
}

class A262{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));

	public void solve(){
		int n=input.nextInt();
		int k=input.nextInt();
		int ans=0;
		for(int i=0;i<n;i++){
			Integer a=input.nextInt();
			String s=a.toString();
			int t=0;
			for(int j=0;j<s.length();j++){
				if(s.charAt(j)=='4'||s.charAt(j)=='7')t++;
			}
			if(t<=k)ans++;
		}
		System.out.println(ans);
	}
}

class A525{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private int []key=new int[27];

	public void solve(){

		int ans=0;
		Arrays.fill(key,0);
		int n=input.nextInt();
		input.nextLine();
		String s=input.nextLine();
		for(int i=0;i<s.length();i++){
			if(isUpperCase(s.charAt(i))){
				int tk=s.charAt(i)-'A';
				if(key[tk]>0)key[tk]--;
				else ans++;
			}
			else if(isLowerCase(s.charAt(i))){
				int tk=s.charAt(i)-'a';
				key[tk]++;
			}
		}
		System.out.println(ans);

	}
}

class B545{
	
	public void solve(){
		
		String s1=IO.input.nextLine();
		String s2=IO.input.nextLine();
		StringBuilder s=new StringBuilder("");
		int same=0,dif=0,n=s1.length();
		int a=0,b=0;
		for(int i=0;i<n;i++){
			s.append(" ");
			if(s1.charAt(i)==s2.charAt(i)){
				same++;
				s.setCharAt(i,'1');
			}
			else {
				dif++;
				if(a<=b){
					if(s1.charAt(i)=='1')s.setCharAt(i,'0');
					else s.setCharAt(i,'1');
					a++;
				}
				else {
					if(s2.charAt(i)=='1')s.setCharAt(i,'0');
					else s.setCharAt(i,'1');
					b++;
				}
			}
		}

		if(dif%2==1)IO.println("impossible");
		else System.out.println(s);
	}
}

class A233{
	public void solve(){
		int n=IO.input.nextInt();
		if(n%2==1)IO.println(-1);
		else {
			for(int i=2;i<=n;i+=2){
				IO.print(i+" "+(i-1)+" ");
			}
		}
	}
}

class A463{
	public void solve(){
		int n=IO.input.nextInt();
		int k=IO.input.nextInt();
		k*=100;
		int ans=-1;
		boolean ok=false;
		for(int i=0;i<n;i++){
			int t=IO.input.nextInt();
			int s=IO.input.nextInt();
			t*=100;
			t+=s;
			if(k>=t){
				ok=true;
				ans=max(ans,(k-t)%100);
			}
		}
		if(ok)IO.println(ans);
		else IO.println(-1);
		
	}
}

class A488{
	public void solve(){
		Integer n;
		try{
			n=IO.input.nextInt();
			int ans=0;
			while(true){
				ans++;
				n++;
				String s=n.toString();
				if(s.contains("8"))break;
			}
			IO.println(ans);
		}catch(Exception e){
			IO.println("ERRO");
		}
		
		
	}
}

class B266{
	public void solve(){
		int n=IO.input.nextInt();
		int k=IO.input.nextInt();
		IO.input.nextLine();
		String s=IO.input.nextLine();
		while(k-->0){
			s=s.replaceAll("BG","GB");
		}
		IO.println(s);
	}
}

class B339{
	public void solve(){
		long n=IO.input.nextLong();
		long k=IO.input.nextLong();
		long ans=0,index=1,i;
		while(k-->0){
			i=IO.input.nextLong();
			if(i-index>=0)ans+=i-index;
			else ans+=i-index+n;
			index=i;
		}
		IO.println(ans);
	}
}

class B492{
	public void solve(){
		int n=IO.input.nextInt();
		int len=IO.input.nextInt();
		int []a=new int[1005];
		for(int i=0;i<n;i++){
			a[i]=IO.input.nextInt();
		}
		sort(a,0,n);
		double ans=-100000;
		for(int i=1;i<n;i++){
			ans=max(ans,1.0*(a[i]-a[i-1]));
		}
		ans/=2;
		double left=a[0]*1.0;
		double right=(len-a[n-1])*1.0;
		ans=max(ans,max(left,right));
		System.out.printf("%.10f\n",ans);
	}
}

class B268{
	public void solve(){
		long n=IO.input.nextLong();
		IO.println((5*n+n*n*n)/6);
	}
}

class B200{
	public void solve(){
		int n=IO.input.nextInt();
		int sum=0;
		for(int i=0;i<n;i++){
			sum+=IO.input.nextInt();
		}
		System.out.printf("%.10f\n",sum*1.0/n);
		
	}
}


class B519{
	public void solve(){
		Map<Integer,Integer>mp=new TreeMap<Integer,Integer>();
		Map<Integer,Integer>time=new TreeMap<Integer,Integer>();
		int n=IO.input.nextInt();

		for(int i=0;i<n;i++){
			Integer t=IO.input.nextInt();
			if(time.containsKey(t)){
				int v=time.get(t);
				v++;
				time.put(t,v);
			}
			else time.put(t,1);
		}

		for(int i=0;i<n-1;i++){
			Integer t=IO.input.nextInt();
			if(mp.containsKey(t)){
				int v=mp.get(t);
				v++;
				mp.put(t,v);
			}
			else mp.put(t,1);
		}
		
		int ans1=0;
		Set<Map.Entry<Integer,Integer> >entrySet=time.entrySet();

		for(Map.Entry<Integer,Integer>entry:entrySet){
			
			if(!mp.containsKey(entry.getKey())){
				ans1=entry.getKey();
				break;
			}
			if(mp.get(entry.getKey())<entry.getValue()){
				ans1=entry.getKey();
				break;
			}
		}

		time.clear();
		for(int i=0;i<n-2;i++){
			Integer t=IO.input.nextInt();
			if(time.containsKey(t)){
				int v=time.get(t);
				v++;
				time.put(t,v);
			}
			else time.put(t,1);
		}

		int ans2=0;
		entrySet=mp.entrySet();
		for(Map.Entry<Integer,Integer>entry:entrySet){
			if(!time.containsKey(entry.getKey())){
				ans2=entry.getKey();
				break;
			}
			if(time.get(entry.getKey())<entry.getValue()){
				ans2=entry.getKey();
				break;
			}
		}

		IO.println(ans1);
		IO.println(ans2);

	}
}


class RUU implements Runnable{
	public void run(){
		for(int i=0;i<100;i++)
			IO.println("hahaha");
	}
}

class B467{
	public void solve(){
		int n=IO.input.nextInt();
		int m=IO.input.nextInt();
		int k=IO.input.nextInt();
		int []a=new int[1005];
		for(int i=0;i<m+1;i++){
			a[i]=IO.input.nextInt();
		}
		int ans=0;
		for(int i=0;i<m;i++){
			if(oneOfAB(a[i],a[m])<=k)ans++;
		}
		IO.println(ans);
	}

	private int oneOfAB(int a,int b){
		int t=a^b,con=0;
		while(t>0){
			con++;
			t-=t&-t;
		}
		return con;
	}
}


class B459{
	public void solve(){
		int n=IO.input.nextInt();
		int mx=1;
		int mn=1000000000;
		Map<Integer,Integer>mp=new TreeMap<Integer,Integer>();
		for(int i=0;i<n;i++){
			int t=IO.input.nextInt();
			mx=max(mx,t);
			mn=min(mn,t);
			if(mp.containsKey(t)){
				int v=mp.get(t);
				v++;
				mp.put(t,v);
			}
			else mp.put(t,1);
		}
		long ans=0;
		if(mx==mn){
			int t=mp.get(mn);
			ans=(long)t*(t-1)/2;
		}
		else ans=(long)mp.get(mx)*mp.get(mn);
		IO.println((mx-mn)+" "+ans);
	}
}


class A278{
	public void solve(){
		int []a=new int[105];
		int n=IO.input.nextInt();
		a[1]=0;
		for(int i=2;i<n+2;i++){
			a[i]=a[i-1]+IO.input.nextInt();
		}
		int s=IO.input.nextInt();
		int t=IO.input.nextInt();
		int tt=max(s,t);
		int ss=min(s,t);
		int ans=min(a[tt]-a[ss],a[n+1]-a[tt]+a[ss]);
		IO.println(ans);
	}
}

class B538{
	public void solve() {
        int n=IO.input.nextInt();
        List<Integer> res=new ArrayList<>();
        while (n>0) {
            int cur=0;
            int tmp=n;
            int mul=1;
            while(tmp>0) {
                if(tmp%10>0)cur+=mul;
                tmp/=10;
                mul*=10;
            }
            n-=cur;
            res.add(cur);
        }
        IO.println(res.size());
        for (int i=0; i<res.size(); ++i) {
            if (i>0) IO.print(" ");
            System.out.print(res.get(i));
        }
        System.out.println();
    }
}

class B456{
	public void solve(){
		String s=IO.input.nextLine();
		int n=s.length();
		if(n>2){
			int t=s.charAt(n-1)-'0';
			int t1=s.charAt(n-2)-'0';
			t=t1*10+t;
		
			if(t%4==0)IO.println(4);
			else IO.println(0);
		}
		else {
			Integer a=Integer.valueOf(s);
			if(a%4==0)IO.println(4);
			else IO.println(0);
		}
		
		

	}
}

class C719{
	public void solve(){
		int n=IO.input.nextInt();
		int t=IO.input.nextInt();
		IO.input.next();
		StringBuilder s=IO.input.nextLine();
		int index=0;
		for(int i=0;i<n;i++){
			if(s.charAt(i)=='.'){
				index=i;
				break;
			}
		}
		for(int i=index+1;i<n;i++){
			if(s.charAt(i)>='5'){
				
			}
		}
	}
}