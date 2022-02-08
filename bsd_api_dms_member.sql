-- MariaDB dump 10.17  Distrib 10.4.14-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: bsd_api_dms_member
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
  `tbu_role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tbu_id`),
  UNIQUE KEY `tb_user_tbu_email_uindex` (`tbu_email`),
  UNIQUE KEY `tb_user_tbu_uid_uindex` (`tbu_uid`),
  KEY `tb_user_tbu_status_index` (`tbu_status`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'2019-09-03 15:42:44',0,'2022-02-07 09:45:02',1,'admin@mail.com','202cb962ac59075b964b07152d234b70','admin','admin','123','Jakarta','1981-08-19 00:00:00','active','xycnh1fzl8chkm8cqr20ni6zvh2ai52c3mvw2uwy0s86mscu9u80h6ylym2imghas6h6ffj05taecfoxfu3g0x8alwbt97q9je8f','1111343528-20q4jm5fw1-Cluster-Morizen-Bekasi-Indonesia.jpg','jnsr8q8t7dzgqv8qqmkfsffc5mqdn5fec4af','ADMIN'),(2,'2021-11-04 12:00:07',1,'2022-02-08 08:59:58',1,'pic1@mail.com','202cb962ac59075b964b07152d234b70','pic','one',NULL,NULL,NULL,'active',NULL,NULL,'ng843n6ocg719kklqklb5814t9n2ahilj9zv','PRINCIPAL'),(3,'2021-11-04 12:12:24',1,'2022-02-08 08:57:54',1,'pic2@mail.com','202cb962ac59075b964b07152d234b70','pic','two',NULL,NULL,NULL,'active',NULL,NULL,'b3n95p03tsdpm9fya84cnelibj9u34xffz6j','DISTRIBUTOR'),(4,'2021-11-04 12:13:34',1,'2022-02-08 09:00:03',1,'pic3@mail.com','202cb962ac59075b964b07152d234b70','pic','three',NULL,NULL,NULL,'active',NULL,NULL,'zxfxjhji09xdf66s3usg6ro49l76ckrcmhyl','DISTRIBUTOR'),(5,'2022-02-07 09:12:43',1,'2022-02-08 08:58:01',1,'pic4@mail.com','202cb962ac59075b964b07152d234b70','pic','four',NULL,NULL,NULL,'active',NULL,NULL,'ni5ju0wgw0l4x3gxoq0cgh3jn3lyvejl5aq8','SUBDIST'),(8,'2022-02-07 09:48:32',1,'2022-02-08 09:00:08',1,'pic6@mail.com','202cb962ac59075b964b07152d234b70','pic','six',NULL,NULL,NULL,'active',NULL,NULL,'onlidhsdmmgz9k8gxzq2dfazrhshyx9zv53p','SUBDIST'),(9,'2022-02-08 08:57:14',1,'2022-02-08 08:58:08',1,'pic7@mail.com','202cb962ac59075b964b07152d234b70','pic','seven',NULL,NULL,NULL,'active',NULL,NULL,'it1wq7s6txkfcl6xw2iji0dmebrmc7b41mtv','GROSIR'),(10,'2022-02-08 08:57:34',1,'2022-02-08 09:00:14',1,'pic8@mail.com','202cb962ac59075b964b07152d234b70','pic','eight',NULL,NULL,NULL,'active',NULL,NULL,'macc9yxlcnfjqix254tmbf0h4459a9w22xfi','GROSIR'),(11,'2022-02-08 08:58:30',1,'2022-02-08 09:43:58',1,'pic9@mail.com','202cb962ac59075b964b07152d234b70','pic','nine',NULL,NULL,NULL,'active',NULL,NULL,'jayf1yr5fd07mshu2c4a29ih8li17beubiwc','MOTORIST'),(12,'2022-02-08 08:59:52',1,'2022-02-08 09:48:28',1,'pic10@mail.com','202cb962ac59075b964b07152d234b70','pic','ten',NULL,NULL,NULL,'active',NULL,NULL,'i8m95htaivk0u5mcjfy3ioo0k9zxxf8lpp5h','MOTORIST');
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
) ENGINE=InnoDB AUTO_INCREMENT=847 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_brand`
--

LOCK TABLES `tb_user_brand` WRITE;
/*!40000 ALTER TABLE `tb_user_brand` DISABLE KEYS */;
INSERT INTO `tb_user_brand` VALUES (199,'2022-02-07 09:45:02',1,NULL,NULL,1,'Anessa','ANESS',1),(200,'2022-02-07 09:45:02',1,NULL,NULL,1,'BEBE','BEBEB',1),(201,'2022-02-07 09:45:02',1,NULL,NULL,1,'Cetaphil','CETAP',1),(202,'2022-02-07 09:45:02',1,NULL,NULL,1,'cocacola','COCAC',1),(203,'2022-02-07 09:45:02',1,NULL,NULL,1,'Combiphar','COMBH',1),(204,'2022-02-07 09:45:02',1,NULL,NULL,1,'Innisfree','INNIS',1),(205,'2022-02-07 09:45:02',1,NULL,NULL,1,'Interbat','INTER',1),(206,'2022-02-07 09:45:02',1,NULL,NULL,1,'Laneige','LANEI',1),(207,'2022-02-07 09:45:02',1,NULL,NULL,1,'Mamonde','MAMON',1),(208,'2022-02-07 09:45:02',1,NULL,NULL,1,'Mecard','MECAR',1),(209,'2022-02-07 09:45:02',1,NULL,NULL,1,'Mentos','MENTO',1),(210,'2022-02-07 09:45:02',1,NULL,NULL,1,'Mustela','MUSTE',1),(211,'2022-02-07 09:45:02',1,NULL,NULL,1,'Nestle','NESTL',1),(212,'2022-02-07 09:45:02',1,NULL,NULL,1,'Nutrition','NUTRI',1),(213,'2022-02-07 09:45:02',1,NULL,NULL,1,'P&G Health','PNGHE',1),(214,'2022-02-07 09:45:02',1,NULL,NULL,1,'Pillowpeople','PILLO',1),(215,'2022-02-07 09:45:02',1,NULL,NULL,1,'Purina','PURIN',1),(216,'2022-02-07 09:45:02',1,NULL,NULL,1,'Sulwhasoo','SULWH',1),(451,'2022-02-08 08:57:54',1,NULL,NULL,3,'Anessa','ANESS',1),(452,'2022-02-08 08:57:54',1,NULL,NULL,3,'BEBE','BEBEB',0),(453,'2022-02-08 08:57:54',1,NULL,NULL,3,'Cetaphil','CETAP',0),(454,'2022-02-08 08:57:54',1,NULL,NULL,3,'cocacola','COCAC',0),(455,'2022-02-08 08:57:54',1,NULL,NULL,3,'Combiphar','COMBH',0),(456,'2022-02-08 08:57:54',1,NULL,NULL,3,'Innisfree','INNIS',0),(457,'2022-02-08 08:57:54',1,NULL,NULL,3,'Interbat','INTER',0),(458,'2022-02-08 08:57:54',1,NULL,NULL,3,'Laneige','LANEI',0),(459,'2022-02-08 08:57:54',1,NULL,NULL,3,'Mamonde','MAMON',0),(460,'2022-02-08 08:57:54',1,NULL,NULL,3,'Mecard','MECAR',0),(461,'2022-02-08 08:57:54',1,NULL,NULL,3,'Mentos','MENTO',0),(462,'2022-02-08 08:57:54',1,NULL,NULL,3,'Mustela','MUSTE',0),(463,'2022-02-08 08:57:54',1,NULL,NULL,3,'Nestle','NESTL',0),(464,'2022-02-08 08:57:54',1,NULL,NULL,3,'Nutrition','NUTRI',0),(465,'2022-02-08 08:57:54',1,NULL,NULL,3,'P&G Health','PNGHE',0),(466,'2022-02-08 08:57:54',1,NULL,NULL,3,'Pillowpeople','PILLO',0),(467,'2022-02-08 08:57:54',1,NULL,NULL,3,'Purina','PURIN',0),(468,'2022-02-08 08:57:54',1,NULL,NULL,3,'Sulwhasoo','SULWH',0),(469,'2022-02-08 08:58:01',1,NULL,NULL,5,'Anessa','ANESS',1),(470,'2022-02-08 08:58:01',1,NULL,NULL,5,'BEBE','BEBEB',0),(471,'2022-02-08 08:58:01',1,NULL,NULL,5,'Cetaphil','CETAP',0),(472,'2022-02-08 08:58:01',1,NULL,NULL,5,'cocacola','COCAC',0),(473,'2022-02-08 08:58:01',1,NULL,NULL,5,'Combiphar','COMBH',0),(474,'2022-02-08 08:58:01',1,NULL,NULL,5,'Innisfree','INNIS',0),(475,'2022-02-08 08:58:01',1,NULL,NULL,5,'Interbat','INTER',0),(476,'2022-02-08 08:58:01',1,NULL,NULL,5,'Laneige','LANEI',0),(477,'2022-02-08 08:58:01',1,NULL,NULL,5,'Mamonde','MAMON',0),(478,'2022-02-08 08:58:01',1,NULL,NULL,5,'Mecard','MECAR',0),(479,'2022-02-08 08:58:01',1,NULL,NULL,5,'Mentos','MENTO',0),(480,'2022-02-08 08:58:01',1,NULL,NULL,5,'Mustela','MUSTE',0),(481,'2022-02-08 08:58:01',1,NULL,NULL,5,'Nestle','NESTL',0),(482,'2022-02-08 08:58:01',1,NULL,NULL,5,'Nutrition','NUTRI',0),(483,'2022-02-08 08:58:01',1,NULL,NULL,5,'P&G Health','PNGHE',0),(484,'2022-02-08 08:58:01',1,NULL,NULL,5,'Pillowpeople','PILLO',0),(485,'2022-02-08 08:58:01',1,NULL,NULL,5,'Purina','PURIN',0),(486,'2022-02-08 08:58:01',1,NULL,NULL,5,'Sulwhasoo','SULWH',0),(487,'2022-02-08 08:58:08',1,NULL,NULL,9,'Anessa','ANESS',1),(488,'2022-02-08 08:58:08',1,NULL,NULL,9,'BEBE','BEBEB',1),(489,'2022-02-08 08:58:08',1,NULL,NULL,9,'Cetaphil','CETAP',1),(490,'2022-02-08 08:58:08',1,NULL,NULL,9,'cocacola','COCAC',1),(491,'2022-02-08 08:58:08',1,NULL,NULL,9,'Combiphar','COMBH',1),(492,'2022-02-08 08:58:08',1,NULL,NULL,9,'Innisfree','INNIS',1),(493,'2022-02-08 08:58:08',1,NULL,NULL,9,'Interbat','INTER',1),(494,'2022-02-08 08:58:08',1,NULL,NULL,9,'Laneige','LANEI',1),(495,'2022-02-08 08:58:08',1,NULL,NULL,9,'Mamonde','MAMON',1),(496,'2022-02-08 08:58:08',1,NULL,NULL,9,'Mecard','MECAR',1),(497,'2022-02-08 08:58:08',1,NULL,NULL,9,'Mentos','MENTO',1),(498,'2022-02-08 08:58:08',1,NULL,NULL,9,'Mustela','MUSTE',1),(499,'2022-02-08 08:58:08',1,NULL,NULL,9,'Nestle','NESTL',1),(500,'2022-02-08 08:58:08',1,NULL,NULL,9,'Nutrition','NUTRI',1),(501,'2022-02-08 08:58:08',1,NULL,NULL,9,'P&G Health','PNGHE',1),(502,'2022-02-08 08:58:08',1,NULL,NULL,9,'Pillowpeople','PILLO',1),(503,'2022-02-08 08:58:08',1,NULL,NULL,9,'Purina','PURIN',1),(504,'2022-02-08 08:58:08',1,NULL,NULL,9,'Sulwhasoo','SULWH',1),(541,'2022-02-08 08:59:58',1,NULL,NULL,2,'Anessa','ANESS',1),(542,'2022-02-08 08:59:58',1,NULL,NULL,2,'BEBE','BEBEB',1),(543,'2022-02-08 08:59:58',1,NULL,NULL,2,'Cetaphil','CETAP',0),(544,'2022-02-08 08:59:58',1,NULL,NULL,2,'cocacola','COCAC',0),(545,'2022-02-08 08:59:58',1,NULL,NULL,2,'Combiphar','COMBH',0),(546,'2022-02-08 08:59:58',1,NULL,NULL,2,'Innisfree','INNIS',1),(547,'2022-02-08 08:59:58',1,NULL,NULL,2,'Interbat','INTER',0),(548,'2022-02-08 08:59:58',1,NULL,NULL,2,'Laneige','LANEI',0),(549,'2022-02-08 08:59:58',1,NULL,NULL,2,'Mamonde','MAMON',0),(550,'2022-02-08 08:59:58',1,NULL,NULL,2,'Mecard','MECAR',0),(551,'2022-02-08 08:59:58',1,NULL,NULL,2,'Mentos','MENTO',0),(552,'2022-02-08 08:59:58',1,NULL,NULL,2,'Mustela','MUSTE',0),(553,'2022-02-08 08:59:58',1,NULL,NULL,2,'Nestle','NESTL',0),(554,'2022-02-08 08:59:58',1,NULL,NULL,2,'Nutrition','NUTRI',0),(555,'2022-02-08 08:59:58',1,NULL,NULL,2,'P&G Health','PNGHE',0),(556,'2022-02-08 08:59:58',1,NULL,NULL,2,'Pillowpeople','PILLO',0),(557,'2022-02-08 08:59:58',1,NULL,NULL,2,'Purina','PURIN',0),(558,'2022-02-08 08:59:58',1,NULL,NULL,2,'Sulwhasoo','SULWH',0),(559,'2022-02-08 09:00:03',1,NULL,NULL,4,'Anessa','ANESS',1),(560,'2022-02-08 09:00:03',1,NULL,NULL,4,'BEBE','BEBEB',1),(561,'2022-02-08 09:00:03',1,NULL,NULL,4,'Cetaphil','CETAP',1),(562,'2022-02-08 09:00:03',1,NULL,NULL,4,'cocacola','COCAC',0),(563,'2022-02-08 09:00:03',1,NULL,NULL,4,'Combiphar','COMBH',0),(564,'2022-02-08 09:00:03',1,NULL,NULL,4,'Innisfree','INNIS',1),(565,'2022-02-08 09:00:03',1,NULL,NULL,4,'Interbat','INTER',0),(566,'2022-02-08 09:00:03',1,NULL,NULL,4,'Laneige','LANEI',0),(567,'2022-02-08 09:00:03',1,NULL,NULL,4,'Mamonde','MAMON',0),(568,'2022-02-08 09:00:03',1,NULL,NULL,4,'Mecard','MECAR',0),(569,'2022-02-08 09:00:03',1,NULL,NULL,4,'Mentos','MENTO',0),(570,'2022-02-08 09:00:03',1,NULL,NULL,4,'Mustela','MUSTE',0),(571,'2022-02-08 09:00:03',1,NULL,NULL,4,'Nestle','NESTL',0),(572,'2022-02-08 09:00:03',1,NULL,NULL,4,'Nutrition','NUTRI',0),(573,'2022-02-08 09:00:03',1,NULL,NULL,4,'P&G Health','PNGHE',0),(574,'2022-02-08 09:00:03',1,NULL,NULL,4,'Pillowpeople','PILLO',0),(575,'2022-02-08 09:00:03',1,NULL,NULL,4,'Purina','PURIN',0),(576,'2022-02-08 09:00:03',1,NULL,NULL,4,'Sulwhasoo','SULWH',0),(577,'2022-02-08 09:00:08',1,NULL,NULL,8,'Anessa','ANESS',1),(578,'2022-02-08 09:00:08',1,NULL,NULL,8,'BEBE','BEBEB',0),(579,'2022-02-08 09:00:08',1,NULL,NULL,8,'Cetaphil','CETAP',0),(580,'2022-02-08 09:00:08',1,NULL,NULL,8,'cocacola','COCAC',0),(581,'2022-02-08 09:00:08',1,NULL,NULL,8,'Combiphar','COMBH',0),(582,'2022-02-08 09:00:08',1,NULL,NULL,8,'Innisfree','INNIS',0),(583,'2022-02-08 09:00:08',1,NULL,NULL,8,'Interbat','INTER',0),(584,'2022-02-08 09:00:08',1,NULL,NULL,8,'Laneige','LANEI',0),(585,'2022-02-08 09:00:08',1,NULL,NULL,8,'Mamonde','MAMON',0),(586,'2022-02-08 09:00:08',1,NULL,NULL,8,'Mecard','MECAR',0),(587,'2022-02-08 09:00:08',1,NULL,NULL,8,'Mentos','MENTO',0),(588,'2022-02-08 09:00:08',1,NULL,NULL,8,'Mustela','MUSTE',0),(589,'2022-02-08 09:00:08',1,NULL,NULL,8,'Nestle','NESTL',0),(590,'2022-02-08 09:00:08',1,NULL,NULL,8,'Nutrition','NUTRI',0),(591,'2022-02-08 09:00:08',1,NULL,NULL,8,'P&G Health','PNGHE',0),(592,'2022-02-08 09:00:08',1,NULL,NULL,8,'Pillowpeople','PILLO',0),(593,'2022-02-08 09:00:08',1,NULL,NULL,8,'Purina','PURIN',0),(594,'2022-02-08 09:00:08',1,NULL,NULL,8,'Sulwhasoo','SULWH',0),(595,'2022-02-08 09:00:14',1,NULL,NULL,10,'Anessa','ANESS',1),(596,'2022-02-08 09:00:14',1,NULL,NULL,10,'BEBE','BEBEB',1),(597,'2022-02-08 09:00:14',1,NULL,NULL,10,'Cetaphil','CETAP',1),(598,'2022-02-08 09:00:14',1,NULL,NULL,10,'cocacola','COCAC',1),(599,'2022-02-08 09:00:14',1,NULL,NULL,10,'Combiphar','COMBH',1),(600,'2022-02-08 09:00:14',1,NULL,NULL,10,'Innisfree','INNIS',1),(601,'2022-02-08 09:00:14',1,NULL,NULL,10,'Interbat','INTER',1),(602,'2022-02-08 09:00:14',1,NULL,NULL,10,'Laneige','LANEI',1),(603,'2022-02-08 09:00:14',1,NULL,NULL,10,'Mamonde','MAMON',1),(604,'2022-02-08 09:00:14',1,NULL,NULL,10,'Mecard','MECAR',1),(605,'2022-02-08 09:00:14',1,NULL,NULL,10,'Mentos','MENTO',1),(606,'2022-02-08 09:00:14',1,NULL,NULL,10,'Mustela','MUSTE',1),(607,'2022-02-08 09:00:14',1,NULL,NULL,10,'Nestle','NESTL',1),(608,'2022-02-08 09:00:14',1,NULL,NULL,10,'Nutrition','NUTRI',1),(609,'2022-02-08 09:00:14',1,NULL,NULL,10,'P&G Health','PNGHE',1),(610,'2022-02-08 09:00:14',1,NULL,NULL,10,'Pillowpeople','PILLO',1),(611,'2022-02-08 09:00:14',1,NULL,NULL,10,'Purina','PURIN',1),(612,'2022-02-08 09:00:14',1,NULL,NULL,10,'Sulwhasoo','SULWH',1),(757,'2022-02-08 09:43:58',1,NULL,NULL,11,'Anessa','ANESS',1),(758,'2022-02-08 09:43:58',1,NULL,NULL,11,'BEBE','BEBEB',1),(759,'2022-02-08 09:43:58',1,NULL,NULL,11,'Cetaphil','CETAP',1),(760,'2022-02-08 09:43:58',1,NULL,NULL,11,'cocacola','COCAC',1),(761,'2022-02-08 09:43:58',1,NULL,NULL,11,'Combiphar','COMBH',1),(762,'2022-02-08 09:43:58',1,NULL,NULL,11,'Innisfree','INNIS',1),(763,'2022-02-08 09:43:58',1,NULL,NULL,11,'Interbat','INTER',1),(764,'2022-02-08 09:43:58',1,NULL,NULL,11,'Laneige','LANEI',1),(765,'2022-02-08 09:43:58',1,NULL,NULL,11,'Mamonde','MAMON',1),(766,'2022-02-08 09:43:58',1,NULL,NULL,11,'Mecard','MECAR',1),(767,'2022-02-08 09:43:58',1,NULL,NULL,11,'Mentos','MENTO',1),(768,'2022-02-08 09:43:58',1,NULL,NULL,11,'Mustela','MUSTE',1),(769,'2022-02-08 09:43:58',1,NULL,NULL,11,'Nestle','NESTL',1),(770,'2022-02-08 09:43:58',1,NULL,NULL,11,'Nutrition','NUTRI',1),(771,'2022-02-08 09:43:58',1,NULL,NULL,11,'P&G Health','PNGHE',1),(772,'2022-02-08 09:43:58',1,NULL,NULL,11,'Pillowpeople','PILLO',1),(773,'2022-02-08 09:43:58',1,NULL,NULL,11,'Purina','PURIN',1),(774,'2022-02-08 09:43:58',1,NULL,NULL,11,'Sulwhasoo','SULWH',1),(829,'2022-02-08 09:48:28',1,NULL,NULL,12,'Anessa','ANESS',1),(830,'2022-02-08 09:48:28',1,NULL,NULL,12,'BEBE','BEBEB',1),(831,'2022-02-08 09:48:28',1,NULL,NULL,12,'Cetaphil','CETAP',1),(832,'2022-02-08 09:48:28',1,NULL,NULL,12,'cocacola','COCAC',1),(833,'2022-02-08 09:48:28',1,NULL,NULL,12,'Combiphar','COMBH',1),(834,'2022-02-08 09:48:28',1,NULL,NULL,12,'Innisfree','INNIS',1),(835,'2022-02-08 09:48:28',1,NULL,NULL,12,'Interbat','INTER',1),(836,'2022-02-08 09:48:28',1,NULL,NULL,12,'Laneige','LANEI',1),(837,'2022-02-08 09:48:28',1,NULL,NULL,12,'Mamonde','MAMON',1),(838,'2022-02-08 09:48:28',1,NULL,NULL,12,'Mecard','MECAR',1),(839,'2022-02-08 09:48:28',1,NULL,NULL,12,'Mentos','MENTO',1),(840,'2022-02-08 09:48:28',1,NULL,NULL,12,'Mustela','MUSTE',1),(841,'2022-02-08 09:48:28',1,NULL,NULL,12,'Nestle','NESTL',1),(842,'2022-02-08 09:48:28',1,NULL,NULL,12,'Nutrition','NUTRI',1),(843,'2022-02-08 09:48:28',1,NULL,NULL,12,'P&G Health','PNGHE',1),(844,'2022-02-08 09:48:28',1,NULL,NULL,12,'Pillowpeople','PILLO',1),(845,'2022-02-08 09:48:28',1,NULL,NULL,12,'Purina','PURIN',1),(846,'2022-02-08 09:48:28',1,NULL,NULL,12,'Sulwhasoo','SULWH',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=283 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_menu`
--

LOCK TABLES `tb_user_menu` WRITE;
/*!40000 ALTER TABLE `tb_user_menu` DISABLE KEYS */;
INSERT INTO `tb_user_menu` VALUES (67,'2022-02-07 09:45:02',1,NULL,NULL,1,4,1,1,1,1),(68,'2022-02-07 09:45:02',1,NULL,NULL,1,2,1,1,1,1),(69,'2022-02-07 09:45:02',1,NULL,NULL,1,3,1,1,1,1),(70,'2022-02-07 09:45:02',1,NULL,NULL,1,1,1,1,1,1),(71,'2022-02-07 09:45:02',1,NULL,NULL,1,5,1,1,1,1),(72,'2022-02-07 09:45:02',1,NULL,NULL,1,6,1,1,1,1),(151,'2022-02-08 08:57:54',1,NULL,NULL,3,4,0,0,0,1),(152,'2022-02-08 08:57:54',1,NULL,NULL,3,2,0,0,0,0),(153,'2022-02-08 08:57:54',1,NULL,NULL,3,3,0,0,0,0),(154,'2022-02-08 08:57:54',1,NULL,NULL,3,1,0,0,0,0),(155,'2022-02-08 08:57:54',1,NULL,NULL,3,5,0,0,0,0),(156,'2022-02-08 08:57:54',1,NULL,NULL,3,6,0,0,0,0),(157,'2022-02-08 08:58:01',1,NULL,NULL,5,4,0,0,0,0),(158,'2022-02-08 08:58:01',1,NULL,NULL,5,2,0,0,0,1),(159,'2022-02-08 08:58:01',1,NULL,NULL,5,3,0,0,0,0),(160,'2022-02-08 08:58:01',1,NULL,NULL,5,1,0,0,0,0),(161,'2022-02-08 08:58:01',1,NULL,NULL,5,5,0,0,0,0),(162,'2022-02-08 08:58:01',1,NULL,NULL,5,6,0,0,0,0),(163,'2022-02-08 08:58:08',1,NULL,NULL,9,4,0,0,0,1),(164,'2022-02-08 08:58:08',1,NULL,NULL,9,2,0,0,0,1),(165,'2022-02-08 08:58:08',1,NULL,NULL,9,3,0,0,0,1),(166,'2022-02-08 08:58:08',1,NULL,NULL,9,1,0,0,0,1),(167,'2022-02-08 08:58:08',1,NULL,NULL,9,5,0,0,0,1),(168,'2022-02-08 08:58:08',1,NULL,NULL,9,6,0,0,0,1),(181,'2022-02-08 08:59:58',1,NULL,NULL,2,4,0,0,0,0),(182,'2022-02-08 08:59:58',1,NULL,NULL,2,2,0,0,0,1),(183,'2022-02-08 08:59:58',1,NULL,NULL,2,3,0,0,0,0),(184,'2022-02-08 08:59:58',1,NULL,NULL,2,1,0,0,0,0),(185,'2022-02-08 08:59:58',1,NULL,NULL,2,5,0,0,0,0),(186,'2022-02-08 08:59:58',1,NULL,NULL,2,6,0,0,0,0),(187,'2022-02-08 09:00:03',1,NULL,NULL,4,4,0,0,0,1),(188,'2022-02-08 09:00:03',1,NULL,NULL,4,2,0,0,0,1),(189,'2022-02-08 09:00:03',1,NULL,NULL,4,3,0,0,0,1),(190,'2022-02-08 09:00:03',1,NULL,NULL,4,1,0,0,0,1),(191,'2022-02-08 09:00:03',1,NULL,NULL,4,5,0,0,0,1),(192,'2022-02-08 09:00:03',1,NULL,NULL,4,6,0,0,0,1),(193,'2022-02-08 09:00:08',1,NULL,NULL,8,4,0,0,0,0),(194,'2022-02-08 09:00:08',1,NULL,NULL,8,2,0,0,0,0),(195,'2022-02-08 09:00:08',1,NULL,NULL,8,3,0,0,0,0),(196,'2022-02-08 09:00:08',1,NULL,NULL,8,1,0,0,0,0),(197,'2022-02-08 09:00:08',1,NULL,NULL,8,5,0,0,0,1),(198,'2022-02-08 09:00:08',1,NULL,NULL,8,6,0,0,0,0),(199,'2022-02-08 09:00:14',1,NULL,NULL,10,4,0,0,0,1),(200,'2022-02-08 09:00:14',1,NULL,NULL,10,2,0,0,0,1),(201,'2022-02-08 09:00:14',1,NULL,NULL,10,3,0,0,0,1),(202,'2022-02-08 09:00:14',1,NULL,NULL,10,1,0,0,0,1),(203,'2022-02-08 09:00:14',1,NULL,NULL,10,5,0,0,0,1),(204,'2022-02-08 09:00:14',1,NULL,NULL,10,6,0,0,0,1),(253,'2022-02-08 09:43:58',1,NULL,NULL,11,4,0,0,0,1),(254,'2022-02-08 09:43:58',1,NULL,NULL,11,2,0,0,0,1),(255,'2022-02-08 09:43:58',1,NULL,NULL,11,3,0,0,0,1),(256,'2022-02-08 09:43:58',1,NULL,NULL,11,1,0,0,0,1),(257,'2022-02-08 09:43:58',1,NULL,NULL,11,5,0,0,0,1),(258,'2022-02-08 09:43:58',1,NULL,NULL,11,6,0,0,0,1),(277,'2022-02-08 09:48:28',1,NULL,NULL,12,4,0,0,0,1),(278,'2022-02-08 09:48:28',1,NULL,NULL,12,2,0,0,0,1),(279,'2022-02-08 09:48:28',1,NULL,NULL,12,3,0,0,0,1),(280,'2022-02-08 09:48:28',1,NULL,NULL,12,1,0,0,0,1),(281,'2022-02-08 09:48:28',1,NULL,NULL,12,5,0,0,0,1),(282,'2022-02-08 09:48:28',1,NULL,NULL,12,6,0,0,0,1);
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

-- Dump completed on 2022-02-08 17:20:01
