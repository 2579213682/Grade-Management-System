/*
 Navicat Premium Data Transfer

 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `calss_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `calss_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`calss_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('临床医学201', '临床医学201班');
INSERT INTO `class` VALUES ('临床医学202', '临床医学202班');
INSERT INTO `class` VALUES ('人力资源管理201', '人力201班');
INSERT INTO `class` VALUES ('法学201', '法学201班');
INSERT INTO `class` VALUES ('法学202', '法学202班');
INSERT INTO `class` VALUES ('计算机科学与技术201', '计科201班');
INSERT INTO `class` VALUES ('财务管理201', '财管201班');
INSERT INTO `class` VALUES ('软件工程大数据201', '大数据201班');
INSERT INTO `class` VALUES ('软件工程大数据202', '大数据202班');
INSERT INTO `class` VALUES ('鸡你太美201', '鸡201班');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `studentid` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subjectid` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  INDEX `fk_score_student`(`studentid`) USING BTREE,
  INDEX `fk_score_subject`(`subjectid`) USING BTREE,
  CONSTRAINT `fk_score_student` FOREIGN KEY (`studentid`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_score_subject` FOREIGN KEY (`subjectid`) REFERENCES `subject` (`subject_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('5720201521', 'javaweb', '85');
INSERT INTO `score` VALUES ('5720201523', 'javaweb', '98');
INSERT INTO `score` VALUES ('5720201524', 'javaweb', '98');
INSERT INTO `score` VALUES ('5720201529', '数据结构', '80');
INSERT INTO `score` VALUES ('5720201533', '人工智能', '85');
INSERT INTO `score` VALUES ('5720201536', '大数据导论', '85');
INSERT INTO `score` VALUES ('5720201532', '电工电子技术', '85');
INSERT INTO `score` VALUES ('5720201524', '数据结构', '70');
INSERT INTO `score` VALUES ('5720201527', '安卓移动应用开发', '71');
INSERT INTO `score` VALUES ('5720201520', '安卓移动应用开发', '90');
INSERT INTO `score` VALUES ('5720201526', '安卓移动应用开发', '88');
INSERT INTO `score` VALUES ('5720201526', 'Linux', '81.5');
INSERT INTO `score` VALUES ('5720201539', 'Linux', '86.5');
INSERT INTO `score` VALUES ('5720201540', 'Linux', '59');
INSERT INTO `score` VALUES ('5720201540', 'javaweb', '80');
INSERT INTO `score` VALUES ('5720201525', 'javaweb', '2312323');
INSERT INTO `score` VALUES ('5720201525', '离散数学', '66');
INSERT INTO `score` VALUES ('5720201530', '离散数学', '99');
INSERT INTO `score` VALUES ('5720201520', '人工智能', '100');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `classid` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE,
  INDEX `fk_student_class`(`classid`) USING BTREE,
  CONSTRAINT `fk_student_class` FOREIGN KEY (`classid`) REFERENCES `class` (`calss_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('5720201520', '路明非', 'lmf12345', '软件工程大数据202');
INSERT INTO `student` VALUES ('5720201521', '陈墨瞳', 'ty5453457', '软件工程大数据202');
INSERT INTO `student` VALUES ('5720201522', '芬格尔', 'cmt23434df', '软件工程大数据202');
INSERT INTO `student` VALUES ('5720201523', '路鸣泽', 'skdasj34234', '软件工程大数据201');
INSERT INTO `student` VALUES ('5720201524', '陆山彦', 'dfsd12123', '软件工程大数据201');
INSERT INTO `student` VALUES ('5720201525', '陈雯雯', 'sdsha23235', '软件工程大数据201');
INSERT INTO `student` VALUES ('5720201526', '苏晓蔷', 'dfdfk1113', '计算机科学与技术201');
INSERT INTO `student` VALUES ('5720201527', '苏恩曦', '2333242', '计算机科学与技术201');
INSERT INTO `student` VALUES ('5720201528', '李雾月', '231235676', '计算机科学与技术201');
INSERT INTO `student` VALUES ('5720201529', '萧炎', '67787345', '财务管理201');
INSERT INTO `student` VALUES ('5720201530', '韩月', '4537789', '财务管理201');
INSERT INTO `student` VALUES ('5720201531', '纳兰桀', '342762438', '财务管理201');
INSERT INTO `student` VALUES ('5720201532', '萧宁', 'dfgr435367', '人力资源管理201');
INSERT INTO `student` VALUES ('5720201533', '樊林哈', '34234sdfe342', '人力资源管理201');
INSERT INTO `student` VALUES ('5720201534', '海东', 'erefg5rtr32', '人力资源管理201');
INSERT INTO `student` VALUES ('5720201535', '陈年晓', '234234276', '法学201');
INSERT INTO `student` VALUES ('5720201536', '王晓璐', '787864538', '法学201');
INSERT INTO `student` VALUES ('5720201537', '胡禄瀚', '45356', '法学201');
INSERT INTO `student` VALUES ('5720201538', '胡延凡', '45313sds', '法学202');
INSERT INTO `student` VALUES ('5720201539', '陶谷康', 'gfngf56', '法学202');
INSERT INTO `student` VALUES ('5720201540', '蔡徐坤', '79783df', '法学202');
INSERT INTO `student` VALUES ('5720201541', '鸡美', NULL, '法学202');
INSERT INTO `student` VALUES ('5720201542', NULL, '123', NULL);
INSERT INTO `student` VALUES ('5720201543', NULL, '12345', NULL);

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`  (
  `subject_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `subject_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`subject_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('javaweb', 'javaweb');
INSERT INTO `subject` VALUES ('linux', 'linux');
INSERT INTO `subject` VALUES ('python', 'python');
INSERT INTO `subject` VALUES ('专业英语', '专业英语');
INSERT INTO `subject` VALUES ('人工智能', '人工智能');
INSERT INTO `subject` VALUES ('大数据导论', '大数据导论');
INSERT INTO `subject` VALUES ('安卓移动应用开发', '安卓移动应用开发');
INSERT INTO `subject` VALUES ('数据结构', '数据结构');
INSERT INTO `subject` VALUES ('电工电子技术', '电工电子技术');
INSERT INTO `subject` VALUES ('离散数学', '离散数学');
INSERT INTO `subject` VALUES ('计算机组成原理', '计算机组成原理');
INSERT INTO `subject` VALUES ('计算机网络', '计算机网络');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teacher_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1016136797', '楚子航', '9012');
INSERT INTO `teacher` VALUES ('1293230948', '胡列娜', '2342');
INSERT INTO `teacher` VALUES ('1326373962', '玛琪玛', '5678');
INSERT INTO `teacher` VALUES ('2309428343', '唐昊', '3423');
INSERT INTO `teacher` VALUES ('2457812451', '朱竹清', '5789');
INSERT INTO `teacher` VALUES ('3366808623', '叶惠美', '1234');

-- ----------------------------
-- Table structure for teacher_and_class
-- ----------------------------
DROP TABLE IF EXISTS `teacher_and_class`;
CREATE TABLE `teacher_and_class`  (
  `classid` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacherid` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `fk_teacher_and_calss_teacher`(`teacherid`) USING BTREE,
  INDEX `fk_teacher_and_calss_class`(`classid`) USING BTREE,
  CONSTRAINT `fk_teacher_and_calss_class` FOREIGN KEY (`classid`) REFERENCES `class` (`calss_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_teacher_and_calss_teacher` FOREIGN KEY (`teacherid`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_and_class
-- ----------------------------
INSERT INTO `teacher_and_class` VALUES ('软件工程大数据201', '3366808623');
INSERT INTO `teacher_and_class` VALUES ('软件工程大数据202', '3366808623');
INSERT INTO `teacher_and_class` VALUES ('计算机科学与技术201', '1293230948');
INSERT INTO `teacher_and_class` VALUES ('软件工程大数据201', '1016136797');
INSERT INTO `teacher_and_class` VALUES ('计算机科学与技术201', '1016136797');
INSERT INTO `teacher_and_class` VALUES ('软件工程大数据202', '1016136797');

-- ----------------------------
-- Table structure for teacher_and_subject
-- ----------------------------
DROP TABLE IF EXISTS `teacher_and_subject`;
CREATE TABLE `teacher_and_subject`  (
  `teacherid` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subjectid` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `fk_teacher_and_subject_teacher`(`teacherid`) USING BTREE,
  INDEX `fk_teacher_and_subject_subject`(`subjectid`) USING BTREE,
  CONSTRAINT `fk_teacher_and_subject_subject` FOREIGN KEY (`subjectid`) REFERENCES `subject` (`subject_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_teacher_and_subject_teacher` FOREIGN KEY (`teacherid`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_and_subject
-- ----------------------------
INSERT INTO `teacher_and_subject` VALUES ('1016136797', 'javaweb');
INSERT INTO `teacher_and_subject` VALUES ('1016136797', 'linux');
INSERT INTO `teacher_and_subject` VALUES ('1293230948', 'python');
INSERT INTO `teacher_and_subject` VALUES ('1293230948', '专业英语');
INSERT INTO `teacher_and_subject` VALUES ('1326373962', '人工智能');
INSERT INTO `teacher_and_subject` VALUES ('1016136797', '安卓移动应用开发');
INSERT INTO `teacher_and_subject` VALUES ('2309428343', '大数据导论');
INSERT INTO `teacher_and_subject` VALUES ('2457812451', '安卓移动应用开发');
INSERT INTO `teacher_and_subject` VALUES ('3366808623', '数据结构');
INSERT INTO `teacher_and_subject` VALUES ('1293230948', '电工电子技术');
INSERT INTO `teacher_and_subject` VALUES ('1326373962', 'javaweb');
INSERT INTO `teacher_and_subject` VALUES ('1326373962', 'linux');
INSERT INTO `teacher_and_subject` VALUES ('2309428343', 'python');
INSERT INTO `teacher_and_subject` VALUES ('1016136797', '专业英语');

SET FOREIGN_KEY_CHECKS = 1;
