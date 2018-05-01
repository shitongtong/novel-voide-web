package com.zzy.service;

import com.zzy.db.DBOperation;
import com.zzy.po.Novel;
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

    public List<Novel> findByNovelUuid(String novelUuid) {
        String sql = "select c.comment_uuid,c.novel_uuid,u.user_uuid,u.name,c.create_time " +
                "from comment c left join user u on u.user_uuid=c.create_uid " +
                "where c.status=1 and c.novel_uuid=?";
        String[] params = new String[]{novelUuid};
        List<List<Object>> lists = DBOperation.executeQuery(sql, params, 5);
        if (lists.size()==0){
            return null;
        }
        List<Novel> novelList = new ArrayList<>();
        Novel novel = new Novel();
        for (List<Object> objects:lists){
             novel = new Novel();
            novel.setNovelUuid((String) objects.get(0));
            novel.setName((String) objects.get(1));
            novel.setUrl((String) objects.get(2));
            novel.setAuthor((String) objects.get(3));
            novel.setIntro((String) objects.get(4));
            novel.setPhoto((String) objects.get(5));
            novel.setCreateTime((Date) objects.get(6));
            novelList.add(novel);
        }

        return novelList;
    }

    public List<Novel> findAll() {
        String sql = "select novel_uuid,name,url,author,intro,photo,create_time " +
                "from novel where status=1";
        String[] params = new String[]{};
        List<List<Object>> lists = DBOperation.executeQuery(sql, params, 7);
        if (lists.size()==0){
            return null;
        }
        List<Novel> novelList = new ArrayList<>();
        Novel novel = new Novel();
        for (List<Object> objects:lists){
            novel = new Novel();
            novel.setNovelUuid((String) objects.get(0));
            novel.setName((String) objects.get(1));
            novel.setUrl((String) objects.get(2));
            novel.setAuthor((String) objects.get(3));
            novel.setIntro((String) objects.get(4));
            novel.setPhoto((String) objects.get(5));
            novel.setCreateTime((Date) objects.get(6));
            novelList.add(novel);
        }

        return novelList;
    }


    public boolean delete(String novelUuid) {
        String sql = "update novel set status=0 where novel_uuid=?";
        String[] params = new String[]{novelUuid};
        return DBOperation.executeUpdate(sql, params);
    }
}
