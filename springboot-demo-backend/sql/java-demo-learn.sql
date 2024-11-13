/*
 Navicat Premium Data Transfer

 Source Server         : localhost_mysql
 Source Server Type    : MySQL
 Source Server Version : 80040 (8.0.40)
 Source Host           : localhost:3306
 Source Schema         : java-demo-learn

 Target Server Type    : MySQL
 Target Server Version : 80040 (8.0.40)
 File Encoding         : 65001

 Date: 30/10/2024 15:06:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` bigint NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1851507025215893506, '李四', 1, '1235512', '安徽宣城');
INSERT INTO `user` VALUES (1851507155885240322, '王五1', 1, '1235234512', '广州武汉');
INSERT INTO `user` VALUES (1851507156472442881, '王五2', 0, '1235234512', '广州武汉');
INSERT INTO `user` VALUES (1851507157185474562, '王五3', 1, '1235234512', '广州武汉');
INSERT INTO `user` VALUES (1851507157827203073, '王五4', 0, '1235234512', '广州武汉');
INSERT INTO `user` VALUES (1851507158540234753, '王五5', 1, '1235234512', '广州武汉');
INSERT INTO `user` VALUES (1851507159060328450, '王五6', 0, '1235234512', '广州武汉');
INSERT INTO `user` VALUES (1851507159651725314, '王五7', 1, '1235234512', '广州武汉');
INSERT INTO `user` VALUES (1851507189947183105, '浪费五1', 0, '1235234512', '广州武汉');
INSERT INTO `user` VALUES (1851507190656020482, '浪费五2', 1, '1235234512', '广州武汉');
INSERT INTO `user` VALUES (1851507191243223041, '浪费五3', 1, '1235234512', '广州武汉');
INSERT INTO `user` VALUES (1851507191826231298, '浪费五4', 0, '1235234512', '广州武汉');

SET FOREIGN_KEY_CHECKS = 1;
