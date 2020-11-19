# 简介
本项目在最简架构基础上添加熔断器、网关、配置中心、负载均衡、eureka集群等

最简架构项目：[https://github.com/tzs199373/spring-cloud-demo-v1](https://github.com/tzs199373/spring-cloud-demo-v1)

最简架构：eureka/provider/consumer/feign

# 工程运行前准备

C:\Windows\System32\drivers\etc	编辑hosts文件

```
127.0.0.1 eureka1111.com
127.0.0.1 eureka1112.com
127.0.0.1 eureka1113.com
```

如果不允许修改，则要更改权限，在属性里操作，具体可以百度。

# 运行
eureka至少启动一个
zuul启动
provider至少启动一个
consumer启动

# 测试
http://127.0.0.1:4444/consumer/findUserById?userId=1
初次调用可能会用服务不通的情况






