## 简介

web相关项目

## 模块

- web-example:  
     web项目demo项目  
- web-psychokinesis：   
    学习说,类似one,每天可以发指定主题的一句话，可进行点赞或排序  
    通过全局配置的任务进行统计更新，并将对应数据推送入库，进入数据池中 
- web-shop：
    所有商品管理项目，展示所有可交易商品  
    包含行情等  
    此项目中实现二阶段提交，通过seata完成事物管理

## 详细

### web-example

集成swagger
项目注册到nacos管理

### web-psychokinesis

- swagger
  http://127.0.0.1:8082/scallion/psychokinesis/swagger-ui/index.html#/

> 介绍  
  学习说,可以每日发一句话，会根据热度进行排名   
  通过redis进行每日热榜排名  
  到达一定程度会获得勋章

### web-shop

展示所有可售卖商品
- report    报告：每日总结，周报
- subscribe 订阅

### 分布式事务

1. web-shop模块可以展示所有可供订阅或交易的内容
   通过web-shop模块中积分或余额购买商品，由seate进行全局事务管控
   - web-shop下单
   - scallion-data-provider模块记录购买信息，并生成订阅链接
   - scallion-user进行积分扣款
   

### 数据

通过脚本预先插入数据

