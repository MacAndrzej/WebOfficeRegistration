use
`web_registration`;

--
-- Table structure for table `parent`
--
create table parent
(
    id               serial primary key,
    surname          varchar(45)          DEFAULT NULL,
    name             varchar(45)          DEFAULT NULL,
    telephone_number varchar(45)          DEFAULT NULL,
    email            varchar(45) NOT NULL,
    users_username   varchar(50),
    date_joined      date        NOT NULL DEFAULT current_date
);

--
-- Inserting data for table `parent`
--
insert into parent
values (1, 'kowalski', 'andrzej', '5555555', 'ka@op.pl', null),
       (2, 'user', 'user', null, 'jj@op.pl', null),
       (3, 'nowak', 'robert', '9999999', 'hht@oo.pi', null);



--
-- Table structure for table `child`
--
create table child
(
    id            serial primary key,
    surname       varchar(45) default null,
    name          varchar(45) default null,
    date_of_birth date        default null,
    parent_id     integer references parent (id)
)
    --
-- Inserting data for table `child`
--
    insert into child
values (1, 'kowalski', 'adam', now(), 1),
       (2, 'nowak', 'stefan', now(), 3),
       (3, 'user', 'jacek', now(), 2);


--
-- Table structure for table `visit`
--
create table visit
(
    id                    serial primary key,
    visit_type            integer REFERENCES visit_types (id),
    date_of_visit_planned date,
    visit_cancelled       boolean,
    date_of_visit_changed date    default null,
    date_of_modification  date    default null,
    absence               boolean default null,
    child_id              integer REFERENCES child (id)
)
    --
-- Inserting data for table `visit`
--
    insert into visit
values (1,1,now(), false, null, null,null),
       (2,3,now(), false, null, null,null),
       (3,4,now(), false, null, null,null);

--
-- Table structure for table `visit_types`
--
create table visit_types
(
    id         serial primary key,
    visit_name varchar(45) NOT NULL
)
    --
-- Inserting data for table `visit_types`
--
    insert into visit_types
values (1,'Pierwsza wizyta'),
       (2,'Diagnoza'),
       (3,'Terapia pedagogiczna'),
       (4,'Trening umiejetności społecznych');

--
-- Table structure for table `users`
--
CREATE TABLE users
(
    id       serial primary key,
    username varchar(50) NOT NULL,
    password varchar(68) NOT NULL,
    enabled  boolean     NOT NULL DEFAULT true
)

CREATE TABLE users
(
    username varchar(50) NOT NULL,
    password varchar(68) NOT NULL,
    enabled  boolean     NOT NULL DEFAULT true
)
    --
-- Inserting data for table `users`
--
    INSERT INTO users
VALUES (1,'andrzej', '$2a$10$QNEe0VL3T0jkSPKY3qvZSeCxQM9ufcroVB8ydeZNEA4zMb1w/ZfEW', true),
       (2,'user', '$2a$10$0yn2NFwuXP8HSeB4T.RI5eftwveU.bMXmIS94ZJzgHRaApZvSrnKC', true),
       (3,'robert', '$2y$10$6FLmMrFrDU6u/g2YNYW8reSOBig7qfwTi.t4UYjYkAFYkoHW0FSo2', true);


--
-- Table structure for table `authorities`
--
CREATE TABLE authorities
(
    username       varchar(50) NOT NULL,
    authority      varchar(50) NOT NULL,
    UNIQUE (username, authority),
    authorities_fk integer REFERENCES users (id)
)
    --
-- Inserting data for table `authorities`
--

    INSERT INTO authorities
VALUES ('andrzej', 'ROLE_ADMIN'),
       ('andrzej', 'ROLE_USER'),
       ('user', 'ROLE_USER'),
       ('robert', 'ROLE_USER');






