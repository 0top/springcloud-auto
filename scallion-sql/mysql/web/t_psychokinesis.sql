CREATE TABLE `t_sentence` (
                              `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                              `user_id` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户id',
                              `sentence` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文字',
                              `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='发布文字表';

CREATE TABLE `t_sentence_operate` (
                                      `id` bigint NOT NULL COMMENT '主键',
                                      `sentence_id` int NOT NULL COMMENT '一句话id',
                                      `user_id` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户id',
                                      `operate_type` tinyint DEFAULT NULL COMMENT '操作类型：1:赞',
                                      `operate_value` tinyint DEFAULT NULL COMMENT '操作值',
                                      `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                      `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `t_sentence_comment` (
                                      `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                                      `sentence_id` int NOT NULL COMMENT '一句话id',
                                      `user_id` int DEFAULT NULL COMMENT '用户id',
                                      `comment` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '评论',
                                      `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                      `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='一句话评论';

CREATE TABLE `t_sentence_commont_operate` (
                                              `id` bigint NOT NULL COMMENT '主键',
                                              `comment_id` int NOT NULL COMMENT '评论id',
                                              `user_id` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户Id',
                                              `operate_type` tinyint DEFAULT NULL COMMENT '评论操作类型',
                                              `operate_value` tinyint DEFAULT NULL COMMENT '评论操作值',
                                              `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                              `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='评论操作表';

