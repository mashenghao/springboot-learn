package cn.mh.sbquickstart.common;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: springboot-learn
 * @Date: 2019/11/3 17:03
 * @Author: mahao
 * @Description:
 */
public interface ResultSetHandler<T> {

    /**
     * 数据库数据集转java对象
     *
     * @param rs 数据库结果集
     * @return 泛型实例对象
     */
    T handle(ResultSet rs) throws SQLException;
}
