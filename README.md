# springcloud-scallion

使用nacos做服务发现,gateway的springcloud项目

# 技术栈

- base:
    java11
    springboot
    springcloud
    mybatis

- task:
    [ ] dag
    [ ] springbatch

- data:
    [ ] elasticseach
    [ ] flink
    [ ] clinkhouse
    [ ] mongodb

- queue:
    [x] rabbitmq
    [ ] kafka
    [ ] disruptor
  
- other:
    [x] swagger
  
- docker：
    [ ] docker-compose

## 规划

[x] 网关
[ ] 任务(含依赖任务)

## nginx 

- 负载均衡： nignx中的upstream有个backup实现

## spring-cloud-alibaba

nacos-server: 1.4.2
    需要使用spring-cloud.alibaba.version=2.2.6.RELEASE
    2.2.7.RELEASE 则对应nacos客户端2.x版本,主要是gRPC协议更新影响