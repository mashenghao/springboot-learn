package cn.mh.sb.sbjdbc.mybatis;

import lombok.Data;

import java.util.Date;

/**
 * @author: mahao
 * @date: 2019/11/25
 */
@Data
public class Account {

    private int id;
    private String name;
    private int money;
    private Date date;


}
