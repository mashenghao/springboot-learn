package cn.mh.sbquickstart.service;

import cn.mh.sbquickstart.entry.Item;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: springboot-learn
 * @Date: 2019/11/3 16:41
 * @Author: mahao
 * @Description:
 */
public interface HelloService {

    List<Item> findAll() throws SQLException;
}
