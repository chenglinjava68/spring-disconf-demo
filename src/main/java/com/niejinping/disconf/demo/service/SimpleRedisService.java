package com.niejinping.disconf.demo.service;

import com.niejinping.disconf.demo.config.JedisConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Created by niejinping on 2017/3/7.
 */
@Service
@Scope("singleton")
@Log4j2(topic = "disconf-demo")
public class SimpleRedisService implements InitializingBean, DisposableBean {
    // jedis 实例
    private Jedis jedis = null;

    /**
     * 分布式配置
     */
    @Autowired
    private JedisConfig jedisConfig;

    public void destroy() throws Exception {
        if (jedis != null) {
            jedis.disconnect();
        }
    }

    public void afterPropertiesSet() throws Exception {
        jedis = new Jedis(jedisConfig.getHost(),
                jedisConfig.getPort());
    }

    public void update(){
        jedis = new Jedis(jedisConfig.getHost(),
                jedisConfig.getPort());
    }

    /**
     * 获取一个值
     *
     * @param key
     * @return
     */
    public String getKey(String key) {
        if (jedis != null) {
            return jedis.get(key);
        }

        return null;
    }

    /**
     * 获取一个值
     *
     * @param key
     * @return
     */
    public String setKey(String key,String value) {
        if (jedis != null) {
            return jedis.set(key,value);
        }

        return null;
    }
}
