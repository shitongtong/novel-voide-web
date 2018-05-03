package com.zzy.po;

/**
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2018/5/2.
 */
public class MovieComment extends BasePo {
    private String movieCommentUuid;
    private String movieUuid;
    private String content;
    private String usernum;

    public String getMovieCommentUuid() {
        return movieCommentUuid;
    }

    public void setMovieCommentUuid(String movieCommentUuid) {
        this.movieCommentUuid = movieCommentUuid;
    }

    public String getMovieUuid() {
        return movieUuid;
    }

    public void setMovieUuid(String movieUuid) {
        this.movieUuid = movieUuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }
}
