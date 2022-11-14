package cn.tedu.csmall.product.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 计划任务配置类
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
@Slf4j
@Configuration
@EnableScheduling// 该注解用来开启计划任务
public class ScheduleConfiguration {
    //测试配置是否加载成功,输出对应日志内容
    public ScheduleConfiguration(){
        log.info("创建配置类对象:ScheduleConfiguration");
    }
}
