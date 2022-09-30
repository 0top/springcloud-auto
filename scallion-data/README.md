# scallion-data

此模块主要包含各种数据生成
通过程序生成数据
并将数据通过rabbitmq,rocketmq,kafka,websocket等方式发送出去

## 饼

对于java来讲,处理大批量数据要用到大数据，不过我们数据量应该达不到
所以后面会添加关于pandas的处理。

## rabbitmq安装

安装前需要先安装erlang:  
[erlang](https://www.erlang.org/downloads)

配置环境变量： ERLANG_HOME=D:\develop-tool\erlang\erl-24.1

[匹配erlang和rabbitmq版本](https://rabbitmq.com/which-erlang.html)

[rabbitmq下载](https://rabbitmq.com/install-windows.html)
https://github.com/rabbitmq/rabbitmq-server/releases

```
./rabbitmq-plugins.bat enable.bat rabbitmq_management
./rabbitmq-server.bat start
```

