import java.net.*;
import java.util.regex.*;
import java.util.*;
import java.io.*;
public class Getzhihu {
	
	public static void main(String[]args){
		String url="http://www.zhihu.com/explore/recommendations";
		String result=getWebCode(url);
		
		List<String>list=getQuetions(result,"question_link.+?>(.+?)<");
		
		for(String question:list){
			System.out.println(question);
		}
	}
	
	
	//获取知乎的提问
	public static List<String>getQuetions(String result,String regex){
		List<String>list=new ArrayList<String>();
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(result);
		while(matcher.find()){
			list.add(matcher.group(1));
		}
		return list;
	}
	
	
	//获取知乎首页的代码
	public static String getWebCode(String url){
		String result=null;
		BufferedReader in=null;
		try{
			URL readURL=new URL(url);
			URLConnection con=readURL.openConnection();
			con.connect();
			in=new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			String str=null;
			while((str=in.readLine())!=null){
				result+=str;
			}
		}
		catch(Exception e){
			System.out.println("发送请求GET异常");
			e.printStackTrace();
		}
		finally{
			try{
				if(in!=null)in.close();
			}
			catch(Exception e2){
				System.out.println("can't close");
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	
	

}

