-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: user
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `Qid` int NOT NULL AUTO_INCREMENT,
  `question` varchar(1000) DEFAULT NULL,
  `opt1` varchar(1000) DEFAULT NULL,
  `opt2` varchar(1000) DEFAULT NULL,
  `opt3` varchar(1000) DEFAULT NULL,
  `opt4` varchar(1000) DEFAULT NULL,
  `answer` int DEFAULT NULL,
  PRIMARY KEY (`Qid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'Number of primitive data types in Java are?','6','7','8','9',3),(2,'Who invented Java Programming','Guido van Rossum','James Gosling','Dennis Ritchie','Bjarne Stroustrup',2),(4,'Which one of the following is not a Java feature?','Object-oriented','Use of pointers','Portable','Dynamic and Extensible',2),(5,'What is the extension of java code files?','.txt','.txt','.class','.java',4),(6,'Which environment variable is used to set the java path?','JavaPATH','JavaPATH','JAVA','JAVA_HOME',4),(7,'What is not the use of “this” keyword in Java?','Passing itself to the method of the same class','Passing itself to the method of the same class','Passing itself to another method','Calling another constructor in constructor chaining',2),(10,'What is the extension of compiled java classes?','.js','.js','.class','.java',6),(11,'Which exception is thrown when java is out of memory?','MemoryError','OutOfMemoryError','MemoryOutOfBoundsException','MemoryFullException',2),(12,' Which of these are selection statements in Java?','break','continue','for()','if()',4),(13,'Which statement is true about Java?',' Java is a sequence-dependent programming language',' Java is a code dependent programming language','Java is a platform-dependent programming language','Java is a platform-independent programming language',4);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `city` varchar(45) DEFAULT NULL,
  `mailid` varchar(45) NOT NULL,
  `mobileno` varchar(15) DEFAULT NULL,
  `result` int DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (2,'shraddha','pisal','shraddha','shraddha123','pune','shraddha@gmail.com','927398126',4),(3,'monika','mohite','monika','monika123','pune','monika@gmail.com','390720975',NULL),(4,'shreya','thorat','shreya','shreya123','pune','shreya@gamil.com','7637831511',6),(5,'vinod','patil','vinod123','vinod123','karad','vinod@gmail.com','9786764565',4),(6,'meena','mane','meena123','meena@123','pune','meena@gmail.com','1263172412',5);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'user'
--

--
-- Dumping routines for database 'user'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-06 17:59:38
