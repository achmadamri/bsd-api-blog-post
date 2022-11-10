-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: bsd_api_blog_post
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

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
-- Table structure for table `tb_comment`
--

DROP TABLE IF EXISTS `tb_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_comment` (
  `tbc_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbc_create_date` datetime DEFAULT NULL,
  `tbc_create_id` int(11) DEFAULT NULL,
  `tbc_update_date` datetime DEFAULT NULL,
  `tbc_update_id` int(11) DEFAULT NULL,
  `tbe_id` int(11) DEFAULT NULL,
  `tbc_content` text DEFAULT NULL,
  PRIMARY KEY (`tbc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_comment`
--

LOCK TABLES `tb_comment` WRITE;
/*!40000 ALTER TABLE `tb_comment` DISABLE KEYS */;
INSERT INTO `tb_comment` VALUES (1,'2022-11-10 12:50:38',0,NULL,0,23,'post'),(2,'2022-11-10 12:56:35',0,NULL,NULL,23,'test'),(3,'2022-11-10 12:57:57',0,NULL,NULL,23,'okok'),(4,'2022-11-10 12:59:28',0,NULL,NULL,26,'werewr'),(5,'2022-11-10 12:59:33',0,NULL,NULL,26,'Test');
/*!40000 ALTER TABLE `tb_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_entry`
--

DROP TABLE IF EXISTS `tb_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_entry` (
  `tbe_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbe_create_date` datetime DEFAULT NULL,
  `tbe_create_id` int(11) DEFAULT NULL,
  `tbe_update_date` datetime DEFAULT NULL,
  `tbe_update_id` int(11) DEFAULT NULL,
  `tbe_title` varchar(100) DEFAULT NULL,
  `tbe_chunk` varchar(100) DEFAULT NULL,
  `tbe_content` longtext DEFAULT NULL,
  `tbe_counter` int(11) DEFAULT NULL,
  PRIMARY KEY (`tbe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_entry`
--

LOCK TABLES `tb_entry` WRITE;
/*!40000 ALTER TABLE `tb_entry` DISABLE KEYS */;
INSERT INTO `tb_entry` VALUES (23,'2022-11-10 09:24:08',1,NULL,0,'Title','<p><i><strong>Content</strong></i></p>','<p><i><strong>Content</strong></i></p>',2),(24,'2022-11-10 11:41:21',1,NULL,0,'Test 2','<p>Test 2</p>','<p>Test 2</p>',NULL),(25,'2022-11-10 11:41:26',1,NULL,0,'Test 3','<p>Test 3</p>','<p>Test 3</p>',4),(26,'2022-11-10 12:59:05',1,NULL,0,'Test Blog 1','<p><i><strong>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</strong></i','<p><i><strong>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</strong></i></p><p><strong>Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</strong></p><blockquote><p>It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p></blockquote>',8);
/*!40000 ALTER TABLE `tb_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `tbu_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbu_create_date` datetime DEFAULT NULL,
  `tbu_create_id` int(11) DEFAULT NULL,
  `tbu_update_date` datetime DEFAULT NULL,
  `tbu_update_id` int(11) DEFAULT NULL,
  `tbu_email` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `tbu_password` varchar(32) CHARACTER SET latin1 DEFAULT NULL,
  `tbu_firstname` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `tbu_lastname` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `tbu_mobile_phone` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `tbu_place_of_birth` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `tbu_date_of_birth` datetime DEFAULT NULL,
  `tbu_status` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `tbu_uid` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `tbu_photo` varchar(1000) CHARACTER SET latin1 DEFAULT NULL,
  `tbu_token_salt` varchar(36) CHARACTER SET latin1 DEFAULT NULL,
  `tbu_role` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`tbu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'2019-09-03 15:42:44',0,'2022-11-10 13:15:57',1,'admin@mail.com','202cb962ac59075b964b07152d234b70','admin','admin','123','Jakarta','1981-08-19 00:00:00','active','xycnh1fzl8chkm8cqr20ni6zvh2ai52c3mvw2uwy0s86mscu9u80h6ylym2imghas6h6ffj05taecfoxfu3g0x8alwbt97q9je8f','1111343528-20q4jm5fw1-Cluster-Morizen-Bekasi-Indonesia.jpg','lk4w7b5pwy7ke7poay1njenn1cf1jejoe6fl','ADMIN'),(2,'2022-11-10 09:48:56',1,'2022-11-10 11:36:05',2,'test@email.com','202cb962ac59075b964b07152d234b70','test','test',NULL,NULL,NULL,'active',NULL,NULL,'q2vgl3wgwg8e5exvz1pu6zsseifrtg4j0gvh','ADMIN'),(3,'2022-11-10 13:24:50',0,'2022-11-10 13:24:53',3,'test2@mail.com','202cb962ac59075b964b07152d234b70','test2','test2',NULL,NULL,NULL,'active',NULL,NULL,'xww9b235ydinsy0nnvmrthtje8g4gfritcl3','ADMIN');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `view_user_entry`
--

DROP TABLE IF EXISTS `view_user_entry`;
/*!50001 DROP VIEW IF EXISTS `view_user_entry`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `view_user_entry` (
  `uuid` tinyint NOT NULL,
  `tbe_id` tinyint NOT NULL,
  `tbe_create_date` tinyint NOT NULL,
  `tbe_create_id` tinyint NOT NULL,
  `tbe_update_date` tinyint NOT NULL,
  `tbe_update_id` tinyint NOT NULL,
  `tbe_title` tinyint NOT NULL,
  `tbe_chunk` tinyint NOT NULL,
  `tbe_content` tinyint NOT NULL,
  `tbu_id` tinyint NOT NULL,
  `tbu_email` tinyint NOT NULL,
  `tbu_firstname` tinyint NOT NULL,
  `tbu_lastname` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_user_entry`
--

/*!50001 DROP TABLE IF EXISTS `view_user_entry`*/;
/*!50001 DROP VIEW IF EXISTS `view_user_entry`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_user_entry` AS select uuid() AS `uuid`,`tbe`.`tbe_id` AS `tbe_id`,`tbe`.`tbe_create_date` AS `tbe_create_date`,`tbe`.`tbe_create_id` AS `tbe_create_id`,`tbe`.`tbe_update_date` AS `tbe_update_date`,`tbe`.`tbe_update_id` AS `tbe_update_id`,`tbe`.`tbe_title` AS `tbe_title`,`tbe`.`tbe_chunk` AS `tbe_chunk`,`tbe`.`tbe_content` AS `tbe_content`,`tbu`.`tbu_id` AS `tbu_id`,`tbu`.`tbu_email` AS `tbu_email`,`tbu`.`tbu_firstname` AS `tbu_firstname`,`tbu`.`tbu_lastname` AS `tbu_lastname` from (`tb_entry` `tbe` join `tb_user` `tbu` on(`tbe`.`tbe_create_id` = `tbu`.`tbu_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-10 20:25:35
