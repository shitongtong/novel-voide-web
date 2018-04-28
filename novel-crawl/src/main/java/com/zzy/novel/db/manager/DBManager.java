package com.zzy.novel.db.manager;

import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接池管理
 *
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2018/4/28.
 */
public class DBManager {
    private static DBManager dBManager = null;

    private DBManager(){
        try {
            JAXPConfigurator.configure(DBPool.getDBPool().getPoolPath(), false);
            Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
        } catch (Exception  e){
            e.printStackTrace();
        }
    }

    /**
     * @return DBManager
     * @Author: lulei
     * @Description: 获取数据库连接池管理对象
     */
    protected static DBManager getDBManager(){
        if (dBManager == null){
            synchronized(DBManager.class){
                if (dBManager == null){
                    dBManager = new DBManager();
                }
            }
        }
        return dBManager;
    }

    /**
     * @param poolName
     * @return Connection
     * @throws SQLException
     * @Author: lulei
     * @Description: 获取数据库链接
     */
    protected Connection getConnection(String poolName) throws SQLException {
        return DriverManager.getConnection(poolName);
    }
}
