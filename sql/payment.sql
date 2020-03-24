CREATE TABLE `t_payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `serial_number` varchar(32) DEFAULT NULL COMMENT '流水号',
  `pay_amount` decimal(10,0) DEFAULT NULL COMMENT '支付金额',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
