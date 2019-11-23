package cn.mh.sbquickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot的二次学习的入门程序：
 * 1.使用jdbc负责持久层数据查询，封装QueryRunner作为查询辅助类，
 * 使用反射将数据库结果集映射到java类中（commons包的BeanUtil类）
 * 2.使用以前封装的DataSource注入到spring中，作为连接池
 * 3.
 */
@SpringBootApplication
public class SbQuickstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbQuickstartApplication.class, args);
    }

}
