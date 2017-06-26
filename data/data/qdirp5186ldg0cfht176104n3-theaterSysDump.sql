-- MySQL dump 10.13  Distrib 5.7.13, for osx10.11 (x86_64)
--
-- Host: 127.0.0.1    Database: theater_system
-- ------------------------------------------------------
-- Server version	5.7.13

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
-- Table structure for table `CreditCard`
--

DROP TABLE IF EXISTS `CreditCard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CreditCard` (
  `number` varchar(20) NOT NULL,
  `expiry` date DEFAULT NULL,
  `name` int(11) DEFAULT NULL,
  PRIMARY KEY (`number`),
  UNIQUE KEY `CreditCard_number_uindex` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CreditCard`
--

LOCK TABLES `CreditCard` WRITE;
/*!40000 ALTER TABLE `CreditCard` DISABLE KEYS */;
/*!40000 ALTER TABLE `CreditCard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Movie`
--

DROP TABLE IF EXISTS `Movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `releaseDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Movie_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movie`
--

LOCK TABLES `Movie` WRITE;
/*!40000 ALTER TABLE `Movie` DISABLE KEYS */;
/*!40000 ALTER TABLE `Movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Screen`
--

DROP TABLE IF EXISTS `Screen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Screen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `size` int(11) DEFAULT NULL,
  `seatingCapacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Screen_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Screen`
--

LOCK TABLES `Screen` WRITE;
/*!40000 ALTER TABLE `Screen` DISABLE KEYS */;
/*!40000 ALTER TABLE `Screen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Screening`
--

DROP TABLE IF EXISTS `Screening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Screening` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `screen_show_movies_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Screening`
--

LOCK TABLES `Screening` WRITE;
/*!40000 ALTER TABLE `Screening` DISABLE KEYS */;
/*!40000 ALTER TABLE `Screening` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Seat`
--

DROP TABLE IF EXISTS `Seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Seat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `row` int(11) DEFAULT NULL,
  `column` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Seat_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Seat`
--

LOCK TABLES `Seat` WRITE;
/*!40000 ALTER TABLE `Seat` DISABLE KEYS */;
/*!40000 ALTER TABLE `Seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Theater`
--

DROP TABLE IF EXISTS `Theater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Theater` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Theater_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Theater`
--

LOCK TABLES `Theater` WRITE;
/*!40000 ALTER TABLE `Theater` DISABLE KEYS */;
/*!40000 ALTER TABLE `Theater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ticket`
--

DROP TABLE IF EXISTS `Ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `credit_card_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `credit_card_book_seat_id_uindex` (`id`),
  KEY `Ticket_CreditCard_number_fk` (`credit_card_number`),
  CONSTRAINT `Ticket_CreditCard_number_fk` FOREIGN KEY (`credit_card_number`) REFERENCES `CreditCard` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ticket`
--

LOCK TABLES `Ticket` WRITE;
/*!40000 ALTER TABLE `Ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `Ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `emailAddress` varchar(255) DEFAULT NULL,
  `postalAddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `User_id_uindex` (`id`),
  UNIQUE KEY `User_name_emailAddress_pk` (`name`,`emailAddress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_actor`
--

DROP TABLE IF EXISTS `movie_actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie_actor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_id` int(11) DEFAULT NULL,
  `actor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `movie_contain_actors_id_uindex` (`id`),
  KEY `movie_contain_actors_Movie_id_fk` (`movie_id`),
  CONSTRAINT `movie_contain_actors_Movie_id_fk` FOREIGN KEY (`movie_id`) REFERENCES `Movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_actor`
--

LOCK TABLES `movie_actor` WRITE;
/*!40000 ALTER TABLE `movie_actor` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie_actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_screening`
--

DROP TABLE IF EXISTS `movie_screening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie_screening` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_id` int(11) DEFAULT NULL,
  `screening_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `movie_screening_id_uindex` (`id`),
  UNIQUE KEY `movie_screening_screening_id_uindex` (`screening_id`),
  KEY `movie_screening_Movie_id_fk` (`movie_id`),
  CONSTRAINT `movie_screening_Movie_id_fk` FOREIGN KEY (`movie_id`) REFERENCES `Movie` (`id`),
  CONSTRAINT `movie_screening_Screening_id_fk` FOREIGN KEY (`screening_id`) REFERENCES `Screening` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_screening`
--

LOCK TABLES `movie_screening` WRITE;
/*!40000 ALTER TABLE `movie_screening` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie_screening` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screen_screening`
--

DROP TABLE IF EXISTS `screen_screening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `screen_screening` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `screen_id` int(11) DEFAULT NULL,
  `screening_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `screen_screening_id_uindex` (`id`),
  UNIQUE KEY `screen_screening_screening_id_uindex` (`screening_id`),
  KEY `screen_screening_Screen_id_fk` (`screen_id`),
  CONSTRAINT `screen_screening_Screen_id_fk` FOREIGN KEY (`screen_id`) REFERENCES `Screen` (`id`),
  CONSTRAINT `screen_screening_Screening_id_fk` FOREIGN KEY (`screening_id`) REFERENCES `Screening` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screen_screening`
--

LOCK TABLES `screen_screening` WRITE;
/*!40000 ALTER TABLE `screen_screening` DISABLE KEYS */;
/*!40000 ALTER TABLE `screen_screening` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screen_seat`
--

DROP TABLE IF EXISTS `screen_seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `screen_seat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `screen_id` int(11) DEFAULT NULL,
  `seat_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `screen_seat_id_uindex` (`id`),
  UNIQUE KEY `screen_seat_seat_id_uindex` (`seat_id`),
  KEY `screen_seat_Screen_id_fk` (`screen_id`),
  CONSTRAINT `screen_seat_Screen_id_fk` FOREIGN KEY (`screen_id`) REFERENCES `Screen` (`id`),
  CONSTRAINT `screen_seat_Seat_id_fk` FOREIGN KEY (`seat_id`) REFERENCES `Seat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screen_seat`
--

LOCK TABLES `screen_seat` WRITE;
/*!40000 ALTER TABLE `screen_seat` DISABLE KEYS */;
/*!40000 ALTER TABLE `screen_seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screen_theater`
--

DROP TABLE IF EXISTS `screen_theater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `screen_theater` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `screen_id` int(11) DEFAULT NULL,
  `theater_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `screen_in_theater_id_uindex` (`id`),
  KEY `screen_in_theater_Screen_id_fk` (`screen_id`),
  KEY `screen_in_theater_Theater_id_fk` (`theater_id`),
  CONSTRAINT `screen_in_theater_Screen_id_fk` FOREIGN KEY (`screen_id`) REFERENCES `Screen` (`id`),
  CONSTRAINT `screen_in_theater_Theater_id_fk` FOREIGN KEY (`theater_id`) REFERENCES `Theater` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screen_theater`
--

LOCK TABLES `screen_theater` WRITE;
/*!40000 ALTER TABLE `screen_theater` DISABLE KEYS */;
/*!40000 ALTER TABLE `screen_theater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theater_phone_numbers`
--

DROP TABLE IF EXISTS `theater_phone_numbers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theater_phone_numbers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theater_id` int(11) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `theater_phone_numbers_id_uindex` (`id`),
  UNIQUE KEY `theater_phone_numbers_phoneNumber_uindex` (`phoneNumber`),
  KEY `theater_phone_numbers_Theater_id_fk` (`theater_id`),
  CONSTRAINT `theater_phone_numbers_Theater_id_fk` FOREIGN KEY (`theater_id`) REFERENCES `Theater` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theater_phone_numbers`
--

LOCK TABLES `theater_phone_numbers` WRITE;
/*!40000 ALTER TABLE `theater_phone_numbers` DISABLE KEYS */;
/*!40000 ALTER TABLE `theater_phone_numbers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_screening`
--

DROP TABLE IF EXISTS `ticket_screening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_screening` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_id` int(11) DEFAULT NULL,
  `screening_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ticket_screening_id_uindex` (`id`),
  UNIQUE KEY `ticket_screening_ticket_id_uindex` (`ticket_id`),
  KEY `ticket_screening_Screening_id_fk` (`screening_id`),
  CONSTRAINT `ticket_screening_Screening_id_fk` FOREIGN KEY (`screening_id`) REFERENCES `Screening` (`id`),
  CONSTRAINT `ticket_screening_Ticket_id_fk` FOREIGN KEY (`ticket_id`) REFERENCES `Ticket` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_screening`
--

LOCK TABLES `ticket_screening` WRITE;
/*!40000 ALTER TABLE `ticket_screening` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket_screening` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_seat`
--

DROP TABLE IF EXISTS `ticket_seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_seat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_id` int(11) DEFAULT NULL,
  `seat_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ticket_seat_id_uindex` (`id`),
  UNIQUE KEY `ticket_seat_ticket_id_uindex` (`ticket_id`),
  KEY `ticket_seat_Seat_id_fk` (`seat_id`),
  CONSTRAINT `ticket_seat_Seat_id_fk` FOREIGN KEY (`seat_id`) REFERENCES `Seat` (`id`),
  CONSTRAINT `ticket_seat_Ticket_id_fk` FOREIGN KEY (`ticket_id`) REFERENCES `Ticket` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_seat`
--

LOCK TABLES `ticket_seat` WRITE;
/*!40000 ALTER TABLE `ticket_seat` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket_seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_credit_card`
--

DROP TABLE IF EXISTS `user_credit_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_credit_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `credit_card_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_credit_card_id_uindex` (`id`),
  KEY `user_credit_card_User_id_fk` (`user_id`),
  KEY `user_credit_card_CreditCard_number_fk` (`credit_card_number`),
  CONSTRAINT `user_credit_card_CreditCard_number_fk` FOREIGN KEY (`credit_card_number`) REFERENCES `CreditCard` (`number`),
  CONSTRAINT `user_credit_card_User_id_fk` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_credit_card`
--

LOCK TABLES `user_credit_card` WRITE;
/*!40000 ALTER TABLE `user_credit_card` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_credit_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_ticket`
--

DROP TABLE IF EXISTS `user_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `ticket_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_ticket_id_uindex` (`id`),
  UNIQUE KEY `user_ticket_ticket_id_uindex` (`ticket_id`),
  KEY `user_ticket_User_id_fk` (`user_id`),
  CONSTRAINT `user_ticket_Ticket_id_fk` FOREIGN KEY (`ticket_id`) REFERENCES `Ticket` (`id`),
  CONSTRAINT `user_ticket_User_id_fk` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_ticket`
--

LOCK TABLES `user_ticket` WRITE;
/*!40000 ALTER TABLE `user_ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-11 22:15:16
