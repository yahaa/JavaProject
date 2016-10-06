import org.json.JSONArray;  
import org.json.JSONObject;  
  
public class TestJson01 {  
    public static void main(String[] args) {  
        //初始化JSONObject 方法一  
        JSONObject jsonObject1 = new JSONObject();  
        jsonObject1.put("Name", "Tom");  
        jsonObject1.put("age", "11");  
          
        //初始化JSONObject 方法二  
        JSONObject jsonObject2 = new JSONObject("{'Name':'Tom','age':'11'}");  
          
        //初始化JSONArray 方法一  
        JSONArray jsonArray1 = new JSONArray();  
        jsonArray1.put("abc");  
        jsonArray1.put("xyz");  
          
        //初始化JSONArray 方法二  
        JSONArray jsonArray2 = new JSONArray("['abc','xyz']");  
          
        System.out.println("jsonObject1:" + "\r" + jsonObject1.toString());  
        System.out.println("jsonObject2:" + "\r" + jsonObject2.toString());  
        System.out.println("jsonArray1:" + "\r" + jsonArray1.toString());  
        System.out.println("jsonArray2:" + "\r" + jsonArray2.toString());  

        String s="{\"Name\":\"Tom\",\"age\":\"11\"}";
        JSONObject jsonObject3=new JSONObject(s);
        System.out.println(jsonObject3);
          
    }  
}


