package com.zzy.novel.crawl.zongheng;

import com.zzy.novel.crawl.CrawlBase;
import com.zzy.novel.util.DoRegex;
import com.zzy.novel.util.ParseUtil;

import java.io.IOException;
import java.util.HashMap;

/**
 * 简介页
 *
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2018/4/28.
 */
public class IntroPage extends CrawlBase {
    private static final String NAME = "<meta name=\"og:novel:book_name\" content=\"(.*?)\"/> ";
    private static final String AUTHOR = "<meta name=\"og:novel:author\" content=\"(.*?)\"/> ";
    private static final String DESC = "<meta property=\"og:description\" content=\"(.*?)\"/> ";
    private static final String TYPE = "<meta name=\"og:novel:category\" content=\"(.*?)\"/> ";
    private static final String LATESTCHAPTER = "<meta name=\"og:novel:latest_chapter_name\" content=\"(.*?)\"/> ";
    private static final String LATESTCHAPTER2 = "<a class=\"chap\" href=\".*?\">(.*?)<p>.*?</p></a>";
    private static final String CHAPTERLISTURL = "<meta name=\"og:novel:read_url\" content=\"(.*?)\"/> ";
    //    private static final String WORDCOUNT = "<span itemprop=\"wordCount\">(\\d*?)</span>";
    private static final String WORDCOUNT = "<span title=\"(\\d*?)字\">\\d*?</span>";
    private static final String KEYWORDS = "<div class=\"keyword\">(.*?)</div>";
    private static final String KEYWORD = "<a.*?>(.*?)</a>";
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

    public IntroPage(String url) throws IOException {
        readPageByGet(url, "utf-8", params);
        this.pageUrl = url;
    }

    /**
     * @return
     * @Author:lulei
     * @Description: 获取书名
     */
    private String getName() {
        return DoRegex.getFirstString(getPageSourceCode(), NAME, 1);
    }

    /**
     * @return
     * @Author:lulei
     * @Description: 获取作者名
     */
    private String getAuthor() {
        return DoRegex.getFirstString(getPageSourceCode(), AUTHOR, 1);
    }

    /**
     * @return
     * @Author:lulei
     * @Description: 书籍简介
     */
    private String getDesc() {
        return DoRegex.getFirstString(getPageSourceCode(), DESC, 1);
    }

    /**
     * @return
     * @Author:lulei
     * @Description: 书籍分类
     */
    private String getType() {
        return DoRegex.getFirstString(getPageSourceCode(), TYPE, 1);
    }

    /**
     * @return
     * @Author:lulei
     * @Description: 最新章节
     */
    private String getLatestChapter() {
        String latestChapter = DoRegex.getFirstString(getPageSourceCode(), LATESTCHAPTER, 1);
        if ("".equals(latestChapter)) {
            latestChapter = DoRegex.getFirstString(getPageSourceCode(), LATESTCHAPTER2, 1).replace("正文：","");
        }
        return latestChapter;
    }

    /**
     * @return
     * @Author:lulei
     * @Description: 章节列表页Url
     */
    private String getChapterListUrl() {
        return DoRegex.getFirstString(getPageSourceCode(), CHAPTERLISTURL, 1);
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
     * @Description: 标签
     */
    private String keyWords() {
        String keyHtml = DoRegex.getFirstString(getPageSourceCode(), KEYWORDS, 1);
        return DoRegex.getString(keyHtml, KEYWORD, " ", 1);
    }

    public static void main(String[] args) throws IOException {
        IntroPage intro = new IntroPage("http://book.zongheng.com/book/740008.html");
        System.out.println("pageUrl: " + intro.pageUrl);
        System.out.println("name: " + intro.getName());
        System.out.println("author: " + intro.getAuthor());
        System.out.println("desc: " + intro.getDesc());
        System.out.println("type: " + intro.getType());
        System.out.println("latestChapter: " + intro.getLatestChapter());
        System.out.println("chapterListUrl: " + intro.getChapterListUrl());
        System.out.println("wordCount: " + intro.getWordCount());
        System.out.println("keyWords: " + intro.keyWords());
    }
}
