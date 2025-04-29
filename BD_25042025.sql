-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: gmingenieros
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `almacenes`
--

DROP TABLE IF EXISTS `almacenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `almacenes` (
  `idalmacen` int NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idalmacen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacenes`
--

LOCK TABLES `almacenes` WRITE;
/*!40000 ALTER TABLE `almacenes` DISABLE KEYS */;
INSERT INTO `almacenes` VALUES (1,'almacen oficina'),(2,'almacen tecnologico'),(3,'almacen campo');
/*!40000 ALTER TABLE `almacenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `almacenxarticulo`
--

DROP TABLE IF EXISTS `almacenxarticulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `almacenxarticulo` (
  `idalmacen` int NOT NULL,
  `idarticulo` int NOT NULL,
  `anio` varchar(45) NOT NULL,
  `mes` varchar(45) NOT NULL,
  `cantidad` decimal(10,2) DEFAULT NULL,
  `movimiento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idarticulo`,`anio`,`mes`,`idalmacen`),
  KEY `fk_idarticulo_idx` (`idarticulo`) /*!80000 INVISIBLE */,
  CONSTRAINT `fk_idarticulo_articulos` FOREIGN KEY (`idarticulo`) REFERENCES `articulos` (`IdArticulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacenxarticulo`
--

LOCK TABLES `almacenxarticulo` WRITE;
/*!40000 ALTER TABLE `almacenxarticulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `almacenxarticulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `areas` (
  `IdArea` int NOT NULL AUTO_INCREMENT,
  `CodigoArea` varchar(50) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdArea`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` VALUES (1,'ARE0001','AdministraciÃ³n'),(2,'ARE0002','TÃ©cnico de Proyectos'),(3,'ARE0003','Contabilidad'),(4,'ARE0004','Gerencia'),(5,'ARE0005','Sistemas');
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articuloconsolidado`
--

DROP TABLE IF EXISTS `articuloconsolidado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articuloconsolidado` (
  `idarticuloconsolidado` int NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `cantidad` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idarticuloconsolidado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articuloconsolidado`
--

LOCK TABLES `articuloconsolidado` WRITE;
/*!40000 ALTER TABLE `articuloconsolidado` DISABLE KEYS */;
/*!40000 ALTER TABLE `articuloconsolidado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articulos`
--

DROP TABLE IF EXISTS `articulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articulos` (
  `IdArticulo` int NOT NULL AUTO_INCREMENT,
  `CodigoArticulo` varchar(50) DEFAULT NULL,
  `IdCategoria` int DEFAULT NULL,
  `IdMarca` int DEFAULT NULL,
  `caracteristicas` varchar(400) DEFAULT NULL,
  `descripcion` varchar(400) DEFAULT NULL,
  `cantidad` decimal(10,2) DEFAULT NULL,
  `IdTipoUnidad` int DEFAULT NULL,
  `valorunidad` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`IdArticulo`),
  KEY `IdCategoria` (`IdCategoria`),
  KEY `IdMarca` (`IdMarca`),
  CONSTRAINT `articulos_ibfk_1` FOREIGN KEY (`IdCategoria`) REFERENCES `categorias` (`IdCategoria`),
  CONSTRAINT `articulos_ibfk_2` FOREIGN KEY (`IdMarca`) REFERENCES `marcas` (`IdMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulos`
--

LOCK TABLES `articulos` WRITE;
/*!40000 ALTER TABLE `articulos` DISABLE KEYS */;
INSERT INTO `articulos` VALUES (1,NULL,2,2,NULL,'sada',0.00,NULL,NULL);
/*!40000 ALTER TABLE `articulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articulosconsolidado`
--

DROP TABLE IF EXISTS `articulosconsolidado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articulosconsolidado` (
  `descripcion` varchar(400) DEFAULT NULL,
  `Total` decimal(32,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulosconsolidado`
--

LOCK TABLES `articulosconsolidado` WRITE;
/*!40000 ALTER TABLE `articulosconsolidado` DISABLE KEYS */;
/*!40000 ALTER TABLE `articulosconsolidado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asistencias`
--

DROP TABLE IF EXISTS `asistencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asistencias` (
  `IdAsistencia` int NOT NULL AUTO_INCREMENT,
  `Dni` char(8) DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `Hora` time DEFAULT NULL,
  `Procesado` char(1) DEFAULT NULL,
  PRIMARY KEY (`IdAsistencia`)
) ENGINE=InnoDB AUTO_INCREMENT=1792 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencias`
--

LOCK TABLES `asistencias` WRITE;
/*!40000 ALTER TABLE `asistencias` DISABLE KEYS */;
INSERT INTO `asistencias` VALUES (1593,'70269937','2022-10-03','08:57:34','S'),(1594,'70269937','2022-10-03','11:48:49','S'),(1595,'70269937','2022-10-05','13:50:16','S'),(1596,'70269937','2022-10-05','16:06:50','S'),(1597,'70269937','2022-10-06','08:42:52','S'),(1598,'70269937','2022-10-06','15:33:40','S'),(1599,'70269937','2022-10-07','08:51:47','S'),(1600,'70269937','2022-10-07','15:29:02','S'),(1601,'70269937','2022-10-10','12:54:58','S'),(1602,'70269937','2022-10-10','15:55:08','S'),(1603,'70269937','2022-10-13','09:49:50','S'),(1604,'70269937','2022-10-13','15:35:41','S'),(1605,'70269937','2022-10-14','09:01:10','S'),(1606,'70269937','2022-10-14','15:59:52','S'),(1607,'70269937','2022-10-17','16:00:20','S'),(1608,'70269937','2022-10-24','09:00:28','S'),(1609,'71240208','2022-10-03','08:35:10','S'),(1610,'71240208','2022-10-03','18:47:38','S'),(1611,'71914589','2022-10-03','07:57:49','S'),(1612,'71914589','2022-10-03','16:05:43','S'),(1613,'71914589','2022-10-04','08:07:50','S'),(1614,'71914589','2022-10-04','16:05:09','S'),(1615,'71914589','2022-10-05','08:16:38','S'),(1616,'71914589','2022-10-05','16:56:13','S'),(1617,'71914589','2022-10-06','08:02:43','S'),(1618,'71914589','2022-10-06','16:13:15','S'),(1619,'71914589','2022-10-07','08:22:21','S'),(1620,'71914589','2022-10-07','16:01:02','S'),(1621,'71914589','2022-10-10','08:55:37','S'),(1622,'71914589','2022-10-10','17:07:09','S'),(1623,'71914589','2022-10-11','08:15:08','S'),(1624,'71914589','2022-10-11','16:57:12','S'),(1625,'71914589','2022-10-17','08:25:45','S'),(1626,'71914589','2022-10-17','17:05:19','S'),(1627,'71914589','2022-10-18','08:19:45','S'),(1628,'71914589','2022-10-18','17:05:34','S'),(1629,'71962046','2022-10-03','08:53:15','S'),(1630,'71962046','2022-10-03','15:56:42','S'),(1631,'71962046','2022-10-04','08:58:53','S'),(1632,'71962046','2022-10-04','17:11:04','S'),(1633,'71962046','2022-10-05','09:07:01','S'),(1634,'71962046','2022-10-05','16:09:46','S'),(1635,'71962046','2022-10-06','08:45:13','S'),(1636,'71962046','2022-10-06','16:23:09','S'),(1637,'71962046','2022-10-07','08:31:40','S'),(1638,'71962046','2022-10-07','13:47:33','S'),(1639,'71962046','2022-10-10','08:55:52','S'),(1640,'71962046','2022-10-11','08:48:51','S'),(1641,'71962046','2022-10-11','15:59:33','S'),(1642,'71962046','2022-10-12','08:12:39','S'),(1643,'71962046','2022-10-12','15:45:13','S'),(1644,'71962046','2022-10-13','09:02:08','S'),(1645,'71962046','2022-10-13','16:45:26','S'),(1646,'71962046','2022-10-14','08:39:26','S'),(1647,'71962046','2022-10-14','17:15:10','S'),(1648,'71962046','2022-10-17','09:15:19','S'),(1649,'71962046','2022-10-17','16:18:55','S'),(1650,'71962046','2022-10-18','09:34:54','S'),(1651,'71962046','2022-10-18','16:06:46','S'),(1652,'71962046','2022-10-19','09:08:55','S'),(1653,'71962046','2022-10-19','16:21:56','S'),(1654,'71962046','2022-10-20','09:13:47','S'),(1655,'71962046','2022-10-20','16:13:10','S'),(1656,'71962046','2022-10-21','08:37:08','S'),(1657,'71962046','2022-10-21','13:36:35','S'),(1658,'72169180','2022-10-03','09:19:55','S'),(1659,'72169180','2022-10-03','13:22:34','S'),(1660,'72169180','2022-10-04','15:53:43','S'),(1661,'72169180','2022-10-05','09:13:31','S'),(1662,'72169180','2022-10-05','10:31:37','S'),(1663,'72169180','2022-10-06','09:24:56','S'),(1664,'72169180','2022-10-06','15:37:15','S'),(1665,'72169180','2022-10-07','09:23:51','S'),(1666,'72169180','2022-10-07','15:31:16','S'),(1667,'72169180','2022-10-11','13:21:06','S'),(1668,'72169180','2022-10-11','15:59:03','S'),(1669,'72169180','2022-10-17','09:36:18','S'),(1670,'72169180','2022-10-17','13:33:57','S'),(1671,'72927474','2022-10-03','08:49:36','S'),(1672,'72927474','2022-10-03','18:21:21','S'),(1673,'72927474','2022-10-04','09:14:53','S'),(1674,'72927474','2022-10-04','18:03:11','S'),(1675,'72927474','2022-10-05','08:58:31','S'),(1676,'72927474','2022-10-05','18:17:21','S'),(1677,'72927474','2022-10-06','08:52:21','S'),(1678,'72927474','2022-10-06','18:13:27','S'),(1679,'72927474','2022-10-07','08:51:51','S'),(1680,'72927474','2022-10-07','16:59:49','S'),(1681,'72927474','2022-10-10','08:52:29','S'),(1682,'72927474','2022-10-10','17:07:01','S'),(1683,'72927474','2022-10-11','08:48:44','S'),(1684,'72927474','2022-10-11','16:57:02','S'),(1685,'72927474','2022-10-12','08:42:53','S'),(1686,'72927474','2022-10-12','16:33:23','S'),(1687,'72927474','2022-10-13','08:52:54','S'),(1688,'72927474','2022-10-13','18:05:49','S'),(1689,'72927474','2022-10-14','08:53:26','S'),(1690,'72927474','2022-10-14','18:12:48','S'),(1691,'72927474','2022-10-17','08:39:23','S'),(1692,'72927474','2022-10-17','16:29:02','S'),(1693,'72927474','2022-10-18','08:40:37','S'),(1694,'72927474','2022-10-18','16:48:06','S'),(1695,'72927474','2022-10-19','08:11:29','S'),(1696,'72927474','2022-10-19','16:43:48','S'),(1697,'72927474','2022-10-20','08:07:01','S'),(1698,'72927474','2022-10-20','16:20:38','S'),(1699,'72927474','2022-10-21','08:10:42','S'),(1700,'72927474','2022-10-21','16:25:41','S'),(1701,'72927474','2022-10-24','08:18:56','S'),(1702,'73277512','2022-10-03','08:14:33','S'),(1703,'73277512','2022-10-03','11:37:54','S'),(1704,'73277512','2022-10-04','08:19:20','S'),(1705,'73277512','2022-10-04','17:00:06','S'),(1706,'73277512','2022-10-05','08:08:32','S'),(1707,'73277512','2022-10-05','16:56:15','S'),(1708,'73277512','2022-10-06','08:10:27','S'),(1709,'73277512','2022-10-06','17:53:48','S'),(1710,'73277512','2022-10-07','08:22:26','S'),(1711,'73277512','2022-10-07','11:46:31','S'),(1712,'73277512','2022-10-10','07:59:17','S'),(1713,'73277512','2022-10-10','13:00:53','S'),(1714,'73277512','2022-10-11','07:54:05','S'),(1715,'73277513','2022-10-11','16:59:04','S'),(1716,'73277514','2022-10-12','08:12:46','S'),(1717,'73277515','2022-10-12','15:05:53','S'),(1718,'73277516','2022-10-13','08:07:20','S'),(1719,'73277517','2022-10-13','17:00:03','S'),(1720,'73277518','2022-10-14','08:25:59','S'),(1721,'73277519','2022-10-14','16:36:26','S'),(1722,'73277520','2022-10-17','08:21:32','S'),(1723,'73277521','2022-10-17','13:56:13','S'),(1724,'73277522','2022-10-18','08:42:06','S'),(1725,'73277523','2022-10-18','17:05:37','S'),(1726,'73277524','2022-10-19','08:23:10','S'),(1727,'73277525','2022-10-19','17:04:18','S'),(1728,'73277526','2022-10-20','08:18:07','S'),(1729,'73277527','2022-10-20','16:57:03','S'),(1730,'73277528','2022-10-24','08:19:14','S'),(1731,'74661034','2022-10-03','08:53:10','S'),(1732,'74661034','2022-10-03','18:28:59','S'),(1733,'74661034','2022-10-04','08:58:47','S'),(1734,'74661034','2022-10-04','18:20:35','S'),(1735,'74661034','2022-10-05','18:17:09','S'),(1736,'74661034','2022-10-06','08:52:28','S'),(1737,'74661034','2022-10-06','21:19:36','S'),(1738,'74661034','2022-10-07','08:31:36','S'),(1739,'74661034','2022-10-07','16:59:46','S'),(1740,'74661034','2022-10-10','08:50:55','S'),(1741,'74661034','2022-10-10','17:06:58','S'),(1742,'74661034','2022-10-11','08:45:24','S'),(1743,'74661034','2022-10-11','16:56:16','S'),(1744,'74661034','2022-10-12','08:53:31','S'),(1745,'74661034','2022-10-12','16:32:48','S'),(1746,'74661034','2022-10-13','08:42:54','S'),(1747,'74661034','2022-10-13','18:05:48','S'),(1748,'74661034','2022-10-14','09:01:33','S'),(1749,'74661034','2022-10-14','18:12:59','S'),(1750,'74661034','2022-10-17','09:15:10','S'),(1751,'74661034','2022-10-17','16:28:54','S'),(1752,'74661034','2022-10-18','08:59:17','S'),(1753,'74661034','2022-10-18','16:44:22','S'),(1754,'74661034','2022-10-19','08:44:55','S'),(1755,'74661034','2022-10-19','16:43:39','S'),(1756,'74661034','2022-10-20','08:55:10','S'),(1757,'74661034','2022-10-20','16:21:10','S'),(1758,'74661034','2022-10-21','08:43:22','S'),(1759,'74661034','2022-10-21','16:26:41','S'),(1760,'76323744','2022-10-03','07:57:34','S'),(1761,'76323744','2022-10-03','18:20:31','S'),(1762,'76323744','2022-10-04','07:49:08','S'),(1763,'76323744','2022-10-04','18:21:02','S'),(1764,'76323744','2022-10-05','07:42:51','S'),(1765,'76323744','2022-10-05','19:04:20','S'),(1766,'76323744','2022-10-06','07:42:01','S'),(1767,'76323744','2022-10-06','18:16:02','S'),(1768,'76323744','2022-10-07','07:44:32','S'),(1769,'76323744','2022-10-07','18:05:59','S'),(1770,'76323744','2022-10-10','07:49:24','S'),(1771,'76323744','2022-10-10','19:42:22','S'),(1772,'76323744','2022-10-11','07:48:50','S'),(1773,'76323744','2022-10-11','18:08:48','S'),(1774,'76323744','2022-10-12','07:33:53','S'),(1775,'76323744','2022-10-12','18:19:51','S'),(1776,'76323744','2022-10-13','07:55:34','S'),(1777,'76323744','2022-10-13','18:21:39','S'),(1778,'76323744','2022-10-14','07:42:30','S'),(1779,'76323744','2022-10-14','18:16:05','S'),(1780,'76323744','2022-10-17','07:45:28','S'),(1781,'76323744','2022-10-17','18:07:23','S'),(1782,'76323744','2022-10-18','08:06:17','S'),(1783,'76323744','2022-10-18','18:31:44','S'),(1784,'76323744','2022-10-19','07:46:05','S'),(1785,'76323744','2022-10-19','18:03:06','S'),(1786,'76323744','2022-10-20','07:36:41','S'),(1787,'76323744','2022-10-20','18:34:35','S'),(1788,'76323744','2022-10-21','07:46:45','S'),(1789,'76323744','2022-10-21','18:07:56','S'),(1790,'76323744','2022-10-24','08:21:13','S'),(1791,'76323744','2022-10-24','13:09:15','S');
/*!40000 ALTER TABLE `asistencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bancos`
--

DROP TABLE IF EXISTS `bancos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bancos` (
  `IdBanco` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdBanco`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bancos`
--

LOCK TABLES `bancos` WRITE;
/*!40000 ALTER TABLE `bancos` DISABLE KEYS */;
INSERT INTO `bancos` VALUES (1,'BCP'),(2,'BBVA'),(3,'IBK'),(4,'BN'),(5,'OTRO'),(6,'SCOTIABANK');
/*!40000 ALTER TABLE `bancos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bkproyectoxobjetoestudio`
--

DROP TABLE IF EXISTS `bkproyectoxobjetoestudio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bkproyectoxobjetoestudio` (
  `IdProyectoxObjectoEstudio` int NOT NULL DEFAULT '0',
  `IdProyecto` int NOT NULL,
  `IdObjetoEstudio` int NOT NULL,
  `Estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bkproyectoxobjetoestudio`
--

LOCK TABLES `bkproyectoxobjetoestudio` WRITE;
/*!40000 ALTER TABLE `bkproyectoxobjetoestudio` DISABLE KEYS */;
INSERT INTO `bkproyectoxobjetoestudio` VALUES (1,1,1,'S'),(2,2,1,'S'),(3,3,1,'S'),(4,4,1,'S'),(5,5,1,'S'),(6,6,1,'S'),(7,7,1,'S'),(8,8,1,'S'),(9,8,2,'S'),(10,8,3,'S'),(11,9,1,'S'),(12,10,1,'S'),(13,11,1,'S'),(14,12,1,'S'),(15,13,1,'S'),(16,14,1,'S'),(17,15,1,'S'),(18,16,1,'S'),(19,17,1,'S'),(20,18,1,'S'),(21,19,4,'S'),(22,20,2,'S'),(23,21,2,'S'),(24,22,1,'S'),(25,22,2,'S'),(26,22,3,'S'),(27,23,1,'S'),(28,24,1,'S'),(29,25,2,'S'),(30,26,1,'S'),(31,27,1,'S'),(32,28,1,'S'),(33,29,1,'S'),(34,30,1,'S'),(35,2,2,'N'),(36,2,3,'N'),(37,2,4,'N'),(38,1,2,'N'),(39,1,3,'N'),(40,1,4,'N'),(41,3,2,'N'),(42,3,3,'N'),(43,3,4,'N'),(44,4,2,'N'),(45,4,3,'N'),(46,4,4,'N'),(47,5,2,'N'),(48,5,3,'N'),(49,5,4,'N'),(50,6,2,'N'),(51,6,3,'N'),(52,6,4,'N'),(53,7,2,'N'),(54,7,3,'N'),(55,7,4,'N'),(56,8,4,'N'),(57,9,2,'N'),(58,9,3,'N'),(59,9,4,'N'),(60,10,2,'N'),(61,10,3,'N'),(62,10,4,'N'),(63,11,2,'N'),(64,11,3,'N'),(65,11,4,'N'),(66,12,2,'N'),(67,12,3,'N'),(68,12,4,'N'),(69,13,2,'N'),(70,13,3,'N'),(71,13,4,'N'),(72,14,2,'N'),(73,14,3,'N'),(74,14,4,'N'),(75,15,2,'N'),(76,15,3,'N'),(77,15,4,'N'),(78,16,2,'N'),(79,16,3,'N'),(80,16,4,'N'),(81,17,2,'N'),(82,17,3,'N'),(83,17,4,'N'),(84,18,2,'N'),(85,18,3,'N'),(86,18,4,'N'),(87,19,1,'N'),(88,19,2,'N'),(89,19,3,'N'),(90,20,1,'N'),(91,20,3,'N'),(92,20,4,'N'),(93,21,1,'N'),(94,21,3,'N'),(95,21,4,'N'),(96,22,4,'N'),(97,23,2,'N'),(98,23,3,'N'),(99,23,4,'N'),(100,24,2,'N'),(101,24,3,'N'),(102,24,4,'N'),(103,25,1,'N'),(104,25,3,'N'),(105,25,4,'N'),(106,26,2,'N'),(107,26,3,'N'),(108,26,4,'N'),(109,27,2,'N'),(110,27,3,'N'),(111,27,4,'N'),(112,28,2,'N'),(113,28,3,'N'),(114,28,4,'N'),(115,29,2,'N'),(116,29,3,'N'),(117,29,4,'N'),(118,30,2,'N'),(119,30,3,'N'),(120,30,4,'N');
/*!40000 ALTER TABLE `bkproyectoxobjetoestudio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cabeceracomprobante`
--

DROP TABLE IF EXISTS `cabeceracomprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cabeceracomprobante` (
  `IdCabeceraComprobante` int NOT NULL AUTO_INCREMENT,
  `IdProveedor` int DEFAULT NULL,
  `IdTipoDocumento` int DEFAULT NULL,
  `NumeroComprobante` varchar(20) DEFAULT NULL,
  `FechaEmision` varchar(10) DEFAULT NULL,
  `FechaVencimiento` varchar(10) DEFAULT NULL,
  `SubTotal` decimal(18,2) DEFAULT NULL,
  `Igv` decimal(18,2) DEFAULT NULL,
  `Total` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`IdCabeceraComprobante`),
  KEY `IdProveedor` (`IdProveedor`),
  KEY `IdTipoDocumento` (`IdTipoDocumento`),
  CONSTRAINT `cabeceracomprobante_ibfk_1` FOREIGN KEY (`IdProveedor`) REFERENCES `proveedores` (`IdProveedor`),
  CONSTRAINT `cabeceracomprobante_ibfk_2` FOREIGN KEY (`IdTipoDocumento`) REFERENCES `tiposdocumentos` (`IdTipoDocumento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cabeceracomprobante`
--

LOCK TABLES `cabeceracomprobante` WRITE;
/*!40000 ALTER TABLE `cabeceracomprobante` DISABLE KEYS */;
/*!40000 ALTER TABLE `cabeceracomprobante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cajachica`
--

DROP TABLE IF EXISTS `cajachica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cajachica` (
  `IdCajaChica` int NOT NULL AUTO_INCREMENT,
  `IdTransferenciaBancaria` int DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `Entrada` varchar(100) DEFAULT NULL,
  `Salida` varchar(100) DEFAULT NULL,
  `Saldo` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`IdCajaChica`),
  KEY `IdTransferenciaBancaria` (`IdTransferenciaBancaria`),
  CONSTRAINT `cajachica_ibfk_1` FOREIGN KEY (`IdTransferenciaBancaria`) REFERENCES `transferenciasbancarias` (`IdTransferenciaBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cajachica`
--

LOCK TABLES `cajachica` WRITE;
/*!40000 ALTER TABLE `cajachica` DISABLE KEYS */;
/*!40000 ALTER TABLE `cajachica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargos`
--

DROP TABLE IF EXISTS `cargos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargos` (
  `IdCargo` int NOT NULL AUTO_INCREMENT,
  `CodigoCargo` varchar(50) DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdCargo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargos`
--

LOCK TABLES `cargos` WRITE;
/*!40000 ALTER TABLE `cargos` DISABLE KEYS */;
INSERT INTO `cargos` VALUES (1,'CAR0001','Administración');
/*!40000 ALTER TABLE `cargos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carreras`
--

DROP TABLE IF EXISTS `carreras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carreras` (
  `IdCarrera` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  `codigoCarrera` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IdCarrera`)
) ENGINE=InnoDB AUTO_INCREMENT=1232 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carreras`
--

LOCK TABLES `carreras` WRITE;
/*!40000 ALTER TABLE `carreras` DISABLE KEYS */;
INSERT INTO `carreras` VALUES (1,'a','CAR000001'),(3,'c','CAR000003'),(4,'d','CAR000004'),(5,'e','CAR000005');
/*!40000 ALTER TABLE `carreras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `IdCategoria` int NOT NULL AUTO_INCREMENT,
  `CodigoCategoria` varchar(50) DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'CAT0001','Bizcochito'),(2,'CAT0002','Frente');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `CategoryID` int NOT NULL,
  `CategoryName` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `IdCliente` int NOT NULL AUTO_INCREMENT,
  `NombreEmpresa` varchar(100) DEFAULT NULL,
  `proyecto` varchar(16000) DEFAULT NULL,
  `TipoCliente` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'NAYLAMP INGENIEROS S.A.C','ESTUDIO DEFINITIVO DE LA VARIANTE DEL QAPAQ Ã‘AM AUTOPISTA PUNO-JULIACA, COMPONENTE PACRI','J'),(2,'CESEL S.A.','ELABORACION DEL ESTUDIO DE PERFIL , EVALUACION PRELIMINAR- EVAP Y LA INGENIERIA DE DETALLE DEL PROYECTO DEL CORREDOR VIAL APURIMAC-CUSCO  TRAMO 3','J'),(3,'NAYLAMP INGENIEROS S.A.C',' ESTUDIO DE PRE INVERSION A NIVEL DE FACTIBILIDAD DEL PROYECTO: MEJORAMIENTO A NIVEL DE AUTOPISTA Y/O PAR VIAL SECTOR 3 AREQUIPA-YURA','J'),(4,'NAYLAMP INGENIEROS S.A.C','ESTUDIO DE PRE INVERSION A NIVEL DE FACTIBILIDAD DEL PROYECTO: MEJORAMIENTO A NIVEL DE AUTOPISTA Y/O PAR VIAL SECTOR 4 YURA - PATAHUASI.','J'),(5,'NAYLAMP INGENIEROS S.A.C','ESTUDIO DEFINITIVO DE LA VARIANTE DE INGENIERIA DE LA SEGUNDA CALZADA DE LA AUTOPISTA PUNO JULIACA, AVANCE PACRI SEGUN PROPUESTA 0101020','J'),(6,'NAYLAMP INGENIEROS S.A.C','PROPUESTA TECNICA ECONOMICA DEL PROYECTO REHABILITACION DEL EJE VIAL NO. 1PIURA-GUAYAQUIL(06 OBRAS-14 PUENTES)','J'),(7,'NAYLAMP INGENIEROS S.A.C','PROPUESTA TECNICA ECONOMICA DEL PROYECTO CONSTRUCCION DE PUENTES POR REEMPLAZO EN LA ZONA NORTE DEL PAIS (02 OBRAS - 12 PUENTES)','J'),(8,'NAYLAMP INGENIEROS S.A.C','ESTUDIO DEFINITIVO DE LA VARIANTE DEINGENIERIA DE LA SEGUNDA CALZADA DE LA AUTOPISTA PUNO JULIACA - EXPEDIENTES INDIVIDUALES, CPE, ANALISIS SEGÃšN DL 1192','J'),(9,'CONSORCIO HIDRO-NAYLAMP','REFORMULACION DEL ESTUDIO DE PREINVERSION A NIVEL DE PERFIL: CONSTRUCCION DE LAVIA DE EVITAMIENTO A LA CIUDAD DE JUANJUI','J'),(10,'CESEL S.A.','ELABORACIÃ“N DEL COMPONENTE DE AFECTACIONES SEGÃšN DL 1192N Y MODIFICATORIAS DEL ESTUDIO DEFINITIVO PARA EL MEJORAMIENTO DEL CORREDOR VIAL APURÃMAC-CUSCO. TRAMO 3, SUBTRAMO 3','J'),(11,'PM PERU','ESTUDIO DE PREINVERSIÃ“N A NIVEL DE PERFIL DEL PROYECTO DE LA CARRETERA HUANCAVELICA â€“ EMP. PE â€“ 3S, TRAMO: LIRCAY â€“ LAGUNILLAS â€“ EMP. RUTA PE â€“ 3S','J'),(12,'PM PERU','ESTUDIO DE PRE INVERSIÃ“N A NIVEL DE PERFIL DE LA CARRETERA PTE PALLAR â€“ PTE CHAGUAL','J'),(13,'GEOCONSULT-PM PERU','ESTUDIO DE PREINVERSION A NIVEL DE PERFIL, CARRETERA LONGITUDINAL DE LA SIERRA, TRAMO IV, PROYECTO GE 006 â€“ 17 HUANCAYO - IZCUCHACA','J'),(14,'EPCM - CONSULTING SAC','Elaboracion del estudio de interferencias para el proyecto del puente Pichari.','J'),(15,'CONSORCIO EPCM-GEOCONSULT','PAC estudio definitivo para la construccion y mejoramiento de la via evitamiento de Huancayo.','J'),(16,'ECOCEL SAC','Servicio de monitoreo ambiental en el paso a desnivel de cerro blanco.','J'),(17,'ECOCEL SAC','Servicio de monitoreo ambiental 8 puentes.','J'),(18,'SIGT','Mejoramiento del corredor vial Apurimac.','J'),(19,'CROVISA','Mejoramiento de los jirones OyÃ³n, Iquitos, VÃ­ctor AndrÃ©s.','J'),(20,'GEOMETRICA','Estudio de afectaciones Prediales','J'),(21,'CONSORCIO PERUANO PUENTES PIURA','Estudio de plan de afectaciones y compensaciones prediales.','J'),(23,'GEOMETRICA','Proyecto cumbil chotano','J'),(24,'CONSORCIO PERUANO PUENTES PIURA','ConstrucciÃ³n de 11 puentes de carretera en la red vial nacional, ruta PE-1NR en el tramo Tambogrande-Morropon-Chulucanas, departamento Piura.','J'),(25,'CONSORCIO PUENTES  Norte (Jack Lopez y Naylamp)','ConstrucciÃ³n de Puentes por reemplazo en Ancash','J'),(26,'PM PERU','Estudio definitivo para la rehabilitaciÃ³n y mejoramiento de la carretera empalme ruta AN111-Huamnin-Progreso-Poque-Llata-Cochapata (TÃºnal Taytamayo)- Nuevas Flores-Quivilla-Tingo Chico  ','J'),(27,'PM PERU','ConstrucciÃ³n de 11 puentes en la red vÃ­al nacional, ruta PE-1NR en el tramo Tambogrande hasta Puente la PeÃ±a km 60+000.','J'),(28,'NAYLAMP INGENIEROS S.A.C','Estudio definitivo de la variante de ingenierÃ­a de la segunda calzada de la autopista Puno Juliaca.','J'),(29,'PM PERU','Estudio de preinversion a nivel de perfil de la carretera PE-5NC, nuevo Siasme-Saramiriza','J');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comunicaciones`
--

DROP TABLE IF EXISTS `comunicaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comunicaciones` (
  `IdComunicacion` int NOT NULL AUTO_INCREMENT,
  `IdPeriodo` int DEFAULT NULL,
  `NombreProyecto` varchar(100) DEFAULT NULL,
  `Tipo` int DEFAULT NULL,
  `CodDoc` varchar(100) DEFAULT NULL,
  `Origen` varchar(100) DEFAULT NULL,
  `Destino` varchar(100) DEFAULT NULL,
  `Flujo` int DEFAULT NULL,
  `Asunto` mediumtext,
  `Fecha` date DEFAULT NULL,
  `CodDocRespuesta` varchar(100) DEFAULT NULL,
  `estado` int DEFAULT NULL,
  `Enlace` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`IdComunicacion`),
  KEY `IdPeriodo` (`IdPeriodo`),
  CONSTRAINT `comunicaciones_ibfk_1` FOREIGN KEY (`IdPeriodo`) REFERENCES `periodos` (`IdPeriodo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comunicaciones`
--

LOCK TABLES `comunicaciones` WRITE;
/*!40000 ALTER TABLE `comunicaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `comunicaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contactos`
--

DROP TABLE IF EXISTS `contactos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contactos` (
  `IdContacto` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) DEFAULT NULL,
  `FechaNacimiento` varchar(10) DEFAULT NULL,
  `PersonasRelacionadas` varchar(100) DEFAULT NULL,
  `Empresa` varchar(100) DEFAULT NULL,
  `Cuentas` varchar(100) DEFAULT NULL,
  `Clave` varchar(100) DEFAULT NULL,
  `Cargo` varchar(100) DEFAULT NULL,
  `Correo` varchar(100) DEFAULT NULL,
  `Telefono` char(9) DEFAULT NULL,
  `Departamento` varchar(100) DEFAULT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `Notas` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdContacto`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactos`
--

LOCK TABLES `contactos` WRITE;
/*!40000 ALTER TABLE `contactos` DISABLE KEYS */;
INSERT INTO `contactos` VALUES (1,'Ivan','25/04/2025','','GM Ingenieros','','','Tecnico','ivan.atanacio@gmail.com','923227609','Loreto','Av. Venezuela 685 Of. 1012',''),(2,'Yuri Cesar Atanacio Anchiraico','25/04/2025','','GM Ingenieros','','','Director General','yuri.atanacio@gmingenieros.com.pe','991231114','Lima','Av. Venezuela 685 Of. 1013',''),(3,'Raul PeÃ±a Olano','','','OHLA','','','Gerente Legal ','rpena@ohla-peru.pe','986670093','Lima','Av. 28 de Julio NÂ°150 Planta 7','Proyecto Red Vial y Rio Lacramarca'),(4,'Milagros Gutierrez Mendoza','','','OHLA','','','null','mgutierrez@ohla-peru.pe',' null','Lima','Av. 28 de Julio NÂ°150 Planta 7','Proyecto Red Vial y Rio Lacramarca'),(5,'Josseline Gianina Llerena Morales De Estrada','','','OHLA','','','null','JOSSELINE.LLERENA@ohla-peru.pe',' null','Lima','Av. 28 de Julio NÂ°150 Planta 7','Proyecto Red Vial y Rio Lacramarca'),(6,'Cintya Escobar Masco','','','OHLA','','','Jefa de Administracion','cintya.escobar@ohla-peru.pe','516257200','Lima','Av. 28 de Julio NÂ°150 Planta 8','Proyecto Red Vial y Rio Lacramarca'),(7,'Jose A. Mayoral Vicente','','','OHLA','','','Coordinador de Proyectos','jmayoral@ohla-peru.pe','949091367','Lima','Av. 28 de Julio NÂ°150 Planta 7','Proyecto Red Vial y Rio Lacramarca'),(8,'Cary Vilchez CastaÃ±eda','','','FCISA','','','Gerente General','cary.vilchez@fcisa.com','987119201','Lima','Av.Tacna 685, oficinas 174 y 181','Proyecto Santa Rosa'),(9,'Eveling Baca Custodio','','','FCISA','','','Gestor Legal','eveling.baca@fcisa.com','984785709','Lima','Av.Tacna 685, oficinas 174,181 y 182','Proyecto Santa Rosa'),(10,'Jennifer Guadalupe Rowe','','','FCISA','','','Gerente de Operaciones ','jennifer.guadalupe@fcisa.com','943603594','Lima','Av.Tacna 685, oficinas 174,181 y 182','Proyecto Santa Rosa'),(11,'Wilder Casimir Manuelo ','','','FCISA','','','Gestor de Proyectos Ambientales','wilder.casimir@fcisa.com','987734508','Lima','Av.Tacna 685, oficinas 174,181 y 182','Proyecto Santa Rosa'),(12,'Jose Miguel Manco Allende','','','FCISA','','','Contabilidad','contabilidad@fcisa.com','978046942','Lima','Av.Tacna 685, oficinas 174,181 y 182','Proyecto Santa Rosa'),(13,'Heyssy Mendoza Campos ','','','FCISA','','','Asistente Ssoma','ssoma@fcisa.com','4286301','Lima','Av.Tacna 685, oficinas 174,181 y 182','Proyecto Santa Rosa'),(14,'Yvan Diaz Velasquez','','','FCISA','','','Administrador','administracion@fcisa.com','4286301','Lima','Av.Tacna 685, oficinas 174,181 y 182','Proyecto Santa Rosa'),(15,'Juan Flores Mango','','','GrupoTYPSA','','','Departamento de Obras Lineales','jpflores@typsa.es ','997502924','Lima','Av. 28 de Julio 1044, piso 5Â ','Proyecto TYPSA'),(16,'Johanna Guevara De la Cruz','','','GrupoTYPSA','','','Asistente Administrativa','mjguevara@typsa.esÂ ','979394568','Lima','Av. 28 de Julio 1044, piso 5Â ','Proyecto TYPSA'),(17,'Rosario HernÃ¡ndez Cabrera','','','GrupoTYPSA','','','CoordinaciÃ³n de Proyectos','mhernandez@typsa.es','955971203','Lima','Av. 28 de Julio 1044, piso 5Â ','Proyecto TYPSA'),(18,'Giannina Gonzales Martinez','','','GrupoTYPSA','','','Control Documentario','gpgonzales@typsa.es','936018303','Lima','Av. 28 de Julio 1044, piso 5Â ','Proyecto TYPSA'),(19,'Luis Andres Vicente Luyo','','','GrupoTYPSA','','','Coordinador de diseÃ±o MT/BT','lavicente@typsa.es','953258438','Lima','Av. 28 de Julio 1044, piso 5Â ','Proyecto TYPSA'),(20,'Maria Anabell Rodriguez Sueros','','','CONSORCIO NAYLAMP','','','Coordinadora de Administracion','administracion@naylampingenieros.pe','16975082','Lima','Jr. Luis Saenz NÂ°150 Urb.Santa Catalina','PROYECTO 11 PUENTES'),(21,'Jorge Fernando Luna Huaman','','','PM PERU','','','Representante Legal','jluna@pmperu.com.pe','14400783','Lima','Av. Los Quechuas NÂ°1336 of. 301- Ate','Proy Lircay, Pte Pallar, Saramiriza'),(22,'Nathy Alfaro MuÃ±oz','','','Geometrica SAC','','','Coordinador de Proyectos','nathy.alfaro@geometrica.com','null','Lima','Av. Paz Soldan 170 INT. 207','Proyecto Quinua y Puente Cumbil'),(23,'Julissa Mejia Camacho','','','Geometrica SAC','','','Administrativa','julissa.camacho@geometrica.com.pe','2217719','Lima','Av. Paz Soldan 170 INT. 208','Proyecto Quinua y Puente Cumbil'),(24,'Marco Antonio Quispe Berrocal','','','GBO INGENIEROS SAC','','','null','gboingenieros@gmail.com','964765184','Callao','Otr. Los Angeles de Oquendo - Prov Callao','Proyecto San Marcos'),(25,'Miguel Yapuchura Cayllahua','','','HARIUS SAC','','','null','ing.mayapuchura@gmail.com','null','Lima','Cal. Santiago Crespo 100 Urb El Trebol','Proyecto Puquina y Anda'),(26,'Victor Salinas','','','FRESNILLO PERU SAC','','','Jefe de Exploraciones','null','null','Cajamarca','Av. Republica de Colombia NÂ° 643 INT 901 B','Estudio de culminacion de carretara de la Sierra'),(27,'Jandy Sanchez','','','FRESNILLO PERU SAC','','','Area Legal','null','null','Cajamarca','Av. Republica de Colombia NÂ° 643 INT 901 B','Estudio de culminacion de carretara de la Sierra'),(28,'sss','','ss','sss','','','sss','sss','111','Ucayali','s','sss');
/*!40000 ALTER TABLE `contactos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contratantes`
--

DROP TABLE IF EXISTS `contratantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contratantes` (
  `IdContratante` int NOT NULL AUTO_INCREMENT,
  `NombreEmpresa` varchar(200) NOT NULL,
  `Tipo` varchar(10) DEFAULT NULL,
  `Direccion` varchar(200) DEFAULT NULL,
  `NroDocumento` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`IdContratante`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contratantes`
--

LOCK TABLES `contratantes` WRITE;
/*!40000 ALTER TABLE `contratantes` DISABLE KEYS */;
INSERT INTO `contratantes` VALUES (1,'CESEL S.A.',NULL,NULL,NULL),(2,'CONSORCIO EPCM-GEOCONSULT',NULL,NULL,NULL),(3,'CONSORCIO HIDRO-NAYLAMP',NULL,NULL,NULL),(4,'CONSORCIO PERUANO PUENTES PIURA',NULL,NULL,NULL),(5,'CONSORCIO PUENTES  Norte (Jack Lopez y Naylamp)',NULL,NULL,NULL),(6,'CROVISA',NULL,NULL,NULL),(7,'ECOCEL SAC',NULL,NULL,NULL),(8,'EPCM - CONSULTING SAC',NULL,NULL,NULL),(9,'GEOCONSULT-PM PERU',NULL,NULL,NULL),(10,'GEOMETRICA',NULL,NULL,NULL),(11,'NAYLAMP INGENIEROS S.A.C',NULL,NULL,NULL),(12,'PM PERU',NULL,NULL,NULL),(13,'SIGT',NULL,NULL,NULL),(14,'GESTOP SOL. INTERGALES SAC',NULL,NULL,NULL),(15,'CONSULTORES Y CONSTRUCTORES CARE SAC',NULL,NULL,NULL),(16,'PYUNGHWA ENGINEERING CONSULTANTS LTD. SUCURSAL DEL PER (PEC PERU)','','',''),(17,'CONSORCIO NIVAFESTSA ENVIROMENT','','',''),(18,'CONSORCIO VIAL QUEROCOTILLO','','',''),(19,'CONSORCIO PUENTE RIO ENE','','','');
/*!40000 ALTER TABLE `contratantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contratos`
--

DROP TABLE IF EXISTS `contratos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contratos` (
  `IdContrato` int NOT NULL AUTO_INCREMENT,
  `FechaInicio` date DEFAULT NULL,
  `DisponibilidadHorario` varchar(100) DEFAULT NULL,
  `DisponibilidadViaje` char(1) DEFAULT NULL,
  `Experiencia` char(1) DEFAULT NULL,
  `FechaFin` date DEFAULT NULL,
  `IdEmpleado` int DEFAULT NULL,
  PRIMARY KEY (`IdContrato`),
  KEY `IdEmpleado` (`IdEmpleado`),
  CONSTRAINT `contratos_ibfk_1` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleados` (`IdEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contratos`
--

LOCK TABLES `contratos` WRITE;
/*!40000 ALTER TABLE `contratos` DISABLE KEYS */;
/*!40000 ALTER TABLE `contratos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contratosdeproyectos`
--

DROP TABLE IF EXISTS `contratosdeproyectos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contratosdeproyectos` (
  `IdContratoProyecto` int NOT NULL,
  `IdProyecto` int NOT NULL,
  `NroDocumentoProyecto` varchar(100) DEFAULT NULL,
  `IdContratante1` int NOT NULL,
  `FechaInicio` date DEFAULT NULL,
  `FechaFin` date DEFAULT NULL,
  `ImporteTotal` decimal(18,2) DEFAULT NULL,
  `Estado` char(1) DEFAULT NULL,
  `Observacion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`IdContratoProyecto`),
  KEY `IdProyecto` (`IdProyecto`),
  KEY `IdContratante1` (`IdContratante1`),
  CONSTRAINT `contratosdeproyectos_ibfk_1` FOREIGN KEY (`IdProyecto`) REFERENCES `proyectos` (`IdProyecto`),
  CONSTRAINT `contratosdeproyectos_ibfk_2` FOREIGN KEY (`IdContratante1`) REFERENCES `contratantes` (`IdContratante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contratosdeproyectos`
--

LOCK TABLES `contratosdeproyectos` WRITE;
/*!40000 ALTER TABLE `contratosdeproyectos` DISABLE KEYS */;
INSERT INTO `contratosdeproyectos` VALUES (1,8,'11',1,'2022-11-01','2023-11-08',10000.00,'A','proyecto no terminado debido a pago no realizado por el contratante.');
/*!40000 ALTER TABLE `contratosdeproyectos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credenciales`
--

DROP TABLE IF EXISTS `credenciales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credenciales` (
  `IdCredencial` int NOT NULL AUTO_INCREMENT,
  `Correo` varchar(200) DEFAULT NULL,
  `Clave` varchar(200) DEFAULT NULL,
  `Alias` varchar(100) DEFAULT NULL,
  `Descripcion` varchar(200) DEFAULT NULL,
  `codigoCredencial` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IdCredencial`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credenciales`
--

LOCK TABLES `credenciales` WRITE;
/*!40000 ALTER TABLE `credenciales` DISABLE KEYS */;
INSERT INTO `credenciales` VALUES (1,'gmingenieros@gmingenieros.com','221322','ninguno','ninguno','CRE000001'),(2,'carlossa@gmail.com','332121','ninguno','ninguno','CRE000002'),(3,'gomezibiza@gmail.com','221343','ninguno','ninguno','CRE000003'),(4,'datatech@gmail.com','332121','ninguno','ninguno','CRE000004');
/*!40000 ALTER TABLE `credenciales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentasbancarias`
--

DROP TABLE IF EXISTS `cuentasbancarias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentasbancarias` (
  `IdCuentaBancaria` int NOT NULL AUTO_INCREMENT,
  `IdBanco` int DEFAULT NULL,
  `TipoPropietario` char(7) DEFAULT NULL,
  `Nombres` varchar(50) DEFAULT NULL,
  `NroCuenta` varchar(50) DEFAULT NULL,
  `NroCuentaInterbancaria` varchar(50) DEFAULT NULL,
  `TipoMoneda` char(1) DEFAULT NULL,
  `FechaCreacion` date DEFAULT NULL,
  PRIMARY KEY (`IdCuentaBancaria`),
  KEY `IdBanco` (`IdBanco`),
  CONSTRAINT `cuentasbancarias_ibfk_1` FOREIGN KEY (`IdBanco`) REFERENCES `bancos` (`IdBanco`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentasbancarias`
--

LOCK TABLES `cuentasbancarias` WRITE;
/*!40000 ALTER TABLE `cuentasbancarias` DISABLE KEYS */;
INSERT INTO `cuentasbancarias` VALUES (1,1,'P','Carlos Bustamante','121545988752','9282112991921','D','2025-04-24'),(2,1,'P','asd','12','12','S','2025-04-24');
/*!40000 ALTER TABLE `cuentasbancarias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamentos` (
  `IdDepartamento` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(100) DEFAULT NULL,
  `codigoDepartamento` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IdDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` VALUES (1,'Amazonas','DEP000001'),(2,'Ancash','DEP000002'),(3,'Apurimac','DEP000003'),(4,'Arequipa','DEP000004'),(5,'Ayacucho','DEP000005'),(6,'Cajamarca','DEP000006'),(7,'Callao','DEP000007'),(8,'Cusco','DEP000008'),(9,'Huancavelica','DEP000009'),(10,'Huanuco','DEP000010'),(11,'Ica','DEP000011'),(12,'Junin','DEP000012'),(13,'La Libertad','DEP000013'),(14,'Lambayeque','DEP000014'),(15,'Lima','DEP000015'),(16,'Loreto','DEP000016'),(17,'Madre de Dios','DEP000017'),(18,'Moquegua','DEP000018'),(19,'Pasco','DEP000019'),(20,'Piura','DEP000020'),(21,'Puno','DEP000021'),(22,'San Martin','DEP000022'),(23,'Tacna','DEP000023'),(24,'Tumbes','DEP000024'),(25,'Ucayali','DEP000025');
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalles_asistencia`
--

DROP TABLE IF EXISTS `detalles_asistencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalles_asistencia` (
  `IdDetalleAsistencia` int NOT NULL AUTO_INCREMENT,
  `IdAsistencia` int DEFAULT NULL,
  `IdEmpleado` int DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `Hora_Entrada` time DEFAULT NULL,
  `Hora_Salida` time DEFAULT NULL,
  `Duracion` time DEFAULT NULL,
  `Observaciones` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdDetalleAsistencia`),
  KEY `IdAsistencia` (`IdAsistencia`),
  KEY `IdEmpleado` (`IdEmpleado`),
  CONSTRAINT `detalles_asistencia_ibfk_1` FOREIGN KEY (`IdAsistencia`) REFERENCES `asistencias` (`IdAsistencia`),
  CONSTRAINT `detalles_asistencia_ibfk_2` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleados` (`IdEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=382 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalles_asistencia`
--

LOCK TABLES `detalles_asistencia` WRITE;
/*!40000 ALTER TABLE `detalles_asistencia` DISABLE KEYS */;
INSERT INTO `detalles_asistencia` VALUES (255,1593,1,'2022-10-03','08:57:34','11:48:49','02:51:15',NULL),(256,1595,1,'2022-10-05','13:50:16','16:06:50','02:16:34',NULL),(257,1597,1,'2022-10-06','08:42:52','15:33:40','06:50:48',NULL),(258,1599,1,'2022-10-07','08:51:47','15:29:02','06:37:15',NULL),(259,1601,1,'2022-10-10','12:54:58','15:55:08','03:00:10',NULL),(260,1603,1,'2022-10-13','09:49:50','15:35:41','05:45:51',NULL),(261,1605,1,'2022-10-14','09:01:10','15:59:52','06:58:42',NULL),(262,1607,1,'2022-10-17','16:00:20',NULL,NULL,NULL),(263,1608,1,'2022-10-24','09:00:28',NULL,NULL,NULL);
/*!40000 ALTER TABLE `detalles_asistencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `IdEmpleado` int NOT NULL,
  `IdCarrera` int DEFAULT NULL,
  `IdInstitucionEducativa` int DEFAULT NULL,
  `IdArea` int DEFAULT NULL,
  `IdFacultad` int DEFAULT NULL,
  `IdTipoEmpleado` int DEFAULT NULL,
  `IdCargo` int DEFAULT NULL,
  `Apellidos` varchar(100) DEFAULT NULL,
  `Nombres` varchar(100) DEFAULT NULL,
  `FechaNacimiento` date DEFAULT NULL,
  `Correo` varchar(100) DEFAULT NULL,
  `Dni` char(8) DEFAULT NULL,
  `Celular` char(9) DEFAULT NULL,
  `Distrito` varchar(50) DEFAULT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `CodigoEstudiante` varchar(20) DEFAULT NULL,
  `Ciclo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`IdEmpleado`),
  KEY `IdCarrera` (`IdCarrera`),
  KEY `IdInstitucionEducativa` (`IdInstitucionEducativa`),
  KEY `IdArea` (`IdArea`),
  KEY `IdFacultad` (`IdFacultad`),
  KEY `IdTipoEmpleado` (`IdTipoEmpleado`),
  KEY `IdCargo` (`IdCargo`),
  CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`IdCarrera`) REFERENCES `carreras` (`IdCarrera`),
  CONSTRAINT `empleados_ibfk_2` FOREIGN KEY (`IdInstitucionEducativa`) REFERENCES `institucioneseducativas` (`IdInstitucionEducativa`),
  CONSTRAINT `empleados_ibfk_3` FOREIGN KEY (`IdArea`) REFERENCES `areas` (`IdArea`),
  CONSTRAINT `empleados_ibfk_4` FOREIGN KEY (`IdFacultad`) REFERENCES `facultades` (`IdFacultad`),
  CONSTRAINT `empleados_ibfk_5` FOREIGN KEY (`IdTipoEmpleado`) REFERENCES `tiposempleados` (`IdTipoEmpleado`),
  CONSTRAINT `empleados_ibfk_6` FOREIGN KEY (`IdCargo`) REFERENCES `cargos` (`IdCargo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,1,1,1,1,1,1,'Sanchez','Carlos','2000-11-10','sadawd','70269937','15125','sjl','asd','u3923','6'),(2,1,1,1,1,1,1,'Arias','Manuel','1999-08-20','sssss','74540865','9555','sjl','sad','asd21','7');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experiencialaboral`
--

DROP TABLE IF EXISTS `experiencialaboral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `experiencialaboral` (
  `IdExperienciaLaboral` int NOT NULL AUTO_INCREMENT,
  `Empresa` varchar(100) DEFAULT NULL,
  `FechaInicio` date DEFAULT NULL,
  `FechaFin` date DEFAULT NULL,
  `CargoAnterior` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdExperienciaLaboral`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experiencialaboral`
--

LOCK TABLES `experiencialaboral` WRITE;
/*!40000 ALTER TABLE `experiencialaboral` DISABLE KEYS */;
/*!40000 ALTER TABLE `experiencialaboral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facultades`
--

DROP TABLE IF EXISTS `facultades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facultades` (
  `IdFacultad` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(100) DEFAULT NULL,
  `codigoFacultad` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IdFacultad`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facultades`
--

LOCK TABLES `facultades` WRITE;
/*!40000 ALTER TABLE `facultades` DISABLE KEYS */;
INSERT INTO `facultades` VALUES (1,'adminstración','FAC000001'),(2,'ingenieria','FAC000002'),(3,'negocios','FAC000003'),(4,'qwd','FAC000004');
/*!40000 ALTER TABLE `facultades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institucioneseducativas`
--

DROP TABLE IF EXISTS `institucioneseducativas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `institucioneseducativas` (
  `IdInstitucionEducativa` int NOT NULL AUTO_INCREMENT,
  `Ruc` char(20) DEFAULT NULL,
  `RazonSocial` varchar(100) DEFAULT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `Sede` varchar(100) DEFAULT NULL,
  `codigoInstituciones` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IdInstitucionEducativa`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institucioneseducativas`
--

LOCK TABLES `institucioneseducativas` WRITE;
/*!40000 ALTER TABLE `institucioneseducativas` DISABLE KEYS */;
INSERT INTO `institucioneseducativas` VALUES (1,'2141241','biotech','av palmeras','San juan de miraflores','INS000001'),(2,'4124124','Medicast','av piramides','San borja','INS000002');
/*!40000 ALTER TABLE `institucioneseducativas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `listar_vista_comunicaciones`
--

DROP TABLE IF EXISTS `listar_vista_comunicaciones`;
/*!50001 DROP VIEW IF EXISTS `listar_vista_comunicaciones`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `listar_vista_comunicaciones` AS SELECT 
 1 AS `Id`,
 1 AS `IdPeriodo`,
 1 AS `NombreProyecto`,
 1 AS `Tipo`,
 1 AS `TipoDesc`,
 1 AS `CodDoc`,
 1 AS `Origen`,
 1 AS `Destino`,
 1 AS `Flujo`,
 1 AS `FlujoDesc`,
 1 AS `Asunto`,
 1 AS `Fecha`,
 1 AS `CodDocRespuesta`,
 1 AS `Estado`,
 1 AS `EstadoDesc`,
 1 AS `Enlace`,
 1 AS `Dias`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marcas` (
  `IdMarca` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`IdMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas`
--

LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` VALUES (1,'GENERICO'),(2,'ORIGINAL');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulos`
--

DROP TABLE IF EXISTS `modulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modulos` (
  `IdModulo` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdModulo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulos`
--

LOCK TABLES `modulos` WRITE;
/*!40000 ALTER TABLE `modulos` DISABLE KEYS */;
INSERT INTO `modulos` VALUES (1,'Recursos Humanos'),(2,'Proyectos'),(3,'Compras'),(4,'pruebas');
/*!40000 ALTER TABLE `modulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `objetosestudio`
--

DROP TABLE IF EXISTS `objetosestudio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `objetosestudio` (
  `IdObjetoEstudio` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`IdObjetoEstudio`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objetosestudio`
--

LOCK TABLES `objetosestudio` WRITE;
/*!40000 ALTER TABLE `objetosestudio` DISABLE KEYS */;
INSERT INTO `objetosestudio` VALUES (1,'predial'),(2,'ambiental'),(3,'social'),(4,'interferencia');
/*!40000 ALTER TABLE `objetosestudio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodos`
--

DROP TABLE IF EXISTS `periodos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodos` (
  `IdPeriodo` int NOT NULL AUTO_INCREMENT,
  `Mes` int DEFAULT NULL,
  `Anio` int DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `Alias` varchar(6) DEFAULT NULL,
  `codigoPeriodo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IdPeriodo`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodos`
--

LOCK TABLES `periodos` WRITE;
/*!40000 ALTER TABLE `periodos` DISABLE KEYS */;
INSERT INTO `periodos` VALUES (1,1,2025,'Enero','012025','PER000001');
/*!40000 ALTER TABLE `periodos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `IdProveedor` int NOT NULL AUTO_INCREMENT,
  `IdDepartamento` int NOT NULL,
  `Nombres` varchar(100) DEFAULT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `Correo` varchar(100) DEFAULT NULL,
  `Telefono` char(20) DEFAULT NULL,
  `Ruc` char(11) DEFAULT NULL,
  `codigoProveedor` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IdProveedor`),
  KEY `IdDepartamento` (`IdDepartamento`),
  CONSTRAINT `proveedores_ibfk_1` FOREIGN KEY (`IdDepartamento`) REFERENCES `departamentos` (`IdDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,23,'Juan Zapata','av jardines','Juanzap@gmail.com','929854754','10232184321','PRO000001'),(2,25,'Richard Gomez','jr educacion','gomezric@gmail.com','924455141','10542566431','PRO000002');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyectos`
--

DROP TABLE IF EXISTS `proyectos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyectos` (
  `IdProyecto` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(5000) DEFAULT NULL,
  `Alias` varchar(500) DEFAULT NULL,
  `Servicio` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`IdProyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectos`
--

LOCK TABLES `proyectos` WRITE;
/*!40000 ALTER TABLE `proyectos` DISABLE KEYS */;
INSERT INTO `proyectos` VALUES (1,'PROYECTO AQP - YURA','','MEJORAMIENTO A NIVEL DE AUTOPISTA Y/O PAR VIAL SECTOR 3 AREQUIPA-YURA'),(2,'PROYECTO YURA-PATAHUASI','','ESTUDIO DE PRE INVERSION A NIVEL DE FACTIBILIDAD DEL\nPROYECTO: MEJORAMIENTO A NIVEL DE AUTOPISTA Y/O PAR VIAL SECTOR 4 YURA - PATAHUASI.'),(3,'PROY. 2da. CALZADA JULIACA-PUNO-AVANCE PACRI PTE 0101020','','ESTUDIO DEFINITIVO DE LA VARIANTE DE INGENIERIA DE LA SEGUNDA CALZADA DE LA\nAUTOPISTA PUNO JULIACA, AVANCE PACRI SEGUN PROPUESTA 0101020'),(4,'REHABILITACION DEL EJE VIAL NÂ° 1 PIURA - GUAYAQUIL (06 OBRAS - 14 PUENTES)','','PROPUESTA TECNICA ECONOMICA DEL PROYECTO REHABILITACION DEL EJE VIAL NO. 1\nPIURA-GUAYAQUIL(06 OBRAS-14 PUENTES)'),(5,'CONSTRUCCION DE PUENTES POR REEMPLAZO EN LA ZONA NORTE DEL PAIS (02 OBRAS - 12 PUENTES)','','PROPUESTA TECNICA ECONOMICA DEL PROYECTO CONSTRUCCION DE PUENTES POR\nREEMPLAZO EN LA ZONA NORTE DEL PAIS (02 OBRAS - 12 PUENTES)'),(6,'ESTUDIO DEF. VARIANTE DE ING. DE LA 2DA. CALZADA AUTOPISTA VARIANTE QAPAQ Ã‘AM AUTOPISTA PUNO-JLC, EXP. INDIVIDUALES, CPE, ANALISIS SEGÃšN DL 1192, PROPUESTA 01010021','','ESTUDIO DEFINITIVO DE LA VARIANTE DEINGENIERIA DE LA SEGUNDA CALZADA DE LA AUTOPISTA PUNO JULIACA - EXPEDIENTES INDIVIDUALES, CPE, ANALISIS SEGÃšN DL 1192'),(7,'Estudio definitivo de la variante de ingenierÃ­a de la segunda calzada de la autopista Puno Juliaca.','','Servicio de arquitectura e ingenieria'),(8,'CORREDOR VIAL APURIMAC - CUSCO TRAMO 3 SUB-TRAMO 3','','ELABORACIÃ“N DEL COMPONENTE DE AFECTACIONES SEGÃšN DL 1192N Y MODIFICATORIAS DEL ESTUDIO DEFINITIVO PARA EL MEJORAMIENTO DEL CORREDOR VIAL APURÃMAC-CUSCO. TRAMO 3, SUBTRAMO 3'),(9,'EV. HUANCAYO','','PAC estudio definitivo para la construccion y mejoramiento de la via evitamiento de Huancayo.'),(10,'Servicio de reformulacion del estudio de pre inversion a nivel de perfil; construccion de la via de evitamiento de la ciudad de juanjui','','REFORMULACION DEL ESTUDIO DE PREINVERSION A NIVEL DE PERFIL: CONSTRUCCION DE LAVIA DE EVITAMIENTO A LA CIUDAD DE JUANJUI'),(11,'ConstrucciÃ³n de 11 puentes de carretera en la red vial nacional, ruta PE-1NR en el tramo Tambogrande-Morropon-Chulucanas, departamento Piura.','','Estudio de plan de afectaciones y compensaciones prediales.'),(12,'ConstrucciÃ³n de Puentes por reemplazo en Ancash','',''),(13,'Estudio de perfil y definitvamente para la rehabilitaciÃ³n y mejoramiento de los caminos vecinales tramo1:EMP.5N (Naranjos)-el Diamante-San AgustÃ­n-Oriente Nuevo;Tramo2:EMP.5N(Angaiza)-Vista Alegre-Ricardo palma-Buenos Aires-EMP.SM-516;Tramo 3:EMP.5N(El Porvenir)-Ramiro PrialÃ© -Nueva esperanza.','','Estudio de mejoramiento de caminos vecinal    '),(14,'Estudio definitivo del proyecto: Mejoramiento del servicio de transitabilidad desde el puente amarillo-Cruce BayÃ³var-Distrito de Olmos-Provincia de Lambayeque-Departamento de Lambayeque.','','Mejoramiento del servicio de transitibilidad desde pte. Amarillo-Cruce Bayovar.'),(15,'PROYECTO LIRCAY - LAGUNILLAS','','ESTUDIO DE PREINVERSIÃ“N A NIVEL DE PERFIL DEL PROYECTO DE LA CARRETERA HUANCAVELICA â€“ EMP. PE â€“ 3S, TRAMO: LIRCAY â€“ LAGUNILLAS â€“ EMP. RUTA PE â€“ 3S'),(16,'PROYECTO PTE PALLAR - PTE CHAGUAL','','ESTUDIO DE PRE INVERSIÃ“N A NIVEL DE PERFIL DE LA CARRETERA PTE PALLAR â€“ PTE CHAGUAL'),(17,'PROYECTO HYO.-IZCUCHACA','','ESTUDIO DE PREINVERSION A NIVEL DE PERFIL, CARRETERA LONGITUDINAL DE LA SIERRA, TRAMO IV, PROYECTO GE 006 â€“ 17 HUANCAYO - IZCUCHACA'),(18,'ESTUDIO DE IMPACTO VIAL CAMPOSANTO ANCON','','ESTUDIO DE IMPACTO VIAL CAMPOSANTO ANCON'),(19,'PROYECTO PUENTE PICHARI','','Elaboracion del estudio de interferencias para el proyecto del puente Pichari.'),(20,'SERVICIO DE MONITOREO AMBIENTAL EN EL PASO A DESNIVEL DE CERRO BLANCO','','Servicio de monitoreo ambiental en el paso a desnivel de cerro blanco.'),(21,'SERVICIO DE MONITOREO AMBIENTAL 8 PUENTES','','Servicio de monitoreo ambiental 8 puentes.'),(22,'CORREDOR VIAL APURIMAC - CUSCO TRAMO 1 Y 2','','Mejoramiento del corredor vial Apurimac.'),(23,'SAN MARTIN','','SERVICIO DE ELABORACION DE 26 EXPEDIENTES Y BUSQUEDA CATASTRAL PARA EL PROYECTO QUEBRADA LEON - P008-07-2021-BESALCO-05'),(24,'OLMOS','','COMPONENTE DE IMPACTO AMBIENTAL -MEJORAMIENTO DE SERVICIO DE TRANSITIBIDAD DESDE EL PTE AMARILLO-CRUCE BAYOVAR-DIST DE OLMOS PROVINCIA DE LAMBAYEQUE DPT DE LAMBAYEQUE'),(25,'Mejoramiento de los jirones OyÃ³n, Iquitos, VÃ­ctor AndrÃ©s ','','Mejoramiento de los jirones OyÃ³n, Iquitos, VÃ­ctor AndrÃ©s.'),(26,'ELABORACIÃ“N DEL EXPEDIENTE TÃ‰CNICO PARA LA EVALUACIÃ“N Y TRATAMIENTO DE LOS SECTORES CRÃTICOS DE LA CARRETERA: QUINUA â€“ SAN FRANCISCO, TRAMO 2: KM. 78+500 (CHALHUAMAYO) â€“ KM. 172+420 (SAN FRANCISCO) ','','ESTUDIO DE IMPACTO Y MONITOREO AMBIENTAL PARA LOS SECTORES CRITICOS EN CARRETERA:QUINUA- SAN FRANCISCO '),(27,'PROYECTO CUMBIL - CHOTANO','','Estudio de afectaciones Prediales'),(28,'Estudio definitivo para la rehabilitaciÃ³n y mejoramiento de la carretera empalme ruta AN111-Huamnin-Progreso-Poque-Llata-Cochapata (TÃºnal Taytamayo)- Nuevas Flores-Quivilla-Tingo Chico  ','','Estudio para la rehabilitacion y mejora de carretera'),(29,'Estudio de preinversion a nivel de perfil de la carretera PE-5NC, nuevo Siasme-Saramiriza','','Estudio de afectaciones prediales para el proyecto; estudio de pre inversiÃ³n a nivel  de perfil de la carretera nuevo Siasme-Saramiriza.'),(30,'ConstrucciÃ³n de 11 puentes en la red vÃ­al nacional, ruta PE-1NR en el tramo Tambogrande hasta Puente la PeÃ±a km 60+000.','','Estudio de afectaciones prediales'),(32,'ConstrucciÃ³n del Puente NaciÃ³n ashÃ¡nincas y Accesos, Ubicado sobre el RÃ­o Ene en la Red Vial Nacional, Ruta PE-28C, Provincia de Satipo, RegiÃ³n JunÃ­n.','','Puente Ashaninca'),(33,'Mejoramiento y construccion de la carretera Jenaro Herrera - Colonia Angamos (Frontera con Brasil) , distrito  de Jenaro Herrera-Provincia de RequeÃ±a - Region Loreto','','Proyecto Jenaro Herrera'),(34,'Creacion del puento Alto Chira y Accesos, distrito de Querocotillo - Provincia de Sullana- Piura','Proyecto Puente Alto chira',''),(35,'Estudio Definitivo para la culminaciÃ³n de las Obras de la Carretera Longitudinal de la Sierra (PE-3N), Tramos: San Marcos- Cajabamba, Cochabamba- Chota, Hualgayoc- DV. Yanacocha, en el Departamento de Cajamarca y el Sector: Huamachuco- Sacsacocha- Puente Pallar en el Departamento de La Libertad','','');
/*!40000 ALTER TABLE `proyectos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyectoxcontratante`
--

DROP TABLE IF EXISTS `proyectoxcontratante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyectoxcontratante` (
  `IdProyectoxContratante` int NOT NULL AUTO_INCREMENT,
  `IdProyecto` int NOT NULL,
  `IdContratante` int NOT NULL,
  PRIMARY KEY (`IdProyectoxContratante`),
  KEY `IdProyecto` (`IdProyecto`),
  KEY `IdContratante` (`IdContratante`),
  CONSTRAINT `proyectoxcontratante_ibfk_1` FOREIGN KEY (`IdProyecto`) REFERENCES `proyectos` (`IdProyecto`),
  CONSTRAINT `proyectoxcontratante_ibfk_2` FOREIGN KEY (`IdContratante`) REFERENCES `contratantes` (`IdContratante`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectoxcontratante`
--

LOCK TABLES `proyectoxcontratante` WRITE;
/*!40000 ALTER TABLE `proyectoxcontratante` DISABLE KEYS */;
INSERT INTO `proyectoxcontratante` VALUES (1,1,11),(2,2,11),(3,3,11),(4,4,11),(5,5,11),(6,6,11),(7,7,11),(8,8,1),(9,9,2),(10,10,3),(11,11,4),(12,12,5),(13,13,15),(14,14,15),(15,15,12),(16,16,12),(17,17,9),(18,18,14),(19,19,8),(20,20,7),(21,21,7),(22,22,13),(23,23,15),(24,24,15),(25,25,6),(26,26,10),(27,27,10),(28,28,12),(29,29,12),(30,30,12),(31,35,16),(32,33,17),(33,34,18),(34,32,19);
/*!40000 ALTER TABLE `proyectoxcontratante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyectoxobjetoestudio`
--

DROP TABLE IF EXISTS `proyectoxobjetoestudio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyectoxobjetoestudio` (
  `IdProyectoxObjectoEstudio` int NOT NULL AUTO_INCREMENT,
  `IdProyecto` int NOT NULL,
  `IdObjetoEstudio` int NOT NULL,
  `Estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`IdProyectoxObjectoEstudio`),
  KEY `IdProyecto` (`IdProyecto`),
  KEY `proyectoxobjetoestudio_ibfk_2` (`IdObjetoEstudio`),
  CONSTRAINT `proyectoxobjetoestudio_ibfk_1` FOREIGN KEY (`IdProyecto`) REFERENCES `proyectos` (`IdProyecto`),
  CONSTRAINT `proyectoxobjetoestudio_ibfk_2` FOREIGN KEY (`IdObjetoEstudio`) REFERENCES `objetosestudio` (`IdObjetoEstudio`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectoxobjetoestudio`
--

LOCK TABLES `proyectoxobjetoestudio` WRITE;
/*!40000 ALTER TABLE `proyectoxobjetoestudio` DISABLE KEYS */;
INSERT INTO `proyectoxobjetoestudio` VALUES (1,1,1,'S'),(2,2,1,'S'),(3,3,1,'S'),(4,4,1,'S'),(5,5,1,'S'),(6,6,1,'S'),(7,7,1,'S'),(8,8,1,'S'),(9,8,2,'S'),(10,8,3,'S'),(11,9,1,'S'),(12,10,1,'S'),(13,11,1,'S'),(14,12,1,'S'),(15,13,1,'S'),(16,14,1,'S'),(17,15,1,'S'),(18,16,1,'S'),(19,17,1,'S'),(20,18,1,'S'),(21,19,4,'S'),(22,20,2,'S'),(23,21,2,'S'),(24,22,1,'S'),(25,22,2,'S'),(26,22,3,'S'),(27,23,1,'S'),(28,24,1,'S'),(29,25,2,'S'),(30,26,1,'S'),(31,27,1,'S'),(32,28,1,'S'),(33,29,1,'S'),(34,30,1,'S'),(35,2,2,'N'),(36,2,3,'N'),(37,2,4,'N'),(38,1,2,'N'),(39,1,3,'N'),(40,1,4,'N'),(41,3,2,'N'),(42,3,3,'N'),(43,3,4,'N'),(44,4,2,'N'),(45,4,3,'N'),(46,4,4,'N'),(47,5,2,'N'),(48,5,3,'N'),(49,5,4,'N'),(50,6,2,'N'),(51,6,3,'N'),(52,6,4,'N'),(53,7,2,'N'),(54,7,3,'N'),(55,7,4,'N'),(56,8,4,'N'),(57,9,2,'N'),(58,9,3,'N'),(59,9,4,'N'),(60,10,2,'N'),(61,10,3,'N'),(62,10,4,'N'),(63,11,2,'N'),(64,11,3,'N'),(65,11,4,'N'),(66,12,2,'N'),(67,12,3,'N'),(68,12,4,'N'),(69,13,2,'N'),(70,13,3,'N'),(71,13,4,'N'),(72,14,2,'N'),(73,14,3,'N'),(74,14,4,'N'),(75,15,2,'N'),(76,15,3,'N'),(77,15,4,'N'),(78,16,2,'N'),(79,16,3,'N'),(80,16,4,'N'),(81,17,2,'N'),(82,17,3,'N'),(83,17,4,'N'),(84,18,2,'N'),(85,18,3,'N'),(86,18,4,'N'),(87,19,1,'N'),(88,19,2,'N'),(89,19,3,'N'),(90,20,1,'N'),(91,20,3,'N'),(92,20,4,'N'),(93,21,1,'N'),(94,21,3,'N'),(95,21,4,'N'),(96,22,4,'N'),(97,23,2,'N'),(98,23,3,'N'),(99,23,4,'N'),(100,24,2,'N'),(101,24,3,'N'),(102,24,4,'N'),(103,25,1,'N'),(104,25,3,'N'),(105,25,4,'N'),(106,26,2,'N'),(107,26,3,'N'),(108,26,4,'N'),(109,27,2,'N'),(110,27,3,'N'),(111,27,4,'N'),(112,28,2,'N'),(113,28,3,'N'),(114,28,4,'N'),(115,29,2,'N'),(116,29,3,'N'),(117,29,4,'N'),(118,30,2,'N'),(119,30,3,'N'),(120,30,4,'N');
/*!40000 ALTER TABLE `proyectoxobjetoestudio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reciboshonorarios`
--

DROP TABLE IF EXISTS `reciboshonorarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reciboshonorarios` (
  `IdReciboHonorario` int NOT NULL AUTO_INCREMENT,
  `NroRecibo` varchar(20) DEFAULT NULL,
  `Ruc` char(11) DEFAULT NULL,
  `Nombres` varchar(100) DEFAULT NULL,
  `Apellidos` varchar(100) DEFAULT NULL,
  `Distrito` varchar(50) DEFAULT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `FormaPago` varchar(50) DEFAULT NULL,
  `Concepto` varchar(100) DEFAULT NULL,
  `ImporteNeto` decimal(18,2) DEFAULT NULL,
  `RetencionIr` decimal(18,2) DEFAULT NULL,
  `ImporteTotal` decimal(18,2) DEFAULT NULL,
  `FechaEmision` date DEFAULT NULL,
  PRIMARY KEY (`IdReciboHonorario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reciboshonorarios`
--

LOCK TABLES `reciboshonorarios` WRITE;
/*!40000 ALTER TABLE `reciboshonorarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `reciboshonorarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposdocumentos`
--

DROP TABLE IF EXISTS `tiposdocumentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tiposdocumentos` (
  `IdTipoDocumento` int NOT NULL AUTO_INCREMENT,
  `IdModulo` int DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdTipoDocumento`),
  KEY `IdModulo` (`IdModulo`),
  CONSTRAINT `tiposdocumentos_ibfk_1` FOREIGN KEY (`IdModulo`) REFERENCES `modulos` (`IdModulo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposdocumentos`
--

LOCK TABLES `tiposdocumentos` WRITE;
/*!40000 ALTER TABLE `tiposdocumentos` DISABLE KEYS */;
INSERT INTO `tiposdocumentos` VALUES (1,2,'Carta'),(2,2,'Correo'),(3,2,'Llamada'),(4,3,'Factura'),(5,3,'Boleta');
/*!40000 ALTER TABLE `tiposdocumentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposempleados`
--

DROP TABLE IF EXISTS `tiposempleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tiposempleados` (
  `IdTipoEmpleado` int NOT NULL AUTO_INCREMENT,
  `CodigoTipoEmpleado` varchar(50) DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdTipoEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposempleados`
--

LOCK TABLES `tiposempleados` WRITE;
/*!40000 ALTER TABLE `tiposempleados` DISABLE KEYS */;
INSERT INTO `tiposempleados` VALUES (1,'TEMP0001','Practicante'),(2,'TEMP0002','Tiempo Completo'),(3,'TEMP0003','Part Time');
/*!40000 ALTER TABLE `tiposempleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transferenciasbancarias`
--

DROP TABLE IF EXISTS `transferenciasbancarias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transferenciasbancarias` (
  `IdTransferenciaBancaria` int NOT NULL AUTO_INCREMENT,
  `IdPeriodo` int DEFAULT NULL,
  `NroOperacion` varchar(20) DEFAULT NULL,
  `CuentaOrigen` char(7) DEFAULT NULL,
  `CuentaDestino` char(7) DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  PRIMARY KEY (`IdTransferenciaBancaria`),
  KEY `IdPeriodo` (`IdPeriodo`),
  CONSTRAINT `transferenciasbancarias_ibfk_1` FOREIGN KEY (`IdPeriodo`) REFERENCES `periodos` (`IdPeriodo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transferenciasbancarias`
--

LOCK TABLES `transferenciasbancarias` WRITE;
/*!40000 ALTER TABLE `transferenciasbancarias` DISABLE KEYS */;
/*!40000 ALTER TABLE `transferenciasbancarias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidadmedida`
--

DROP TABLE IF EXISTS `unidadmedida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidadmedida` (
  `idunidadmedida` int NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idunidadmedida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidadmedida`
--

LOCK TABLES `unidadmedida` WRITE;
/*!40000 ALTER TABLE `unidadmedida` DISABLE KEYS */;
INSERT INTO `unidadmedida` VALUES (1,'talla'),(2,'peso');
/*!40000 ALTER TABLE `unidadmedida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `IdUsuario` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `pass` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Luis','123456789'),(2,'gmingenieros','123456789');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `verproductosxalmacen`
--

DROP TABLE IF EXISTS `verproductosxalmacen`;
/*!50001 DROP VIEW IF EXISTS `verproductosxalmacen`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `verproductosxalmacen` AS SELECT 
 1 AS `IdArticulo`,
 1 AS `nombrearticulo`,
 1 AS `anio`,
 1 AS `mes`,
 1 AS `cantidad`,
 1 AS `idalmacen`,
 1 AS `nombrealmacen`,
 1 AS `movimiento`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `viaticos`
--

DROP TABLE IF EXISTS `viaticos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viaticos` (
  `IdViatico` int NOT NULL AUTO_INCREMENT,
  `IdEmpleado` int DEFAULT NULL,
  `IdPeriodo` int DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `Pasaje` decimal(18,2) DEFAULT NULL,
  `Menu` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`IdViatico`),
  KEY `IdEmpleado` (`IdEmpleado`),
  KEY `IdPeriodo` (`IdPeriodo`),
  CONSTRAINT `viaticos_ibfk_1` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleados` (`IdEmpleado`),
  CONSTRAINT `viaticos_ibfk_2` FOREIGN KEY (`IdPeriodo`) REFERENCES `periodos` (`IdPeriodo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viaticos`
--

LOCK TABLES `viaticos` WRITE;
/*!40000 ALTER TABLE `viaticos` DISABLE KEYS */;
INSERT INTO `viaticos` VALUES (1,1,1,'ninguna',12.00,12.00),(11,2,1,'ninguna',23.00,23.00),(12,1,1,'ninguna',21.00,21.00);
/*!40000 ALTER TABLE `viaticos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gmingenieros'
--

--
-- Dumping routines for database 'gmingenieros'
--
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_areas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_areas`(
	IN p_codigo VARCHAR(20),
    IN p_descripcion VARCHAR(100)
)
BEGIN
    UPDATE areas 
    SET descripcion = p_descripcion 
    WHERE CodigoArea = p_codigo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_articulos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_articulos`(
    IN p_Id INT,
    IN p_Descripcion VARCHAR(100),
    IN p_IdCategoria INT,
    IN p_IdMarca INT,
    IN p_Caracteristicas VARCHAR(100),
    IN p_Cantidad INT
)
BEGIN
    UPDATE articulos SET 
		descripcion = p_Descripcion,
		IdCategoria = p_Idcategoria,
        IdMarca = p_IdMarca,
        caracteristicas = p_Caracteristicas,
        cantidad = p_Cantidad
    WHERE idArticulo = p_Id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_asistencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_asistencia`(
xId INT,
xHora CHAR(8)
)
BEGIN
	UPDATE asistencias SET Hora = xHora WHERE Id = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_cabeceracomprobante` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_cabeceracomprobante`(in xNumeroComprobante varchar(20), in xFechaEmision varchar (10), 
in xFechaVencimiento varchar (10), 
in xSubTotal decimal (18,2), 
in xIgv decimal(18,2),in xTotal decimal(18,2), 
in xIdProveedores int,in xIdTipoDocumento int)
BEGIN
update cabeceracomprobante set 
FechaEmision=STR_TO_DATE(xFechaEmision, '%d/%m/%Y'),
FechaVencimiento=STR_TO_DATE(xFechaVencimiento, '%d/%m/%Y'),
SubTotal=xSubTotal, 
Igv=xIgv,
Total=xTotal, 
IdProveedores=xIdProveedores, 
IdTipoDocumento=xIdTipoDocumento
where NumeroComprobante=xNumeroComprobante;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_cargos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_cargos`(
    IN p_codigo VARCHAR(20),
    IN p_descripcion VARCHAR(100)
)
BEGIN
    UPDATE cargos 
    SET Descripcion = p_descripcion 
    WHERE CodigoCargo = p_codigo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_carreras` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_carreras`(
    IN xId VARCHAR(20),
    IN xDescripcion VARCHAR(100)
)
BEGIN
    UPDATE carreras 
    SET Descripcion = xDescripcion
    WHERE codigoCarrera = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_categorias` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_categorias`(
	IN p_codigo VARCHAR(20),
    IN p_descripcion VARCHAR(100)
)
BEGIN
	UPDATE categorias 
    SET Descripcion = p_descripcion
	where CodigoCategoria = p_codigo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_comunicacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_comunicacion`(parId int , parIdPeriodo int, parNomProy varchar(100), parTipo int, parCodDoc varchar(100), parOrigen varchar(100), parDestino varchar(100), parFlujo int,
parAsunto varchar(100), parFecha date, parCodDocRespuesta varchar(100), parEstado int, parEnlace varchar(100))
BEGIN
update comunicaciones 
set Nombre = parNomProy, 
Tipo = parTipo, CodDoc = parCodDoc, Origen = parOrigen, Destino = parDestino, 
Flujo = parFlujo, Asunto = parAsunto, Fecha = parFecha, 
CodDocRespuesta = parCodDocRespuesta,  
Estado = parEstado, Enlace = parEnlace
where ID = parId 
and  IdPeriodo = parIdPeriodo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_contactos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_contactos`(
IN `xId` int, 
IN `xNombre` VARCHAR(100), 
IN `xFechaNacimiento` VARCHAR(10), 
IN `xPersonasRelacionadas` VARCHAR(100), 
IN `xEmpresa` VARCHAR(100),
IN `xCuentas` VARCHAR(100),
IN `xClave` VARCHAR(100), 
IN `xCargo` VARCHAR(100), 
IN `xCorreo` VARCHAR(100), 
IN `xTelefono` CHAR(9), 
IN `xDepartamento` VARCHAR(100), 
IN `xDireccion` VARCHAR(100), 
IN `xNotas` VARCHAR(200))
BEGIN
update contactos 
set 
Nombre=xNombre, 
FechaNacimiento=xFechaNacimiento, 
PersonasRelacionadas=xPersonasRelacionadas,
Empresa=xEmpresa,
Cuentas=xCuentas,
Clave=xClave, 
Cargo=xCargo, 
Correo=xCorreo, 
Telefono=xTelefono, 
Departamento=xDepartamento, 
Direccion=xDireccion, Notas=xNotas
where IdContacto=xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_contratoxproyectos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_contratoxproyectos`(in xIdContratoProyecto int, 
in xIdProyecto int,
in xNroDocumentoProyecto varchar(100), 
in xIdContratante1 int, 
in xFechaInicio date, 
in xFechaFin date, 
in xImporteTotal decimal(18,2), 
in xEstado char(1), 
in xObservacion varchar(200))
BEGIN
update contratosdeproyectos
set IdProyecto = xIdProyecto,
NroDocumentoProyecto= xNroDocumentoProyecto,
IdContratante1= xIdContratante1,

FechaInicio = xFechaInicio,
FechaFin = xFechaFin,
ImporteTotal = xImporteTotal,

Estado = xEstado,
Observacion=xObservacion
where  IdContratoProyecto = xIdContratoProyecto;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_credencial` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_credencial`(
in xidcredencial varchar(10),
in xcorreo varchar(200),
in xclave varchar(200), 
in xalias varchar(100), 
in xdescripcion varchar(200)
)
BEGIN
	update credenciales 
    set correo = xcorreo, clave = xclave, alias = xalias, descripcion = xdescripcion
    where codigoCredencial = xidcredencial;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_cuenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_cuenta`(
	IN xId INT,
    IN xTipoPropietario CHAR(7),
    IN xNombres VARCHAR(50),
    IN xBanco INT,
	IN xCCC VARCHAR(50),
    IN xCCI VARCHAR(50),
    IN xTipoMoneda CHAR(1)
)
BEGIN
	UPDATE cuentasbancarias
    SET  TipoPropietario = xTipoPropietario,
         IdBanco = xBanco,
         Nombres = xNombres,
         NroCuenta = xCCC,
         NroCuentaInterbancaria = xCCI,
         TipoMoneda = xTipoMoneda,
         FechaCreacion = CURDATE()  -- Establecer la fecha actual
    WHERE IdCuentaBancaria = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_datos_empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_datos_empleado`(
IN xId int, IN xApellidos VARCHAR(100), IN xNombres VARCHAR(100), IN xFechaNacimiento VARCHAR(10), IN xCorreo VARCHAR(100), IN xDni CHAR(8), IN xCelular CHAR(9), IN xDistrito VARCHAR(50), IN xDireccion VARCHAR(100), IN xIdArea int, IN xIdCargo int, IN xIdTipoEmpleado int
)
BEGIN
UPDATE empleados SET Apellidos = xApellidos,
Nombres = xNombres,
FechaNacimiento = STR_TO_DATE(xFechaNacimiento, '%d/%m/%Y'),
Correo = xCorreo,
Dni = xDni,
Celular = xCelular,
Distrito = xDistrito,
Direccion = xDireccion,
IdArea = xIdArea,
IdCargo = xIdCargo,
IdTipoEmpleado = xIdTipoEmpleado
WHERE Id = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_departamentos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_departamentos`(
IN xId VARCHAR(20),
IN xDescripcion VARCHAR(100)
)
BEGIN
UPDATE departamentos 
SET Descripcion = xDescripcion
WHERE codigoDepartamento = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_detalle_asistencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_detalle_asistencia`(
    IN xId_detalle INT,
    IN xHora CHAR(8)
)
BEGIN
    -- Declaramos las variables
    DECLARE v_hora_entrada TIME;
    DECLARE v_hora_salida TIME;
    DECLARE v_duracion TIME;

    -- Insertarmos los valores correspondientes
    -- en la variables creadas
    SELECT Hora_entrada, Hora_salida, v_duracion
    INTO v_hora_entrada, v_hora_salida, v_duracion
    FROM detalles_asistencia
    WHERE Id = xId_detalle;

    -- Convertir xHora a TIME
    SET xHora = STR_TO_DATE(xHora, '%H:%i:%s');

    IF v_hora_salida IS NULL THEN
        -- Actualizar la hora de salida
        IF xHora < v_hora_entrada THEN
            -- Cambiar posicion de hora de entrada y salida
            UPDATE detalles_asistencia
            SET Hora_entrada = xHora,
                Hora_salida = v_hora_entrada,
                Duracion = TIMEDIFF(v_hora_entrada, xHora)
            WHERE Id = xId_detalle;
        ELSE
            -- Actualizar hora de salida y calcular duracion
            UPDATE detalles_asistencia
            SET Hora_salida = xHora,
                Duracion = TIMEDIFF(xHora, v_hora_entrada)
            WHERE Id = xId_detalle;
        END IF;
    ELSE
        -- Actualizar hora de entrada y recalcular la duracion
        UPDATE detalles_asistencia
        SET Hora_entrada = xHora,
            Duracion = TIMEDIFF(v_hora_salida, xHora)
        WHERE Id = xId_detalle;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_empleados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_empleados`(
IN xId int,
IN xApellidos VARCHAR(100),
IN xNombres VARCHAR(100),
IN xFechaNacimiento DATE,
IN xCorreo VARCHAR(100),
IN xDni CHAR(8),
IN xCelular CHAR(9),
IN xDireccion VARCHAR(100),
IN xCodigoEstudiante VARCHAR(100),
IN xIdCarrera int,
IN xIdCiclo int,
IN xIdInstitucionEducativa int,
IN xIdArea int,
IN xIdFacultad int,
IN xIdTipoEmpleado int,
IN xIdCargo int
)
BEGIN
UPDATE empleados SET Apellidos= xApellidos, Nombres=xNombres, Correo=xCorreo, Dni=xDni, Celular=xCelular, Direccion=xDireccion, IdCarrera=xIdCarrera, IdCiclo=xIdCiclo, IdInstitucionEducativa=xIdInstitucionEducativa, IdArea=xIdArea, IdFxultad=xIdFxultad, 
IdTipoEmpleado=xIdTipoEmpleado, IdCargo=xIdCargo
WHERE Id=xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_facultades` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_facultades`(
IN xId VARCHAR(20),
IN xDescripcion VARCHAR(100)
)
BEGIN
UPDATE facultades SET Descripcion = xDescripcion
WHERE codigoFacultad = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_instituciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_instituciones`(
    IN xId VARCHAR(20),
    IN xRuc CHAR(20),
    IN xRazonSocial VARCHAR(100),
    IN xDireccion VARCHAR(100),
    IN xSede VARCHAR(100)
)
BEGIN
    UPDATE institucioneseducativas
    SET Ruc = xRuc, RazonSocial = xRazonSocial, Direccion = xDireccion, Sede = xSede
    WHERE codigoInstituciones = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_modulo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_modulo`(IN `xId` int, IN `xDescripcion` VARCHAR(100))
BEGIN
UPDATE modulo SET Descripcion=xDescripcion
where Id=xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_observacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_observacion`(
IN xId INT,
IN xObservacion VARCHAR(255)
)
BEGIN
	UPDATE detalle_asistencia
    SET Observaciones = xObservacion
    WHERE Id = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_periodos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_periodos`(
    IN xId varchar(10),
    IN xDescripcion VARCHAR(100)
)
BEGIN
    DECLARE numMes INT;

    -- Convertir el nombre del mes a número
    SET numMes = CASE LOWER(xDescripcion)
        WHEN 'enero' THEN 1
        WHEN 'febrero' THEN 2
        WHEN 'marzo' THEN 3
        WHEN 'abril' THEN 4
        WHEN 'mayo' THEN 5
        WHEN 'junio' THEN 6
        WHEN 'julio' THEN 7
        WHEN 'agosto' THEN 8
        WHEN 'septiembre' THEN 9
        WHEN 'octubre' THEN 10
        WHEN 'noviembre' THEN 11
        WHEN 'diciembre' THEN 12
        ELSE 0
    END;

    -- Actualizar todos los campos relacionados
    UPDATE periodos
    SET
        Descripcion = xDescripcion,
        Mes = numMes,
        Anio = 2025,
        Alias = CONCAT(LPAD(numMes, 2, '0'), '2025')
    WHERE codigoPeriodo = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_proveedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_proveedores`(
xId varchar(20), 
xIdDepartamento int,
xNombres varchar (100), 
xDireccion varchar (100), 
xCorreo varchar(100), 
xTelefono char(9), 
xRuc char(11))
BEGIN
update proveedores set 
IdDepartamento = xIdDepartamento,
Nombres=xNombres, 
Direccion=xDireccion,
Correo=xCorreo, 
Telefono=xTelefono, 
Ruc=xRuc
where codigoProveedor=xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_proyectoxobjetoestudio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_proyectoxobjetoestudio`(in xidproyecto int, 
in xidobjetoestudio int, in xestado varchar(1))
BEGIN
	update proyectoxobjetoestudio  
    set estado = xestado
    where idproyecto = xidproyecto
    and idobjetoestudio = xidobjetoestudio;
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_recibo_honorario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_recibo_honorario`(
    IN xId int,
    IN xNroRecibo VARCHAR(20),
    IN xRuc CHAR(11),
    IN xNombres VARCHAR(100),
    IN xApellidos VARCHAR(100),
    IN xDistrito VARCHAR(50),
    IN xDireccion VARCHAR(100),
    IN xFormaPago VARCHAR(50),
    IN xConcepto VARCHAR(100),
    IN xImporteNeto DECIMAL(18, 2),
    IN xRetencionIr DECIMAL(18, 2),
    IN xImporteTotal DECIMAL(18, 2),
    IN xFechaEmision CHAR(10)
)
BEGIN
    UPDATE reciboshonorarios
    SET 
        NroRecibo = xNroRecibo   ,
        Ruc = xRuc  , 
        Nombres = xNombres  ,
        Apellidos = xApellidos  ,
        Distrito = xDistrito  ,
        Direccion = xDireccion  ,
        FormaPago = xFormaPago  ,
        Concepto = xConcepto  ,
        ImporteNeto = xImporteNeto  ,
        RetencionIr = xRetencionIr  ,
        ImporteTotal = xImporteTotal  ,
        FechaEmision = STR_TO_DATE(xFechaEmision, '%d/%m/%Y')  
    WHERE
        Id = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_tipodocumento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_tipodocumento`(IN `xId` int, IN `xDescripcion` VARCHAR(100), IN `xIdModulo` int)
BEGIN
UPDATE tiposdocumentos SET  Descripcion = xDescripcion,
 IdModulo = xIdModulo
WHERE Id = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_tipoempleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_tipoempleado`(
IN p_codigo VARCHAR(20),
    IN p_descripcion VARCHAR(100)
)
BEGIN
    UPDATE tiposempleados 
    SET Descripcion = p_descripcion 
    WHERE CodigoTipoEmpleado = p_codigo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_transferencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_transferencia`(
xId INT,
xIdPeriodo int,
xNroOperacion VARCHAR(20),
xCuentaOrigen CHAR(7),
xCuentaDestino CHAR(7),
xFecha CHAR(10)
)
BEGIN
    UPDATE transferenciasbancarias 
    SET 
        IdPeriodo = xIdPeriodo, 
        NroOperacion = xNroOperacion,
        CuentaOrigen = xCuentaOrigen,
        CuentaDestino = xCuentaDestino,
        Fecha = STR_TO_DATE(xFecha, '%d/%m/%Y')
    WHERE IdTransferenciaBancaria = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizar_viaticos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_viaticos`(
IN xId INT,
IN xDescripcion VARCHAR(100),
IN xPasaje DECIMAL(18, 2),
IN xMenu DECIMAL(18, 2),
IN xIdEmpleado int,
IN xIdPeriodo int
)
BEGIN
	UPDATE viaticos 
    SET Descripcion = xDescripcion,
    Pasaje = xPasaje,
    Menu = xMenu,
    IdEmpleado = xIdEmpleado,
    IdPeriodo = xIdPeriodo
    WHERE IdViatico = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `cargar_categorias` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cargar_categorias`()
BEGIN
    SELECT descripcion FROM categorias;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `cargar_marcas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cargar_marcas`()
BEGIN
    SELECT descripcion FROM marcas;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `consulta_areas_cargos_tipos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consulta_areas_cargos_tipos`(
xArea VARCHAR(100),
xCargo VARCHAR(100),
xTipo VARCHAR(100)
)
BEGIN
	SELECT a.Id AS Id_area, c.Id AS Id_cargo, t.Id AS Id_tipo
    FROM areas a, cargos c, tiposempleados t
    WHERE a.Descripcion = xArea
    AND c.Descripcion = xCargo
    AND t.Descripcion = xTipo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `consulta_inst_facu_carr` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consulta_inst_facu_carr`(
xIns VARCHAR(100),
xFac VARCHAR(100),
xCar VARCHAR(100)
)
BEGIN
	SELECT i.Id AS Id_ins, f.Id AS Id_fac, c.Id AS Id_car
    FROM institucioneseducativas i, facultades f, carreras c
    WHERE i.RazonSocial = xIns
    AND f.Descripcion = xFac
    AND c.Descripcion = xCar;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_areas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_areas`(
	IN p_codigo VARCHAR(20)
)
BEGIN
    DELETE FROM areas WHERE CodigoArea = p_codigo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_articulos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_articulos`(
    IN p_IdArticulo INT
)
BEGIN
    DELETE FROM articulos WHERE idArticulo = p_IdArticulo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_cabeceracomprobante` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_cabeceracomprobante`(in xNumeroComprobante varchar (20))
BEGIN
delete from cabeceracomprobante 
where NumeroComprobante=xNumeroComprobante;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_cargos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_cargos`(
    IN p_codigo VARCHAR(20)
)
BEGIN
    DELETE FROM cargos WHERE CodigoCargo = p_codigo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_carreras` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_carreras`(
    IN xId VARCHAR(100)  -- Cambiar de INT a VARCHAR(100)
)
BEGIN
    DELETE FROM carreras WHERE codigoCarrera = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_categorias` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_categorias`(
	IN p_codigo VARCHAR(20)
)
BEGIN
DELETE FROM categorias WHERE CodigoCategoria = p_codigo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_comunicacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_comunicacion`(parId int, parIdPeriodo int)
BEGIN
delete from comunicaciones where Id = parId and IdPeriodo = parIdPeriodo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_contacto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_contacto`(IN `xId` int)
BEGIN
delete from contactos  where IdContacto=xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_credencial` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_credencial`(in xidcredencial varchar(10))
BEGIN
    DELETE FROM credenciales WHERE codigoCredencial = xidcredencial;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_cuenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_cuenta`(
	IN xId int
)
BEGIN
 DELETE FROM cuentasbancarias WHERE IdCuentaBancaria = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_departamentos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_departamentos`(
IN xId VARCHAR(100)
)
BEGIN
DELETE FROM departamentos WHERE codigoDepartamento = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_empleados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_empleados`(
IN xId int
)
BEGIN
DELETE FROM empleados WHERE Id= xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_facultades` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_facultades`(
IN xId VARCHAR(100)
)
BEGIN
DELETE FROM facultades WHERE codigoFacultad = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_instituciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_instituciones`(
    IN xId varchar(100)
)
BEGIN
    DELETE FROM institucioneseducativas
    WHERE codigoInstituciones = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_modulo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_modulo`(IN `xId` int)
BEGIN
DELETE FROM modulo WHERE Id= xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_periodos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_periodos`(
IN xId varchar(100)
)
BEGIN
DELETE FROM periodos WHERE codigoPeriodo = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_proveedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_proveedores`(
xId varchar(100)
)
BEGIN
delete from proveedores where codigoProveedor=xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_recibo_honorario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_recibo_honorario`(
IN xId int
)
BEGIN
	DELETE FROM reciboshonorarios WHERE Id = xId  ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_tipodocumento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_tipodocumento`(IN `xId` int)
BEGIN
DELETE FROM tiposdocumentos WHERE Id= xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_tipoempleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_tipoempleado`(
	IN p_codigo VARCHAR(20)
)
BEGIN
DELETE FROM tiposempleados WHERE CodigoTipoEmpleado= p_codigo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_transferencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_transferencia`(
xId INT
)
BEGIN
	DELETE FROM transferenciasbancarias
    WHERE IdTransferenciaBancaria = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_viaticos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_viaticos`(
IN xId INT
)
BEGIN
DELETE FROM viaticos WHERE IdViatico = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `generar_codigo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_codigo`(
    IN p_tabla VARCHAR(50),    -- Nombre de la tabla (ej. 'cargos')
    IN p_campo_id VARCHAR(50), -- Nombre del campo ID (ej. 'IdCargo')
    IN p_prefijo VARCHAR(10),  -- Prefijo del cÃ³digo (ej. 'CAR')
    OUT p_codigo VARCHAR(20)   -- CÃ³digo generado (ej. 'CAR0001')
)
BEGIN
    DECLARE next_id INT;

    -- Obtener el mÃ¡ximo valor actual de IdCargo
    SET @sql_query = CONCAT('SELECT MAX(', p_campo_id, ') INTO @next_id FROM ', p_tabla);

    -- Ejecutar la consulta para obtener el mÃ¡ximo ID
    PREPARE stmt FROM @sql_query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;

    -- Si la tabla estÃ¡ vacÃ­a, empezar desde 1
    IF @next_id IS NULL THEN
        SET @next_id = 0;
    END IF;

    -- Incrementar el ID para el prÃ³ximo cÃ³digo
    SET @next_id = @next_id + 1;

    -- Generar el cÃ³digo con formato (Ejemplo: CAR0001)
    SET p_codigo = CONCAT(p_prefijo, LPAD(@next_id, 4, '0'));

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `generar_codigocomunicacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_codigocomunicacion`()
BEGIN
-- asignar el prefijo para el codigo
set @prefijo = 'CG';

-- obtener la cantidad de registro de la tabla
set  @cantidadRegistros = (select count(*) from comunicaciones limit 1);

-- se obtiene el ultimo, en caso de no tener registors en la tabla asignar CG0000, si no CG00001
set @ultimocodigo = ( case when @cantidadRegistros = 0 then  'CG0000' else (select Id from comunicaciones order by Id desc limit 1) end);
 
-- retirar el prefijo del codigo CF0001 obtenido a traves de a consulta
-- el ultimo codigo ingresado convertir a enter y sumar en 1 para obtener el siguiente codigo.
set @correlativo = convert( substring(@ultimocodigo,3,4), signed) + 1 ;
-- 1

-- completar con ceros segun la longitud del correlativo
set @ceros = repeat('0', 4-length(@correlativo)); -- 00
-- 000

-- concatenear las variables
--  A , 00, 11 => A0011
select concat(@prefijo,@ceros, @correlativo);
-- CG0001

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `generar_codigoentero` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_codigoentero`(in tabla varchar(200),out codigo_generado int)
BEGIN

	
set @querydinamico = '';
    set @columnaId = '';
    set @querydinamico = concat('select column_name into @columnaId from information_schema.statistics  where table_schema = ',
    '"gmingenieros"', ' and table_name=', '"',tabla,'"', ' and index_name=', '"primary"');
    
    PREPARE stmt FROM @querydinamico;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
    
    
    /*
	set @cantidadregistros = 0;
    set @querycantregistros = '';
    set @querycantregistros = concat('select count(', @columnaId, ') into  @cantidadregistros  from ', @tabla, ' limit 1');
    prepare stmt from  @querycantregistros;
    execute stmt;
    deallocate prepare stmt;
    select @cantidadregistros;
    */
    set @correlativo = 0;
    set @querycorrelativo = '';
    set @querysiguientecorrelativo = concat('select (ifnull(max(', @columnaId, '),0) + 1 ) into @correlativo  from ', tabla, ' limit 1');
    prepare stmt from  @querysiguientecorrelativo;
    execute stmt;
    deallocate prepare stmt;    
	
    
    
    set codigo_generado = @correlativo;
    /*set codigo_generado =  @correlativo;*/
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `generar_codigoenterocontactos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_codigoenterocontactos`(out codigo_generado int  )
BEGIN
	set @cantidadregistros = 0;
    set @cantidadregistros = (select count(IdContacto) from contactos limit 1);
    set @correlativo = 0;
    if(@cantidadregistros  = 0) then
		set @correlativo = 1;
        else
        set @correlativo =  (select  isnull(max(IdContacto)) + 1 from contactos limit 1);
    End if;
    set codigo_generado =  @correlativo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `generar_detalle_asistencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_detalle_asistencia`()
BEGIN
-- Generar el detalle a partir de las asistencias existentes
INSERT INTO detalles_asistencia (IdAsistencia, IdEmpleado, Fecha, Hora_entrada, Hora_salida, Duracion)
	SELECT 
	  MIN(a.Idasistencia) AS Id_asistencia,
	  e.Idempleado AS Id_empleado,
      /*1 as id_empleado,*/
	  a.Fecha,
	  CASE 
		WHEN COUNT(*) > 1 THEN MIN(a.Hora) 
		ELSE MIN(a.Hora)
	  END AS Entrada,
	  CASE 
		WHEN COUNT(*) > 1 THEN MAX(a.Hora) 
		ELSE NULL
	  END AS Salida,
	  TIMEDIFF(
		CASE 
		  WHEN COUNT(*) > 1 THEN MAX(a.Hora) 
		  ELSE NULL
		END,
		CASE 
		  WHEN COUNT(*) > 1 THEN MIN(a.Hora) 
		  ELSE MIN(a.Hora)
		END
	  ) AS Duracion
	FROM asistencias a 
	left JOIN empleados e ON a.Dni = e.Dni
	WHERE a.Procesado = 'N'
	GROUP BY e.idempleado, a.Fecha;

	-- Actualiza los registros procesados
	UPDATE asistencias SET Procesado = 'S' WHERE Procesado = 'N';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_areas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_areas`(
IN p_descripcion VARCHAR(100),
    OUT p_codigo VARCHAR(20)
)
BEGIN
    CALL generar_codigo('areas', 'IdArea', 'ARE', p_codigo);

    -- Insertar el nuevo cargo en la tabla
    INSERT INTO areas (CodigoArea, descripcion) VALUES (p_codigo, p_descripcion);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_articulos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_articulos`(
    IN p_Id INT,
    IN p_descripcion VARCHAR(100),
    IN p_IdCategoria INT,
    IN p_IdMarca INT,
    IN p_caracteristicas VARCHAR(255),
    IN p_Cantidad INT
)
BEGIN
    IF (SELECT COUNT(*) FROM marcas WHERE IdMarca = p_IdMarca) = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La marca especificada no existe';
    END IF;

    INSERT INTO articulos (IdArticulo, IdCategoria, IdMarca, caracteristicas, descripcion, cantidad)
    VALUES (p_Id, p_IdCategoria, p_IdMarca, p_caracteristicas, p_descripcion, p_Cantidad);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_asistencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_asistencia`(
IN xDni CHAR(8),
IN xFecha CHAR(10),
IN xHora CHAR(8)
)
BEGIN
	INSERT INTO asistencias (Dni, Fecha, Hora) VALUES (xDni, STR_TO_DATE(xFecha, '%d/%m/%Y'), xHora);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_cabeceracomprobante` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_cabeceracomprobante`(in xNumeroComprobante varchar(20), in xFechaEmision varchar (10), 
in xFechaVencimiento varchar (10),in xSubTotal decimal (18,2), 
in xIgv decimal(18,2), in xTotal decimal(18,2), 
in xIdProveedores int,in xIdTipoDocumento int)
BEGIN
insert into cabeceracomprobante (NumeroComprobante, FechaEmision, FechaVencimiento, SubTotal, Igv, Total, IdProveedores, IdTipoDocumento) 
 values (xNumeroComprobante,STR_TO_DATE(xFechaEmision, '%d/%m/%Y'),
 STR_TO_DATE(xFechaVencimiento, '%d/%m/%Y'), xSubTotal, xIgv, xTotal,xIdProveedores,
 xIdTipoDocumento);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_cargos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_cargos`(
    IN p_descripcion VARCHAR(100),
    OUT p_codigo VARCHAR(20)
)
BEGIN
    -- Generar el cÃ³digo Ãºnico para `cargos`
    CALL generar_codigo('cargos', 'IdCargo', 'CAR', p_codigo);

    -- Insertar el nuevo cargo en la tabla
    INSERT INTO cargos (CodigoCargo, Descripcion) VALUES (p_codigo, p_descripcion);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_carreras` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_carreras`(
    IN xId INT, 
    IN xDescripcion VARCHAR(100)
)
BEGIN
    INSERT INTO carreras (IdCarrera, descripcion) VALUES (xId, xDescripcion);
    
    UPDATE carreras 
    SET codigoCarrera = CONCAT('CAR000', LPAD(CAST(xId AS CHAR), 3, '0'))
    WHERE IdCarrera = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_categorias` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_categorias`(
IN p_descripcion VARCHAR(100),
    OUT p_codigo VARCHAR(20)
)
BEGIN
    CALL generar_codigo('categorias', 'IdCategoria', 'CAT', p_codigo);

    -- Insertar el nuevo cargo en la tabla
    INSERT INTO categorias (CodigoCategoria, Descripcion) VALUES (p_codigo, p_descripcion);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_comunicacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_comunicacion`(in parId int , in parIdPeriodo int, in parNomProy varchar(100), in parTipo int, 
in parCodDoc varchar(100), in parOrigen varchar(100), in parDestino varchar(100), in parFlujo int,
in parAsunto varchar(100), in parFecha date, in parCodDocRespuesta varchar(100), in parEstado int, in parEnlace varchar(100) )
BEGIN
	insert into comunicaciones values(parId , parIdPeriodo, parNomProy, parTipo, parCodDoc, parOrigen, parDestino, parFlujo, parAsunto, parFecha, parCodDocRespuesta, parEstado, parEnlace);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_contactos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_contactos`(IN `xId` int, IN `xNombre` VARCHAR(100), IN `xFechaNacimiento` VARCHAR(10), IN `xPersonasRelacionadas` VARCHAR(100), IN `xEmpresa` VARCHAR(100),IN `xCuentas` VARCHAR(100),IN `xClave` VARCHAR(100), IN `xCargo` VARCHAR(100), IN `xCorreo` VARCHAR(100), IN `xTelefono` CHAR(9), IN `xDepartamento` VARCHAR(100), IN `xDireccion` VARCHAR(100), IN `xNotas` VARCHAR(200))
BEGIN
insert into contactos values (xId,  xNombre, xFechaNacimiento, xPersonasRelacionadas, xEmpresa,xCuentas,xClave, 
xCargo, xCorreo, xTelefono, xDepartamento, xDireccion, xNotas);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_contratoxproyectos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_contratoxproyectos`(in xIdContratoProyecto int, 
in xIdProyecto int,
in xNroDocumentoProyecto varchar(100), 
in xIdContratante1 int, 
in xFechaInicio date, 
in xFechaFin date, 
in xImporteTotal decimal(18,2), 
in xEstado char(1), 
in xObservacion varchar(200) )
BEGIN
insert into contratosdeproyectos(IdContratoProyecto,
IdProyecto, 
NroDocumentoProyecto, 
IdContratante1, 
FechaInicio, 
FechaFin, 
ImporteTotal, 
Estado, 
Observacion)
values (xIdContratoProyecto, 
xIdProyecto,  
xNroDocumentoProyecto, 
xIdContratante1, 
xFechaInicio, 
xFechaFin, 
xImporteTotal, 
xEstado, 
xObservacion);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_credencial` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_credencial`( 
    IN xCorreo VARCHAR(200),
    IN xClave VARCHAR(200),
    IN xAlias VARCHAR(100),
    IN xDescripcion VARCHAR(200)
)
BEGIN
    DECLARE lastId INT;

    -- Insertar los datos
    INSERT INTO credenciales (correo, clave, alias, descripcion)
    VALUES (xCorreo, xClave, xAlias, xDescripcion);
    
    -- Obtener el último ID insertado
    SET lastId = LAST_INSERT_ID();

    -- Generar y asignar el código personalizado
    UPDATE credenciales
    SET codigoCredencial = CONCAT('CRE000', LPAD(CAST(lastId AS CHAR), 3, '0'))
    WHERE IdCredencial = lastId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_cuenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_cuenta`(
	IN xId INT,
    IN xTipoPropietario CHAR(20),
    IN xNombres VARCHAR(50),
    IN xBanco INT,
	IN xCCC VARCHAR(50),
    IN xCCI VARCHAR(50),
    IN xTipoMoneda CHAR(10)
)
BEGIN
	INSERT INTO cuentasbancarias (
        IdCuentaBancaria, TipoPropietario, Nombres, IdBanco,
        NroCuenta, NroCuentaInterbancaria, TipoMoneda)
    VALUES (
        xId, xTipoPropietario, xNombres, xBanco,
        xCCC, xCCI, xTipoMoneda);
    
    UPDATE cuentasbancarias
SET FechaCreacion = CURDATE()  
WHERE IdCuentaBancaria = xId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_datos_academicos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_datos_academicos`(
In xDni CHAR(8),
IN xIdIns int,
IN xIdFac int,
IN xIdCar int,
IN xCic VARCHAR(20),
IN xCodEs VARCHAR(20)
)
BEGIN
	UPDATE empleados
    SET IdInstitucionEducativa = xIdIns, IdFacultad = xIdFac, IdCarrera = xIdCar, Ciclo = xCic, CodigoEstudiante = xCodEs
    WHERE Dni = xDni;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_datos_empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_datos_empleado`(
IN xId int, IN xApellidos VARCHAR(100), IN xNombres VARCHAR(100), IN xFechaNacimiento VARCHAR(10), IN xCorreo VARCHAR(100), IN xDni CHAR(8), IN xCelular CHAR(9), IN xDistrito VARCHAR(50), IN xDireccion VARCHAR(100), IN xIdArea int, IN xIdCargo int, IN xIdTipoEmpleado int
)
BEGIN
INSERT INTO empleados(Id, Apellidos, Nombres, FechaNacimiento, Correo, Dni, Celular, Distrito, Direccion, IdArea, IdCargo, IdTipoEmpleado)
VALUES (xId, xApellidos, xNombres, STR_TO_DATE(xFechaNacimiento, '%d/%m/%Y'), xCorreo, xDni, xCelular, xDistrito, xDireccion, xIdArea, xIdCargo, xIdTipoEmpleado);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_departamentos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_departamentos`(
IN xId int,
IN xDescripcion VARCHAR(100)
)
BEGIN
INSERT INTO departamentos(IdDepartamento, Descripcion)  VALUES (xId, xDescripcion);

UPDATE departamentos
SET codigoDepartamento = CONCAT('DEP000', LPAD(CAST(xId AS CHAR), 3, '0'))
WHERE IdDepartamento = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_empleado`(
IN xId int, IN xApellidos VARCHAR(100), IN xNombres VARCHAR(100), IN xFechaNacimiento DATE, IN xCorreo VARCHAR(100), IN xDni CHAR(8), IN xCelular CHAR(9), IN xDireccion VARCHAR(100), IN xCodigoEstudiante VARCHAR(100), IN xIdCarrera int, IN xIdCiclo int, IN xIdInstitucionEducativa int, IN xIdArea int, IN xIdFacultad int, IN xIdTipoEmpleado int, IN xIdCargo int
)
BEGIN
INSERT INTO empleados VALUES(xId, xApellidos, xNombres, xFechaNacimiento, xCorreo, xDni, xCelular, xDireccion, xCodigoEstudiante, xIdCarrera, xIdCiclo, xIdInstitucionEducativa, xIdArea, xIdFacultad, xIdTipoEmpleado, xIdCargo);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_facultades` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_facultades`(
IN xId int,
IN xDescripcion VARCHAR(100)
)
BEGIN
INSERT INTO facultades(IdFacultad, Descripcion)  VALUES (xId, xDescripcion);

UPDATE facultades
SET codigoFacultad = CONCAT('FAC000', LPAD(CAST(xId AS CHAR), 3, '0'))
WHERE IdFacultad = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_instituciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_instituciones`(
    IN xIdInstitucion INT, 
    IN xRuc VARCHAR(20),
    IN xRazonSocial VARCHAR(100),
    IN xDireccion VARCHAR(200),
    IN xSede VARCHAR(100)
)
BEGIN

    INSERT INTO institucioneseducativas (IdInstitucionEducativa, Ruc, RazonSocial, Direccion, Sede) 
    VALUES (xIdInstitucion, xRuc, xRazonSocial, xDireccion, xSede);
    
    UPDATE institucioneseducativas 
    SET codigoInstituciones = CONCAT('INS000', LPAD(CAST(xIdInstitucion AS CHAR), 3, '0'))
    WHERE IdInstitucionEducativa = xIdInstitucion;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_modulo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_modulo`(IN `xId` int, IN `xDescripcion` VARCHAR(100))
BEGIN
INSERT INTO modulo VALUES ( xId, xDescripcion);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_periodos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_periodos`(
    IN xId INT,
    IN xMes INT,
    IN xDescripcion VARCHAR(100)
)
BEGIN
    DECLARE anio INT DEFAULT 2025;

    -- Insertar en la tabla 'periodos'
    INSERT INTO periodos (IdPeriodo, Mes, Anio, descripcion, Alias, codigoPeriodo)
    VALUES (
        xId,
        xMes,
        anio,
        xDescripcion,
        CONCAT(LPAD(xMes, 2, '0'), anio),
        '' -- código se actualiza después
    );

    -- Actualizar el código del periodo
    UPDATE periodos
    SET codigoPeriodo = CONCAT('PER000', LPAD(CAST(xId AS CHAR), 3, '0'))
    WHERE IdPeriodo = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_proveedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_proveedores`(
    IN xId INT, 
    IN xDepartamentoId INT,  
    IN xNombres VARCHAR(100), 
    IN xDireccion VARCHAR(100), 
    IN xCorreo VARCHAR(100), 
    IN xTelefono CHAR(9), 
    IN xRuc CHAR(11)
)
BEGIN
    INSERT INTO proveedores (IdProveedor, IdDepartamento, Nombres, Direccion, Correo, Telefono, Ruc) 
    VALUES (xId, xDepartamentoId, xNombres, xDireccion, xCorreo, xTelefono, xRuc);

    UPDATE proveedores
    SET codigoProveedor = CONCAT('PRO000', LPAD(CAST(xId AS CHAR), 3, '0'))
    WHERE IdProveedor = xId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_proyectoxobjetoestudio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_proyectoxobjetoestudio`(in xidproyecto int, in xidobjetoestudio int, in xestado varchar(1))
BEGIN
	insert into proyectoxobjetoestudio (idproyecto, idobjetoestudio, estado) values (xidproyecto, xidproyecto, xestado);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_recibo_honorario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_recibo_honorario`(
    IN xId int,
    IN xNroRecibo VARCHAR(20),
    IN xRuc CHAR(11),
    IN xNombres VARCHAR(100),
    IN xApellidos VARCHAR(100),
    IN xDistrito VARCHAR(50),
    IN xDireccion VARCHAR(100),
    IN xFormaPago VARCHAR(50),
    IN xConcepto VARCHAR(100),
    IN xImporteNeto DECIMAL(18, 2),
    IN xRetencionIr DECIMAL(18, 2),
    IN xImporteTotal DECIMAL(18, 2),
    IN xFechaEmision CHAR(10)
)
BEGIN
	INSERT INTO reciboshonorarios
    VALUES (
		xId,
		xNroRecibo,
		xRuc,
		xNombres,
		xApellidos,
		xDistrito,
		xDireccion,
		xFormaPago,
		xConcepto,
		xImporteNeto,
		xRetencionIr,
		xImporteTotal,
		STR_TO_DATE(xFechaEmision, '%d/%m/%Y')
	);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_tipodocumento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_tipodocumento`(IN `xId` int, IN `xIdModulo` int,
IN `xDescripcion` VARCHAR(100))
BEGIN
INSERT INTO tiposdocumentos VALUES (xId, xIdModulo, xDescripcion);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_tipoempleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_tipoempleado`(
IN p_descripcion VARCHAR(100),
    OUT p_codigo VARCHAR(20)
)
BEGIN
    CALL generar_codigo('tiposempleados', 'IdTipoEmpleado', 'TEMP', p_codigo);

    -- Insertar el nuevo cargo en la tabla
    INSERT INTO tiposempleados (CodigoTipoEmpleado, Descripcion) VALUES (p_codigo, p_descripcion);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_transferencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_transferencia`(
xIdPeriodo int,
xNroOperacion VARCHAR(20),
xCuentaOrigen CHAR(7),
xCuentaDestino CHAR(7),
xFecha CHAR(10)
)
BEGIN
INSERT INTO transferenciasbancarias(IdPeriodo, NroOperacion, CuentaOrigen, CuentaDestino, Fecha)
VALUES (xIdPeriodo, xNroOperacion, xCuentaOrigen, xCuentaDestino, STR_TO_DATE(xFecha, '%d/%m/%Y'));
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_viaticos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_viaticos`(
IN xDescripcion VARCHAR(100),
IN xPasaje DECIMAL(18, 2),
IN xMenu DECIMAL(18, 2),
IN xIdEmpleado int,
IN xIdPeriodo int
)
BEGIN
INSERT INTO viaticos (Descripcion, Pasaje, Menu, IdEmpleado, IdPeriodo)
VALUES (xDescripcion, xPasaje, xMenu, xIdEmpleado, xIdPeriodo);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_areas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_areas`()
BEGIN
    SELECT CodigoArea, descripcion FROM areas ORDER BY CodigoArea;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_articulos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_articulos`()
BEGIN
    SELECT 
        art.idarticulo,
        art.idcategoria,
		cat.descripcion as categoriaDescripcion,
        art.idmarca,
        mar.descripcion as marcaDescripcion,
        caracteristicas,
        art.descripcion,
        cantidad
    FROM articulos art left join categorias cat 
    ON art.idcategoria = cat.idcategoria
    LEFT JOIN marcas mar on art.idmarca = mar.idmarca;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_cabeceracomprobante` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_cabeceracomprobante`()
BEGIN
select C.NumeroComprobante as "Numero de Comprobante", 
DATE_FORMAT(C.FechaEmision, '%d/%m/%Y') as "Fecha de Emision",
DATE_FORMAT(C.FechaVencimiento, '%d/%m/%Y') as "Fecha de Vencimiento",
C.SubTotal as "Sub Total", C.Igv,
C.Total, P.Nombres as "Proveedores", T.Descripcion as "Tipo de Documento" from cabeceracomprobante C 
inner join proveedores P on C.IdProveedores= P.Id
inner join tiposdocumentos T on C.IdTipoDocumento= T.Id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_cargos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_cargos`()
BEGIN
    SELECT CodigoCargo, Descripcion FROM cargos ORDER BY CodigoCargo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_carreras` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_carreras`()
BEGIN
SELECT*FROM carreras;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_categorias` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_categorias`()
BEGIN
    SELECT CodigoCategoria, Descripcion FROM categorias ORDER BY CodigoCategoria;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_comunicacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_comunicacion`()
BEGIN
select * from listar_vista_comunicaciones limit 50;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_comunicacionesfiltrados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_comunicacionesfiltrados`(in parFiltro char(1),in parFechaInicio varchar(10), in parFechaFin varchar(10), 
in parEstadoCodigo int, 
in parFlujoCodigo int, in parOrigen varchar(100), in parDestino varchar(100)
 )
BEGIN


set @condicion = ' where ';
set @parametrosFiltros = '';
set @comillaSimple = '\'';
set @cadenaParFechas =  if(length(parFechaInicio)=10,concat(' fecha between ', 
															@comillaSimple , parFechaInicio , @comillaSimple,
															' and ' ,@comillaSimple, parFechaFin, @comillaSimple, ' ') , '');														
set @cadenaParEstado = if(length(parEstadoCodigo)> 0, concat(' and Estado = ',  parEstadoCodigo , ' '), '');
set @cadenaParFlujo = if(length(parFlujoCodigo)>0, concat(' and Flujo = ',parFlujoCodigo ,' '), '');
set @cadenaParOrigen = if(length(parOrigen)> 0, concat('  and origen=', @comillaSimple,parOrigen,@comillaSimple , ' '), '');
set @cadenaParDestino = if(length(parDestino)>0, concat(' and destino=',@comillaSimple,parDestino, @comillaSimple , ' '), '');
/*
  set @sqldinamico = concat('select * from listar_vista_comunicaciones ', @condicion,@cadenaParFechas, @cadenaParEstado, 
  @cadenaParFlujo, @cadenaParOrigen , @cadenaParDestino);
  
 
  prepare stmt from @sqldinamico;
 
  EXECUTE stmt;
 select stmt;
 */
 if parFiltro = 'S' then
 
 if length(parOrigen) > 0 then
    
	SELECT 
        `comunicaciones`.`Id` AS `Id`,
        `comunicaciones`.`IdPeriodo` AS `IdPeriodo`,
        `comunicaciones`.`NombreProyecto` AS `NombreProyecto`,
        `comunicaciones`.`Tipo` AS `Tipo`,
        (CASE `comunicaciones`.`Tipo`
            WHEN 0 THEN 'Carta'
            WHEN 1 THEN 'Correo'
            WHEN 2 THEN 'Llamada'
        END) AS `TipoDesc`,
        `comunicaciones`.`CodDoc` AS `CodDoc`,
        `comunicaciones`.`Origen` AS `Origen`,
        `comunicaciones`.`Destino` AS `Destino`,
        `comunicaciones`.`Flujo` AS `Flujo`,
        (CASE `comunicaciones`.`Flujo`
            WHEN 0 THEN 'Emision'
            ELSE 'Recepcion'
        END) AS `FlujoDesc`,
        `comunicaciones`.`Asunto` AS `Asunto`,
        DATE_FORMAT(`comunicaciones`.`Fecha`, '%d/%m/%Y') AS `Fecha`,
        `comunicaciones`.`CodDocRespuesta` AS `CodDocRespuesta`,
        `comunicaciones`.`Estado` AS `Estado`,
        (CASE `comunicaciones`.`Estado`
            WHEN 0 THEN 'Proceso'
            WHEN 1 THEN 'Resuelto'
            WHEN 2 THEN 'Archivado'
        END) AS `EstadoDesc`,
        `comunicaciones`.`Enlace` AS `Enlace`,
        (TO_DAYS(CAST(DATE_FORMAT(NOW(), '%Y-%m-%d') AS DATE)) - TO_DAYS(`comunicaciones`.`Fecha`)) AS `Dias`
    FROM
        `comunicaciones`     
        where fecha >=convert(parFechaInicio,date) and fecha<= convert(parFechaFin,date)        
        and estado = parEstadoCodigo and flujo = parFlujoCodigo
        and origen = parOrigen and destino = parDestino ;
	else
    SELECT 
        `comunicaciones`.`Id` AS `Id`,
        `comunicaciones`.`IdPeriodo` AS `IdPeriodo`,
        `comunicaciones`.`NombreProyecto` AS `NombreProyecto`,
        `comunicaciones`.`Tipo` AS `Tipo`,
        (CASE `comunicaciones`.`Tipo`
            WHEN 0 THEN 'Carta'
            WHEN 1 THEN 'Correo'
            WHEN 2 THEN 'Llamada'
        END) AS `TipoDesc`,
        `comunicaciones`.`CodDoc` AS `CodDoc`,
        `comunicaciones`.`Origen` AS `Origen`,
        `comunicaciones`.`Destino` AS `Destino`,
        `comunicaciones`.`Flujo` AS `Flujo`,
        (CASE `comunicaciones`.`Flujo`
            WHEN 0 THEN 'Emision'
            ELSE 'Recepcion'
        END) AS `FlujoDesc`,
        `comunicaciones`.`Asunto` AS `Asunto`,
        DATE_FORMAT(`comunicaciones`.`Fecha`, '%d/%m/%Y') AS `Fecha`,
        `comunicaciones`.`CodDocRespuesta` AS `CodDocRespuesta`,
        `comunicaciones`.`Estado` AS `Estado`,
        (CASE `comunicaciones`.`Estado`
            WHEN 0 THEN 'Proceso'
            WHEN 1 THEN 'Resuelto'
            WHEN 2 THEN 'Archivado'
        END) AS `EstadoDesc`,
        `comunicaciones`.`Enlace` AS `Enlace`,
        (TO_DAYS(CAST(DATE_FORMAT(NOW(), '%Y-%m-%d') AS DATE)) - TO_DAYS(`comunicaciones`.`Fecha`)) AS `Dias`
    FROM
        `comunicaciones`     
        where fecha >= convert(parFechaInicio,date) and fecha<=convert(parFechaFin,date) 
        and estado = parEstadoCodigo and flujo = parFlujoCodigo;
        
    End if;
    
 Else
 
 
   SELECT 
        `comunicaciones`.`Id` AS `Id`,
        `comunicaciones`.`IdPeriodo` AS `IdPeriodo`,
        `comunicaciones`.`NombreProyecto` AS `NombreProyecto`,
        `comunicaciones`.`Tipo` AS `Tipo`,
        (CASE `comunicaciones`.`Tipo`
            WHEN 0 THEN 'Carta'
            WHEN 1 THEN 'Correo'
            WHEN 2 THEN 'Llamada'
        END) AS `TipoDesc`,
        `comunicaciones`.`CodDoc` AS `CodDoc`,
        `comunicaciones`.`Origen` AS `Origen`,
        `comunicaciones`.`Destino` AS `Destino`,
        `comunicaciones`.`Flujo` AS `Flujo`,
        (CASE `comunicaciones`.`Flujo`
            WHEN 0 THEN 'Emision'
            ELSE 'Recepcion'
        END) AS `FlujoDesc`,
        `comunicaciones`.`Asunto` AS `Asunto`,
        DATE_FORMAT(`comunicaciones`.`Fecha`, '%d/%m/%Y') AS `Fecha`,
        `comunicaciones`.`CodDocRespuesta` AS `CodDocRespuesta`,
        `comunicaciones`.`Estado` AS `Estado`,
        (CASE `comunicaciones`.`Estado`
            WHEN 0 THEN 'Proceso'
            WHEN 1 THEN 'Resuelto'
            WHEN 2 THEN 'Archivado'
        END) AS `EstadoDesc`,
        `comunicaciones`.`Enlace` AS `Enlace`,
        (TO_DAYS(CAST(DATE_FORMAT(NOW(), '%Y-%m-%d') AS DATE)) - TO_DAYS(`comunicaciones`.`Fecha`)) AS `Dias`
    FROM
        `comunicaciones`   ;
        End if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_contactos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_contactos`()
BEGIN
select * from contactos;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_contratosdeproyectos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_contratosdeproyectos`()
BEGIN
Select IdContratoProyecto, cdp.IdProyecto, p.Nombre as NombreProyecto, 
		NroDocumentoProyecto, cdp.IdContratante1, cte.NombreEmpresa,
    FechaInicio, FechaFin, ImporteTotal,  Estado,
    (case when Estado = 'A' then 'Activo' else 'Inactivo' end) as DescripcionEstado, Observacion 
	From contratosdeproyectos  cdp left join Proyectos p on  cdp.idproyecto = p.idproyecto 
    left join contratantes cte on cdp.IdContratante1 =  cte.IdContratante;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_credencial` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_credencial`()
BEGIN
	select * from credenciales;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_cuentas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_cuentas`()
BEGIN
SELECT c.IdCuentaBancaria, c.TipoPropietario, c.Nombres, b.Descripcion AS 'Banco', 
c.NroCuenta AS 'CCC', c.NroCuentaInterbancaria AS 'CCI', c.TipoMoneda
FROM cuentasbancarias c INNER JOIN bancos b ON c.IdBanco = b.IdBanco;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_departamentos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_departamentos`()
BEGIN
	SELECT * FROM departamentos;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_emple` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_emple`()
BEGIN
SELECT E.IdEmpleado as Id, E.Apellidos, 
E.Nombres, DATE_FORMAT(E.FechaNacimiento, '%d/%m/%Y') AS FechaNacimiento, 
E.Correo, E.Dni, E.Celular, E.Distrito, E.Direccion, A.Descripcion AS Area, 
C.Descripcion AS Cargo, T.Descripcion AS "Tip. Empleado"
FROM empleados E INNER JOIN areas A ON E.IdArea = A.IdArea
INNER JOIN cargos C ON  E.IdCargo = C.IdCargo
INNER JOIN tiposempleados T ON E.IdTipoEmpleado = T.IdTipoEmpleado
ORDER BY E.IdEmpleado ASC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_empleados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_empleados`()
BEGIN
SELECT * FROM empleados;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_facultades` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_facultades`()
BEGIN
SELECT * FROM facultades;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_instituciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_instituciones`()
BEGIN
    SELECT * FROM institucioneseducativas;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_marcas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_marcas`()
BEGIN
    SELECT descripcion FROM marcas;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_modulo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_modulo`()
BEGIN
SELECT * FROM modulo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_objetoestudio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_objetoestudio`()
BEGIN
	select * from objetosestudio;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_objetoestudiosxproyecto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_objetoestudiosxproyecto`(in xidproyecto int )
BEGIN
	Select idproyecto, idobjetoestudio, Estado
		from proyectoxobjetoestudio where idproyecto = xidproyecto;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_periodos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_periodos`()
BEGIN
 SELECT  * FROM periodos;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_proveedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_proveedores`()
BEGIN
SELECT
	p.codigoProveedor,
    d.Descripcion,
    p.Nombres,
    p.Direccion,
    p.Correo,
    p.Telefono,
    p.Ruc
FROM proveedores p
INNER JOIN departamentos d
ON d.IdDepartamento = p.IdDepartamento;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_proveedores_departamentos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_proveedores_departamentos`()
BEGIN
	SELECT * FROM departamentos;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_proyectoxcontratante` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_proyectoxcontratante`()
BEGIN
select pytxctt.IdProyecto, ctt.NombreEmpresa , pyt.Nombre, pyt.Servicio
	from proyectoxcontratante pytxctt inner join contratantes ctt  
	on ctt.IdContratante = pytxctt.IdContratante
    inner join proyectos pyt on pyt.IdProyecto = pytxctt.IdProyecto ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_recibos_honorarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_recibos_honorarios`()
BEGIN
    SELECT IdReciboHonorario as Id, NroRecibo, Ruc, Nombres, Apellidos, Distrito, Direccion, 
   FormaPago, Concepto, ImporteNeto, RetencionIr, 
   ImporteTotal, 
   DATE_FORMAT(FechaEmision, '%d/%m/%Y') AS FechaEmision
    FROM reciboshonorarios;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_tipodocumento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_tipodocumento`()
BEGIN
SELECT T.IdTipoDocumento, T.Descripcion,  
		M.Descripcion AS Modulo, M.IdModulo
FROM tiposdocumentos T INNER JOIN modulos M ON T.IdModulo = M.IdModulo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_tipoempleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_tipoempleado`()
BEGIN
	SELECT CodigoTipoEmpleado, Descripcion FROM tiposempleados ORDER BY CodigoTipoEmpleado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_transferencias` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_transferencias`()
BEGIN
    SELECT 
        tb.IdTransferenciaBancaria,
        tb.IdPeriodo,
        tb.NroOperacion,
        tb.CuentaOrigen,
        tb.CuentaDestino,
        tb.Fecha
    FROM 
        transferenciasbancarias tb;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_viaticos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_viaticos`()
BEGIN
SELECT 
	v.IdViatico as Id, 
    v.Descripcion, 
    v.Pasaje, 
    v.Menu, 
    CONCAT(e.Nombres, " ", e.Apellidos) AS Empleado, 
    v.IdPeriodo AS Periodo
FROM viaticos v 
INNER JOIN empleados e 
ON v.IdEmpleado = e.IdEmpleado
ORDER BY IdViatico ASC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_viaticos_empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_viaticos_empleado`()
BEGIN
SELECT 
	IdEmpleado,
    CONCAT(Nombres, " ", Apellidos) AS Nombre_Completo
FROM empleados;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_viaticos_periodo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_viaticos_periodo`()
BEGIN
SELECT 
	IdPeriodo,
    Mes
FROM periodos;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `new_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `new_procedure`(in xIdCredencial int, in xCorreo varchar(200),
    in xClave varchar(200),
    in xAlias varchar(100),
    in xDescripcion varchar(200))
BEGIN
	update credencial 
    set Correo = xCorreo, Clave = xClave, Alias = xAlias, Descripcion = xDescripcion
    where IdCredecnail = xIdCredencial;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_cantidadobjetoestudioxproyecto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_cantidadobjetoestudioxproyecto`(in xidproyecto int, out cantidad int)
BEGIN
	set cantidad  =  (select count(*)  from proyectoxobjetoestudio where idproyecto = xidproyecto);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_cantidad_asistencias` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_cantidad_asistencias`(
IN xDni CHAR(8),
IN xPeriodo int,
OUT xCantidad INT
)
BEGIN
	DECLARE mes INT;
    DECLARE anio INT;
    
    SET mes = substring(xPeriodo, 1, 2);
    SET anio = substring(xPeriodo, 3);
    
    SELECT COUNT(*) INTO xCantidad FROM detalles_asistencia de
	INNER JOIN empleados e ON de.Idempleado = e.Idempleado
	WHERE year(de.Fecha) = anio AND month(de.Fecha) = mes
	AND e.Dni = xDni;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_carrera` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_carrera`(
    IN p_idCarrera INT
)
BEGIN
    SELECT codigoCarrera, descripcion 
    FROM carreras 
    WHERE IdCarrera = p_idCarrera;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_credencial` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_credencial`(
IN xid INT
)
BEGIN
SELECT 
	codigoCredencial, 
    Correo,
    Clave,
    Alias,
    Descripcion
    FROM credenciales
    WHERE IdCredencial = xid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_datos_academicos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_datos_academicos`(
xDni CHAR(8)
)
BEGIN
SELECT i.RazonSocial AS Institucion, f.Descripcion AS Facultad, c.Descripcion AS Carrera, e.Ciclo AS Ciclo, e.CodigoEstudiante AS Codigo
FROM empleados e INNER JOIN institucioneseducativas i
ON e.IdInstitucionEducativa = i.Id
INNER JOIN facultades f ON e.IdFacultad = f.Id
INNER JOIN carreras c ON e.IdCarrera = c.Id
WHERE e.dni = xDni;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_departamento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_departamento`(
IN p_idFacultad INT
)
BEGIN
	SELECT codigoDepartamento, Descripcion
    FROM departamentos
    WHERE IdDepartamento = p_idFacultad;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_detalle_asistencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_detalle_asistencia`(
IN xDni CHAR(8),
IN xFecha CHAR(10),
OUT xId INT
)
BEGIN
	SELECT de.Id INTO xId FROM detalles_asistencia AS de
    INNER JOIN empleados AS e ON de.Id_empleado = e.ID
    WHERE e.Dni = xDni AND de.Fecha = STR_TO_DATE(xFecha, '%d/%m/%Y');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_facultad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_facultad`(
    IN p_idInstitucion INT
)
BEGIN
    SELECT codigoFacultad, Descripcion
    FROM facultades
    WHERE IdFacultad = p_idInstitucion;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_horario_empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_horario_empleado`(
IN xDni CHAR(8),
IN xFecha CHAR(10)
)
BEGIN
SELECT de.Hora_entrada, de.Hora_salida, de.Duracion, de.Observaciones
FROM detalles_asistencia de INNER JOIN empleados e ON de.idempleado = e.Idempleado;
/*WHERE de.Fecha = STR_TO_DATE(xFecha, '%d/%m/%Y') AND e.DNI = xDni;*/
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_id_asistencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_id_asistencia`(
    IN xDni CHAR(8),
    IN xFecha CHAR(10),
    IN xHora CHAR(8),
    OUT xId INT
)
BEGIN
	SELECT Id INTO xId
    FROM asistencias
    WHERE Dni = xDni AND Fecha = STR_TO_DATE(xFecha, '%d/%m/%Y') AND Hora = xHora;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_id_detalle_asistencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_id_detalle_asistencia`(
IN xDni CHAR(8),
IN xFecha CHAR(10),
IN xHoraEntrada CHAR(8),
OUT xId INT
)
BEGIN
	SELECT de.Id INTO xId FROM detalles_asistencia de
	INNER JOIN empleados e ON de.Idempleado = e.Idempleado
	WHERE e.Dni = xDni AND de.Fecha = str_to_date(xFecha, '%d/%m/%Y')
    AND de.Hora_entrada = xHoraEntrada;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_institucion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_institucion`(
    IN p_idInstitucion INT
)
BEGIN
    SELECT codigoInstituciones, Ruc, RazonSocial, Direccion, Sede 
    FROM institucioneseducativas 
    WHERE IdInstitucionEducativa = p_idInstitucion;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_institucion_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_institucion_id`(
IN idInstitucion INT
)
BEGIN
    SELECT codigoInstituciones, Ruc, RazonSocial, Direccion, Sede 
    FROM institucioneseducativas 
    WHERE IdInstitucionEducativa = idInstitucion;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_proveedor`(
    IN p_id INT
)
BEGIN
    SELECT p.codigoProveedor, d.Descripcion, p.Nombres, p.Direccion, p.Correo, p.Telefono, p.Ruc
	FROM proveedores p
	JOIN departamentos d 
	USING(IdDepartamento)
    WHERE p.IdProveedor = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_proyectosxcontratante` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_proyectosxcontratante`(in idcontratante int )
BEGIN
select pytxctt.IdProyecto, ctt.NombreEmpresa , pyt.Nombre, pyt.Servicio
	from proyectoxcontratante pytxctt inner join contratantes ctt  
	on ctt.IdContratante = pytxctt.IdContratante
    inner join proyectos pyt on pyt.IdProyecto = pytxctt.IdProyecto 
    where pytxctt.IdContratante  = idcontratante;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `listar_vista_comunicaciones`
--

/*!50001 DROP VIEW IF EXISTS `listar_vista_comunicaciones`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `listar_vista_comunicaciones` AS select `comunicaciones`.`IdComunicacion` AS `Id`,`comunicaciones`.`IdPeriodo` AS `IdPeriodo`,`comunicaciones`.`NombreProyecto` AS `NombreProyecto`,`comunicaciones`.`Tipo` AS `Tipo`,(case `comunicaciones`.`Tipo` when 0 then 'Carta' when 1 then 'Correo' when 2 then 'Llamada' end) AS `TipoDesc`,`comunicaciones`.`CodDoc` AS `CodDoc`,`comunicaciones`.`Origen` AS `Origen`,`comunicaciones`.`Destino` AS `Destino`,`comunicaciones`.`Flujo` AS `Flujo`,(case `comunicaciones`.`Flujo` when 0 then 'Emision' else 'Recepcion' end) AS `FlujoDesc`,`comunicaciones`.`Asunto` AS `Asunto`,date_format(`comunicaciones`.`Fecha`,'%d/%m/%Y') AS `Fecha`,`comunicaciones`.`CodDocRespuesta` AS `CodDocRespuesta`,`comunicaciones`.`estado` AS `Estado`,(case `comunicaciones`.`estado` when 0 then 'Proceso' when 1 then 'Resuelto' when 2 then 'Archivado' end) AS `EstadoDesc`,`comunicaciones`.`Enlace` AS `Enlace`,(to_days(cast(date_format(now(),'%Y-%m-%d') as date)) - to_days(`comunicaciones`.`Fecha`)) AS `Dias` from `comunicaciones` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `verproductosxalmacen`
--

/*!50001 DROP VIEW IF EXISTS `verproductosxalmacen`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `verproductosxalmacen` AS select `art`.`IdArticulo` AS `IdArticulo`,`art`.`descripcion` AS `nombrearticulo`,`almxart`.`anio` AS `anio`,`almxart`.`mes` AS `mes`,`almxart`.`cantidad` AS `cantidad`,`alm`.`idalmacen` AS `idalmacen`,`alm`.`descripcion` AS `nombrealmacen`,`almxart`.`movimiento` AS `movimiento` from ((`almacenxarticulo` `almxart` join `articulos` `art` on((`almxart`.`idarticulo` = `art`.`IdArticulo`))) join `almacenes` `alm` on((`almxart`.`idalmacen` = `alm`.`idalmacen`))) */;
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

-- Dump completed on 2025-04-25 16:39:10
