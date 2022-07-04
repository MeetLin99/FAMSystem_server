/*
 Navicat Premium Data Transfer

 Source Server         : MyDatabase
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : famsystem

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 04/07/2022 12:53:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ADMINNAME` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ADMINPASSWORD` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ADMINSTATUS` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123456', '1');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NEWSABSTRACT` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TEXT` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `RELEASDATE` date NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, '修改标题', '改一改', '<p>测试内容111111</p>', '2022-06-09');
INSERT INTO `news` VALUES (2, '测试标题2', '测试摘要2', '<p>测试正文2</p>', '2020-02-18');
INSERT INTO `news` VALUES (3, '测试标题3', '测试摘要3', '<p>测试正文3</p>', '2020-02-18');
INSERT INTO `news` VALUES (4, '测试标题4', '测试摘要4', '<p>测试正文4</p>', '2020-02-18');
INSERT INTO `news` VALUES (5, '测试标题5', '测试摘要5', '<p>测试正文6</p>', '2020-02-18');
INSERT INTO `news` VALUES (6, '测试标题01', '测试摘要01', '<p>测试正文01</p>', '2020-02-18');
INSERT INTO `news` VALUES (7, '测试标题02', '测试摘要02', '<p>测试正文02</p>', '2020-02-18');
INSERT INTO `news` VALUES (8, '测试标题03', '测试摘要03', '<p>测试正文03</p>', '2020-02-18');
INSERT INTO `news` VALUES (9, '测试标题04', '测试摘要04', '<p>测试正文04</p>', '2020-02-18');
INSERT INTO `news` VALUES (13, '开心', '学习是开心的', '我们很忙开发项目', '2022-06-09');
INSERT INTO `news` VALUES (14, '水土不服', '回大沈阳', '<p>坚持住，因为大家也在坚持</p>', '2022-06-09');
INSERT INTO `news` VALUES (15, '测试标题00000', '回大沈阳000000', '<p>坚持住，因为大家也在坚持00000</p>', '2022-06-09');

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock`  (
  `stockno` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ammount` int(11) NULL DEFAULT NULL,
  `batch` int(25) NULL DEFAULT NULL,
  PRIMARY KEY (`stockno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES (1, '芬达', '汽水饮料', 200, 22070201);
INSERT INTO `stock` VALUES (3, '玩具汽车', '玩具', 400, 22070201);
INSERT INTO `stock` VALUES (4, '遥控小飞机', '玩具', 300, 22070201);
INSERT INTO `stock` VALUES (5, '小鸡爪', '零食食品', 500, 22070202);
INSERT INTO `stock` VALUES (6, '肥宅快乐水', '休闲食品', 550, 22070201);
INSERT INTO `stock` VALUES (7, '奔驰小模型', '玩具', 500, 22070401);

SET FOREIGN_KEY_CHECKS = 1;
