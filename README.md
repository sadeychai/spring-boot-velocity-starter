**本组件主要功能是让1.4.x以上版本的springboot支持velocity模板**

实现
===
该组件的实现步骤可以参考博文：[【终极方案】Springboot1.5以上版本如何支持Velocity模板](https://blog.csdn.net/kksadie/article/details/132193526)

使用方式
===
pom引入：
```xml
       <dependency>
            <groupId>com.sadeychai.boot</groupId>
            <artifactId>spring-boot-velocity-starter</artifactId>
            <version>1.0.0-SNAPSHOT</version>
        </dependency>
```

application.properties配置：

```properties
    spring.velocity.enabled=true
    spring.velocity.cache= false
    spring.velocity.charset=UTF-8
    spring.velocity.properties.input.encoding=UTF-8
    spring.velocity.properties.output.encoding=UTF-8
    spring.velocity.check-template-location=true
    spring.velocity.resource-loader-path=classpath:/templates/
    spring.velocity.suffix=.vm
    spring.velocity.toolbox-config-location=/velocity/toolbox.xml
    #layout支持
    spring.velocity.layout-view-resolver= true
    spring.velocity.layout-url= /src/page/layout/default.vm
    spring.velocity.screen-content-key= content

```
