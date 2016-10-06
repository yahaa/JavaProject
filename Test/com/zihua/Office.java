package com.zihua;
import java.util.*;
public class Office{
	public static void main(String[]args){
		try{
			
			Class t=Class.forName("com.zihua."+args[0]);
			OfficeUable use=(OfficeUable)t.newInstance();
			use.start();
		}
		catch(Exception e){
			System.out.println("can't finds");
		}
	}
}