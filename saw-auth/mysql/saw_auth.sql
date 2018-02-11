/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : saw_auth

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-02-11 15:04:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auth_permission
-- ----------------------------
DROP TABLE IF EXISTS `auth_permission`;
CREATE TABLE `auth_permission` (
  `auth_permission_id` varchar(36) NOT NULL,
  `name` varchar(12) DEFAULT NULL,
  `desc` varchar(100) DEFAULT NULL,
  `pid` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`auth_permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_permission
-- ----------------------------
INSERT INTO `auth_permission` VALUES ('a0b6b9eb60344129997c34f2ffbf1134', 'ADMIN', 'admin', null);
INSERT INTO `auth_permission` VALUES ('ee56a6303a1f44f581cfec69d3da1007', 'USER', 'shanlehong', null);

-- ----------------------------
-- Table structure for auth_permission_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_permission_role`;
CREATE TABLE `auth_permission_role` (
  `auth_permission_role_id` varchar(36) NOT NULL,
  `auth_permission_id` varchar(36) DEFAULT NULL,
  `auth_role_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`auth_permission_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_permission_role
-- ----------------------------
INSERT INTO `auth_permission_role` VALUES ('5621deff76544c9c8a01191104e3cb9e', 'a0b6b9eb60344129997c34f2ffbf1134', '2f16f4ae04744ead80e97eb1fdeccf90');
INSERT INTO `auth_permission_role` VALUES ('b6e8b63f070f4640a15c404ea6753226', 'ee56a6303a1f44f581cfec69d3da1007', '89169cc095ad4a02ba0359f4d86a7774');

-- ----------------------------
-- Table structure for auth_resource
-- ----------------------------
DROP TABLE IF EXISTS `auth_resource`;
CREATE TABLE `auth_resource` (
  `auth_resource_id` varchar(36) NOT NULL,
  `url` varchar(1021) NOT NULL COMMENT '资源URL',
  PRIMARY KEY (`auth_resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_resource
-- ----------------------------
INSERT INTO `auth_resource` VALUES ('3d372f6d4d424595b50ffa50a59ff5e4', '/admin');
INSERT INTO `auth_resource` VALUES ('f9963f7e507d487aba30e778831c52a3', '/');

-- ----------------------------
-- Table structure for auth_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role` (
  `auth_role_id` varchar(36) DEFAULT NULL,
  `name` varchar(12) DEFAULT NULL COMMENT '角色名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_role
-- ----------------------------
INSERT INTO `auth_role` VALUES ('2f16f4ae04744ead80e97eb1fdeccf90', 'ROLE_ADMIN');
INSERT INTO `auth_role` VALUES ('89169cc095ad4a02ba0359f4d86a7774', 'ROLE_USER');

-- ----------------------------
-- Table structure for auth_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_resource`;
CREATE TABLE `auth_role_resource` (
  `auth_role_resource_id` varchar(36) NOT NULL,
  `auth_role_id` varchar(36) NOT NULL,
  `auth_resource_id` varchar(36) NOT NULL,
  PRIMARY KEY (`auth_role_resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_role_resource
-- ----------------------------
INSERT INTO `auth_role_resource` VALUES ('9c2a8275d8364b29a8723b73af6087d8', '2f16f4ae04744ead80e97eb1fdeccf90', '3d372f6d4d424595b50ffa50a59ff5e4');
INSERT INTO `auth_role_resource` VALUES ('b378fe58dcf74485ace7a21501381e44', '89169cc095ad4a02ba0359f4d86a7774', 'f9963f7e507d487aba30e778831c52a3');

-- ----------------------------
-- Table structure for auth_role_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_user`;
CREATE TABLE `auth_role_user` (
  `auth_role_user_id` varchar(36) NOT NULL,
  `auth_user_id` varchar(36) DEFAULT NULL,
  `auth_role_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`auth_role_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_role_user
-- ----------------------------
INSERT INTO `auth_role_user` VALUES ('06e42d754bf94c54a79a094a22b73a3f', '35e4ba285c104b3597b8527cc1fc69cf', '2f16f4ae04744ead80e97eb1fdeccf90');
INSERT INTO `auth_role_user` VALUES ('61083f5243944e5287e79df7f26dbfe3', '0c3d3b7162af47fb8d5980c150ddcd2e', '89169cc095ad4a02ba0359f4d86a7774');

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user` (
  `auth_user_id` varchar(36) NOT NULL COMMENT '主键',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(12) DEFAULT NULL COMMENT '用户密码',
  `creater_id` varchar(20) DEFAULT NULL COMMENT '创建ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater_id` varchar(20) DEFAULT NULL COMMENT '更新者ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  `delete_flag` tinyint(4) DEFAULT NULL COMMENT '删除标识 0未删除 1已删除',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`auth_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user` VALUES ('0c3d3b7162af47fb8d5980c150ddcd2e', 'shanlehong', '123456', 'system', '2018-02-08 13:28:26', null, null, '1', '0', null);
INSERT INTO `auth_user` VALUES ('35e4ba285c104b3597b8527cc1fc69cf', 'admin', 'admin', 'system', '2018-02-09 11:46:37', null, null, '1', '0', null);
