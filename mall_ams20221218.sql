-- MariaDB dump 10.19  Distrib 10.5.17-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: mall_ams
-- ------------------------------------------------------
-- Server version	10.5.17-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ams_admin`
--

DROP TABLE IF EXISTS `ams_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ams_admin` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` char(64) DEFAULT NULL COMMENT '密码（密文）',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像URL',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `enable` tinyint(3) unsigned DEFAULT 0 COMMENT '是否启用，1=启用，0=未启用',
  `last_login_ip` varchar(50) DEFAULT NULL COMMENT '最后登录IP地址（冗余）',
  `login_count` int(10) unsigned DEFAULT 0 COMMENT '累计登录次数（冗余）',
  `gmt_last_login` datetime DEFAULT NULL COMMENT '最后登录时间（冗余）',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ams_admin`
--

LOCK TABLES `ams_admin` WRITE;
/*!40000 ALTER TABLE `ams_admin` DISABLE KEYS */;
INSERT INTO `ams_admin` VALUES (1,'root','$2a$10$N.ZOn9G6/YLFixAOPMg/h.z7pCu6v2XyFDtC4q.jeeGm/TEZyj15C','系统管理员','https://img2.baidu.com/it/u=4244269751,4000533845&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','13900139001','root@baidu.com','最高权限的管理员',1,NULL,0,NULL,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(2,'super_admin','$2a$10$N.ZOn9G6/YLFixAOPMg/h.z7pCu6v2XyFDtC4q.jeeGm/TEZyj15C','超级管理员','https://img0.baidu.com/it/u=1600969112,4145041554&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','13900139002','super_admin@baidu.cn','超级管理员，通常具有除了【管理管理员】以外的全部权限',1,NULL,0,NULL,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(3,'liucangsong','$2a$10$N.ZOn9G6/YLFixAOPMg/h.z7pCu6v2XyFDtC4q.jeeGm/TEZyj15C','苍松老师','https://img1.baidu.com/it/u=873106765,2587410047&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1663606800&t=c8de61604dbff6118ae140268f4e3c67','13900139003','liucangsong@baidu.cn','刘苍松老师的账号',1,NULL,0,NULL,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(4,'wangkejing','$2a$10$N.ZOn9G6/YLFixAOPMg/h.z7pCu6v2XyFDtC4q.jeeGm/TEZyj15C','克晶老师','https://img2.baidu.com/it/u=3062813899,1142128231&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1663606800&t=e153f24b4499fce32df24cb1ea1b9efa','13900139004','wangkejing@qq.com','王克晶老师的账号',0,NULL,0,NULL,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(5,'fanchuanqi','$2a$10$N.ZOn9G6/YLFixAOPMg/h.z7pCu6v2XyFDtC4q.jeeGm/TEZyj15C','传奇老师','https://img2.baidu.com/it/u=2704182461,2749837878&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','13900139005','fanchuanqi@baidu.com','范传奇老师的账号',0,NULL,0,NULL,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(9,'武清源1','123456','Devotion','https://img2.baidu.com/it/u=4244269751,4000533845&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','155518980171','2168149199@qq.com1','无',1,'宁波',2,NULL,NULL,NULL),(10,'武清源2','123456','Devotion','https://img2.baidu.com/it/u=4244269751,4000533845&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','155518980172','2168149199@qq.com2','无',1,'宁波',2,NULL,NULL,NULL),(11,'武清源3','123456','Devotion','https://img2.baidu.com/it/u=4244269751,4000533845&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','155518980173','2168149199@qq.com3','无',1,'宁波',2,NULL,NULL,NULL),(12,'武清源4','123456','Devotion','https://img2.baidu.com/it/u=4244269751,4000533845&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','155518980174','2168149199@qq.com4','无',1,'宁波',2,NULL,NULL,NULL),(13,'武清源5','123456','Devotion','https://img2.baidu.com/it/u=4244269751,4000533845&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','155518980175','2168149199@qq.com5','无',1,'宁波',2,NULL,NULL,NULL),(14,'武清源','123456','Devotion','342311kgrfgrepg','15551898017','2168149199@qq.com','无',1,NULL,0,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ams_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ams_admin_role`
--

DROP TABLE IF EXISTS `ams_admin_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ams_admin_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) unsigned DEFAULT NULL COMMENT '管理员id',
  `role_id` bigint(20) unsigned DEFAULT NULL COMMENT '角色id',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='管理员角色关联';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ams_admin_role`
--

LOCK TABLES `ams_admin_role` WRITE;
/*!40000 ALTER TABLE `ams_admin_role` DISABLE KEYS */;
INSERT INTO `ams_admin_role` VALUES (1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(2,2,2,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(3,3,3,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(4,4,4,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(5,4,5,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(6,5,6,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(7,6,2,'2022-11-06 13:59:40','2022-11-06 13:59:40'),(8,6,4,'2022-11-06 13:59:40','2022-11-06 13:59:40'),(9,6,6,'2022-11-06 13:59:40','2022-11-06 13:59:40'),(10,7,3,'2022-11-06 14:07:36','2022-11-06 14:07:36'),(11,7,5,'2022-11-06 14:07:36','2022-11-06 14:07:36'),(15,14,2,'2022-12-11 15:09:57','2022-12-11 15:09:57'),(16,14,3,'2022-12-11 15:09:57','2022-12-11 15:09:57');
/*!40000 ALTER TABLE `ams_admin_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ams_login_log`
--

DROP TABLE IF EXISTS `ams_login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ams_login_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) unsigned DEFAULT NULL COMMENT '管理员id',
  `username` varchar(50) DEFAULT NULL COMMENT '管理员用户名（冗余）',
  `nickname` varchar(50) DEFAULT NULL COMMENT '管理员昵称（冗余）',
  `ip` varchar(50) DEFAULT NULL COMMENT '登录IP地址',
  `user_agent` varchar(255) DEFAULT NULL COMMENT '浏览器内核',
  `gmt_login` datetime DEFAULT NULL COMMENT '登录时间',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理员登录日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ams_login_log`
--

LOCK TABLES `ams_login_log` WRITE;
/*!40000 ALTER TABLE `ams_login_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `ams_login_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ams_permission`
--

DROP TABLE IF EXISTS `ams_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ams_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `value` varchar(255) DEFAULT NULL COMMENT '值',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `sort` tinyint(3) unsigned DEFAULT 0 COMMENT '自定义排序序号',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COMMENT='权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ams_permission`
--

LOCK TABLES `ams_permission` WRITE;
/*!40000 ALTER TABLE `ams_permission` DISABLE KEYS */;
INSERT INTO `ams_permission` VALUES (1,'后台管理-管理员-读取','/ams/admin/read','读取管理员信息，含查看列表、查看详情，及其它查询操作',255,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(2,'后台管理-管理员-添加','/ams/admin/add-new','添加管理员',254,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(3,'后台管理-管理员-删除','/ams/admin/delete','删除管理员',253,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(4,'后台管理-管理员-修改','/ams/admin/update','修改管理员信息，含修改密码、启用、禁用、修改基本资料，及其它修改操作',252,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(5,'后台管理-商品-读取','/pms/product/read','读取商品信息，含商品相关的所有数据的读取操作，查看列表、查看详情，及其它查询操作',99,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(6,'后台管理-商品-添加','/pms/product/add-new','添加商品，含商品相关的所有数据的添加操作',98,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(7,'后台管理-商品-删除','/pms/product/delete','删除商品，含商品相关的所有数据的删除操作',97,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(8,'后台管理-商品-修改','/pms/product/update','修改商品信息，含商品相关的所有数据的修改操作，含所有修改操作',96,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(9,'后台管理-品牌-列表','/pms/brand/read','读取品牌信息，含查看列表、查看详情，及其它查询操作',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(10,'后台管理-品牌-添加','/pms/brand/add-new','添加品牌',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(11,'后台管理-品牌-删除','/pms/brand/delete','删除品牌',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(12,'后台管理-品牌-修改','/pms/brand/update','修改品牌信息，含修改基本资料、启用、禁用，及其它修改操作',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(13,'后台管理-类别-添加','/pms/category/read','读取类别信息，含查看列表、查看详情，及其它查询操作',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(14,'后台管理-类别-添加','/pms/category/add-new','添加类别',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(15,'后台管理-类别-删除','/pms/category/delete','删除类别',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(16,'后台管理-类别-修改','/pms/category/update','修改类别信息，含修改基本资料、启用、禁用，及其它修改操作',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(17,'后台管理-图片-添加','/pms/picture/read','读取图片信息，含查看列表、查看详情，及其它查询操作',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(18,'后台管理-图片-添加','/pms/picture/add-new','添加图片',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(19,'后台管理-图片-删除','/pms/picture/delete','删除图片',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(20,'后台管理-图片-修改','/pms/picture/update','修改图片信息，含所有修改操作',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(21,'后台管理-相册-添加','/pms/album/read','读取相册信息，含查看列表、查看详情，及其它查询操作',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(22,'后台管理-相册-添加','/pms/album/add-new','添加相册',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(23,'后台管理-相册-删除','/pms/album/delete','删除相册',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(24,'后台管理-相册-修改','/pms/album/update','修改相册信息，含所有修改操作',0,'2022-07-08 11:30:44','2022-07-08 11:30:44');
/*!40000 ALTER TABLE `ams_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ams_role`
--

DROP TABLE IF EXISTS `ams_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ams_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `sort` tinyint(3) unsigned DEFAULT 0 COMMENT '自定义排序序号',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ams_role`
--

LOCK TABLES `ams_role` WRITE;
/*!40000 ALTER TABLE `ams_role` DISABLE KEYS */;
INSERT INTO `ams_role` VALUES (1,'系统管理员','最高权限的管理员角色，应该关联所有权限',255,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(2,'超级管理员','除了系统管理员以外的最高权限的管理员角色，应该关联除了【管理员管理】以外的所有权限',255,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(3,'商品管理员','负责商品管理的管理员角色，应该关联与商口相关的所有权限',99,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(4,'品牌管理员','负责管理品牌的管理员角色，应该关联品牌管理的相关权限',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(5,'分类管理员','负责管理类别的管理员角色，应该关联类别管理的相关权限',0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(6,'相册管理员','负责管理图片、相册的管理员角色，应该关联图片管理、相册管理的相关权限',0,'2022-07-08 11:30:44','2022-07-08 11:30:44');
/*!40000 ALTER TABLE `ams_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ams_role_permission`
--

DROP TABLE IF EXISTS `ams_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ams_role_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) unsigned DEFAULT NULL COMMENT '角色id',
  `permission_id` bigint(20) unsigned DEFAULT NULL COMMENT '权限id',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关联';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ams_role_permission`
--

LOCK TABLES `ams_role_permission` WRITE;
/*!40000 ALTER TABLE `ams_role_permission` DISABLE KEYS */;
INSERT INTO `ams_role_permission` VALUES (1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(2,1,2,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(3,1,3,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(4,1,4,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(5,1,5,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(6,1,6,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(7,1,7,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(8,1,8,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(9,1,9,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(10,1,10,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(11,1,11,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(12,1,12,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(13,1,13,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(14,1,14,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(15,1,15,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(16,1,16,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(17,1,17,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(18,1,18,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(19,1,19,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(20,1,20,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(21,1,21,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(22,1,22,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(23,1,23,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(24,1,24,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(25,2,5,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(26,2,6,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(27,2,7,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(28,2,8,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(29,2,9,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(30,2,10,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(31,2,11,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(32,2,12,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(33,2,13,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(34,2,14,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(35,2,15,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(36,2,16,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(37,2,17,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(38,2,18,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(39,2,19,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(40,2,20,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(41,2,21,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(42,2,22,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(43,2,23,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(44,2,24,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(45,3,5,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(46,3,6,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(47,3,7,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(48,3,8,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(49,4,9,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(50,4,10,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(51,4,11,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(52,4,12,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(53,5,13,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(54,5,14,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(55,5,15,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(56,5,16,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(57,6,17,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(58,6,18,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(59,6,19,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(60,6,20,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(61,6,21,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(62,6,22,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(63,6,23,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(64,6,24,'2022-07-08 11:30:44','2022-07-08 11:30:44');
/*!40000 ALTER TABLE `ams_role_permission` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-18 19:19:59