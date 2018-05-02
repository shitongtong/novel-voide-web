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
public class NovelService {

    /**
     *
     * @param name
     * @param url
     * @param author
     * @param intro
     * @param photo
     * @param userUuid
     * @return
     */
    public boolean save(String name, String url,String author ,String intro,String photo,String userUuid) {
        String sql = "insert into novel(novel_uuid,name,url,author,intro,photo,create_uid,update_uid) " +
                "values(?,?,?,?,?,?,?,?)";
        String[] params = new String[]{UUIDUtil.uuid(), name, url,author,intro,photo,userUuid,userUuid};
        return DBOperation.executeUpdate(sql, params);
    }

    /**
     * 查找用户上传的小说
     * @param userUuid
     * @return
     */
    public List<Novel> findByUserUuid(String userUuid) {
        String sql = "select novel_uuid,name,url,author,intro,photo,create_time " +
                "from novel where status=1 and create_uid=?";
        String[] params = new String[]{userUuid};
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

    public Novel findByNovelUuid(String novelUuid) {
        String sql = "select novel_uuid,name,url,author,intro,photo,create_time from novel where status=1 and novel_uuid=?";
        String[] params = new String[]{novelUuid};
        List<List<Object>> lists = DBOperation.executeQuery(sql, params, 7);
        if (lists.size()==0){
            return null;
        }
        List<Object> objects = lists.get(0);
        Novel novel = new Novel();
        novel.setNovelUuid((String) objects.get(0));
        novel.setName((String) objects.get(1));
        novel.setUrl((String) objects.get(2));
        novel.setAuthor((String) objects.get(3));
        novel.setIntro((String) objects.get(4));
        novel.setPhoto((String) objects.get(5));
        novel.setCreateTime((Date) objects.get(6));
        return novel;
    }
}
