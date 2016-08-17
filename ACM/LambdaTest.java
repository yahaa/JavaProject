import java.util.*;
public class LambdaTest{
	public static void main(String[]args){
		TTT a=new TTT();
		a.test1(()->System.out.println("hahahaha"));
		Ea ff=()->System.out.println("jklasjdklfasd");
		ff.eat();
		String ya="1111";
		a.test2(String->System.out.println(String));
	}
}

interface Ea{
	void eat();
}

interface Fa{
	void fly(String sss);
}

class TTT{
	public void test1(Ea a){
		a.eat();
	}

	public void test2(Fa b){
		b.fly("uuuuuu");
	}

}