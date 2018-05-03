package com.zzy.dto;

import java.util.Date;

/**
 * Created by stt on 2018/5/1.
 */
public class MovieCommentDto {
    private String movieCommentUuid;
    private String movieUuid;
    private String userUuid;
    private String userName;
    private Date createTime;
    private Integer usernum;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUsernum() {
        return usernum;
    }

    public void setUsernum(Integer usernum) {
        this.usernum = usernum;
    }

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

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
