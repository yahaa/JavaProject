package com.zihua.test;
import static java.lang.Character.*;

import java.io.BufferedInputStream;
import java.util.*;
/**
 * Created by zihua on 16-10-9.
 */
public class A281 {
    private Scanner input=new Scanner(new BufferedInputStream(System.in));

    public void solve(){
        String s=input.nextLine();
        Character tc=s.charAt(0);
        tc=toUpperCase(tc);
        s=s.substring(1);
        System.out.println(tc+s);
    }

    public static void main(String[]args){
        A281 a=new A281();
        a.solve();
    }
}
