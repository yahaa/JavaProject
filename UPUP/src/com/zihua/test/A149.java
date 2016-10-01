package com.zihua.test;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by zihua on 16-9-30.
 */
public class A149 {
    private Scanner input=new Scanner(new BufferedInputStream(System.in));
    Integer []a=new Integer[12];
    public void solve(){
        int k=input.nextInt();
        for(int i=0;i<12;i++)a[i]=input.nextInt();
        Comparator<Integer>cmp=(x,y)->(x<y)?1:((x==y)?0:-1);
        Arrays.sort(a,cmp);
        int i=0,ans=0;
        while(k>0&&i<12){
            k-=a[i++];
            ans++;
        }
        if(k>0)ans=-1;
        System.out.println(ans);
    }
    public static void main(String[]args){
        A149 t=new A149();
        t.solve();
    }

}
