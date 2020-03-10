DROP DATABASE IF EXISTS CMS;
CREATE DATABASE CMS;
USE CMS;
#===========================================================

DROP TABLE IF EXISTS `teacher_detail`;
CREATE TABLE `teacher_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `youtube_channel` varchar(255) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `teacher_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqbhet7ud6qm9tl2j5xfcf3cnt` (`teacher_detail_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
#===========================================================

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
#===========================================================

DROP TABLE IF EXISTS `degree`;
CREATE TABLE `degree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `degree_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdgomx5qg5fvg9cgyh0sdh0vwo` (`degree_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKprox8elgnr8u5wrq1983degk` (`course_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
#===========================================================

DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE `teacher_course` (
  `teacher_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  KEY `FKp8bco6842vkqh13y4759ib7tk` (`course_id`),
  KEY `FKaleldsg7yww5as540ld8iwghe` (`teacher_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `teacher_student`;
CREATE TABLE `teacher_student` (
  `teacher_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  KEY `FKebm5q7cats93q6xhipiltwi1f` (`student_id`),
  KEY `FKakg2j3fancim4cf4pqunwykr1` (`teacher_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `course_student`;
CREATE TABLE `course_student` (
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  KEY `FKlmj50qx9k98b7li5li74nnylb` (`course_id`),
  KEY `FK4xxxkt1m6afc9vxp3ryb0xfhi` (`student_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
#===========================================================
