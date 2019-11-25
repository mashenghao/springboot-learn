package cn.mh.sb.sbjdbc.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: mahao
 * @date: 2019/11/25
 */
@Mapper
public interface AccountMapper {

    @Select("select * from account where id = #{id}")
    Account selectById(int id);

    /**
     * 配置版方法
     *
     * @return
     */
    public List<Account> selectAll();
}
