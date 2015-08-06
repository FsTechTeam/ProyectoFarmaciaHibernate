-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: localhost    Database: proyectobdfa
-- ------------------------------------------------------
-- Server version	5.5.15

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
-- Table structure for table `Articulo`
--

DROP TABLE IF EXISTS `Articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Articulo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `can` int(11) DEFAULT '0',
  `des` varchar(200) DEFAULT NULL,
  `pco` double DEFAULT NULL,
  `por` double DEFAULT NULL,
  `pve` double DEFAULT NULL,
  `tipo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_articulo_tipo_idx` (`tipo_id`),
  KEY `FKBA9B58FBDBE8349E` (`tipo_id`),
  CONSTRAINT `FKBA9B58FBDBE8349E` FOREIGN KEY (`tipo_id`) REFERENCES `Tipo` (`id`),
  CONSTRAINT `fk_articulo_tipo` FOREIGN KEY (`tipo_id`) REFERENCES `tipo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Articulo`
--

LOCK TABLES `Articulo` WRITE;
/*!40000 ALTER TABLE `Articulo` DISABLE KEYS */;
INSERT INTO `Articulo` VALUES (1,1,'ARTICULO 1',349.78,565.6,550,1),(2,37,'ARTICULO 2',15.65,15.2,14.56,2),(3,0,'ASOFARMA',10.5,56.7,14.56,3),(4,25,'ACITIP',389.5,567.82,550,3),(5,19,'PRODUCTO 1',10.2,45.4,19.2,1),(6,12,'Producto 2',1,3,2,2),(7,0,'FAKTU',10000,10023,11000,4),(8,0,'FAKTU UNGUENTO',2,3,5,1);
/*!40000 ALTER TABLE `Articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CompraCab`
--

DROP TABLE IF EXISTS `CompraCab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CompraCab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `hora` varchar(45) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `proveedor_id` int(11) NOT NULL,
  `funcionario_id` int(11) NOT NULL,
  `NFactura` varchar(100) DEFAULT NULL,
  `Serie` varchar(100) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_compracab_proveedor1_idx` (`proveedor_id`),
  KEY `fk_compracab_funcionario1_idx` (`funcionario_id`),
  KEY `FK242519462A321C16` (`proveedor_id`),
  KEY `FK24251946B80887F6` (`funcionario_id`),
  CONSTRAINT `FK242519462A321C16` FOREIGN KEY (`proveedor_id`) REFERENCES `Proveedor` (`id`),
  CONSTRAINT `FK24251946B80887F6` FOREIGN KEY (`funcionario_id`) REFERENCES `Funcionario` (`id`),
  CONSTRAINT `fk_compracab_funcionario1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compracab_proveedor1` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CompraCab`
--

LOCK TABLES `CompraCab` WRITE;
/*!40000 ALTER TABLE `CompraCab` DISABLE KEYS */;
INSERT INTO `CompraCab` VALUES (1,'2015-07-07','16:22:29',3497.8,1,1,NULL,NULL,1),(2,'2015-07-07','16:23:38',903.01,1,1,NULL,NULL,2),(3,'2015-07-07','17:13:16',136.3,1,1,NULL,NULL,3),(4,'2015-07-08','07:13:57',3895,1,1,NULL,NULL,4),(5,'2015-07-08','15:00:43',1525.12,1,1,NULL,NULL,5),(6,'2015-07-08','15:06:55',699.56,1,1,NULL,NULL,6),(7,'2015-01-01','12:47:07',31.3,1,1,NULL,NULL,7),(8,'2015-07-26','23:23:34',389.5,1,1,NULL,NULL,8),(9,'2015-07-26','23:51:56',389.5,1,1,'1234','A',9),(10,'2015-07-26','23:54:54',2,1,1,'12345','A',10),(11,'2014-12-29','23:56:22',3497.8,2,1,'123456','A',11),(12,'2014-12-29','00:02:22',31.5,6,1,'67896','A',12),(13,'2014-12-29','00:06:36',10.2,1,1,'8787','A',13),(14,'2014-12-29','00:07:09',704.25,4,1,'1234','A',14),(15,'2014-12-29','21:52:54',102,1,1,'12345','A',15),(16,'2014-12-29','13:02:38',6995.6,1,1,'213','23',16),(17,'2014-12-29','13:09:05',3497.8,2,1,'3241','A',17),(18,'2015-07-30','15:03:42',381.08,2,1,'1234','A',18),(19,'2015-07-30','15:05:47',31.3,2,1,'666','ABC',19),(20,'2015-07-30','15:09:32',349.78,1,1,'54321','cba',20),(21,'2015-07-21','16:43:02',5325.62,2,1,'4567','A',21),(22,'2015-07-30','17:50:38',1509.12,4,1,'4444','A',22),(23,'2015-07-30','17:59:39',1758.9,1,1,'5555','A',23),(24,'2015-07-30','18:46:08',5842.5,1,1,'455','A',24);
/*!40000 ALTER TABLE `CompraCab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CompraDet`
--

DROP TABLE IF EXISTS `CompraDet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CompraDet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT NULL,
  `importe` double DEFAULT NULL,
  `articulo_id` int(11) NOT NULL,
  `cabecera_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_compradet_articulo1_idx` (`articulo_id`),
  KEY `fk_compradet_compracab1_idx` (`cabecera_id`),
  KEY `FK24251D95E8E2D3E` (`articulo_id`),
  KEY `FK24251D95874F8A4A` (`cabecera_id`),
  CONSTRAINT `FK24251D95874F8A4A` FOREIGN KEY (`cabecera_id`) REFERENCES `CompraCab` (`id`),
  CONSTRAINT `FK24251D95E8E2D3E` FOREIGN KEY (`articulo_id`) REFERENCES `Articulo` (`id`),
  CONSTRAINT `fk_compradet_articulo1` FOREIGN KEY (`articulo_id`) REFERENCES `articulo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compradet_compracab1` FOREIGN KEY (`cabecera_id`) REFERENCES `compracab` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CompraDet`
--

LOCK TABLES `CompraDet` WRITE;
/*!40000 ALTER TABLE `CompraDet` DISABLE KEYS */;
INSERT INTO `CompraDet` VALUES (1,10,3497.8,1,1),(2,13,203.45,2,2),(3,2,699.56,1,2),(4,10,105,3,3),(5,2,31.3,2,3),(6,10,3895,4,4),(7,12,126,3,5),(8,4,1399.12,1,5),(9,2,699.56,1,6),(10,2,31.3,2,7),(11,1,389.5,4,8),(12,1,389.5,4,9),(13,2,2,6,10),(14,10,3497.8,1,11),(15,3,31.5,3,12),(16,1,10.2,5,13),(17,45,704.25,2,14),(18,10,102,5,15),(19,20,6995.6,1,16),(20,10,3497.8,1,17),(21,1,349.78,1,18),(22,2,31.3,2,18),(23,2,31.3,2,19),(24,1,349.78,1,20),(25,10,3895,4,21),(26,4,1399.12,1,21),(27,3,31.5,3,21),(28,4,8,8,22),(29,10,102,5,22),(30,4,1399.12,1,22),(31,5,1748.9,1,23),(32,10,10,6,23),(33,15,5842.5,4,24);
/*!40000 ALTER TABLE `CompraDet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Lote`
--

DROP TABLE IF EXISTS `Lote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Lote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FechaV` date NOT NULL,
  `NLote` int(11) NOT NULL,
  `articulo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Lote_articulo1_idx` (`articulo_id`),
  KEY `FK243B54E8E2D3E` (`articulo_id`),
  CONSTRAINT `FK243B54E8E2D3E` FOREIGN KEY (`articulo_id`) REFERENCES `Articulo` (`id`),
  CONSTRAINT `fk_Lote_articulo1` FOREIGN KEY (`articulo_id`) REFERENCES `articulo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Lote`
--

LOCK TABLES `Lote` WRITE;
/*!40000 ALTER TABLE `Lote` DISABLE KEYS */;
/*!40000 ALTER TABLE `Lote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Proveedor`
--

DROP TABLE IF EXISTS `Proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Proveedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `des` varchar(200) DEFAULT NULL,
  `dir` varchar(200) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `nit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Proveedor`
--

LOCK TABLES `Proveedor` WRITE;
/*!40000 ALTER TABLE `Proveedor` DISABLE KEYS */;
INSERT INTO `Proveedor` VALUES (1,'LABYMED','LABYMED','213123','LABYMED@CORREO',NULL),(2,'PROVEEDOR 1','PROVEEDOR 1','923823','PROVEDOR@PROVEEDOR.COM',NULL),(3,'PROVEEDOR2','PROVEEDOR2','23123','PASDSAD@ASDAS.COM',NULL),(4,'MICRO','XXXX','21312','XXXXX',NULL),(6,'PINOS','XX','2131','XXXXX',NULL),(7,'zoltum','dsaasd','123','21312',NULL),(12,'PROVEEDOR 3','DSADSA','31212','ASDASD','21312312'),(13,'LABYMED 1','SDAS','321','DSADAS','321312'),(24,'lester','funciona','3123','23131',NULL),(34,'jali','das','2312','dasdas',NULL),(45,'bali','dsad','2312','sada',NULL);
/*!40000 ALTER TABLE `Proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `VentaCab`
--

DROP TABLE IF EXISTS `VentaCab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `VentaCab` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `hora` varchar(200) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `cliente_id` int(11) NOT NULL,
  `funcionario_id` int(11) NOT NULL,
  `pagado` tinyint(1) DEFAULT '0',
  `numOrden` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`num`),
  KEY `fk_ventacab_cliente1_idx` (`cliente_id`),
  KEY `fk_ventacab_funcionario1_idx` (`funcionario_id`),
  KEY `FK86BF4DF8B80887F6` (`funcionario_id`),
  KEY `FK86BF4DF8A6E0D96` (`cliente_id`),
  CONSTRAINT `FK86BF4DF8A6E0D96` FOREIGN KEY (`cliente_id`) REFERENCES `Cliente` (`id`),
  CONSTRAINT `FK86BF4DF8B80887F6` FOREIGN KEY (`funcionario_id`) REFERENCES `Funcionario` (`id`),
  CONSTRAINT `fk_ventacab_cliente1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ventacab_funcionario1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `VentaCab`
--

LOCK TABLES `VentaCab` WRITE;
/*!40000 ALTER TABLE `VentaCab` DISABLE KEYS */;
INSERT INTO `VentaCab` VALUES (1,'2015-07-07','16:38:30',43.68,2,1,0,NULL),(2,'2015-07-07','23:19:38',5776.64,3,1,0,NULL),(3,'2015-07-08','15:02:02',5703.84,4,1,0,NULL),(4,'2015-07-08','15:03:42',2750,5,1,0,NULL),(5,'2015-07-16','12:47:39',14.56,6,1,0,NULL),(6,'2015-07-23','12:21:46',1679.12,7,1,0,NULL),(7,'2015-07-30','18:29:04',11647.8,1,1,0,NULL),(8,'2015-07-30','18:31:06',627.44,1,1,0,NULL),(9,'2015-07-30','18:35:28',1688.76,1,1,0,NULL),(10,'2015-07-30','18:37:21',28050,1,1,0,NULL),(11,'2015-07-30','18:49:29',116.48,1,1,0,NULL);
/*!40000 ALTER TABLE `VentaCab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `VentaDet`
--

DROP TABLE IF EXISTS `VentaDet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `VentaDet` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `cant` int(11) DEFAULT NULL,
  `importe` double DEFAULT NULL,
  `articulo_id` int(11) NOT NULL,
  `ventaCab_num` int(11) NOT NULL,
  PRIMARY KEY (`num`),
  KEY `fk_ventadet_articulo1_idx` (`articulo_id`),
  KEY `fk_ventadet_ventacab1_idx` (`ventaCab_num`),
  KEY `FK86BF5247E8E2D3E` (`articulo_id`),
  KEY `FK86BF5247874317FB` (`ventaCab_num`),
  CONSTRAINT `FK86BF5247874317FB` FOREIGN KEY (`ventaCab_num`) REFERENCES `VentaCab` (`num`),
  CONSTRAINT `FK86BF5247E8E2D3E` FOREIGN KEY (`articulo_id`) REFERENCES `Articulo` (`id`),
  CONSTRAINT `fk_ventadet_articulo1` FOREIGN KEY (`articulo_id`) REFERENCES `articulo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ventadet_ventacab1` FOREIGN KEY (`ventaCab_num`) REFERENCES `ventacab` (`num`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `VentaDet`
--

LOCK TABLES `VentaDet` WRITE;
/*!40000 ALTER TABLE `VentaDet` DISABLE KEYS */;
INSERT INTO `VentaDet` VALUES (1,3,43.68,2,1),(2,9,131.04,3,2),(3,10,145.6,2,2),(4,10,5500,1,2),(5,10,5500,4,3),(6,12,174.72,3,3),(7,2,29.12,2,3),(8,5,2750,1,4),(9,1,14.56,3,5),(10,2,29.12,2,6),(11,3,1650,1,6),(12,1,550,1,7),(13,1,11000,7,7),(14,5,25,8,7),(15,5,72.8,3,7),(16,4,58.24,2,8),(17,1,550,1,8),(18,1,19.2,5,8),(19,1,550,1,9),(20,1,14.56,3,9),(21,1,5,8,9),(22,2,1100,4,9),(23,1,19.2,5,9),(24,51,28050,1,10),(25,8,116.48,2,11);
/*!40000 ALTER TABLE `VentaDet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `des` varchar(45) DEFAULT NULL,
  `dir` varchar(45) DEFAULT NULL,
  `ruc` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'EULAR','Direccion','BAUTISTA','77777777'),(2,'CARLOS','Direccion','LOPEZ','77777777'),(3,'JENNER','Direccion','CARDONA','77777777'),(4,'GERSON','Direccion','VILLA DE COYOY','77777777'),(5,'XXXX','Direccion','XXXX','77777777'),(6,'usuario','Direccion','skjasd','77777777'),(7,'LESTER ','Direccion','Meneses','77777777');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(45) DEFAULT NULL,
  `cargo` varchar(45) DEFAULT NULL,
  `dir` varchar(45) DEFAULT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Bautista','Contabilidad','ciudad','Dr. Eular','123123');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `des` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (1,'PRESENTACION1'),(2,'PRESENTACION 2'),(3,'40 MGS'),(4,'POMADA');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-30 22:38:59
