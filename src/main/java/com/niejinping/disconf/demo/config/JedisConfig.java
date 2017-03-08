package com.niejinping.disconf.demo.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by niejinping on 2017/3/7.
 */
@Service
@Scope("singleton")
@DisconfFile(filename = "redis.properties")
@Data
public class JedisConfig {
    // 代表连接地址
    private String host;



    // 代表连接port
    private int port;

    @DisconfFileItem(name = "redis.host", associateField = "host")
    public String getHost() {
        return host;
    }

    @DisconfFileItem(name = "redis.port", associateField = "port")
    public int getPort() {
        return port;
    }
}
