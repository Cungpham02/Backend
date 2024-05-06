create database Do_An_Tot_Nghiep_Cung_Duong
drop database Do_An_Tot_Nghiep_Cung_Duong
use Do_An_Tot_Nghiep_Cung_Duong
create table user(
id int AUTO_INCREMENT primary key,
username nvarchar(100),
password nvarchar(255),
email nVARCHAR (255) NOT NULL,
address nvarchar(255) NOT NULL,
phonenumber varchar(12) NOT NULL
)user
create table role(
id int AUTO_INCREMENT primary key,
rolename nvarchar(100)
)
create table userroles(
id int AUTO_INCREMENT primary key,
user_id int,
role_id int,
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (role_id) REFERENCES role(id)
)



