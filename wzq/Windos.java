import java.awt.*;
import javax.swing.*;
public class Windos{
	public static void main(String[]args){
		Show a=new Show();
	}
}

class Show{
	private Frame f=new Frame("Hello !");
	private Panel gameP=new Panel();
	private Panel selectP=new Panel();

	public Show(){
		f.add(gameP);
		f.add(selectP,BorderLayout.SOUTH);
		f.setVisible(true);
	}

}

