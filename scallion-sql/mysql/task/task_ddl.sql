-- 定时任务表
CREATE TABLE `t_schedule_task` (
                                   `id` int NOT NULL AUTO_INCREMENT COMMENT 'Id',
                                   `task_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务id',
                                   `task_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '任务名称',
                                   `task_service` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '任务执行类',
                                   `params` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '任务参数',
                                   `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='定时任务表';

CREATE TABLE `t_schedule_job` (
                                  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                                  `job_id` int DEFAULT NULL,
                                  `cron` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
                                  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
                                  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;







