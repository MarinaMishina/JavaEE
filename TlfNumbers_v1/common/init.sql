# SQL Manager 2010 for MySQL 4.5.0.9
# ---------------------------------------
# Host     : utm5-test.dt.local
# Port     : 3306
# Database : binatel_bill


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `binatel_bill`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_unicode_ci';

USE `binatel_bill`;

#
# Structure for the `company_client` table : 
#

CREATE TABLE `company_client` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL,
  `short_name` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL,
  `inn` varchar(10) character set utf8 collate utf8_unicode_ci NOT NULL,
  `kpp` varchar(9) character set utf8 collate utf8_unicode_ci NOT NULL,
  `OGRN` varchar(45) character set utf8 collate utf8_unicode_ci NOT NULL,
  `ur_address` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL,
  `fact_address` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL,
  `bank_name` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL,
  `bank_account` varchar(45) character set utf8 collate utf8_unicode_ci NOT NULL,
  `bank_corr_account` varchar(45) character set utf8 collate utf8_unicode_ci NOT NULL,
  `bank_BIK` varchar(45) character set utf8 collate utf8_unicode_ci NOT NULL,
  `fin_phone` varchar(45) character set utf8 collate utf8_unicode_ci NOT NULL,
  `tech_phone` varchar(45) character set utf8 collate utf8_unicode_ci NOT NULL,
  `fin_contact_person` varchar(255) character set utf8 collate utf8_unicode_ci default NULL,
  `tech_contact_person` varchar(255) character set utf8 collate utf8_unicode_ci default NULL,
  `email` varchar(45) character set utf8 collate utf8_unicode_ci NOT NULL,
  `fin_email` varchar(45) character set utf8 collate utf8_unicode_ci default NULL,
  `tech_email` varchar(45) character set utf8 collate utf8_unicode_ci default NULL,
  `login` varchar(45) character set utf8 collate utf8_unicode_ci NOT NULL,
  `password` varchar(45) character set utf8 collate utf8_unicode_ci NOT NULL,
  `archive` tinyint(4) NOT NULL default '0',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `inn_UNIQUE` (`inn`),
  UNIQUE KEY `OGRN_UNIQUE` (`OGRN`),
  KEY `idx_short_name` (`short_name`),
  KEY `idx_inn` (`inn`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 0 kB';

#
# Structure for the `lang_msg` table : 
#

CREATE TABLE `lang_msg` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `lang` varchar(45) collate utf8_unicode_ci NOT NULL,
  `lang_code` smallint(6) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `lang_code` (`lang_code`),
  UNIQUE KEY `lang_code_2` (`lang_code`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Structure for the `tlf_group_oper` table : 
#

CREATE TABLE `tlf_group_oper` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `group_name` varchar(45) collate utf8_unicode_ci NOT NULL,
  `allow_loss` double NOT NULL default '0',
  `description` varchar(255) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`id`),
  KEY `idx_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Structure for the `tlf_tarif_client` table : 
#

CREATE TABLE `tlf_tarif_client` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) collate utf8_unicode_ci NOT NULL,
  `descr` varchar(255) collate utf8_unicode_ci NOT NULL default ' ',
  PRIMARY KEY  (`id`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Structure for the `contract_client` table : 
#

CREATE TABLE `contract_client` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `number` varchar(45) collate utf8_unicode_ci NOT NULL,
  `company_id` int(10) unsigned NOT NULL,
  `date_begin_ts` int(20) NOT NULL,
  `date_end_ts` int(20) default '2145902400',
  `balance` double NOT NULL default '0',
  `credit` double NOT NULL default '0',
  `tarif_in_id` int(10) unsigned NOT NULL,
  `tarif_out_id` int(10) unsigned NOT NULL,
  `tlf_group_id` int(10) unsigned NOT NULL,
  `lang_msg` int(10) unsigned default '1',
  `agent_abon_percent` int(10) unsigned NOT NULL default '0',
  `agent_traf_percent` int(10) unsigned NOT NULL default '0',
  `is_avans` tinyint(4) NOT NULL,
  `archive` tinyint(4) NOT NULL default '0',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `number_UNIQUE` (`number`),
  KEY `fk_company_id_idx` (`company_id`),
  KEY `fk_group_id_idx` (`tlf_group_id`),
  KEY `fk_tarif_in_id_idx` (`tarif_in_id`),
  KEY `fk_tarif_out_id_idx` (`tarif_out_id`),
  KEY `fk_lang_msg_idx` (`lang_msg`),
  CONSTRAINT `fk_company_id` FOREIGN KEY (`company_id`) REFERENCES `company_client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_group_id` FOREIGN KEY (`tlf_group_id`) REFERENCES `tlf_group_oper` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lang_msg` FOREIGN KEY (`lang_msg`) REFERENCES `lang_msg` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarif_in_id` FOREIGN KEY (`tarif_in_id`) REFERENCES `tlf_tarif_client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarif_out_id` FOREIGN KEY (`tarif_out_id`) REFERENCES `tlf_tarif_client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Structure for the `tlf_numbers` table : 
#

CREATE TABLE `tlf_numbers` (
  `id` int(11) NOT NULL auto_increment,
  `e164_number` varchar(20) collate utf8_unicode_ci NOT NULL,
  `code` varchar(20) collate utf8_unicode_ci NOT NULL,
  `tel_num1` varchar(20) collate utf8_unicode_ci NOT NULL,
  `tel_num2` varchar(20) collate utf8_unicode_ci NOT NULL,
  `tel_num3` varchar(20) collate utf8_unicode_ci NOT NULL,
  `price_number` double(15,2) NOT NULL,
  `month_price_number` double(15,2) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Structure for the `tlf_client_numbers` table : 
#

CREATE TABLE `tlf_client_numbers` (
  `id` int(11) NOT NULL auto_increment,
  `contract_id` int(11) default NULL,
  `number_id` int(11) default NULL,
  `date_link` bigint(20) unsigned NOT NULL,
  `date_unlink` bigint(20) unsigned NOT NULL default '0',
  PRIMARY KEY  (`id`),
  KEY `contract_id` (`contract_id`),
  KEY `tlf_client_numbers_fk` (`number_id`),
  CONSTRAINT `tlf_client_numbers_fk` FOREIGN KEY (`number_id`) REFERENCES `tlf_numbers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Structure for the `tlf_zone_client` table : 
#

CREATE TABLE `tlf_zone_client` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `name` varchar(255) collate utf8_unicode_ci NOT NULL,
  `type` varchar(45) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Structure for the `tlf_direction_client` table : 
#

CREATE TABLE `tlf_direction_client` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `prefix` varchar(45) collate utf8_unicode_ci NOT NULL,
  `name` varchar(255) collate utf8_unicode_ci NOT NULL default ' ',
  `zone_id` int(11) unsigned NOT NULL,
  `start_date_ts` int(11) unsigned NOT NULL,
  `end_date_ts` int(11) unsigned NOT NULL default '2145902400',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `prefix` (`prefix`),
  KEY `fk_zone_id` (`zone_id`),
  CONSTRAINT `fk_zone_id` FOREIGN KEY (`zone_id`) REFERENCES `tlf_zone_client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Structure for the `tlf_tarif_cost_client` table : 
#

CREATE TABLE `tlf_tarif_cost_client` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `tarif_id` int(11) unsigned NOT NULL,
  `zone_id` int(11) unsigned NOT NULL,
  `base_cost` double(15,2) NOT NULL default '0.00',
  `time_round` int(11) unsigned NOT NULL default '60',
  `time_free` int(11) unsigned NOT NULL default '6',
  `start_date_ts` int(11) unsigned NOT NULL,
  `end_date_ts` int(11) unsigned NOT NULL default '2145902400',
  `active` tinyint(4) unsigned NOT NULL default '1',
  `archive` tinyint(4) unsigned NOT NULL default '0',
  PRIMARY KEY  (`id`),
  KEY `fk_tarif_id` (`tarif_id`),
  KEY `zone_id` (`zone_id`),
  CONSTRAINT `fk_zone_id_tarif_cost` FOREIGN KEY (`zone_id`) REFERENCES `tlf_zone_client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarif_id` FOREIGN KEY (`tarif_id`) REFERENCES `tlf_tarif_client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Structure for the `tlf_userID_client` table : 
#

CREATE TABLE `tlf_userID_client` (
  `id` int(11) NOT NULL auto_increment,
  `userid` varchar(255) collate utf8_unicode_ci NOT NULL,
  `contract_id` int(11) unsigned NOT NULL,
  `password` varchar(20) collate utf8_unicode_ci NOT NULL default ' ',
  `active` tinyint(4) unsigned NOT NULL default '1',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `userid` (`userid`),
  KEY `contract_id` (`contract_id`),
  CONSTRAINT `tlf_userID_client_fk` FOREIGN KEY (`contract_id`) REFERENCES `contract_client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for the `company_client` table  (LIMIT 0,500)
#

INSERT INTO `company_client` (`id`, `name`, `short_name`, `inn`, `kpp`, `OGRN`, `ur_address`, `fact_address`, `bank_name`, `bank_account`, `bank_corr_account`, `bank_BIK`, `fin_phone`, `tech_phone`, `fin_contact_person`, `tech_contact_person`, `email`, `fin_email`, `tech_email`, `login`, `password`, `archive`) VALUES 
  (2,'ООО Абада Груп','ООО Абада Груп','1111111111','222222222','231231231231231','ООО Абада Груп','ООО Абада Груп','ООО Абада Груп','231231231','123123123123','123123123','123123123132','123123123123','ООО Абада Груп','ООО Абада Груп','ООО Абада Груп','ООО Абада Груп','ООО Абада Груп','ООО Абада Груп','ООО Абада Груп',0),
  (3,'ООО Эверест','ООО Эверест','3333333333','333333333','23123123123123','ООО Эверест','ООО Эверест','ООО Эверест','23123123123123123','123123123123','123123123','123213123','123123123','ООО Эверест','ООО Эверест','ООО Эверест','2342342','ООО Эверест','ООО Эверест','ООО Эверест',0),
  (5,'ООО ваоылваоылдоаыо','ывлаоывлао','333333333','231212112','21312312312313','ваываываываываы','ываываываыаыа','ываываываыва','342342342423423','234234234234','234234234234','2342342424','23423423424','аыаыаываыва','ываываываыа','чмчсмчсмчмч','чмчмчмчм','чмсчмчмчм','счмчсмчм','ываываыва',0),
  (6,'dgsfgdsfgdsfgsdfg','dfgsfgsdfgdgdsfgdfg','12221212','232423','23423','sfdsdfsdfsdfsdf','sdfsdfsdfsdfsdf','sdfsdfsdfsdfsfd','435345345345345','345345345345','345345345345','345345345','34534535','fgdfgsdfgdgsd','sdgdfgdfgdfg','dfgdfgdfg','dfgdfgdfg','sddfgdfgdfg','dfgdfg','dfgdgdg',0),
  (7,'ООО Тест','ООО Тест','234234','234234','56756756757','Москва','Москва','ОАО ВТБ','34283472834787','808080808088','3242342','1234567','1234567','Петров','Петров','dasdasd@hdjh.ru','dasdasd@hdjh.ru','dasdasd@hdjh.ru','TEST','test123',0),
  (8,'ООО ТЕСТ2','ООО ТЕСТ2','121212','232323','3434343','Москва','Москва','ОАО ВТБ','1234567','1234567','1234567','1232323','1232323','Иванов','Иванов','test2@mail.ru','test2@mail.ru','test2@mail.ru','test2','test2123',0),
  (9,'ООО ТЕСТ3','ООО ТЕСТ3','09876','09876','09876','Клин','Клин','ОАО ВТБ','09090909','77777777','878787','1231212','1231212','Васин','Васин','test3@mail.ru','test3@mail.ru','test3@mail.ru','test3','test3123',0),
  (10,'ООО ТЕСТ4','ООО ТЕСТ4','6543456','6543456','6543456','Клинd','Клинd','ОАОddd','1234321','1234321','1234321','12334343','12334343','АВАВАВ','АВАВАВ','aaa@mail.ru','aaa@mail.ru','aaa@mail.ru','test4','test412300',0),
  (11,'ТЕСТ5','ТЕСТ5','3212345','3212345','90909090','Москва','Москва','ОАО ВТБ','1234567','1234567','1234567','1234525','1234525','hghg','sdfdf','sss@s.com','sss@s.com','sss@s.com','GGG','test12345',0),
  (12,'TEST8','ТЕСТ8','323232','43432','12345754','Москва','Москва','ВТБ','343421567','34234243','342342','1234','1234','Иванов','Иванов','ss@s.ru','ss@s.ru','ss@s.ru','test8','test8123',0),
  (13,'ТЕСТ9','ТЕСТ9','98765','9876','56789','Москва','Москва','ВТБ','876543','45645464','546454','12345','34567','','','s@nn.ru','','','test9','test9123',0),
  (14,'ТЕСТ10','ТЕСТ10','345345','3234234','123123123','Москва','Москва','ВТБ','32423423423','324234234234','324234234','348234234','2342424','','','d@bb.ru','','','test10','test10123',0),
  (15,'TEST11','TEST11','122212123','34242424','234235','Москва','Москва','ВТБ','5645646','343422323','234234234243','234234','234234234','fsdfsf','sdfsdfs','23424@ee.ru','aaa@ss.eu','aaa@ss.eu','test11','test11123',0),
  (16,'ТЕСТ12','ТЕСТ12','4324234','23423423','21123','Москва','Москва','ВТБ24','1233423424','3424234','34234234','23423424','23423424','dfsf','sdfsdf','dd@cc.ru','dd@cc.ru','dd@cc.ru','test12','test12123',0),
  (17,'TEST13','TEST13','565656565','534535435','3423424','sdfsfsfsf','sdfsfsf','GGGG','86757567','56756757','56756757','2342424','23423424','fsfsfsf','sdfsdf','a@aa.ru','a@aa.ru','a@aa.ru','test13','1eFpzPQjm',0),
  (18,'TEST14','TEST14','5434535','3453453','345345','Moscow','Moscow','Moscow','234234234','234234234','23423424','67575757','56756757','fsfsf','sfsfsf','a@aa.ru','a@aa.ru','a@aa.ru','test14','qiZZ92ET5',0),
  (19,'test33','test33','444444','44444','4444444','test33','test33','test33','43535354345','345345345','345345345','54534535','34535435','','','d@bb.ru','d@bb.ru','d@bb.ru','d@bb.ru','BFmVBh9Lh',0);
COMMIT;

#
# Data for the `tlf_group_oper` table  (LIMIT 0,500)
#

INSERT INTO `tlf_group_oper` (`id`, `group_name`, `allow_loss`, `description`) VALUES 
  (1,'TEST_1',0,''),
  (2,'TEST_2',0.2,'TEST_2dfgdfgdfgdfgdgdfgdgdgfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdfgdgdfgdfgdfgdfgdgdfgdfgdfgdfgdfgdgdgdfgdfgdgdgdfgdfgdgdgdfgdfgdfgdgdf'),
  (3,'ПРЕМИУМ',3000,'БИЛАЙН, МАСТЕРТЕЛ'),
  (4,'ЭКСКЛЮЗИВ',50,'КОМКОР'),
  (5,'ОСНОВНАЯ',1000,'ВЫМПЕЛКОМ, МТТ'),
  (6,'ЭКОНОМ',100,'ВЫМПЕЛКОМ');
COMMIT;

#
# Data for the `lang_msg` table  (LIMIT 0,500)
#

INSERT INTO `lang_msg` (`id`, `lang`, `lang_code`) VALUES 
  (1,'Русский',1),
  (2,'Английский',2),
  (3,'Украинский',3),
  (4,'Китайский',4),
  (5,'Немецкий',5),
  (6,'Free',6),
  (7,'Free',7),
  (8,'Free',8),
  (9,'Free',9);
COMMIT;

#
# Data for the `tlf_tarif_client` table  (LIMIT 0,500)
#

INSERT INTO `tlf_tarif_client` (`id`, `name`, `descr`) VALUES 
  (1,'TP-ACTION-PRESS-IN','Входящие звонки'),
  (2,'TP-ACTION-PRESS-OUT','Исходящие звонки'),
  (3,'TP-ABADA-GRUP-IN','Входящие звонки'),
  (4,'TP-ABADA-GRUP-OUT','Исходящие звонки'),
  (5,'TP-KLEVER-GRUP-IN','Входящие звонки'),
  (6,'TP-KLEVER-GRUP-OUT','Исходящие звонки');
COMMIT;

#
# Data for the `contract_client` table  (LIMIT 0,500)
#

INSERT INTO `contract_client` (`id`, `number`, `company_id`, `date_begin_ts`, `date_end_ts`, `balance`, `credit`, `tarif_in_id`, `tarif_out_id`, `tlf_group_id`, `lang_msg`, `agent_abon_percent`, `agent_traf_percent`, `is_avans`, `archive`) VALUES 
  (1,'1',9,1422302400,1422648000,0,0,1,2,1,1,0,0,0,0),
  (2,'2',14,1422475200,1422648000,0,0,1,2,2,1,0,0,0,0),
  (3,'3',8,1422734400,2114380800,0,0,1,2,4,2,0,0,0,0),
  (4,'5',7,1422475200,2114380800,0,0,3,4,5,1,0,0,0,0),
  (5,'6',6,1422475200,2114380800,0,0,1,4,1,1,0,0,0,0),
  (6,'7',5,1422475200,2114380800,0,0,1,2,1,1,0,0,0,0),
  (7,'8',3,1422475200,2114380800,0,0,1,2,1,1,0,0,0,0),
  (8,'9',6,1422561600,1425067200,0,0,1,2,1,1,0,0,0,0),
  (9,'10',6,1422561600,2114380800,0,0,1,2,3,1,0,0,0,0),
  (10,'11',6,1422561600,1427745600,0,0,1,2,1,1,0,0,0,0),
  (11,'12',6,1422561600,2114380800,0,0,1,4,1,1,0,0,0,0),
  (12,'13',8,1422561600,2114380800,0,0,1,3,1,1,0,0,0,0),
  (13,'14',5,1422561600,1417377600,0,0,1,4,1,1,0,0,0,0),
  (14,'15',5,0,0,0,0,1,2,1,1,0,0,0,0),
  (15,'16',5,1422561600,1425067200,0,0,1,2,2,1,0,0,0,0),
  (16,'17',3,1422561600,1425067200,0,0,1,4,1,2,0,0,0,0),
  (17,'18',3,1422561600,1422648000,0,0,3,2,1,1,0,0,0,0),
  (18,'19',9,1422561600,1422648000,0,0,1,2,1,1,0,0,0,0),
  (19,'20',3,1422561600,1422648000,0,0,1,2,1,1,0,0,0,0),
  (20,'28',19,0,0,0,0,1,2,1,1,0,0,0,0),
  (21,'29',19,0,0,0,0,1,2,1,1,0,0,0,0),
  (22,'30',10,1422820800,2114380800,0,0,1,2,1,1,0,0,0,0),
  (23,'31',10,0,0,0,0,1,2,1,1,0,0,0,0),
  (24,'32',19,0,0,0,0,1,2,2,1,0,0,0,0),
  (25,'33',12,1422820800,2114380800,0,0,1,2,4,1,0,0,0,0),
  (26,'35',12,1422820800,2114380800,0,0,2,1,1,1,0,0,0,0),
  (27,'36',18,1422820800,1423166400,0,0,2,1,1,1,0,0,0,0),
  (28,'37',18,1422820800,1427745600,0,0,1,2,2,1,0,0,0,0),
  (29,'38',12,1422907200,1423252800,0,0,1,2,2,1,0,0,0,0),
  (30,'39',12,1422820800,1425067200,0,0,1,2,1,1,0,0,0,0),
  (31,'40',11,1422820800,1425067200,0,0,1,2,1,1,0,0,0,0),
  (32,'41',10,1422820800,2114380800,0,0,1,2,1,1,0,0,0,0),
  (33,'42',8,1422820800,1427745600,0,0,1,2,1,1,0,0,0,0),
  (34,'43',14,1422820800,1427745600,0,0,1,2,3,1,0,0,0,0),
  (35,'44',14,1422820800,1425067200,0,0,1,2,1,1,0,0,0,0),
  (36,'45',10,1422820800,2114380800,0,0,3,4,3,1,0,0,0,0),
  (37,'50',8,1423166400,2114380800,0,0,1,2,6,2,0,0,0,0);
COMMIT;

#
# Data for the `tlf_numbers` table  (LIMIT 0,500)
#

INSERT INTO `tlf_numbers` (`id`, `e164_number`, `code`, `tel_num1`, `tel_num2`, `tel_num3`, `price_number`, `month_price_number`) VALUES 
  (1,'74999224042','499','922','40','42',1000.00,300.00);
COMMIT;

#
# Data for the `tlf_zone_client` table  (LIMIT 0,500)
#

INSERT INTO `tlf_zone_client` (`id`, `name`, `type`) VALUES 
  (1,'rus mob','МГ'),
  (2,'msk mob','ВЗ'),
  (3,'msk','МСТН'),
  (4,'msk spec3','МСТН'),
  (5,'rus free phone','МГ');
COMMIT;

#
# Data for the `tlf_direction_client` table  (LIMIT 0,500)
#

INSERT INTO `tlf_direction_client` (`id`, `prefix`, `name`, `zone_id`, `start_date_ts`, `end_date_ts`) VALUES 
  (1,'79','Rus mob',1,0,2145902400),
  (2,'7909','msk mob',2,0,2145902400),
  (3,'7903','msk mob',2,0,2145902400),
  (4,'7495','msk fix',3,0,2145902400),
  (5,'7499','msk fix',3,0,2145902400),
  (6,'7498','mo fix',3,0,2145902400),
  (7,'07495100','msk time',4,0,2145902400),
  (8,'7800','Free Phone',5,0,2145902400);
COMMIT;

#
# Data for the `tlf_tarif_cost_client` table  (LIMIT 0,500)
#

INSERT INTO `tlf_tarif_cost_client` (`id`, `tarif_id`, `zone_id`, `base_cost`, `time_round`, `time_free`, `start_date_ts`, `end_date_ts`, `active`, `archive`) VALUES 
  (1,1,4,0.65,30,0,0,2145902400,1,0),
  (2,1,2,1.50,60,6,0,2145902400,1,0),
  (3,1,3,0.50,30,0,0,2145902400,1,0),
  (4,1,1,2.00,60,6,0,2145902400,1,0),
  (5,2,3,0.00,60,6,0,1427846400,1,0),
  (6,1,5,0.50,60,6,0,2145902400,1,0),
  (7,2,1,3.15,60,6,1422748800,1427846400,1,0),
  (8,2,2,2.10,60,6,1422748800,1427850000,1,0),
  (9,2,2,1.50,60,6,1388534400,1391212800,1,0);
COMMIT;

#
# Data for the `tlf_userID_client` table  (LIMIT 0,500)
#

INSERT INTO `tlf_userID_client` (`id`, `userid`, `contract_id`, `password`, `active`) VALUES 
  (1,'ui1',1,'56565',1),
  (2,'uitest2',2,'098',0),
  (3,'uitest3',8,'dftrddf888',1),
  (4,'uitest4',6,'4545',1),
  (5,'UId123',8,'fdgdfgdf',1),
  (6,'uid333',8,'bnvcx',1),
  (7,'uitest999',8,'999',0);
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;