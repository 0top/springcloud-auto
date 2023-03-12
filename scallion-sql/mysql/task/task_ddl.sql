-- 定时任务表
CREATE TABLE `t_schedule_task` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT 'Id',
    `task_id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
    `task_name` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;







