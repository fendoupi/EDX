package tools;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;

import com.test.cn.edx.MyApplication;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.Objects;

/**
 * Created by yuan on 2016/4/19.
 */
public class ObjectStream {
    public static <T> String saveObject(T t) {
        //创造字节输出流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //对象输入流，封装字节流
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            //写入对象
            oos.writeObject(t);
            // 将字节流编码成base64的字符窜
            String oAuth_Base64 = new String(Base64.encodeToString(bos.toByteArray(),Base64.DEFAULT));
            return oAuth_Base64;
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }
    public static <T> Objects getObject(String string){
        Objects obj = null;
        //读取字节
        byte[] base64 = Base64.decode(string.getBytes(),Base64.DEFAULT);
        //封装到字节流
        ByteArrayInputStream bais = new ByteArrayInputStream(base64);
        try {
            //再次封装
            ObjectInputStream bis = new ObjectInputStream(bais);
            try {
                //读取对象
                obj = (Objects) bis.readObject();
                return obj;
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (StreamCorruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       return null;
    }
}
