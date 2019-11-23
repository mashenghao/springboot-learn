package cn.mh.sbquickstart.common;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * 连接池： 使用动态代理模式，也可以使用装饰者模式
 *
 * @author mahao
 * @date 2019年5月3日 上午10:42:07
 */
public class MyDataSource implements DataSource {

    private static volatile MyDataSource instance = null;

    private List<Connection> pool = new LinkedList<>();

    public static void main(String[] args) throws SQLException {
        Connection connection = MyDataSource.createPool().getConnection();
        System.out.println(connection.getClass());
    }


    private MyDataSource(int num) {
        for (int i = 0; i < num; i++) {
            Connection conn = JdbcUtil.getConnection();
            Connection proxy = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(),
                    new Class[]{Connection.class}, new InvocationHandler() {

                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            if (method.getName().equals("close")) {
                                // System.out.println("返回连接");
                                if (conn != null) {
                                    pool.add(conn);
                                }
                                return null;
                            } else {
                                return method.invoke(conn, args);
                            }
                        }
                    });
            pool.add(proxy);
        }
    }

    public static MyDataSource createPool() {
        if (instance == null) {
            synchronized (MyDataSource.class) {
                if (instance == null) {
                    instance = new MyDataSource(15);
                }
            }
        }
        return instance;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Connection getConnection() throws SQLException {
        // System.out.println("连接池中大小是----" + pool.size());
        if (pool.size() == 0) {
            addCapacity(5);
        }
        return pool.remove(0);
    }

    private void addCapacity(int i) {
        Connection conn = JdbcUtil.getConnection();
        Connection proxy = (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(),
                Connection.class.getInterfaces(), new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("close")) {
                            pool.add(conn);
                        }
                        return method.invoke(conn, args);
                    }
                });
        pool.add(proxy);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }
}
