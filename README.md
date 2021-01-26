# 简介
本项目在最简架构基础上添加熔断器、网关、配置中心、负载均衡、eureka集群等

最简架构项目：[https://github.com/tzs199373/spring-cloud-demo-v1](https://github.com/tzs199373/spring-cloud-demo-v1)

最简架构：eureka/provider/consumer/feign

# 工程运行前准备
本项目准备了两种注册中心，eureka与nacos

一、eureka使用集群，先做如下准备

C:\Windows\System32\drivers\etc	编辑hosts文件

```
127.0.0.1 eureka1111.com
127.0.0.1 eureka1112.com
127.0.0.1 eureka1113.com
```

如果不允许修改，则要更改权限，在属性里操作，具体可以百度。

二、nacos则先提前安装好

# 快速运行
1、注册中心（必须）
eureka,集群至少启动一个,如果三个没有全部启动，其他项目启动时会有连接失败错误，但不影响整个系统;

或者启动nacos

2、网关（非必须）

zuul，如要测试consumer集群负载均衡则必须启动，zuul注册中心配置为eureka

3、微服务（必须）

provider至少启动一个，目前provider-2221注册中心配置为nacos,provider-2222注册中心配置为eureka

consumer至少启动一个，目前consumer-3332注册中心配置为nacos,consumer-3333注册中心配置为eureka

注册中心的调整在properties与pom文件中，如果想测试微服务集群与负载均衡，请先保持注册中心一致

4、配置中心（非必须）

spring-config: consumer-3333使用spring-config的代码片段已被屏蔽

nacos:也可以做配置中心，无需添加项目，consumer-nacos-config使用nacos作为配置中心，nacos具体配置可以百度

5、监控（非必须）
hystrix-dashboard，熔断监控可视化

# 测试
如果启动了网关zuul：
http://127.0.0.1:4444/consumer/findUserById?userId=1

如果未启动网关：
consumer-3332：http://127.0.0.1:3332/findUserById?userId=1
consumer-3333：http://127.0.0.1:3333/findUserById?userId=1

初次调用可能会用服务不通的情况






