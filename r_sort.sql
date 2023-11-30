/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.26 : Database - r_sort
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`r_sort` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `r_sort`;

/*Table structure for table `garbage_encyclopedia` */

DROP TABLE IF EXISTS `garbage_encyclopedia`;

CREATE TABLE `garbage_encyclopedia` (
  `garbage_id` int NOT NULL AUTO_INCREMENT,
  `garbage_type` int DEFAULT NULL COMMENT '垃圾类别(1其他垃圾，2可回收垃圾，3厨余垃圾，4有害垃圾)',
  `garbage_name` varchar(50) DEFAULT NULL COMMENT '垃圾名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '垃圾标语',
  PRIMARY KEY (`garbage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8mb3;

/*Data for the table `garbage_encyclopedia` */

insert  into `garbage_encyclopedia`(`garbage_id`,`garbage_type`,`garbage_name`,`remark`) values (1,1,'废纸','废纸不要乱丢呀，会污染环境'),(2,1,'保鲜膜',NULL),(3,1,'椰子壳',NULL),(4,1,'一次性餐具',NULL),(5,1,'榴莲壳',NULL),(6,1,'湿纸巾',NULL),(7,1,'创口贴',NULL),(8,1,'竹筷子',NULL),(9,1,'橡皮泥',NULL),(10,1,'过期化妆品',NULL),(11,1,'干燥剂',NULL),(12,1,'坚果壳',NULL),(13,1,'口香糖',NULL),(14,1,'海绵',NULL),(15,1,'渣土',NULL),(16,1,'大棒骨',NULL),(17,1,'旧毛巾',NULL),(18,1,'贝壳',NULL),(19,1,'胶带',NULL),(20,1,'镜子',NULL),(21,1,'陶瓷制品',NULL),(22,1,'一次性口罩',NULL),(23,1,'防碎气泡膜',NULL),(24,1,'毛发',NULL),(25,1,'茶叶袋',NULL),(26,1,'笔',NULL),(27,1,'文件袋',NULL),(28,1,'盘子',NULL),(29,1,'眼镜',NULL),(30,1,'脏塑料袋',NULL),(31,1,'牙膏皮',NULL),(32,1,'用过的卫生纸',NULL),(33,1,'一次性杯子',NULL),(34,1,'彩笔',NULL),(35,1,'脏衣服',NULL),(36,1,'烟头',NULL),(37,2,'废铁锅',NULL),(38,2,'塑料玩具',NULL),(39,2,'玻璃片',NULL),(40,2,'布料',NULL),(41,2,'废指甲钳',NULL),(42,2,'废铁文具盒',NULL),(43,2,'洗发水瓶',NULL),(44,2,'金属罐头盒',NULL),(45,2,'旧茶几',NULL),(46,2,'旧毛毯',NULL),(47,2,'旧手机',NULL),(48,2,'旧塑料果篮',NULL),(49,2,'旧刀片',NULL),(50,2,'旧电视',NULL),(51,2,'食品保鲜盒',NULL),(52,2,'玩具',NULL),(53,2,'金属零件',NULL),(54,2,'信封',NULL),(55,2,'易拉罐',NULL),(56,2,'牛奶盒',NULL),(57,2,'旧衣服\r\n',NULL),(58,2,'书本',NULL),(59,2,'矿泉水瓶',NULL),(60,2,'未被污染的布料',NULL),(61,2,'碎玻璃瓶',NULL),(62,2,'墨水瓶',NULL),(63,2,'电脑',NULL),(64,2,'玻璃瓶',NULL),(65,2,'纸皮箱',NULL),(66,2,'旧报纸',NULL),(67,2,'衣服',NULL),(68,2,'废锁头',NULL),(69,2,'塑胶',NULL),(70,2,'毛绒玩具',NULL),(71,2,'香水瓶',NULL),(72,2,'插座',NULL),(73,3,'蛋糕',NULL),(74,3,'饼干',NULL),(75,3,'蔬菜',NULL),(76,3,'豆类',NULL),(77,3,'面包',NULL),(78,3,'宠物粮食',NULL),(79,3,'香蕉皮',NULL),(80,3,'吃剩的鸡爪',NULL),(81,3,'剩菜剩饭',NULL),(82,3,'玉米核',NULL),(83,3,'柔韧面食',NULL),(84,3,'果核',NULL),(85,3,'鱼骨',NULL),(86,3,'坚硬骨头',NULL),(87,3,'茶叶残渣',NULL),(88,3,'骨骼内脏',NULL),(89,3,'果壳',NULL),(90,3,'废弃食品',NULL),(91,3,'残枝落叶',NULL),(92,3,'废弃食用油',NULL),(93,3,'甘蔗渣',NULL),(94,3,'干脆面',NULL),(95,3,'奶茶中的珍珠',NULL),(96,3,'过期的巧克力',NULL),(97,3,'仙人球',NULL),(98,3,'油烟机的油脂',NULL),(99,3,'小龙虾',NULL),(100,3,'中药药渣',NULL),(101,3,'螃蟹壳',NULL),(102,3,'西瓜籽',NULL),(103,3,'玉米叶',NULL),(104,3,'玉米须',NULL),(105,3,'调料',NULL),(106,3,'粽子馅',NULL),(107,3,'苹果',NULL),(108,4,'节能灯泡',NULL),(109,4,'农药',NULL),(110,4,'染发剂壳',NULL),(111,4,'杀虫剂',NULL),(112,4,'电池',NULL),(113,4,'废荧光灯管',NULL),(114,4,'水银温度计',NULL),(115,4,'油漆桶',NULL),(116,4,'过期药品',NULL),(117,4,'消毒剂',NULL),(118,4,'充电电池',NULL),(119,4,'废弃油桶',NULL),(120,4,'卤素灯',NULL),(121,4,'蓄电池',NULL),(122,4,'杀虫喷雾',NULL),(123,4,'相片底片',NULL),(124,4,'水银血压计',NULL),(125,4,'汽油',NULL),(126,4,'废胶卷',NULL),(127,4,'废弃化妆品',NULL),(128,4,'x光片',NULL),(129,4,'发胶',NULL),(130,4,'指甲油',NULL),(131,4,'废氧化录电池',NULL),(132,4,'废铅蓄电池',NULL),(133,4,'油漆',NULL),(134,4,'滴眼液',NULL),(135,4,'止痛膏',NULL),(136,4,'老鼠药',NULL),(137,4,'废日光灯泡',NULL),(138,4,'过期止咳糖浆',NULL),(139,4,'含水银的LED灯',NULL),(140,4,'铭镇电池',NULL),(141,4,'荧光棒',NULL),(142,4,'废锂电池',NULL),(143,4,'废碳粉墨盒',NULL);

/*Table structure for table `garbage_type` */

DROP TABLE IF EXISTS `garbage_type`;

CREATE TABLE `garbage_type` (
  `g_type` int DEFAULT NULL,
  `g_message` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `g_explain` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `contain` varchar(100) DEFAULT NULL,
  `tip` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `garbage_type` */

insert  into `garbage_type`(`g_type`,`g_message`,`g_explain`,`contain`,`tip`) values (1,'其他垃圾','其它垃圾，指除可回收物、有害垃圾、厨余垃圾（湿垃圾）以外的其它生活废弃物','常见包括砖瓦陶瓷、渣土、卫生间废纸、猫砂、污损塑料、毛发、硬壳、一次性制品、灰土、瓷器碎片等难以回收的废弃物','尽量沥干水分；难以辨识类别的生活垃圾都可以投入干垃圾容器内'),(2,'可回收垃圾','可回收垃圾是指适宜回收、可循环利用的生活废弃物','常见包括各类废金属、玻璃瓶、易拉罐、饮料瓶、塑料玩具、书本、报纸、广告单、纸板箱、衣服、床上用品、电子产品等','轻投轻放；清洁干燥，避免污染，费纸尽量平整；立体包装物请清空内容物，清洁后压扁投放；有尖锐边角的、应包裹后投放'),(3,'厨余垃圾','厨余垃圾是指居民日常生活及食品加工、饮食服务、单位供餐等活动中产生的垃圾','常见包括菜叶、剩菜、剩饭、果皮、蛋壳、茶渣、骨头等','纯流质的食物垃圾、如牛奶等，应直接倒进下水口。有包装物的湿垃圾应将包装物去除后分类投放、包装物请投放到对应的可回收物或干垃圾容器'),(4,'有害垃圾','有害垃圾是指存有对人体健康有害的重金属、有毒的物质或者对环境造成现实危害或者潜在危害的废弃物','常见包括废电池、废荧光灯管、废灯泡、废水银温度计、废油漆桶、过期药品、农药、杀虫剂等','分类投放有害垃圾时，应注意轻放。其中：废灯管等易破损的有害垃圾应连带包装或包裹后投放；废弃药品宜连带包装一并投放；杀虫剂等压力罐装容器，应排空内容物后投放；在公共场所产生有害垃圾且未发现对应收集容器时，应携带至有害垃圾投放点妥善投放');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
