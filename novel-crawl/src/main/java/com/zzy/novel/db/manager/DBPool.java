package com.zzy.novel.db.manager;

import com.zzy.novel.util.ClassUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据库连接池配置
 *
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2018/4/28.
 */
public class DBPool {
    private static DBPool dbPool = null;
    private String poolPath;
    private static Logger log = LoggerFactory.getLogger(DBPool.class);
    private static String path = ClassUtil.getClassRootPath(DBPool.class);

    public static DBPool getDBPool() {
        if (dbPool == null) {
            synchronized (DBPool.class) {
                if (dbPool == null) {
                    dbPool = new DBPool();
                }
            }
        }
        return dbPool;
    }

    private DBPool() {

    }

    /**
     * @param poolPath
     * @Author: lulei
     * @Description: 设置数据库连接池配置文件路径
     */
    public void setPoolPath(String poolPath) {
        this.poolPath = poolPath;
    }

    /**
     * @return
     * @Author: lulei
     * @Description: 返回数据库连接池配置文件路径
     */
    protected String getPoolPath() {
        //如果没有指定配置文件，则使用默认配置文件
        if (poolPath == null) {
            poolPath = path + "proxool.xml";
            log.info("Database's poolpath is null, use default path:" + poolPath);
        }
        return poolPath;
    }
}
