package com.zzy.service;

import com.zzy.db.DBOperation;
import com.zzy.dto.CommentDto;
import com.zzy.po.Comment;
import com.zzy.util.UUIDUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by stt on 2018/4/30.
 */
public class CommentService {


    public boolean save(String content, String novelUuid,String userUuid) {
        String sql = "insert into comment(comment_uuid,content,novel_uuid,create_uid,update_uid) " +
                "values(?,?,?,?,?)";
        String[] params = new String[]{UUIDUtil.uuid(), content, novelUuid,userUuid,userUuid};
        return DBOperation.executeUpdate(sql, params);
    }

    public List<CommentDto> findByNovelUuid(String novelUuid) {
        String sql = "select c.comment_uuid,c.novel_uuid,u.user_uuid,u.name,c.create_time,c.usernum,c.content " +
                "from comment c left join user u on u.user_uuid=c.create_uid " +
                "where c.status=1 and c.novel_uuid=?";
        String[] params = new String[]{novelUuid};
        List<List<Object>> lists = DBOperation.executeQuery(sql, params, 7);
        List<CommentDto> commentDtoList = new ArrayList<>();
        CommentDto commentDto = new CommentDto();
        for (List<Object> objects:lists){
            commentDto = new CommentDto();
            commentDto.setCommentUuid((String) objects.get(0));
            commentDto.setNovelUuid((String) objects.get(1));
            commentDto.setUserUuid((String) objects.get(2));
            commentDto.setUserName((String) objects.get(3));
            commentDto.setCreateTime((Date) objects.get(4));
            commentDto.setUsernum((int) objects.get(5));
            commentDto.setContent((String) objects.get(6));
            commentDtoList.add(commentDto);
        }

        return commentDtoList;
    }

    public Comment findByCommentUuid(String commentUuid) {
        String sql = "select novel_uuid,create_uid from comment where comment_uuid=?";
        String[] params = new String[]{commentUuid};
        List<List<Object>> lists = DBOperation.executeQuery(sql, params, 2);
        if (lists.size()==0){
            return null;
        }
        List<Object> objects = lists.get(0);
        Comment comment = new Comment();
        comment.setNovelUuid((String) objects.get(0));
        comment.setCreateUid((String) objects.get(1));
        return comment;
    }

    public Comment update(String commentUuid) {
        String sql = "select novel_uuid,create_uid from comment where comment_uuid=?";
        String[] params = new String[]{commentUuid};
        List<List<Object>> lists = DBOperation.executeQuery(sql, params, 2);
        if (lists.size()==0){
            return null;
        }
        List<Object> objects = lists.get(0);
        Comment comment = new Comment();
        comment.setNovelUuid((String) objects.get(0));
        comment.setCreateUid((String) objects.get(1));
        return comment;
    }
}
