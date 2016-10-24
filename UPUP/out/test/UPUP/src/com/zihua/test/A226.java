package com.zihua.test;
import java.util.*;
import static java.lang.Math.*;
/**
 * Created by zihua on 16-10-5.
 */

public class A226 {
    Scanner input=new Scanner(System.in);

    public int diff(String s,String ts){
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=ts.charAt(i))ans++;
        }
        return ans;
    }

    public void solve(){
        int n=input.nextInt();
        input.nextLine();
        String s=input.nextLine();
        String ts=get(n,1);
        String tts=get(n,0);
        int ans=min(diff(s,ts),diff(s,tts));
        System.out.println(ans);
    }

    private String get(int n,int t){
        StringBuilder s=new StringBuilder("");
        if(t==0){
            for(int i=0;i<n;i+=2) {
                s.append('B');
                s.append('R');
            }
        }
        else
            for(int i=0;i<n;i+=2){
                s.append('R');
                s.append('B');
            }
        return s.toString();
    }

    public static void main(String[]args){
        A226 a=new A226();
        a.solve();
    }


}
