/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : jiangli

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-07-16 16:14:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuphone` varchar(255) NOT NULL,
  `worphone` varchar(255) DEFAULT NULL,
  `location` varchar(255) NOT NULL,
  `studate` varchar(30) DEFAULT NULL,
  `wordate` varchar(30) DEFAULT NULL,
  `grade` varchar(10) DEFAULT NULL,
  `reply` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `miao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES ('24', '13672247121', '13672247121', '三教机房301', '2016-07-14', '2016-07-14', null, '维修工特别好', '已完成', '空调坏了，快点维修，热死了');
INSERT INTO `repair` VALUES ('25', '13672247121', '13672247121', '教工寝室9栋', '2016-07-14', '2016-07-14', null, '维修的十分仔细，对细节的处理十分好', '已完成', '卧室漏水，十分严重');
INSERT INTO `repair` VALUES ('26', '13672247121', '13672247121', '教工寝室9栋', '2016-07-14', '2016-07-14', null, '王包成人非常好', '已完成', '卧室漏水，十分严重');
INSERT INTO `repair` VALUES ('27', '123456789', '13672247121', '篮球场旁', '2016-07-14', '2016-07-15', null, null, '维修中', '漏水');
INSERT INTO `repair` VALUES ('28', '13672247121', '13672247121', '一教204', '2016-07-14', '2016-07-15', null, '维修工人特别好，维修十分的仔细', '已完成', '没电');
INSERT INTO `repair` VALUES ('29', '13672247121', '13672247121', '二食堂', '2016-07-15', '2016-07-15', null, null, '维修中', '二食堂中央空调损坏');
INSERT INTO `repair` VALUES ('30', '13672247121', null, '', '2016-07-15', null, null, null, '待修', '');
INSERT INTO `repair` VALUES ('31', '13672247121', null, '', '2016-07-15', null, null, null, '待修', '');
INSERT INTO `repair` VALUES ('32', '13672247121', null, '', '2016-07-15', null, null, null, '待修', '');
INSERT INTO `repair` VALUES ('33', '13672247121', null, '二教机房', '2016-07-16', null, null, null, '待修', '二教机房01号电脑黑屏，无法使用');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('14', '毛卫俊', '13672247121', '1995');
INSERT INTO `student` VALUES ('15', '章建星', '13658204547', 'wssb');
INSERT INTO `student` VALUES ('16', '朱哥', '123456789', 'wssg');
INSERT INTO `student` VALUES ('17', '', '', '');
INSERT INTO `student` VALUES ('18', '', '', '');

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES ('1', '毛卫俊', '13672247121', '1995');
INSERT INTO `worker` VALUES ('2', '辛军有', '123456', '123456');
