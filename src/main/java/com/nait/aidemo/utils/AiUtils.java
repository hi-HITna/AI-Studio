package com.nait.aidemo.utils;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import java.io.IOException;
import java.util.HashMap;

public class AiUtils {
    //设置APPID/AK/SK
    public static final String APP_ID = "38986934";
    public static final String API_KEY = "8G0aQAGTDBymjbPvTnGjZqRw";
    public static final String SECRET_KEY = "QTcGbt3T0CKKmYFFdHgts1unGAM7UOeT";

    public static final String APP_ID_IMAGE = "39217517";
    public static final String API_KEY_IMAGE = "l7HmN2mP5xKMQtniZDG7hj8T";
    public static final String SECRET_KEY_IMAGE = "RnvcWA17h2AAFKSpZHCBPf9AnPaBj8mI";
    public static final String APP_ID_NLP = "39229906";
    public static final String API_KEY_NLP = "z8CfnLGzkyfoe9nI4EW1GZBc";
    public static final String SECRET_KEY_NLP = "7KdU4F5PbXhmRdhmKHkGFGdMS6kKB3xj";
    public static String pictoWords(MultipartFile file) throws IOException {//传入的是图片
        AipOcr client = new AipOcr("25452825"
                , "RQ3u6XR0jWKqUD6rYFNBMDxM"
                , "AW2WNIsk1sUVr2CZDGODHWkoutfi7G5C");//百度的key
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用接口
       //图片的绝对地址
//        String path = "C:\\Users\\lenovo\\OneDrive\\桌面\\下载.jpg";
        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
        JSONArray words_result = res.getJSONArray("words_result");
        String result = "";
        for (int i = 0; i <words_result.length(); i++) {
            JSONObject jsonObject = words_result.getJSONObject(i);
            Object words = jsonObject.get("words");//只提取问题
            String s=(String)words;
            result += s + "";
        }
       // System.out.println(result);  //这个可以变成一行只有图片文字的字符串
        return result;
    }
    public static String imgRecognition(MultipartFile file) throws IOException{
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID_IMAGE, API_KEY_IMAGE, SECRET_KEY_IMAGE);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用接口

        JSONObject res = client.advancedGeneral(file.getBytes(), new HashMap<String, String>());
        return res.toString(2);
    }
    public static String correction(String text){
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
        // 传入可选参数调用接口
        HashMap<String, Object> options10 = new HashMap<String, Object>();

        // 文本纠错
        JSONObject res10 = client.ecnet(text, options10);
        return res10.toString(2);
    }
}
