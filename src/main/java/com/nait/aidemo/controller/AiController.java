package com.nait.aidemo.controller;

import com.nait.aidemo.utils.AiUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@CrossOrigin
@RestController
public class AiController {
    @RequestMapping(value="/pic",method = RequestMethod.POST)
    public String PicToWord(@RequestParam("file") MultipartFile file) throws IOException {
        String res = AiUtils.pictoWords(file);//ai中传入文件
        System.out.println(res);  //这个可以变成一行只有图片文字的字符串
        return res;
    }
    @RequestMapping(value="/img",method = RequestMethod.POST)
    public String ImgToWord(@RequestParam("file") MultipartFile file) throws IOException {
        String res = AiUtils.imgRecognition(file);//ai中传入文件
        System.out.println(res);  //这个可以变成一行只有图片文字的字符串
        return res;
    }
    @RequestMapping(value="/correction",method = RequestMethod.GET)
    public String ImgToWord(@RequestParam("text") String text)  {
        System.out.println(text);
        String res = AiUtils.correction(text);//ai中传入文件
        System.out.println(res);  //这个可以变成一行只有图片文字的字符串
        return res;
    }

}
