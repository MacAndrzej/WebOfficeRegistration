use `web_registration`;

--
-- Table structure for table `parent`
--
 create table `parent`(
`id` int(11) NOT NULL auto_increment,
`surname` varchar(45) default null,
`name` varchar(45) default null,
`telephone_number` varchar(45) default null,
`email` varchar(45) not null,
`users_username` varchar(50),

primary key (`id`),
FOREIGN KEY (`users_username`) REFERENCES `users` (`username`)

 )ENGINE=innoDB auto_increment=1 DEFAULT CHARSET=latin1;
 
 --
-- Inserting data for table `parent`
--
 insert into `parent` values
 (1,'kowalski','andrzej','5555555','ka@op.pl',null),
 (2,'user','user',null,'jj@op.pl',null),
 (3,'nowak','robert','9999999','hht@oo.pi',null);
 


--
-- Table structure for table `child`
--
create table `child`(
`id` int(11) NOT NULL auto_increment,
`surname` varchar(45) default null,
`name` varchar(45) default null,
`date_of_birth` date default null,
`parent_id` int,
primary key (`id`),
foreign key(`parent_id`) references `parent` (`id`)
 )ENGINE=innoDB auto_increment=1 DEFAULT CHARSET=latin1;
 
 --
-- Inserting data for table `child`
--
 insert into `child` values
 (1,'kowalski','adam',now(),1),
 (2,'nowak','stefan',now(),3),
 (3,'user','jacek',now(),2);
 
 
--
-- Table structure for table `visit`
--
create table `visit`(
`id` int(11) NOT NULL auto_increment,
`date_of_visit_planned` date,
`time_of_visit_planned` time,
`term_of_visit_cancelled` boolean,
`date_of_visit_changed` date,
`time_of_visit_changed` time,
`term_of_modification` date,
`absence` boolean,
`child_id` int(11),
primary key (`id`),
FOREIGN KEY (`child_id`) REFERENCES `child` (`id`)

 )
ENGINE=innoDB auto_increment=1 DEFAULT CHARSET=latin1;

--
-- Table structure for table `users`
--
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
INSERT INTO `users` 
VALUES 
('andrzej','$2a$10$QNEe0VL3T0jkSPKY3qvZSeCxQM9ufcroVB8ydeZNEA4zMb1w/ZfEW',1),
('user','$2a$10$0yn2NFwuXP8HSeB4T.RI5eftwveU.bMXmIS94ZJzgHRaApZvSrnKC',1),
('robert','$2y$10$6FLmMrFrDU6u/g2YNYW8reSOBig7qfwTi.t4UYjYkAFYkoHW0FSo2',1);


--
-- Table structure for table `authorities`
--


CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('andrzej','ROLE_ADMIN'),
('andrzej','ROLE_USER'),
('user','ROLE_USER'),
('robert','ROLE_USER');






