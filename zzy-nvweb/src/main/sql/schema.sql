DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_uuid` varchar(32) NOT NULL,
  `name` varchar(22) NOT NULL COMMENT '账号',
  `password` varchar(55) DEFAULT NULL COMMENT '密码',
  `type` int(2) DEFAULT '0' COMMENT '用户类型:0:普通用户，1：管理员，2：超级管理员',
  `status` int(2) DEFAULT '1' COMMENT '状态:0:删除，1：正常',
  `sort` int(8) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_uid` varchar(32) DEFAULT NULL COMMENT '创建人uuid',
  `update_uid` varchar(32) DEFAULT NULL COMMENT '更新人uuid',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_uuid` (`user_uuid`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';


DROP TABLE IF EXISTS `novel`;
CREATE TABLE `novel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `novel_uuid` varchar(32) NOT NULL COMMENT '小说uuid',
  `name` varchar(50) NOT NULL COMMENT '小说名称',
  `url` varchar(1000) NOT NULL COMMENT '小说地址',
  `author` varchar(22) DEFAULT NULL COMMENT '作者',
  `intro` varchar(1000) DEFAULT NULL COMMENT '简介',
  `photo` varchar(500) DEFAULT NULL COMMENT '封面图片',
  `status` int(2) DEFAULT '1' COMMENT '状态:0:删除，1：正常',
  `sort` int(8) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_uid` varchar(32) NOT NULL COMMENT '创建人uuid',
  `update_uid` varchar(32) NOT NULL COMMENT '更新人uuid',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_novel_uuid` (`novel_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='小说表';



DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_uuid` varchar(32) NOT NULL,
  `content` varchar(1000) NOT NULL COMMENT '评论内容',
  `novel_uuid` varchar(32) NOT NULL COMMENT '评论的小说uuid',
  `usernum` int(3) DEFAULT '0' COMMENT '有用数',
  `status` int(2) DEFAULT '1' COMMENT '状态:0:删除，1：正常',
  `sort` int(8) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_uid` varchar(32) NOT NULL COMMENT '创建人uuid',
  `update_uid` varchar(32) NOT NULL COMMENT '更新人uuid',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_comment_uuid` (`comment_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';



DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_uuid` varchar(32) NOT NULL ,
  `name` varchar(50) NOT NULL COMMENT '电影名称',
  `url` varchar(1000) NOT NULL COMMENT '地址',
  `director` varchar(22) DEFAULT NULL COMMENT '导演',
  `screenwriter` varchar(100) DEFAULT NULL COMMENT '编剧',
  `starring` varchar(200) DEFAULT NULL COMMENT '主演',
  `intro` varchar(1000) DEFAULT NULL COMMENT '简介',
  `photo` varchar(500) DEFAULT NULL COMMENT '封面图片',
  `status` int(2) DEFAULT '1' COMMENT '状态:0:删除，1：正常',
  `sort` int(8) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_uid` varchar(32) NOT NULL COMMENT '创建人uuid',
  `update_uid` varchar(32) NOT NULL COMMENT '更新人uuid',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_movie_uuid` (`movie_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电影表';



DROP TABLE IF EXISTS `movie_comment`;
CREATE TABLE `movie_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_comment_uuid` varchar(32) NOT NULL,
  `content` varchar(1000) NOT NULL COMMENT '评论内容',
  `movie_uuid` varchar(32) NOT NULL COMMENT '评论的电影uuid',
  `usernum` int(3) DEFAULT '0' COMMENT '有用数',
  `status` int(2) DEFAULT '1' COMMENT '状态:0:删除，1：正常',
  `sort` int(8) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_uid` varchar(32) NOT NULL COMMENT '创建人uuid',
  `update_uid` varchar(32) NOT NULL COMMENT '更新人uuid',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_movie_comment_uuid` (`movie_comment_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电影评论表';