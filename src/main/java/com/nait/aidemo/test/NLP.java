package com.nait.aidemo.test;

import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.nlp.ESimnetType;
import org.json.JSONObject;

import java.util.HashMap;

public class NLP {
    //设置APPID/AK/SK
    public static final String APP_ID = "39229906";
    public static final String API_KEY = "z8CfnLGzkyfoe9nI4EW1GZBc";
    public static final String SECRET_KEY = "7KdU4F5PbXhmRdhmKHkGFGdMS6kKB3xj";

    public static void main(String[] args) {
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);


        System.out.println("--------1.词法分析---------");
        String text = "百度是一家高科技公司";
        JSONObject res = client.lexer(text, null);
        System.out.println(res.toString(2));

        System.out.println("--------2.依存句法分析---------");
        String text2 = "今天有笑吗";

        // 传入可选参数调用接口
        HashMap<String, Object> options2 = new HashMap<String, Object>();
        options2.put("mode", 1);

        // 依存句法分析
        JSONObject res2 = client.depParser(text2, options2);
        System.out.println(res2.toString(2));

        System.out.println("--------3.词向量表示---------");
        String word3 = "张飞";

        // 传入可选参数调用接口
        HashMap<String, Object> options3 = new HashMap<String, Object>();

        // 词向量表示
        JSONObject res3 = client.wordEmbedding(word3, options3);
        System.out.println(res3.toString(2));

        System.out.println("--------4.DNN语言模型---------");
        String text4 = "床前明月光";

        // 传入可选参数调用接口
        HashMap<String, Object> options4 = new HashMap<String, Object>();

        // DNN语言模型
        JSONObject res4 = client.dnnlmCn(text4, options4);
        System.out.println(res4.toString(2));

        System.out.println("--------5.词义相似度---------");
        String word5_1 = "考研";
        String word5_2 = "高考";

        // 传入可选参数调用接口
        HashMap<String, Object> options5 = new HashMap<String, Object>();


        // 词义相似度
        JSONObject res5 = client.wordSimEmbedding(word5_1, word5_2, options5);
        System.out.println(res5.toString(2));


        System.out.println("-------------6.评论观点抽取-------------");
        String text6 = "三星电脑电池不给力";
        HashMap<String, Object> options6 = new HashMap<String, Object>();

        // 获取美食评论情感属性
        JSONObject response6 = client.commentTag("这家餐馆味道不错", ESimnetType.FOOD, options6);
        System.out.println(response6.toString());

        // 获取酒店评论情感属性
        response6 = client.commentTag("喜来登酒店不错", ESimnetType.HOTEL, options6);
        System.out.println(response6.toString());


        System.out.println("-------------7.情感倾向分析-------------");
        String text7 = "苹果是一家伟大的公司";

        // 传入可选参数调用接口
        HashMap<String, Object> options7 = new HashMap<String, Object>();

        // 情感倾向分析
        JSONObject res7 = client.sentimentClassify(text, options7);
        System.out.println(res7.toString(2));


        System.out.println("-------------8.文章标签-------------");
        String title = "iphone手机出现“白苹果”原因及解决办法，用苹果手机的可以看下";
        String content = "如果下面的方法还是没有解决你的问题建议来我们门店看下成都市锦江区红星路三段99号银石广场24层01室。";

        // 传入可选参数调用接口
        HashMap<String, Object> options8 = new HashMap<String, Object>();

        // 文章标签
        JSONObject res8 = client.keyword(title, content, options8);
        System.out.println(res8.toString(2));


        System.out.println("-------------9.文章分类-------------");
        String title9 = "欧洲冠军杯足球赛";
        String content9 = "欧洲冠军联赛是欧洲足球协会联盟主办的年度足球比赛，代表欧洲俱乐部足球最高荣誉和水平，被认为是全世界最高素质、最具影响力以及最高水平的俱乐部赛事，亦是世界上奖金最高的足球赛事和体育赛事之一。";

        // 传入可选参数调用接口
        HashMap<String, Object> options9 = new HashMap<String, Object>();

        // 文章分类
        JSONObject res9 = client.topic(title9, content9, options9);
        System.out.println(res9.toString(2));


        System.out.println("-------------10.文本纠错-------------");
        String text10 = "百度是一家人工只能公司";

        // 传入可选参数调用接口
        HashMap<String, Object> options10 = new HashMap<String, Object>();

        // 文本纠错
        JSONObject res10 = client.ecnet(text10, options10);
        System.out.println(res10.toString(2));


        System.out.println("-------------11.对话情绪识别接口-------------");
        String text11 = "本来今天高高兴兴";

        // 传入可选参数调用接口
        HashMap<String, Object> options11 = new HashMap<String, Object>();
        options11.put("scene", "talk");

        // 对话情绪识别接口
        JSONObject res11 = client.emotion(text11, options11);
        System.out.println(res11.toString(2));

        System.out.println("-------------12.新闻摘要接口-------------");
        String content12 = "麻省理工学院的研究团队为无人机在仓库中使用RFID技术进行库存查找等工作，创造了一种...";
        int maxSummaryLen = 300;

        // 传入可选参数调用接口
        HashMap<String, Object> options12 = new HashMap<String, Object>();
        options12.put("title", "标题");

        // 新闻摘要接口
        JSONObject res12 = client.newsSummary(content12, maxSummaryLen, options12);
        System.out.println(res12.toString(2));

        System.out.println("-------------13.地址识别接口-------------");
        String text13 = "上海市浦东新区纳贤路701号百度上海研发中心 F4A000 张三";

        // 传入可选参数调用接口
        HashMap<String, Object> options13 = new HashMap<String, Object>();

        // 地址识别接口
        JSONObject res13 = client.address(text13, options13);
        System.out.println(res.toString(2));



    }

}
