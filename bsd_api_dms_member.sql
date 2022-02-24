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
  `tbm_sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`tbm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_menu`
--

LOCK TABLES `tb_menu` WRITE;
/*!40000 ALTER TABLE `tb_menu` DISABLE KEYS */;
INSERT INTO `tb_menu` VALUES (1,'2021-07-31 15:26:21',0,NULL,NULL,'Product',2),(2,'2021-07-31 15:26:21',0,NULL,NULL,'Order',3),(3,'2021-07-31 15:26:21',0,NULL,NULL,'Packing',4),(4,'2021-07-31 15:26:21',0,NULL,NULL,'Confirm',5),(5,'2021-07-31 15:26:21',0,NULL,NULL,'Report',6),(6,'2021-07-31 15:26:21',0,NULL,NULL,'User',7),(7,'2021-07-31 15:26:21',0,NULL,NULL,'Market',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,NULL,NULL,NULL,NULL,'admin@mail.com','202cb962ac59075b964b07152d234b70','admin','admin',NULL,NULL,NULL,'active',NULL,NULL,'jnsr8q8t7dzgqv8qqmkfsffc5mqdn5fec4af','ADMIN'),(2,NULL,NULL,'2022-02-24 00:36:55',1,'pic1@mail.com','202cb962ac59075b964b07152d234b70','pic','one',NULL,NULL,NULL,'active',NULL,NULL,'ng843n6ocg719kklqklb5814t9n2ahilj9zv','PRINCIPAL'),(3,NULL,NULL,'2022-02-24 00:36:59',1,'pic2@mail.com','202cb962ac59075b964b07152d234b70','pic','two',NULL,NULL,NULL,'active',NULL,NULL,'b3n95p03tsdpm9fya84cnelibj9u34xffz6j','DISTRIBUTOR'),(4,NULL,NULL,'2022-02-24 00:37:08',1,'pic3@mail.com','202cb962ac59075b964b07152d234b70','pic','three',NULL,NULL,NULL,'active',NULL,NULL,'zxfxjhji09xdf66s3usg6ro49l76ckrcmhyl','DISTRIBUTOR'),(5,NULL,NULL,'2022-02-24 00:37:13',1,'pic4@mail.com','202cb962ac59075b964b07152d234b70','pic','four',NULL,NULL,NULL,'active',NULL,NULL,'ni5ju0wgw0l4x3gxoq0cgh3jn3lyvejl5aq8','SUBDIST'),(6,NULL,NULL,'2022-02-24 00:37:18',1,'pic6@mail.com','202cb962ac59075b964b07152d234b70','pic','six',NULL,NULL,NULL,'active',NULL,NULL,'onlidhsdmmgz9k8gxzq2dfazrhshyx9zv53p','SUBDIST'),(7,NULL,NULL,'2022-02-24 00:37:30',1,'pic7@mail.com','202cb962ac59075b964b07152d234b70','pic','seven',NULL,NULL,NULL,'active',NULL,NULL,'it1wq7s6txkfcl6xw2iji0dmebrmc7b41mtv','GROSIR'),(8,NULL,NULL,'2022-02-24 00:37:34',1,'pic8@mail.com','202cb962ac59075b964b07152d234b70','pic','eight',NULL,NULL,NULL,'active',NULL,NULL,'macc9yxlcnfjqix254tmbf0h4459a9w22xfi','GROSIR'),(9,NULL,NULL,'2022-02-24 00:37:39',1,'pic9@mail.com','202cb962ac59075b964b07152d234b70','pic','nine',NULL,NULL,NULL,'active',NULL,NULL,'jayf1yr5fd07mshu2c4a29ih8li17beubiwc','MOTORIST'),(10,NULL,NULL,'2022-02-24 00:37:44',1,'pic10@mail.com','202cb962ac59075b964b07152d234b70','pic','ten',NULL,NULL,NULL,'active',NULL,NULL,'i8m95htaivk0u5mcjfy3ioo0k9zxxf8lpp5h','MOTORIST'),(12,'2022-02-14 11:18:06',1,'2022-02-24 00:37:48',1,'pic11@mail.com','202cb962ac59075b964b07152d234b70','pic','eleven',NULL,NULL,NULL,'active',NULL,NULL,'lk9i5cv2dm5bnyz07apzo3wirxodwfhhxf85','DISTRIBUTOR'),(13,'2022-02-14 11:19:22',1,'2022-02-24 00:37:52',1,'pic12@mail.com','202cb962ac59075b964b07152d234b70','pic','twelve',NULL,NULL,NULL,'active',NULL,NULL,'uzf4niy96076mn4crvfsalm9r06uoey2spjj','GROSIR'),(14,'2022-02-16 07:42:38',1,'2022-02-24 00:37:55',1,'pic13@mail.com','202cb962ac59075b964b07152d234b70','pic','thirteen',NULL,NULL,NULL,'active',NULL,NULL,'oka59r3uxjbqi7pfwpv2kbiyf1tuxedqvam6','GROSIR');
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
) ENGINE=InnoDB AUTO_INCREMENT=742 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_brand`
--

LOCK TABLES `tb_user_brand` WRITE;
/*!40000 ALTER TABLE `tb_user_brand` DISABLE KEYS */;
INSERT INTO `tb_user_brand` VALUES (1,'2022-02-15 11:45:45',0,NULL,NULL,1,'Innisfree','INNIS',1),(2,'2022-02-15 11:45:45',0,NULL,NULL,1,'Laneige','LANEI',1),(3,'2022-02-15 11:45:45',0,NULL,NULL,1,'Mamonde','MAMON',1),(4,'2022-02-15 11:45:45',0,NULL,NULL,1,'Cetaphil','CETAP',1),(5,'2022-02-15 11:45:45',0,NULL,NULL,1,'Anessa','ANESS',1),(6,'2022-02-15 11:45:45',0,NULL,NULL,1,'Mustela','MUSTE',1),(7,'2022-02-15 11:45:45',0,NULL,NULL,1,'Interbat','INTER',1),(8,'2022-02-15 11:45:45',0,NULL,NULL,1,'Nestle','NESTL',1),(9,'2022-02-15 11:45:45',0,NULL,NULL,1,'Nutrition','NUTRI',1),(10,'2022-02-15 11:45:45',0,NULL,NULL,1,'Purina','PURIN',1),(11,'2022-02-15 11:45:45',0,NULL,NULL,1,'Mentos','MENTO',1),(12,'2022-02-15 11:45:45',0,NULL,NULL,1,'P&G Health','PNGHE',1),(13,'2022-02-15 11:45:45',0,NULL,NULL,1,'Combiphar','COMBH',1),(14,'2022-02-15 11:45:45',0,NULL,NULL,1,'BEBE','BEBEB',1),(15,'2022-02-15 11:45:45',0,NULL,NULL,1,'Pillowpeople','PILLO',1),(16,'2022-02-15 11:45:45',0,NULL,NULL,1,'Sulwhasoo','SULWH',1),(17,'2022-02-15 11:45:45',0,NULL,NULL,1,'cocacola','COCAC',1),(18,'2022-02-15 11:45:45',0,NULL,NULL,1,'Mecard','MECAR',1),(508,'2022-02-24 00:36:55',1,NULL,NULL,2,'Anessa','ANESS',1),(509,'2022-02-24 00:36:55',1,NULL,NULL,2,'BEBE','BEBEB',1),(510,'2022-02-24 00:36:55',1,NULL,NULL,2,'Cetaphil','CETAP',1),(511,'2022-02-24 00:36:55',1,NULL,NULL,2,'cocacola','COCAC',1),(512,'2022-02-24 00:36:55',1,NULL,NULL,2,'Combiphar','COMBH',1),(513,'2022-02-24 00:36:55',1,NULL,NULL,2,'Innisfree','INNIS',1),(514,'2022-02-24 00:36:55',1,NULL,NULL,2,'Interbat','INTER',1),(515,'2022-02-24 00:36:55',1,NULL,NULL,2,'Laneige','LANEI',1),(516,'2022-02-24 00:36:55',1,NULL,NULL,2,'Mamonde','MAMON',1),(517,'2022-02-24 00:36:55',1,NULL,NULL,2,'Mecard','MECAR',1),(518,'2022-02-24 00:36:55',1,NULL,NULL,2,'Mentos','MENTO',1),(519,'2022-02-24 00:36:55',1,NULL,NULL,2,'Mustela','MUSTE',1),(520,'2022-02-24 00:36:55',1,NULL,NULL,2,'Nestle','NESTL',1),(521,'2022-02-24 00:36:55',1,NULL,NULL,2,'Nutrition','NUTRI',1),(522,'2022-02-24 00:36:55',1,NULL,NULL,2,'P&G Health','PNGHE',1),(523,'2022-02-24 00:36:55',1,NULL,NULL,2,'Pillowpeople','PILLO',1),(524,'2022-02-24 00:36:55',1,NULL,NULL,2,'Purina','PURIN',1),(525,'2022-02-24 00:36:55',1,NULL,NULL,2,'Sulwhasoo','SULWH',1),(526,'2022-02-24 00:36:59',1,NULL,NULL,3,'Anessa','ANESS',1),(527,'2022-02-24 00:36:59',1,NULL,NULL,3,'BEBE','BEBEB',1),(528,'2022-02-24 00:36:59',1,NULL,NULL,3,'Cetaphil','CETAP',1),(529,'2022-02-24 00:36:59',1,NULL,NULL,3,'cocacola','COCAC',1),(530,'2022-02-24 00:36:59',1,NULL,NULL,3,'Combiphar','COMBH',1),(531,'2022-02-24 00:36:59',1,NULL,NULL,3,'Innisfree','INNIS',1),(532,'2022-02-24 00:36:59',1,NULL,NULL,3,'Interbat','INTER',1),(533,'2022-02-24 00:36:59',1,NULL,NULL,3,'Laneige','LANEI',1),(534,'2022-02-24 00:36:59',1,NULL,NULL,3,'Mamonde','MAMON',1),(535,'2022-02-24 00:36:59',1,NULL,NULL,3,'Mecard','MECAR',1),(536,'2022-02-24 00:36:59',1,NULL,NULL,3,'Mentos','MENTO',1),(537,'2022-02-24 00:36:59',1,NULL,NULL,3,'Mustela','MUSTE',1),(538,'2022-02-24 00:36:59',1,NULL,NULL,3,'Nestle','NESTL',1),(539,'2022-02-24 00:36:59',1,NULL,NULL,3,'Nutrition','NUTRI',1),(540,'2022-02-24 00:36:59',1,NULL,NULL,3,'P&G Health','PNGHE',1),(541,'2022-02-24 00:36:59',1,NULL,NULL,3,'Pillowpeople','PILLO',1),(542,'2022-02-24 00:36:59',1,NULL,NULL,3,'Purina','PURIN',1),(543,'2022-02-24 00:36:59',1,NULL,NULL,3,'Sulwhasoo','SULWH',1),(562,'2022-02-24 00:37:08',1,NULL,NULL,4,'Anessa','ANESS',1),(563,'2022-02-24 00:37:08',1,NULL,NULL,4,'BEBE','BEBEB',1),(564,'2022-02-24 00:37:08',1,NULL,NULL,4,'Cetaphil','CETAP',1),(565,'2022-02-24 00:37:08',1,NULL,NULL,4,'cocacola','COCAC',1),(566,'2022-02-24 00:37:08',1,NULL,NULL,4,'Combiphar','COMBH',1),(567,'2022-02-24 00:37:08',1,NULL,NULL,4,'Innisfree','INNIS',1),(568,'2022-02-24 00:37:08',1,NULL,NULL,4,'Interbat','INTER',1),(569,'2022-02-24 00:37:08',1,NULL,NULL,4,'Laneige','LANEI',1),(570,'2022-02-24 00:37:08',1,NULL,NULL,4,'Mamonde','MAMON',1),(571,'2022-02-24 00:37:08',1,NULL,NULL,4,'Mecard','MECAR',1),(572,'2022-02-24 00:37:08',1,NULL,NULL,4,'Mentos','MENTO',1),(573,'2022-02-24 00:37:08',1,NULL,NULL,4,'Mustela','MUSTE',1),(574,'2022-02-24 00:37:08',1,NULL,NULL,4,'Nestle','NESTL',1),(575,'2022-02-24 00:37:08',1,NULL,NULL,4,'Nutrition','NUTRI',1),(576,'2022-02-24 00:37:08',1,NULL,NULL,4,'P&G Health','PNGHE',1),(577,'2022-02-24 00:37:08',1,NULL,NULL,4,'Pillowpeople','PILLO',1),(578,'2022-02-24 00:37:08',1,NULL,NULL,4,'Purina','PURIN',1),(579,'2022-02-24 00:37:08',1,NULL,NULL,4,'Sulwhasoo','SULWH',1),(580,'2022-02-24 00:37:13',1,NULL,NULL,5,'Anessa','ANESS',1),(581,'2022-02-24 00:37:13',1,NULL,NULL,5,'BEBE','BEBEB',1),(582,'2022-02-24 00:37:13',1,NULL,NULL,5,'Cetaphil','CETAP',1),(583,'2022-02-24 00:37:13',1,NULL,NULL,5,'cocacola','COCAC',1),(584,'2022-02-24 00:37:13',1,NULL,NULL,5,'Combiphar','COMBH',1),(585,'2022-02-24 00:37:13',1,NULL,NULL,5,'Innisfree','INNIS',1),(586,'2022-02-24 00:37:13',1,NULL,NULL,5,'Interbat','INTER',1),(587,'2022-02-24 00:37:13',1,NULL,NULL,5,'Laneige','LANEI',1),(588,'2022-02-24 00:37:13',1,NULL,NULL,5,'Mamonde','MAMON',1),(589,'2022-02-24 00:37:13',1,NULL,NULL,5,'Mecard','MECAR',1),(590,'2022-02-24 00:37:13',1,NULL,NULL,5,'Mentos','MENTO',1),(591,'2022-02-24 00:37:13',1,NULL,NULL,5,'Mustela','MUSTE',1),(592,'2022-02-24 00:37:13',1,NULL,NULL,5,'Nestle','NESTL',1),(593,'2022-02-24 00:37:13',1,NULL,NULL,5,'Nutrition','NUTRI',1),(594,'2022-02-24 00:37:13',1,NULL,NULL,5,'P&G Health','PNGHE',1),(595,'2022-02-24 00:37:13',1,NULL,NULL,5,'Pillowpeople','PILLO',1),(596,'2022-02-24 00:37:13',1,NULL,NULL,5,'Purina','PURIN',1),(597,'2022-02-24 00:37:13',1,NULL,NULL,5,'Sulwhasoo','SULWH',1),(598,'2022-02-24 00:37:18',1,NULL,NULL,6,'Anessa','ANESS',1),(599,'2022-02-24 00:37:18',1,NULL,NULL,6,'BEBE','BEBEB',1),(600,'2022-02-24 00:37:18',1,NULL,NULL,6,'Cetaphil','CETAP',1),(601,'2022-02-24 00:37:18',1,NULL,NULL,6,'cocacola','COCAC',1),(602,'2022-02-24 00:37:18',1,NULL,NULL,6,'Combiphar','COMBH',1),(603,'2022-02-24 00:37:18',1,NULL,NULL,6,'Innisfree','INNIS',1),(604,'2022-02-24 00:37:18',1,NULL,NULL,6,'Interbat','INTER',1),(605,'2022-02-24 00:37:18',1,NULL,NULL,6,'Laneige','LANEI',1),(606,'2022-02-24 00:37:18',1,NULL,NULL,6,'Mamonde','MAMON',1),(607,'2022-02-24 00:37:18',1,NULL,NULL,6,'Mecard','MECAR',1),(608,'2022-02-24 00:37:18',1,NULL,NULL,6,'Mentos','MENTO',1),(609,'2022-02-24 00:37:18',1,NULL,NULL,6,'Mustela','MUSTE',1),(610,'2022-02-24 00:37:18',1,NULL,NULL,6,'Nestle','NESTL',1),(611,'2022-02-24 00:37:18',1,NULL,NULL,6,'Nutrition','NUTRI',1),(612,'2022-02-24 00:37:18',1,NULL,NULL,6,'P&G Health','PNGHE',1),(613,'2022-02-24 00:37:18',1,NULL,NULL,6,'Pillowpeople','PILLO',1),(614,'2022-02-24 00:37:18',1,NULL,NULL,6,'Purina','PURIN',1),(615,'2022-02-24 00:37:18',1,NULL,NULL,6,'Sulwhasoo','SULWH',1),(616,'2022-02-24 00:37:30',1,NULL,NULL,7,'Anessa','ANESS',1),(617,'2022-02-24 00:37:30',1,NULL,NULL,7,'BEBE','BEBEB',1),(618,'2022-02-24 00:37:30',1,NULL,NULL,7,'Cetaphil','CETAP',1),(619,'2022-02-24 00:37:30',1,NULL,NULL,7,'cocacola','COCAC',1),(620,'2022-02-24 00:37:30',1,NULL,NULL,7,'Combiphar','COMBH',1),(621,'2022-02-24 00:37:30',1,NULL,NULL,7,'Innisfree','INNIS',1),(622,'2022-02-24 00:37:30',1,NULL,NULL,7,'Interbat','INTER',1),(623,'2022-02-24 00:37:30',1,NULL,NULL,7,'Laneige','LANEI',1),(624,'2022-02-24 00:37:30',1,NULL,NULL,7,'Mamonde','MAMON',1),(625,'2022-02-24 00:37:30',1,NULL,NULL,7,'Mecard','MECAR',1),(626,'2022-02-24 00:37:30',1,NULL,NULL,7,'Mentos','MENTO',1),(627,'2022-02-24 00:37:30',1,NULL,NULL,7,'Mustela','MUSTE',1),(628,'2022-02-24 00:37:30',1,NULL,NULL,7,'Nestle','NESTL',1),(629,'2022-02-24 00:37:30',1,NULL,NULL,7,'Nutrition','NUTRI',1),(630,'2022-02-24 00:37:30',1,NULL,NULL,7,'P&G Health','PNGHE',1),(631,'2022-02-24 00:37:30',1,NULL,NULL,7,'Pillowpeople','PILLO',1),(632,'2022-02-24 00:37:30',1,NULL,NULL,7,'Purina','PURIN',1),(633,'2022-02-24 00:37:30',1,NULL,NULL,7,'Sulwhasoo','SULWH',1),(634,'2022-02-24 00:37:34',1,NULL,NULL,8,'Anessa','ANESS',1),(635,'2022-02-24 00:37:34',1,NULL,NULL,8,'BEBE','BEBEB',1),(636,'2022-02-24 00:37:34',1,NULL,NULL,8,'Cetaphil','CETAP',1),(637,'2022-02-24 00:37:34',1,NULL,NULL,8,'cocacola','COCAC',1),(638,'2022-02-24 00:37:34',1,NULL,NULL,8,'Combiphar','COMBH',1),(639,'2022-02-24 00:37:34',1,NULL,NULL,8,'Innisfree','INNIS',1),(640,'2022-02-24 00:37:34',1,NULL,NULL,8,'Interbat','INTER',1),(641,'2022-02-24 00:37:34',1,NULL,NULL,8,'Laneige','LANEI',1),(642,'2022-02-24 00:37:34',1,NULL,NULL,8,'Mamonde','MAMON',1),(643,'2022-02-24 00:37:34',1,NULL,NULL,8,'Mecard','MECAR',1),(644,'2022-02-24 00:37:34',1,NULL,NULL,8,'Mentos','MENTO',1),(645,'2022-02-24 00:37:34',1,NULL,NULL,8,'Mustela','MUSTE',1),(646,'2022-02-24 00:37:34',1,NULL,NULL,8,'Nestle','NESTL',1),(647,'2022-02-24 00:37:34',1,NULL,NULL,8,'Nutrition','NUTRI',1),(648,'2022-02-24 00:37:34',1,NULL,NULL,8,'P&G Health','PNGHE',1),(649,'2022-02-24 00:37:34',1,NULL,NULL,8,'Pillowpeople','PILLO',1),(650,'2022-02-24 00:37:34',1,NULL,NULL,8,'Purina','PURIN',1),(651,'2022-02-24 00:37:34',1,NULL,NULL,8,'Sulwhasoo','SULWH',1),(652,'2022-02-24 00:37:39',1,NULL,NULL,9,'Anessa','ANESS',1),(653,'2022-02-24 00:37:39',1,NULL,NULL,9,'BEBE','BEBEB',1),(654,'2022-02-24 00:37:39',1,NULL,NULL,9,'Cetaphil','CETAP',1),(655,'2022-02-24 00:37:39',1,NULL,NULL,9,'cocacola','COCAC',1),(656,'2022-02-24 00:37:39',1,NULL,NULL,9,'Combiphar','COMBH',1),(657,'2022-02-24 00:37:39',1,NULL,NULL,9,'Innisfree','INNIS',1),(658,'2022-02-24 00:37:39',1,NULL,NULL,9,'Interbat','INTER',1),(659,'2022-02-24 00:37:39',1,NULL,NULL,9,'Laneige','LANEI',1),(660,'2022-02-24 00:37:39',1,NULL,NULL,9,'Mamonde','MAMON',1),(661,'2022-02-24 00:37:39',1,NULL,NULL,9,'Mecard','MECAR',1),(662,'2022-02-24 00:37:39',1,NULL,NULL,9,'Mentos','MENTO',1),(663,'2022-02-24 00:37:39',1,NULL,NULL,9,'Mustela','MUSTE',1),(664,'2022-02-24 00:37:39',1,NULL,NULL,9,'Nestle','NESTL',1),(665,'2022-02-24 00:37:39',1,NULL,NULL,9,'Nutrition','NUTRI',1),(666,'2022-02-24 00:37:39',1,NULL,NULL,9,'P&G Health','PNGHE',1),(667,'2022-02-24 00:37:39',1,NULL,NULL,9,'Pillowpeople','PILLO',1),(668,'2022-02-24 00:37:39',1,NULL,NULL,9,'Purina','PURIN',1),(669,'2022-02-24 00:37:39',1,NULL,NULL,9,'Sulwhasoo','SULWH',1),(670,'2022-02-24 00:37:44',1,NULL,NULL,10,'Anessa','ANESS',1),(671,'2022-02-24 00:37:44',1,NULL,NULL,10,'BEBE','BEBEB',1),(672,'2022-02-24 00:37:44',1,NULL,NULL,10,'Cetaphil','CETAP',1),(673,'2022-02-24 00:37:44',1,NULL,NULL,10,'cocacola','COCAC',1),(674,'2022-02-24 00:37:44',1,NULL,NULL,10,'Combiphar','COMBH',1),(675,'2022-02-24 00:37:44',1,NULL,NULL,10,'Innisfree','INNIS',1),(676,'2022-02-24 00:37:44',1,NULL,NULL,10,'Interbat','INTER',1),(677,'2022-02-24 00:37:44',1,NULL,NULL,10,'Laneige','LANEI',1),(678,'2022-02-24 00:37:44',1,NULL,NULL,10,'Mamonde','MAMON',1),(679,'2022-02-24 00:37:44',1,NULL,NULL,10,'Mecard','MECAR',1),(680,'2022-02-24 00:37:44',1,NULL,NULL,10,'Mentos','MENTO',1),(681,'2022-02-24 00:37:44',1,NULL,NULL,10,'Mustela','MUSTE',1),(682,'2022-02-24 00:37:44',1,NULL,NULL,10,'Nestle','NESTL',1),(683,'2022-02-24 00:37:44',1,NULL,NULL,10,'Nutrition','NUTRI',1),(684,'2022-02-24 00:37:44',1,NULL,NULL,10,'P&G Health','PNGHE',1),(685,'2022-02-24 00:37:44',1,NULL,NULL,10,'Pillowpeople','PILLO',1),(686,'2022-02-24 00:37:44',1,NULL,NULL,10,'Purina','PURIN',1),(687,'2022-02-24 00:37:44',1,NULL,NULL,10,'Sulwhasoo','SULWH',1),(688,'2022-02-24 00:37:48',1,NULL,NULL,12,'Anessa','ANESS',1),(689,'2022-02-24 00:37:48',1,NULL,NULL,12,'BEBE','BEBEB',1),(690,'2022-02-24 00:37:48',1,NULL,NULL,12,'Cetaphil','CETAP',1),(691,'2022-02-24 00:37:48',1,NULL,NULL,12,'cocacola','COCAC',1),(692,'2022-02-24 00:37:48',1,NULL,NULL,12,'Combiphar','COMBH',1),(693,'2022-02-24 00:37:48',1,NULL,NULL,12,'Innisfree','INNIS',1),(694,'2022-02-24 00:37:48',1,NULL,NULL,12,'Interbat','INTER',1),(695,'2022-02-24 00:37:48',1,NULL,NULL,12,'Laneige','LANEI',1),(696,'2022-02-24 00:37:48',1,NULL,NULL,12,'Mamonde','MAMON',1),(697,'2022-02-24 00:37:48',1,NULL,NULL,12,'Mecard','MECAR',1),(698,'2022-02-24 00:37:48',1,NULL,NULL,12,'Mentos','MENTO',1),(699,'2022-02-24 00:37:48',1,NULL,NULL,12,'Mustela','MUSTE',1),(700,'2022-02-24 00:37:48',1,NULL,NULL,12,'Nestle','NESTL',1),(701,'2022-02-24 00:37:48',1,NULL,NULL,12,'Nutrition','NUTRI',1),(702,'2022-02-24 00:37:48',1,NULL,NULL,12,'P&G Health','PNGHE',1),(703,'2022-02-24 00:37:48',1,NULL,NULL,12,'Pillowpeople','PILLO',1),(704,'2022-02-24 00:37:48',1,NULL,NULL,12,'Purina','PURIN',1),(705,'2022-02-24 00:37:48',1,NULL,NULL,12,'Sulwhasoo','SULWH',1),(706,'2022-02-24 00:37:52',1,NULL,NULL,13,'Anessa','ANESS',1),(707,'2022-02-24 00:37:52',1,NULL,NULL,13,'BEBE','BEBEB',1),(708,'2022-02-24 00:37:52',1,NULL,NULL,13,'Cetaphil','CETAP',1),(709,'2022-02-24 00:37:52',1,NULL,NULL,13,'cocacola','COCAC',1),(710,'2022-02-24 00:37:52',1,NULL,NULL,13,'Combiphar','COMBH',1),(711,'2022-02-24 00:37:52',1,NULL,NULL,13,'Innisfree','INNIS',1),(712,'2022-02-24 00:37:52',1,NULL,NULL,13,'Interbat','INTER',1),(713,'2022-02-24 00:37:52',1,NULL,NULL,13,'Laneige','LANEI',1),(714,'2022-02-24 00:37:52',1,NULL,NULL,13,'Mamonde','MAMON',1),(715,'2022-02-24 00:37:52',1,NULL,NULL,13,'Mecard','MECAR',1),(716,'2022-02-24 00:37:52',1,NULL,NULL,13,'Mentos','MENTO',1),(717,'2022-02-24 00:37:52',1,NULL,NULL,13,'Mustela','MUSTE',1),(718,'2022-02-24 00:37:52',1,NULL,NULL,13,'Nestle','NESTL',1),(719,'2022-02-24 00:37:52',1,NULL,NULL,13,'Nutrition','NUTRI',1),(720,'2022-02-24 00:37:52',1,NULL,NULL,13,'P&G Health','PNGHE',1),(721,'2022-02-24 00:37:52',1,NULL,NULL,13,'Pillowpeople','PILLO',1),(722,'2022-02-24 00:37:52',1,NULL,NULL,13,'Purina','PURIN',1),(723,'2022-02-24 00:37:52',1,NULL,NULL,13,'Sulwhasoo','SULWH',1),(724,'2022-02-24 00:37:55',1,NULL,NULL,14,'Anessa','ANESS',1),(725,'2022-02-24 00:37:55',1,NULL,NULL,14,'BEBE','BEBEB',1),(726,'2022-02-24 00:37:55',1,NULL,NULL,14,'Cetaphil','CETAP',1),(727,'2022-02-24 00:37:55',1,NULL,NULL,14,'cocacola','COCAC',1),(728,'2022-02-24 00:37:55',1,NULL,NULL,14,'Combiphar','COMBH',1),(729,'2022-02-24 00:37:55',1,NULL,NULL,14,'Innisfree','INNIS',1),(730,'2022-02-24 00:37:55',1,NULL,NULL,14,'Interbat','INTER',1),(731,'2022-02-24 00:37:55',1,NULL,NULL,14,'Laneige','LANEI',1),(732,'2022-02-24 00:37:55',1,NULL,NULL,14,'Mamonde','MAMON',1),(733,'2022-02-24 00:37:55',1,NULL,NULL,14,'Mecard','MECAR',1),(734,'2022-02-24 00:37:55',1,NULL,NULL,14,'Mentos','MENTO',1),(735,'2022-02-24 00:37:55',1,NULL,NULL,14,'Mustela','MUSTE',1),(736,'2022-02-24 00:37:55',1,NULL,NULL,14,'Nestle','NESTL',1),(737,'2022-02-24 00:37:55',1,NULL,NULL,14,'Nutrition','NUTRI',1),(738,'2022-02-24 00:37:55',1,NULL,NULL,14,'P&G Health','PNGHE',1),(739,'2022-02-24 00:37:55',1,NULL,NULL,14,'Pillowpeople','PILLO',1),(740,'2022-02-24 00:37:55',1,NULL,NULL,14,'Purina','PURIN',1),(741,'2022-02-24 00:37:55',1,NULL,NULL,14,'Sulwhasoo','SULWH',1);
/*!40000 ALTER TABLE `tb_user_brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_market`
--

DROP TABLE IF EXISTS `tb_user_market`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user_market` (
  `tbum_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbum_create_date` datetime DEFAULT NULL,
  `tbum_create_id` int(11) DEFAULT NULL,
  `tbum_update_date` datetime DEFAULT NULL,
  `tbum_update_id` int(11) DEFAULT NULL,
  `tbu_id` int(11) DEFAULT NULL,
  `tbm_market` varchar(255) DEFAULT NULL,
  `tbm_market_check` int(11) DEFAULT NULL,
  PRIMARY KEY (`tbum_id`)
) ENGINE=InnoDB AUTO_INCREMENT=561 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_market`
--

LOCK TABLES `tb_user_market` WRITE;
/*!40000 ALTER TABLE `tb_user_market` DISABLE KEYS */;
INSERT INTO `tb_user_market` VALUES (1,'2022-02-15 11:29:33',0,NULL,NULL,1,'Principal A',1),(2,'2022-02-15 11:29:33',0,NULL,NULL,1,'Distributor A',1),(3,'2022-02-15 11:29:33',0,NULL,NULL,1,'Distributor B',1),(4,'2022-02-15 11:29:33',0,NULL,NULL,1,'Subdist A',1),(5,'2022-02-15 11:29:33',0,NULL,NULL,1,'Subdist B',1),(6,'2022-02-15 11:29:33',0,NULL,NULL,1,'Subdist C',1),(7,'2022-02-15 11:29:33',0,NULL,NULL,1,'Subdist D',1),(8,'2022-02-15 11:29:33',0,NULL,NULL,1,'Subdist E',1),(9,'2022-02-15 11:29:33',0,NULL,NULL,1,'Grosir A',1),(10,'2022-02-15 11:29:33',0,NULL,NULL,1,'Grosir B',1),(11,'2022-02-15 11:29:33',0,NULL,NULL,1,'Grosir C',1),(12,'2022-02-15 11:29:33',0,NULL,NULL,1,'Grosir D',1),(13,'2022-02-15 11:29:33',0,NULL,NULL,1,'Grosir E',1),(14,'2022-02-15 11:29:33',0,NULL,NULL,1,'Grosir F',1),(15,'2022-02-15 11:29:33',0,NULL,NULL,1,'Grosir G',1),(425,'2022-02-24 00:36:55',1,NULL,NULL,2,'Principal A',1),(426,'2022-02-24 00:36:55',1,NULL,NULL,2,'Distributor A',1),(427,'2022-02-24 00:36:55',1,NULL,NULL,2,'Subdist A',1),(428,'2022-02-24 00:36:55',1,NULL,NULL,2,'Grosir A',1),(429,'2022-02-24 00:36:55',1,NULL,NULL,2,'Motorist A',1),(430,'2022-02-24 00:36:55',1,NULL,NULL,2,'Grosir B',1),(431,'2022-02-24 00:36:55',1,NULL,NULL,2,'Grosir C',1),(432,'2022-02-24 00:36:55',1,NULL,NULL,2,'Subdist B',1),(433,'2022-02-24 00:36:55',1,NULL,NULL,2,'Grosir D',1),(434,'2022-02-24 00:36:55',1,NULL,NULL,2,'Grosir E',1),(435,'2022-02-24 00:36:55',1,NULL,NULL,2,'Grosir F',1),(436,'2022-02-24 00:36:55',1,NULL,NULL,2,'Grosir G',1),(437,'2022-02-24 00:36:55',1,NULL,NULL,2,'Subdist C',1),(438,'2022-02-24 00:36:55',1,NULL,NULL,2,'Distributor B',1),(439,'2022-02-24 00:36:55',1,NULL,NULL,2,'Subdist D',1),(440,'2022-02-24 00:36:55',1,NULL,NULL,2,'Subdist E',1),(441,'2022-02-24 00:36:59',1,NULL,NULL,3,'Distributor A',1),(442,'2022-02-24 00:36:59',1,NULL,NULL,3,'Distributor B',1),(443,'2022-02-24 00:36:59',1,NULL,NULL,3,'Subdist A',1),(444,'2022-02-24 00:36:59',1,NULL,NULL,3,'Grosir A',1),(445,'2022-02-24 00:36:59',1,NULL,NULL,3,'Motorist A',1),(446,'2022-02-24 00:36:59',1,NULL,NULL,3,'Grosir B',1),(447,'2022-02-24 00:36:59',1,NULL,NULL,3,'Grosir C',1),(448,'2022-02-24 00:36:59',1,NULL,NULL,3,'Subdist B',1),(449,'2022-02-24 00:36:59',1,NULL,NULL,3,'Grosir D',1),(450,'2022-02-24 00:36:59',1,NULL,NULL,3,'Grosir E',1),(451,'2022-02-24 00:36:59',1,NULL,NULL,3,'Grosir F',1),(452,'2022-02-24 00:36:59',1,NULL,NULL,3,'Grosir G',1),(453,'2022-02-24 00:36:59',1,NULL,NULL,3,'Subdist C',1),(454,'2022-02-24 00:36:59',1,NULL,NULL,3,'Subdist D',1),(455,'2022-02-24 00:36:59',1,NULL,NULL,3,'Subdist E',1),(471,'2022-02-24 00:37:08',1,NULL,NULL,4,'Distributor A',1),(472,'2022-02-24 00:37:08',1,NULL,NULL,4,'Distributor B',1),(473,'2022-02-24 00:37:08',1,NULL,NULL,4,'Subdist A',1),(474,'2022-02-24 00:37:08',1,NULL,NULL,4,'Grosir A',1),(475,'2022-02-24 00:37:08',1,NULL,NULL,4,'Motorist A',1),(476,'2022-02-24 00:37:08',1,NULL,NULL,4,'Grosir B',1),(477,'2022-02-24 00:37:08',1,NULL,NULL,4,'Grosir C',1),(478,'2022-02-24 00:37:08',1,NULL,NULL,4,'Subdist B',1),(479,'2022-02-24 00:37:08',1,NULL,NULL,4,'Grosir D',1),(480,'2022-02-24 00:37:08',1,NULL,NULL,4,'Grosir E',1),(481,'2022-02-24 00:37:08',1,NULL,NULL,4,'Grosir F',1),(482,'2022-02-24 00:37:08',1,NULL,NULL,4,'Grosir G',1),(483,'2022-02-24 00:37:08',1,NULL,NULL,4,'Subdist C',1),(484,'2022-02-24 00:37:08',1,NULL,NULL,4,'Subdist D',1),(485,'2022-02-24 00:37:08',1,NULL,NULL,4,'Subdist E',1),(486,'2022-02-24 00:37:13',1,NULL,NULL,5,'Subdist A',1),(487,'2022-02-24 00:37:13',1,NULL,NULL,5,'Subdist B',1),(488,'2022-02-24 00:37:13',1,NULL,NULL,5,'Subdist C',1),(489,'2022-02-24 00:37:13',1,NULL,NULL,5,'Subdist D',1),(490,'2022-02-24 00:37:13',1,NULL,NULL,5,'Subdist E',1),(491,'2022-02-24 00:37:13',1,NULL,NULL,5,'Grosir A',1),(492,'2022-02-24 00:37:13',1,NULL,NULL,5,'Motorist A',1),(493,'2022-02-24 00:37:13',1,NULL,NULL,5,'Grosir B',1),(494,'2022-02-24 00:37:13',1,NULL,NULL,5,'Grosir C',1),(495,'2022-02-24 00:37:13',1,NULL,NULL,5,'Grosir D',1),(496,'2022-02-24 00:37:13',1,NULL,NULL,5,'Grosir E',1),(497,'2022-02-24 00:37:13',1,NULL,NULL,5,'Grosir F',1),(498,'2022-02-24 00:37:13',1,NULL,NULL,5,'Grosir G',1),(499,'2022-02-24 00:37:18',1,NULL,NULL,6,'Subdist A',1),(500,'2022-02-24 00:37:18',1,NULL,NULL,6,'Subdist B',1),(501,'2022-02-24 00:37:18',1,NULL,NULL,6,'Subdist C',1),(502,'2022-02-24 00:37:18',1,NULL,NULL,6,'Subdist D',1),(503,'2022-02-24 00:37:18',1,NULL,NULL,6,'Subdist E',1),(504,'2022-02-24 00:37:18',1,NULL,NULL,6,'Grosir A',1),(505,'2022-02-24 00:37:18',1,NULL,NULL,6,'Motorist A',1),(506,'2022-02-24 00:37:18',1,NULL,NULL,6,'Grosir B',1),(507,'2022-02-24 00:37:18',1,NULL,NULL,6,'Grosir C',1),(508,'2022-02-24 00:37:18',1,NULL,NULL,6,'Grosir D',1),(509,'2022-02-24 00:37:18',1,NULL,NULL,6,'Grosir E',1),(510,'2022-02-24 00:37:18',1,NULL,NULL,6,'Grosir F',1),(511,'2022-02-24 00:37:18',1,NULL,NULL,6,'Grosir G',1),(512,'2022-02-24 00:37:30',1,NULL,NULL,7,'Grosir A',1),(513,'2022-02-24 00:37:30',1,NULL,NULL,7,'Grosir B',1),(514,'2022-02-24 00:37:30',1,NULL,NULL,7,'Grosir C',1),(515,'2022-02-24 00:37:30',1,NULL,NULL,7,'Grosir D',1),(516,'2022-02-24 00:37:30',1,NULL,NULL,7,'Grosir E',1),(517,'2022-02-24 00:37:30',1,NULL,NULL,7,'Grosir F',1),(518,'2022-02-24 00:37:30',1,NULL,NULL,7,'Grosir G',1),(519,'2022-02-24 00:37:30',1,NULL,NULL,7,'Motorist A',1),(520,'2022-02-24 00:37:34',1,NULL,NULL,8,'Grosir A',1),(521,'2022-02-24 00:37:34',1,NULL,NULL,8,'Grosir B',1),(522,'2022-02-24 00:37:34',1,NULL,NULL,8,'Grosir C',1),(523,'2022-02-24 00:37:34',1,NULL,NULL,8,'Grosir D',1),(524,'2022-02-24 00:37:34',1,NULL,NULL,8,'Grosir E',1),(525,'2022-02-24 00:37:34',1,NULL,NULL,8,'Grosir F',1),(526,'2022-02-24 00:37:34',1,NULL,NULL,8,'Grosir G',1),(527,'2022-02-24 00:37:34',1,NULL,NULL,8,'Motorist A',1),(528,'2022-02-24 00:37:39',1,NULL,NULL,9,'Motorist A',1),(529,'2022-02-24 00:37:44',1,NULL,NULL,10,'Motorist A',1),(530,'2022-02-24 00:37:48',1,NULL,NULL,12,'Distributor A',1),(531,'2022-02-24 00:37:48',1,NULL,NULL,12,'Distributor B',1),(532,'2022-02-24 00:37:48',1,NULL,NULL,12,'Subdist A',1),(533,'2022-02-24 00:37:48',1,NULL,NULL,12,'Grosir A',1),(534,'2022-02-24 00:37:48',1,NULL,NULL,12,'Motorist A',1),(535,'2022-02-24 00:37:48',1,NULL,NULL,12,'Grosir B',1),(536,'2022-02-24 00:37:48',1,NULL,NULL,12,'Grosir C',1),(537,'2022-02-24 00:37:48',1,NULL,NULL,12,'Subdist B',1),(538,'2022-02-24 00:37:48',1,NULL,NULL,12,'Grosir D',1),(539,'2022-02-24 00:37:48',1,NULL,NULL,12,'Grosir E',1),(540,'2022-02-24 00:37:48',1,NULL,NULL,12,'Grosir F',1),(541,'2022-02-24 00:37:48',1,NULL,NULL,12,'Grosir G',1),(542,'2022-02-24 00:37:48',1,NULL,NULL,12,'Subdist C',1),(543,'2022-02-24 00:37:48',1,NULL,NULL,12,'Subdist D',1),(544,'2022-02-24 00:37:48',1,NULL,NULL,12,'Subdist E',1),(545,'2022-02-24 00:37:52',1,NULL,NULL,13,'Grosir A',1),(546,'2022-02-24 00:37:52',1,NULL,NULL,13,'Grosir B',1),(547,'2022-02-24 00:37:52',1,NULL,NULL,13,'Grosir C',1),(548,'2022-02-24 00:37:52',1,NULL,NULL,13,'Grosir D',1),(549,'2022-02-24 00:37:52',1,NULL,NULL,13,'Grosir E',1),(550,'2022-02-24 00:37:52',1,NULL,NULL,13,'Grosir F',1),(551,'2022-02-24 00:37:52',1,NULL,NULL,13,'Grosir G',1),(552,'2022-02-24 00:37:52',1,NULL,NULL,13,'Motorist A',1),(553,'2022-02-24 00:37:55',1,NULL,NULL,14,'Grosir A',1),(554,'2022-02-24 00:37:55',1,NULL,NULL,14,'Grosir B',1),(555,'2022-02-24 00:37:55',1,NULL,NULL,14,'Grosir C',1),(556,'2022-02-24 00:37:55',1,NULL,NULL,14,'Grosir D',1),(557,'2022-02-24 00:37:55',1,NULL,NULL,14,'Grosir E',1),(558,'2022-02-24 00:37:55',1,NULL,NULL,14,'Grosir F',1),(559,'2022-02-24 00:37:55',1,NULL,NULL,14,'Grosir G',1),(560,'2022-02-24 00:37:55',1,NULL,NULL,14,'Motorist A',1);
/*!40000 ALTER TABLE `tb_user_market` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=338 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_menu`
--

LOCK TABLES `tb_user_menu` WRITE;
/*!40000 ALTER TABLE `tb_user_menu` DISABLE KEYS */;
INSERT INTO `tb_user_menu` VALUES (1,'2022-02-14 15:18:30',0,NULL,NULL,1,1,1,1,1,1),(2,'2022-02-14 15:18:30',0,NULL,NULL,1,2,1,1,1,1),(3,'2022-02-14 15:18:30',0,NULL,NULL,1,3,1,1,1,1),(4,'2022-02-14 15:18:30',0,NULL,NULL,1,4,1,1,1,1),(5,'2022-02-14 15:18:30',0,NULL,NULL,1,5,1,1,1,1),(6,'2022-02-14 15:18:30',0,NULL,NULL,1,6,1,1,1,1),(7,'2022-02-14 15:18:30',0,NULL,NULL,1,7,1,1,1,1),(247,'2022-02-24 00:36:55',1,NULL,NULL,2,4,1,1,1,1),(248,'2022-02-24 00:36:55',1,NULL,NULL,2,7,1,1,1,1),(249,'2022-02-24 00:36:55',1,NULL,NULL,2,2,1,1,1,1),(250,'2022-02-24 00:36:55',1,NULL,NULL,2,3,1,1,1,1),(251,'2022-02-24 00:36:55',1,NULL,NULL,2,1,1,1,1,1),(252,'2022-02-24 00:36:55',1,NULL,NULL,2,5,1,1,1,1),(253,'2022-02-24 00:36:55',1,NULL,NULL,2,6,1,1,1,0),(254,'2022-02-24 00:36:59',1,NULL,NULL,3,4,1,1,1,1),(255,'2022-02-24 00:36:59',1,NULL,NULL,3,7,1,1,1,0),(256,'2022-02-24 00:36:59',1,NULL,NULL,3,2,1,1,1,1),(257,'2022-02-24 00:36:59',1,NULL,NULL,3,3,1,1,1,1),(258,'2022-02-24 00:36:59',1,NULL,NULL,3,1,1,1,1,1),(259,'2022-02-24 00:36:59',1,NULL,NULL,3,5,1,1,1,1),(260,'2022-02-24 00:36:59',1,NULL,NULL,3,6,1,1,1,0),(268,'2022-02-24 00:37:08',1,NULL,NULL,4,4,1,1,1,1),(269,'2022-02-24 00:37:08',1,NULL,NULL,4,7,1,1,1,0),(270,'2022-02-24 00:37:08',1,NULL,NULL,4,2,1,1,1,1),(271,'2022-02-24 00:37:08',1,NULL,NULL,4,3,1,1,1,1),(272,'2022-02-24 00:37:08',1,NULL,NULL,4,1,1,1,1,1),(273,'2022-02-24 00:37:08',1,NULL,NULL,4,5,1,1,1,1),(274,'2022-02-24 00:37:08',1,NULL,NULL,4,6,1,1,1,0),(275,'2022-02-24 00:37:13',1,NULL,NULL,5,4,1,1,1,1),(276,'2022-02-24 00:37:13',1,NULL,NULL,5,7,1,1,1,0),(277,'2022-02-24 00:37:13',1,NULL,NULL,5,2,1,1,1,1),(278,'2022-02-24 00:37:13',1,NULL,NULL,5,3,1,1,1,1),(279,'2022-02-24 00:37:13',1,NULL,NULL,5,1,1,1,1,0),(280,'2022-02-24 00:37:13',1,NULL,NULL,5,5,1,1,1,1),(281,'2022-02-24 00:37:13',1,NULL,NULL,5,6,1,1,1,0),(282,'2022-02-24 00:37:18',1,NULL,NULL,6,4,1,1,1,1),(283,'2022-02-24 00:37:18',1,NULL,NULL,6,7,1,1,1,0),(284,'2022-02-24 00:37:18',1,NULL,NULL,6,2,1,1,1,1),(285,'2022-02-24 00:37:18',1,NULL,NULL,6,3,1,1,1,1),(286,'2022-02-24 00:37:18',1,NULL,NULL,6,1,1,1,1,0),(287,'2022-02-24 00:37:18',1,NULL,NULL,6,5,1,1,1,1),(288,'2022-02-24 00:37:18',1,NULL,NULL,6,6,1,1,1,0),(289,'2022-02-24 00:37:30',1,NULL,NULL,7,4,1,1,1,1),(290,'2022-02-24 00:37:30',1,NULL,NULL,7,7,1,1,1,0),(291,'2022-02-24 00:37:30',1,NULL,NULL,7,2,1,1,1,0),(292,'2022-02-24 00:37:30',1,NULL,NULL,7,3,1,1,1,1),(293,'2022-02-24 00:37:30',1,NULL,NULL,7,1,1,1,1,0),(294,'2022-02-24 00:37:30',1,NULL,NULL,7,5,1,1,1,1),(295,'2022-02-24 00:37:30',1,NULL,NULL,7,6,1,1,1,0),(296,'2022-02-24 00:37:34',1,NULL,NULL,8,4,1,1,1,1),(297,'2022-02-24 00:37:34',1,NULL,NULL,8,7,1,1,1,0),(298,'2022-02-24 00:37:34',1,NULL,NULL,8,2,1,1,1,0),(299,'2022-02-24 00:37:34',1,NULL,NULL,8,3,1,1,1,1),(300,'2022-02-24 00:37:34',1,NULL,NULL,8,1,1,1,1,0),(301,'2022-02-24 00:37:34',1,NULL,NULL,8,5,1,1,1,1),(302,'2022-02-24 00:37:34',1,NULL,NULL,8,6,1,1,1,0),(303,'2022-02-24 00:37:39',1,NULL,NULL,9,4,1,1,1,0),(304,'2022-02-24 00:37:39',1,NULL,NULL,9,7,1,1,1,0),(305,'2022-02-24 00:37:39',1,NULL,NULL,9,2,1,1,1,1),(306,'2022-02-24 00:37:39',1,NULL,NULL,9,3,1,1,1,0),(307,'2022-02-24 00:37:39',1,NULL,NULL,9,1,1,1,1,0),(308,'2022-02-24 00:37:39',1,NULL,NULL,9,5,1,1,1,1),(309,'2022-02-24 00:37:39',1,NULL,NULL,9,6,1,1,1,0),(310,'2022-02-24 00:37:44',1,NULL,NULL,10,4,1,1,1,0),(311,'2022-02-24 00:37:44',1,NULL,NULL,10,7,1,1,1,0),(312,'2022-02-24 00:37:44',1,NULL,NULL,10,2,1,1,1,1),(313,'2022-02-24 00:37:44',1,NULL,NULL,10,3,1,1,1,0),(314,'2022-02-24 00:37:44',1,NULL,NULL,10,1,1,1,1,0),(315,'2022-02-24 00:37:44',1,NULL,NULL,10,5,1,1,1,1),(316,'2022-02-24 00:37:44',1,NULL,NULL,10,6,1,1,1,0),(317,'2022-02-24 00:37:48',1,NULL,NULL,12,4,0,0,0,1),(318,'2022-02-24 00:37:48',1,NULL,NULL,12,7,0,0,0,0),(319,'2022-02-24 00:37:48',1,NULL,NULL,12,2,0,0,0,1),(320,'2022-02-24 00:37:48',1,NULL,NULL,12,3,0,0,0,1),(321,'2022-02-24 00:37:48',1,NULL,NULL,12,1,0,0,0,1),(322,'2022-02-24 00:37:48',1,NULL,NULL,12,5,0,0,0,1),(323,'2022-02-24 00:37:48',1,NULL,NULL,12,6,0,0,0,0),(324,'2022-02-24 00:37:52',1,NULL,NULL,13,4,0,0,0,1),(325,'2022-02-24 00:37:52',1,NULL,NULL,13,7,0,0,0,0),(326,'2022-02-24 00:37:52',1,NULL,NULL,13,2,0,0,0,0),(327,'2022-02-24 00:37:52',1,NULL,NULL,13,3,0,0,0,1),(328,'2022-02-24 00:37:52',1,NULL,NULL,13,1,0,0,0,0),(329,'2022-02-24 00:37:52',1,NULL,NULL,13,5,0,0,0,1),(330,'2022-02-24 00:37:52',1,NULL,NULL,13,6,0,0,0,0),(331,'2022-02-24 00:37:55',1,NULL,NULL,14,4,0,0,0,1),(332,'2022-02-24 00:37:55',1,NULL,NULL,14,7,0,0,0,0),(333,'2022-02-24 00:37:55',1,NULL,NULL,14,2,0,0,0,0),(334,'2022-02-24 00:37:55',1,NULL,NULL,14,3,0,0,0,1),(335,'2022-02-24 00:37:55',1,NULL,NULL,14,1,0,0,0,0),(336,'2022-02-24 00:37:55',1,NULL,NULL,14,5,0,0,0,1),(337,'2022-02-24 00:37:55',1,NULL,NULL,14,6,0,0,0,0);
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
  `tbum_view` tinyint NOT NULL,
  `tbm_sort` tinyint NOT NULL
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
/*!50001 VIEW `view_user_menu` AS select uuid() AS `uuid`,`tbu`.`tbu_id` AS `tbu_id`,`tbu`.`tbu_email` AS `tbu_email`,`tbu`.`tbu_firstname` AS `tbu_firstname`,`tbu`.`tbu_lastname` AS `tbu_lastname`,`tbm`.`tbm_id` AS `tbm_id`,`tbm`.`tbm_name` AS `tbm_name`,`tbum`.`tbum_add` AS `tbum_add`,`tbum`.`tbum_edit` AS `tbum_edit`,`tbum`.`tbum_delete` AS `tbum_delete`,`tbum`.`tbum_view` AS `tbum_view`,`tbm`.`tbm_sort` AS `tbm_sort` from ((`tb_user` `tbu` join `tb_user_menu` `tbum` on(`tbu`.`tbu_id` = `tbum`.`tbu_id`)) join `tb_menu` `tbm` on(`tbum`.`tbm_id` = `tbm`.`tbm_id`)) */;
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

-- Dump completed on 2022-02-24  7:43:46
