package com.zzy.novel.crawl.zongheng;

import com.zzy.novel.crawl.zongheng.model.CrawlListInfo;
import com.zzy.novel.crawl.zongheng.model.NovelChapterModel;
import com.zzy.novel.crawl.zongheng.model.NovelIntroModel;
import com.zzy.novel.crawl.zongheng.model.NovelReadModel;
import com.zzy.novel.db.manager.DBServer;
import com.zzy.novel.util.ParseMD5;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 纵横中文小说数据库操作
 *
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2018/4/28.
 */
public class ZonghengDb {
//    private static final String POOLNAME = "proxool.test";
    private static final String POOLNAME = "proxool";

    /**
     * @param urls
     * @Author:lulei
     * @Description: 保存更新列表采集到的URL
     */
    public void saveInfoUrls(List<String> urls) {
        if (urls == null || urls.size() < 1) {
            return;
        }
        for (String url : urls) {
            String md5Id = ParseMD5.parseStrToMd5L32(url);
            if (haveInfoUrl(md5Id)) {
                updateInfoState(md5Id, 1);
            } else {
                insertInfoUrl(md5Id, url);
            }
        }
    }

    /**
     * @param state
     * @return
     * @Author:lulei
     * @Description: 随机获取一个简介url
     */
    public String getRandIntroPageUrl(int state) {
        DBServer dbServer = new DBServer(POOLNAME);
        try {
            String sql = "select * from novelinfo where state = '" + state + "' order by rand() limit 1";
            ResultSet rs = dbServer.select(sql);
            while (rs.next()) {
                return rs.getString("url");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbServer.close();
        }
        return null;
    }

    /**
     * @param state
     * @return
     * @Author:lulei
     * @Description: 随机获取一个章节信息
     */
    public NovelChapterModel getRandReadPageUrl(int state) {
        DBServer dbServer = new DBServer(POOLNAME);
        try {
            String sql = "select * from novelchapter where state = '" + state + "' order by rand() limit 1";
            ResultSet rs = dbServer.select(sql);
            while (rs.next()) {
                NovelChapterModel chapter = new NovelChapterModel();
                chapter.setChapterId(rs.getInt("chapterid"));
                chapter.setTime(rs.getLong("chaptertime"));
                chapter.setUrl(rs.getString("url"));
                return chapter;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbServer.close();
        }
        return null;
    }

    /**
     * @param novel
     * @Author:lulei
     * @Description: 保存小说阅读页信息
     */
    public void saveNovelRead(NovelReadModel novel) {
        if (novel == null) {
            return;
        }
        DBServer dbServer = new DBServer(POOLNAME);
        try {
            HashMap<Integer, Object> params = new HashMap<Integer, Object>();
            int i = 1;
            String md5Id = ParseMD5.parseStrToMd5L32(novel.getUrl());
            //如果已经存在，则直接返回
            if (haveReadUrl(md5Id)) {
                return;
            }
            long now = System.currentTimeMillis();
            params.put(i++, md5Id);
            params.put(i++, novel.getUrl());
            params.put(i++, novel.getTitle());
            params.put(i++, novel.getWordCount());
            params.put(i++, novel.getChapterId());
            params.put(i++, novel.getContent());
            params.put(i++, novel.getTime());
            params.put(i++, now);
            params.put(i++, now);
            dbServer.insert("novelchapterdetail", "id,url,title,wordcount,chapterid,content,chaptertime,createtime,updatetime", params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbServer.close();
        }
    }

    /**
     * @return
     * @Author:lulei
     * @Description: 获取监控的更新列表页
     */
    public List<CrawlListInfo> getCrawlListInfos() {
        List<CrawlListInfo> infos = new ArrayList<CrawlListInfo>();
        DBServer dbServer = new DBServer(POOLNAME);
        try {
            String sql = "select * from crawllist where state = '1'";
            ResultSet rs = dbServer.select(sql);
            while (rs.next()) {
                CrawlListInfo info = new CrawlListInfo();
                infos.add(info);
                info.setFrequency(rs.getInt("frequency"));
                info.setInfo(rs.getString("info"));
                info.setUrl(rs.getString("url"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbServer.close();
        }
        return infos;
    }

    /**
     * @param bean
     * @Author:lulei
     * @Description: 更新简介页记录
     */
    public void updateInfo(NovelIntroModel bean) {
        if (bean == null) {
            return;
        }
        DBServer dbServer = new DBServer(POOLNAME);
        try {
            HashMap<Integer, Object> params = new HashMap<Integer, Object>();
            int i = 1;
            params.put(i++, bean.getName());
            params.put(i++, bean.getAuthor());
            params.put(i++, bean.getDescription());
            params.put(i++, bean.getType());
            params.put(i++, bean.getLastChapter());
            params.put(i++, bean.getChapterCount());
            params.put(i++, bean.getChapterlisturl());
            params.put(i++, bean.getWordCount());
            params.put(i++, bean.getKeyWords());
            long now = System.currentTimeMillis();
            params.put(i++, now);
            params.put(i++, "0");
            String columns = "name, author, description, type, lastchapter, chaptercount, chapterlisturl, wordcount, keywords, updatetime, state";
            String condition = "where id = '" + bean.getMd5Id() + "'";
            dbServer.update("novelinfo", columns, condition, params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbServer.close();
        }
    }

    /**
     * @param chapters
     * @Author:lulei
     * @Description: 保存章节列表信息
     */
    public void saveChapters(List<String[]> chapters) {
        if (chapters == null) {
            return;
        }
        DBServer dbServer = new DBServer(POOLNAME);
        try {
            for (int i = 0; i < chapters.size(); i++) {
                String[] chapter = chapters.get(i);
                if (chapter.length != 4) {
                    continue;
                }
                //name、wordcount、time、url
                String md5Id = ParseMD5.parseStrToMd5L32(chapter[3]);
                if (!haveChapterUrl(md5Id)) {
                    insertChapterUrl(chapter, i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbServer.close();
        }
    }

    /**
     * @param md5Id
     * @param state
     * @Author:lulei
     * @Description: 修改简介页的抓取状态
     */
    public void updateInfoState(String md5Id, int state) {
        DBServer dbServer = new DBServer(POOLNAME);
        try {
            String sql = "update novelinfo set state = '" + state + "' where id = '" + md5Id + "'";
            dbServer.update(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbServer.close();
        }
    }

    /**
     * @param md5Id
     * @param state
     * @Author:lulei
     * @Description: 更新章节列表采集状态
     */
    public void updateChapterState(String md5Id, int state) {
        DBServer dbServer = new DBServer(POOLNAME);
        try {
            String sql = "update novelchapter set state = '" + state + "' where id = '" + md5Id + "'";
            dbServer.update(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbServer.close();
        }
    }

    /**
     * @param md5Id
     * @param url
     * @Author:lulei
     * @Description: 新增一个抓取简介页
     */
    private void insertInfoUrl(String md5Id, String url) {
        DBServer dbServer = new DBServer(POOLNAME);
        try {
            HashMap<Integer, Object> params = new HashMap<Integer, Object>();
            int i = 1;
            params.put(i++, md5Id);
            params.put(i++, url);
            long now = System.currentTimeMillis();
            params.put(i++, now);
            params.put(i++, now);
            params.put(i++, "1");
            dbServer.insert("novelinfo", "id, url, createtime, updatetime, state", params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbServer.close();
        }
    }

    /**
     * @param md5Id
     * @return
     * @Author:lulei
     * @Description: 判断简介页是否存在
     */
    private boolean haveInfoUrl(String md5Id) {
        DBServer dbServer = new DBServer(POOLNAME);
        try {
            ResultSet rs = dbServer.select("select sum(1) as count from novelinfo where id = '" + md5Id + "'");
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        } finally {
            dbServer.close();
        }
    }

    /**
     * @param md5Id
     * @return
     * @Author:lulei
     * @Description: 判断阅读页信息是否存在
     */
    private boolean haveReadUrl(String md5Id) {
        DBServer dbServer = new DBServer(POOLNAME);
        try {
            ResultSet rs = dbServer.select("select sum(1) as count from novelchapterdetail where id = '" + md5Id + "'");
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        } finally {
            dbServer.close();
        }
    }

    /**
     * @param chapter
     * @param chapterId
     * @Author:lulei
     * @Description: 插入章节列表页信息
     */
    private void insertChapterUrl(String[] chapter, int chapterId) {
        //name、wordcount、time、url
        DBServer dbServer = new DBServer(POOLNAME);
        try {
            HashMap<Integer, Object> params = new HashMap<Integer, Object>();
            int i = 1;
            params.put(i++, ParseMD5.parseStrToMd5L32(chapter[3]));
            params.put(i++, chapter[3]);
            params.put(i++, chapter[0]);
            params.put(i++, chapter[1]);
            params.put(i++, chapterId);
            params.put(i++, chapter[2]);
            long now = System.currentTimeMillis();
            params.put(i++, now);
            params.put(i++, "1");
            dbServer.insert("novelchapter", "id, url, title, wordcount, chapterid, chaptertime, createtime, state", params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbServer.close();
        }
    }

    /**
     * @param md5Id
     * @return
     * @Author:lulei
     * @Description: 是否存在章节信息
     */
    private boolean haveChapterUrl(String md5Id) {
        DBServer dbServer = new DBServer(POOLNAME);
        try {
            ResultSet rs = dbServer.select("select sum(1) as count from novelchapter where id = '" + md5Id + "'");
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        } finally {
            dbServer.close();
        }
    }

    public static void main(String[] args) {
        ZonghengDb zonghengDb = new ZonghengDb();
        boolean b = zonghengDb.haveInfoUrl("11");
        System.out.println(b);
    }
}
