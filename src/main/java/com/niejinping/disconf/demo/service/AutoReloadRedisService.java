package com.niejinping.disconf.demo.service;

import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by niejinping on 2017/3/8.
 */
@Service
@DisconfUpdateService(confFileKeys = {"redis.properties"})
public class AutoReloadRedisService implements IDisconfUpdate {
    @Autowired
    private SimpleRedisService simpleRedisService;
    public void reload() throws Exception {
        simpleRedisService.update();
    }
}
