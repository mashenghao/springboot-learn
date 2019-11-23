package cn.mh.sbquickstart.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 对list类型数据进行处理
 *
 * @param <T>
 */
public class BeanListHandler<T> implements ResultSetHandler<List<T>> {

    private Class<T> clazz;

    public BeanListHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * 不足的是无法处理数据库字段和对象之间字段不一样问题，如下划线的处理。
     *
     * @param rs 数据库结果集
     * @return
     * @throws SQLException
     */
    @Override
    public List<T> handle(ResultSet rs) throws SQLException {
        List<T> list = new ArrayList<>();
        try {
            while (rs.next()) {
                T instance = clazz.newInstance();
                Field[] fileds = clazz.getDeclaredFields();
                for (Field field : fileds) {
                    Class type = field.getType();
                    Object object = rs.getObject(field.getName());
                    if (object != null) {
                        String name = (char) (field.getName().charAt(0) - 32)
                                + field.getName().substring(1, field.getName().length());
                        Method method = clazz.getMethod("set" + name, type);
                        method.invoke(instance, object);
                    }
                }
                list.add(instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
