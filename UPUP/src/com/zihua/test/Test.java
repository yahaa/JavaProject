package com.zihua.test;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import static java.lang.Math.*;

/**
 * Created by zihua on 16-9-29.
 */
public class Test {
    public static void main(String[]args){
       B427 a=new B427();
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

class B427{
    private Scanner input =new Scanner(new BufferedInputStream(System.in));
    private Integer []a;
    public void solve(){
        int n=input.nextInt();
        int k=input.nextInt();
        a=new Integer[n];
        for(int i=0;i<n;i++)a[i]=input.nextInt();
       Comparator<Integer> cmp=(x, y)->(x<y)?1:((x==y)?0:-1);
        Arrays.sort(a);
        int ans=0;
        for(int i=n-1;i>=0;i-=k){
            ans+=a[i]*2-2;
        }
        System.out.println(ans);
    }
}

