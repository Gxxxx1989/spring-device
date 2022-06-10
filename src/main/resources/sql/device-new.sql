/*
 Navicat Premium Data Transfer

 Source Server         : 本地库
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : device

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 11/06/2022 03:45:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for agent
-- ----------------------------
DROP TABLE IF EXISTS `agent`;
CREATE TABLE `agent`  (
  `id` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '代理商户名称',
  `code` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '代理商编码',
  `address` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL COMMENT '代理商地址',
  `contact_person` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '联系人',
  `device_count` int(11) NULL DEFAULT NULL COMMENT '设备数量',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '数据版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of agent
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单地址',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) NULL DEFAULT NULL COMMENT '版本号',
  `parent_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父菜单',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('E-1654886406287-ef79f2c3443d4ccf', 'menu1', '/menu1', '2022-06-10 18:40:06', '2022-06-10 18:40:06', 0, NULL);
INSERT INTO `menu` VALUES ('E-1654886462706-23d166b0f5844e29', 'menu2', '/menu2', '2022-06-10 18:41:03', '2022-06-10 18:41:03', 0, NULL);
INSERT INTO `menu` VALUES ('E-1654886488143-d4b2dc973d6c4df6', 'menu3', '/menu3', '2022-06-10 18:41:28', '2022-06-10 18:41:28', 0, NULL);
INSERT INTO `menu` VALUES ('E-1654886515961-7912625377124156', 'menu4', '/menu4', '2022-06-10 18:41:56', '2022-06-10 18:41:56', 0, NULL);
INSERT INTO `menu` VALUES ('E-1654886600539-490d6d80bd6e4553', 'menu5', '/menu5', '2022-06-10 18:43:21', '2022-06-10 18:43:21', 0, NULL);
INSERT INTO `menu` VALUES ('E-1654887362373-0f06a9be77a34945', 'menu6', '/menu6', '2022-06-10 18:56:02', '2022-06-10 18:56:02', 0, NULL);
INSERT INTO `menu` VALUES ('E-1654887523360-6d5471e971d54c5c', 'menu7', '/menu7', '2022-06-10 18:58:43', '2022-06-10 18:58:43', 0, NULL);
INSERT INTO `menu` VALUES ('E-1654887539719-72673d1204fd4e7d', 'menu8', '/menu8', '2022-06-10 18:59:00', '2022-06-10 18:59:00', 0, NULL);
INSERT INTO `menu` VALUES ('E-1654887759848-7c8dbb9f4f324c90', 'menu8', '/menu8', '2022-06-10 19:02:40', '2022-06-10 19:02:40', 0, NULL);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键',
  `order_no` varchar(80) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '订单号',
  `order_content` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL COMMENT '订单内容',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单价格',
  `pay_status` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '付款状态',
  `order_status` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '订单状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '数据版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标题',
  `action` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限动作',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '数据版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '数据版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('O-1654768732954-601ce950c9314ff5', '普通用户', '1', '2022-06-09 09:58:53', '2022-06-09 09:58:53', 0);
INSERT INTO `role` VALUES ('O-1654768741580-d07b7034ad6546e9', '管理员', '1', '2022-06-09 09:59:02', '2022-06-09 09:59:02', 0);
INSERT INTO `role` VALUES ('O-1654768749063-04e947595e554936', '经销商', '1', '2022-06-09 09:59:09', '2022-06-09 09:59:09', 0);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '数据版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `id` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键',
  `code` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '门店编码',
  `address` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL COMMENT '门店地址',
  `contact_person` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '联系人',
  `agent_id` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属代理商id',
  `device_count` int(11) NULL DEFAULT NULL COMMENT '设备数量',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '数据版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '数据版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('S-1654842837715-ebc5da411ed948f1', 'guoxi', '$2a$10$wtb4jgOXWqltpFCxLNXy0OzlFUin625dQClATKB3nwEwYVQIDy3zC', '1', '2022-06-10 06:33:58', '2022-06-10 06:33:58', 0);
INSERT INTO `user` VALUES ('S-1654885360975-f9d4e84b08014473', 'guoxi1', '$2a$10$/sAGL.ZRcvZIKRF2Cw/LpOytO8O8PzGd8/F3zh9r9I6nmXxeSGiJi', '1', '2022-06-10 18:22:41', '2022-06-10 18:22:41', 0);
INSERT INTO `user` VALUES ('S-1654885384484-0e156e35a7854c9c', 'guoxi2', '$2a$10$Mj59TJsE/SAaoT0f7qwB/.bsJar6hEQ/cMSAH3lYOVPPESM2BWSCK', '1', '2022-06-10 18:23:04', '2022-06-10 18:23:04', 0);
INSERT INTO `user` VALUES ('S-1654885396375-a3cd04b6a9254375', 'guoxi3', '$2a$10$L0kwbRvb0cMvAO53J/j5cOVeFsh/10pcNHH2FvXyQImT4nrvbvdUS', '1', '2022-06-10 18:23:16', '2022-06-10 18:23:16', 0);
INSERT INTO `user` VALUES ('S-1654887351908-30ab185b1a92432b', 'guoxi4', '$2a$10$a1sPEn91nDNSIpmHdMrmuOlKhUZKgn7SxH70v9KPFzqKtEym/exBu', '1', '2022-06-10 18:55:52', '2022-06-10 18:55:52', 0);
INSERT INTO `user` VALUES ('S-1654887682524-d8a628090144470f', 'guoxi5', '$2a$10$BLClVc0GGLAP6pTwtkeJnuMbexYohOzs6lkE0LICjCUAg3fH1QEFq', '1', '2022-06-10 19:01:23', '2022-06-10 19:01:23', 0);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '数据版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
