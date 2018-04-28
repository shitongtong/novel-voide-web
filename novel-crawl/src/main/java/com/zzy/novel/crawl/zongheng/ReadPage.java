package com.zzy.novel.crawl.zongheng;

import com.zzy.novel.crawl.CrawlBase;
import com.zzy.novel.util.DoRegex;
import com.zzy.novel.util.ParseUtil;

import java.io.IOException;
import java.util.HashMap;

/**
 * 阅读页
 *
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2018/4/28.
 */
public class ReadPage extends CrawlBase {
//    private static final String CONTENT = "<div id=\"chapterContent\" class=\"content\" itemprop=\"acticleBody\">(.*?)</div>";
    private static final String CONTENT = "<div id=\"readerFs\" class=\"\">(.*?)</div>";
    private static final String TITLE = "chapterName=\"(.*?)\"";
    private static final String WORDCOUNT = "itemprop=\"wordCount\">(\\d*)</span>";
    private String pageUrl;
    private static HashMap<String, String> params;

    /**
     * 添加相关头信息，对请求进行伪装
     */
    static {
        params = new HashMap<String, String>();
        params.put("Referer", "http://book.zongheng.com");
        params.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36");
    }

    public ReadPage(String url) throws IOException {
        readPageByGet(url, "utf-8", params);
        this.pageUrl = url;
    }

    /**
     * @return
     * @Author:lulei
     * @Description: 章节标题
     */
    private String getTitle() {
        return DoRegex.getFirstString(getPageSourceCode(), TITLE, 1);
    }

    /**
     * @return
     * @Author:lulei
     * @Description: 字数
     */
    private int getWordCount() {
        String wordCount = DoRegex.getFirstString(getPageSourceCode(), WORDCOUNT, 1);
        return ParseUtil.parseStringToInt(wordCount, 0);
    }

    /**
     * @return
     * @Author:lulei
     * @Description: 正文
     */
    private String getContent() {
        return DoRegex.getFirstString(getPageSourceCode(), CONTENT, 1);
    }

    public static void main(String[] args) throws IOException {
        ReadPage readPage = new ReadPage("http://book.zongheng.com/chapter/740008/40845529.html");
        System.out.println(readPage.pageUrl);
        System.out.println(readPage.getTitle());
        System.out.println(readPage.getWordCount());
        System.out.println(readPage.getContent());
    }
}
