package com.niejinping.disconf.demo.service;

import com.niejinping.disconf.demo.config.JedisConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by niejinping on 2017/3/7.
 */
@Log4j2(topic = "disconf-demo")
@Service("disconfDemoTask")
public class DisconfDemoTask {
    @Autowired
    private SimpleRedisService simpleRedisService;

    @Autowired
    private JedisConfig jedisConfig;

    private static final String REDIS_KEY = "disconf_key";

    /**
     *
     */
    public int run() {

        try {

            while (true) {

                Thread.sleep(1000);

                log.info("redis( " + jedisConfig.getHost() + ","
                        + jedisConfig.getPort() + ")  get key: " + REDIS_KEY);
                log.info("get key : {} ,value :{}",REDIS_KEY,simpleRedisService.getKey(REDIS_KEY));

                log.info("set key : {} ,value :{}",REDIS_KEY,simpleRedisService.setKey(REDIS_KEY,"hello,disconf"));

            }

        } catch (Exception e) {
            log.error(e.toString(), e);
        }

        return 0;
    }
}
