/*
 Navicat Premium Data Transfer

 Source Server         : lym
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : kafkatest

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 08/09/2021 11:16:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for stu_info
-- ----------------------------
DROP TABLE IF EXISTS `stu_info`;
CREATE TABLE `stu_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `score` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '2k评分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_info
-- ----------------------------
INSERT INTO `stu_info` VALUES (1, '库里', 33, '110', '98');
INSERT INTO `stu_info` VALUES (2, '詹姆斯', 36, '120', '97');
INSERT INTO `stu_info` VALUES (3, '保罗', 36, '130', '90');
INSERT INTO `stu_info` VALUES (4, '科比', 43, '140', '99');
INSERT INTO `stu_info` VALUES (5, '奥尼尔', 44, '150', '98');
INSERT INTO `stu_info` VALUES (6, '哈登', 30, '160', '97');
INSERT INTO `stu_info` VALUES (7, '欧文', 30, '170', '96');
INSERT INTO `stu_info` VALUES (8, '利拉德', 33, '180', '96');
INSERT INTO `stu_info` VALUES (9, '字母哥', 26, '190', '92');
INSERT INTO `stu_info` VALUES (10, '维斯布鲁克', 33, '200', '94');
INSERT INTO `stu_info` VALUES (11, '杜兰特', 33, '210', '97');

-- ----------------------------
-- Table structure for stu_info_copy
-- ----------------------------
DROP TABLE IF EXISTS `stu_info_copy`;
CREATE TABLE `stu_info_copy`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_info_copy
-- ----------------------------
INSERT INTO `stu_info_copy` VALUES (1, '库里', '98');
INSERT INTO `stu_info_copy` VALUES (2, '詹姆斯', '97');
INSERT INTO `stu_info_copy` VALUES (3, '保罗', '90');
INSERT INTO `stu_info_copy` VALUES (4, '科比', '99');
INSERT INTO `stu_info_copy` VALUES (5, '奥尼尔', '98');
INSERT INTO `stu_info_copy` VALUES (6, '哈登', '97');
INSERT INTO `stu_info_copy` VALUES (7, '欧文', '96');
INSERT INTO `stu_info_copy` VALUES (8, '利拉德', '96');
INSERT INTO `stu_info_copy` VALUES (9, '字母哥', '92');
INSERT INTO `stu_info_copy` VALUES (10, '维斯布鲁克', '94');
INSERT INTO `stu_info_copy` VALUES (11, '杜兰特', '97');

SET FOREIGN_KEY_CHECKS = 1;
