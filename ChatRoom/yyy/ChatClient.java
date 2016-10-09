
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class ChatClient {
	//ע���û�����
	private JDialog jd = new JDialog();
	private JPanel buttonsPanel = new JPanel();
	private JLabel jb = new JLabel("�������ǳƣ�");
	private JTextField username = new JTextField(15);
	private JButton jok = new JButton("ȷ��");
	private JButton jcancl = new JButton("ȡ��");
	
	//����������
	private JFrame jf = new JFrame("");
	private JPanel jp = new JPanel();
	private JPanel jp2 = new JPanel();
	private JLabel user = new JLabel();
	private JLabel jlabel = new JLabel("��");
	private JComboBox otherUser = new JComboBox();
	private JLabel jlabel2 =new JLabel("˵��");
	private JTextField sendMessage = new JTextField(25);
	private JButton send = new JButton("����");
	private JLabel jlabel3 = new JLabel("�����û��б�");
	private Box box = Box.createVerticalBox();
	private JTextArea showMessage = new JTextArea(40,20);
	
	//��ǰ�û�����
	private String workstr;
	private String systemstr;
	private Socket s = null;
	private DataOutputStream dos = null;
	private DataInputStream dis = null;
	private boolean bConnected = false;
	
	
	public static void main(String args[]) {
		ChatClient c = new ChatClient();
	}
	
	
	public ChatClient(){
		lunachLogin();
	}
 
	//��½�Ի���
	public void lunachLogin(){
		jd.setTitle("����");
		jd.setResizable(false);
		jd.setLocation(200, 300);
		Container jDialogContentPane = jd.getContentPane();
		jDialogContentPane.add(buttonsPanel, BorderLayout.SOUTH);
		jDialogContentPane.add(jb, BorderLayout.NORTH);
		jDialogContentPane.add(username, BorderLayout.CENTER);
		buttonsPanel.add(jok);
		buttonsPanel.add(jcancl);
		jd.pack();
		jd.setVisible(true);
		connect();
  
		jok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(username.getText().equals("")){
				}
				else{
					String str = "L" + username.getText().trim();// trimȥ�����߿ո�
					user = new JLabel(username.getText().trim());
					try {
						dos.writeUTF(str);
						dos.flush();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					jd.setVisible(false);
					lunachWork();
				}
			}
		});
  
		jcancl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
			}
		});
	}
	
	
	//��½����ʾ����
	public void lunachWork(){
		jf.setLocation(400, 300);
		jf.setSize(600,300);
		Container jFramecontentPane = jf.getContentPane();
		showMessage.setEditable(false);
		JScrollPane js = new JScrollPane(showMessage);
		jp.add(user);
		jp.add(jlabel);
		jp.add(otherUser);
		jp.add(jlabel2);
		jp.add(sendMessage);
		jp.add(send);
		jp2.setLayout(new BorderLayout());
		jp2.add(jlabel3,BorderLayout.NORTH);
		jp2.add(box,BorderLayout.CENTER);
		jf.add(js,BorderLayout.CENTER);
		jf.add(jp,BorderLayout.SOUTH);
		jf.add(jp2,BorderLayout.EAST);
		jf.setVisible(true);
  
		jf.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				String str = "S" + username.getText().trim();
				try {
					dos.writeUTF(str);
					dos.flush();
   
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
				disconnect();
			}
		});
  
		jf.addComponentListener(new ComponentAdapter(){
			public void componentResized(ComponentEvent e) {
				int width = e.getComponent().getWidth();
				int height = e.getComponent().getHeight();
				if (width < 500)width = 500;
				if (height < 200)height = 200;
				jf.setSize(width, height);
			}
		});
	
  
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sendMessage.getText().equals("")){}
				else{
					String str = "W" + username.getText().trim()+" ˵ -----> "+sendMessage.getText().trim();
					sendMessage.setText("");
					try {
						dos.writeUTF(str);
						dos.flush();
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
  		new Thread(new ReceiveThread()).start();
	}
 
	//���ӷ�����
	public void connect(){
		try {
			s= new Socket("115.29.146.79",8888);
			dos =new DataOutputStream(s.getOutputStream());
			dis =new DataInputStream(s.getInputStream());
			System.out.println("���ӷ������ɹ���");
			bConnected=true;
		} 
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//��������Ͽ�
	public void disconnect(){
		try {
			dis.close();
			dos.close();
			s.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	class ReceiveThread implements Runnable{
		public void run() {
			try{
				while(bConnected){
					String str = dis.readUTF();
					if(str.charAt(0) == 'W'){
						workstr = str.substring(1);
						showMessage.setText(showMessage.getText()+workstr+'\n');
					}
					else if(str.charAt(0) == 'R'){
						box.removeAll();
						otherUser.removeAllItems();
						jf.setVisible(false);
						workstr = str.substring(1);
						showMessage.setText(showMessage.getText()+workstr+'\n');
					}
					else{ 
						systemstr = str.substring(1);
						JButton jb = new JButton(systemstr);
						box.add(jb);
						otherUser.addItem(systemstr);
						jf.setVisible(true);
					}
				}
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	
	
}