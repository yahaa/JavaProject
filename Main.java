import java.util.*;
import java.io.BufferedInputStream;
import static java.lang.Math.*;

public class Main{
	public static void main(String[]args){
		TZ a=new TZ();
		a.solve();
	}
}



class HDU1701{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	public void solve(){
		int t=input.nextInt();
		while(t-->0){
			double a=input.nextDouble();
			double b=input.nextDouble();
			for(int i=1;;i++){
				if((int)(a*i/100)<(int)(b*i/100)){
					System.out.println(i);
					break;
				}
			}
		}
	}

}

class HDU1702{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));

	public void solve(){
		int t=input.nextInt();
		input.nextLine();
		while(t-->0){
			int n=input.nextInt();
			String s=input.nextLine();

			if(s.equals(" FIFO")){
				Queue<Integer>qu=new LinkedList<Integer>();
				while(n-->0){
					String op=input.next();
					if(op.equals("IN")){
						int m=input.nextInt();
						qu.add(m);
					}
					else{
						if(!qu.isEmpty()){
							System.out.println(qu.poll());
						}
						else System.out.println("None");
					}
				}
			}
			else {
				Stack<Integer>sta=new Stack<Integer>();
				while(n-->0){
					String op=input.next();
					if(op.equals("IN")){
						int m=input.nextInt();
						sta.push(m);
					}
					else {
						if(!sta.isEmpty())System.out.println(sta.pop());
						else System.out.println("None");
					}
				}
			}
		}
	}

}

class HDU1703{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	
	public void solve(){
		while(input.hasNext()){
			int n=input.nextInt();
			if(n==0)break;
			if(n==1)System.out.println(0);
			else if(n==2)System.out.println(5);
			else if(n==3)System.out.println(15);
			else System.out.println((2*n-4)*5);
		}
	}
}


class Union{
	private int []an=new int[505];
	private Scanner input=new Scanner(new BufferedInputStream(System.in));

	public void solve(){
		int t=input.nextInt();
		while(t-->0){
			Arrays.fill(an,-1);
			int n=input.nextInt();
			int tn=n;
			int m=input.nextInt();
			while(m-->0){
				int a=input.nextInt();
				int b=input.nextInt();
				int pa=findp(a);
				int pb=findp(b);
				if(pa!=pb){
					n--;
					an[pa]+=an[pb];
					an[pb]=pa;
				}
			}

			int ans=tn*(tn-1)/2;
			for(int i=1;i<=tn;i++){
				if(an[i]<0){
					int tt=abs(an[i]);
					ans-=tt*(tt-1)/2;
				}
			}
			System.out.println(ans);
		}
	}

	private int findp(int a){
		int p=a;
		while(an[p]>=0){
			p=an[p];
		}
		return p;
	}
}

class HDU1704{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private int [][]g=new int[501][501];
	private int n,m;

	public void floyd(){
		for(int k=1;k<=n;k++){
			for(int i=1;i<=n;i++){
				if(g[i][k]==1){
					for(int j=1;j<=n;j++){
						if(g[k][j]==1)g[i][j]=1;
					}
				}
			}
		}
	}

	private int getAns(){
		int ans=0;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(i==j)continue;
				if(g[i][j]==0&&g[j][i]==0)ans++;
			}
		}
		return ans/2;
	}

	private void init(){
		n=input.nextInt();
		m=input.nextInt();
		for(int i=0;i<=n;i++)Arrays.fill(g[i],0);
	}

	public void solve(){
		int t=input.nextInt();
		while(t-->0){
			init();
			while(m-->0){
				int a=input.nextInt();
				int b=input.nextInt();
				g[a][b]=1;
			}
			floyd();
			System.out.println(getAns());
		}
		
	}
}


class HDU1705{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));

	public void solve(){
		while(true){
			int x1=input.nextInt();
			int y1=input.nextInt();
			int x2=input.nextInt();
			int y2=input.nextInt();
			int x3=input.nextInt();
			int y3=input.nextInt();
			if(x1==0&&x2==0&&x3==0&&y1==0&&y2==0&&y3==0)break;
			double s=abs((x2-x1)*(y3-y1)-(y2-y1)*(x3-x1));
			int all=gcd(abs(y2-y1),abs(x2-x1))+gcd(abs(y3-y2),abs(x3-x2))+gcd(abs(y3-y1),abs(x3-x1));
			System.out.println((int)((s-all+2)/2));
			
		}

	}

	public int gcd(int a,int b){
		if(b==0)return a;
		return gcd(b,a%b);
	}


}


class HDU1706{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private int [][]g;
	private int [][]a;
	private int n,m;
	private int maxn=Integer.MAX_VALUE;
	public void solve(){
		while(input.hasNext()){
			init();
			floyd();
			int ans=-1;
			int count=0;
			for(int i=1;i<=n;i++){
				for(int j=1;j<i;j++){
					if(g[i][j]==maxn)continue;
					if(g[i][j]>ans){
						ans=g[i][j];
						count=a[i][j];
					}
					else if(ans==g[i][j]){
						count+=a[i][j];
					}
				}
			}
			System.out.println(ans+" "+count);
			
		}
	}

	private void floyd(){
		for(int k=1;k<=n;k++){
			for(int i=1;i<=n;i++){
				if(g[i][k]>=maxn||i==k)continue;
				for(int j=1;j<=n;j++){
					if(g[k][j]>=maxn||i==j||j==k)continue;
					if(g[i][j]>g[i][k]+g[k][j]){
						g[i][j]=g[i][k]+g[k][j];
						a[i][j]=a[i][k]*a[k][j];
					}
					else if(g[i][j]==g[i][k]+g[k][j]){
						a[i][j]+=a[i][k]*a[k][j];
					}
				}
			
			}
		}
	}



	private void init(){
		n=input.nextInt();
		m=input.nextInt();
		g=new int[n+1][n+1];
		a=new int[n+1][n+1];
		for(int i=0;i<=n;i++){
			Arrays.fill(g[i],maxn);
			Arrays.fill(a[i],0);
		}

		int i,j,v;
		while(m-->0){
			i=input.nextInt();
			j=input.nextInt();
			v=input.nextInt();
			if(i==j)continue;
			if(g[i][j]>v){
				g[i][j]=g[j][i]=v;
				a[i][j]=a[j][i]=1;
			}
			else if(g[i][j]==v){
				a[i][j]++;
				a[j][i]++;
			}
		}

	}
}

class Cn{
	private int []a=new int[26];
	public Cn(){
		for(int i=0;i<26;i++)a[i]=0;
	}
	public void add(Cn f1,Cn f2){
		for(int i=0;i<26;i++){
			a[i]+=f1.a[i]+f2.a[i];
		}
	}
	public void init(String s){
		for(int i=0;i<s.length();i++){
			int index=(int)(s.charAt(i)-'a');
			a[index]++;
		}
	}

	public void print(){
		for(int i=0;i<26;i++){
			System.out.println((char)(i+'a')+":"+a[i]);
		}
	}
}


class HDU1708{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private Cn []a;
	public void solve(){
		int t=input.nextInt();
		input.nextLine();
		for(int j=0;j<t;j++){
			a=new Cn[51];
			String s=input.nextLine();
			String []ar=s.split(" ");
			a[0]=new Cn();
			a[1]=new Cn();
			a[0].init(ar[0]);
			a[1].init(ar[1]);
			int n=Integer.valueOf(ar[2]);
			for(int i=2;i<=n;i++){
				a[i]=new Cn();
				a[i].add(a[i-1],a[i-2]);
			}

			a[n].print();
			System.out.println();
		}
		
	}

}

class Student{
	private String name;
	private int [][]busy=new int[15][15];

	public Student(){
		name=null;
		for(int i=0;i<15;i++)
			Arrays.fill(busy[i],0);
	}

	public void setName(String name){
		this.name=name;
	}

	public void setBusy(int d,int s,int e){
		for(int i=s;i<=e;i++)busy[d][i]=1;
	}
	
	public boolean isBusy(int d,int s,int e){
		for(int i=s;i<=e;i++){
			if(busy[d][i]==1)return true; 
		}
		return false;
	}

	public String getName(){
		return name;
	}

}


class HDU1707{
	Student []stu=new Student[220];
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	public void solve(){
		int t=input.nextInt();
		while(t-->0){
			int n=input.nextInt();
			for(int i=1;i<=n;i++){
				String name=input.next();
				int k=input.nextInt();
				Student tm=new Student();
				while(k-->0){
					int d=input.nextInt();
					int s=input.nextInt();
					int e=input.nextInt();
					tm.setBusy(d,s,e);
				}
				tm.setName(name);
				stu[i]=tm;
			}

			int m=input.nextInt();
			while(m-->0){
				int d=input.nextInt();
				int s=input.nextInt();
				int e=input.nextInt();
				String []ans=new String[220];
				int c=0;
				for(int i=1;i<=n;i++){
					if(stu[i].isBusy(d,s,e)){
						ans[c++]=stu[i].getName();
					}
				}

				if(c>0){
					Arrays.sort(ans,0,c);
					for(int i=0;i<c-1;i++){
						System.out.print(ans[i]+" ");
					}
					System.out.println(ans[c-1]);
				}
				else System.out.println("None");

			}
		}
	}
}

class HDU1709{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private final int maxn=10000+5;
	private int []x;
	private int []dp=new int[maxn];
	private boolean []vist=new boolean[maxn];


	public void solve(){
		while(input.hasNext()){
			init();
			int n=input.nextInt();
			x=new int[n+1];
			int sum=0;
			for(int i=1;i<=n;i++){
				x[i]=input.nextInt();
				sum+=x[i];
			}

			for(int i=1;i<=n;i++){
				Arrays.fill(dp,0);
				for(int j=0;j<=sum;j++){
					if(vist[j]){
						dp[j+x[i]]=1;
						dp[abs(j-x[i])]=1;
					}
				}
				for(int j=0;j<=sum;j++){
					if(dp[j]==1)vist[j]=true;
				}
			}


			int ans=0;
			for(int i=1;i<=sum;i++){
				if(!vist[i])ans++;
			}

			System.out.println(ans);
			if(ans>0){
				int tt=0;
				for(int i=1;i<=sum;i++){
					if(!vist[i]){
						if(tt++==0)System.out.print(i);
						else System.out.print(" "+i);
					}
				}
				System.out.println();
			}

		}
	}

	public void init(){
		Arrays.fill(vist,false);
		vist[0]=true;
	}
}


class HDU1710{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private int n;
	private int []pre;
	private int []ins;
	private Queue<Integer>ans;
	

	private void init(){
		pre=new int[n];
		ins=new int[n];
		ans=new LinkedList<Integer>();
	}

	private void build(int a,int b,int n){
		if(n<1)return;
		int i;
		for(i=0;pre[a]!=ins[b+i];i++);
		build(a+1,b,i);
		build(a+i+1,b+i+1,n-i-1);
		ans.add(pre[a]);

	}

	public void solve(){
		while(input.hasNext()){
			n=input.nextInt();
			init();
			for(int i=0;i<n;i++)pre[i]=input.nextInt();
			for(int i=0;i<n;i++)ins[i]=input.nextInt();
			build(0,0,n);
			System.out.print(ans.poll());
			while(!ans.isEmpty())System.out.print(" "+ans.poll());
			System.out.println();
		}
	}

}

class TZ{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private int n;
	private int []pos;
	private int []ins;
	private Queue<Integer>ans;
	

	private void init(){
		pos=new int[n];
		ins=new int[n];
		ans=new LinkedList<Integer>();
	}

	private void build(int a,int b,int n){
		if(n==1){
			ans.add(pos[a]);
			return;
		}
		if(n<=0)return;
		int i;
		for(i=0;pos[a]!=ins[b+i];i++);
		build(a-n+i,b,i);
		build(a-1,b+i+1,n-i-1);
		

	}

	public void solve(){
		while(input.hasNext()){
			n=input.nextInt();
			init();
			for(int i=0;i<n;i++)pos[i]=input.nextInt();
			for(int i=0;i<n;i++)ins[i]=input.nextInt();
			build(n-1,0,n);
			System.out.print(ans.poll());
			while(!ans.isEmpty())System.out.print(" "+ans.poll());
			System.out.println();
		}
	}
}