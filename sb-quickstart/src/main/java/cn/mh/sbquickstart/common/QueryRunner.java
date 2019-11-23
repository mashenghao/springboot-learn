package cn.mh.sbquickstart.common;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库查询辅助类
 *
 * @author: mahao
 * @date: 2019/11/3
 */
public class QueryRunner {

    private DataSource ds;

    public QueryRunner(DataSource ds) {
        this.ds = ds;
    }

    public <T> T query(ResultSetHandler<T> handler, String sql, Object... params) throws SQLException {
        Connection conn = ds.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        this.fillStatement(stmt, params);
        ResultSet rs = stmt.executeQuery();
        conn.close();
        return handler.handle(rs);
    }

    /**
     * 填充preparedStatement中参数
     *
     * @param stmt
     * @param params
     * @throws SQLException
     */
    public void fillStatement(PreparedStatement stmt, Object... params) throws SQLException {
        if (params == null) {
            return;
        }
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }
    }

}
