package com.zihua.test;
import java.io.BufferedInputStream;
import java.util.*;
import static java.lang.Character.*;
/**
 * Created by zihua on 16-10-9.
 */
public class A58 {
    private Scanner input=new Scanner(new BufferedInputStream(System.in));

    public void solve(){
        String s=input.nextLine();
        s=s.replaceAll("[^hello]","");
        s=s.replaceAll("hh+","h");
        s=s.replaceAll("ee+","e");
        s=s.replaceAll("lll+","ll");
        s=s.replaceAll("oo+","o");
        String tt="hello";

    }

    public static void main(String[]args){
        A58 a=new A58();
        a.solve();
    }
}
