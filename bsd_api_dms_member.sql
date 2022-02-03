-- MariaDB dump 10.17  Distrib 10.4.14-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: dms_api_psm_member
-- ------------------------------------------------------
-- Server version	10.4.22-MariaDB

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
-- Table structure for table `tb_menu`
--

DROP TABLE IF EXISTS `tb_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_menu` (
  `tbm_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbm_create_date` datetime DEFAULT NULL,
  `tbm_create_id` int(11) DEFAULT NULL,
  `tbm_update_date` datetime DEFAULT NULL,
  `tbm_update_id` int(11) DEFAULT NULL,
  `tbm_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tbm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_menu`
--

LOCK TABLES `tb_menu` WRITE;
/*!40000 ALTER TABLE `tb_menu` DISABLE KEYS */;
INSERT INTO `tb_menu` VALUES (1,'2021-07-31 15:26:21',0,NULL,NULL,'Product Registration'),(2,'2021-07-31 15:26:21',0,NULL,NULL,'Order'),(3,'2021-07-31 15:26:21',0,NULL,NULL,'Packing'),(4,'2021-07-31 15:26:21',0,NULL,NULL,'Confirm'),(5,'2021-07-31 15:26:21',0,NULL,NULL,'Report'),(6,'2021-07-31 15:26:21',0,NULL,NULL,'User');
/*!40000 ALTER TABLE `tb_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_structure`
--

DROP TABLE IF EXISTS `tb_structure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_structure` (
  `tbs_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbs_create_date` datetime DEFAULT NULL,
  `tbs_create_id` int(11) DEFAULT NULL,
  `tbs_update_date` datetime DEFAULT NULL,
  `tbs_update_id` int(11) DEFAULT NULL,
  `tbs_status` varchar(255) DEFAULT NULL,
  `tbs_id_parent` int(11) DEFAULT NULL,
  `tbs_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tbs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_structure`
--

LOCK TABLES `tb_structure` WRITE;
/*!40000 ALTER TABLE `tb_structure` DISABLE KEYS */;
INSERT INTO `tb_structure` VALUES (1,'2022-02-03 17:20:14',0,NULL,NULL,'PRINCIPAL',NULL,'Principal 1'),(2,'2022-02-03 17:21:44',0,NULL,NULL,'DISTRIBUTOR',1,'Distributor 1'),(3,'2022-02-03 17:22:02',0,NULL,NULL,'DISTRIBUTOR',1,'Distributor 2'),(4,'2022-02-03 17:22:26',0,NULL,NULL,'SUBDIST',2,'Subdist 1'),(5,'2022-02-03 17:22:51',0,NULL,NULL,'SUBDIST',2,'Subdist 2'),(6,'2022-02-03 17:25:26',0,NULL,NULL,'GROSIR',4,'Grosir 1'),(7,'2022-02-03 17:25:26',0,NULL,NULL,'GROSIR',4,'Grosir 2');
/*!40000 ALTER TABLE `tb_structure` ENABLE KEYS */;
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
  `tbu_email` varchar(255) DEFAULT NULL,
  `tbu_password` varchar(32) DEFAULT NULL,
  `tbu_firstname` varchar(100) DEFAULT NULL,
  `tbu_lastname` varchar(100) DEFAULT NULL,
  `tbu_mobile_phone` varchar(100) DEFAULT NULL,
  `tbu_place_of_birth` varchar(100) DEFAULT NULL,
  `tbu_date_of_birth` datetime DEFAULT NULL,
  `tbu_status` varchar(20) DEFAULT NULL,
  `tbu_uid` varchar(100) DEFAULT NULL,
  `tbu_photo` varchar(1000) DEFAULT NULL,
  `tbu_token_salt` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`tbu_id`),
  UNIQUE KEY `tb_user_tbu_email_uindex` (`tbu_email`),
  UNIQUE KEY `tb_user_tbu_uid_uindex` (`tbu_uid`),
  KEY `tb_user_tbu_status_index` (`tbu_status`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'2019-09-03 15:42:44',0,'2021-11-04 14:17:16',4,'admin@mail.com','202cb962ac59075b964b07152d234b70','admin','admin','123','Jakarta','1981-08-19 00:00:00','active','xycnh1fzl8chkm8cqr20ni6zvh2ai52c3mvw2uwy0s86mscu9u80h6ylym2imghas6h6ffj05taecfoxfu3g0x8alwbt97q9je8f','1111343528-20q4jm5fw1-Cluster-Morizen-Bekasi-Indonesia.jpg','jnsr8q8t7dzgqv8qqmkfsffc5mqdn5fec4af'),(2,'2021-11-04 12:00:07',1,NULL,NULL,'pic1@mail.com','202cb962ac59075b964b07152d234b70','pic','one',NULL,NULL,NULL,'active',NULL,NULL,'ng843n6ocg719kklqklb5814t9n2ahilj9zv'),(3,'2021-11-04 12:12:24',1,NULL,NULL,'pic2@mail.com','202cb962ac59075b964b07152d234b70','pic','two',NULL,NULL,NULL,'active',NULL,NULL,'b3n95p03tsdpm9fya84cnelibj9u34xffz6j'),(4,'2021-11-04 12:13:34',1,NULL,NULL,'pic3@mail.com','202cb962ac59075b964b07152d234b70','pic','three',NULL,NULL,NULL,'active',NULL,NULL,'zxfxjhji09xdf66s3usg6ro49l76ckrcmhyl');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_brand`
--

DROP TABLE IF EXISTS `tb_user_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user_brand` (
  `tbub_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbub_create_date` datetime DEFAULT NULL,
  `tbub_create_id` int(11) DEFAULT NULL,
  `tbub_update_date` datetime DEFAULT NULL,
  `tbub_update_id` int(11) DEFAULT NULL,
  `tbu_id` int(11) DEFAULT NULL,
  `tbb_brand` varchar(255) DEFAULT NULL,
  `tbb_brand_id` varchar(5) DEFAULT NULL,
  `tbb_brand_check` int(11) DEFAULT NULL,
  PRIMARY KEY (`tbub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_brand`
--

LOCK TABLES `tb_user_brand` WRITE;
/*!40000 ALTER TABLE `tb_user_brand` DISABLE KEYS */;
INSERT INTO `tb_user_brand` VALUES (19,'2021-11-04 12:00:07',1,NULL,NULL,2,'Anessa','ANESS',1),(20,'2021-11-04 12:00:07',1,NULL,NULL,2,'BEBE','BEBEB',1),(21,'2021-11-04 12:00:07',1,NULL,NULL,2,'Cetaphil','CETAP',0),(22,'2021-11-04 12:00:07',1,NULL,NULL,2,'cocacola','COCAC',0),(23,'2021-11-04 12:00:07',1,NULL,NULL,2,'Combiphar','COMBH',0),(24,'2021-11-04 12:00:07',1,NULL,NULL,2,'Innisfree','INNIS',1),(25,'2021-11-04 12:00:07',1,NULL,NULL,2,'Interbat','INTER',0),(26,'2021-11-04 12:00:07',1,NULL,NULL,2,'Laneige','LANEI',0),(27,'2021-11-04 12:00:07',1,NULL,NULL,2,'Mamonde','MAMON',0),(28,'2021-11-04 12:00:07',1,NULL,NULL,2,'Mecard','MECAR',0),(29,'2021-11-04 12:00:07',1,NULL,NULL,2,'Mentos','MENTO',0),(30,'2021-11-04 12:00:07',1,NULL,NULL,2,'Mustela','MUSTE',0),(31,'2021-11-04 12:00:07',1,NULL,NULL,2,'Nestle','NESTL',0),(32,'2021-11-04 12:00:07',1,NULL,NULL,2,'Nutrition','NUTRI',0),(33,'2021-11-04 12:00:07',1,NULL,NULL,2,'Pillowpeople','PILLO',0),(34,'2021-11-04 12:00:07',1,NULL,NULL,2,'P&G Health','PNGHE',0),(35,'2021-11-04 12:00:07',1,NULL,NULL,2,'Purina','PURIN',0),(36,'2021-11-04 12:00:07',1,NULL,NULL,2,'Sulwhasoo','SULWH',0),(37,'2021-11-04 12:12:24',1,NULL,NULL,3,'Anessa','ANESS',1),(38,'2021-11-04 12:12:24',1,NULL,NULL,3,'BEBE','BEBEB',0),(39,'2021-11-04 12:12:24',1,NULL,NULL,3,'Cetaphil','CETAP',0),(40,'2021-11-04 12:12:24',1,NULL,NULL,3,'cocacola','COCAC',0),(41,'2021-11-04 12:12:24',1,NULL,NULL,3,'Combiphar','COMBH',0),(42,'2021-11-04 12:12:24',1,NULL,NULL,3,'Innisfree','INNIS',0),(43,'2021-11-04 12:12:24',1,NULL,NULL,3,'Interbat','INTER',0),(44,'2021-11-04 12:12:24',1,NULL,NULL,3,'Laneige','LANEI',0),(45,'2021-11-04 12:12:24',1,NULL,NULL,3,'Mamonde','MAMON',0),(46,'2021-11-04 12:12:24',1,NULL,NULL,3,'Mecard','MECAR',0),(47,'2021-11-04 12:12:24',1,NULL,NULL,3,'Mentos','MENTO',0),(48,'2021-11-04 12:12:24',1,NULL,NULL,3,'Mustela','MUSTE',0),(49,'2021-11-04 12:12:24',1,NULL,NULL,3,'Nestle','NESTL',0),(50,'2021-11-04 12:12:24',1,NULL,NULL,3,'Nutrition','NUTRI',0),(51,'2021-11-04 12:12:24',1,NULL,NULL,3,'Pillowpeople','PILLO',0),(52,'2021-11-04 12:12:24',1,NULL,NULL,3,'P&G Health','PNGHE',0),(53,'2021-11-04 12:12:24',1,NULL,NULL,3,'Purina','PURIN',0),(54,'2021-11-04 12:12:24',1,NULL,NULL,3,'Sulwhasoo','SULWH',0),(55,'2021-11-04 12:13:34',1,NULL,NULL,4,'Anessa','ANESS',1),(56,'2021-11-04 12:13:34',1,NULL,NULL,4,'BEBE','BEBEB',1),(57,'2021-11-04 12:13:34',1,NULL,NULL,4,'Cetaphil','CETAP',1),(58,'2021-11-04 12:13:34',1,NULL,NULL,4,'cocacola','COCAC',0),(59,'2021-11-04 12:13:34',1,NULL,NULL,4,'Combiphar','COMBH',0),(60,'2021-11-04 12:13:34',1,NULL,NULL,4,'Innisfree','INNIS',1),(61,'2021-11-04 12:13:34',1,NULL,NULL,4,'Interbat','INTER',0),(62,'2021-11-04 12:13:34',1,NULL,NULL,4,'Laneige','LANEI',0),(63,'2021-11-04 12:13:34',1,NULL,NULL,4,'Mamonde','MAMON',0),(64,'2021-11-04 12:13:34',1,NULL,NULL,4,'Mecard','MECAR',0),(65,'2021-11-04 12:13:34',1,NULL,NULL,4,'Mentos','MENTO',0),(66,'2021-11-04 12:13:34',1,NULL,NULL,4,'Mustela','MUSTE',0),(67,'2021-11-04 12:13:34',1,NULL,NULL,4,'Nestle','NESTL',0),(68,'2021-11-04 12:13:34',1,NULL,NULL,4,'Nutrition','NUTRI',0),(69,'2021-11-04 12:13:34',1,NULL,NULL,4,'Pillowpeople','PILLO',0),(70,'2021-11-04 12:13:34',1,NULL,NULL,4,'P&G Health','PNGHE',0),(71,'2021-11-04 12:13:34',1,NULL,NULL,4,'Purina','PURIN',0),(72,'2021-11-04 12:13:34',1,NULL,NULL,4,'Sulwhasoo','SULWH',0),(73,'2021-11-04 14:17:16',4,NULL,NULL,1,'Anessa','ANESS',1),(74,'2021-11-04 14:17:16',4,NULL,NULL,1,'BEBE','BEBEB',1),(75,'2021-11-04 14:17:16',4,NULL,NULL,1,'Cetaphil','CETAP',1),(76,'2021-11-04 14:17:16',4,NULL,NULL,1,'cocacola','COCAC',1),(77,'2021-11-04 14:17:16',4,NULL,NULL,1,'Combiphar','COMBH',1),(78,'2021-11-04 14:17:16',4,NULL,NULL,1,'Innisfree','INNIS',1),(79,'2021-11-04 14:17:16',4,NULL,NULL,1,'Interbat','INTER',1),(80,'2021-11-04 14:17:16',4,NULL,NULL,1,'Laneige','LANEI',1),(81,'2021-11-04 14:17:16',4,NULL,NULL,1,'Mamonde','MAMON',1),(82,'2021-11-04 14:17:16',4,NULL,NULL,1,'Mecard','MECAR',1),(83,'2021-11-04 14:17:16',4,NULL,NULL,1,'Mentos','MENTO',1),(84,'2021-11-04 14:17:16',4,NULL,NULL,1,'Mustela','MUSTE',1),(85,'2021-11-04 14:17:16',4,NULL,NULL,1,'Nestle','NESTL',1),(86,'2021-11-04 14:17:16',4,NULL,NULL,1,'Nutrition','NUTRI',1),(87,'2021-11-04 14:17:16',4,NULL,NULL,1,'P&G Health','PNGHE',1),(88,'2021-11-04 14:17:16',4,NULL,NULL,1,'Pillowpeople','PILLO',1),(89,'2021-11-04 14:17:16',4,NULL,NULL,1,'Purina','PURIN',1),(90,'2021-11-04 14:17:16',4,NULL,NULL,1,'Sulwhasoo','SULWH',1);
/*!40000 ALTER TABLE `tb_user_brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_menu`
--

DROP TABLE IF EXISTS `tb_user_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user_menu` (
  `tbum_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbum_create_date` datetime DEFAULT NULL,
  `tbum_create_id` int(11) DEFAULT NULL,
  `tbum_update_date` datetime DEFAULT NULL,
  `tbum_update_id` int(11) DEFAULT NULL,
  `tbu_id` int(11) DEFAULT NULL,
  `tbm_id` int(11) DEFAULT NULL,
  `tbum_add` int(11) DEFAULT NULL,
  `tbum_edit` int(11) DEFAULT NULL,
  `tbum_delete` int(11) DEFAULT NULL,
  `tbum_view` int(11) DEFAULT NULL,
  PRIMARY KEY (`tbum_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_menu`
--

LOCK TABLES `tb_user_menu` WRITE;
/*!40000 ALTER TABLE `tb_user_menu` DISABLE KEYS */;
INSERT INTO `tb_user_menu` VALUES (7,'2021-11-04 12:00:07',1,NULL,NULL,2,4,0,0,0,0),(8,'2021-11-04 12:00:07',1,NULL,NULL,2,2,0,0,0,1),(9,'2021-11-04 12:00:07',1,NULL,NULL,2,3,0,0,0,0),(10,'2021-11-04 12:00:07',1,NULL,NULL,2,1,0,0,0,0),(11,'2021-11-04 12:00:07',1,NULL,NULL,2,5,0,0,0,0),(12,'2021-11-04 12:00:07',1,NULL,NULL,2,6,0,0,0,0),(13,'2021-11-04 12:12:24',1,NULL,NULL,3,4,0,0,0,1),(14,'2021-11-04 12:12:24',1,NULL,NULL,3,2,0,0,0,0),(15,'2021-11-04 12:12:24',1,NULL,NULL,3,3,0,0,0,0),(16,'2021-11-04 12:12:24',1,NULL,NULL,3,1,0,0,0,0),(17,'2021-11-04 12:12:24',1,NULL,NULL,3,5,0,0,0,0),(18,'2021-11-04 12:12:24',1,NULL,NULL,3,6,0,0,0,0),(19,'2021-11-04 12:13:34',1,NULL,NULL,4,4,0,0,0,1),(20,'2021-11-04 12:13:34',1,NULL,NULL,4,2,0,0,0,1),(21,'2021-11-04 12:13:34',1,NULL,NULL,4,3,0,0,0,1),(22,'2021-11-04 12:13:34',1,NULL,NULL,4,1,0,0,0,1),(23,'2021-11-04 12:13:34',1,NULL,NULL,4,5,0,0,0,1),(24,'2021-11-04 12:13:34',1,NULL,NULL,4,6,0,0,0,1),(25,'2021-11-04 14:17:16',4,NULL,NULL,1,4,1,1,1,1),(26,'2021-11-04 14:17:16',4,NULL,NULL,1,2,1,1,1,1),(27,'2021-11-04 14:17:16',4,NULL,NULL,1,3,1,1,1,1),(28,'2021-11-04 14:17:16',4,NULL,NULL,1,1,1,1,1,1),(29,'2021-11-04 14:17:16',4,NULL,NULL,1,5,1,1,1,1),(30,'2021-11-04 14:17:16',4,NULL,NULL,1,6,1,1,1,1);
/*!40000 ALTER TABLE `tb_user_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `view_user_brand`
--

DROP TABLE IF EXISTS `view_user_brand`;
/*!50001 DROP VIEW IF EXISTS `view_user_brand`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `view_user_brand` (
  `uuid` tinyint NOT NULL,
  `tbu_id` tinyint NOT NULL,
  `tbu_email` tinyint NOT NULL,
  `tbu_firstname` tinyint NOT NULL,
  `tbu_lastname` tinyint NOT NULL,
  `tbb_brand` tinyint NOT NULL,
  `tbb_brand_id` tinyint NOT NULL,
  `tbb_brand_check` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `view_user_menu`
--

DROP TABLE IF EXISTS `view_user_menu`;
/*!50001 DROP VIEW IF EXISTS `view_user_menu`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `view_user_menu` (
  `uuid` tinyint NOT NULL,
  `tbu_id` tinyint NOT NULL,
  `tbu_email` tinyint NOT NULL,
  `tbu_firstname` tinyint NOT NULL,
  `tbu_lastname` tinyint NOT NULL,
  `tbm_id` tinyint NOT NULL,
  `tbm_name` tinyint NOT NULL,
  `tbum_add` tinyint NOT NULL,
  `tbum_edit` tinyint NOT NULL,
  `tbum_delete` tinyint NOT NULL,
  `tbum_view` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_user_brand`
--

/*!50001 DROP TABLE IF EXISTS `view_user_brand`*/;
/*!50001 DROP VIEW IF EXISTS `view_user_brand`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_user_brand` AS select uuid() AS `uuid`,`tbu`.`tbu_id` AS `tbu_id`,`tbu`.`tbu_email` AS `tbu_email`,`tbu`.`tbu_firstname` AS `tbu_firstname`,`tbu`.`tbu_lastname` AS `tbu_lastname`,`tbub`.`tbb_brand` AS `tbb_brand`,`tbub`.`tbb_brand_id` AS `tbb_brand_id`,`tbub`.`tbb_brand_check` AS `tbb_brand_check` from (`tb_user` `tbu` join `tb_user_brand` `tbub` on(`tbu`.`tbu_id` = `tbub`.`tbu_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_user_menu`
--

/*!50001 DROP TABLE IF EXISTS `view_user_menu`*/;
/*!50001 DROP VIEW IF EXISTS `view_user_menu`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_user_menu` AS select uuid() AS `uuid`,`tbu`.`tbu_id` AS `tbu_id`,`tbu`.`tbu_email` AS `tbu_email`,`tbu`.`tbu_firstname` AS `tbu_firstname`,`tbu`.`tbu_lastname` AS `tbu_lastname`,`tbm`.`tbm_id` AS `tbm_id`,`tbm`.`tbm_name` AS `tbm_name`,`tbum`.`tbum_add` AS `tbum_add`,`tbum`.`tbum_edit` AS `tbum_edit`,`tbum`.`tbum_delete` AS `tbum_delete`,`tbum`.`tbum_view` AS `tbum_view` from ((`tb_user` `tbu` join `tb_user_menu` `tbum` on(`tbu`.`tbu_id` = `tbum`.`tbu_id`)) join `tb_menu` `tbm` on(`tbum`.`tbm_id` = `tbm`.`tbm_id`)) */;
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

-- Dump completed on 2022-02-03 17:59:30
