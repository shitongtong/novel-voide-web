package com.zzy.novel.crawl.zongheng.model;

/**
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2018/4/28.
 */
public class NovelReadModel extends NovelChapterModel {
    private String title;
    private int wordCount;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
