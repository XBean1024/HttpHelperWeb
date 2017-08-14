package com.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by smart on 2017/8/14.
 * function：
 */
public class JsoupTest {
    public void test(){
        try {
            Document doc = Jsoup.connect("http://www.jb51.net")
                                   .data("query", "Java")
                                   .userAgent("Mozilla")
                                   .cookie("auth", "token")
                                   .timeout(3000)
                                   .post();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
