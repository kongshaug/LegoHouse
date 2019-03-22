
create database `legohouse`;
create table if not exists  `legohouse`.`Users` 
(
`id` int(55) not null primary key auto_increment,
`email` VARCHAR(55),
`password` VARCHAR(55),
`role` VARCHAR(55)
);


create table legoHouse.`mesurments` 
(
`id` int(55) not null primary key auto_increment,
`email` VARCHAR(55) not null,
`shippingStatus` boolean default false,
`wigth` VARCHAR(55),
`depth` VARCHAR(55),
`hight` VARCHAR(55)
);

INSERT INTO Users (email, password, role) VALUES ('admin@account', '1234', 'emp');
