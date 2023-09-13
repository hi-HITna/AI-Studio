package com.nait.aidemo.test;


import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;

import java.util.HashMap;

public class ImgSample {
    //设置APPID/AK/SK
    public static final String APP_ID = "39217517";
    public static final String API_KEY = "l7HmN2mP5xKMQtniZDG7hj8T";
    public static final String SECRET_KEY = "RnvcWA17h2AAFKSpZHCBPf9AnPaBj8mI";

    public static void main(String[] args) {
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用接口
        String path = "C:\\Users\\lenovo\\OneDrive\\桌面\\OIP-C.jpg";
        JSONObject res = client.advancedGeneral(path, new HashMap<String, String>());

        System.out.println(res.toString(2));

    }
}
