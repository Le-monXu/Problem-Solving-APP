/*
 Navicat Premium Data Transfer

 Source Server         : MySQL Java Web
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : cordova_app

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 23/06/2020 16:34:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answertable
-- ----------------------------
DROP TABLE IF EXISTS `answertable`;
CREATE TABLE `answertable`  (
  `aid` int(0) NOT NULL AUTO_INCREMENT,
  `uid` int(0) NOT NULL,
  `answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `qid` int(0) NOT NULL,
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `score` float NOT NULL,
  `support` int(0) NOT NULL,
  PRIMARY KEY (`aid`) USING BTREE,
  INDEX `uid_idx1`(`uid`) USING BTREE,
  INDEX `qid_idx`(`qid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for questiontable
-- ----------------------------
DROP TABLE IF EXISTS `questiontable`;
CREATE TABLE `questiontable`  (
  `qid` int(0) NOT NULL AUTO_INCREMENT,
  `uid` int(0) NOT NULL,
  `content` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `startTime` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `state` tinyint(1) NOT NULL,
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bestAnswer` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`qid`) USING BTREE,
  INDEX `uid_idx`(`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for scoretable
-- ----------------------------
DROP TABLE IF EXISTS `scoretable`;
CREATE TABLE `scoretable`  (
  `uid` int(0) NOT NULL,
  `aid` int(0) NOT NULL,
  `score` tinyint(0) NOT NULL,
  `isSupport` tinyint(1) NOT NULL,
  PRIMARY KEY (`uid`, `aid`) USING BTREE,
  INDEX `aid_idx`(`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for usertable
-- ----------------------------
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  `major` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
