package com.zihua.test;

import java.io.BufferedInputStream;
import java.util.Scanner;
import static java.lang.Character.*;
import static java.lang.Math.*;
/**
 * Created by zihua on 16-10-9.
 */
public class A131 {
    private Scanner input=new Scanner(new BufferedInputStream(System.in));

    public void solve(){
        String s=input.nextLine();
        Character tc=s.charAt(0);
        boolean t1=isUpperCase(tc);
        boolean t2=true;
        for(int i=1;i<s.length();i++){
            tc=s.charAt(i);
            if(isLowerCase(tc))t2=false;
            if(!t2)break;
        }

        if(t2&&!t1){
            for(int i=0;i<s.length();i++){
                tc=s.charAt(i);
                if(i==0)System.out.print(toUpperCase(tc));
                else System.out.print(toLowerCase(tc));
            }
        }
        else if(t1&&t2){
            for(int i=0;i<s.length();i++){
                tc=s.charAt(i);
                System.out.print(toLowerCase(tc));
            }
        }
        else System.out.print(s);
        System.out.println();
    }

    public static void main(String[]args){
        A131 a=new A131();
        a.solve();
    }
}
