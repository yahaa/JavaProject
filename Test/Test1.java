import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.FileDialog;
import javax.swing.*;
import java.util.LinkedList;
public class Test1{
	public static void main(String[]args)throws Exception{
		Hello a=new Hello();
	}
}

class Win{
	private Frame f;
	private Panel p;

	public Win(){

	}
	public Win(int x,int y){
		init(x,y);
	} 

	public void init(int x,int y){
		f=new Frame("hello world !");
		p=new Panel();
		f.add(p);
		setP();
		setF(x,y);
		
	}

	

	private void setF(int x,int y){
		f.setBounds(x,y,250,200);
		f.setVisible(true);
	}

	private void setP(){
		p.add(new TextField(20));
		p.add(new Button("click me"));
		
	}

}

class OpenFile{
	private Frame f=new Frame("yaaaaa");
	private FileDialog d1=new FileDialog(f,"find you file",FileDialog.LOAD);
	private FileDialog d2=new FileDialog(f,"save you file",FileDialog.SAVE);

	private Button b1=new Button("Open");
	private Button b2=new Button("SAVE");

	public OpenFile(){
		b1.addActionListener(e->{
			d1.setVisible(true);
			System.out.println(d1.getDirectory()+d1.getFile());

		});

		b2.addActionListener(e->{
			d2.setVisible(true);
			System.out.println(d2.getDirectory()+d2.getFile());
		});

		f.add(b1);
		f.add(b2,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}

}

class Hello{
	private Frame f=new Frame("test");
	private Button ok=new Button("ok");
	private TextField tf=new TextField(30);

	class OKL implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println(e);
			System.out.println("USER CLICK OK");
			tf.setText("HELLO WORLD");
		}
	}
	public Hello(){
		ok.addActionListener(e->{
			System.out.println("hahaha");
			tf.setText("JAKSLDJFLKASJDFKLJASDLKFJASLD;FJLASKJFLKASJFKL;ASJDFKLJASFJ;AS");
		}
		);
		f.add(tf);
		f.add(ok,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}


}


