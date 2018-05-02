package com.zzy.po;

/**
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2018/5/2.
 */
public class Comment extends BasePo {
    private String commentUuid;
    private String novelUuid;
    private String content;
    private String usenum;

    public String getCommentUuid() {
        return commentUuid;
    }

    public void setCommentUuid(String commentUuid) {
        this.commentUuid = commentUuid;
    }

    public String getNovelUuid() {
        return novelUuid;
    }

    public void setNovelUuid(String novelUuid) {
        this.novelUuid = novelUuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsenum() {
        return usenum;
    }

    public void setUsenum(String usenum) {
        this.usenum = usenum;
    }
}
