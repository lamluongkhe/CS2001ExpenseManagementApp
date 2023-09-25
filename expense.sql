-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: expense
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Freelance','Income'),(2,'Salary','Income'),(3,'Entertainment','Expense'),(4,'Transportation','Expense'),(5,'Shopping','Expense');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `messageContent` varchar(255) DEFAULT NULL,
  `timeStamp` date DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CHAT_USER_idx` (`user_id`),
  CONSTRAINT `FK_CHAT_USER` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupmember`
--

DROP TABLE IF EXISTS `groupmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groupmember` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `teamgroup_id` int NOT NULL,
  `roleingroup` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_GROUPMEMBER_USER_idx` (`user_id`),
  KEY `FK_GROUPMEMBER_TEAMGROUP_idx` (`teamgroup_id`),
  CONSTRAINT `FK_GROUPMEMBER_TEAMGROUP` FOREIGN KEY (`teamgroup_id`) REFERENCES `teamgroup` (`id`),
  CONSTRAINT `FK_GROUPMEMBER_USER` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupmember`
--

LOCK TABLES `groupmember` WRITE;
/*!40000 ALTER TABLE `groupmember` DISABLE KEYS */;
INSERT INTO `groupmember` VALUES (1,1,1,'Admin'),(2,3,2,'Admin'),(3,4,3,'Admin'),(4,2,1,'User'),(5,3,1,'User');
/*!40000 ALTER TABLE `groupmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grouptransaction`
--

DROP TABLE IF EXISTS `grouptransaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grouptransaction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `transaction_id` int NOT NULL,
  `teamgroup_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_GROUPTRANSACTION_TRANSACTION_idx` (`transaction_id`),
  KEY `FK_GROUPTRANSACTION_TEAMGROUP_idx` (`teamgroup_id`),
  CONSTRAINT `FK_GROUPTRANSACTION_TEAMGROUP` FOREIGN KEY (`teamgroup_id`) REFERENCES `teamgroup` (`id`),
  CONSTRAINT `FK_GROUPTRANSACTION_TRANSACTION` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grouptransaction`
--

LOCK TABLES `grouptransaction` WRITE;
/*!40000 ALTER TABLE `grouptransaction` DISABLE KEYS */;
INSERT INTO `grouptransaction` VALUES (2,6,1);
/*!40000 ALTER TABLE `grouptransaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifications` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `NotificationDate` datetime NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_NOTIFICATIONS_USER_idx` (`user_id`),
  CONSTRAINT `FK_NOTIFICATIONS_USER` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES (1,'New message!','2023-08-21 09:30:00',1),(2,'Task reminder','2023-08-21 14:00:00',2),(3,'Event alert','2023-08-21 16:45:00',3);
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teamgroup`
--

DROP TABLE IF EXISTS `teamgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teamgroup` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teamgroup`
--

LOCK TABLES `teamgroup` WRITE;
/*!40000 ALTER TABLE `teamgroup` DISABLE KEYS */;
INSERT INTO `teamgroup` VALUES (1,'Friends'),(2,'Family'),(3,'Colleagues');
/*!40000 ALTER TABLE `teamgroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `amount` int NOT NULL,
  `type` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `category_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_TRANSACTION_CATEGORY_idx` (`category_id`),
  KEY `FK_TRANSACTION_USER_idx` (`user_id`),
  CONSTRAINT `FK_TRANSACTION_CATEGORY` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FK_TRANSACTION_USER` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (2,'2023-01-10',-50,'Expense','Grocery Shopping','Bought groceries',5,3),(3,'2023-03-10',-30,'Expense','Eating Out','Dinner with friends',1,4),(4,'2023-11-01',300,'Income','Freelance Gie','Web design project',3,3),(5,'2023-05-15',-20,'Expense','Transportation','Bus fare',4,11),(6,'2023-02-18',-15,'Expense','Entertainment','Movie tickets',3,6),(7,'2023-12-20',-10,'Expense','Shopping','New shirt',5,3),(17,'2022-07-03',120,'Income','Helu','aaaaaa',1,4),(18,'2023-08-03',200,'Income','asdada','aasdsa',1,2),(19,'2023-08-10',560,'Income','hjgk','6767',2,3),(20,'2022-07-30',-20,'Expense','aaa','bbb',1,4),(21,'2023-10-01',30,'Income','hello','hi',2,4),(22,'2022-03-06',200,'Income','Hello','sadasd',1,3),(23,'2023-09-03',-10,'Expense','aaaa','adasd',1,2);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(100) NOT NULL,
  `active` bit(1) DEFAULT b'1',
  `avatar` varchar(255) DEFAULT NULL,
  `user_role` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'khe@gmail','Khe','Lam','1111','khe','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','https://res.cloudinary.com/dnjmavk9l/image/upload/v1693285329/lkpxhfcwz0ayw7xlpkg0.png','ROLE_ADMIN'),(2,'nhan@gmail.com','Nhan','Ho','2222','nhan','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','','ROLE_USER'),(3,'vinh@gmail.com','Vinh','Mai','3333','vinh','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','https://res.cloudinary.com/dnjmavk9l/image/upload/v1693285329/lkpxhfcwz0ayw7xlpkg0.png','ROLE_USER'),(4,'quynh@gmail.com','Quynh','Pham','4444','quynh','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','https://res.cloudinary.com/dnjmavk9l/image/upload/v1693285329/lkpxhfcwz0ayw7xlpkg0.png','ROLE_USER'),(6,'nga@gmail.com','Nga','Hoang','5555','Nga','$2a$10$5xlOUcCWH.GLFBX9PAEqT.PeBAFPh5XJdeJDOvXOO255K6kS5xWLq',_binary '','https://res.cloudinary.com/dnjmavk9l/image/upload/v1693285329/lkpxhfcwz0ayw7xlpkg0.png','ROLE_USER'),(11,'u@gmail.com','Phat','Pham','77777','u','$2a$10$OvWUO6R162TxNttXhxYqueZHrzzq/0.ND2N5exTgz79CVfWt6lpXu',_binary '','https://res.cloudinary.com/dnjmavk9l/image/upload/v1693392091/g7obg926qdoax0tgarwz.jpg','ROLE_USER'),(12,'ly@gmail.com','Cai','Ly','888888','ly','$2a$10$qBkDl17LWWtpO8cXhsHVDO456CjLqpwXUo88ywnh.9ADv41yD.t5u',_binary '',NULL,'ROLE_USER'),(16,'nhi@gmail.com','Huan','Nhi','101010','Nhi','$2a$10$aPmiY7ilviohMPOF9tquyO2SPbJWuTB5ypL8vpMQE0/j0cH3gKl3O',_binary '\0','https://res.cloudinary.com/dnjmavk9l/image/upload/v1693736732/fi2axwnhmyykv4nlfyvw.jpg','ROLE_USER');
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

-- Dump completed on 2023-09-08 19:18:19
