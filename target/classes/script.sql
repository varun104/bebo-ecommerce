CREATE TABLE IF NOT EXISTS USER_DATA(
user_id int AUTO_INCREMENT PRIMARY KEY,
first_name varchar(200) NOT NULL,
last_name varchar(200) NOT NULL,
email varchar(200) NOT NULL,
mobile_Number varchar(200) NOT NULL,
password varchar(200) NOT NULL,
role varchar(200) NOT NULL,
created_at date NOT NULL,
created_by varchar(100) NOT NULL,
updated_at date DEFAULT NULL,
updated_by varchar(100) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS USER_DATA(
user_id int AUTO_INCREMENT PRIMARY KEY,
first_name varchar(200) NOT NULL,
last_name varchar(200) NOT NULL,
email varchar(200) NOT NULL,
mobile_Number varchar(200) NOT NULL,
password varchar(200) NOT NULL,
role varchar(200) NOT NULL,
created_at date NOT NULL,
created_by varchar(100) NOT NULL,
updated_at date DEFAULT NULL,
updated_by varchar(100) DEFAULT NULL
);

