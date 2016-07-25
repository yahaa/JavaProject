import java.util.*;
public class LambdaTest{
	public static void main(String[]args){
		TTT a=new TTT();
		a.test1(()->System.out.println("hahahaha"));
		Ea ff=()->System.out.println("jklasjdklfasd");
		ff.eat();
		a.test2(()->System.out.println("jklajsd"));
	}
}

interface Ea{
	void eat();
}

interface Fa{
	void fly();
}

class TTT{
	public void test1(Ea a){
		a.eat();
	}

	public void test2(Fa b){
		b.fly();
	}

}