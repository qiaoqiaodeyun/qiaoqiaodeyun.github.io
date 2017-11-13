/*
MySQL Data Transfer
Source Host: localhost
Source Database: dbo
Target Host: localhost
Target Database: dbo
Date: 2016/7/11 15:25:39
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for category
-- ----------------------------
CREATE TABLE `category` (
  `categoryid` varchar(20) NOT NULL,
  `categoryname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
CREATE TABLE `comment` (
  `Commentid` varchar(20) NOT NULL,
  `commentcontent` text,
  `createtime` date DEFAULT NULL,
  `userid` varchar(20) DEFAULT NULL,
  `newsid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Commentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for news
-- ----------------------------
CREATE TABLE `news` (
  `newsid` varchar(20) NOT NULL,
  `newstitle` varchar(100) DEFAULT NULL,
  `newscontent` text,
  `createdate` date DEFAULT NULL,
  `keyword` varchar(100) DEFAULT NULL,
  `categoryid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`newsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
CREATE TABLE `userinfo` (
  `userid` varchar(20) NOT NULL,
  `username` varchar(10) DEFAULT NULL,
  `userpassword` varchar(20) DEFAULT NULL,
  `userphone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
