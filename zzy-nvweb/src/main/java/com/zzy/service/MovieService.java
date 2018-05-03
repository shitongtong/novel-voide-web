package com.zzy.service;

import com.zzy.db.DBOperation;
import com.zzy.po.Movie;
import com.zzy.util.UUIDUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by stt on 2018/4/30.
 */
public class MovieService {


    public boolean save(String name, String url, String director, String screenwriter, String starring, String intro, String photo, String userUuid) {
        String sql = "insert into movie(movie_uuid,name,url,director,screenwriter,starring,intro,photo,create_uid,update_uid) " +
                "values(?,?,?,?,?,?,?,?,?,?)";
        String[] params = new String[]{UUIDUtil.uuid(), name, url, director, screenwriter, starring, intro, photo, userUuid, userUuid};
        return DBOperation.executeUpdate(sql, params);
    }

    /**
     * 查找用户上传的电影
     *
     * @param userUuid
     * @return
     */
    public List<Movie> findByUserUuid(String userUuid) {
        String sql = "select movie_uuid,name,url,director,screenwriter,starring,intro,photo,create_time " +
                "from movie where status=1 and create_uid=? order by create_time desc";
        String[] params = new String[]{userUuid};
        List<List<Object>> lists = DBOperation.executeQuery(sql, params, 9);
        if (lists.size() == 0) {
            return null;
        }
        List<Movie> movieList = new ArrayList<>();
        Movie movie = new Movie();
        for (List<Object> objects : lists) {
            movie = new Movie();
            movie.setMovieUuid((String) objects.get(0));
            movie.setName((String) objects.get(1));
            movie.setUrl((String) objects.get(2));
            movie.setDirector((String) objects.get(3));
            movie.setScreenwriter((String) objects.get(4));
            movie.setStarring((String) objects.get(5));
            movie.setIntro((String) objects.get(6));
            movie.setPhoto((String) objects.get(7));
            movie.setCreateTime((Date) objects.get(8));
            movieList.add(movie);
        }

        return movieList;
    }

    public List<Movie> findAll() {
        String sql = "select movie_uuid,name,url,director,screenwriter,starring,intro,photo,create_time " +
                "from movie where status=1 order by create_time desc";
        String[] params = new String[]{};
        List<List<Object>> lists = DBOperation.executeQuery(sql, params, 9);
        if (lists.size() == 0) {
            return null;
        }
        List<Movie> movieList = new ArrayList<>();
        Movie movie = new Movie();
        for (List<Object> objects : lists) {
            movie = new Movie();
            movie.setMovieUuid((String) objects.get(0));
            movie.setName((String) objects.get(1));
            movie.setUrl((String) objects.get(2));
            movie.setDirector((String) objects.get(3));
            movie.setScreenwriter((String) objects.get(4));
            movie.setStarring((String) objects.get(5));
            movie.setIntro((String) objects.get(6));
            movie.setPhoto((String) objects.get(7));
            movie.setCreateTime((Date) objects.get(8));
            movieList.add(movie);
        }

        return movieList;
    }


    public boolean delete(String movieUuid) {
        String sql = "update movie set status=0 where movie_uuid=?";
        String[] params = new String[]{movieUuid};
        return DBOperation.executeUpdate(sql, params);
    }

    public Movie findByMovieUuid(String movieUuid) {
        String sql = "select movie_uuid,name,url,director,screenwriter,starring,intro,photo,create_time from movie where status=1 and movie_uuid=?";
        String[] params = new String[]{movieUuid};
        List<List<Object>> lists = DBOperation.executeQuery(sql, params, 9);
        if (lists.size() == 0) {
            return null;
        }
        List<Object> objects = lists.get(0);
        Movie movie = new Movie();
        movie.setMovieUuid((String) objects.get(0));
        movie.setName((String) objects.get(1));
        movie.setUrl((String) objects.get(2));
        movie.setDirector((String) objects.get(3));
        movie.setScreenwriter((String) objects.get(4));
        movie.setStarring((String) objects.get(5));
        movie.setIntro((String) objects.get(6));
        movie.setPhoto((String) objects.get(7));
        movie.setCreateTime((Date) objects.get(8));
        return movie;
    }
}
