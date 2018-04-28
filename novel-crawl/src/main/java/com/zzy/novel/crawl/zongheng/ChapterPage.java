package com.zzy.novel.crawl.zongheng;

import com.zzy.novel.crawl.CrawlBase;
import com.zzy.novel.util.DoRegex;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * 章节列表页
 *
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2018/4/28.
 */
public class ChapterPage extends CrawlBase {
//    private static final String CHAPTER = "<td class=\"chapterBean\" chapterId=\"\\d*\" chapterName=\"(.*?)\" chapterLevel=\"\\d*\" wordNum=\"(.*?)\" updateTime=\"(.*?)\"><a href=\"(.*?)\" title=\".*?\">";
    private static final String CHAPTER = "<td class=\"chapterBean\" chapterid=\"\\d*\" chaptername=\"(.*?)\" chapterlevel=\"\\d*\" wordnum=\"(.*?)\" updatetime=\"(.*?)\"><a href=\"(.*?)\" title=\".*?\">";
    private static final int[] ARRAY = {1, 2, 3, 4};
    private static HashMap<String, String> params;

    /**
     * 添加相关头信息，对请求进行伪装
     */
    static {
        params = new HashMap<String, String>();
        params.put("Referer", "http://book.zongheng.com");
        params.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36");
    }

    public ChapterPage(String url) throws IOException {
        readPageByGet(url, "utf-8", params);
    }

    public List<String[]> getChaptersInfo() {
        return DoRegex.getListArray(getPageSourceCode(), CHAPTER, ARRAY);
    }

    public static void main(String[] args) throws IOException {
        ChapterPage chapterPage = new ChapterPage("http://book.zongheng.com/showchapter/740008.html");
        for (String[] ss : chapterPage.getChaptersInfo()) {
            for (String s : ss) {
                System.out.println(s);
            }
            System.out.println("----------------------------------------------------    ");
        }
    }
}
