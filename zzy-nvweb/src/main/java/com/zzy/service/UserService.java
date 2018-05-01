package com.zzy.service;

import com.zzy.db.DBOperation;
import com.zzy.po.User;
import com.zzy.util.UUIDUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by stt on 2018/4/30.
 */
public class UserService {

    /**
     * 用户注册
     *
     * @param name
     * @param password
     * @return
     */
    public boolean register(String name, String password) {
        String sql = "insert into user(user_uuid,name,password) values(?,?,?)";
        String[] params = new String[]{UUIDUtil.uuid(), name, password};
        return DBOperation.executeUpdate(sql, params);
    }

    /**
     * 根据账号判断用户是否存在
     * @param name
     * @return
     */
    public boolean exits(String name) {
        String sql = "select count(*) from user where status=1 and name=?";
        String[] params = new String[]{name};
        List<List<Object>> lists = DBOperation.executeQuery(sql, params, 1);
        if ((long) lists.get(0).get(0) > 0) {
            return true;
        }
        return false;

    }

    /**
     * 根据账号查找用户
     * @param name
     * @return
     */
    public User findByName(String name) {
        String sql = "select id,user_uuid,name,password,type,status,sort,remark,create_time,update_time,create_uid,update_uid " +
                "from user where status=1 and name=? limit 1";
        String[] params = new String[]{name};
        List<List<Object>> lists = DBOperation.executeQuery(sql, params, 12);
        if (lists.size()==0){
            return null;
        }
        List<Object> objects = lists.get(0);
        User user = new User();
        user.setId((Integer) objects.get(0));
        user.setUserUuid((String) objects.get(1));
        user.setName((String) objects.get(2));
        user.setPassword((String) objects.get(3));
        user.setType((Integer) objects.get(4));
        user.setStatus((Integer) objects.get(5));
        user.setSort((Integer) objects.get(6));
        user.setRemark((String) objects.get(7));
        user.setCreateTime((Date) objects.get(8));
        user.setUpdateTime((Date) objects.get(9));
        user.setCreateUid((String) objects.get(10));
        user.setUpdateUid((String) objects.get(11));
        return user;
    }

    /**
     *
     * @param userUuid
     * @return
     */
    public User findByUserUuid(String userUuid) {
        String sql = "select id,user_uuid,name,password,type,status,sort,remark,create_time,update_time,create_uid,update_uid " +
                "from user where user_uuid=?";
        String[] params = new String[]{userUuid};
        List<List<Object>> lists = DBOperation.executeQuery(sql, params, 12);
        if (lists.size()==0){
            return null;
        }
        List<Object> objects = lists.get(0);
        User user = new User();
        user.setId((Integer) objects.get(0));
        user.setUserUuid((String) objects.get(1));
        user.setName((String) objects.get(2));
        user.setPassword((String) objects.get(3));
        user.setType((Integer) objects.get(4));
        user.setStatus((Integer) objects.get(5));
        user.setSort((Integer) objects.get(6));
        user.setRemark((String) objects.get(7));
        user.setCreateTime((Date) objects.get(8));
        user.setUpdateTime((Date) objects.get(9));
        user.setCreateUid((String) objects.get(10));
        user.setUpdateUid((String) objects.get(11));
        return user;
    }

    public List<User> findAll() {
        String sql = "select id,user_uuid,name,password,type,status,sort,remark,create_time,update_time,create_uid,update_uid " +
                "from user where status=1";
        String[] params = new String[]{};
        List<List<Object>> lists = DBOperation.executeQuery(sql, params, 12);
        if (lists.size()==0){
            return null;
        }

        List<User> userList = new ArrayList<>();
        User user = new User();
        for (List<Object> objects:lists){
            user.setId((Integer) objects.get(0));
            user.setUserUuid((String) objects.get(1));
            user.setName((String) objects.get(2));
            user.setPassword((String) objects.get(3));
            user.setType((Integer) objects.get(4));
            user.setStatus((Integer) objects.get(5));
            user.setSort((Integer) objects.get(6));
            user.setRemark((String) objects.get(7));
            user.setCreateTime((Date) objects.get(8));
            user.setUpdateTime((Date) objects.get(9));
            user.setCreateUid((String) objects.get(10));
            user.setUpdateUid((String) objects.get(11));

            userList.add(user);
        }

        return userList;
    }


    public boolean delete(String userUuid) {
        String sql = "update user set status=0 where user_uuid=?";
        String[] params = new String[]{userUuid};
        return DBOperation.executeUpdate(sql, params);
    }
}
