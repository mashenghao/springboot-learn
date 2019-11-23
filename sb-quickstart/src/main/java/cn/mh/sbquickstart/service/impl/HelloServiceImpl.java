package cn.mh.sbquickstart.service.impl;

import cn.mh.sbquickstart.dao.HelloDao;
import cn.mh.sbquickstart.entry.Item;
import cn.mh.sbquickstart.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: mahao
 * @date: 2019/11/3
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    HelloDao helloDao;

    @Override
    public List<Item> findAll() throws SQLException {
        return helloDao.selectAll();
    }
}
