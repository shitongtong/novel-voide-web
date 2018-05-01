package com.zzy.db;

import com.zzy.util.PropertiesUtil;

import java.sql.*;
import java.util.*;

/**
 * 数据库操作类
 * Created by stt on 2018/4/29.
 */
public class DBOperation {
    private static Properties properties = PropertiesUtil.getProperties("jdbc.properties");
    //数据库驱动
    private static String driver = properties.getProperty("jdbc.driverClassName");
    //数据库路径，找到对应的数据库
    private static String url = properties.getProperty("jdbc.url");
    //数据库账号
    private static String username = properties.getProperty("jdbc.username");
    //数据库密码
    private static String password = properties.getProperty("jdbc.password");


    /***
     * 连接数据库的方法
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getCon() throws ClassNotFoundException, SQLException {
        Class.forName(driver);//加载数据库驱动
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }

    /***
     * 关闭数据库的方法
     *
     * @param con
     * @param ps
     */
    public static void close(Connection con, PreparedStatement ps,ResultSet rs) {
        if (rs != null) {//关闭资源，避免出现异常
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /***
     * 增删改的方法
     *
     * @param sql
     * @param arr
     * @return
     */
    public static boolean executeUpdate(String sql, Object[] arr) {
        System.out.println("executeSql: "+sql);
        System.out.println("params: "+ Arrays.toString(arr));
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getCon();//第一步 ：连接数据库的操作
            ps = con.prepareStatement(sql);//第二步：预编译
            //第三步：设置值
            if (arr != null && arr.length != 0) {
                for (int i = 0; i < arr.length; i++) {
                    ps.setObject(i + 1, arr[i]);
                }
            }
            int count = ps.executeUpdate();//第四步：执行sql语句
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, ps,null);
        }
        return false;
    }

    /***
     * 查询的方法
     *
     * @param sql
     * @param arr
     * @return
     */
    public static List<List<Object>> executeQuery(String sql, Object[] arr,int queryParamSize) {
        System.out.println("executeSql: "+sql);
        System.out.println("params: "+ Arrays.toString(arr));

        List<List<Object>> resultList = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getCon();//第一步 ：连接数据库的操作
            ps = con.prepareStatement(sql);//第二步：预编译
            //第三步：设置值
            if (arr != null && arr.length != 0) {
                for (int i = 0; i < arr.length; i++) {
                    ps.setObject(i + 1, arr[i]);
                }
            }
            rs = ps.executeQuery();//第四步：执行sql语句
            while (rs.next()){
                List<Object> rowlist = new ArrayList<>();
                for (int i = 1; i <= queryParamSize; i++) {
                    rowlist.add(rs.getObject(i));
                }
                resultList.add(rowlist);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, ps,rs);
        }
        return resultList;
    }

    public static void main(String[] args) {
        String sql = "select * from user where status=1 and name=?";
        String[] params = new String[]{"aa1"};
        List<List<Object>> lists = DBOperation.executeQuery(sql, params, 1);
        System.out.println(lists.size());
        if (lists.get(0).size()==0){
            System.out.println("0");
        }else {
            System.out.println("1");
        }
    }

}
