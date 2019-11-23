package cn.mh.sbquickstart.dao;

import cn.mh.sbquickstart.entry.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mahao
 * @date: 2019/11/3
 */
@Repository
public class HelloDao {


    @Autowired
    DataSource dataSource;

    public List<Item> selectAll() throws SQLException {
        Connection conn = dataSource.getConnection();
        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery("select  * from tb_item");
        List<Item> items = new ArrayList<>(rs.getRow());
        while (rs.next()) {
            Item item = new Item();
            item.setId(rs.getLong(1));
            item.setTitle(rs.getString(2));
            item.setSellPoint(rs.getString(3));
            item.setPrice(rs.getLong(4));
            item.setNum(rs.getInt(5));
            item.setBarcode(rs.getString(6));
            item.setImage(rs.getString(7));
            item.setCid(rs.getLong(8));
            item.setStatus(rs.getByte(9));
            item.setCreated(rs.getDate(10));
            item.setUpdated(rs.getDate(11));
            items.add(item);
        }
        System.out.println(items);
        return items;
    }


}
