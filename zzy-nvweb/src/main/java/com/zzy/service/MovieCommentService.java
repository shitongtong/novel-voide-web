package com.zzy.service;

import com.zzy.db.DBOperation;
import com.zzy.dto.MovieCommentDto;
import com.zzy.po.MovieComment;
import com.zzy.util.UUIDUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by stt on 2018/4/30.
 */
public class MovieCommentService {


    public boolean save(String content, String movieUuid,String userUuid) {
        String sql = "insert into movie_comment(movie_comment_uuid,content,movie_uuid,create_uid,update_uid) " +
                "values(?,?,?,?,?)";
        String[] params = new String[]{UUIDUtil.uuid(), content, movieUuid,userUuid,userUuid};
        return DBOperation.executeUpdate(sql, params);
    }

    public List<MovieCommentDto> findByMovieUuid(String movieUuid) {
        String sql = "select c.movie_comment_uuid,c.movie_uuid,u.user_uuid,u.name,c.create_time,c.usernum,c.content " +
                "from movie_comment c left join user u on u.user_uuid=c.create_uid " +
                "where c.status=1 and c.movie_uuid=? order by c.usernum desc,c.create_time desc";
        String[] params = new String[]{movieUuid};
        List<List<Object>> lists = DBOperation.executeQuery(sql, params, 7);
        List<MovieCommentDto> movieCommentDtoList = new ArrayList<>();
        MovieCommentDto movieCommentDto = new MovieCommentDto();
        for (List<Object> objects:lists){
            movieCommentDto = new MovieCommentDto();
            movieCommentDto.setMovieCommentUuid((String) objects.get(0));
            movieCommentDto.setMovieUuid((String) objects.get(1));
            movieCommentDto.setUserUuid((String) objects.get(2));
            movieCommentDto.setUserName((String) objects.get(3));
            movieCommentDto.setCreateTime((Date) objects.get(4));
            movieCommentDto.setUsernum((int) objects.get(5));
            movieCommentDto.setContent((String) objects.get(6));
            movieCommentDtoList.add(movieCommentDto);
        }
        return movieCommentDtoList;
    }

    public MovieComment findByMovieCommentUuid(String movieCommentUuid) {
        String sql = "select movie_uuid,create_uid from movie_comment where movie_comment_uuid=?";
        String[] params = new String[]{movieCommentUuid};
        List<List<Object>> lists = DBOperation.executeQuery(sql, params, 2);
        if (lists.size()==0){
            return null;
        }
        List<Object> objects = lists.get(0);
        MovieComment movieComment = new MovieComment();
        movieComment.setMovieUuid((String) objects.get(0));
        movieComment.setCreateUid((String) objects.get(1));
        return movieComment;
    }

    public boolean update(String movieCommentUuid) {
        String sql = "update movie_comment set usernum=usernum+1 where movie_comment_uuid=?";
        String[] params = new String[]{movieCommentUuid};
        return DBOperation.executeUpdate(sql,params);
    }
}
