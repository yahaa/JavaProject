import java.util.*;
public class EnumTest{
	public static void main(String[]args){
		for(Season s:Season.values()){
			System.out.println(s);
		}
		Gender g=Enum.valueOf(Gender.class,"FEMALE");
		System.out.println(g.getName());
	}
}

enum Season{
	SPRING,SUMMER,FALL,WINTER;
}

enum Gender{
	MALE("nan"),FEMALE("nv");
	private final String name;
	private Gender(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
}

