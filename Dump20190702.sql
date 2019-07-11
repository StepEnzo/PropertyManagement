-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: property
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `admin` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `admincol` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `damage`
--

DROP TABLE IF EXISTS `damage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `damage` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `pid` int(10) unsigned NOT NULL,
  `level` varchar(255) NOT NULL,
  `solution` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ToProperty` (`pid`),
  CONSTRAINT `ToProperty` FOREIGN KEY (`pid`) REFERENCES `propertyitem` (`pid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `damage`
--

LOCK TABLES `damage` WRITE;
/*!40000 ALTER TABLE `damage` DISABLE KEYS */;
/*!40000 ALTER TABLE `damage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propertyitem`
--

DROP TABLE IF EXISTS `propertyitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `propertyitem` (
  `id` int(10) unsigned NOT NULL,
  `pid` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `itemcol` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`pid`,`id`),
  KEY `ItemtoName_idx` (`id`),
  CONSTRAINT `ItemtoName` FOREIGN KEY (`id`) REFERENCES `propertyname` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propertyitem`
--

LOCK TABLES `propertyitem` WRITE;
/*!40000 ALTER TABLE `propertyitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `propertyitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propertyname`
--

DROP TABLE IF EXISTS `propertyname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `propertyname` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `propertyname` varchar(45) NOT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `modelnumber` varchar(45) DEFAULT NULL,
  `specification` varchar(45) DEFAULT NULL,
  `namecol` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propertyname`
--

LOCK TABLES `propertyname` WRITE;
/*!40000 ALTER TABLE `propertyname` DISABLE KEYS */;
/*!40000 ALTER TABLE `propertyname` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pus`
--

DROP TABLE IF EXISTS `pus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pus` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `propertyid` int(10) unsigned NOT NULL,
  `userid` int(10) unsigned NOT NULL,
  `date` date NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ToPropertyItem_idx` (`propertyid`),
  KEY `ToUser_idx` (`userid`),
  CONSTRAINT `ToPropertyItem` FOREIGN KEY (`propertyid`) REFERENCES `propertyitem` (`pid`) ON UPDATE CASCADE,
  CONSTRAINT `ToUser` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pus`
--

LOCK TABLES `pus` WRITE;
/*!40000 ALTER TABLE `pus` DISABLE KEYS */;
/*!40000 ALTER TABLE `pus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `superadmin`
--

DROP TABLE IF EXISTS `superadmin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `superadmin` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `superadmin`
--

LOCK TABLES `superadmin` WRITE;
/*!40000 ALTER TABLE `superadmin` DISABLE KEYS */;
INSERT INTO `superadmin` VALUES (0000000002,'admin','654321');
/*!40000 ALTER TABLE `superadmin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `rank` int(11) DEFAULT '1',
  `username` varchar(45) DEFAULT NULL,
  `usercontrol` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-02 16:50:43
