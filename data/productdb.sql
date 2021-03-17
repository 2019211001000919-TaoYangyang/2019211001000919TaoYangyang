create database `productdb`;

create table `usertable`(
`id` int PRIMARY KEY AUTO_INCREMENT,
`username` varchar(255) not null,
`password` varchar(255) not null,
`email` varchar(255),
`gender` int,
`birth` date
)