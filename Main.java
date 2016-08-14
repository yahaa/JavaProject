import java.util.*;
import java.io.BufferedInputStream;
import java.math.*;
import static java.lang.Math.*;

public class Main{
	public static void main(String[]args){
		A a=new A();
		a.solve();
	
	}
}

class A{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private BigInteger x=new BigInteger("10001");
	
	public void solve(){
		int t=1;
		while(input.hasNext()){
			String s=input.nextLine();
			if(s.length()<=4){
				if(s.compareTo("0")==0)System.out.printf("Case #%d: YES\n",t++);
				else System.out.printf("Case #%d: NO\n",t++);
				continue;
			}
			boolean ans=false;
			for(int i=5;i<=s.length();i++){
				BigInteger n=new BigInteger(s.substring(0,i));
				if(n.mod(x)==BigInteger.ZERO){
					ans=true;
					break;
				}
			}
			if(ans)System.out.printf("Case #%d: YES\n",t++);
			else System.out.printf("Case #%d: NO\n",t++);

		}
	}
}