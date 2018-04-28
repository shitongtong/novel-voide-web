package com.zzy.novel.util;

/**
 * 类工具
 * 主要是返回class文件所在的文件目录或工程的根目录地址，这主要用于指定工程中配置文件的路径，不至于环境迁移而导致配置文件路径错误
 *
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2018/4/28.
 */
public class ClassUtil {
    /**
     * @param c
     * @return
     * @Description: 返回类class文件所在的目录
     */
    public static String getClassPath(Class<?> c) {
        return c.getResource("").getPath().replaceAll("%20", " ");
    }

    /**
     * @param c
     * @param hasName 是否显示文件名
     * @return 返回类class文件的地址
     * @Description:
     */
    public static String getClassPath(Class<?> c, boolean hasName) {
        String name = c.getSimpleName() + ".class";
        String path = c.getResource(name).getPath().replaceAll("%20", " ");
        if (hasName) {
            return path;
        } else {
            return path.substring(0, path.length() - name.length());
        }
    }

    /**
     * @param c
     * @return
     * @Description: 返回类class文件所在的顶级目录
     */
    public static String getClassRootPath(Class<?> c) {
        return c.getResource("/").getPath().replaceAll("%20", " ");
    }

    public static void main(String[] args) {
        System.out.println(ClassUtil.getClassPath(ClassUtil.class, true));
        System.out.println(ClassUtil.getClassPath(Math.class, true));
        System.out.println(ClassUtil.getClassRootPath(Math.class));
    }
}
