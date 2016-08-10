import java.util.*;
import java.io.BufferedInputStream;
import static java.lang.Math.*;

public class Main{
	public static void main(String[]args){
		HDU1705 a=new HDU1705();
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
