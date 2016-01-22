/*
Navicat MySQL Data Transfer

Source Server         : mysql01
Source Server Version : 50543
Source Host           : localhost:3306
Source Database       : db_device

Target Server Type    : MYSQL
Target Server Version : 50543
File Encoding         : 65001

Date: 2015-12-26 11:39:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_scd_apply
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_apply`;
CREATE TABLE `tb_scd_apply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apply_no` varchar(30) DEFAULT NULL COMMENT '申请编号',
  `apply_emp` bigint(20) DEFAULT NULL COMMENT '申请人',
  `status` int(2) DEFAULT NULL COMMENT '申请状态',
  `deal_emp` bigint(20) DEFAULT NULL COMMENT '审核人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `apply_time` datetime DEFAULT NULL COMMENT '申请时间',
  `deal_time` datetime DEFAULT NULL COMMENT '审核时间',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_emp` bigint(20) DEFAULT NULL,
  `modify_emp` bigint(20) DEFAULT NULL,
  `is_valid` int(2) DEFAULT '1',
  `deal_text` varchar(255) DEFAULT NULL COMMENT '处理意见',
  `apply_text` varchar(255) DEFAULT NULL COMMENT '申请理由',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='设备申请表';

-- ----------------------------
-- Records of tb_scd_apply
-- ----------------------------
INSERT INTO `tb_scd_apply` VALUES ('1', 'AP1010101', '4', '2', '4', '测试', '2015-12-23 21:54:44', '2015-12-23 21:54:45', '2015-12-23 21:54:47', '2015-12-23 21:54:48', '4', '4', '1', '测试', '测试');
INSERT INTO `tb_scd_apply` VALUES ('2', 'AP1010102', '4', '1', '4', '测试', '2015-12-23 22:35:28', '2015-12-23 22:35:31', '2015-12-23 22:35:33', '2015-12-23 22:35:35', '4', '4', '1', '测试', '测试');

-- ----------------------------
-- Table structure for tb_scd_apply_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_apply_item`;
CREATE TABLE `tb_scd_apply_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_no` varchar(30) DEFAULT NULL COMMENT '申请项编号',
  `dev_id` bigint(20) DEFAULT NULL COMMENT '设备编号',
  `dev_num` int(11) DEFAULT NULL COMMENT '数量',
  `remark` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_emp` bigint(20) DEFAULT NULL,
  `modify_emp` bigint(20) DEFAULT NULL,
  `is_valid` int(2) DEFAULT '1',
  `apply_id` bigint(20) DEFAULT NULL COMMENT '申请id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='设备申请项表';

-- ----------------------------
-- Records of tb_scd_apply_item
-- ----------------------------
INSERT INTO `tb_scd_apply_item` VALUES ('1', 'IT10101101', '1', '10', '测试', '2015-12-24 00:59:37', '2015-12-24 00:59:40', '4', '4', '1', '1');

-- ----------------------------
-- Table structure for tb_scd_dev
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev`;
CREATE TABLE `tb_scd_dev` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dev_no` varchar(30) DEFAULT NULL COMMENT '设备编号',
  `bar_code` varchar(255) DEFAULT NULL COMMENT '条形码',
  `dev_name` varchar(255) DEFAULT NULL COMMENT '设备名称',
  `cate_id` int(11) DEFAULT NULL COMMENT '类别id',
  `model_no` varchar(255) DEFAULT NULL COMMENT '型号',
  `standard` varchar(255) DEFAULT NULL COMMENT '规格',
  `price` decimal(10,0) DEFAULT NULL COMMENT '单价',
  `country_id` int(11) DEFAULT NULL COMMENT '国家id',
  `firm` varchar(255) DEFAULT NULL COMMENT '生产厂商',
  `out_firm_no` varchar(255) DEFAULT NULL COMMENT '生产日期',
  `purchase_time` datetime DEFAULT NULL COMMENT '购置时间',
  `found_id` int(11) DEFAULT NULL COMMENT '经费科目',
  `origin_id` int(11) DEFAULT NULL COMMENT '设备来源',
  `deposit_id` int(11) DEFAULT NULL COMMENT '存放地',
  `dev_sum` int(11) DEFAULT NULL COMMENT '设备数量',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_emp` bigint(20) DEFAULT NULL,
  `modify_emp` bigint(20) DEFAULT NULL,
  `is_valid` int(2) DEFAULT '1',
  `dev_power` int(2) DEFAULT NULL COMMENT '设备权限',
  `direc_id` int(11) DEFAULT NULL COMMENT '设备使用方向',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='设备基本信息表';

-- ----------------------------
-- Records of tb_scd_dev
-- ----------------------------
INSERT INTO `tb_scd_dev` VALUES ('1', 'De101011', 'No1010101', '集成电池', '1', '', '9V', '3', '1', '测试厂商', 'ceshi001', '2015-12-20 14:25:21', '1', '1', '1', '20', '测试', '2015-12-20 14:25:39', '2015-12-20 14:25:41', '4', '4', '1', null, '1');
INSERT INTO `tb_scd_dev` VALUES ('2', 'De101012', 'No1010102', '集成电池01', '2', 'ceshi ', '8V', '5', '2', '测试厂商', '测试001', '2015-12-25 22:46:29', '1', '1', '1', '30', '测试', '2015-12-25 22:46:51', '2015-12-25 22:46:54', '4', '4', '1', null, '1');

-- ----------------------------
-- Table structure for tb_scd_dev_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev_category`;
CREATE TABLE `tb_scd_dev_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `cate_no` varchar(30) DEFAULT NULL COMMENT '类别号',
  `cate_name` varchar(30) DEFAULT NULL COMMENT '类别名称',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_emp` bigint(20) DEFAULT NULL,
  `modify_emp` bigint(20) DEFAULT NULL,
  `is_valid` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='设备类别表';

-- ----------------------------
-- Records of tb_scd_dev_category
-- ----------------------------
INSERT INTO `tb_scd_dev_category` VALUES ('1', 'CG101010101', '测试类别1', '2015-12-16 21:37:23', '2015-12-16 21:37:25', '4', '4', '1');
INSERT INTO `tb_scd_dev_category` VALUES ('2', 'CG10101010102', '测试类别2', '2015-12-16 21:37:47', '2015-12-16 21:37:49', '4', '4', '1');

-- ----------------------------
-- Table structure for tb_scd_dev_country
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev_country`;
CREATE TABLE `tb_scd_dev_country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country_no` varchar(30) DEFAULT NULL COMMENT '国家编号',
  `country_name` varchar(30) DEFAULT NULL COMMENT '国家名称',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_emp` bigint(20) DEFAULT NULL,
  `modify_emp` bigint(20) DEFAULT NULL,
  `is_valid` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='设备国别表';

-- ----------------------------
-- Records of tb_scd_dev_country
-- ----------------------------
INSERT INTO `tb_scd_dev_country` VALUES ('1', 'Co1010101', '中国', '2015-12-20 16:48:42', '2015-12-20 16:48:44', '4', '4', '1');
INSERT INTO `tb_scd_dev_country` VALUES ('2', 'Co1010102', '日本', '2015-12-20 16:49:05', '2015-12-20 16:49:07', '4', '4', '1');

-- ----------------------------
-- Table structure for tb_scd_dev_deposit
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev_deposit`;
CREATE TABLE `tb_scd_dev_deposit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dev_deposit_no` varchar(30) DEFAULT NULL COMMENT '设备存放地编号',
  `dev_deposit_name` varchar(30) DEFAULT NULL COMMENT '设备存放地名称',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_emp` bigint(20) DEFAULT NULL,
  `modify_emp` bigint(20) DEFAULT NULL,
  `is_valid` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='设备存放地表';

-- ----------------------------
-- Records of tb_scd_dev_deposit
-- ----------------------------
INSERT INTO `tb_scd_dev_deposit` VALUES ('1', 'Do1010101', '一号实验室', '2015-12-20 16:49:37', '2015-12-20 16:49:39', '4', '4', '1');
INSERT INTO `tb_scd_dev_deposit` VALUES ('2', 'Do1010101', '二号实验室', '2015-12-20 16:49:56', '2015-12-20 16:49:58', '4', '4', '1');

-- ----------------------------
-- Table structure for tb_scd_dev_found_sub
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev_found_sub`;
CREATE TABLE `tb_scd_dev_found_sub` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `found_sub_no` varchar(30) DEFAULT NULL COMMENT '经费科目编号',
  `found_sub_name` varchar(30) DEFAULT NULL COMMENT '经费科目名称',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_emp` bigint(20) DEFAULT NULL,
  `modify_emp` bigint(20) DEFAULT NULL,
  `is_valid` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='设备经费科目表';

-- ----------------------------
-- Records of tb_scd_dev_found_sub
-- ----------------------------
INSERT INTO `tb_scd_dev_found_sub` VALUES ('1', 'Fs101010101', '测试经费1', '2015-12-20 16:50:44', '2015-12-20 16:50:46', '4', '4', '1');
INSERT INTO `tb_scd_dev_found_sub` VALUES ('2', 'Fs101010101', '测试经费2', '2015-12-20 16:51:05', '2015-12-20 16:51:07', '4', '4', '1');

-- ----------------------------
-- Table structure for tb_scd_dev_input
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev_input`;
CREATE TABLE `tb_scd_dev_input` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `input_no` varchar(30) DEFAULT NULL COMMENT '入库编号',
  `bar_code` varchar(255) DEFAULT NULL COMMENT '条形码',
  `dev_name` varchar(255) DEFAULT NULL COMMENT '设备名称',
  `cate_id` int(11) DEFAULT NULL COMMENT '类别id',
  `model_no` varchar(255) DEFAULT NULL COMMENT '型号',
  `standard` varchar(255) DEFAULT NULL COMMENT '规格',
  `price` decimal(10,0) DEFAULT NULL COMMENT '单价',
  `country_id` int(11) DEFAULT NULL COMMENT '国家id',
  `firm` varchar(255) DEFAULT NULL COMMENT '生产厂家',
  `out_firm_no` varchar(255) DEFAULT NULL COMMENT '出厂日期',
  `purchase_time` datetime DEFAULT NULL COMMENT '购买时间',
  `found_id` int(11) DEFAULT NULL COMMENT '经费科目',
  `origin_id` int(11) DEFAULT NULL COMMENT '设备来源',
  `deposit_id` int(11) DEFAULT NULL COMMENT '存放地',
  `dev_num` int(11) DEFAULT NULL COMMENT '设备数量',
  `deal_emp` bigint(20) DEFAULT NULL COMMENT '经手人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_emp` bigint(20) DEFAULT NULL,
  `modify_emp` bigint(20) DEFAULT NULL,
  `is_valid` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备入库记录表';

-- ----------------------------
-- Records of tb_scd_dev_input
-- ----------------------------

-- ----------------------------
-- Table structure for tb_scd_dev_origin
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev_origin`;
CREATE TABLE `tb_scd_dev_origin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dev_origin_no` varchar(30) DEFAULT NULL COMMENT '设备来源编号',
  `dev_origin_name` varchar(30) DEFAULT NULL COMMENT '设备来源名称',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_emp` bigint(20) DEFAULT NULL,
  `modify_emp` bigint(20) DEFAULT NULL,
  `is_valid` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='设备来源表';

-- ----------------------------
-- Records of tb_scd_dev_origin
-- ----------------------------
INSERT INTO `tb_scd_dev_origin` VALUES ('1', 'ON1010101011', '校友捐赠', '2015-12-16 21:11:28', '2015-12-16 21:11:30', '4', '4', '1');
INSERT INTO `tb_scd_dev_origin` VALUES ('2', 'ON1010101012', '学校购买', '2015-12-16 21:24:59', '2015-12-16 21:25:01', '4', '4', '1');

-- ----------------------------
-- Table structure for tb_scd_dev_status
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev_status`;
CREATE TABLE `tb_scd_dev_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dev_status_no` varchar(30) DEFAULT NULL COMMENT '设备现状编号',
  `dev_status_name` varchar(30) DEFAULT NULL COMMENT '设备现状名称',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_emp` bigint(20) DEFAULT NULL,
  `modify_emp` bigint(20) DEFAULT NULL,
  `is_valid` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备现状表';

-- ----------------------------
-- Records of tb_scd_dev_status
-- ----------------------------

-- ----------------------------
-- Table structure for tb_scd_dev_use_direc
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev_use_direc`;
CREATE TABLE `tb_scd_dev_use_direc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `use_direc_no` varchar(30) DEFAULT NULL COMMENT '使用方向编号',
  `use_direc_name` varchar(30) DEFAULT NULL COMMENT '使用方向名称',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_emp` bigint(20) DEFAULT NULL,
  `modify_emp` bigint(20) DEFAULT NULL,
  `is_valid` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='设备使用方向表';

-- ----------------------------
-- Records of tb_scd_dev_use_direc
-- ----------------------------
INSERT INTO `tb_scd_dev_use_direc` VALUES ('1', 'Di101010101', '测试使用方向1', '2015-12-20 16:51:48', '2015-12-20 16:51:50', '4', '4', '1');
INSERT INTO `tb_scd_dev_use_direc` VALUES ('2', 'Di101010101', '测试使用方向2', '2015-12-20 16:52:06', '2015-12-20 16:52:08', '4', '4', '1');

-- ----------------------------
-- Table structure for tb_scd_dump
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dump`;
CREATE TABLE `tb_scd_dump` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dev_id` bigint(20) DEFAULT NULL COMMENT '设备id',
  `dump_no` varchar(30) DEFAULT NULL COMMENT '报废编号',
  `dump_num` int(11) DEFAULT NULL COMMENT '报废数量',
  `dump_reason` int(2) DEFAULT NULL COMMENT '报废原因',
  `dump_time` datetime DEFAULT NULL COMMENT '报废时间',
  `dump_emp` varchar(20) DEFAULT NULL COMMENT '报废负责人',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_emp` bigint(20) DEFAULT NULL,
  `modify_emp` bigint(20) DEFAULT NULL,
  `is_valid` int(2) DEFAULT '1',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='设备报废记录表';

-- ----------------------------
-- Records of tb_scd_dump
-- ----------------------------
INSERT INTO `tb_scd_dump` VALUES ('1', '1', 'DU1010101', '10', '1', '2015-12-24 00:35:26', '测试', '2015-12-24 00:35:30', '2015-12-24 00:35:32', '4', '4', '1', '测试');
INSERT INTO `tb_scd_dump` VALUES ('2', '1', 'DU1010102', '5', '2', '2015-12-24 00:36:02', '测试', '2015-12-24 00:36:06', '2015-12-24 00:36:08', '4', '4', '1', '测试');

-- ----------------------------
-- Table structure for tb_scd_maintain
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_maintain`;
CREATE TABLE `tb_scd_maintain` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `maintain_no` varchar(30) DEFAULT NULL COMMENT '维修记录编号',
  `dev_id` bigint(20) DEFAULT NULL COMMENT '设备Id',
  `maintain_num` int(11) DEFAULT NULL COMMENT '设备数量',
  `maintain_emp` varchar(30) DEFAULT NULL COMMENT '维修负责人',
  `status` int(11) DEFAULT NULL COMMENT '维修状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_emp` bigint(20) DEFAULT NULL,
  `modify_emp` bigint(20) DEFAULT NULL,
  `is_valid` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='设备维修记录表';

-- ----------------------------
-- Records of tb_scd_maintain
-- ----------------------------
INSERT INTO `tb_scd_maintain` VALUES ('1', 'MT1010101', '1', '10', '测试', '1', '册数', '2015-12-23 23:51:08', '2015-12-23 23:51:09', '4', '4', '1');

-- ----------------------------
-- Table structure for tb_scd_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_menu`;
CREATE TABLE `tb_scd_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(30) DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(255) DEFAULT NULL COMMENT '菜单地址',
  `parent_id` int(11) DEFAULT NULL COMMENT '上级菜单id',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_emp` bigint(20) DEFAULT NULL,
  `modify_emp` bigint(20) DEFAULT NULL,
  `is_valid` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
-- Records of tb_scd_menu
-- ----------------------------
INSERT INTO `tb_scd_menu` VALUES ('2', '用户列表', null, '0', null, null, null, null, '1');
INSERT INTO `tb_scd_menu` VALUES ('3', '设备管理', null, '0', null, null, null, null, '1');
INSERT INTO `tb_scd_menu` VALUES ('4', '系统管理', null, '0', null, null, null, null, '1');
INSERT INTO `tb_scd_menu` VALUES ('5', '系统维护', null, '0', null, null, null, null, '1');
INSERT INTO `tb_scd_menu` VALUES ('6', '设备信息', null, '3', null, null, null, null, '1');
INSERT INTO `tb_scd_menu` VALUES ('7', '设备入库', null, '3', null, null, null, null, '1');
INSERT INTO `tb_scd_menu` VALUES ('8', '设备申请', null, '3', null, null, null, null, '1');
INSERT INTO `tb_scd_menu` VALUES ('9', '设备维修', null, '3', null, null, null, null, '1');
INSERT INTO `tb_scd_menu` VALUES ('10', '设备报废', null, '3', null, null, null, null, '1');

-- ----------------------------
-- Table structure for tb_scd_power
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_power`;
CREATE TABLE `tb_scd_power` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `power_name` varchar(30) DEFAULT NULL COMMENT '权限名称',
  `power_context` varchar(255) DEFAULT NULL COMMENT '权限内容',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_emp` bigint(20) DEFAULT NULL,
  `modify_emp` bigint(20) DEFAULT NULL,
  `is_valid` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统权限表';

-- ----------------------------
-- Records of tb_scd_power
-- ----------------------------

-- ----------------------------
-- Table structure for tb_scd_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_user`;
CREATE TABLE `tb_scd_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(32) DEFAULT NULL COMMENT '用户密码',
  `real_name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `user_sex` int(2) DEFAULT NULL COMMENT '性别',
  `user_role` int(2) DEFAULT NULL COMMENT '角色',
  `user_tel` varchar(11) DEFAULT NULL COMMENT '电话',
  `user_menu` varchar(50) DEFAULT NULL COMMENT '菜单列表',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_emp` bigint(20) DEFAULT NULL COMMENT '创建人',
  `modify_emp` bigint(20) DEFAULT NULL COMMENT '修改人',
  `is_valid` int(2) DEFAULT '1' COMMENT '是否有效 1：有效 0：无效',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tb_scd_user
-- ----------------------------
INSERT INTO `tb_scd_user` VALUES ('4', 'admin', '4QrcOUm6Wau+VuBX8g+IPg==', '杨利鹏', '1', '1', '18235140527', '1,2,3,4,5', null, '2015-12-25 21:39:36', null, '4', '1', null);
INSERT INTO `tb_scd_user` VALUES ('5', 'zhangsan', '123456', '张三', '1', '1', '18235140527', '1', '2015-11-30 00:12:33', '2015-11-30 00:12:33', '4', '4', '1', null);
INSERT INTO `tb_scd_user` VALUES ('6', 'lisi', null, null, null, null, null, null, null, null, null, null, '1', null);
INSERT INTO `tb_scd_user` VALUES ('7', 'aaaa', '4QrcOUm6Wau+VuBX8g+IPg==', null, null, null, null, null, null, '2015-12-25 22:10:49', null, '4', '1', null);
INSERT INTO `tb_scd_user` VALUES ('8', 'dd', '4QrcOUm6Wau+VuBX8g+IPg==', null, null, null, null, null, null, '2015-12-25 22:10:43', null, '4', '0', null);
INSERT INTO `tb_scd_user` VALUES ('9', 'ff', null, null, null, null, null, null, null, '2015-12-24 01:59:10', null, '4', '0', null);
INSERT INTO `tb_scd_user` VALUES ('10', 'ceshi001', '4QrcOUm6Wau+VuBX8g+IPg==', '测试001', '1', '3', '1212121', '1,2,3', '2015-12-25 22:10:07', '2015-12-25 22:10:07', '4', '4', '1', '测试备注001');
