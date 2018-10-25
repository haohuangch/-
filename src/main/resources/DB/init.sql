
DROP TABLE IF EXISTS `account_info`;
CREATE TABLE `account_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(12) NOT NULL COMMENT '用户名',
  `phone` varchar(12) DEFAULT NULL COMMENT '手机号',
  `login_pwd` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `privilege` int(4) NOT NULL COMMENT '权限',
  `loginpwd_modify_time` datetime DEFAULT NULL COMMENT '上次登录密码修改时间',
  `regist_time` datetime DEFAULT NULL COMMENT '注册时间',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户账户信息';
select * from account_info;

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_id` bigint(20) unsigned NOT NULL COMMENT '账户id',
  `name` varchar(64) DEFAULT '' COMMENT '姓名',
  `id_number` varchar(64) DEFAULT '' COMMENT '身份证号码',
  `age` int(4) DEFAULT NULL COMMENT '年龄',
  `position` varchar(64) DEFAULT NULL COMMENT '职位',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modifier` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `modify_time` datetime DEFAULT NULL COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息';

DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_id` bigint(20) unsigned NOT NULL COMMENT '账户id',
  `type` varchar(64) DEFAULT '' COMMENT '类型',
  `discribe` varchar(512) DEFAULT '' COMMENT '描述',
  `status` int(4) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='事件';

DROP TABLE IF EXISTS `meal`;
CREATE TABLE `meal` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `event_id` bigint(20) unsigned NOT NULL COMMENT '事件id',
  `addr` varchar(128) DEFAULT '' COMMENT '地点',
  `partner` varchar(512) DEFAULT '' COMMENT '人物',
  `food` varchar(512) DEFAULT '' COMMENT '食物',
  `feeling` varchar(512) DEFAULT '' COMMENT '体验',
  `cost` int(10) NOT NULL comment '花费',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='饮食';
select * from meal;

DROP TABLE IF EXISTS `travel`;
CREATE TABLE `travel` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `event_id` bigint(20) unsigned NOT NULL COMMENT '事件id',
  `start` varchar(128) DEFAULT '' COMMENT '出发地点',
  `destination` varchar(128) DEFAULT '' COMMENT '目的地',
  `partner` varchar(512) DEFAULT '' COMMENT '人物',
  `feeling` varchar(512) DEFAULT '' COMMENT '体验',
  `cost` int(10) NOT NULL comment '花费',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出行';

DROP TABLE IF EXISTS `medical_treatment`;
CREATE TABLE `medical_treatment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `event_id` bigint(20) unsigned NOT NULL COMMENT '事件id',
  `addr` varchar(128) DEFAULT '' COMMENT '地点',
  `hospital` varchar(128) DEFAULT '' COMMENT '医院',
  `disease` varchar(128) DEFAULT '' COMMENT '病症',
  `feeling` varchar(512) DEFAULT '' COMMENT '体验',
  `cost` int(10) NOT NULL comment '花费',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医疗';


DROP TABLE IF EXISTS `learning`;
CREATE TABLE `learning` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `event_id` bigint(20) unsigned NOT NULL COMMENT '事件id',
  `addr` varchar(128) DEFAULT '' COMMENT '地点',
  `content` varchar(128) DEFAULT '' COMMENT '内容',
  `during` varchar(64) DEFAULT '' COMMENT '时长',
  `feeling` varchar(512) DEFAULT '' COMMENT '体验',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学习';


DROP TABLE IF EXISTS `sport`;
CREATE TABLE `sport` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `event_id` bigint(20) unsigned NOT NULL COMMENT '事件id',
  `addr` varchar(128) DEFAULT '' COMMENT '地点',
  `item` varchar(128) DEFAULT '' COMMENT '项目',
  `partner` varchar(128) DEFAULT '' COMMENT '人物',
  `during` varchar(64) DEFAULT '' COMMENT '时长',
  `feeling` varchar(512) DEFAULT '' COMMENT '体验',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运动';


DROP TABLE IF EXISTS `sleeping`;
CREATE TABLE `sleeping` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `event_id` bigint(20) unsigned NOT NULL COMMENT '事件id',
  `addr` varchar(128) DEFAULT '' COMMENT '地点',
  `during` varchar(64) DEFAULT '' COMMENT '时长',
  `feeling` varchar(512) DEFAULT '' COMMENT '质量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='睡眠';


DROP TABLE IF EXISTS `working`;
CREATE TABLE `working` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `event_id` bigint(20) unsigned NOT NULL COMMENT '事件id',
  `addr` varchar(128) DEFAULT '' COMMENT '地点',
  `content` varchar(128) DEFAULT '' COMMENT '内容',
  `during` varchar(64) DEFAULT '' COMMENT '时长',
  `feeling` varchar(512) DEFAULT '' COMMENT '体验',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作';

DROP TABLE IF EXISTS `consumption`;
CREATE TABLE `consumption` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `event_id` bigint(20) unsigned NOT NULL COMMENT '事件id',
  `type` varchar(128) DEFAULT '' COMMENT '消费类型',
  `addr` varchar(128) DEFAULT '' COMMENT '地点',
  `cost` int(10) NOT NULL comment '花费',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消费';


