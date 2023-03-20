CREATE TABLE `t_sentence` (
                              `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                              `user_id` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户id',
                              `sentence` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文字',
                              `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='发布文字表';