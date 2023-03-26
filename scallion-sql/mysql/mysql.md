## mysql
## 创建用户
GRANT USAGE ON *.* TO 'scallion'@'%' IDENTIFIED BY 'scallion2022' WITH GRANT OPTION;
GRANT ALL PRIVILEGES on *.* to 'scallion'@'%' IDENTIFIED BY 'scallion2022';
FLUSH PRIVILEGES;

## 高版本创建用户
- 创建用户配置密码
    CREATE USER 'scallion'@'%' IDENTIFIED BY 'scallion2022';
- 分配权限
    GRANT ALL PRIVILEGES ON *.* TO 'scallion'@'%' WITH GRANT OPTION;
- 刷新
  FLUSH PRIVILEGES;    
