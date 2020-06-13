package utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class AjaxUtil {
    private String value;
    public AjaxUtil(String value){
        this.value=value;
    }
    public <T> T model(Class<T> tClass){
        try {
return new ObjectMapper().readValue(value,tClass);
        }catch (IOException e){
e.printStackTrace();
        }
        return null;
    }
    public static AjaxUtil of(BufferedReader reader){
        StringBuilder sb=new StringBuilder();
        try {
            String line;
            while ((line=reader.readLine())!=null){
sb.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return new AjaxUtil(sb.toString());
    }
}
