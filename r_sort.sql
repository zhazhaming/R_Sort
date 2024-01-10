/*
 Navicat Premium Data Transfer

 Source Server         : practice


 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : r_sort

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 10/01/2024 23:42:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
                          `id` int NOT NULL,
                          `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                          `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                          `createDate` date NULL DEFAULT NULL,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin', '2024-01-07');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
                            `Id` int NOT NULL AUTO_INCREMENT,
                            `Title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                            `Introduce` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
                            `Content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
                            `StartTime` date NULL DEFAULT NULL,
                            `EndTime` date NULL DEFAULT NULL,
                            PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '农村垃圾处理', '随着农村的经济发展和基础设施建设速度快，农村城镇化水平不断提高，推进美丽乡村建设', '  随着农村的经济发展和基础设施建设速度快，农村城镇化水平不断提高，推进美丽乡村建设，但农村生活垃圾治理是在及将来的重点难点，农村的垃圾处理建设长期以来落后于城市，而且存在差距越来越大的倾向。大量的生活垃圾难以处理，严重污染了农村环境，制约着农村的可持续发展。 近年来，随着农村经济的快速发展和居民生活水平的不断提高，农村生活垃圾的产量日益增加；农村生活垃圾得不到及时有效的处理，容易造成对农村环境的污染。因此，农村生活垃圾处理成为改善农村环境亟待解决的问题。\r\n\r\n一、主要存在的问题\r\n\r\n1、垃圾处理设施不足。作为20个行政村街道两万多人口的山区镇只有垃圾中转站3个，垃圾处理设施偏少。固定的垃圾中转站、垃圾运输车也没有完全使用到位，对现有的垃圾填埋场没有采取防渗防漏处理措施的。\r\n\r\n2、农村生活垃圾产生量大、成份复杂、再利用率不高。过去，农村垃圾以厨房剩余物以及菜叶瓜皮为主，大部分以堆肥、沤肥、直接还田等传统处理方式进入自然生态循环系统。现在，随着农村生产生活方式的发展变化，农村生活垃圾成分发生了明显变化，一次性用品废弃物明显增多，尤其是塑料袋、废电池、光盘、农药瓶等在生活垃圾中的比例逐年增大，这些随意丢在沟渠、塘边，严重污染了环境。其中许多成分危害大、难降解，依靠传统的方式根本无法处理。加之垃圾收集和处理系统不健全，随意弃置的垃圾成为农村环境的主要污染源，不仅污染大气和土壤，孳生蚊蝇、老鼠等，还会产生大量毒性很强的渗滤液，经雨水冲刷渗入水体，严重危及农村饮水安全，影响人民群众身体健康。\r\n\r\n3、垃圾处理方式简单。垃圾处理基本采取集中填埋、焚烧。垃圾填埋也只进行简单堆放，甚至只是采用简单露天堆积，无法从根本上解决垃圾的去向问题，垃圾没有进行无害化处理直接，导致分散的垃圾污染变成集中污染或二次污染。\r\n\r\n4、机构队伍力量不足、资金难保障。全镇现配备村级保洁员仅45人，且年龄偏大。集镇人口多，也存在保洁力量弱、资金保障能力差。没有建立垃圾处理资金保障机制，保洁费用收取难、收取资金少，仅够维持少量人员经费。乡镇财力弱，对垃圾处理设施维护资金投入不多。\r\n\r\n二、造成农村垃圾处理难的原因\r\n\r\n1、环卫意识不强。众多农民环保意识差，对农村“脏、乱、差”现象习以为常，缺乏遏制环境污染的主观性。更有一些住户，随地倒垃圾并称自己并不是保洁员，卫生就应该有保洁员负责,现在仍然存在“干部干，群众看”现象。\r\n\r\n2、经费不足。政府是推行垃圾集中收集处理的实施主体和责任主体承担垃圾填埋基础设施建设的配套投入，而且还要承担垃圾中转站的运行、维护和人员工资以及村保洁员的费用补贴。由于镇财力有限、村集体经济薄弱，难以承受这么大的财力负担。\r\n\r\n三、解决垃圾处理问题的对策措施\r\n\r\n1、加强宣教，从源头上减少垃圾污染。充分利用村村通广播、宣传栏等开展多种形式宣传教育活动，中小学校开设环卫常识课，大力宣传科学、卫生、环保方面的知识，积极开展“小手拉大手”活动，宣传环境保护的现实意义，宣传垃圾污染的危害性，宣倡导移风易俗，引导、促进广大农民转变传统的思想观念，改变不良的生活习惯，从而从源头上减少垃圾的污染。\r\n\r\n2、做好分类减量，实现垃圾减量化的目标。按照垃圾处理“无害化、资源化、减量化”要求，建立“自觉分类会聚，区域压缩运输，分区无害处理”的垃圾收运模式。通过宣传让农户将本户日产生活垃圾按照低污染可降解垃圾和高污染不可降解垃圾进行初步分类收集。大力发展沼气工程，以提高农村垃圾处理的效率，减少农村垃圾的排放总量。\r\n\r\n3、解决好钱”的问题——拓宽渠道，多方筹措垃圾处理经费。一是拓展上级政策。积极创造条件，争取更多资金补助。二是实行财政以奖代补。财政每年安排一定专项资金，通过“以奖代补”形式，对村保洁员报酬给予一定补助。三是提倡有偿保洁。按“一事一议”原则，采取村民大会或村民代表大会表决办法，建立村庄环境卫生有偿保洁制度，向村民适当收取保洁费，并对辖区内的商店、企业收取一定保洁费。\r\n\r\n4、充分发挥市场配置资源的基础性作用。基层政府要明确“谁投资，谁受益”的原则。充分发挥保洁公司作用，落实保洁公司的主体责任;另一方面，也要体现“谁污染，谁治理”的原则。出台相关政策，逐步在各地实行生活，生产垃圾收费制度，明确垃圾收费相关事宜，在使垃圾得到有效的减量的同时，弥补财政投入的不足。\r\n\r\n5、加强对农村垃圾处理工作的监管、指导,改变对垃圾的管理。运用行政手段对农村垃圾处理进行强制性规范实施，建立垃圾回收制度，以“减量化、无害化、资源化”原则为导向，结合村庄特点建设回收站、小型处理厂。', '2023-12-03', '2023-12-10');
INSERT INTO `article` VALUES (2, '农村垃圾分类的思考', '今年以来，随着疫情防控在乡村的全面落实，各种形之有效卫生健康普及宣传，结合美丽乡村建设、农村垃圾分类宣传、推进取得明显成效', '  今年以来，随着疫情防控在乡村的全面落实，各种形之有效卫生健康普及宣传，结合美丽乡村建设、农村垃圾分类宣传、推进取得明显成效，使广大村民环保意识明显增强了，村民对于垃圾分类意识也同步提高。垃圾分类是一个系统工程，更是一项造福于子孙后代的民生福祉工程。推动农村生活垃圾分类处理，完善农村生活垃圾分类处理，促进垃圾分类和资源化利用建立，是建设美丽乡村的必由之路。下一步，就是要把他们认可的想法逐渐转变为生活习惯，来推动农村垃圾分类。当前，全县正大力推进生活垃圾分类向基层农村推进，做好农村垃圾分类也是重要工程。结合当前驻村现状形势，就乡村垃圾分类治理的工作提出一点思考：\r\n\r\n一、农村垃圾分类的现状\r\n\r\n所驻行政村下辖4个自然村，其中二个自然小村在山里，村人口约2300余人，约820余户。垃圾分类采用网格化管理，“两委”干部、党员分片包干，监督垃圾分类执行情况。目前，农村生活垃圾主要以厨余垃圾和易腐蚀垃圾为主，但近些年随着生活水平提高，农村生活垃圾产生量迅速增加，农村生活垃圾的成分变得多样化，其他如塑料袋、泡沫盒、玻璃、金属、等生活垃圾比例攀升，处理变得困难。建筑垃圾呈上升趋势，随意丢弃或露天堆放、废弃农药瓶内残留农药等现象存在，容易污染周边的土地和水体环境，容易滋生蚊蝇，破坏了水资源、土壤、空气，破坏美丽乡村自然景观,影响居民生活和农业生产。\r\n\r\n二、当前垃圾分类工作中存在的问题\r\n\r\n一是村民的垃圾分类意识还有待增强。当前农村生活垃圾分类减量处理工作启动时间不长，宣传发动工作刚开始，群众基础不够扎实，对垃圾分类工作的认识还不到位，一些村民垃圾分类知识普及不够，村民自己动手垃圾分类能力有待提高，行为习惯尚未真正养成。二是垃圾收运规范化水平还有待提升。在垃圾收运工作开展过程中，部分村级保洁员自身分类意识不强，工作不到位，容易造成一些保洁人员将已进行垃圾分类的厨余垃圾、有害垃圾再混收混运，存在着“先分后混”的尴尬局面。三是垃圾分类在村级事务中管理高度不够。目前村级组织尽管有参与的热情且在每周工作例会中得到体现与会商，但尚未将垃圾分类纳入组织章程中，缺少长效机制保障。造成经常会商，缺少具体举措和落实的措施。处于推动下显成效，不推回原点的状态。四是垃圾分类的参与主体还有待扩增。垃圾分类工作尚处在起步阶段，主要还是靠政府在推动，村级组织落实。而垃圾分类各个环节需要更多党员、村民代表、社会参与，虽采取分片包干监督的网格化管理，但在执行过程中存在时紧时松现象。目前从事垃圾分类的专业企业还比较少，市场化运作还有一定的操作难度。村级组织中的作用显现不够突出。五是村级组织在实施过程中缺乏足够的资金支持。由于村集体经济薄弱，收入来源匮乏。专门用于垃圾分类的资金得不到充分保障。在人员安排、设施保障、后期处理等方面滞后于垃圾分类现状，使垃圾分类不能有效推进。\r\n\r\n三、推进农村垃圾分类的几点建议\r\n\r\n1、日常生活垃圾几种分类方法。农村生活垃圾分类处理是一项系统工程，需要结合农村实际，统筹考虑农村生活垃圾的利用、处理，探索方式多样的生活垃圾收运处置体系。目前在开展的垃圾分类收集处理工作，通行的基本做法有四法，即分为可回收垃圾、餐厨垃圾、有害垃圾和其他垃圾。有三分法，即可腐烂和不可腐烂、可回收垃圾。也有简单的两分法，即湿垃圾和干垃圾、可回收和不可回收等几种分法。对于一个区域或行政片来讲，统一垃圾的分法或分类标准，有利于管好、利用好垃圾资源的回收利用。当然，对于资源的回收利用，越细分，利用越充分。但对于刚开始接触垃圾分类的群众来说，分类应从简单分类开始，先易后难，逐步细分，给群众一个接受的过程。可以在各自然村先从两分开始，落实垃圾分类指导员，指导他们把垃圾按可腐烂和不可腐烂分类。对农村餐厨垃圾、其他垃圾、装修垃圾（大件垃圾）等实行分流，由保洁员等专业人员收集送至村、镇垃圾分类收集分拣站或有机垃圾处理站，餐厨垃圾进行资源化处理，大件垃圾进行拆解、破碎、分拣和分类。可腐烂的餐厨垃圾通过定点投放、定时收集、定车运输、定点处理，通过机械制肥，达到资源循环利用。不可腐烂的垃圾，通过专用运输车收集后，集中压块，运往焚烧厂作焚烧发电处理。\r\n\r\n2、继续加大宣传垃圾分类。进一步加大宣传力度利用，宣传标语和图文并茂的宣传画、墙画，培训说明会、垃圾收集车循环播放垃圾分类知识等多种群众喜闻乐见的形式，让村民详细了解垃圾分类处理的意义，明确具体的分类标准、主要做法和自己所承担的责任与义务，以及先进农户典型做法的宣传。强化农民对农村环保认同感、知晓度。鼓励镇村干部党员以志愿服务名义进村入户，广泛开展“听民情、汇民意”活动，召开各种形式的恳谈会，面对面与农民群众宣传沟通，广聚民意，充分发挥农民积极性、主动性和创造性。\r\n\r\n3、加强垃圾分类教育培训。以家庭为单位，建立垃圾分类分层培训制度，对一线垃圾分类指导员、监督员、村民小组长、党员骨干、保洁员分别进行分类培训，增强全民垃圾分类的意识，逐步形成“垃圾分类，从我做起”的良好习惯。在中小学开设资源回收再利用课程，培养学生垃圾分类、资源节约和环境保护意识，逐步改变村民的传统观念，让村民认识到垃圾分类的重要性，引导村民自觉参与。制定切合当地农民实际的农村生活垃圾分类管理规范要求，用制度规范村民行为。垃圾分类不是一朝一夕就能完成的一项工作，它需要村民真正自觉自愿地参与其中，并逐渐养成一种生活习惯，使其成为新的生活方式。同时，在加强宣传的基础上，引进奖励和激励机制，对一些日常垃圾分类做的好的农户采取挂牌“示范户”的形式，给予一定的物质奖励。对一些进步明显并在村中积极争做垃圾分类志愿者的人、户给予适当物质奖励。形成在村中争做垃圾分类的先进户。使垃圾分类在村中有序推进。\r\n\r\n4、探索分类处理第三方服务模式。在农村生活垃圾分类减量处理上，进一步探索第三方服务，进行“政府主导、公开招标、合同管理、评估兑现”第三方服务的管理模式。通过市场竞标，引入竞争机制，成立美丽乡村环境服务有限公司。政府部门抓管理，环境服务有限公司具体做，彻底解决农村生活垃圾分类“易反复、常反弹”的困扰，提高农村生活垃圾分类减量处理质量和群众满意度。同时也减轻村在资金上的投入。\r\n\r\n5、发挥党员干部带头作用。要注重发挥农村党员先锋模范作用，把环境整治等攻坚克难的农村工作与基层党建工作结合起来，选聘鼓励镇村干部进村入户义务监督员，完善农村生活垃圾分类减量处理、长效保洁、公用设施管护维护制度。积极开展党员干部“垃圾分类、美化家园”义务劳动活动。同时，将党员联户帮扶工作与日常垃圾分类的宣传、监督工作有机结合起来，使党员联户工作的内容更加宽泛，责任更加明确。引导农民积极参与农村生活垃圾分类减量处理。宣传发动、邻里互动，进一步激发广大农民群众农村生活垃圾分类减量处理的热情。', '2023-12-03', '2023-12-10');

-- ----------------------------
-- Table structure for garbage_encyclopedia
-- ----------------------------
DROP TABLE IF EXISTS `garbage_encyclopedia`;
CREATE TABLE `garbage_encyclopedia`  (
                                         `garbage_id` int NOT NULL AUTO_INCREMENT,
                                         `garbage_type` int NULL DEFAULT NULL COMMENT '垃圾类别(1其他垃圾，2可回收垃圾，3厨余垃圾，4有害垃圾)',
                                         `garbage_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '垃圾名称',
                                         `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '垃圾标语',
                                         PRIMARY KEY (`garbage_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 143 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of garbage_encyclopedia
-- ----------------------------
INSERT INTO `garbage_encyclopedia` VALUES (1, 1, '废纸', '废纸不要乱丢呀，会污染环境');
INSERT INTO `garbage_encyclopedia` VALUES (2, 1, '保鲜膜', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (3, 1, '椰子壳', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (4, 1, '一次性餐具', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (5, 1, '榴莲壳', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (6, 1, '湿纸巾', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (7, 1, '创口贴', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (8, 1, '竹筷子', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (9, 1, '橡皮泥', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (10, 1, '过期化妆品', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (11, 1, '干燥剂', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (12, 1, '坚果壳', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (13, 1, '口香糖', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (14, 1, '海绵', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (15, 1, '渣土', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (16, 1, '大棒骨', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (17, 1, '旧毛巾', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (18, 1, '贝壳', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (19, 1, '胶带', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (20, 1, '镜子', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (21, 1, '陶瓷制品', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (22, 1, '一次性口罩', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (23, 1, '防碎气泡膜', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (24, 1, '毛发', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (25, 1, '茶叶袋', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (26, 1, '笔', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (27, 1, '文件袋', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (28, 1, '盘子', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (29, 1, '眼镜', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (30, 1, '脏塑料袋', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (31, 1, '牙膏皮', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (32, 1, '用过的卫生纸', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (33, 1, '一次性杯子', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (34, 1, '彩笔', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (35, 1, '脏衣服', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (36, 1, '烟头', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (37, 2, '废铁锅', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (38, 2, '塑料玩具', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (39, 2, '玻璃片', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (40, 2, '布料', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (41, 2, '废指甲钳', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (42, 2, '废铁文具盒', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (43, 2, '洗发水瓶', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (44, 2, '金属罐头盒', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (45, 2, '旧茶几', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (46, 2, '旧毛毯', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (47, 2, '旧手机', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (48, 2, '旧塑料果篮', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (49, 2, '旧刀片', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (50, 2, '旧电视', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (51, 2, '食品保鲜盒', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (52, 2, '玩具', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (53, 2, '金属零件', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (54, 2, '信封', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (55, 2, '易拉罐', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (56, 2, '牛奶盒', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (57, 2, '旧衣服\r\n', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (58, 2, '书本', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (59, 2, '矿泉水瓶', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (60, 2, '未被污染的布料', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (61, 2, '碎玻璃瓶', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (62, 2, '墨水瓶', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (63, 2, '电脑', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (64, 2, '玻璃瓶', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (65, 2, '纸皮箱', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (66, 2, '旧报纸', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (67, 2, '衣服', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (68, 2, '废锁头', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (69, 2, '塑胶', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (70, 2, '毛绒玩具', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (71, 2, '香水瓶', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (72, 2, '插座', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (73, 3, '蛋糕', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (74, 3, '饼干', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (75, 3, '蔬菜', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (76, 3, '豆类', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (77, 3, '面包', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (78, 3, '宠物粮食', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (79, 3, '香蕉皮', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (80, 3, '吃剩的鸡爪', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (81, 3, '剩菜剩饭', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (82, 3, '玉米核', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (83, 3, '柔韧面食', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (84, 3, '果核', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (85, 3, '鱼骨', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (86, 3, '坚硬骨头', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (87, 3, '茶叶残渣', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (88, 3, '骨骼内脏', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (89, 3, '果壳', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (90, 3, '废弃食品', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (91, 3, '残枝落叶', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (92, 3, '废弃食用油', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (93, 3, '甘蔗渣', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (94, 3, '干脆面', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (95, 3, '奶茶中的珍珠', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (96, 3, '过期的巧克力', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (97, 3, '仙人球', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (98, 3, '油烟机的油脂', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (99, 3, '小龙虾', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (100, 3, '中药药渣', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (101, 3, '螃蟹壳', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (102, 3, '西瓜籽', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (103, 3, '玉米叶', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (104, 3, '玉米须', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (105, 3, '调料', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (106, 3, '粽子馅', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (107, 3, '苹果', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (108, 4, '节能灯泡', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (109, 4, '农药', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (110, 4, '染发剂壳', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (111, 4, '杀虫剂', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (112, 4, '电池', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (113, 4, '废荧光灯管', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (114, 4, '水银温度计', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (115, 4, '油漆桶', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (116, 4, '过期药品', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (117, 4, '消毒剂', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (118, 4, '充电电池', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (119, 4, '废弃油桶', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (120, 4, '卤素灯', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (121, 4, '蓄电池', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (122, 4, '杀虫喷雾', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (123, 4, '相片底片', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (124, 4, '水银血压计', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (125, 4, '汽油', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (126, 4, '废胶卷', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (127, 4, '废弃化妆品', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (128, 4, 'x光片', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (129, 4, '发胶', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (130, 4, '指甲油', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (131, 4, '废氧化录电池', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (132, 4, '废铅蓄电池', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (133, 4, '油漆', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (134, 4, '滴眼液', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (135, 4, '止痛膏', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (136, 4, '老鼠药', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (137, 4, '废日光灯泡', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (138, 4, '过期止咳糖浆', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (139, 4, '含水银的LED灯', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (140, 4, '铭镇电池', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (141, 4, '荧光棒', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (142, 4, '废锂电池', NULL);
INSERT INTO `garbage_encyclopedia` VALUES (143, 4, '废碳粉墨盒', NULL);

-- ----------------------------
-- Table structure for garbage_type
-- ----------------------------
DROP TABLE IF EXISTS `garbage_type`;
CREATE TABLE `garbage_type`  (
                                 `g_type` int NULL DEFAULT NULL,
                                 `g_message` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                 `g_explain` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                 `contain` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                 `tip` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of garbage_type
-- ----------------------------
INSERT INTO `garbage_type` VALUES (1, '其他垃圾', '其它垃圾，指除可回收物、有害垃圾、厨余垃圾（湿垃圾）以外的其它生活废弃物', '常见包括砖瓦陶瓷、渣土、卫生间废纸、猫砂、污损塑料、毛发、硬壳、一次性制品、灰土、瓷器碎片等难以回收的废弃物', '尽量沥干水分；难以辨识类别的生活垃圾都可以投入干垃圾容器内');
INSERT INTO `garbage_type` VALUES (2, '可回收垃圾', '可回收垃圾是指适宜回收、可循环利用的生活废弃物', '常见包括各类废金属、玻璃瓶、易拉罐、饮料瓶、塑料玩具、书本、报纸、广告单、纸板箱、衣服、床上用品、电子产品等', '轻投轻放；清洁干燥，避免污染，费纸尽量平整；立体包装物请清空内容物，清洁后压扁投放；有尖锐边角的、应包裹后投放');
INSERT INTO `garbage_type` VALUES (3, '厨余垃圾', '厨余垃圾是指居民日常生活及食品加工、饮食服务、单位供餐等活动中产生的垃圾', '常见包括菜叶、剩菜、剩饭、果皮、蛋壳、茶渣、骨头等', '纯流质的食物垃圾、如牛奶等，应直接倒进下水口。有包装物的湿垃圾应将包装物去除后分类投放、包装物请投放到对应的可回收物或干垃圾容器');
INSERT INTO `garbage_type` VALUES (4, '有害垃圾', '有害垃圾是指存有对人体健康有害的重金属、有毒的物质或者对环境造成现实危害或者潜在危害的废弃物', '常见包括废电池、废荧光灯管、废灯泡、废水银温度计、废油漆桶、过期药品、农药、杀虫剂等', '分类投放有害垃圾时，应注意轻放。其中：废灯管等易破损的有害垃圾应连带包装或包裹后投放；废弃药品宜连带包装一并投放；杀虫剂等压力罐装容器，应排空内容物后投放；在公共场所产生有害垃圾且未发现对应收集容器时，应携带至有害垃圾投放点妥善投放');

-- ----------------------------
-- Table structure for volunteer
-- ----------------------------
DROP TABLE IF EXISTS `volunteer`;
CREATE TABLE `volunteer`  (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `missionId` int NOT NULL,
                              `districtName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                              `subject` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                              `startDate` datetime NULL DEFAULT NULL,
                              `endDate` datetime NULL DEFAULT NULL,
                              `missionTypeName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                              `missionRegionName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                              `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of volunteer
-- ----------------------------
INSERT INTO `volunteer` VALUES (1, 8105247, '博罗县手有余香', '2024年博罗县新时代文明实践活动罗阳街道观背村乡村少年宫——为“爱”弯腰 益起捡跑 亲子志愿服务活动', '2024-01-06 09:00:00', '2024-01-06 12:00:00', '文明实践', '博罗县', 'https://www.izyz.org/mission/detail-8105247');
INSERT INTO `volunteer` VALUES (2, 8105196, '白莲洞公园志愿服务分队', '白莲洞公园城市服务驿站', '2024-01-06 08:00:00', '2024-01-31 18:59:59', '社区服务', '香洲区', 'https://www.izyz.org/mission/detail-8105196');

SET FOREIGN_KEY_CHECKS = 1;
