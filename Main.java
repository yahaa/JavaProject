import java.util.*;
import java.io.BufferedInputStream;
import java.math.*;
import static java.lang.Math.*;

public class Main{
	public static void main(String[]args){
		HDU1720 a=new HDU1720();
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

class HDU1720{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private TreeMap<Character,BigInteger>mp=new TreeMap<Character,BigInteger>();

	private void init(){
		for(int i=0;i<=9;i++){
			mp.put((char)(i+'0'),BigInteger.valueOf(i));
		}
		for(int i=0;i<=5;i++){
			mp.put((char)('a'+i),BigInteger.valueOf(10+i));
		}
		
	}

	public void solve(){
		init();
		while(input.hasNext()){
			String x=input.next();
			String y=input.next();
			x=x.toLowerCase();
			y=y.toLowerCase();
			BigInteger a=BigInteger.ZERO;
			BigInteger b=BigInteger.ZERO;
			BigInteger t16=new BigInteger("16");
			BigInteger t1=new BigInteger("1");
			for(int i=x.length()-1;i>=0;i--){
				a=a.add(mp.get(x.charAt(i)).multiply(t1));
				t1=t1.multiply(t16);
			}

			BigInteger t2=new BigInteger("1");
			for(int i=y.length()-1;i>=0;i--){
				b=b.add(mp.get(y.charAt(i)).multiply(t2));
				t2=t2.multiply(t16);
			}

			System.out.println(a.add(b));

		}
	}
}