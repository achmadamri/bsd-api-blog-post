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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_menu`
--

LOCK TABLES `tb_menu` WRITE;
/*!40000 ALTER TABLE `tb_menu` DISABLE KEYS */;
INSERT INTO `tb_menu` VALUES (1,'2021-07-31 15:26:21',0,NULL,NULL,'Product'),(2,'2021-07-31 15:26:21',0,NULL,NULL,'Order'),(3,'2021-07-31 15:26:21',0,NULL,NULL,'Packing'),(4,'2021-07-31 15:26:21',0,NULL,NULL,'Confirm'),(5,'2021-07-31 15:26:21',0,NULL,NULL,'Report'),(6,'2021-07-31 15:26:21',0,NULL,NULL,'User'),(7,'2021-07-31 15:26:21',0,NULL,NULL,'Market');
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
INSERT INTO `tb_user` VALUES (1,NULL,NULL,NULL,NULL,'admin@mail.com','202cb962ac59075b964b07152d234b70','admin','admin',NULL,NULL,NULL,'active',NULL,NULL,'jnsr8q8t7dzgqv8qqmkfsffc5mqdn5fec4af','ADMIN'),(2,NULL,NULL,NULL,NULL,'pic1@mail.com','202cb962ac59075b964b07152d234b70','pic','one',NULL,NULL,NULL,'active',NULL,NULL,'ng843n6ocg719kklqklb5814t9n2ahilj9zv','PRINCIPAL'),(3,NULL,NULL,NULL,NULL,'pic2@mail.com','202cb962ac59075b964b07152d234b70','pic','two',NULL,NULL,NULL,'active',NULL,NULL,'b3n95p03tsdpm9fya84cnelibj9u34xffz6j','DISTRIBUTOR'),(4,NULL,NULL,NULL,NULL,'pic3@mail.com','202cb962ac59075b964b07152d234b70','pic','three',NULL,NULL,NULL,'active',NULL,NULL,'zxfxjhji09xdf66s3usg6ro49l76ckrcmhyl','DISTRIBUTOR'),(5,NULL,NULL,NULL,NULL,'pic4@mail.com','202cb962ac59075b964b07152d234b70','pic','four',NULL,NULL,NULL,'active',NULL,NULL,'ni5ju0wgw0l4x3gxoq0cgh3jn3lyvejl5aq8','SUBDIST'),(6,NULL,NULL,NULL,NULL,'pic6@mail.com','202cb962ac59075b964b07152d234b70','pic','six',NULL,NULL,NULL,'active',NULL,NULL,'onlidhsdmmgz9k8gxzq2dfazrhshyx9zv53p','SUBDIST'),(7,NULL,NULL,NULL,NULL,'pic7@mail.com','202cb962ac59075b964b07152d234b70','pic','seven',NULL,NULL,NULL,'active',NULL,NULL,'it1wq7s6txkfcl6xw2iji0dmebrmc7b41mtv','GROSIR'),(8,NULL,NULL,NULL,NULL,'pic8@mail.com','202cb962ac59075b964b07152d234b70','pic','eight',NULL,NULL,NULL,'active',NULL,NULL,'macc9yxlcnfjqix254tmbf0h4459a9w22xfi','GROSIR'),(9,NULL,NULL,NULL,NULL,'pic9@mail.com','202cb962ac59075b964b07152d234b70','pic','nine',NULL,NULL,NULL,'active',NULL,NULL,'jayf1yr5fd07mshu2c4a29ih8li17beubiwc','MOTORIST'),(10,NULL,NULL,NULL,NULL,'pic10@mail.com','202cb962ac59075b964b07152d234b70','pic','ten',NULL,NULL,NULL,'active',NULL,NULL,'i8m95htaivk0u5mcjfy3ioo0k9zxxf8lpp5h','MOTORIST'),(12,'2022-02-14 11:18:06',1,NULL,NULL,'pic11@mail.com','202cb962ac59075b964b07152d234b70','pic','eleven',NULL,NULL,NULL,'active',NULL,NULL,'lk9i5cv2dm5bnyz07apzo3wirxodwfhhxf85','DISTRIBUTOR'),(13,'2022-02-14 11:19:22',1,'2022-02-16 09:13:56',1,'pic12@mail.com','202cb962ac59075b964b07152d234b70','pic','twelve',NULL,NULL,NULL,'active',NULL,NULL,'uzf4niy96076mn4crvfsalm9r06uoey2spjj','GROSIR'),(14,'2022-02-16 07:42:38',1,'2022-02-16 09:12:53',1,'pic13@mail.com','202cb962ac59075b964b07152d234b70','pic','thirteen',NULL,NULL,NULL,'active',NULL,NULL,'oka59r3uxjbqi7pfwpv2kbiyf1tuxedqvam6','GROSIR');
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
) ENGINE=InnoDB AUTO_INCREMENT=472 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_brand`
--

LOCK TABLES `tb_user_brand` WRITE;
/*!40000 ALTER TABLE `tb_user_brand` DISABLE KEYS */;
INSERT INTO `tb_user_brand` VALUES (1,'2022-02-15 11:45:45',0,NULL,NULL,1,'Innisfree','INNIS',1),(2,'2022-02-15 11:45:45',0,NULL,NULL,1,'Laneige','LANEI',1),(3,'2022-02-15 11:45:45',0,NULL,NULL,1,'Mamonde','MAMON',1),(4,'2022-02-15 11:45:45',0,NULL,NULL,1,'Cetaphil','CETAP',1),(5,'2022-02-15 11:45:45',0,NULL,NULL,1,'Anessa','ANESS',1),(6,'2022-02-15 11:45:45',0,NULL,NULL,1,'Mustela','MUSTE',1),(7,'2022-02-15 11:45:45',0,NULL,NULL,1,'Interbat','INTER',1),(8,'2022-02-15 11:45:45',0,NULL,NULL,1,'Nestle','NESTL',1),(9,'2022-02-15 11:45:45',0,NULL,NULL,1,'Nutrition','NUTRI',1),(10,'2022-02-15 11:45:45',0,NULL,NULL,1,'Purina','PURIN',1),(11,'2022-02-15 11:45:45',0,NULL,NULL,1,'Mentos','MENTO',1),(12,'2022-02-15 11:45:45',0,NULL,NULL,1,'P&G Health','PNGHE',1),(13,'2022-02-15 11:45:45',0,NULL,NULL,1,'Combiphar','COMBH',1),(14,'2022-02-15 11:45:45',0,NULL,NULL,1,'BEBE','BEBEB',1),(15,'2022-02-15 11:45:45',0,NULL,NULL,1,'Pillowpeople','PILLO',1),(16,'2022-02-15 11:45:45',0,NULL,NULL,1,'Sulwhasoo','SULWH',1),(17,'2022-02-15 11:45:45',0,NULL,NULL,1,'cocacola','COCAC',1),(18,'2022-02-15 11:45:45',0,NULL,NULL,1,'Mecard','MECAR',1),(19,'2022-02-15 11:45:45',0,NULL,NULL,2,'Innisfree','INNIS',1),(20,'2022-02-15 11:45:45',0,NULL,NULL,2,'Laneige','LANEI',1),(21,'2022-02-15 11:45:45',0,NULL,NULL,2,'Mamonde','MAMON',1),(22,'2022-02-15 11:45:45',0,NULL,NULL,2,'Cetaphil','CETAP',1),(23,'2022-02-15 11:45:45',0,NULL,NULL,2,'Anessa','ANESS',1),(24,'2022-02-15 11:45:45',0,NULL,NULL,2,'Mustela','MUSTE',1),(25,'2022-02-15 11:45:45',0,NULL,NULL,2,'Interbat','INTER',1),(26,'2022-02-15 11:45:45',0,NULL,NULL,2,'Nestle','NESTL',1),(27,'2022-02-15 11:45:45',0,NULL,NULL,2,'Nutrition','NUTRI',1),(28,'2022-02-15 11:45:45',0,NULL,NULL,2,'Purina','PURIN',1),(29,'2022-02-15 11:45:45',0,NULL,NULL,2,'Mentos','MENTO',1),(30,'2022-02-15 11:45:45',0,NULL,NULL,2,'P&G Health','PNGHE',1),(31,'2022-02-15 11:45:45',0,NULL,NULL,2,'Combiphar','COMBH',1),(32,'2022-02-15 11:45:45',0,NULL,NULL,2,'BEBE','BEBEB',1),(33,'2022-02-15 11:45:45',0,NULL,NULL,2,'Pillowpeople','PILLO',1),(34,'2022-02-15 11:45:45',0,NULL,NULL,2,'Sulwhasoo','SULWH',1),(35,'2022-02-15 11:45:45',0,NULL,NULL,2,'cocacola','COCAC',1),(36,'2022-02-15 11:45:45',0,NULL,NULL,2,'Mecard','MECAR',1),(37,'2022-02-15 11:45:45',0,NULL,NULL,3,'Innisfree','INNIS',1),(38,'2022-02-15 11:45:45',0,NULL,NULL,3,'Laneige','LANEI',1),(39,'2022-02-15 11:45:45',0,NULL,NULL,3,'Mamonde','MAMON',1),(40,'2022-02-15 11:45:45',0,NULL,NULL,3,'Cetaphil','CETAP',1),(41,'2022-02-15 11:45:45',0,NULL,NULL,3,'Anessa','ANESS',1),(42,'2022-02-15 11:45:45',0,NULL,NULL,3,'Mustela','MUSTE',1),(43,'2022-02-15 11:45:45',0,NULL,NULL,3,'Interbat','INTER',1),(44,'2022-02-15 11:45:45',0,NULL,NULL,3,'Nestle','NESTL',1),(45,'2022-02-15 11:45:45',0,NULL,NULL,3,'Nutrition','NUTRI',1),(46,'2022-02-15 11:45:45',0,NULL,NULL,3,'Purina','PURIN',1),(47,'2022-02-15 11:45:45',0,NULL,NULL,3,'Mentos','MENTO',1),(48,'2022-02-15 11:45:45',0,NULL,NULL,3,'P&G Health','PNGHE',1),(49,'2022-02-15 11:45:45',0,NULL,NULL,3,'Combiphar','COMBH',1),(50,'2022-02-15 11:45:45',0,NULL,NULL,3,'BEBE','BEBEB',1),(51,'2022-02-15 11:45:45',0,NULL,NULL,3,'Pillowpeople','PILLO',1),(52,'2022-02-15 11:45:45',0,NULL,NULL,3,'Sulwhasoo','SULWH',1),(53,'2022-02-15 11:45:45',0,NULL,NULL,3,'cocacola','COCAC',1),(54,'2022-02-15 11:45:45',0,NULL,NULL,3,'Mecard','MECAR',1),(55,'2022-02-15 11:45:45',0,NULL,NULL,4,'Innisfree','INNIS',1),(56,'2022-02-15 11:45:45',0,NULL,NULL,4,'Laneige','LANEI',1),(57,'2022-02-15 11:45:45',0,NULL,NULL,4,'Mamonde','MAMON',1),(58,'2022-02-15 11:45:45',0,NULL,NULL,4,'Cetaphil','CETAP',1),(59,'2022-02-15 11:45:45',0,NULL,NULL,4,'Anessa','ANESS',1),(60,'2022-02-15 11:45:45',0,NULL,NULL,4,'Mustela','MUSTE',1),(61,'2022-02-15 11:45:45',0,NULL,NULL,4,'Interbat','INTER',1),(62,'2022-02-15 11:45:45',0,NULL,NULL,4,'Nestle','NESTL',1),(63,'2022-02-15 11:45:45',0,NULL,NULL,4,'Nutrition','NUTRI',1),(64,'2022-02-15 11:45:45',0,NULL,NULL,4,'Purina','PURIN',1),(65,'2022-02-15 11:45:45',0,NULL,NULL,4,'Mentos','MENTO',1),(66,'2022-02-15 11:45:45',0,NULL,NULL,4,'P&G Health','PNGHE',1),(67,'2022-02-15 11:45:45',0,NULL,NULL,4,'Combiphar','COMBH',1),(68,'2022-02-15 11:45:45',0,NULL,NULL,4,'BEBE','BEBEB',1),(69,'2022-02-15 11:45:45',0,NULL,NULL,4,'Pillowpeople','PILLO',1),(70,'2022-02-15 11:45:45',0,NULL,NULL,4,'Sulwhasoo','SULWH',1),(71,'2022-02-15 11:45:45',0,NULL,NULL,4,'cocacola','COCAC',1),(72,'2022-02-15 11:45:45',0,NULL,NULL,4,'Mecard','MECAR',1),(73,'2022-02-15 11:45:45',0,NULL,NULL,5,'Innisfree','INNIS',1),(74,'2022-02-15 11:45:45',0,NULL,NULL,5,'Laneige','LANEI',1),(75,'2022-02-15 11:45:45',0,NULL,NULL,5,'Mamonde','MAMON',1),(76,'2022-02-15 11:45:45',0,NULL,NULL,5,'Cetaphil','CETAP',1),(77,'2022-02-15 11:45:45',0,NULL,NULL,5,'Anessa','ANESS',1),(78,'2022-02-15 11:45:45',0,NULL,NULL,5,'Mustela','MUSTE',1),(79,'2022-02-15 11:45:45',0,NULL,NULL,5,'Interbat','INTER',1),(80,'2022-02-15 11:45:45',0,NULL,NULL,5,'Nestle','NESTL',1),(81,'2022-02-15 11:45:45',0,NULL,NULL,5,'Nutrition','NUTRI',1),(82,'2022-02-15 11:45:45',0,NULL,NULL,5,'Purina','PURIN',1),(83,'2022-02-15 11:45:45',0,NULL,NULL,5,'Mentos','MENTO',1),(84,'2022-02-15 11:45:45',0,NULL,NULL,5,'P&G Health','PNGHE',1),(85,'2022-02-15 11:45:45',0,NULL,NULL,5,'Combiphar','COMBH',1),(86,'2022-02-15 11:45:45',0,NULL,NULL,5,'BEBE','BEBEB',1),(87,'2022-02-15 11:45:45',0,NULL,NULL,5,'Pillowpeople','PILLO',1),(88,'2022-02-15 11:45:45',0,NULL,NULL,5,'Sulwhasoo','SULWH',1),(89,'2022-02-15 11:45:45',0,NULL,NULL,5,'cocacola','COCAC',1),(90,'2022-02-15 11:45:45',0,NULL,NULL,5,'Mecard','MECAR',1),(91,'2022-02-15 11:45:45',0,NULL,NULL,6,'Innisfree','INNIS',1),(92,'2022-02-15 11:45:45',0,NULL,NULL,6,'Laneige','LANEI',1),(93,'2022-02-15 11:45:45',0,NULL,NULL,6,'Mamonde','MAMON',1),(94,'2022-02-15 11:45:45',0,NULL,NULL,6,'Cetaphil','CETAP',1),(95,'2022-02-15 11:45:45',0,NULL,NULL,6,'Anessa','ANESS',1),(96,'2022-02-15 11:45:45',0,NULL,NULL,6,'Mustela','MUSTE',1),(97,'2022-02-15 11:45:45',0,NULL,NULL,6,'Interbat','INTER',1),(98,'2022-02-15 11:45:45',0,NULL,NULL,6,'Nestle','NESTL',1),(99,'2022-02-15 11:45:45',0,NULL,NULL,6,'Nutrition','NUTRI',1),(100,'2022-02-15 11:45:45',0,NULL,NULL,6,'Purina','PURIN',1),(101,'2022-02-15 11:45:45',0,NULL,NULL,6,'Mentos','MENTO',1),(102,'2022-02-15 11:45:45',0,NULL,NULL,6,'P&G Health','PNGHE',1),(103,'2022-02-15 11:45:45',0,NULL,NULL,6,'Combiphar','COMBH',1),(104,'2022-02-15 11:45:45',0,NULL,NULL,6,'BEBE','BEBEB',1),(105,'2022-02-15 11:45:45',0,NULL,NULL,6,'Pillowpeople','PILLO',1),(106,'2022-02-15 11:45:45',0,NULL,NULL,6,'Sulwhasoo','SULWH',1),(107,'2022-02-15 11:45:45',0,NULL,NULL,6,'cocacola','COCAC',1),(108,'2022-02-15 11:45:45',0,NULL,NULL,6,'Mecard','MECAR',1),(109,'2022-02-15 11:45:45',0,NULL,NULL,7,'Innisfree','INNIS',1),(110,'2022-02-15 11:45:45',0,NULL,NULL,7,'Laneige','LANEI',1),(111,'2022-02-15 11:45:45',0,NULL,NULL,7,'Mamonde','MAMON',1),(112,'2022-02-15 11:45:45',0,NULL,NULL,7,'Cetaphil','CETAP',1),(113,'2022-02-15 11:45:45',0,NULL,NULL,7,'Anessa','ANESS',1),(114,'2022-02-15 11:45:45',0,NULL,NULL,7,'Mustela','MUSTE',1),(115,'2022-02-15 11:45:45',0,NULL,NULL,7,'Interbat','INTER',1),(116,'2022-02-15 11:45:45',0,NULL,NULL,7,'Nestle','NESTL',1),(117,'2022-02-15 11:45:45',0,NULL,NULL,7,'Nutrition','NUTRI',1),(118,'2022-02-15 11:45:45',0,NULL,NULL,7,'Purina','PURIN',1),(119,'2022-02-15 11:45:45',0,NULL,NULL,7,'Mentos','MENTO',1),(120,'2022-02-15 11:45:45',0,NULL,NULL,7,'P&G Health','PNGHE',1),(121,'2022-02-15 11:45:45',0,NULL,NULL,7,'Combiphar','COMBH',1),(122,'2022-02-15 11:45:45',0,NULL,NULL,7,'BEBE','BEBEB',1),(123,'2022-02-15 11:45:45',0,NULL,NULL,7,'Pillowpeople','PILLO',1),(124,'2022-02-15 11:45:45',0,NULL,NULL,7,'Sulwhasoo','SULWH',1),(125,'2022-02-15 11:45:45',0,NULL,NULL,7,'cocacola','COCAC',1),(126,'2022-02-15 11:45:45',0,NULL,NULL,7,'Mecard','MECAR',1),(127,'2022-02-15 11:45:45',0,NULL,NULL,8,'Innisfree','INNIS',1),(128,'2022-02-15 11:45:45',0,NULL,NULL,8,'Laneige','LANEI',1),(129,'2022-02-15 11:45:45',0,NULL,NULL,8,'Mamonde','MAMON',1),(130,'2022-02-15 11:45:45',0,NULL,NULL,8,'Cetaphil','CETAP',1),(131,'2022-02-15 11:45:45',0,NULL,NULL,8,'Anessa','ANESS',1),(132,'2022-02-15 11:45:45',0,NULL,NULL,8,'Mustela','MUSTE',1),(133,'2022-02-15 11:45:45',0,NULL,NULL,8,'Interbat','INTER',1),(134,'2022-02-15 11:45:45',0,NULL,NULL,8,'Nestle','NESTL',1),(135,'2022-02-15 11:45:45',0,NULL,NULL,8,'Nutrition','NUTRI',1),(136,'2022-02-15 11:45:45',0,NULL,NULL,8,'Purina','PURIN',1),(137,'2022-02-15 11:45:45',0,NULL,NULL,8,'Mentos','MENTO',1),(138,'2022-02-15 11:45:45',0,NULL,NULL,8,'P&G Health','PNGHE',1),(139,'2022-02-15 11:45:45',0,NULL,NULL,8,'Combiphar','COMBH',1),(140,'2022-02-15 11:45:45',0,NULL,NULL,8,'BEBE','BEBEB',1),(141,'2022-02-15 11:45:45',0,NULL,NULL,8,'Pillowpeople','PILLO',1),(142,'2022-02-15 11:45:45',0,NULL,NULL,8,'Sulwhasoo','SULWH',1),(143,'2022-02-15 11:45:45',0,NULL,NULL,8,'cocacola','COCAC',1),(144,'2022-02-15 11:45:45',0,NULL,NULL,8,'Mecard','MECAR',1),(145,'2022-02-15 11:45:45',0,NULL,NULL,9,'Innisfree','INNIS',1),(146,'2022-02-15 11:45:45',0,NULL,NULL,9,'Laneige','LANEI',1),(147,'2022-02-15 11:45:45',0,NULL,NULL,9,'Mamonde','MAMON',1),(148,'2022-02-15 11:45:45',0,NULL,NULL,9,'Cetaphil','CETAP',1),(149,'2022-02-15 11:45:45',0,NULL,NULL,9,'Anessa','ANESS',1),(150,'2022-02-15 11:45:45',0,NULL,NULL,9,'Mustela','MUSTE',1),(151,'2022-02-15 11:45:45',0,NULL,NULL,9,'Interbat','INTER',1),(152,'2022-02-15 11:45:45',0,NULL,NULL,9,'Nestle','NESTL',1),(153,'2022-02-15 11:45:45',0,NULL,NULL,9,'Nutrition','NUTRI',1),(154,'2022-02-15 11:45:45',0,NULL,NULL,9,'Purina','PURIN',1),(155,'2022-02-15 11:45:45',0,NULL,NULL,9,'Mentos','MENTO',1),(156,'2022-02-15 11:45:45',0,NULL,NULL,9,'P&G Health','PNGHE',1),(157,'2022-02-15 11:45:45',0,NULL,NULL,9,'Combiphar','COMBH',1),(158,'2022-02-15 11:45:45',0,NULL,NULL,9,'BEBE','BEBEB',1),(159,'2022-02-15 11:45:45',0,NULL,NULL,9,'Pillowpeople','PILLO',1),(160,'2022-02-15 11:45:45',0,NULL,NULL,9,'Sulwhasoo','SULWH',1),(161,'2022-02-15 11:45:45',0,NULL,NULL,9,'cocacola','COCAC',1),(162,'2022-02-15 11:45:45',0,NULL,NULL,9,'Mecard','MECAR',1),(163,'2022-02-15 11:45:45',0,NULL,NULL,10,'Innisfree','INNIS',1),(164,'2022-02-15 11:45:45',0,NULL,NULL,10,'Laneige','LANEI',1),(165,'2022-02-15 11:45:45',0,NULL,NULL,10,'Mamonde','MAMON',1),(166,'2022-02-15 11:45:45',0,NULL,NULL,10,'Cetaphil','CETAP',1),(167,'2022-02-15 11:45:45',0,NULL,NULL,10,'Anessa','ANESS',1),(168,'2022-02-15 11:45:45',0,NULL,NULL,10,'Mustela','MUSTE',1),(169,'2022-02-15 11:45:45',0,NULL,NULL,10,'Interbat','INTER',1),(170,'2022-02-15 11:45:45',0,NULL,NULL,10,'Nestle','NESTL',1),(171,'2022-02-15 11:45:45',0,NULL,NULL,10,'Nutrition','NUTRI',1),(172,'2022-02-15 11:45:45',0,NULL,NULL,10,'Purina','PURIN',1),(173,'2022-02-15 11:45:45',0,NULL,NULL,10,'Mentos','MENTO',1),(174,'2022-02-15 11:45:45',0,NULL,NULL,10,'P&G Health','PNGHE',1),(175,'2022-02-15 11:45:45',0,NULL,NULL,10,'Combiphar','COMBH',1),(176,'2022-02-15 11:45:45',0,NULL,NULL,10,'BEBE','BEBEB',1),(177,'2022-02-15 11:45:45',0,NULL,NULL,10,'Pillowpeople','PILLO',1),(178,'2022-02-15 11:45:45',0,NULL,NULL,10,'Sulwhasoo','SULWH',1),(179,'2022-02-15 11:45:45',0,NULL,NULL,10,'cocacola','COCAC',1),(180,'2022-02-15 11:45:45',0,NULL,NULL,10,'Mecard','MECAR',1),(181,'2022-02-15 11:45:45',0,NULL,NULL,12,'Innisfree','INNIS',1),(182,'2022-02-15 11:45:45',0,NULL,NULL,12,'Laneige','LANEI',1),(183,'2022-02-15 11:45:45',0,NULL,NULL,12,'Mamonde','MAMON',1),(184,'2022-02-15 11:45:45',0,NULL,NULL,12,'Cetaphil','CETAP',1),(185,'2022-02-15 11:45:45',0,NULL,NULL,12,'Anessa','ANESS',1),(186,'2022-02-15 11:45:45',0,NULL,NULL,12,'Mustela','MUSTE',1),(187,'2022-02-15 11:45:45',0,NULL,NULL,12,'Interbat','INTER',1),(188,'2022-02-15 11:45:45',0,NULL,NULL,12,'Nestle','NESTL',1),(189,'2022-02-15 11:45:45',0,NULL,NULL,12,'Nutrition','NUTRI',1),(190,'2022-02-15 11:45:45',0,NULL,NULL,12,'Purina','PURIN',1),(191,'2022-02-15 11:45:45',0,NULL,NULL,12,'Mentos','MENTO',1),(192,'2022-02-15 11:45:45',0,NULL,NULL,12,'P&G Health','PNGHE',1),(193,'2022-02-15 11:45:45',0,NULL,NULL,12,'Combiphar','COMBH',1),(194,'2022-02-15 11:45:45',0,NULL,NULL,12,'BEBE','BEBEB',1),(195,'2022-02-15 11:45:45',0,NULL,NULL,12,'Pillowpeople','PILLO',1),(196,'2022-02-15 11:45:45',0,NULL,NULL,12,'Sulwhasoo','SULWH',1),(197,'2022-02-15 11:45:45',0,NULL,NULL,12,'cocacola','COCAC',1),(198,'2022-02-15 11:45:45',0,NULL,NULL,12,'Mecard','MECAR',1),(436,'2022-02-16 09:12:53',1,NULL,NULL,14,'Anessa','ANESS',1),(437,'2022-02-16 09:12:53',1,NULL,NULL,14,'BEBE','BEBEB',1),(438,'2022-02-16 09:12:53',1,NULL,NULL,14,'Cetaphil','CETAP',1),(439,'2022-02-16 09:12:53',1,NULL,NULL,14,'cocacola','COCAC',1),(440,'2022-02-16 09:12:53',1,NULL,NULL,14,'Combiphar','COMBH',1),(441,'2022-02-16 09:12:53',1,NULL,NULL,14,'Innisfree','INNIS',1),(442,'2022-02-16 09:12:53',1,NULL,NULL,14,'Interbat','INTER',1),(443,'2022-02-16 09:12:53',1,NULL,NULL,14,'Laneige','LANEI',1),(444,'2022-02-16 09:12:53',1,NULL,NULL,14,'Mamonde','MAMON',1),(445,'2022-02-16 09:12:53',1,NULL,NULL,14,'Mecard','MECAR',1),(446,'2022-02-16 09:12:53',1,NULL,NULL,14,'Mentos','MENTO',1),(447,'2022-02-16 09:12:53',1,NULL,NULL,14,'Mustela','MUSTE',1),(448,'2022-02-16 09:12:53',1,NULL,NULL,14,'Nestle','NESTL',1),(449,'2022-02-16 09:12:53',1,NULL,NULL,14,'Nutrition','NUTRI',1),(450,'2022-02-16 09:12:53',1,NULL,NULL,14,'P&G Health','PNGHE',1),(451,'2022-02-16 09:12:53',1,NULL,NULL,14,'Pillowpeople','PILLO',1),(452,'2022-02-16 09:12:53',1,NULL,NULL,14,'Purina','PURIN',1),(453,'2022-02-16 09:12:53',1,NULL,NULL,14,'Sulwhasoo','SULWH',1),(454,'2022-02-16 09:13:56',1,NULL,NULL,13,'Anessa','ANESS',1),(455,'2022-02-16 09:13:56',1,NULL,NULL,13,'BEBE','BEBEB',1),(456,'2022-02-16 09:13:56',1,NULL,NULL,13,'Cetaphil','CETAP',1),(457,'2022-02-16 09:13:56',1,NULL,NULL,13,'cocacola','COCAC',1),(458,'2022-02-16 09:13:56',1,NULL,NULL,13,'Combiphar','COMBH',1),(459,'2022-02-16 09:13:56',1,NULL,NULL,13,'Innisfree','INNIS',1),(460,'2022-02-16 09:13:56',1,NULL,NULL,13,'Interbat','INTER',1),(461,'2022-02-16 09:13:56',1,NULL,NULL,13,'Laneige','LANEI',1),(462,'2022-02-16 09:13:56',1,NULL,NULL,13,'Mamonde','MAMON',1),(463,'2022-02-16 09:13:56',1,NULL,NULL,13,'Mecard','MECAR',1),(464,'2022-02-16 09:13:56',1,NULL,NULL,13,'Mentos','MENTO',1),(465,'2022-02-16 09:13:56',1,NULL,NULL,13,'Mustela','MUSTE',1),(466,'2022-02-16 09:13:56',1,NULL,NULL,13,'Nestle','NESTL',1),(467,'2022-02-16 09:13:56',1,NULL,NULL,13,'Nutrition','NUTRI',1),(468,'2022-02-16 09:13:56',1,NULL,NULL,13,'P&G Health','PNGHE',1),(469,'2022-02-16 09:13:56',1,NULL,NULL,13,'Pillowpeople','PILLO',1),(470,'2022-02-16 09:13:56',1,NULL,NULL,13,'Purina','PURIN',1),(471,'2022-02-16 09:13:56',1,NULL,NULL,13,'Sulwhasoo','SULWH',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=394 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_market`
--

LOCK TABLES `tb_user_market` WRITE;
/*!40000 ALTER TABLE `tb_user_market` DISABLE KEYS */;
INSERT INTO `tb_user_market` VALUES (1,'2022-02-15 11:29:33',0,NULL,NULL,1,'Principal A',1),(2,'2022-02-15 11:29:33',0,NULL,NULL,1,'Distributor A',1),(3,'2022-02-15 11:29:33',0,NULL,NULL,1,'Distributor B',1),(4,'2022-02-15 11:29:33',0,NULL,NULL,1,'Subdist A',1),(5,'2022-02-15 11:29:33',0,NULL,NULL,1,'Subdist B',1),(6,'2022-02-15 11:29:33',0,NULL,NULL,1,'Subdist C',1),(7,'2022-02-15 11:29:33',0,NULL,NULL,1,'Subdist D',1),(8,'2022-02-15 11:29:33',0,NULL,NULL,1,'Subdist E',1),(9,'2022-02-15 11:29:33',0,NULL,NULL,1,'Grosir A',1),(10,'2022-02-15 11:29:33',0,NULL,NULL,1,'Grosir B',1),(11,'2022-02-15 11:29:33',0,NULL,NULL,1,'Grosir C',1),(12,'2022-02-15 11:29:33',0,NULL,NULL,1,'Grosir D',1),(13,'2022-02-15 11:29:33',0,NULL,NULL,1,'Grosir E',1),(14,'2022-02-15 11:29:33',0,NULL,NULL,1,'Grosir F',1),(15,'2022-02-15 11:29:33',0,NULL,NULL,1,'Grosir G',1),(16,'2022-02-15 11:29:33',0,NULL,NULL,2,'Principal A',1),(17,'2022-02-15 11:29:33',0,NULL,NULL,2,'Distributor A',1),(18,'2022-02-15 11:29:33',0,NULL,NULL,2,'Distributor B',1),(19,'2022-02-15 11:29:33',0,NULL,NULL,2,'Subdist A',1),(20,'2022-02-15 11:29:33',0,NULL,NULL,2,'Subdist B',1),(21,'2022-02-15 11:29:33',0,NULL,NULL,2,'Subdist C',1),(22,'2022-02-15 11:29:33',0,NULL,NULL,2,'Subdist D',1),(23,'2022-02-15 11:29:33',0,NULL,NULL,2,'Subdist E',1),(24,'2022-02-15 11:29:33',0,NULL,NULL,2,'Grosir A',1),(25,'2022-02-15 11:29:33',0,NULL,NULL,2,'Grosir B',1),(26,'2022-02-15 11:29:33',0,NULL,NULL,2,'Grosir C',1),(27,'2022-02-15 11:29:33',0,NULL,NULL,2,'Grosir D',1),(28,'2022-02-15 11:29:33',0,NULL,NULL,2,'Grosir E',1),(29,'2022-02-15 11:29:33',0,NULL,NULL,2,'Grosir F',1),(30,'2022-02-15 11:29:33',0,NULL,NULL,2,'Grosir G',1),(31,'2022-02-15 11:29:33',0,NULL,NULL,3,'Principal A',1),(32,'2022-02-15 11:29:33',0,NULL,NULL,3,'Distributor A',1),(33,'2022-02-15 11:29:33',0,NULL,NULL,3,'Distributor B',1),(34,'2022-02-15 11:29:33',0,NULL,NULL,3,'Subdist A',1),(35,'2022-02-15 11:29:33',0,NULL,NULL,3,'Subdist B',1),(36,'2022-02-15 11:29:33',0,NULL,NULL,3,'Subdist C',1),(37,'2022-02-15 11:29:33',0,NULL,NULL,3,'Subdist D',1),(38,'2022-02-15 11:29:33',0,NULL,NULL,3,'Subdist E',1),(39,'2022-02-15 11:29:33',0,NULL,NULL,3,'Grosir A',1),(40,'2022-02-15 11:29:33',0,NULL,NULL,3,'Grosir B',1),(41,'2022-02-15 11:29:33',0,NULL,NULL,3,'Grosir C',1),(42,'2022-02-15 11:29:33',0,NULL,NULL,3,'Grosir D',1),(43,'2022-02-15 11:29:33',0,NULL,NULL,3,'Grosir E',1),(44,'2022-02-15 11:29:33',0,NULL,NULL,3,'Grosir F',1),(45,'2022-02-15 11:29:33',0,NULL,NULL,3,'Grosir G',1),(46,'2022-02-15 11:29:33',0,NULL,NULL,4,'Principal A',1),(47,'2022-02-15 11:29:33',0,NULL,NULL,4,'Distributor A',1),(48,'2022-02-15 11:29:33',0,NULL,NULL,4,'Distributor B',1),(49,'2022-02-15 11:29:33',0,NULL,NULL,4,'Subdist A',1),(50,'2022-02-15 11:29:33',0,NULL,NULL,4,'Subdist B',1),(51,'2022-02-15 11:29:33',0,NULL,NULL,4,'Subdist C',1),(52,'2022-02-15 11:29:33',0,NULL,NULL,4,'Subdist D',1),(53,'2022-02-15 11:29:33',0,NULL,NULL,4,'Subdist E',1),(54,'2022-02-15 11:29:33',0,NULL,NULL,4,'Grosir A',1),(55,'2022-02-15 11:29:33',0,NULL,NULL,4,'Grosir B',1),(56,'2022-02-15 11:29:33',0,NULL,NULL,4,'Grosir C',1),(57,'2022-02-15 11:29:33',0,NULL,NULL,4,'Grosir D',1),(58,'2022-02-15 11:29:33',0,NULL,NULL,4,'Grosir E',1),(59,'2022-02-15 11:29:33',0,NULL,NULL,4,'Grosir F',1),(60,'2022-02-15 11:29:33',0,NULL,NULL,4,'Grosir G',1),(61,'2022-02-15 11:29:33',0,NULL,NULL,5,'Principal A',1),(62,'2022-02-15 11:29:33',0,NULL,NULL,5,'Distributor A',1),(63,'2022-02-15 11:29:33',0,NULL,NULL,5,'Distributor B',1),(64,'2022-02-15 11:29:33',0,NULL,NULL,5,'Subdist A',1),(65,'2022-02-15 11:29:33',0,NULL,NULL,5,'Subdist B',1),(66,'2022-02-15 11:29:33',0,NULL,NULL,5,'Subdist C',1),(67,'2022-02-15 11:29:33',0,NULL,NULL,5,'Subdist D',1),(68,'2022-02-15 11:29:33',0,NULL,NULL,5,'Subdist E',1),(69,'2022-02-15 11:29:33',0,NULL,NULL,5,'Grosir A',1),(70,'2022-02-15 11:29:33',0,NULL,NULL,5,'Grosir B',1),(71,'2022-02-15 11:29:33',0,NULL,NULL,5,'Grosir C',1),(72,'2022-02-15 11:29:33',0,NULL,NULL,5,'Grosir D',1),(73,'2022-02-15 11:29:33',0,NULL,NULL,5,'Grosir E',1),(74,'2022-02-15 11:29:33',0,NULL,NULL,5,'Grosir F',1),(75,'2022-02-15 11:29:33',0,NULL,NULL,5,'Grosir G',1),(76,'2022-02-15 11:29:33',0,NULL,NULL,6,'Principal A',1),(77,'2022-02-15 11:29:33',0,NULL,NULL,6,'Distributor A',1),(78,'2022-02-15 11:29:33',0,NULL,NULL,6,'Distributor B',1),(79,'2022-02-15 11:29:33',0,NULL,NULL,6,'Subdist A',1),(80,'2022-02-15 11:29:33',0,NULL,NULL,6,'Subdist B',1),(81,'2022-02-15 11:29:33',0,NULL,NULL,6,'Subdist C',1),(82,'2022-02-15 11:29:33',0,NULL,NULL,6,'Subdist D',1),(83,'2022-02-15 11:29:33',0,NULL,NULL,6,'Subdist E',1),(84,'2022-02-15 11:29:33',0,NULL,NULL,6,'Grosir A',1),(85,'2022-02-15 11:29:33',0,NULL,NULL,6,'Grosir B',1),(86,'2022-02-15 11:29:33',0,NULL,NULL,6,'Grosir C',1),(87,'2022-02-15 11:29:33',0,NULL,NULL,6,'Grosir D',1),(88,'2022-02-15 11:29:33',0,NULL,NULL,6,'Grosir E',1),(89,'2022-02-15 11:29:33',0,NULL,NULL,6,'Grosir F',1),(90,'2022-02-15 11:29:33',0,NULL,NULL,6,'Grosir G',1),(91,'2022-02-15 11:29:33',0,NULL,NULL,7,'Principal A',1),(92,'2022-02-15 11:29:33',0,NULL,NULL,7,'Distributor A',1),(93,'2022-02-15 11:29:33',0,NULL,NULL,7,'Distributor B',1),(94,'2022-02-15 11:29:33',0,NULL,NULL,7,'Subdist A',1),(95,'2022-02-15 11:29:33',0,NULL,NULL,7,'Subdist B',1),(96,'2022-02-15 11:29:33',0,NULL,NULL,7,'Subdist C',1),(97,'2022-02-15 11:29:33',0,NULL,NULL,7,'Subdist D',1),(98,'2022-02-15 11:29:33',0,NULL,NULL,7,'Subdist E',1),(99,'2022-02-15 11:29:33',0,NULL,NULL,7,'Grosir A',1),(100,'2022-02-15 11:29:33',0,NULL,NULL,7,'Grosir B',1),(101,'2022-02-15 11:29:33',0,NULL,NULL,7,'Grosir C',1),(102,'2022-02-15 11:29:33',0,NULL,NULL,7,'Grosir D',1),(103,'2022-02-15 11:29:33',0,NULL,NULL,7,'Grosir E',1),(104,'2022-02-15 11:29:33',0,NULL,NULL,7,'Grosir F',1),(105,'2022-02-15 11:29:33',0,NULL,NULL,7,'Grosir G',1),(106,'2022-02-15 11:29:33',0,NULL,NULL,8,'Principal A',1),(107,'2022-02-15 11:29:33',0,NULL,NULL,8,'Distributor A',1),(108,'2022-02-15 11:29:33',0,NULL,NULL,8,'Distributor B',1),(109,'2022-02-15 11:29:33',0,NULL,NULL,8,'Subdist A',1),(110,'2022-02-15 11:29:33',0,NULL,NULL,8,'Subdist B',1),(111,'2022-02-15 11:29:33',0,NULL,NULL,8,'Subdist C',1),(112,'2022-02-15 11:29:33',0,NULL,NULL,8,'Subdist D',1),(113,'2022-02-15 11:29:33',0,NULL,NULL,8,'Subdist E',1),(114,'2022-02-15 11:29:33',0,NULL,NULL,8,'Grosir A',1),(115,'2022-02-15 11:29:33',0,NULL,NULL,8,'Grosir B',1),(116,'2022-02-15 11:29:33',0,NULL,NULL,8,'Grosir C',1),(117,'2022-02-15 11:29:33',0,NULL,NULL,8,'Grosir D',1),(118,'2022-02-15 11:29:33',0,NULL,NULL,8,'Grosir E',1),(119,'2022-02-15 11:29:33',0,NULL,NULL,8,'Grosir F',1),(120,'2022-02-15 11:29:33',0,NULL,NULL,8,'Grosir G',1),(121,'2022-02-15 11:29:33',0,NULL,NULL,9,'Principal A',1),(122,'2022-02-15 11:29:33',0,NULL,NULL,9,'Distributor A',1),(123,'2022-02-15 11:29:33',0,NULL,NULL,9,'Distributor B',1),(124,'2022-02-15 11:29:33',0,NULL,NULL,9,'Subdist A',1),(125,'2022-02-15 11:29:33',0,NULL,NULL,9,'Subdist B',1),(126,'2022-02-15 11:29:33',0,NULL,NULL,9,'Subdist C',1),(127,'2022-02-15 11:29:33',0,NULL,NULL,9,'Subdist D',1),(128,'2022-02-15 11:29:33',0,NULL,NULL,9,'Subdist E',1),(129,'2022-02-15 11:29:33',0,NULL,NULL,9,'Grosir A',1),(130,'2022-02-15 11:29:33',0,NULL,NULL,9,'Grosir B',1),(131,'2022-02-15 11:29:33',0,NULL,NULL,9,'Grosir C',1),(132,'2022-02-15 11:29:33',0,NULL,NULL,9,'Grosir D',1),(133,'2022-02-15 11:29:33',0,NULL,NULL,9,'Grosir E',1),(134,'2022-02-15 11:29:33',0,NULL,NULL,9,'Grosir F',1),(135,'2022-02-15 11:29:33',0,NULL,NULL,9,'Grosir G',1),(136,'2022-02-15 11:29:33',0,NULL,NULL,10,'Principal A',1),(137,'2022-02-15 11:29:33',0,NULL,NULL,10,'Distributor A',1),(138,'2022-02-15 11:29:33',0,NULL,NULL,10,'Distributor B',1),(139,'2022-02-15 11:29:33',0,NULL,NULL,10,'Subdist A',1),(140,'2022-02-15 11:29:33',0,NULL,NULL,10,'Subdist B',1),(141,'2022-02-15 11:29:33',0,NULL,NULL,10,'Subdist C',1),(142,'2022-02-15 11:29:33',0,NULL,NULL,10,'Subdist D',1),(143,'2022-02-15 11:29:33',0,NULL,NULL,10,'Subdist E',1),(144,'2022-02-15 11:29:33',0,NULL,NULL,10,'Grosir A',1),(145,'2022-02-15 11:29:33',0,NULL,NULL,10,'Grosir B',1),(146,'2022-02-15 11:29:33',0,NULL,NULL,10,'Grosir C',1),(147,'2022-02-15 11:29:33',0,NULL,NULL,10,'Grosir D',1),(148,'2022-02-15 11:29:33',0,NULL,NULL,10,'Grosir E',1),(149,'2022-02-15 11:29:33',0,NULL,NULL,10,'Grosir F',1),(150,'2022-02-15 11:29:33',0,NULL,NULL,10,'Grosir G',1),(151,'2022-02-15 11:29:33',0,NULL,NULL,12,'Principal A',1),(152,'2022-02-15 11:29:33',0,NULL,NULL,12,'Distributor A',1),(153,'2022-02-15 11:29:33',0,NULL,NULL,12,'Distributor B',1),(154,'2022-02-15 11:29:33',0,NULL,NULL,12,'Subdist A',1),(155,'2022-02-15 11:29:33',0,NULL,NULL,12,'Subdist B',1),(156,'2022-02-15 11:29:33',0,NULL,NULL,12,'Subdist C',1),(157,'2022-02-15 11:29:33',0,NULL,NULL,12,'Subdist D',1),(158,'2022-02-15 11:29:33',0,NULL,NULL,12,'Subdist E',1),(159,'2022-02-15 11:29:33',0,NULL,NULL,12,'Grosir A',1),(160,'2022-02-15 11:29:33',0,NULL,NULL,12,'Grosir B',1),(161,'2022-02-15 11:29:33',0,NULL,NULL,12,'Grosir C',1),(162,'2022-02-15 11:29:33',0,NULL,NULL,12,'Grosir D',1),(163,'2022-02-15 11:29:33',0,NULL,NULL,12,'Grosir E',1),(164,'2022-02-15 11:29:33',0,NULL,NULL,12,'Grosir F',1),(165,'2022-02-15 11:29:33',0,NULL,NULL,12,'Grosir G',1),(380,'2022-02-16 09:12:53',1,NULL,NULL,14,'Grosir A',1),(381,'2022-02-16 09:12:53',1,NULL,NULL,14,'Grosir B',0),(382,'2022-02-16 09:12:53',1,NULL,NULL,14,'Grosir C',0),(383,'2022-02-16 09:12:53',1,NULL,NULL,14,'Grosir D',0),(384,'2022-02-16 09:12:53',1,NULL,NULL,14,'Grosir E',1),(385,'2022-02-16 09:12:53',1,NULL,NULL,14,'Grosir F',1),(386,'2022-02-16 09:12:53',1,NULL,NULL,14,'Grosir G',1),(387,'2022-02-16 09:13:56',1,NULL,NULL,13,'Grosir A',1),(388,'2022-02-16 09:13:56',1,NULL,NULL,13,'Grosir B',1),(389,'2022-02-16 09:13:56',1,NULL,NULL,13,'Grosir C',1),(390,'2022-02-16 09:13:56',1,NULL,NULL,13,'Grosir D',1),(391,'2022-02-16 09:13:56',1,NULL,NULL,13,'Grosir E',1),(392,'2022-02-16 09:13:56',1,NULL,NULL,13,'Grosir F',0),(393,'2022-02-16 09:13:56',1,NULL,NULL,13,'Grosir G',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_menu`
--

LOCK TABLES `tb_user_menu` WRITE;
/*!40000 ALTER TABLE `tb_user_menu` DISABLE KEYS */;
INSERT INTO `tb_user_menu` VALUES (1,'2022-02-14 15:18:30',0,NULL,NULL,1,1,1,1,1,1),(2,'2022-02-14 15:18:30',0,NULL,NULL,1,2,1,1,1,1),(3,'2022-02-14 15:18:30',0,NULL,NULL,1,3,1,1,1,1),(4,'2022-02-14 15:18:30',0,NULL,NULL,1,4,1,1,1,1),(5,'2022-02-14 15:18:30',0,NULL,NULL,1,5,1,1,1,1),(6,'2022-02-14 15:18:30',0,NULL,NULL,1,6,1,1,1,1),(7,'2022-02-14 15:18:30',0,NULL,NULL,1,7,1,1,1,1),(8,'2022-02-14 15:18:30',0,NULL,NULL,2,1,1,1,1,1),(9,'2022-02-14 15:18:30',0,NULL,NULL,2,2,1,1,1,1),(10,'2022-02-14 15:18:30',0,NULL,NULL,2,3,1,1,1,1),(11,'2022-02-14 15:18:30',0,NULL,NULL,2,4,1,1,1,1),(12,'2022-02-14 15:18:30',0,NULL,NULL,2,5,1,1,1,1),(13,'2022-02-14 15:18:30',0,NULL,NULL,2,6,1,1,1,1),(14,'2022-02-14 15:18:30',0,NULL,NULL,2,7,1,1,1,1),(15,'2022-02-14 15:18:30',0,NULL,NULL,3,1,1,1,1,1),(16,'2022-02-14 15:18:30',0,NULL,NULL,3,2,1,1,1,1),(17,'2022-02-14 15:18:30',0,NULL,NULL,3,3,1,1,1,1),(18,'2022-02-14 15:18:30',0,NULL,NULL,3,4,1,1,1,1),(19,'2022-02-14 15:18:30',0,NULL,NULL,3,5,1,1,1,1),(20,'2022-02-14 15:18:30',0,NULL,NULL,3,6,1,1,1,1),(21,'2022-02-14 15:18:30',0,NULL,NULL,3,7,1,1,1,1),(22,'2022-02-14 15:18:30',0,NULL,NULL,4,1,1,1,1,1),(23,'2022-02-14 15:18:30',0,NULL,NULL,4,2,1,1,1,1),(24,'2022-02-14 15:18:30',0,NULL,NULL,4,3,1,1,1,1),(25,'2022-02-14 15:18:30',0,NULL,NULL,4,4,1,1,1,1),(26,'2022-02-14 15:18:30',0,NULL,NULL,4,5,1,1,1,1),(27,'2022-02-14 15:18:30',0,NULL,NULL,4,6,1,1,1,1),(28,'2022-02-14 15:18:30',0,NULL,NULL,4,7,1,1,1,1),(29,'2022-02-14 15:18:30',0,NULL,NULL,5,1,1,1,1,1),(30,'2022-02-14 15:18:30',0,NULL,NULL,5,2,1,1,1,1),(31,'2022-02-14 15:18:30',0,NULL,NULL,5,3,1,1,1,1),(32,'2022-02-14 15:18:30',0,NULL,NULL,5,4,1,1,1,1),(33,'2022-02-14 15:18:30',0,NULL,NULL,5,5,1,1,1,1),(34,'2022-02-14 15:18:30',0,NULL,NULL,5,6,1,1,1,1),(35,'2022-02-14 15:18:30',0,NULL,NULL,5,7,1,1,1,1),(36,'2022-02-14 15:18:30',0,NULL,NULL,6,1,1,1,1,1),(37,'2022-02-14 15:18:30',0,NULL,NULL,6,2,1,1,1,1),(38,'2022-02-14 15:18:30',0,NULL,NULL,6,3,1,1,1,1),(39,'2022-02-14 15:18:30',0,NULL,NULL,6,4,1,1,1,1),(40,'2022-02-14 15:18:30',0,NULL,NULL,6,5,1,1,1,1),(41,'2022-02-14 15:18:30',0,NULL,NULL,6,6,1,1,1,1),(42,'2022-02-14 15:18:30',0,NULL,NULL,6,7,1,1,1,1),(43,'2022-02-14 15:18:30',0,NULL,NULL,7,1,1,1,1,1),(44,'2022-02-14 15:18:30',0,NULL,NULL,7,2,1,1,1,1),(45,'2022-02-14 15:18:30',0,NULL,NULL,7,3,1,1,1,1),(46,'2022-02-14 15:18:30',0,NULL,NULL,7,4,1,1,1,1),(47,'2022-02-14 15:18:30',0,NULL,NULL,7,5,1,1,1,1),(48,'2022-02-14 15:18:30',0,NULL,NULL,7,6,1,1,1,1),(49,'2022-02-14 15:18:30',0,NULL,NULL,7,7,1,1,1,1),(50,'2022-02-14 15:18:30',0,NULL,NULL,8,1,1,1,1,1),(51,'2022-02-14 15:18:30',0,NULL,NULL,8,2,1,1,1,1),(52,'2022-02-14 15:18:30',0,NULL,NULL,8,3,1,1,1,1),(53,'2022-02-14 15:18:30',0,NULL,NULL,8,4,1,1,1,1),(54,'2022-02-14 15:18:30',0,NULL,NULL,8,5,1,1,1,1),(55,'2022-02-14 15:18:30',0,NULL,NULL,8,6,1,1,1,1),(56,'2022-02-14 15:18:30',0,NULL,NULL,8,7,1,1,1,1),(57,'2022-02-14 15:18:30',0,NULL,NULL,9,1,1,1,1,1),(58,'2022-02-14 15:18:30',0,NULL,NULL,9,2,1,1,1,1),(59,'2022-02-14 15:18:30',0,NULL,NULL,9,3,1,1,1,1),(60,'2022-02-14 15:18:30',0,NULL,NULL,9,4,1,1,1,1),(61,'2022-02-14 15:18:30',0,NULL,NULL,9,5,1,1,1,1),(62,'2022-02-14 15:18:30',0,NULL,NULL,9,6,1,1,1,1),(63,'2022-02-14 15:18:30',0,NULL,NULL,9,7,1,1,1,1),(64,'2022-02-14 15:18:30',0,NULL,NULL,10,1,1,1,1,1),(65,'2022-02-14 15:18:30',0,NULL,NULL,10,2,1,1,1,1),(66,'2022-02-14 15:18:30',0,NULL,NULL,10,3,1,1,1,1),(67,'2022-02-14 15:18:30',0,NULL,NULL,10,4,1,1,1,1),(68,'2022-02-14 15:18:30',0,NULL,NULL,10,5,1,1,1,1),(69,'2022-02-14 15:18:30',0,NULL,NULL,10,6,1,1,1,1),(70,'2022-02-14 15:18:30',0,NULL,NULL,10,7,1,1,1,1),(135,'2022-02-14 11:18:06',1,NULL,NULL,12,4,0,0,0,1),(136,'2022-02-14 11:18:06',1,NULL,NULL,12,7,0,0,0,1),(137,'2022-02-14 11:18:06',1,NULL,NULL,12,2,0,0,0,1),(138,'2022-02-14 11:18:06',1,NULL,NULL,12,3,0,0,0,1),(139,'2022-02-14 11:18:06',1,NULL,NULL,12,1,0,0,0,1),(140,'2022-02-14 11:18:06',1,NULL,NULL,12,5,0,0,0,1),(141,'2022-02-14 11:18:06',1,NULL,NULL,12,6,0,0,0,1),(219,'2022-02-16 09:12:53',1,NULL,NULL,14,4,0,0,0,1),(220,'2022-02-16 09:12:53',1,NULL,NULL,14,7,0,0,0,1),(221,'2022-02-16 09:12:53',1,NULL,NULL,14,2,0,0,0,1),(222,'2022-02-16 09:12:53',1,NULL,NULL,14,3,0,0,0,1),(223,'2022-02-16 09:12:53',1,NULL,NULL,14,1,0,0,0,1),(224,'2022-02-16 09:12:53',1,NULL,NULL,14,5,0,0,0,1),(225,'2022-02-16 09:12:53',1,NULL,NULL,14,6,0,0,0,1),(226,'2022-02-16 09:13:56',1,NULL,NULL,13,4,0,0,0,1),(227,'2022-02-16 09:13:56',1,NULL,NULL,13,7,0,0,0,1),(228,'2022-02-16 09:13:56',1,NULL,NULL,13,2,0,0,0,1),(229,'2022-02-16 09:13:56',1,NULL,NULL,13,3,0,0,0,1),(230,'2022-02-16 09:13:56',1,NULL,NULL,13,1,0,0,0,1),(231,'2022-02-16 09:13:56',1,NULL,NULL,13,5,0,0,0,1),(232,'2022-02-16 09:13:56',1,NULL,NULL,13,6,0,0,0,1);
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

-- Dump completed on 2022-02-22 16:28:54
