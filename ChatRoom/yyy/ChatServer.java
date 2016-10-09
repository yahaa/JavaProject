
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	List<Client> clients = new ArrayList<Client>();
	Client c = null;
	ArrayList<String> userList = new ArrayList<String>();
 
	public static void main(String[] args){
		new ChatServer().start();
	}
 
	public void start(){
		boolean started = false;
		ServerSocket ss = null;
		DataInputStream dis = null;
		//����������
		try{
			ss = new ServerSocket(8888);
			started = true;
			System.out.println("������������!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//serverSocket��ʼ����
		try{
			while(started){
				Socket s = ss.accept();
				c = new Client(s);
				System.out.println("��һ�ͻ��˵�½�ˣ�");
				new Thread(c).start();
				clients.add(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				ss.close();
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
	}
 
	class Client implements Runnable {
		private Socket s;
		private DataInputStream dis =null;
		private DataOutputStream dos=null;
		private boolean bConnected =false;
  
		public Client(Socket s){
			this.s=s;
			try {
				dis= new DataInputStream(s.getInputStream());
				dos =new DataOutputStream(s.getOutputStream());
				bConnected =true;
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
		
		//д������
		private void send(String str)throws Exception{
			dos.writeUTF(str);
		}
		
		//����
		private void login(String str) throws Exception{
			userList.add("X"+str.substring(1));
			String str1 = "R" + "��ϵͳ��Ϣ��-----> " + str.substring(1) + " �����ˣ�";
			//System.out.println(str1.substring(1));//����������ʾ
			sendToAll(str1);
			nowIn();
		}
		
		//����
		private void logout(String str) throws Exception{
			userList.remove("X"+str.substring(1));
			String str1 = "R" + "��ϵͳ��Ϣ��-----> " + str.substring(1) + " �����ˣ�";
			System.out.println(str1.substring(1));
			sendToAll(str1);
			nowIn();
					
		}
		
		//��������ʾ��ǰ��������
		private void nowIn()throws Exception{
			System.out.print("Ŀǰ�����û��� ");
			for(int j=0;j<userList.size();j++){
				String s = userList.get(j);
				System.out.print(s.substring(1)+" ");
				sendToAll(s);
			}
			System.out.println("��");
		}
		
		//֪ͨ���ߵ������� messge��Ϣ
		private void sendToAll(String messge)throws Exception{
			for(int i=0;i<clients.size();i++){
				c = clients.get(i);
				c.send(messge);
			}
			//System.out.println(messge.substring(1));
		}
		
		
		//����ע���Լ�
		private void closeClient()throws Exception{
			if(dis !=null) dis.close();
			if(dos !=null) dos.close();
			if(s!=null) s.close();
		}
		
		
		public void run(){
			try{
				while(bConnected){
					String str = dis.readUTF();
					if(str.charAt(0) == 'L')login(str);
					else if(str.charAt(0) == 'S')logout(str);
					else {
						sendToAll(str);
						System.out.println(str);
					
					}
				}
			}
			catch(SocketException e) {
				clients.remove(this);
			}
			catch(EOFException e){}
			catch(Exception e) {}
			finally{
				try {
					closeClient();
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}	
		}
		
		
	}
	
	
}