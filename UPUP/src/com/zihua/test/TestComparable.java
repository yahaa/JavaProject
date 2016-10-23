package com.zihua.test;

/**
 * Created by zihua on 16-10-19.
 */
public class TestComparable {
    public static void main(String[]args){

    }
}

class FF implements Comparable<FF>{
    Integer a=100;

    public int compareTo(FF a){
        return -1;
    }
    @Override
    public String toString(){
        return "jjj";
    }

}
