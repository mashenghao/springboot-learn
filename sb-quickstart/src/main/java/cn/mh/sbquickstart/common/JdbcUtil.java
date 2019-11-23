package cn.mh.sbquickstart.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc连接工具类
 *
 * @author mahao
 * @date 2019年5月2日 下午5:35:30
 */
public class JdbcUtil {
    //数据库连接地址
    public static String URL = "jdbc:mysql://127.0.0.1:3306/taotao?serverTimezone=UTC";
    //用户名
    public static String USERNAME = "root";
    //密码
    public static String PASSWORD = "123456";
    //MYSQL驱动类
    public static String SERVER = "com.mysql.jdbc.Driver";

    //加载属性资源
    // private static ResourceBundle rb = ResourceBundle.getBundle("jdbc");

    //静态块加载驱动程序
    static {
            
           /* URL  =   rb.getString("jdbc.url");
            USERNAME  =   rb.getString("jdbc.username");
            PASSWORD  =   rb.getString("jdbc.password");
            SERVER    =   rb.getString("jdbc.server");*/
        try {
            Class.forName(SERVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //定义一个获取数据库连接的方法
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭数据库
    public static void close(ResultSet rs, Statement st, Connection conn) {

        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
