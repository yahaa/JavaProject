package com.zihua;
import java.util.*;

public class Excel implements OfficeUable{
	String name="excle";
	Date time=new Date();
	public void start(){
		try{
			for(int i=0;i<10;i++){
				Thread.sleep(500);
				System.out.print("......");
			}
		}
		catch(Exception e){
			System.out.println("xxxxx");
		}
		System.out.println(name+" "+time);
	}
}