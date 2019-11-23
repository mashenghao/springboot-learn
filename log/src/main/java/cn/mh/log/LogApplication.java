package cn.mh.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.rmi.runtime.Log;

@SpringBootApplication
public class LogApplication {

    private final static Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

}
