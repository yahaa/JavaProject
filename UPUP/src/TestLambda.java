import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by zihua on 16-9-30.
 */
public class TestLambda {
    public static void main(String[]args){
        In1 a=(x,y)->x+y;
        System.out.println(a.getsum(10,13));
        In2 b=Integer::valueOf;
        System.out.println(b.getString("12345"));
        Test1 c=new Test1();
        c.solve();
    }
}

@FunctionalInterface
interface In1{
    int getsum(int a,int b);
}

@FunctionalInterface
interface In2{
    Integer getString(String s);
}

class Test1{
    Scanner input=new Scanner(new BufferedInputStream(System.in));
    private Integer []a=new Integer[10];
    public void solve(){
        for(int i=0;i<10;i++)a[i]=input.nextInt();
        Comparator<Integer> cmp=(x, y)->(x < y)?1:((x > y)?-1:0);
        Arrays.sort(a,cmp);
        for(int t:a)System.out.print(t+" ");
    }

}





