package com.zzy.novel.crawl.zongheng.model;

/**
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2018/4/28.
 */
public class NovelChapterModel {
    private String url;
    private int chapterId;
    private long time;
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getChapterId() {
        return chapterId;
    }
    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
}
