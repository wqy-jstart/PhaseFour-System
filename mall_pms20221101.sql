-- MariaDB dump 10.19  Distrib 10.5.17-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: mall_pms
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ams_admin`
--

LOCK TABLES `ams_admin` WRITE;
/*!40000 ALTER TABLE `ams_admin` DISABLE KEYS */;
INSERT INTO `ams_admin` VALUES (1,'root','$2a$10$N.ZOn9G6/YLFixAOPMg/h.z7pCu6v2XyFDtC4q.jeeGm/TEZyj15C','系统管理员','https://img2.baidu.com/it/u=4244269751,4000533845&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','13900139001','root@baidu.com','最高权限的管理员',1,NULL,0,NULL,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(2,'super_admin','$2a$10$N.ZOn9G6/YLFixAOPMg/h.z7pCu6v2XyFDtC4q.jeeGm/TEZyj15C','超级管理员','https://img0.baidu.com/it/u=1600969112,4145041554&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','13900139002','super_admin@baidu.cn','超级管理员，通常具有除了【管理管理员】以外的全部权限',1,NULL,0,NULL,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(3,'liucangsong','$2a$10$N.ZOn9G6/YLFixAOPMg/h.z7pCu6v2XyFDtC4q.jeeGm/TEZyj15C','苍松老师','https://img1.baidu.com/it/u=873106765,2587410047&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1663606800&t=c8de61604dbff6118ae140268f4e3c67','13900139003','liucangsong@baidu.cn','刘苍松老师的账号',1,NULL,0,NULL,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(4,'wangkejing','$2a$10$N.ZOn9G6/YLFixAOPMg/h.z7pCu6v2XyFDtC4q.jeeGm/TEZyj15C','克晶老师','https://img2.baidu.com/it/u=3062813899,1142128231&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1663606800&t=e153f24b4499fce32df24cb1ea1b9efa','13900139004','wangkejing@qq.com','王克晶老师的账号',0,NULL,0,NULL,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(5,'fanchuanqi','$2a$10$N.ZOn9G6/YLFixAOPMg/h.z7pCu6v2XyFDtC4q.jeeGm/TEZyj15C','传奇老师','https://img2.baidu.com/it/u=2704182461,2749837878&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','13900139005','fanchuanqi@baidu.com','范传奇老师的账号',0,NULL,0,NULL,'2022-07-08 11:30:44','2022-07-08 11:30:44');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='管理员角色关联';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ams_admin_role`
--

LOCK TABLES `ams_admin_role` WRITE;
/*!40000 ALTER TABLE `ams_admin_role` DISABLE KEYS */;
INSERT INTO `ams_admin_role` VALUES (1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(2,2,2,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(3,3,3,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(4,4,4,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(5,4,5,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(6,5,6,'2022-07-08 11:30:44','2022-07-08 11:30:44');
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

--
-- Table structure for table `pms_album`
--

DROP TABLE IF EXISTS `pms_album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pms_album` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `name` varchar(50) DEFAULT NULL COMMENT '相册名称',
  `description` varchar(255) DEFAULT NULL COMMENT '相册简介',
  `sort` tinyint(3) unsigned DEFAULT 0 COMMENT '自定义排序序号',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COMMENT='相册';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pms_album`
--

LOCK TABLES `pms_album` WRITE;
/*!40000 ALTER TABLE `pms_album` DISABLE KEYS */;
INSERT INTO `pms_album` VALUES (5,'新-相册','新-简介',166,NULL,NULL),(6,'批量插入测试相册2','批量插入相册简介2',200,NULL,NULL),(7,'批量插入测试相册3','批量插入相册简介3',200,NULL,NULL),(8,'批量插入测试相册4','批量插入相册简介4',200,NULL,NULL),(9,'批量插入测试相册5','批量插入相册简介5',200,NULL,NULL),(10,'测试数据10','测试数据简介10',100,NULL,NULL),(11,'相册001','相册001的简介',199,NULL,NULL),(12,'相册001','相册001的简介',199,NULL,NULL),(13,'相册001','相册001的简介',199,NULL,NULL),(14,'相册101','相册001的简介',199,NULL,NULL),(15,'相册003','相册003描述',30,NULL,NULL),(17,'不知道1','好',1,NULL,NULL),(18,NULL,NULL,NULL,NULL,NULL),(19,NULL,NULL,NULL,NULL,NULL),(22,'xxxxx','xxxxxx',1,NULL,NULL),(23,'xxxxxx','yyyyy',1,NULL,NULL),(24,'11111','22222',111,NULL,NULL),(25,'我真的不知道呀','好的好的好的',2,NULL,NULL),(26,'记录每一天','很好',2,NULL,NULL),(27,'测试11','测试111',22,NULL,NULL),(28,'测试111','11111',11,NULL,NULL),(29,'美好的回忆','好得很呀',3,NULL,NULL),(30,'记录每一天1','很好1',2,NULL,NULL),(31,'记录美好生活','呃呃呃呃呃呃呃呃',1,NULL,NULL),(32,'记录美好生活1','嗯嗯嗯嗯嗯嗯',22,NULL,NULL),(33,'记录美好生活2','呃呃呃呃呃呃呃呃',11,NULL,NULL),(34,'今天是11月1日','好好好好',2,NULL,NULL);
/*!40000 ALTER TABLE `pms_album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pms_attribute`
--

DROP TABLE IF EXISTS `pms_attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pms_attribute` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `template_id` bigint(20) unsigned DEFAULT NULL COMMENT '所属属性模版id',
  `name` varchar(50) DEFAULT NULL COMMENT '属性名称',
  `description` varchar(255) DEFAULT NULL COMMENT '简介（某些属性名称可能相同，通过简介补充描述）',
  `type` tinyint(3) unsigned DEFAULT 0 COMMENT '属性类型，1=销售属性，0=非销售属性',
  `input_type` tinyint(3) unsigned DEFAULT 0 COMMENT '输入类型，0=手动录入，1=单选，2=多选，3=单选（下拉列表），4=多选（下拉列表）',
  `value_list` varchar(255) DEFAULT NULL COMMENT '备选值列表',
  `unit` varchar(50) DEFAULT NULL COMMENT '计量单位',
  `sort` tinyint(3) unsigned DEFAULT 0 COMMENT '自定义排序序号',
  `is_allow_customize` tinyint(3) unsigned DEFAULT 0 COMMENT '是否允许自定义，1=允许，0=禁止',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='属性';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pms_attribute`
--

LOCK TABLES `pms_attribute` WRITE;
/*!40000 ALTER TABLE `pms_attribute` DISABLE KEYS */;
INSERT INTO `pms_attribute` VALUES (1,2,'had','好',3,1,'无','无',2,1,NULL,NULL),(2,2,'had1','好',3,1,'无','无',2,1,NULL,NULL),(3,4,'哈','换行',2,1,NULL,NULL,0,0,NULL,NULL);
/*!40000 ALTER TABLE `pms_attribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pms_attribute_template`
--

DROP TABLE IF EXISTS `pms_attribute_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pms_attribute_template` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `name` varchar(50) DEFAULT NULL COMMENT '属性模版名称',
  `pinyin` varchar(50) DEFAULT NULL COMMENT '属性模版名称的拼音',
  `keywords` varchar(255) DEFAULT NULL COMMENT '关键词列表，各关键词使用英文的逗号分隔',
  `sort` tinyint(3) unsigned DEFAULT 0 COMMENT '自定义排序序号',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='属性模版';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pms_attribute_template`
--

LOCK TABLES `pms_attribute_template` WRITE;
/*!40000 ALTER TABLE `pms_attribute_template` DISABLE KEYS */;
INSERT INTO `pms_attribute_template` VALUES (4,'不知道3','buzd3','无3',1,NULL,NULL),(5,'不知道4','buzd4','无4',1,NULL,NULL),(6,'不知道5','buzd5','无5',1,NULL,NULL),(7,NULL,NULL,NULL,0,NULL,NULL),(8,'不知道','buzd','无',1,NULL,NULL),(9,'不知道6','buzd','无',1,NULL,NULL),(10,'不知道8','bzd','无',1,NULL,NULL),(11,'无','pianyi','无',1,NULL,NULL);
/*!40000 ALTER TABLE `pms_attribute_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pms_brand`
--

DROP TABLE IF EXISTS `pms_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pms_brand` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `name` varchar(50) DEFAULT NULL COMMENT '品牌名称',
  `pinyin` varchar(50) DEFAULT NULL COMMENT '品牌名称的拼音',
  `logo` varchar(255) DEFAULT NULL COMMENT '品牌logo的URL',
  `description` varchar(255) DEFAULT NULL COMMENT '品牌简介',
  `keywords` varchar(255) DEFAULT NULL COMMENT '关键词列表，各关键词使用英文的逗号分隔',
  `sort` tinyint(3) unsigned DEFAULT 0 COMMENT '自定义排序序号',
  `sales` int(10) unsigned DEFAULT 0 COMMENT '销量（冗余）',
  `product_count` int(10) unsigned DEFAULT 0 COMMENT '商品种类数量总和（冗余）',
  `comment_count` int(10) unsigned DEFAULT 0 COMMENT '买家评论数量总和（冗余）',
  `positive_comment_count` int(10) unsigned DEFAULT 0 COMMENT '买家好评数量总和（冗余）',
  `enable` tinyint(3) unsigned DEFAULT 0 COMMENT '是否启用，1=启用，0=未启用',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COMMENT='品牌';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pms_brand`
--

LOCK TABLES `pms_brand` WRITE;
/*!40000 ALTER TABLE `pms_brand` DISABLE KEYS */;
INSERT INTO `pms_brand` VALUES (1,'华为','huawei','暂无','暂无','暂无',0,0,0,0,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(2,'小米','xiaomi','暂无','暂无','暂无',0,0,0,0,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(3,'格力','geli','暂无','暂无','暂无',0,0,0,0,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(4,'华硕','huashuo','暂无','暂无','暂无',0,0,0,0,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(5,'荣耀','rongyao','暂无','暂无','暂无',0,0,0,0,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(6,'微软','weiruan','暂无','暂无','暂无',0,0,0,0,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(7,'奥克斯','aokesi','暂无','暂无','暂无',0,0,0,0,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(8,'海尔','haier','暂无','暂无','暂无',0,0,0,0,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(9,'美的','meidi','暂无','暂无','暂无',0,0,0,0,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(10,'真我','realme','暂无','暂无','暂无',0,0,0,0,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(11,'VIVO','vivo','暂无','暂无','暂无',0,0,0,0,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(12,'OPPO','oppo','暂无','暂无','暂无',0,0,0,0,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(13,'小天鹅','xiaotiane','暂无','暂无','暂无',0,0,0,0,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(14,'志高','zhigao','暂无','暂无','暂无',0,0,0,0,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(15,'格力','GeLi','GL','该商品非常好!','格',1,3000,30,300,200,3,NULL,NULL),(16,'格力','GeLi','GL','该商品非常好!','格',1,3000,30,300,200,1,NULL,NULL),(17,'新-格力','新-GeLi','新-GL','新-该商品非常好!','新-格',1,2888,30,300,200,1,NULL,NULL),(18,'商品名称1','GeLi1','GL1','该商品非常好!1','格1',1,200,30,300,200,1,NULL,NULL),(19,'商品名称2','GeLi2','GL2','该商品非常好!2','格2',1,200,30,300,200,1,NULL,NULL),(20,'商品名称1','GeLi1','GL1','该商品非常好!1','格1',1,200,30,300,200,1,NULL,NULL),(21,'商品名称2','GeLi2','GL2','该商品非常好!2','格2',1,200,30,300,200,1,NULL,NULL),(22,'商品名称3','GeLi3','GL3','该商品非常好!3','格3',1,200,30,300,200,1,NULL,NULL),(23,'商品名称1','GeLi1','GL1','该商品非常好!1','格1',1,200,30,300,200,1,NULL,NULL),(24,'商品名称2','GeLi2','GL2','该商品非常好!2','格2',1,200,30,300,200,1,NULL,NULL),(25,'商品名称3','GeLi3','GL3','该商品非常好!3','格3',1,200,30,300,200,1,NULL,NULL),(26,'商品名称4','GeLi4','GL4','该商品非常好!4','格4',1,200,30,300,200,1,NULL,NULL),(27,'商品名称1','GeLi1','GL1','该商品非常好!1','格1',1,200,30,300,200,1,NULL,NULL),(28,'商品名称2','GeLi2','GL2','该商品非常好!2','格2',1,200,30,300,200,1,NULL,NULL),(32,'美的01','新-MeiDi','新-Mei','新-该商品非常好!','新-格',1,2888,30,300,200,1,NULL,NULL),(33,'\"美的02\"','\"新-MeiDi\"','\"新-Mei\"','\"新-该商品非常好!\"',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(34,'美的2','Mei','无','好品牌','无',1,2000,2,12,1,2,NULL,NULL);
/*!40000 ALTER TABLE `pms_brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pms_brand_category`
--

DROP TABLE IF EXISTS `pms_brand_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pms_brand_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `brand_id` bigint(20) unsigned DEFAULT NULL COMMENT '品牌id',
  `category_id` bigint(20) unsigned DEFAULT NULL COMMENT '类别id',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='品牌与类别关联';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pms_brand_category`
--

LOCK TABLES `pms_brand_category` WRITE;
/*!40000 ALTER TABLE `pms_brand_category` DISABLE KEYS */;
INSERT INTO `pms_brand_category` VALUES (1,1,1,NULL,NULL),(2,2,1,NULL,NULL),(3,22,22,NULL,NULL);
/*!40000 ALTER TABLE `pms_brand_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pms_category`
--

DROP TABLE IF EXISTS `pms_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pms_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `name` varchar(50) DEFAULT NULL COMMENT '类别名称',
  `parent_id` bigint(20) unsigned DEFAULT 0 COMMENT '父级类别id，如果无父级，则为0',
  `depth` tinyint(3) unsigned DEFAULT 1 COMMENT '深度，最顶级类别的深度为1，次级为2，以此类推',
  `keywords` varchar(255) DEFAULT NULL COMMENT '关键词列表，各关键词使用英文的逗号分隔',
  `sort` tinyint(3) unsigned DEFAULT 0 COMMENT '自定义排序序号',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标图片的URL',
  `enable` tinyint(3) unsigned DEFAULT 0 COMMENT '是否启用，1=启用，0=未启用',
  `is_parent` tinyint(3) unsigned DEFAULT 0 COMMENT '是否为父级（是否包含子级），1=是父级，0=不是父级',
  `is_display` tinyint(3) unsigned DEFAULT 0 COMMENT '是否显示在导航栏中，1=启用，0=未启用',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8mb4 COMMENT='类别';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pms_category`
--

LOCK TABLES `pms_category` WRITE;
/*!40000 ALTER TABLE `pms_category` DISABLE KEYS */;
INSERT INTO `pms_category` VALUES (1,'家用电器',0,1,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(2,'电视',1,2,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(3,'空调',1,2,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(4,'洗衣机',1,2,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(5,'冰箱',1,2,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(6,'全面屏电视',2,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(7,'OLED电视',2,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(8,'智慧屏',2,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(9,'空调挂机',3,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(10,'空调柜机',3,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(11,'新风空调',3,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(12,'滚桶洗衣机',4,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(13,'洗烘一体机',4,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(14,'迷你洗衣机',4,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(15,'洗衣机配件',4,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(16,'双门冰箱',5,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(17,'三门冰箱',5,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(18,'对开门冰箱',5,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(19,'冰柜',5,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(20,'手机数码',0,1,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(21,'手机通讯',20,2,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(22,'拍照手机',21,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(23,'游戏手机',21,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(24,'全面屏手机',21,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(25,'5G手机',21,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(26,'对讲机',21,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(27,'手机配件',20,2,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(28,'手机壳',27,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(29,'贴膜',27,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(30,'数据线',27,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(31,'充电器',27,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(32,'手机饰品',27,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(33,'摄影摄像',20,2,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(34,'数码相机',33,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(35,'微单相机',33,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(36,'单反相机',33,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(37,'拍立得',33,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(38,'影音娱乐',20,2,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(39,'耳机',38,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(40,'音箱',38,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(41,'麦克风',38,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(42,'收音机',38,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(43,'电脑办公',0,1,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(44,'电脑整机',43,2,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(45,'台式机',44,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(46,'笔记本',44,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(47,'游戏机',44,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(48,'平板电脑',44,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(49,'一体机',44,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(50,'服务器',44,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(51,'电脑配件',43,2,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(52,'鼠标',51,3,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(53,'键盘',51,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(54,'显卡',51,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(55,'主板',51,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(56,'CPU',51,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(57,'内存条',51,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(58,'硬盘',51,3,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(59,'移动硬盘',58,4,'无',0,'无',1,0,0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(60,'机械硬盘',58,4,'无',0,'无',1,0,0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(61,'固态硬盘',58,4,'无',0,'无',1,0,0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(62,'无线鼠标',52,4,'无',0,'无',1,0,0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(63,'有线鼠标',52,4,'无',0,'无',1,0,0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(64,'游戏鼠标',52,4,'无',0,'无',1,0,0,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(65,'家具',0,1,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(66,'灯具',65,2,'无',0,'无',1,1,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(67,'吸顶灯',66,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(68,'台灯',66,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(69,'筒灯',66,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(70,'应急灯',66,3,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(71,'沙发',65,2,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(72,'茶几',65,2,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(73,'床',65,2,'无',0,'无',1,0,1,'2022-07-08 11:30:44','2022-07-08 11:30:44'),(74,'品牌女装',1,3,'无',3,'无',1,1,1,NULL,NULL),(75,'品牌男装1',1,2,'无1',2,'无1',1,1,1,NULL,NULL),(80,'品牌男装',1,2,'无',2,'无',1,1,1,NULL,NULL),(81,'品牌男装1',1,2,'无1',2,'无1',1,1,1,NULL,NULL),(82,'品牌男装2',1,2,'无2',2,'无2',1,1,1,NULL,NULL),(83,'品牌男装3',1,2,'无3',2,'无3',1,1,1,NULL,NULL),(84,'品牌男装4',1,2,'无4',2,'无4',1,1,1,NULL,NULL),(85,'品牌男装5',1,2,'无5',2,'无5',1,1,1,NULL,NULL),(86,'品牌男装6',1,2,'无',2,'无',1,1,1,NULL,NULL),(87,'\"品牌男装7\"',1,1,'\"无\"',0,'\"无\"',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `pms_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pms_category_attribute_template`
--

DROP TABLE IF EXISTS `pms_category_attribute_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pms_category_attribute_template` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `category_id` bigint(20) unsigned DEFAULT NULL COMMENT '类别id',
  `attribute_template_id` bigint(20) unsigned DEFAULT NULL COMMENT '属性模版id',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='类别与属性模版关联';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pms_category_attribute_template`
--

LOCK TABLES `pms_category_attribute_template` WRITE;
/*!40000 ALTER TABLE `pms_category_attribute_template` DISABLE KEYS */;
INSERT INTO `pms_category_attribute_template` VALUES (1,1,2,NULL,NULL),(2,2,2,NULL,NULL),(3,2,5,NULL,NULL);
/*!40000 ALTER TABLE `pms_category_attribute_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pms_picture`
--

DROP TABLE IF EXISTS `pms_picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pms_picture` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `album_id` bigint(20) unsigned DEFAULT NULL COMMENT '相册id',
  `url` varchar(255) DEFAULT NULL COMMENT '图片url',
  `description` varchar(255) DEFAULT NULL COMMENT '图片简介',
  `width` smallint(5) unsigned DEFAULT NULL COMMENT '图片宽度，单位：px',
  `height` smallint(5) unsigned DEFAULT NULL COMMENT '图片高度，单位：px',
  `is_cover` tinyint(3) unsigned DEFAULT 0 COMMENT '是否为封面图片，1=是，0=否',
  `sort` tinyint(3) unsigned DEFAULT 0 COMMENT '自定义排序序号',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='图片';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pms_picture`
--

LOCK TABLES `pms_picture` WRITE;
/*!40000 ALTER TABLE `pms_picture` DISABLE KEYS */;
INSERT INTO `pms_picture` VALUES (1,1,'ABC23','好',233,122,1,2,NULL,NULL),(2,1,'ABC231','好',233,122,1,2,NULL,NULL),(3,6,'a','h',222,333,1,2,NULL,NULL),(4,5,'3232gfrhr','好',600,500,1,3,NULL,NULL),(5,22,'2222','g',333,444,4,3,NULL,NULL);
/*!40000 ALTER TABLE `pms_picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pms_sku`
--

DROP TABLE IF EXISTS `pms_sku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pms_sku` (
  `id` bigint(20) unsigned NOT NULL COMMENT '记录id',
  `spu_id` bigint(20) unsigned DEFAULT NULL COMMENT 'SPU id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `bar_code` varchar(255) DEFAULT NULL COMMENT '条型码',
  `attribute_template_id` bigint(20) unsigned DEFAULT NULL COMMENT '属性模版id',
  `specifications` varchar(2500) DEFAULT NULL COMMENT '全部属性，使用JSON格式表示（冗余）',
  `album_id` bigint(20) unsigned DEFAULT NULL COMMENT '相册id',
  `pictures` varchar(500) DEFAULT NULL COMMENT '组图URLs，使用JSON格式表示',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `stock` int(10) unsigned DEFAULT 0 COMMENT '当前库存',
  `stock_threshold` int(10) unsigned DEFAULT 0 COMMENT '库存预警阈值',
  `sales` int(10) unsigned DEFAULT 0 COMMENT '销量（冗余）',
  `comment_count` int(10) unsigned DEFAULT 0 COMMENT '买家评论数量总和（冗余）',
  `positive_comment_count` int(10) unsigned DEFAULT 0 COMMENT '买家好评数量总和（冗余）',
  `sort` tinyint(3) unsigned DEFAULT 0 COMMENT '自定义排序序号',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='SKU（Stock Keeping Unit）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pms_sku`
--

LOCK TABLES `pms_sku` WRITE;
/*!40000 ALTER TABLE `pms_sku` DISABLE KEYS */;
INSERT INTO `pms_sku` VALUES (1,2,'无','无',2,'无',1,'无',2.00,0,0,0,0,0,0,NULL,NULL),(2,2,'无1','无',2,'无',1,'无',2.00,0,0,0,0,0,0,NULL,NULL);
/*!40000 ALTER TABLE `pms_sku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pms_sku_specification`
--

DROP TABLE IF EXISTS `pms_sku_specification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pms_sku_specification` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `sku_id` bigint(20) unsigned DEFAULT NULL COMMENT 'SKU id',
  `attribute_id` bigint(20) unsigned DEFAULT NULL COMMENT '属性id',
  `attribute_name` varchar(50) DEFAULT NULL COMMENT '属性名称',
  `attribute_value` varchar(50) DEFAULT NULL COMMENT '属性值',
  `unit` varchar(10) DEFAULT NULL COMMENT '自动补充的计量单位',
  `sort` tinyint(3) unsigned DEFAULT 0 COMMENT '自定义排序序号',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='SKU数据';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pms_sku_specification`
--

LOCK TABLES `pms_sku_specification` WRITE;
/*!40000 ALTER TABLE `pms_sku_specification` DISABLE KEYS */;
INSERT INTO `pms_sku_specification` VALUES (1,1,1,'无','无','4',2,NULL,NULL),(2,2,1,'无','无','4',2,NULL,NULL);
/*!40000 ALTER TABLE `pms_sku_specification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pms_spu`
--

DROP TABLE IF EXISTS `pms_spu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pms_spu` (
  `id` bigint(20) unsigned NOT NULL COMMENT '记录id',
  `name` varchar(50) DEFAULT NULL COMMENT 'SPU名称',
  `type_number` varchar(50) DEFAULT NULL COMMENT 'SPU编号',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `description` varchar(255) DEFAULT NULL COMMENT '简介',
  `list_price` decimal(10,2) DEFAULT NULL COMMENT '价格（显示在列表中）',
  `stock` int(10) unsigned DEFAULT 0 COMMENT '当前库存（冗余）',
  `stock_threshold` int(10) unsigned DEFAULT 0 COMMENT '库存预警阈值（冗余）',
  `unit` varchar(50) DEFAULT NULL COMMENT '计件单位',
  `brand_id` bigint(20) unsigned DEFAULT NULL COMMENT '品牌id',
  `brand_name` varchar(50) DEFAULT NULL COMMENT '品牌名称（冗余）',
  `category_id` bigint(20) unsigned DEFAULT NULL COMMENT '类别id',
  `category_name` varchar(50) DEFAULT NULL COMMENT '类别名称（冗余）',
  `attribute_template_id` bigint(20) unsigned DEFAULT NULL COMMENT '属性模版id',
  `album_id` bigint(20) unsigned DEFAULT NULL COMMENT '相册id',
  `pictures` varchar(500) DEFAULT NULL COMMENT '组图URLs，使用JSON数组表示',
  `keywords` varchar(255) DEFAULT NULL COMMENT '关键词列表，各关键词使用英文的逗号分隔',
  `tags` varchar(255) DEFAULT NULL COMMENT '标签列表，各标签使用英文的逗号分隔，原则上最多3个',
  `sales` int(10) unsigned DEFAULT 0 COMMENT '销量（冗余）',
  `comment_count` int(10) unsigned DEFAULT 0 COMMENT '买家评论数量总和（冗余）',
  `positive_comment_count` int(10) unsigned DEFAULT 0 COMMENT '买家好评数量总和（冗余）',
  `sort` tinyint(3) unsigned DEFAULT 0 COMMENT '自定义排序序号',
  `is_deleted` tinyint(3) unsigned DEFAULT 0 COMMENT '是否标记为删除，1=已删除，0=未删除',
  `is_published` tinyint(3) unsigned DEFAULT 0 COMMENT '是否上架（发布），1=已上架，0=未上架（下架）',
  `is_new_arrival` tinyint(3) unsigned DEFAULT 0 COMMENT '是否新品，1=新品，0=非新品',
  `is_recommend` tinyint(3) unsigned DEFAULT 0 COMMENT '是否推荐，1=推荐，0=不推荐',
  `is_checked` tinyint(3) unsigned DEFAULT 0 COMMENT '是否已审核，1=已审核，0=未审核',
  `check_user` varchar(50) DEFAULT NULL COMMENT '审核人（冗余）',
  `gmt_check` datetime DEFAULT NULL COMMENT '审核通过时间（冗余）',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='SPU（Standard Product Unit）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pms_spu`
--

LOCK TABLES `pms_spu` WRITE;
/*!40000 ALTER TABLE `pms_spu` DISABLE KEYS */;
INSERT INTO `pms_spu` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'','','','',NULL,NULL,NULL,'',2,'',NULL,'',1,4,'','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL),(4,NULL,NULL,NULL,NULL,NULL,0,0,NULL,33,NULL,NULL,NULL,NULL,32,NULL,NULL,NULL,0,0,0,0,0,0,0,0,0,NULL,NULL,NULL,NULL),(5,NULL,NULL,NULL,NULL,NULL,0,0,NULL,22,NULL,NULL,NULL,NULL,22,NULL,NULL,NULL,0,0,0,0,0,0,0,0,0,NULL,NULL,NULL,NULL),(6,NULL,NULL,NULL,NULL,NULL,0,0,NULL,23,NULL,NULL,NULL,NULL,23,NULL,NULL,NULL,0,0,0,0,0,0,0,0,0,NULL,NULL,NULL,NULL),(7,NULL,NULL,NULL,NULL,NULL,0,0,NULL,24,NULL,NULL,NULL,NULL,25,NULL,NULL,NULL,0,0,0,0,0,0,0,0,0,NULL,NULL,NULL,NULL),(8,NULL,NULL,NULL,NULL,NULL,0,0,NULL,25,NULL,NULL,NULL,NULL,24,NULL,NULL,NULL,0,0,0,0,0,0,0,0,0,NULL,NULL,NULL,NULL),(9,NULL,NULL,NULL,NULL,NULL,0,0,NULL,26,NULL,NULL,NULL,NULL,26,NULL,NULL,NULL,0,0,0,0,0,0,0,0,0,NULL,NULL,NULL,NULL),(10,NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,0,0,0,0,0,0,0,0,0,NULL,NULL,NULL,NULL),(11,NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,NULL,NULL,NULL,22,6,NULL,NULL,NULL,0,0,0,0,0,0,0,0,0,NULL,NULL,NULL,NULL),(12,NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,NULL,NULL,NULL,23,25,NULL,NULL,NULL,0,0,0,0,0,0,0,0,0,NULL,NULL,NULL,NULL),(13,NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,NULL,NULL,NULL,24,29,NULL,NULL,NULL,0,0,0,0,0,0,0,0,0,NULL,NULL,NULL,NULL),(14,NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,NULL,NULL,NULL,25,30,NULL,NULL,NULL,0,0,0,0,0,0,0,0,0,NULL,NULL,NULL,NULL),(15,NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,NULL,NULL,NULL,26,33,NULL,NULL,NULL,0,0,0,0,0,0,0,0,0,NULL,NULL,NULL,NULL),(16,NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,NULL,NULL,NULL,6,27,NULL,NULL,NULL,0,0,0,0,0,0,0,0,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `pms_spu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pms_spu_detail`
--

DROP TABLE IF EXISTS `pms_spu_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pms_spu_detail` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `spu_id` bigint(20) unsigned DEFAULT NULL COMMENT 'SPU id',
  `detail` text DEFAULT NULL COMMENT 'SPU详情，应该使用HTML富文本，通常内容是若干张图片',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='SPU详情';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pms_spu_detail`
--

LOCK TABLES `pms_spu_detail` WRITE;
/*!40000 ALTER TABLE `pms_spu_detail` DISABLE KEYS */;
INSERT INTO `pms_spu_detail` VALUES (1,1,'无',NULL,NULL),(2,2,'无',NULL,NULL);
/*!40000 ALTER TABLE `pms_spu_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-01 20:55:28
