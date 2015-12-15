/*
Navicat MySQL Data Transfer

Source Server         : MysqlTest
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2015-12-10 13:20:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for scourse
-- ----------------------------
DROP TABLE IF EXISTS `scourse`;
CREATE TABLE `scourse` (
  `courseID` varchar(25) NOT NULL,
  `subject` varchar(25) DEFAULT NULL,
  `classyear` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scourse
-- ----------------------------
INSERT INTO `scourse` VALUES ('10101', '语文', '一年级上');
INSERT INTO `scourse` VALUES ('10102', '语文', '一年级下');
INSERT INTO `scourse` VALUES ('10201', '数学', '一年级上');
INSERT INTO `scourse` VALUES ('10202', '数学', '一年级下');
INSERT INTO `scourse` VALUES ('10301', '英语', '一年级上');
INSERT INTO `scourse` VALUES ('10302', '英语', '一年级下');
INSERT INTO `scourse` VALUES ('20101', '语文', '二年级上');
INSERT INTO `scourse` VALUES ('20102', '语文', '二年级下');
INSERT INTO `scourse` VALUES ('20201', '数学', '二年级上');
INSERT INTO `scourse` VALUES ('20202', '数学', '二年级下');
INSERT INTO `scourse` VALUES ('20301', '英语', '二年级上');
INSERT INTO `scourse` VALUES ('20302', '英语', '二年级下');
INSERT INTO `scourse` VALUES ('30101', '语文', '三年级上');
INSERT INTO `scourse` VALUES ('30102', '语文', '三年级下');
INSERT INTO `scourse` VALUES ('30201', '数学', '三年级上');
INSERT INTO `scourse` VALUES ('30202', '数学', '三年级下');
INSERT INTO `scourse` VALUES ('30301', '英语', '三年级上');
INSERT INTO `scourse` VALUES ('30302', '英语', '三年级下');
INSERT INTO `scourse` VALUES ('40101', '语文', '四年级上');
INSERT INTO `scourse` VALUES ('40102', '语文', '四年级下');
INSERT INTO `scourse` VALUES ('40201', '数学', '四年级上');
INSERT INTO `scourse` VALUES ('40202', '数学', '四年级下');
INSERT INTO `scourse` VALUES ('40301', '英语', '四年级上');
INSERT INTO `scourse` VALUES ('40302', '英语', '四年级下');
INSERT INTO `scourse` VALUES ('50101', '语文', '五年级上');
INSERT INTO `scourse` VALUES ('50102', '语文', '五年级下');
INSERT INTO `scourse` VALUES ('50201', '数学', '五年级上');
INSERT INTO `scourse` VALUES ('50202', '数学', '五年级下');
INSERT INTO `scourse` VALUES ('50301', '英语', '五年级上');
INSERT INTO `scourse` VALUES ('50302', '英语', '五年级下');
INSERT INTO `scourse` VALUES ('60101', '语文', '六年级上');
INSERT INTO `scourse` VALUES ('60102', '语文', '六年级下');
INSERT INTO `scourse` VALUES ('60201', '数学', '六年级上');
INSERT INTO `scourse` VALUES ('60202', '数学', '六年级下');
INSERT INTO `scourse` VALUES ('60301', '英语', '六年级上');
INSERT INTO `scourse` VALUES ('60302', '英语', '六年级下');

-- ----------------------------
-- Table structure for sscore
-- ----------------------------
DROP TABLE IF EXISTS `sscore`;
CREATE TABLE `sscore` (
  `studentID` varchar(25) NOT NULL,
  `courseID` varchar(25) NOT NULL,
  `testID` varchar(25) NOT NULL,
  `score` int(4) DEFAULT NULL,
  `PR` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sscore
-- ----------------------------
INSERT INTO `sscore` VALUES ('201401001', '30101', '20140001', '78', '63.1579');
INSERT INTO `sscore` VALUES ('201401001', '30101', '20140002', '80', '89.6226');
INSERT INTO `sscore` VALUES ('201401001', '30101', '20140003', '80', '84.1667');
INSERT INTO `sscore` VALUES ('201401001', '30101', '20140004', '80', '72.807');
INSERT INTO `sscore` VALUES ('201401001', '30101', '20140005', '66', '44');
INSERT INTO `sscore` VALUES ('201401001', '30201', '20140006', '70', '57.2581');
INSERT INTO `sscore` VALUES ('201401001', '30201', '20140007', '58', '39.2857');
INSERT INTO `sscore` VALUES ('201401001', '30201', '20140008', '86', '89.2857');
INSERT INTO `sscore` VALUES ('201401001', '30201', '20140009', '60', '27.8689');
INSERT INTO `sscore` VALUES ('201401001', '30201', '20140010', '74', '74.1667');
INSERT INTO `sscore` VALUES ('201401001', '30301', '20140011', '62', '36.2903');
INSERT INTO `sscore` VALUES ('201401001', '30301', '20140012', '62', '69.2308');
INSERT INTO `sscore` VALUES ('201401001', '30301', '20140013', '66', '37.7193');
INSERT INTO `sscore` VALUES ('201401001', '30301', '20140014', '76', '63');
INSERT INTO `sscore` VALUES ('201401001', '30301', '20140015', '60', '59.434');
INSERT INTO `sscore` VALUES ('201401002', '30101', '20140001', '85', '96.4912');
INSERT INTO `sscore` VALUES ('201401002', '30101', '20140002', '45', '42.5926');
INSERT INTO `sscore` VALUES ('201401002', '30101', '20140003', '28', '15.5405');
INSERT INTO `sscore` VALUES ('201401002', '30101', '20140004', '76', '59.2593');
INSERT INTO `sscore` VALUES ('201401002', '30101', '20140005', '32', '22.973');
INSERT INTO `sscore` VALUES ('201401002', '30201', '20140006', '78', '62.2807');
INSERT INTO `sscore` VALUES ('201401002', '30201', '20140007', '54', '54.2553');
INSERT INTO `sscore` VALUES ('201401002', '30201', '20140008', '72', '46.2963');
INSERT INTO `sscore` VALUES ('201401002', '30201', '20140009', '72', '49.1228');
INSERT INTO `sscore` VALUES ('201401002', '30201', '20140010', '85', '92.5532');
INSERT INTO `sscore` VALUES ('201401002', '30301', '20140011', '85', '96.4912');
INSERT INTO `sscore` VALUES ('201401002', '30301', '20140012', '25', '11.7021');
INSERT INTO `sscore` VALUES ('201401002', '30301', '20140013', '45', '39.3617');
INSERT INTO `sscore` VALUES ('201401002', '30301', '20140014', '45', '39.3617');
INSERT INTO `sscore` VALUES ('201401002', '30301', '20140015', '70', '81.5789');
INSERT INTO `sscore` VALUES ('201401003', '30101', '20140001', '85', '96.4912');
INSERT INTO `sscore` VALUES ('201401003', '30101', '20140002', '45', '42.5926');
INSERT INTO `sscore` VALUES ('201401003', '30101', '20140003', '28', '15.5405');
INSERT INTO `sscore` VALUES ('201401003', '30101', '20140004', '76', '59.2593');
INSERT INTO `sscore` VALUES ('201401003', '30101', '20140005', '32', '22.973');
INSERT INTO `sscore` VALUES ('201401003', '30201', '20140006', '78', '62.2807');
INSERT INTO `sscore` VALUES ('201401003', '30201', '20140007', '54', '54.2553');
INSERT INTO `sscore` VALUES ('201401003', '30201', '20140008', '72', '46.2963');
INSERT INTO `sscore` VALUES ('201401003', '30201', '20140009', '72', '49.1228');
INSERT INTO `sscore` VALUES ('201401003', '30201', '20140010', '85', '92.5532');
INSERT INTO `sscore` VALUES ('201401003', '30301', '20140011', '85', '96.4912');
INSERT INTO `sscore` VALUES ('201401003', '30301', '20140012', '25', '11.7021');
INSERT INTO `sscore` VALUES ('201401003', '30301', '20140013', '45', '39.3617');
INSERT INTO `sscore` VALUES ('201401003', '30301', '20140014', '45', '39.3617');
INSERT INTO `sscore` VALUES ('201401003', '30301', '20140015', '70', '81.5789');
INSERT INTO `sscore` VALUES ('201401004', '30101', '20140001', '60', '17.7419');
INSERT INTO `sscore` VALUES ('201401004', '30101', '20140002', '64', '25');
INSERT INTO `sscore` VALUES ('201401004', '30101', '20140003', '85', '96.4912');
INSERT INTO `sscore` VALUES ('201401004', '30101', '20140004', '76', '49.1803');
INSERT INTO `sscore` VALUES ('201401004', '30101', '20140005', '90', '33.3333');
INSERT INTO `sscore` VALUES ('201401004', '30201', '20140006', '45', '42.5926');
INSERT INTO `sscore` VALUES ('201401004', '30201', '20140007', '90', '77.5');
INSERT INTO `sscore` VALUES ('201401004', '30201', '20140008', '68', '44.5');
INSERT INTO `sscore` VALUES ('201401004', '30201', '20140009', '78', '59');
INSERT INTO `sscore` VALUES ('201401004', '30201', '20140010', '78', '75');
INSERT INTO `sscore` VALUES ('201401004', '30301', '20140011', '78', '63.1579');
INSERT INTO `sscore` VALUES ('201401004', '30301', '20140012', '85', '74');
INSERT INTO `sscore` VALUES ('201401004', '30301', '20140013', '58', '43.8462');
INSERT INTO `sscore` VALUES ('201401004', '30301', '20140014', '72', '86.0656');
INSERT INTO `sscore` VALUES ('201401004', '30301', '20140015', '80', '89.6226');
INSERT INTO `sscore` VALUES ('201401005', '30101', '20140001', '80', '84.1667');
INSERT INTO `sscore` VALUES ('201401005', '30101', '20140002', '80', '88.4615');
INSERT INTO `sscore` VALUES ('201401005', '30101', '20140003', '54', '62.3288');
INSERT INTO `sscore` VALUES ('201401005', '30101', '20140004', '62', '26.3636');
INSERT INTO `sscore` VALUES ('201401005', '30101', '20140005', '72', '40.9091');
INSERT INTO `sscore` VALUES ('201401005', '30201', '20140006', '76', '43.8596');
INSERT INTO `sscore` VALUES ('201401005', '30201', '20140007', '28', '15.5405');
INSERT INTO `sscore` VALUES ('201401005', '30201', '20140008', '76', '59.2593');
INSERT INTO `sscore` VALUES ('201401005', '30201', '20140009', '60', '54.918');
INSERT INTO `sscore` VALUES ('201401005', '30201', '20140010', '32', '10.4839');
INSERT INTO `sscore` VALUES ('201401005', '30301', '20140011', '55', '37.5');
INSERT INTO `sscore` VALUES ('201401005', '30301', '20140012', '60', '48.3333');
INSERT INTO `sscore` VALUES ('201401005', '30301', '20140013', '70', '72.5');
INSERT INTO `sscore` VALUES ('201401005', '30301', '20140014', '65', '52.9412');
INSERT INTO `sscore` VALUES ('201401005', '30301', '20140015', '80', '72.807');
INSERT INTO `sscore` VALUES ('201401006', '30101', '20140001', '66', '44');
INSERT INTO `sscore` VALUES ('201401006', '30101', '20140002', '66', '32.7869');
INSERT INTO `sscore` VALUES ('201401006', '30101', '20140003', '80', '77.5');
INSERT INTO `sscore` VALUES ('201401006', '30101', '20140004', '60', '25');
INSERT INTO `sscore` VALUES ('201401006', '30101', '20140005', '62', '33.0645');
INSERT INTO `sscore` VALUES ('201401006', '30201', '20140006', '50', '34.6774');
INSERT INTO `sscore` VALUES ('201401006', '30201', '20140007', '70', '57.2581');
INSERT INTO `sscore` VALUES ('201401006', '30201', '20140008', '58', '39.2857');
INSERT INTO `sscore` VALUES ('201401006', '30201', '20140009', '76', '62.6984');
INSERT INTO `sscore` VALUES ('201401006', '30201', '20140010', '90', '95.3125');
INSERT INTO `sscore` VALUES ('201401006', '30301', '20140011', '86', '89.2857');
INSERT INTO `sscore` VALUES ('201401006', '30301', '20140012', '60', '27.8689');
INSERT INTO `sscore` VALUES ('201401006', '30301', '20140013', '76', '57.377');
INSERT INTO `sscore` VALUES ('201401006', '30301', '20140014', '100', '99.0741');
INSERT INTO `sscore` VALUES ('201401006', '30301', '20140015', '100', '96.7213');
INSERT INTO `sscore` VALUES ('201401007', '30101', '20140001', '48', '9.64912');
INSERT INTO `sscore` VALUES ('201401007', '30101', '20140002', '32', '22.973');
INSERT INTO `sscore` VALUES ('201401007', '30101', '20140003', '76', '92.8571');
INSERT INTO `sscore` VALUES ('201401007', '30101', '20140004', '16', '0.862069');
INSERT INTO `sscore` VALUES ('201401007', '30101', '20140005', '77', '43.3824');
INSERT INTO `sscore` VALUES ('201401007', '30201', '20140006', '77', '75.4545');
INSERT INTO `sscore` VALUES ('201401007', '30201', '20140007', '60', '20.8333');
INSERT INTO `sscore` VALUES ('201401007', '30201', '20140008', '65', '36');
INSERT INTO `sscore` VALUES ('201401007', '30201', '20140009', '80', '63');
INSERT INTO `sscore` VALUES ('201401007', '30201', '20140010', '45', '11.5');
INSERT INTO `sscore` VALUES ('201401007', '30301', '20140011', '88', '86.7647');
INSERT INTO `sscore` VALUES ('201401007', '30301', '20140012', '95', '90');
INSERT INTO `sscore` VALUES ('201401007', '30301', '20140013', '97', '97.3684');
INSERT INTO `sscore` VALUES ('201401007', '30301', '20140014', '83', '55');
INSERT INTO `sscore` VALUES ('201401007', '30301', '20140015', '72', '64.6552');
INSERT INTO `sscore` VALUES ('201401008', '30101', '20140001', '80', '78.4483');
INSERT INTO `sscore` VALUES ('201401008', '30101', '20140002', '57', '20.4082');
INSERT INTO `sscore` VALUES ('201401008', '30101', '20140003', '62', '27.5');
INSERT INTO `sscore` VALUES ('201401008', '30101', '20140004', '64', '43.5484');
INSERT INTO `sscore` VALUES ('201401008', '30101', '20140005', '82', '81.4516');
INSERT INTO `sscore` VALUES ('201401008', '30201', '20140006', '100', '99.1667');
INSERT INTO `sscore` VALUES ('201401008', '30201', '20140007', '92', '97.5');
INSERT INTO `sscore` VALUES ('201401008', '30201', '20140008', '63', '57');
INSERT INTO `sscore` VALUES ('201401008', '30201', '20140009', '100', '98.2759');
INSERT INTO `sscore` VALUES ('201401008', '30201', '20140010', '88', '97.1154');
INSERT INTO `sscore` VALUES ('201401008', '30301', '20140011', '83', '72.9508');
INSERT INTO `sscore` VALUES ('201401008', '30301', '20140012', '100', '98.3871');
INSERT INTO `sscore` VALUES ('201401008', '30301', '20140013', '78', '62.2807');
INSERT INTO `sscore` VALUES ('201401008', '30301', '20140014', '54', '54.2553');
INSERT INTO `sscore` VALUES ('201401008', '30301', '20140015', '72', '46.2963');
INSERT INTO `sscore` VALUES ('201401009', '30101', '20140001', '62', '57.377');
INSERT INTO `sscore` VALUES ('201401009', '30101', '20140002', '84', '83.5');
INSERT INTO `sscore` VALUES ('201401009', '30101', '20140003', '88', '79.5');
INSERT INTO `sscore` VALUES ('201401009', '30101', '20140004', '84', '87.9032');
INSERT INTO `sscore` VALUES ('201401009', '30101', '20140005', '68', '53.2787');
INSERT INTO `sscore` VALUES ('201401009', '30201', '20140006', '78', '59.7015');
INSERT INTO `sscore` VALUES ('201401009', '30201', '20140007', '74', '74.1667');
INSERT INTO `sscore` VALUES ('201401009', '30201', '20140008', '62', '36.2903');
INSERT INTO `sscore` VALUES ('201401009', '30201', '20140009', '62', '69.2308');
INSERT INTO `sscore` VALUES ('201401009', '30201', '20140010', '78', '60.1562');
INSERT INTO `sscore` VALUES ('201401009', '30301', '20140011', '66', '30.3279');
INSERT INTO `sscore` VALUES ('201401009', '30301', '20140012', '54', '35.2459');
INSERT INTO `sscore` VALUES ('201401009', '30301', '20140013', '22', '2.5');
INSERT INTO `sscore` VALUES ('201401009', '30301', '20140014', '48', '18.5484');
INSERT INTO `sscore` VALUES ('201401009', '30301', '20140015', '40', '30.9524');
INSERT INTO `sscore` VALUES ('201401010', '30101', '20140001', '50', '43.2203');
INSERT INTO `sscore` VALUES ('201401010', '30101', '20140002', '24', '5.26316');
INSERT INTO `sscore` VALUES ('201401010', '30101', '20140003', '36', '24.0741');
INSERT INTO `sscore` VALUES ('201401010', '30101', '20140004', '68', '39.1667');
INSERT INTO `sscore` VALUES ('201401010', '30101', '20140005', '48', '20');
INSERT INTO `sscore` VALUES ('201401010', '30201', '20140006', '60', '38.0952');
INSERT INTO `sscore` VALUES ('201401010', '30201', '20140007', '66', '50.7937');
INSERT INTO `sscore` VALUES ('201401010', '30201', '20140008', '68', '47.5');
INSERT INTO `sscore` VALUES ('201401010', '30201', '20140009', '16', '2.41935');
INSERT INTO `sscore` VALUES ('201401010', '30201', '20140010', '72', '49.1228');
INSERT INTO `sscore` VALUES ('201401010', '30301', '20140011', '85', '92.5532');
INSERT INTO `sscore` VALUES ('201401010', '30301', '20140012', '100', '96.7213');
INSERT INTO `sscore` VALUES ('201401010', '30301', '20140013', '78', '56.5574');
INSERT INTO `sscore` VALUES ('201401010', '30301', '20140014', '85', '96.4912');
INSERT INTO `sscore` VALUES ('201401010', '30301', '20140015', '72', '79.3651');

-- ----------------------------
-- Table structure for stcourse
-- ----------------------------
DROP TABLE IF EXISTS `stcourse`;
CREATE TABLE `stcourse` (
  `studentID` varchar(25) DEFAULT NULL,
  `teacherID` varchar(25) DEFAULT NULL,
  `courseID` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stcourse
-- ----------------------------
INSERT INTO `stcourse` VALUES ('201401001', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401001', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401001', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401002', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401002', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401002', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401003', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401003', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401003', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401004', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401004', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401004', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401005', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401005', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401005', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401006', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401006', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401006', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401007', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401007', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401007', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401008', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401008', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401008', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401009', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401009', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401009', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401010', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401010', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401010', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401011', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401011', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401011', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401012', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401012', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401012', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401013', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401013', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401013', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401014', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401014', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401014', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401015', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401015', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401015', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401016', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401016', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401016', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401017', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401017', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401017', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401018', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401018', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401018', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401019', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401019', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401019', '06', '30301');
INSERT INTO `stcourse` VALUES ('201401020', '01', '30101');
INSERT INTO `stcourse` VALUES ('201401020', '02', '30201');
INSERT INTO `stcourse` VALUES ('201401020', '06', '30301');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentID` varchar(25) NOT NULL,
  `sname` varchar(25) DEFAULT NULL,
  `ssex` char(4) DEFAULT NULL,
  `spassword` varchar(25) DEFAULT NULL,
  `class` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('201401001', '熊家乐', 'm', '123', '一班');
INSERT INTO `student` VALUES ('201401002', '张君益', 'm', '123', '一班');
INSERT INTO `student` VALUES ('201401003', '曾睿', 'm', '123', '一班');
INSERT INTO `student` VALUES ('201401004', '陈灏', 'm', '123', '一班');
INSERT INTO `student` VALUES ('201401005', '方子晨', 'w', '123', '一班');
INSERT INTO `student` VALUES ('201401006', '高溢', 'm', '123', '一班');
INSERT INTO `student` VALUES ('201401007', '何昭阳', 'w', '123', '一班');
INSERT INTO `student` VALUES ('201401008', '李健豪', 'm', '123', '一班');
INSERT INTO `student` VALUES ('201401009', '林丽娟', 'w', '123', '一班');
INSERT INTO `student` VALUES ('201401010', '林彦希', 'm', '123', '一班');
INSERT INTO `student` VALUES ('201401011', '林一锷', 'm', '123', '一班');
INSERT INTO `student` VALUES ('201401012', '沈星语', 'm', '123', '一班');
INSERT INTO `student` VALUES ('201401013', '孙杰', 'm', '123', '一班');
INSERT INTO `student` VALUES ('201401014', '王张鑫', 'm', '123', '一班');
INSERT INTO `student` VALUES ('201401015', '魏增安', 'm', '123', '一班');
INSERT INTO `student` VALUES ('201401016', '杨佳静', 'w', '123', '一班');
INSERT INTO `student` VALUES ('201401017', '余锦澜', 'w', '123', '一班');
INSERT INTO `student` VALUES ('201401018', '俞佳茜', 'w', '123', '一班');
INSERT INTO `student` VALUES ('201401019', '张济清', 'm', '123', '一班');
INSERT INTO `student` VALUES ('201401020', '赵晔泽', 'm', '123', '一班');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherID` varchar(25) NOT NULL,
  `tname` varchar(25) DEFAULT NULL,
  `course` char(10) DEFAULT NULL,
  `tsex` char(4) DEFAULT NULL,
  `tpassword` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`teacherID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('01', '朱雅莹', '语文', 'w', '123');
INSERT INTO `teacher` VALUES ('02', '陈森淼', '数学', 'm', '123');
INSERT INTO `teacher` VALUES ('03', '陈丽芳', '数学', 'w', '123');
INSERT INTO `teacher` VALUES ('04', '陈学', '语文', 'm', '123');
INSERT INTO `teacher` VALUES ('05', '谢东源', '英文', 'm', '123');
INSERT INTO `teacher` VALUES ('06', '王月茹', '英文', 'w', '123');
INSERT INTO `teacher` VALUES ('07', '谢英', '语文', 'w', '123');
INSERT INTO `teacher` VALUES ('08', '庄小桦', '英文', 'w', '123');
INSERT INTO `teacher` VALUES ('09', '郑尧', '数学', 'w', '123');
INSERT INTO `teacher` VALUES ('10', '郎婕', '英文', 'w', '123');
INSERT INTO `teacher` VALUES ('11', '吕紫红', '数学', 'w', '123');
INSERT INTO `teacher` VALUES ('12', '肖莉岚', '英文', 'w', '123');
INSERT INTO `teacher` VALUES ('13', '赵津蕾', '语文', 'w', '123');
