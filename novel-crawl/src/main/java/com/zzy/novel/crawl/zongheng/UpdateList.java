package com.zzy.novel.crawl.zongheng;

import com.zzy.novel.crawl.CrawlListPageBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2018/4/28.
 */
public class UpdateList extends CrawlListPageBase {
    private static HashMap<String, String> params;

    /**
     * 添加相关头信息，对请求进行伪装
     */
    static {
        params = new HashMap<String, String>();
        params.put("Referer", "http://book.zongheng.com");
        params.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36");
    }

    public UpdateList(String urlStr) throws IOException {
        super(urlStr, "utf-8", "get", params);
    }

    @Override
    public String getUrlRegexString() {
        return "<a class=\"fs14\" href=\"(.*?)\"";
    }

    @Override
    public int getUrlRegexStringNum() {
        return 1;
    }

    public List<String> getPageUrls(boolean exceptOther) {
        List<String> urls = getPageUrls();
        if (exceptOther) {
            List<String> exceptUrls = new ArrayList<>();
            for (String url : urls) {
                if (url.indexOf("zongheng") > 0) {
                    exceptUrls.add(url);
                }
            }
            return exceptUrls;
        }
        return urls;
    }

    public static void main(String[] args) throws IOException {
        UpdateList updateList = new UpdateList("http://book.zongheng.com/store/c0/c0/b9/u0/p1/v0/s9/t0/ALL.html");
        for (String s : updateList.getPageUrls(true)) {
            System.out.println(s);
        }
    }

}
