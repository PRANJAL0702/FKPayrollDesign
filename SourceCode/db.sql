-- MySQL dump 10.13  Distrib 8.0.20, for Linux (x86_64)
--
-- Host: localhost    Database: Flipkart
-- ------------------------------------------------------
-- Server version	8.0.20-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `HourlyEmployee`
--

DROP TABLE IF EXISTS `HourlyEmployee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `HourlyEmployee` (
  `id` int NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `LastSalaryDate` date DEFAULT NULL,
  `modeofpayment` varchar(40) DEFAULT NULL,
  `LastPayment` double DEFAULT NULL,
  `Password` varchar(30) DEFAULT '123',
  `Commission` double DEFAULT '0',
  `LastPaymentMadeWay` varchar(30) DEFAULT NULL,
  `hourlyrate` int DEFAULT '100',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HourlyEmployee`
--

LOCK TABLES `HourlyEmployee` WRITE;
/*!40000 ALTER TABLE `HourlyEmployee` DISABLE KEYS */;
INSERT INTO `HourlyEmployee` VALUES (1,'Pranjal','2020-05-10',NULL,800,'123',0,NULL,100),(2,'Shyamu','2020-05-10',NULL,600,'123',0,NULL,100),(3,'Ramu',NULL,NULL,NULL,'123',0,NULL,100),(4,'Riya','2020-05-10','Hand in Hand',0,'123',0,'Hand in Hand',100);
/*!40000 ALTER TABLE `HourlyEmployee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AdminDatabase`
--

DROP TABLE IF EXISTS `AdminDatabase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `AdminDatabase` (
  `Name` varchar(25) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AdminDatabase`
--

LOCK TABLES `AdminDatabase` WRITE;
/*!40000 ALTER TABLE `AdminDatabase` DISABLE KEYS */;
INSERT INTO `AdminDatabase` VALUES ('Admin1','1234'),('Admin2','12345');
/*!40000 ALTER TABLE `AdminDatabase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CommissionTable`
--

DROP TABLE IF EXISTS `CommissionTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CommissionTable` (
  `id` int DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `Commission` double DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CommissionTable`
--

LOCK TABLES `CommissionTable` WRITE;
/*!40000 ALTER TABLE `CommissionTable` DISABLE KEYS */;
/*!40000 ALTER TABLE `CommissionTable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HourlyEmployeeDaily`
--

DROP TABLE IF EXISTS `HourlyEmployeeDaily`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `HourlyEmployeeDaily` (
  `id` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  `hours` int DEFAULT NULL,
  `wageforday` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HourlyEmployeeDaily`
--

LOCK TABLES `HourlyEmployeeDaily` WRITE;
/*!40000 ALTER TABLE `HourlyEmployeeDaily` DISABLE KEYS */;
/*!40000 ALTER TABLE `HourlyEmployeeDaily` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MonthlyEmployee`
--

DROP TABLE IF EXISTS `MonthlyEmployee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MonthlyEmployee` (
  `id` int DEFAULT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `MonthlySalary` double DEFAULT NULL,
  `modeofpayment` varchar(30) DEFAULT NULL,
  `Password` varchar(30) DEFAULT '123',
  `LastPayment` date DEFAULT NULL,
  `Commission` double DEFAULT '0',
  `LastPaymentMade` double DEFAULT NULL,
  `LastPaymentMadeWay` varchar(30) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MonthlyEmployee`
--

LOCK TABLES `MonthlyEmployee` WRITE;
/*!40000 ALTER TABLE `MonthlyEmployee` DISABLE KEYS */;
INSERT INTO `MonthlyEmployee` VALUES (1,'Pranjal',15000,'Cheque','123','2020-05-10',4000,15000,'Draft');
/*!40000 ALTER TABLE `MonthlyEmployee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-10 19:26:42
