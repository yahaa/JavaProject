package com.zihua.crawler;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Spider;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Vector;

/**
 * Created by zihua on 16-10-28.
 */
public class XinLang{
    private Spider spider=null;
    private Vector<String> results=new Vector<String>();
}


class Sprider implements Runnable {

    private HttpGet httpGet=null;
    private String result=null;
    private  HttpResponse response=null;


    public Sprider(String url){
        httpGet=new HttpGet(url);
    }

    public void run(){

        try{
            response = HttpClients.createDefault().execute(httpGet);
            if(response.getStatusLine().getStatusCode()==200){
                result = EntityUtils.toString(response.getEntity());
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public String getResutl(){
        return result;
    }

}

class HTMLParser implements Runnable{
    private String html=null;

    public HTMLParser(String html){
        this.html=html;
    }

    public void run(){

    }

    private void parser(){
        Document document= Jsoup.parse(html);
        Elements elements=document.getElementsByAttribute("action-type=\"hover\"");
    }

}

