/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : db_store

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2017-01-04 15:56:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `category` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `cdesc` varchar(99) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `cate` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '1', '食品', ' 	坚果、饮料、膨化食品');
INSERT INTO `category` VALUES ('2', '2', '化妆品', ' 	洁面、BB霜、养护');
INSERT INTO `category` VALUES ('3', '3', '家电', '家用、家电');
INSERT INTO `category` VALUES ('4', '4', '文具', ' 	笔、纸、书包');
INSERT INTO `category` VALUES ('5', '5', '服饰', '衣服、裤子');

-- ----------------------------
-- Table structure for `delivery`
-- ----------------------------
DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(99) NOT NULL DEFAULT '顺风',
  `dprice` decimal(20,2) DEFAULT '0.00',
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery
-- ----------------------------
INSERT INTO `delivery` VALUES ('1', '申通', '8.00');
INSERT INTO `delivery` VALUES ('2', '顺风', '8.00');
INSERT INTO `delivery` VALUES ('3', '圆通', '8.00');
INSERT INTO `delivery` VALUES ('4', '韵达', '8.00');

-- ----------------------------
-- Table structure for `guestbook`
-- ----------------------------
DROP TABLE IF EXISTS `guestbook`;
CREATE TABLE `guestbook` (
  `wid` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NOT NULL,
  `content` varchar(4000) NOT NULL,
  `answerContent` varchar(4000) CHARACTER SET utf8 DEFAULT '',
  PRIMARY KEY (`wid`),
  KEY `md` (`mid`),
  CONSTRAINT `md` FOREIGN KEY (`mid`) REFERENCES `member` (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of guestbook
-- ----------------------------
INSERT INTO `guestbook` VALUES ('1', '1', '11111', '1111111');
INSERT INTO `guestbook` VALUES ('2', '1', '11', '');
INSERT INTO `guestbook` VALUES ('3', '5', 'aa', '');

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mlevel` varchar(20) NOT NULL DEFAULT 'V1',
  `loginName` varchar(30) CHARACTER SET utf8 NOT NULL,
  `loginPwd` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '123456',
  `mName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `phone` int(18) NOT NULL DEFAULT '123456',
  `address` varchar(20) CHARACTER SET utf8 NOT NULL DEFAULT '江苏',
  `email` varchar(20) CHARACTER SET utf8 NOT NULL DEFAULT 'abc@ccit.js.cn',
  `intergal` int(11) NOT NULL DEFAULT '100',
  PRIMARY KEY (`mid`),
  KEY `mlevel` (`mlevel`),
  CONSTRAINT `mlevel` FOREIGN KEY (`mlevel`) REFERENCES `memberlevel` (`levelName`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', 'V7', 'admin', 'admin', 'admin', '123456', '江苏', 'abc@ccit.js.cn', '10000');
INSERT INTO `member` VALUES ('2', 'V1', 'john', '123456', 'john', '123456', '江苏', 'abc@ccit.js.cn', '200');
INSERT INTO `member` VALUES ('3', 'V1', 'HLZ', '123456', 'HLZ', '123456', '江苏', 'abc@ccit.js.cn', '3066');
INSERT INTO `member` VALUES ('4', 'V1', '11', '11', '11', '11', '11', '11', '100');
INSERT INTO `member` VALUES ('5', 'V1', '1', '1', '1', '1', '1', '1', '100');

-- ----------------------------
-- Table structure for `memberlevel`
-- ----------------------------
DROP TABLE IF EXISTS `memberlevel`;
CREATE TABLE `memberlevel` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `levelName` varchar(20) NOT NULL,
  `favourable` decimal(11,2) NOT NULL,
  PRIMARY KEY (`lid`),
  KEY `mid` (`lid`),
  KEY `levelName` (`levelName`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of memberlevel
-- ----------------------------
INSERT INTO `memberlevel` VALUES ('1', 'V1', '0.95');
INSERT INTO `memberlevel` VALUES ('2', 'V2', '0.90');
INSERT INTO `memberlevel` VALUES ('3', 'V3', '0.85');
INSERT INTO `memberlevel` VALUES ('4', 'V4', '0.80');
INSERT INTO `memberlevel` VALUES ('5', 'V5', '0.75');
INSERT INTO `memberlevel` VALUES ('6', 'V6', '0.70');
INSERT INTO `memberlevel` VALUES ('7', 'V7', '0.60');

-- ----------------------------
-- Table structure for `merchandise`
-- ----------------------------
DROP TABLE IF EXISTS `merchandise`;
CREATE TABLE `merchandise` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `category` int(11) NOT NULL,
  `mername` varchar(50) NOT NULL,
  `price` varchar(9) NOT NULL,
  `sprice` varchar(9) NOT NULL,
  `picture` varchar(50) DEFAULT NULL,
  `merdesc` varchar(4000) NOT NULL,
  `manufacturer` varchar(20) NOT NULL,
  `special` int(11) NOT NULL,
  PRIMARY KEY (`gid`),
  KEY `category` (`category`),
  CONSTRAINT `category` FOREIGN KEY (`category`) REFERENCES `category` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of merchandise
-- ----------------------------
INSERT INTO `merchandise` VALUES ('1', '1', '薯片', '49.99', '35.00', 'shupian.png', '乐事薯片膨化零食', '上海', '1');
INSERT INTO `merchandise` VALUES ('2', '1', '糖果', '60.00', '36.00', 'tangguo.png', '水果味软糖', '广州', '1');
INSERT INTO `merchandise` VALUES ('3', '1', '饼干', '65.76', '48.00', 'binggan.png', '进口曲奇', '上海', '1');
INSERT INTO `merchandise` VALUES ('4', '1', '果干', '44.80', '44.80', 'guogan.png', '凤梨果干蜜饯', '上海', '1');
INSERT INTO `merchandise` VALUES ('5', '1', '樱桃', '49.90', '49.90', 'yingtao.png', '新鲜之力红樱桃', '苏州', '1');
INSERT INTO `merchandise` VALUES ('6', '1', '可乐', '58.00', '52.00', 'kele.png', '整箱瓶装', '上海', '1');
INSERT INTO `merchandise` VALUES ('7', '1', '泡面', '62.50', '59.90', 'paomian.png', '五包装', '上海', '1');
INSERT INTO `merchandise` VALUES ('8', '1', '坚果', '39.90', '35.90', 'jianguo.png', '奶油味', '上海', '1');
INSERT INTO `merchandise` VALUES ('9', '1', '面包', '39.80', '39.80', 'mianbao.png', '糕点零食', '常州', '1');
INSERT INTO `merchandise` VALUES ('10', '2', '洗面奶', '90.00', '33.00', 'ximiannai.png', '芦荟洁面', '北京', '1');
INSERT INTO `merchandise` VALUES ('11', '2', '面膜', '120.00', '88.88', 'mianmo.png', '美白保湿', '北京', '1');
INSERT INTO `merchandise` VALUES ('12', '2', '粉底液', '490.00', '360.00', 'fendiye.png', '轻薄保湿', '上海', '1');
INSERT INTO `merchandise` VALUES ('13', '2', '口红', '340.00', '280.00', 'kouhong.png', '方管', '上海', '1');
INSERT INTO `merchandise` VALUES ('14', '2', '眼霜', '1700.00', '1700.00', 'yanshuang.png', '淡化纹路', '上海', '1');
INSERT INTO `merchandise` VALUES ('15', '2', '气垫BB', '188.00', '158.00', 'qidianbb.png', '水光气垫', '苏州', '1');
INSERT INTO `merchandise` VALUES ('16', '2', '精华液', '580.00', '580.00', 'jinghuaye.png', '补水修护', '苏州', '1');
INSERT INTO `merchandise` VALUES ('17', '2', '眼影', '398.00', '298.00', 'yanying.png', '自然粉嫩', '上海', '1');
INSERT INTO `merchandise` VALUES ('18', '2', '护手霜', '109.00', '39.00', 'hushoushuang.png', '水嫩香滑', '北京', '1');
INSERT INTO `merchandise` VALUES ('19', '3', '吸尘器', '499.00', '499.00', 'xichenqi.png', '省电节能', '常州', '1');
INSERT INTO `merchandise` VALUES ('20', '3', '电饭锅', '258.00', '198.00', 'dianfanguo.png', '健康环保', '苏州', '1');
INSERT INTO `merchandise` VALUES ('21', '3', '电磁炉', '716.00', '368.00', 'diancilu.png', '受热均匀', '无锡', '1');
INSERT INTO `merchandise` VALUES ('22', '3', '冰箱', '808.00', '568.00', 'bingxiang.png', '小型冷冻冰箱', '无锡', '1');
INSERT INTO `merchandise` VALUES ('23', '3', '空调', '2998.00', '2798.00', 'kongtiao.png', '站立式', '上海', '1');
INSERT INTO `merchandise` VALUES ('24', '3', '电视机', '888.00', '788.00', 'dianshiji.png', '液晶大屏', '苏州', '1');
INSERT INTO `merchandise` VALUES ('25', '3', '电吹风', '99.99', '60.99', 'dianchuifeng.png', '大功率', '苏州', '1');
INSERT INTO `merchandise` VALUES ('26', '3', '电动牙刷', '1499.00', '1299.00', 'yashua.png', '声波震动', '常州', '1');
INSERT INTO `merchandise` VALUES ('27', '3', '微波炉', '699.00', '399.00', 'weibolu.png', '纳米不锈钢', '苏州', '1');
INSERT INTO `merchandise` VALUES ('28', '4', '钢笔', '128.99', '99.99', 'gangbi.png', '书写流畅', '无锡', '1');
INSERT INTO `merchandise` VALUES ('29', '4', '毛笔', '199.00', '128.00', 'maobi.png', '柔软狼毛', '广州', '1');
INSERT INTO `merchandise` VALUES ('30', '4', '铅笔', '32.00', '15.99', 'qianbi.png', '20支装', '义乌', '1');
INSERT INTO `merchandise` VALUES ('31', '4', '笔记本', '16.00', '9.89', 'bijiben.png', '糖果色', '义乌', '1');
INSERT INTO `merchandise` VALUES ('32', '4', '蜡笔', '78.88', '60.00', 'labi.png', '组合装', '广州', '1');
INSERT INTO `merchandise` VALUES ('33', '4', '文具盒', '60.00', '32.00', 'wenjuhe.png', '卡通图案', '杭州', '1');
INSERT INTO `merchandise` VALUES ('34', '4', '书包', '168.99', '132.99', 'shubao.png', '学生双肩包', '义乌', '1');
INSERT INTO `merchandise` VALUES ('35', '4', '笔筒', '35.00', '20.09', 'bitong.png', '个性文具', '义乌', '1');
INSERT INTO `merchandise` VALUES ('36', '4', '草稿纸', '12.09', '9.99', 'caogaoben.png', '演算绘画涂鸦', '广州', '1');
INSERT INTO `merchandise` VALUES ('37', '5', '连衣裙', '198.99', '158.99', 'lianyiqun.png', '韩版淑女裙', '苏州', '1');
INSERT INTO `merchandise` VALUES ('38', '5', '卫衣', '150.00', '150.00', 'weiyi.png', '宽松男友风', '杭州', '1');
INSERT INTO `merchandise` VALUES ('39', '5', '牛仔裤', '99.99', '78.00', 'niuzaiku.png', '小脚休闲', '广州', '1');
INSERT INTO `merchandise` VALUES ('40', '5', '外套', '360.00', '280.00', 'waitao.png', '韩版休闲', '南京', '1');
INSERT INTO `merchandise` VALUES ('41', '5', '短裙', '90.00', '79.99', 'duanqun.png', '高腰修身', '上海', '1');
INSERT INTO `merchandise` VALUES ('42', '5', '风衣', '400.99', '366.99', 'fengyi.png', '长款双排扣', '杭州', '1');
INSERT INTO `merchandise` VALUES ('43', '5', '毛衣', '160.00', '120.00', 'maoyi.png', '纯色均码', '南京', '1');
INSERT INTO `merchandise` VALUES ('44', '5', '棉服', '580.99', '580.99', 'mianfu.png', '加厚保暖', '苏州', '1');
INSERT INTO `merchandise` VALUES ('45', '5', '短袖', '110.09', '99.99', 'duanxiu.png', '纯棉舒适', '苏州', '1');
INSERT INTO `merchandise` VALUES ('46', '3', '小米5', '1789', '1789', 'cart_thumb.gif', '拍照神器', '中国大陆', '1');
INSERT INTO `merchandise` VALUES ('48', '1', '11', '11.0', '11.0', 'uml.png', '', '11', '1');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NOT NULL,
  `orderNo` int(11) NOT NULL DEFAULT '1',
  `orderdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sum` decimal(22,2) NOT NULL,
  `orderstatus` int(11) NOT NULL DEFAULT '1',
  `dstatus` int(20) NOT NULL,
  `pay` int(20) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `mid` (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('2', '2', '11', '2016-12-04 00:00:00', '11.00', '1', '2', '1');
INSERT INTO `orders` VALUES ('7', '1', '0', '2017-01-04 11:11:32', '3613.90', '1', '0', '1');
INSERT INTO `orders` VALUES ('8', '1', '0', '2017-01-04 11:11:40', '3613.90', '1', '0', '1');
INSERT INTO `orders` VALUES ('9', '1', '0', '2017-01-04 11:11:48', '3613.90', '1', '0', '1');
INSERT INTO `orders` VALUES ('10', '1', '0', '2017-01-04 11:12:07', '3613.90', '1', '0', '1');
INSERT INTO `orders` VALUES ('11', '1', '0', '2017-01-04 13:19:25', '3613.90', '1', '0', '1');
INSERT INTO `orders` VALUES ('12', '1', '0', '2017-01-04 13:20:02', '3613.90', '1', '0', '1');
INSERT INTO `orders` VALUES ('13', '1', '0', '2017-01-04 13:20:30', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('14', '1', '0', '2017-01-04 13:25:03', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('15', '1', '0', '2017-01-04 13:26:32', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('16', '1', '0', '2017-01-04 13:26:57', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('17', '1', '0', '2017-01-04 13:29:42', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('18', '1', '0', '2017-01-04 13:29:44', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('19', '1', '0', '2017-01-04 13:30:07', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('20', '1', '0', '2017-01-04 13:30:08', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('21', '1', '0', '2017-01-04 13:30:35', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('22', '1', '0', '2017-01-04 13:33:37', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('23', '1', '0', '2017-01-04 13:33:39', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('24', '1', '0', '2017-01-04 13:36:20', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('25', '1', '0', '2017-01-04 13:36:32', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('26', '1', '0', '2017-01-04 13:36:49', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('27', '1', '0', '2017-01-04 13:36:56', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('28', '1', '0', '2017-01-04 13:36:57', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('29', '1', '0', '2017-01-04 13:37:03', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('30', '1', '0', '2017-01-04 13:37:06', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('31', '1', '0', '2017-01-04 13:37:32', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('32', '1', '0', '2017-01-04 13:37:34', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('33', '1', '0', '2017-01-04 13:37:40', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('34', '1', '0', '2017-01-04 13:38:03', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('35', '1', '0', '2017-01-04 13:38:37', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('36', '1', '0', '2017-01-04 13:38:42', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('37', '1', '0', '2017-01-04 13:38:50', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('38', '1', '0', '2017-01-04 13:38:51', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('39', '1', '0', '2017-01-04 13:38:57', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('40', '1', '0', '2017-01-04 13:39:24', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('41', '1', '0', '2017-01-04 13:39:25', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('42', '1', '0', '2017-01-04 13:39:30', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('43', '1', '0', '2017-01-04 13:39:35', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('44', '1', '0', '2017-01-04 13:39:41', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('45', '1', '0', '2017-01-04 13:39:43', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('46', '1', '0', '2017-01-04 13:39:48', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('47', '1', '0', '2017-01-04 13:40:13', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('48', '1', '0', '2017-01-04 13:40:19', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('49', '1', '0', '2017-01-04 13:40:20', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('50', '1', '0', '2017-01-04 13:40:25', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('51', '1', '0', '2017-01-04 13:40:47', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('52', '1', '0', '2017-01-04 13:40:57', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('53', '1', '0', '2017-01-04 13:40:58', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('54', '1', '0', '2017-01-04 13:41:08', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('55', '1', '0', '2017-01-04 13:41:14', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('56', '1', '0', '2017-01-04 13:41:25', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('57', '1', '0', '2017-01-04 13:42:15', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('58', '1', '0', '2017-01-04 13:42:44', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('59', '1', '0', '2017-01-04 13:43:09', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('60', '1', '0', '2017-01-04 13:43:16', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('61', '1', '0', '2017-01-04 13:43:23', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('62', '1', '0', '2017-01-04 13:43:54', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('63', '1', '0', '2017-01-04 13:44:00', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('64', '1', '0', '2017-01-04 13:44:07', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('65', '1', '0', '2017-01-04 13:44:32', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('66', '1', '0', '2017-01-04 13:44:33', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('67', '1', '0', '2017-01-04 13:45:08', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('68', '1', '0', '2017-01-04 13:45:24', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('69', '1', '0', '2017-01-04 13:46:11', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('70', '1', '0', '2017-01-04 13:46:29', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('71', '1', '0', '2017-01-04 13:47:03', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('72', '1', '0', '2017-01-04 13:47:05', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('73', '1', '0', '2017-01-04 13:47:27', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('74', '1', '0', '2017-01-04 13:47:34', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('75', '1', '0', '2017-01-04 13:47:59', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('76', '1', '0', '2017-01-04 13:48:14', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('77', '1', '0', '2017-01-04 13:48:22', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('78', '1', '0', '2017-01-04 13:48:45', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('79', '1', '0', '2017-01-04 13:49:07', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('80', '1', '0', '2017-01-04 13:49:14', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('81', '1', '0', '2017-01-04 13:50:55', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('82', '1', '0', '2017-01-04 13:51:25', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('83', '1', '0', '2017-01-04 13:53:14', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('84', '1', '0', '2017-01-04 13:53:25', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('85', '1', '0', '2017-01-04 13:53:54', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('86', '1', '0', '2017-01-04 13:55:44', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('87', '1', '0', '2017-01-04 13:56:02', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('88', '1', '0', '2017-01-04 13:56:21', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('89', '1', '0', '2017-01-04 13:56:53', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('90', '1', '0', '2017-01-04 13:57:00', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('91', '1', '0', '2017-01-04 13:57:35', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('92', '1', '0', '2017-01-04 13:59:17', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('93', '1', '0', '2017-01-04 14:01:53', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('94', '1', '0', '2017-01-04 14:02:08', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('95', '1', '0', '2017-01-04 14:08:01', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('96', '1', '0', '2017-01-04 14:08:26', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('97', '1', '0', '2017-01-04 14:08:33', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('98', '1', '0', '2017-01-04 14:10:06', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('99', '1', '0', '2017-01-04 14:10:35', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('100', '1', '0', '2017-01-04 14:11:50', '1797.00', '1', '0', '1');
INSERT INTO `orders` VALUES ('106', '5', '0', '2017-01-04 15:45:42', '1797.00', '1', '0', '1');

-- ----------------------------
-- Table structure for `shouye`
-- ----------------------------
DROP TABLE IF EXISTS `shouye`;
CREATE TABLE `shouye` (
  `sid` int(11) NOT NULL,
  `sname` varchar(22) DEFAULT NULL,
  `sno` varchar(9) DEFAULT NULL,
  `snation` varchar(22) DEFAULT NULL,
  `scity` varchar(22) DEFAULT NULL,
  `scolor` varchar(22) DEFAULT NULL,
  `ssize` varchar(50) DEFAULT NULL,
  `sdate` datetime DEFAULT NULL,
  `scharact` varchar(4000) DEFAULT NULL,
  `sother` varchar(4000) DEFAULT NULL,
  `spic` varchar(4000) DEFAULT NULL,
  `sprice` decimal(65,2) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shouye
-- ----------------------------
INSERT INTO `shouye` VALUES ('1', '小米手机', '2402696', '中国', '上海', '黑色', '小米5代', '2016-03-01 00:00:00', '安卓系统、指纹识别、双卡双带，超长待机', '像素1600万以上，电池容量3000Ah', 'cart_thumb.gif', '1789.00');
INSERT INTO `shouye` VALUES ('2', '菠萝果干', '1623285', '中国', '福建', '黄色', '100*3袋', '2016-12-10 00:00:00', '采用新鲜菠萝，添加白砂糖，葡萄糖，焦亚硫酸钠，无防腐剂', '保质期360天，净含量200克', 'guogan.png', '27.90');
INSERT INTO `shouye` VALUES ('3', '短裙', '483', '中国', '苏州', '酒红色、黑白色、黑色', 'S、M、L、XL', '2016-04-04 00:00:00', '韩版高腰A字裙、毛呢材质、秋季款、适用年龄18-24岁', '通勤风格、纯色短裙', 'duanqun.png', '78.90');
INSERT INTO `shouye` VALUES ('4', '短袖', 'TX1001', '中国', '杭州', '黑色、白色', 'S、M、L、XL', '2016-08-22 00:00:00', '电商销售、韩版文艺风、修身常规款、圆领纯色', '棉50%、纤维45%、2016夏季热款', 'duanxiu.png', '78.90');
INSERT INTO `shouye` VALUES ('5', '笔筒', '9115', '中国', '杭州', '白色、黑色、粉色', '小号、中号、大号', '0201-05-26 00:00:00', 'DIY创意礼物，塑料材质。馒头家族元素', '多功能方形笔筒，得力品牌', 'bitong.png', '27.90');
INSERT INTO `shouye` VALUES ('6', '护手霜', null, null, null, null, null, null, null, null, 'hushoushuang.png', null);
INSERT INTO `shouye` VALUES ('8', '毛衣', null, null, null, null, null, null, null, null, 'maoyi.png', null);
INSERT INTO `shouye` VALUES ('9', '坚果', null, null, null, null, null, null, null, null, 'jianguo.png', null);
INSERT INTO `shouye` VALUES ('10', '毛衣', null, null, null, null, null, null, null, null, 'maoyi.png', null);
INSERT INTO `shouye` VALUES ('11', '风衣', null, null, null, null, null, null, null, null, 'fengyi.png', null);
INSERT INTO `shouye` VALUES ('111', '电饭锅', null, null, null, null, null, null, null, null, 'dianfanguo.png', null);
