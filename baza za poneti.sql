-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: izdavanjenekretnina
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `grad`
--

DROP TABLE IF EXISTS `grad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grad` (
  `IDgrad` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(35) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`IDgrad`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grad`
--

LOCK TABLES `grad` WRITE;
/*!40000 ALTER TABLE `grad` DISABLE KEYS */;
INSERT INTO `grad` VALUES (1,'Beograd'),(2,'Zrednjanin'),(3,'Vrsac'),(4,'Nis'),(5,'Kragujevac'),(6,'Uzice'),(7,'Pristina'),(8,'Subotica'),(9,'Arilje'),(10,''),(11,'Sabac'),(12,'Zrenjanin'),(13,'Mladenovac'),(14,'Novi Sad'),(15,'Ub'),(16,'Ljig'),(17,'Cacak'),(18,'Pec'),(19,'Visibaba');
/*!40000 ALTER TABLE `grad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grejanje`
--

DROP TABLE IF EXISTS `grejanje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grejanje` (
  `IDgrejanje` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`IDgrejanje`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grejanje`
--

LOCK TABLES `grejanje` WRITE;
/*!40000 ALTER TABLE `grejanje` DISABLE KEYS */;
INSERT INTO `grejanje` VALUES (1,'Centralno'),(2,'Drva'),(3,'Ugalj'),(4,'Plin'),(5,'Struja'),(6,'Klima'),(7,'Pelet');
/*!40000 ALTER TABLE `grejanje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iznajmljivanja`
--

DROP TABLE IF EXISTS `iznajmljivanja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `iznajmljivanja` (
  `IDevidencija_iznajmljivanja` int(11) NOT NULL AUTO_INCREMENT,
  `Broj_iznajmljivanja` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `Kupac` int(11) DEFAULT NULL,
  `Zaposleni` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDevidencija_iznajmljivanja`),
  KEY `iznajmljivanje=>kupac_idx` (`Kupac`),
  KEY `iz=>zzap_idx` (`Zaposleni`),
  CONSTRAINT `iz=>zzap` FOREIGN KEY (`Zaposleni`) REFERENCES `zaposleni` (`idzaposleni`) ON UPDATE CASCADE,
  CONSTRAINT `iznajmljivanje=>kupac` FOREIGN KEY (`Kupac`) REFERENCES `kupac` (`idkupac`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iznajmljivanja`
--

LOCK TABLES `iznajmljivanja` WRITE;
/*!40000 ALTER TABLE `iznajmljivanja` DISABLE KEYS */;
INSERT INTO `iznajmljivanja` VALUES (1,'001',1,1),(2,'002',2,2),(3,'003',1,1),(4,'004',2,1),(5,'005',1,1),(6,'006',1,1),(7,'007',4,2),(8,'008',3,2),(9,'12',1,1),(10,'12',1,1),(11,'432',1,1),(12,'5676',1,1),(13,'5842',1,1),(14,'22',1,1),(15,'6719',1,1),(16,'858',1,1),(17,'68',1,1),(18,'99',1,1),(19,'44',1,1),(20,'252',1,1),(21,'',1,1),(22,'888',1,1),(23,'58',1,1),(24,'56',1,1),(25,'55',1,1),(26,'56',1,1),(27,'55',1,1),(28,'99',2,2),(29,'100',1,1),(30,'101',1,1),(31,'111',1,1),(32,'103',1,1),(33,'333',1,1),(34,'444',1,1),(35,'35',2,2),(36,'35',1,1),(37,'36',1,1),(38,'40',1,1),(39,'37',1,1),(40,'40',1,1),(41,'41',2,2),(42,'42',1,1),(43,'43',1,1),(44,'44',3,2),(45,'45',4,2),(46,'46',4,2),(47,'47',1,1),(48,'48',4,2),(49,'49',2,1),(50,'50',1,1),(51,'51',1,1),(52,'thrht',1,1);
/*!40000 ALTER TABLE `iznajmljivanja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kupac`
--

DROP TABLE IF EXISTS `kupac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `kupac` (
  `IDkupac` int(11) NOT NULL AUTO_INCREMENT,
  `imeiprezimekupac` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `LKkupca` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `Telkupac` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `Adresakupac` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `Emailkupac` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`IDkupac`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kupac`
--

LOCK TABLES `kupac` WRITE;
/*!40000 ALTER TABLE `kupac` DISABLE KEYS */;
INSERT INTO `kupac` VALUES (1,'Petar Pe','984334UI','065 111888','Njegoseva 68','petrovic@gmail.com'),(2,'Marica Sunjev','00048423','065 555 444','Zlakusa bb','maricas@gmail.com'),(3,'Dejan Deja','99944433','011333422','Beogradska 88','dejanovic@gmail.com'),(4,'Milos Milivojevic','99438388','0612727464','Milene Pavlovic Barili 6','milivojevicm66@gmail.com'),(5,'Dejan Dejannnnnnnnnnn','99944433','011333422','Beogradska 88','dejanovic@gmail.com');
/*!40000 ALTER TABLE `kupac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lokacija`
--

DROP TABLE IF EXISTS `lokacija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lokacija` (
  `IDlokacija` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`IDlokacija`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lokacija`
--

LOCK TABLES `lokacija` WRITE;
/*!40000 ALTER TABLE `lokacija` DISABLE KEYS */;
INSERT INTO `lokacija` VALUES (1,'Centar'),(2,'Zona 1'),(3,'Zona 2'),(4,'Zona 3'),(5,'Zona 4'),(6,'Zona 5');
/*!40000 ALTER TABLE `lokacija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `namestenost`
--

DROP TABLE IF EXISTS `namestenost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `namestenost` (
  `IDnamestenost` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`IDnamestenost`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `namestenost`
--

LOCK TABLES `namestenost` WRITE;
/*!40000 ALTER TABLE `namestenost` DISABLE KEYS */;
INSERT INTO `namestenost` VALUES (1,'Namesten'),(2,'Nenamesten'),(3,'Polunamesten');
/*!40000 ALTER TABLE `namestenost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nekretnina`
--

DROP TABLE IF EXISTS `nekretnina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nekretnina` (
  `IDnekretnina` int(11) NOT NULL AUTO_INCREMENT,
  `SifraNekretnine` varchar(10) COLLATE utf8_bin NOT NULL,
  `TipNekretnine` int(11) NOT NULL,
  `Tip_gradnje` int(11) NOT NULL,
  `Grad` int(11) NOT NULL,
  `Adresa` varchar(25) COLLATE utf8_bin NOT NULL,
  `Lokacija` int(11) NOT NULL,
  `Povrsina` int(11) NOT NULL,
  `Broj_soba` int(11) DEFAULT NULL,
  `Broj_kupatila` int(11) DEFAULT NULL,
  `Namestenost` int(11) NOT NULL,
  `Grejanje` int(11) NOT NULL,
  `Status` varchar(20) COLLATE utf8_bin DEFAULT 'Slobodno',
  PRIMARY KEY (`IDnekretnina`),
  KEY `Nekretnina->Grad_idx` (`Grad`),
  KEY `Nekretnina->Grejanja_idx` (`Grejanje`),
  KEY `Nekretnina->Lokacija_idx` (`Lokacija`),
  KEY `Nekretnina->Namestenost_idx` (`Namestenost`),
  KEY `Nekretnina->tip_gradnje_idx` (`Tip_gradnje`),
  KEY `Nekretnina->tip_nekretnine_idx` (`TipNekretnine`),
  CONSTRAINT `Nekretnina->Grad` FOREIGN KEY (`Grad`) REFERENCES `grad` (`idgrad`) ON UPDATE CASCADE,
  CONSTRAINT `Nekretnina->Grejanja` FOREIGN KEY (`Grejanje`) REFERENCES `grejanje` (`idgrejanje`) ON UPDATE CASCADE,
  CONSTRAINT `Nekretnina->Lokacija` FOREIGN KEY (`Lokacija`) REFERENCES `lokacija` (`idlokacija`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `Nekretnina->Namestenost` FOREIGN KEY (`Namestenost`) REFERENCES `namestenost` (`idnamestenost`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `Nekretnina->tip_gradnje` FOREIGN KEY (`Tip_gradnje`) REFERENCES `tip_gradnje` (`idtip_gradnje`) ON UPDATE CASCADE,
  CONSTRAINT `Nekretnina->tip_nekretnine` FOREIGN KEY (`TipNekretnine`) REFERENCES `tip_nekretnine` (`idtip_nekretnine`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nekretnina`
--

LOCK TABLES `nekretnina` WRITE;
/*!40000 ALTER TABLE `nekretnina` DISABLE KEYS */;
INSERT INTO `nekretnina` VALUES (1,'001',1,1,1,'rgdfgds',1,65,3,2,1,1,'Iznajmljeno'),(2,'002',2,2,3,'Skadarska 26',2,80,3,1,1,4,'Prodato'),(3,'003',3,2,1,'Avala bb',6,45,2,1,3,2,'Prodato'),(4,'2',4,1,1,'Dimitrija Tucovica 65',1,100,4,2,2,6,'Prodato'),(5,'004',4,1,1,'Cumicevo Sokace 34',1,80,0,2,2,6,'Iznajmljeno'),(6,'005',6,2,6,'',4,150,5,2,3,2,'Prodato'),(7,'006',5,1,4,'Negotinska 88',2,30,0,1,2,6,'Prodato'),(8,'007',3,2,15,'Ulica BB',6,50,2,1,1,2,'Iznajmljeno'),(9,'008',4,2,1,'Cumicevo Sokace 34',1,80,0,2,2,6,'Iznajmljeno'),(10,'013',1,1,1,'rgdfgds',1,65,3,2,1,1,'Prodato'),(11,'001',2,1,3,'Skadarska 65',2,90,4,1,3,4,'Prodato'),(12,'333',1,1,1,'rgdfgds',1,65,3,2,1,1,'Prodato'),(13,'777',1,1,1,'rgdfgds',1,65,3,2,1,1,'Prodato'),(14,'009',1,1,1,'Durmitorska',1,75,3,2,1,1,'Iznajmljeno'),(15,'010',2,1,1,'Malog Radojice 16',2,200,5,3,1,1,'Iznajmljeno'),(16,'011',1,1,1,'Milene P.Barili 6',4,75,3,2,1,1,'Prodato'),(17,'012',2,1,1,'Jelezovacka',4,300,6,3,2,2,'Prodato'),(18,'013',4,1,4,'Niska 88',1,250,0,0,2,1,'Prodato'),(19,'015',1,1,1,'15ta',1,44,2,1,1,1,'Iznajmljeno'),(20,'22',1,1,1,'22222222222',1,222222,222,2222,1,1,'Iznajmljeno'),(21,'444',1,1,1,'444444',1,444,4,2,1,1,'Iznajmljeno'),(22,'56',1,1,1,'dasdasdsa',1,400,5,3,1,1,'Prodato'),(23,'99',1,1,1,'99ta',1,99,6,2,1,1,'Prodato'),(24,'100',1,1,1,'Cvetkova 89',1,89,5,2,1,1,'Prodato'),(25,'101',1,1,1,'stoprva 1',1,100,4,2,1,1,'Prodato'),(26,'0000',1,1,1,'cickova 88',1,160,6,3,1,1,'Iznajmljeno'),(27,'333',1,1,1,'',1,33,0,1,1,1,'Iznajmljeno'),(28,'444',1,1,1,'44',1,444,44,4,1,1,'Iznajmljeno'),(29,'555',1,1,1,'55555',1,55,2,1,1,1,'Slobodno'),(30,'888',1,1,1,'99999999',1,99,5,4,1,1,'Iznajmljeno'),(31,'099',1,1,1,'888',1,88,5,1,1,1,'Iznajmljeno'),(32,'089',1,1,1,'89ta ta ta ',1,60,4,1,1,1,'Prodato'),(33,'087',1,1,1,'osamdeset sedmaaa',1,87,4,2,1,1,'Prodato'),(34,'086',1,1,1,'osamdeset i sesta',1,86,5,2,1,1,'Prodato'),(35,'101',1,1,1,'Ciganjska 88',1,88,4,2,1,1,'Slobodno'),(36,'102',1,1,1,'Beogradska',1,100,5,2,1,1,'Slobodno');
/*!40000 ALTER TABLE `nekretnina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodaja`
--

DROP TABLE IF EXISTS `prodaja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `prodaja` (
  `IDevidencija_prodaje` int(11) NOT NULL AUTO_INCREMENT,
  `Datum_prodaje` bigint(20) DEFAULT NULL,
  `Broj_prodaje` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `Kupac` int(11) DEFAULT NULL,
  `Zaposleni` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDevidencija_prodaje`),
  KEY `Prodaja->Kupac_idx` (`Kupac`),
  KEY `Prodaja->Zaposleni_idx` (`Zaposleni`),
  CONSTRAINT `Prodaja->Kupac` FOREIGN KEY (`Kupac`) REFERENCES `kupac` (`idkupac`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `Prodaja->Zaposleni` FOREIGN KEY (`Zaposleni`) REFERENCES `zaposleni` (`idzaposleni`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodaja`
--

LOCK TABLES `prodaja` WRITE;
/*!40000 ALTER TABLE `prodaja` DISABLE KEYS */;
INSERT INTO `prodaja` VALUES (1,1329692400,'001',1,1),(2,1431640800,'002',1,1),(3,1551049200,'3',4,2),(4,1431640800,'4',1,1),(5,1559426400,'010',2,1),(6,1527199200,'013',2,2),(7,0,'42342',1,1),(8,1495922400,'014',1,1),(9,0,'sa',1,1),(10,1529877600,'014',3,2),(11,1532642400,'015',3,2),(12,1535407200,'200',1,1),(13,1569708000,'021',1,1),(14,1437775200,'015',2,2),(15,0,'ss',1,1),(16,1535407200,'016',1,1),(17,1519167600,'019',1,1),(18,1526335200,'019',1,1),(19,0,'4896',1,1),(20,0,'da',1,1),(21,0,'jhkk',1,1),(22,0,'rrv3r',1,1),(23,0,'hihl',1,1),(24,0,'',1,1),(25,0,'kjyk',1,1),(26,0,'kug',1,1),(27,0,'jkjbj',1,1),(28,0,'kl',1,1),(29,1649887200,'17',2,1),(30,0,'wqwq',1,1),(31,990741600,'30',1,1),(32,1116540000,'32',1,1),(33,1219874400,'33',1,1),(34,1398290400,'33',1,1),(35,1552604400,'35',1,1),(36,1029621600,'36',1,1),(37,984438000,'37',1,1),(38,1081893600,'38',1,1),(39,1527458400,'39',1,1),(40,0,'',1,1);
/*!40000 ALTER TABLE `prodaja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stavke_iznajmljivanja`
--

DROP TABLE IF EXISTS `stavke_iznajmljivanja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stavke_iznajmljivanja` (
  `IDstavkeIznajmljivanja` int(11) NOT NULL AUTO_INCREMENT,
  `IDIznajmljivanje` int(11) DEFAULT NULL,
  `Nekretnina` int(11) DEFAULT NULL,
  `Datum_pocetak` bigint(20) DEFAULT NULL,
  `Datum_kraj` bigint(20) DEFAULT NULL,
  `Cena` double DEFAULT NULL,
  PRIMARY KEY (`IDstavkeIznajmljivanja`),
  KEY `stavkeIZN->iznajmljivanja_idx` (`IDIznajmljivanje`),
  KEY `stavkeIZN->nekretnina_idx` (`Nekretnina`),
  CONSTRAINT `stavkeIZN->iznajmljivanja` FOREIGN KEY (`IDIznajmljivanje`) REFERENCES `iznajmljivanja` (`idevidencija_iznajmljivanja`) ON UPDATE CASCADE,
  CONSTRAINT `stavkeIZN->nekretnina` FOREIGN KEY (`Nekretnina`) REFERENCES `nekretnina` (`idnekretnina`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stavke_iznajmljivanja`
--

LOCK TABLES `stavke_iznajmljivanja` WRITE;
/*!40000 ALTER TABLE `stavke_iznajmljivanja` DISABLE KEYS */;
INSERT INTO `stavke_iznajmljivanja` VALUES (1,34,20,1432159200,1434837600,300),(2,35,22,1464127200,1527199200,400),(3,34,20,1432159200,1440108000,300),(4,36,26,1430776800,1436047200,800),(5,39,27,1499378400,1504735200,150),(6,40,28,1396562400,1399154400,500),(7,41,29,1362265200,1370210400,200),(8,41,29,1430776800,1436047200,800),(9,42,30,1520982000,1534197600,500),(10,43,31,1002578400,1020895200,300),(11,44,31,1023660000,1028930400,300),(12,45,32,1116367200,1129586400,250),(13,46,31,1219183200,1250719200,350),(14,47,33,1142290800,1205449200,300),(15,48,33,1423868400,1455404400,300),(16,49,34,1081893600,1092434400,400),(17,50,29,1242770400,1350684000,300),(18,51,29,1353366000,1447974000,300),(19,52,35,1365717600,1527199200,400);
/*!40000 ALTER TABLE `stavke_iznajmljivanja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stavke_prodaje`
--

DROP TABLE IF EXISTS `stavke_prodaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stavke_prodaje` (
  `IDstavke_prodaje` int(11) NOT NULL AUTO_INCREMENT,
  `IDProdaje` int(11) DEFAULT NULL,
  `Nekretnina` int(11) DEFAULT NULL,
  `Cena_po_kvadratu` double DEFAULT NULL,
  PRIMARY KEY (`IDstavke_prodaje`),
  KEY `StavkeNekretnine->Nekretnina_idx` (`IDProdaje`),
  KEY `stavkeProd->nekretnina_idx` (`Nekretnina`),
  CONSTRAINT `stavkePRod->prodaja` FOREIGN KEY (`IDProdaje`) REFERENCES `prodaja` (`idevidencija_prodaje`) ON UPDATE CASCADE,
  CONSTRAINT `stavkeProd->nekretnina` FOREIGN KEY (`Nekretnina`) REFERENCES `nekretnina` (`idnekretnina`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stavke_prodaje`
--

LOCK TABLES `stavke_prodaje` WRITE;
/*!40000 ALTER TABLE `stavke_prodaje` DISABLE KEYS */;
INSERT INTO `stavke_prodaje` VALUES (1,1,5,5000),(2,2,4,2000),(3,3,6,1000),(4,4,12,850),(5,5,11,500),(6,6,13,350),(7,8,6,200),(8,10,6,350),(9,11,2,400),(10,12,4,500),(11,13,7,800),(12,14,8,450),(13,16,10,600),(14,29,17,500),(15,31,24,8000),(16,32,24,7000),(17,34,25,4000),(18,35,29,3000),(19,36,32,400),(20,37,33,500),(21,38,34,400),(22,39,22,400);
/*!40000 ALTER TABLE `stavke_prodaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tip_gradnje`
--

DROP TABLE IF EXISTS `tip_gradnje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tip_gradnje` (
  `IDTip_gradnje` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`IDTip_gradnje`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tip_gradnje`
--

LOCK TABLES `tip_gradnje` WRITE;
/*!40000 ALTER TABLE `tip_gradnje` DISABLE KEYS */;
INSERT INTO `tip_gradnje` VALUES (1,'Novo'),(2,'Staro');
/*!40000 ALTER TABLE `tip_gradnje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tip_nekretnine`
--

DROP TABLE IF EXISTS `tip_nekretnine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tip_nekretnine` (
  `IDtip_nekretnine` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`IDtip_nekretnine`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tip_nekretnine`
--

LOCK TABLES `tip_nekretnine` WRITE;
/*!40000 ALTER TABLE `tip_nekretnine` DISABLE KEYS */;
INSERT INTO `tip_nekretnine` VALUES (1,'Stan'),(2,'Kuca'),(3,'Vikendica'),(4,'Poslovni prostor'),(5,'Kancelarija'),(6,'Kuca na selu'),(7,'Potkrovlje');
/*!40000 ALTER TABLE `tip_nekretnine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zaposleni`
--

DROP TABLE IF EXISTS `zaposleni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `zaposleni` (
  `IDzaposleni` int(11) NOT NULL AUTO_INCREMENT,
  `Sifrazaposleni` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `ImeIPrezimezaposleni` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `Telefonzaposleni` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`IDzaposleni`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zaposleni`
--

LOCK TABLES `zaposleni` WRITE;
/*!40000 ALTER TABLE `zaposleni` DISABLE KEYS */;
INSERT INTO `zaposleni` VALUES (1,'001','Ivan Milicevic','069 007 007'),(2,'002','Djordje Forst','069 444 555');
/*!40000 ALTER TABLE `zaposleni` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-16 15:27:40
