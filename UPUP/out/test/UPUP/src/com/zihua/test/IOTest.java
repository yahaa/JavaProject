package com.zihua.test;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yahaa on 16-10-11.
 */
public class IOTest {

    public void testFileWriter(String path){
        File file=new File(path);
        FileWriter outFile=null;
        try{
            outFile=new FileWriter(file);
            String name="you are lll";
            for(int i=0;i<100;i++){
                outFile.write(name);
                outFile.append('\n');
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                outFile.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    public void testPrintWriter(String path){
        File file=new File(path);
        PrintWriter printFile=null;
        try{
            String name="PrintWriter";
            printFile=new PrintWriter(file);
            for(int i=0;i<100;i++){
                printFile.println(name);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            printFile.close();
        }
    }

    public static void main(String[]args){
        IOTest a=new IOTest();
        a.testFileWriter("writer.txt");
        a.testPrintWriter("print.txt");
    }

}
