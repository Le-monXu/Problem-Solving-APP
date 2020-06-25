package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    protected Connection c = null;
    protected Statement s = null;
    protected ResultSet r = null;

    protected void buildConn() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("数据库驱动加载成功！");
        c = DriverManager.getConnection(
                "jdbc:mysql://localhost/cordova_app?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false",
                "javaweb", "javaweb");
        System.out.println("连接数据库成功！");
        s = c.createStatement();
    }

    protected void distroy() throws Exception {
        if (r != null) {
            r.close();
        }
        System.out.println("关闭结果集！");
        if (s != null) {
            s.close();
        }
        System.out.println("关闭句柄！");
        if (c != null) {
            c.close();
        }
        System.out.println("关闭连接！");
    }

}
