import java.io.BufferedInputStream;
import java.util.Scanner;
import static java.lang.Math.*;

/**
 * Created by zihua on 16-9-29.
 */
public class Test {
    public static void main(String[]args){
       A116 a=new A116();
        a.solve();
    }
}

class A116{
    private Scanner input=new Scanner(new BufferedInputStream(System.in));
    public void solve(){
        long ans=0;
        int n=input.nextInt();
        int a,b;
        int sum=0;
        for(int i=1;i<=n;i++){
            a=input.nextInt();
            b=input.nextInt();
            sum=sum-a+b;
            ans=max(sum,ans);
        }
        System.out.println(ans);
    }

}

