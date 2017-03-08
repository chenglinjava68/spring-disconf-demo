package com.niejinping.disconf.demo;

import com.niejinping.disconf.demo.service.DisconfDemoTask;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by niejinping on 2017/3/7.
 */
@Log4j2(topic = "disconf-demo")
public class App {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        DisconfDemoTask disconfDemoTask = (DisconfDemoTask)ac.getBean("disconfDemoTask");

        if(disconfDemoTask == null){
            log.error("错误，找不到对象");
            return;
        }

        disconfDemoTask.run();

        try {
            ac.wait(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
