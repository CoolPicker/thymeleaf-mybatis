package com.nya.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * 自定义配置文件对应的配置类
 * spring boot 1.5后，ConfigurationProperties取消locations属性，现采用PropertySource配合使用
 * 注意：PropertySource注解只支持properties配置文件，不支持yaml文件
 * @Author: nya
 * @Date: 18-5-22 下午4:00
 */
@ConfigurationProperties(prefix = "example")
@PropertySource(value = "classpath:config/config-test.properties")
@Component
public class ExampleConfig {
    private String name;
    private String wife;
    private String age;
    private String dream;

    public void setName(String name) {
        this.name = name;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setDream(String dream) {
        this.dream = dream;
    }

    public String getName() {
        return name;
    }

    public String getWife() {
        return wife;
    }

    public String getAge() {
        return age;
    }

    public String getDream() {
        return dream;
    }
}
