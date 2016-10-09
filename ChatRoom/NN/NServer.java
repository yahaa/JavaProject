
import java.nio.charset.Charset;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.Channel;


public class NServer {
	private Selector selector=null;
	private final int PORT=30000;
	private Charset charset=Charset.forName("UTF-8");
	private ServerSocketChannel ssc=null;
	private static int userCount=0;
	
	
	public void init()throws IOException{
		System.out.println("服务器开启成功......");
		//selector 配置
		selector=Selector.open();
		// ssc 配置
		ssc=ServerSocketChannel.open();
		InetSocketAddress address=new InetSocketAddress(PORT);
		ssc.bind(address);
		ssc.configureBlocking(false);
		ssc.register(selector,SelectionKey.OP_ACCEPT);
		checkOpt();
		
	}
	
	private void checkOpt()throws IOException{
		System.out.println("进入监控状态......");
		while(selector.select()>0){
			for(SelectionKey key:selector.selectedKeys()){
				selector.selectedKeys().remove(key);
				//处理连接请求
				if(key.isAcceptable()){
					SocketChannel sc=ssc.accept();
					//sc 配置
					sc.configureBlocking(false);
					sc.register(selector,SelectionKey.OP_READ);
					key.interestOps(SelectionKey.OP_ACCEPT);
					userCount++;
					System.out.println("当前在线人数 "+userCount);
				}
				
				//处理读取数据请求
				if(key.isReadable()){
					SocketChannel sc=(SocketChannel)key.channel();
					ByteBuffer buff=ByteBuffer.allocate(1024);
					String word="";
					try{
						while(sc.read(buff)>0){
							buff.flip();
							word+=charset.decode(buff);
						}
						System.out.println(word);
						key.interestOps(SelectionKey.OP_READ);
						if(word.length()<=0){
							key.cancel();
							userCount--;
							System.out.println("当前在线人数 "+userCount);
						}
						
					}
					catch(IOException ex){
						key.cancel();
						if(key.channel()!=null)key.channel().close();
						ex.printStackTrace();
					}
					
					//把消息发给所有的用户
					if(word.length()>0){
						for(SelectionKey tkey:selector.keys()){
							Channel sendTo=tkey.channel();
							if(sendTo instanceof SocketChannel){
								((SocketChannel) sendTo).write(charset.encode(word));
							}
						}
					}
					
				}
			}
		}
	}
	
	
	public static void main(String[]args){
		NServer a=new NServer();
		try{
			a.init();
		}
		catch(IOException ex){
			System.out.println("IO错误");
			ex.printStackTrace();
		}
	}
	
}
