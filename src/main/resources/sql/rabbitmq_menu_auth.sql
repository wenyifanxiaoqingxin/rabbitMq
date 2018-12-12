CREATE DATABASE  IF NOT EXISTS `rabbitmq` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `rabbitmq`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: rabbitmq
-- ------------------------------------------------------
-- Server version	5.7.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `menu_auth`
--

DROP TABLE IF EXISTS `menu_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_auth` (
  `id` varchar(64) NOT NULL,
  `auth_name` varchar(127) DEFAULT NULL COMMENT '权限名称',
  `auth_url` varchar(127) DEFAULT NULL COMMENT '资源路径',
  `auth_permission` varchar(127) DEFAULT NULL COMMENT '权限字符串',
  `auth_type` varchar(45) DEFAULT NULL COMMENT '权限类型\n0：菜单\n1：按钮',
  `auth_status` varchar(45) DEFAULT NULL COMMENT '权限状态\n0：未启用\n1：启用',
  `auth_descrtion` varchar(45) DEFAULT NULL COMMENT '权限描述',
  `auth_parent_id` varchar(45) DEFAULT NULL COMMENT '父级菜单',
  `auth_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_auth`
--

LOCK TABLES `menu_auth` WRITE;
/*!40000 ALTER TABLE `menu_auth` DISABLE KEYS */;
INSERT INTO `menu_auth` VALUES ('1674a0d36e484defae449d82fcde142c','进入聊天','websocket/html','websocket_html','0','1','进入聊天','0',300);
/*!40000 ALTER TABLE `menu_auth` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-12 17:55:01
