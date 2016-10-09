
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.nio.channels.SocketChannel;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Scanner;
import java.io.BufferedInputStream;


public class NClient {
	private Selector selector=null;
	private final int POST=30000;
	private Charset charset=Charset.forName("UTF-8");
	private SocketChannel sc=null;
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private String name;
	
	public NClient(){
		System.out.print("输入你的名字 :");
		name=input.next();
		input.nextLine();
		name+=" : ";
	}
	
	
	public void init(){
		try{
			selector=Selector.open();
			InetSocketAddress address=new InetSocketAddress("115.29.146.79",POST);
			sc=SocketChannel.open(address);
			sc.configureBlocking(false);
			sc.register(selector, SelectionKey.OP_READ);
			System.out.println("成功连接到服务器.......");
			Thread a=new Thread(new Client());
			a.start();
			while(input.hasNextLine()){
				String word=input.nextLine();
				sc.write(charset.encode(name+word));
			}
		}
		catch(IOException ex){
			ex.printStackTrace();
			System.out.println("无法连接到服务器.......");
		}
		
		
		
	}
	
	private class Client implements Runnable {
		public void run(){
			try{
				while(selector.select()>0){
					for(SelectionKey key:selector.selectedKeys()){
						selector.selectedKeys().remove(key);
						if(key.isReadable()){
							SocketChannel tsc=(SocketChannel)key.channel();
							ByteBuffer buff=ByteBuffer.allocate(1024);
							String receiveWord="";
							while(tsc.read(buff)>0){
								buff.flip();
								receiveWord+=charset.decode(buff);
							}
							receiveWord=receiveWord.replaceAll("null", "");
							System.out.println(receiveWord);
							key.interestOps(SelectionKey.OP_READ);
						}
					}
				}
			}
			catch(IOException ex){
				System.out.println("接受消息出错.......");
			}
			
		}
		
	}
	
	public static void main(String[]args){
		NClient a=new NClient();
		a.init();
	}
	
}
