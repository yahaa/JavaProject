package com.zihua.crawler;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zihua on 16-10-28.
 */
public class TSprider {
    private String regex="<tr action-type="+"([\\s\\S]*)"+"tr>";
    Pattern pattern=Pattern.compile(regex);
    private HttpGet httpGet=null;
    private Map<String,String>header=new HashMap<String,String>();
    private String coki="SINAGLOBAL=5860507432664.037.1469106393629; " +
            "_s_tentry=movie.kankan.com; " +
            "login_sid_t=ad2531f6b13cd0fe8d11795951a52ae1; " +
            "Apache=7722743806385.588.1477661165246; " +
            "ULV=1477661165250:8:3:1:7722743806385.588.1477661165246:1476283215465; " +
            "SWB=usrmdinst_20; WBtopGlobal_register_version=92d6e26980370f2c; " +
            "SSOLoginState=1477661351; SCF=Ai8x5fvRQoPBo1JIx45_OTCRXaiSzqOiGs-94" +
            "B3hNmkfop7d67rvE3yWjDCtcqNwq-ARWgImTXzDH72msY5idgk.; " +
            "SUB=_2A251FyL4DeTxGeNN6VIT9i3LzjiIHXVWZRMwrDV8PUNbmtBeLRGlkW8AEcRCQ-mA-59L6YhAjY6j2G0Z0A..; " +
            "SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9W5FHqgNizjGfms9p2i--MuE5JpX5KzhUgL.Fo-0eo5ESoeNSKB2dJLoI7" +
            "U_qgLueh57; SUHB=0u5BKAuoXcubJ2; ALF=1509197350; wvr=6; " +
            "UOR=pinglun.sohu.com,widget.weibo.com,graph.qq.com";


    public TSprider(String url){
        httpGet=new HttpGet(url);
        addHeader();
    }

    private void addHeader(){
        header.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        header.put("Accept-Encoding","gzip, deflate, sdch");
        header.put("Accept-Language","zh-CN,zh;q=0.8");
        header.put("Cache-Control","max-age=0");
        header.put("Connection","keep-alive");
        header.put("Cookie",coki);
        header.put("Host","s.weibo.com");
        header.put("Referer","http://s.weibo.com/top/summary?Refer=top_hot&topnav=1&wvr=6");
        header.put("Upgrade-Insecure-Requests","1");
        header.put("User-Agent","Mozilla/5.0 (X11; Linux x86_64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.59 Safari/537.36");
        Set<Map.Entry<String,String>> entrySet=header.entrySet();
        for(Map.Entry<String,String>en:entrySet){
            httpGet.addHeader(en.getKey(),en.getValue());
        }


    }


    public void run(){

        String result=null;
        try{

            HttpResponse response = HttpClients.createDefault().execute(httpGet);
            if(response.getStatusLine().getStatusCode()==200){
                HttpEntity entity=response.getEntity();
                BufferedReader input=new BufferedReader(new InputStreamReader(entity.getContent()));
                String line=null;
                while((line=input.readLine())!=null){
                    result+=line;
                }
                System.out.println(result);
            }
//            Matcher m=pattern.matcher(result);
//            while(m.find())
//                result=m.group(0);
//            System.out.println(result);
//            Document document=Jsoup.parse(result);
//            //System.out.println(document);
//            Elements tr=document.getElementsByAttributeValue("class","star_name");
//            System.out.println(tr.size());




        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);

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


    public static void parers(String html){
        Document doc=Jsoup.parse(html);
        Elements elements=doc.select("tr[action-type]");
        System.out.println(elements.size());
        for(Element e:elements){
            System.out.println(e.text());
        }
    }

    public static void main(String[]args){

       String result= TSprider.sendGet("http://s.weibo.com/top/summary?cate=realtimehot");
        parers(result);

    }

}
