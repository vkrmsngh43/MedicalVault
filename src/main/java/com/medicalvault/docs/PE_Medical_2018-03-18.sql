# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.17)
# Database: PE_Medical
# Generation Time: 2018-03-18 16:05:50 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table t_access_request_records
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_access_request_records`;

CREATE TABLE `t_access_request_records` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `requested_by_user_id` int(11) unsigned NOT NULL,
  `access_code` varchar(11) DEFAULT NULL,
  `access_code_generated_at` datetime DEFAULT NULL,
  `status` varchar(16) DEFAULT NULL,
  `access_code_ttl` int(5) NOT NULL DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_USER_ID2` (`user_id`),
  KEY `FK_USER_ID3` (`requested_by_user_id`),
  CONSTRAINT `FK_USER_ID2` FOREIGN KEY (`user_id`) REFERENCES `t_users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_USER_ID3` FOREIGN KEY (`requested_by_user_id`) REFERENCES `t_users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_access_request_records` WRITE;
/*!40000 ALTER TABLE `t_access_request_records` DISABLE KEYS */;

INSERT INTO `t_access_request_records` (`id`, `user_id`, `requested_by_user_id`, `access_code`, `access_code_generated_at`, `status`, `access_code_ttl`, `created_at`, `updated_at`)
VALUES
	(1,10102,10101,'987678','2018-03-17 18:21:13','GENERATED',600000,NULL,'2018-03-17 18:21:13'),
	(2,10102,10101,'373194','2018-03-18 10:07:49','Expired',600000,NULL,'2018-03-18 10:07:49'),
	(3,10102,10101,'890575','2018-03-18 10:18:43','Expired',600000,NULL,'2018-03-18 10:18:42'),
	(4,10102,10101,'246065','2018-03-18 13:15:37','Generated',600000,NULL,'2018-03-18 13:15:36'),
	(5,10102,3,'853916','2018-03-18 16:11:42','Generated',600000,'2018-03-18 16:11:42','2018-03-18 16:11:41'),
	(6,10102,3,'971339','2018-03-18 16:20:18','Expired',600000,'2018-03-18 16:20:18','2018-03-18 16:20:18'),
	(7,10102,3,'871199','2018-03-18 17:07:26','Used',600000,'2018-03-18 17:07:26','2018-03-18 17:07:26');

/*!40000 ALTER TABLE `t_access_request_records` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_user_medical_prescriptions
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user_medical_prescriptions`;

CREATE TABLE `t_user_medical_prescriptions` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `prescribed_by` int(11) unsigned NOT NULL,
  `medical_condition` varchar(256) DEFAULT NULL,
  `allergies` varchar(256) DEFAULT NULL,
  `medic_duration` int(11) DEFAULT NULL,
  `prescription` varchar(1024) DEFAULT NULL,
  `prescription_notes` varchar(1024) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `modified_at` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_USER_ID4` (`user_id`),
  KEY `FK_USER_ID5` (`prescribed_by`),
  CONSTRAINT `FK_USER_ID4` FOREIGN KEY (`user_id`) REFERENCES `t_users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_USER_ID5` FOREIGN KEY (`prescribed_by`) REFERENCES `t_users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_user_medical_prescriptions` WRITE;
/*!40000 ALTER TABLE `t_user_medical_prescriptions` DISABLE KEYS */;

INSERT INTO `t_user_medical_prescriptions` (`id`, `user_id`, `prescribed_by`, `medical_condition`, `allergies`, `medic_duration`, `prescription`, `prescription_notes`, `created_at`, `modified_at`)
VALUES
	(10091,10102,10101,'Pneumonia','None',3,'Pneumonia Cure','Take until cured',NULL,NULL);

/*!40000 ALTER TABLE `t_user_medical_prescriptions` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_user_medical_records
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user_medical_records`;

CREATE TABLE `t_user_medical_records` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `hospital` varchar(256) DEFAULT NULL,
  `referred_by_hospital` varchar(256) DEFAULT NULL,
  `doctor` varchar(128) DEFAULT NULL,
  `referred_by_doctor` varchar(128) DEFAULT NULL,
  `problems` varchar(512) DEFAULT NULL,
  `medications` varchar(1024) DEFAULT NULL,
  `allergies` varchar(512) DEFAULT NULL,
  `medical_history` varchar(1024) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_USER_ID` (`user_id`),
  CONSTRAINT `FK_USER_ID` FOREIGN KEY (`user_id`) REFERENCES `t_users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_user_medical_records` WRITE;
/*!40000 ALTER TABLE `t_user_medical_records` DISABLE KEYS */;

INSERT INTO `t_user_medical_records` (`id`, `user_id`, `hospital`, `referred_by_hospital`, `doctor`, `referred_by_doctor`, `problems`, `medications`, `allergies`, `medical_history`, `created_at`, `updated_at`)
VALUES
	(10010,10101,'XYZ Hospital','ABC Hospital','XYZ Doc','ABC Doc','Cancer','Chemotherapy','none','none','2018-03-17 12:26:07','2018-03-17 12:26:07'),
	(10011,10102,'XYZ Hospital','ABC Hospital','XYZ Doc','ABC Doc','Cancer','Chemotherapy','none','none','2018-03-17 12:26:07','2018-03-17 12:26:07');

/*!40000 ALTER TABLE `t_user_medical_records` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_user_types
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user_types`;

CREATE TABLE `t_user_types` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_users`;

CREATE TABLE `t_users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) DEFAULT NULL,
  `first_name` varchar(128) DEFAULT NULL,
  `last_name` varchar(128) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `phone_number` varchar(16) DEFAULT NULL,
  `email_id` varchar(64) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `modified_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_users` WRITE;
/*!40000 ALTER TABLE `t_users` DISABLE KEYS */;

INSERT INTO `t_users` (`id`, `user_name`, `first_name`, `last_name`, `password`, `phone_number`, `email_id`, `authorities`, `created_at`, `modified_at`)
VALUES
	(3,'michaeld','Michael','Dave','$2a$10$63cKJGc2.SvtcO4btcd1pe7kULStiGYxndMVHXIA0axv2KOe/FeXW','8291326130',NULL,'PHARMACIST','2018-03-18 16:10:44','2018-03-18 16:10:44'),
	(10101,'vikramsingh','Vikram','Singh','$2a$10$8uqzWhWMQHvgol7pWX747uUjaH4apnlPyFAB.06OP.JfqniiXEHJC','8291326130',NULL,'DOCTOR','2018-03-17 10:07:52','2018-03-17 10:07:52'),
	(10102,'Example Singh','Example','Singh','$2a$10$oHGv5PNSLboJPbrRWUzSo.l2HFjdhBVIVP6g2NhFF0vh6qc.rJHha','8291326130',NULL,'PATIENT','2018-03-17 18:20:08','2018-03-17 18:20:08');

/*!40000 ALTER TABLE `t_users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
