package com.zihua.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import java.util.LinkedList;
import java.util.Queue;



/**
 * Created by zihua on 16-10-28.
 */
public class XinLang{
   public static void main(String[]args){
       Spider spider=new Spider("http://s.weibo.com/top/summary?cate=realtimehot");
       spider.run();
   }
}


class Spider {

    private String url=null;
    private String result=null;


    public Spider(String url){
        this.url=url;

    }

    public void run(){
        long start=System.currentTimeMillis();
        while(true) {
            String tre = parers(sendGet(url));
            String[] tres = tre.split("[\n]");
            insertToMysql(tres);
            long current=System.currentTimeMillis();
            long total=(current-start)/1000;
            long day=total/(3600*24);
            total%=(3600*24);
            long hour=total/3600;
            total%=3600;
            long min=total/60;
            total%=60;
            long second=total;
            System.out.println("当前运行 "+day+" 天 "+hour+" 小时 "+min+" 分 "+total+" 秒 ");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void insertToMysql(String[]data){
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver") ;
            String u ="jdbc:mysql://localhost:3306/Crawler?useUnicode=true&characterEncoding=gbk";
            conn = DriverManager.getConnection(u,"root","  ") ;

            Statement statement=conn.createStatement();

            String qsql="select * from host_search where topic=";
            String usql="update host_search set rating=";
            String insql ="INSERT INTO host_search VALUES(";


            for(int i=0;i<data.length;i++){

                String []t=data[i].split("[ ]");
                String topic="";
                for(int j=1;j<t.length-1;j++){
                    topic+=t[j];
                }
                if(topic==null)continue;
                int len=t.length;
                Integer rating=Integer.valueOf(t[len-1]);
                String qu=qsql+"\""+topic+"\"";
                ResultSet result=statement.executeQuery(qu);

                //System.out.println(qu);
                boolean exist=false;
                Integer te=0;
                while(result.next()){
                    exist=true;
                    te=result.getInt(1);
                    //System.out.println(result.getString(2)+" "+te);
                }

                if(exist){
                    String update=usql+te;
                    update+=" where topic="+"\""+topic+"\"";
                    statement.executeUpdate(update);
                    //System.out.println(update);
                }
                else {

                    String insert=insql+rating+","+"\""+topic+"\")";
                    Statement stmt = conn.createStatement();
                    //System.out.println(insert);
                    stmt.execute(insert);

                }

            }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("failure!!!") ;
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


     private  String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            connection.setConnectTimeout(3000);
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    private String parers(String html){
        Document doc=Jsoup.parse(html);
        Elements elements=doc.select("tr[action-type]");
        //System.out.println(elements.size());
        String result="";
        for(Element e:elements){
            result+=e.text();
            result+="\n";
        }
        return  result;
    }


}



