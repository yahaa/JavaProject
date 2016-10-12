import java.util.*;
import static java.lang.Math.*;
import java.io.BufferedInputStream;

public class QianB{
	public static void main(String[]args){
		Task a=new Task();
		a.solve();
	}
}

class Task{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));

	public void solve(){
		while(input.hasNext()){
			int n=input.nextInt();
			if(n==0)break;
			int ans=0;
			int tn=n;
			while(n>1){
				int t=n/3;
				t+=(n%3>0)?1:0;
				n=t;
				ans++;
			}
			System.out.println(tn);
			System.out.println("Iimes:"+ans);
		}
	}
}