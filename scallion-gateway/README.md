# scallion-gateway

此项目为网关项目,所有前端通过网关对接其他项目

## e.g

通过gateway访问web-example,
路由配置于scallion-gateway-discovery项目中application.properties

http://localhost:18080/example/example/nacos 
    将会路由到http://localhost:8081/example/nacos


