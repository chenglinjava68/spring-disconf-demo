# spring-disconf-demo
disconf分布式配置示例

## 背景介绍
分布式配置，解藕大法好。


## 环境准备

> 需要提前搭建那配置中心，这个比较麻烦，比较繁锁的。按指导步骤进行即可，但需要注意几点。

- web是有两个，一个是api服务器，一个是web管理后台。

- 管理后台会调用api服务器，因此，需要注意域名或者说是url指向
- 部署时，建议api服务器和web管理后台单独部署
- web管理后台是全静态资源，使用nginx部署即可，如果api部署有context(url前缀)，则需要修改jquery.js文件9948行。网上有文章说明。
- api服务器部署在tomcat下面，需要配置nginx，将请求定向到api服务器
这个过程，请参考文章：
[http://www.codexiu.cn/jquery/blog/14151/](http://www.codexiu.cn/jquery/blog/14151/)

### 代码编写
这个就简单了，照着demo即可。

#### 服务依赖
```
      <dependency>
            <groupId>com.baidu.disconf</groupId>
            <artifactId>disconf-client</artifactId>
            <version>2.6.36</version>
            <exclusions>
                <exclusion>
                    <artifactId>log4j</artifactId>
                    <groupId>log4j</groupId>
                </exclusion>
            </exclusions>
        </dependency>
        
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-1.2-api</artifactId>
            <version>2.6.2</version>
        </dependency>

```
> 注意去年log4j的支持，采用log4j2,这里会有依赖冲突，需要google解决之。

#### demo

代码简单，不值一提。
