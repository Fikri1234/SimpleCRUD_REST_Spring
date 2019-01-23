--liquibase formatted sql

------------------------------------ mst user ---------------------------------------------------

--changeset Fikri:01 context:dev labels:create_mst_user 
--comment: create table mst_user

CREATE TABLE MST_USER (
	user_id varchar(255) PRIMARY KEY NOT NULL,
	password varchar(255) NULL,
	name varchar(255) NULL,
	account_non_expired BOOLEAN NULL,
	account_non_locked BOOLEAN NULL,
	credentials_non_expired BOOLEAN NULL,
	enabled BOOLEAN NULL,

	role_code varchar(255) NULL,

	birth_date TIMESTAMP NULL,
	email varchar(255) NULL,
	nik varchar(255) NULL,
	type varchar(255) NULL,
	posisi_skrg varchar(255) NULL,
	posisi_dulu varchar(255) NULL,

	created_date TIMESTAMP NULL,
	last_update TIMESTAMP NULL
);

--rollback drop table MST_USER;


--changeset Fikri:02 context:dev labels:insert_mst_user
--comment: insert table MST_USER

insert into MST_USER	
(USER_ID,PASSWORD,NAME,account_non_expired,account_non_locked,credentials_non_expired,ENABLED,ROLE_CODE,BIRTH_date,EMAIL,nik,type,posisi_skrg,posisi_dulu,CREATED_date,LAST_UPdate) values
('admin','$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha',NULL,TRUE,TRUE,TRUE,TRUE,'ROLE_MANAGER',{ts '1997-01-24 00:00:00'},'bruz@gmail.com','1123','promosi','ROLE_MANAGER','ROLE_ASISTEN_MANAGER',{ts '2018-01-30 17:51:21'},{ts '2018-01-30 17:51:21'});
insert into MST_USER	
(USER_ID,PASSWORD,NAME,account_non_expired,account_non_locked,credentials_non_expired,ENABLED,ROLE_CODE,BIRTH_date,EMAIL,nik,type,posisi_skrg,posisi_dulu,CREATED_date,LAST_UPdate) values
('budi','$2a$08$1kRxTVadsyebkxcngE.1Oea8k5nUHDrpc9e2uVMkDrcU.jQD6N.kS',NULL,TRUE,TRUE,TRUE,TRUE,'ROLE_STAFF',{ts '1997-01-24 00:00:00'},'lin@gmail.com','1124','demosi','ROLE_STAFF','ROLE_SUPERVISOR',{ts '2018-01-30 17:51:21'},{ts '2018-01-30 17:51:21'});
insert into MST_USER	
(USER_ID,PASSWORD,NAME,account_non_expired,account_non_locked,credentials_non_expired,ENABLED,ROLE_CODE,BIRTH_date,EMAIL,nik,type,posisi_skrg,posisi_dulu,CREATED_date,LAST_UPdate) values
('danang','$2a$08$KtW9IZLQ3R63OnK6q8I3A.23AKbkvWaipXHfwCKMemdwtEWvHM.k2',NULL,TRUE,TRUE,TRUE,TRUE,'ROLE_SUPERVISOR',{ts '1997-01-24 00:00:00'},'user1@example.com','1125','promosi','ROLE_SUPERVISOR','ROLE_STAFF',{ts '2018-01-30 17:51:21'},{ts '2018-01-30 17:51:21'});
insert into MST_USER	
(USER_ID,PASSWORD,NAME,account_non_expired,account_non_locked,credentials_non_expired,ENABLED,ROLE_CODE,BIRTH_date,EMAIL,nik,type,posisi_skrg,posisi_dulu,CREATED_date,LAST_UPdate) values
('darto','$2a$08$AH8QaSTu8ZTsvwTdOWAGSeauv4GEaJ.9xgjvLMynj4bZOWKpBniyS',NULL,TRUE,TRUE,TRUE,TRUE,'ROLE_ASISTEN_MANAGER',{ts '1997-01-24 00:00:00'},'user2@example.com','1126','demosi','ROLE_MANAGER','ROLE_ASISTEN_MANAGER',{ts '2018-01-30 17:51:21'},{ts '2018-01-30 17:51:21'});
insert into MST_USER	
(USER_ID,PASSWORD,NAME,account_non_expired,account_non_locked,credentials_non_expired,ENABLED,ROLE_CODE,BIRTH_date,EMAIL,nik,type,posisi_skrg,posisi_dulu,CREATED_date,LAST_UPdate) values
('darto1','$2a$08$AH8QaSTu8ZTsvwTdOWAGSeauv4GEaJ.9xgjvLMynj4bZOWKpBniyS',NULL,TRUE,TRUE,TRUE,TRUE,'ROLE_ASISTEN_MANAGER',{ts '1997-01-24 00:00:00'},'user3@example.com','1127','demosi','ROLE_MANAGER','ROLE_ASISTEN_MANAGER',{ts '2018-01-30 17:51:21'},{ts '2018-01-30 17:51:21'});
insert into MST_USER	
(USER_ID,PASSWORD,NAME,account_non_expired,account_non_locked,credentials_non_expired,ENABLED,ROLE_CODE,BIRTH_date,EMAIL,nik,type,posisi_skrg,posisi_dulu,CREATED_date,LAST_UPdate) values
('darto2','$2a$08$AH8QaSTu8ZTsvwTdOWAGSeauv4GEaJ.9xgjvLMynj4bZOWKpBniyS',NULL,TRUE,TRUE,TRUE,TRUE,'ROLE_ASISTEN_MANAGER',{ts '1997-01-24 00:00:00'},'user4@example.com','1128','demosi','ROLE_MANAGER','ROLE_ASISTEN_MANAGER',{ts '2018-01-30 17:51:21'},{ts '2018-01-30 17:51:21'});
insert into MST_USER	
(USER_ID,PASSWORD,NAME,account_non_expired,account_non_locked,credentials_non_expired,ENABLED,ROLE_CODE,BIRTH_date,EMAIL,nik,type,posisi_skrg,posisi_dulu,CREATED_date,LAST_UPdate) values
('darto3','$2a$08$AH8QaSTu8ZTsvwTdOWAGSeauv4GEaJ.9xgjvLMynj4bZOWKpBniyS',NULL,TRUE,TRUE,TRUE,TRUE,'ROLE_ASISTEN_MANAGER',{ts '1997-01-24 00:00:00'},'user5@example.com','1129','demosi','ROLE_MANAGER','ROLE_ASISTEN_MANAGER',{ts '2018-01-30 17:51:21'},{ts '2018-01-30 17:51:21'});
insert into MST_USER	
(USER_ID,PASSWORD,NAME,account_non_expired,account_non_locked,credentials_non_expired,ENABLED,ROLE_CODE,BIRTH_date,EMAIL,nik,type,posisi_skrg,posisi_dulu,CREATED_date,LAST_UPdate) values
('darto4','$2a$08$AH8QaSTu8ZTsvwTdOWAGSeauv4GEaJ.9xgjvLMynj4bZOWKpBniyS',NULL,TRUE,TRUE,TRUE,TRUE,'ROLE_ASISTEN_MANAGER',{ts '1997-01-24 00:00:00'},'user6@example.com','1130','demosi','ROLE_MANAGER','ROLE_ASISTEN_MANAGER',{ts '2018-01-30 17:51:21'},{ts '2018-01-30 17:51:21'});
insert into MST_USER	
(USER_ID,PASSWORD,NAME,account_non_expired,account_non_locked,credentials_non_expired,ENABLED,ROLE_CODE,BIRTH_date,EMAIL,nik,type,posisi_skrg,posisi_dulu,CREATED_date,LAST_UPdate) values
('darto5','$2a$08$AH8QaSTu8ZTsvwTdOWAGSeauv4GEaJ.9xgjvLMynj4bZOWKpBniyS',NULL,TRUE,TRUE,TRUE,TRUE,'ROLE_ASISTEN_MANAGER',{ts '1997-01-24 00:00:00'},'user7@example.com','1131','demosi','ROLE_MANAGER','ROLE_ASISTEN_MANAGER',{ts '2018-01-30 17:51:21'},{ts '2018-01-30 17:51:21'});
insert into MST_USER	
(USER_ID,PASSWORD,NAME,account_non_expired,account_non_locked,credentials_non_expired,ENABLED,ROLE_CODE,BIRTH_date,EMAIL,nik,type,posisi_skrg,posisi_dulu,CREATED_date,LAST_UPdate) values
('darto6','$2a$08$AH8QaSTu8ZTsvwTdOWAGSeauv4GEaJ.9xgjvLMynj4bZOWKpBniyS',NULL,TRUE,TRUE,TRUE,TRUE,'ROLE_ASISTEN_MANAGER',{ts '1997-01-24 00:00:00'},'user8@example.com','1132','demosi','ROLE_MANAGER','ROLE_ASISTEN_MANAGER',{ts '2018-01-30 17:51:21'},{ts '2018-01-30 17:51:21'});
insert into MST_USER	
(USER_ID,PASSWORD,NAME,account_non_expired,account_non_locked,credentials_non_expired,ENABLED,ROLE_CODE,BIRTH_date,EMAIL,nik,type,posisi_skrg,posisi_dulu,CREATED_date,LAST_UPdate) values
('darto7','$2a$08$AH8QaSTu8ZTsvwTdOWAGSeauv4GEaJ.9xgjvLMynj4bZOWKpBniyS',NULL,TRUE,TRUE,TRUE,TRUE,'ROLE_ASISTEN_MANAGER',{ts '1997-01-24 00:00:00'},'user9@example.com','1133','demosi','ROLE_MANAGER','ROLE_ASISTEN_MANAGER',{ts '2018-01-30 17:51:21'},{ts '2018-01-30 17:51:21'});
insert into MST_USER	
(USER_ID,PASSWORD,NAME,account_non_expired,account_non_locked,credentials_non_expired,ENABLED,ROLE_CODE,BIRTH_date,EMAIL,nik,type,posisi_skrg,posisi_dulu,CREATED_date,LAST_UPdate) values
('darto8','$2a$08$AH8QaSTu8ZTsvwTdOWAGSeauv4GEaJ.9xgjvLMynj4bZOWKpBniyS',NULL,TRUE,TRUE,TRUE,TRUE,'ROLE_ASISTEN_MANAGER',{ts '1997-01-24 00:00:00'},'user10@example.com','1134','demosi','ROLE_MANAGER','ROLE_ASISTEN_MANAGER',{ts '2018-01-30 17:51:21'},{ts '2018-01-30 17:51:21'});
--rollback delete from MST_USER;
		
---------------------------------------- user role -------------------------------------------

--changeset Fikri:03 context:dev labels:create_mst_user_role
--comment: create table MST_USER_ROLE

CREATE TABLE MST_USER_ROLE
(
   ROLE_CODE varchar(50) PRIMARY KEY NOT NULL,
   IS_ACTIVE BOOLEAN NOT NULL,
   DESCRIPTION varchar(300) DEFAULT NULL,
   ROLE_NAME varchar(100) NOT NULL,
   CREATED_DATE datetime NOT NULL,
   LAST_UPDATE datetime DEFAULT NULL
);

--rollback drop table MST_USER_ROLE;


--changeset Fikri:04 context:dev labels:insert_mst_user_role
--comment: insert table MST_USER_ROLE

INSERT INTO MST_USER_ROLE (ROLE_CODE,IS_ACTIVE,DESCRIPTION,ROLE_NAME,CREATED_DATE,LAST_UPDATE) VALUES ('ROLE_STAFF',TRUE,null,'Staff',{ts '2018-01-19 11:25:15'},{ts '2018-01-19 11:25:15'});
INSERT INTO MST_USER_ROLE (ROLE_CODE,IS_ACTIVE,DESCRIPTION,ROLE_NAME,CREATED_DATE,LAST_UPDATE) VALUES ('ROLE_SUPERVISOR',TRUE,null,'Supervisor',{ts '2018-01-19 11:25:15'},{ts '2018-01-19 11:25:15'});
INSERT INTO MST_USER_ROLE (ROLE_CODE,IS_ACTIVE,DESCRIPTION,ROLE_NAME,CREATED_DATE,LAST_UPDATE) VALUES ('ROLE_ASISTEN_MANAGER',TRUE,null,'Asisten Manager',{ts '2018-01-19 11:25:15'},{ts '2018-01-29 20:54:00'});
INSERT INTO MST_USER_ROLE (ROLE_CODE,IS_ACTIVE,DESCRIPTION,ROLE_NAME,CREATED_DATE,LAST_UPDATE) VALUES ('ROLE_MANAGER',TRUE,null,'Manager',{ts '2018-01-19 11:25:15'},{ts '2018-01-29 20:54:00'});

--rollback delete from MST_USER_ROLE;

--------------------------------------------- mst param --------------------------------------------------

--changeset Fikri:05 context:dev labels:create_mst_param
--comment: create table MST_PARAM

CREATE TABLE MST_PARAM
(
   PARAM_CODE int PRIMARY KEY NOT NULL AUTO_INCREMENT,
   PARAM_NAME varchar(45),
   PARAM_VALUE varchar(145) DEFAULT NULL,
   PARAM_DESCRIPTION varchar(145) DEFAULT NULL,
   CREATED_DATE datetime NOT NULL,
   LAST_UPDATE datetime DEFAULT NULL
);

--rollback drop table MST_PARAM;

--changeset Fikri:06 context:dev labels:insert_mst_param
--comment: insert table MST_PARAM

INSERT INTO MST_PARAM (PARAM_NAME,PARAM_VALUE,PARAM_DESCRIPTION,CREATED_DATE,LAST_UPDATE) VALUES ('MAX_LOGIN_FAILED_ATTEMPTS','5','maksimum failed login',{ts '2018-01-19 00:00:00'},{ts '2018-02-27 17:42:17'});
INSERT INTO MST_PARAM (PARAM_NAME,PARAM_VALUE,PARAM_DESCRIPTION,CREATED_DATE,LAST_UPDATE) VALUES ('SECRET_JWT','secret','password jwt',{ts '2018-01-19 00:00:00'},{ts '2018-02-27 17:42:17'});
INSERT INTO MST_PARAM (PARAM_NAME,PARAM_VALUE,PARAM_DESCRIPTION,CREATED_DATE,LAST_UPDATE) VALUES ('EXPIRES_JWT','3600','maksimum waktu biodata dapat diakses dari local (menit)',{ts '2018-01-19 00:00:00'},{ts '2018-02-27 17:42:17'});

--rollback delete from MST_PARAM;

--------------------------------------------- mst department ---------------------------------------------------

--changeset Fikri:07 context:dev labels:create_mst_department
--comment: create table MST_DEPARTMENT

CREATE TABLE MST_DEPARTMENT
(
   id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
   department_name varchar(255),
   CREATED_DATE datetime NOT NULL,
   LAST_UPDATE datetime DEFAULT NULL
);

--rollback drop table MST_DEPARTMENT;

--changeset Fikri:08 context:dev labels:insert_mst_department
--comment: insert table MST_DEPARTMENT 

INSERT INTO MST_DEPARTMENT (department_name,CREATED_DATE,LAST_UPDATE) VALUES ('IT',{ts '2018-01-19 00:00:00'},{ts '2018-02-27 17:42:17'});
INSERT INTO MST_DEPARTMENT (department_name,CREATED_DATE,LAST_UPDATE) VALUES ('HRD',{ts '2018-01-19 00:00:00'},{ts '2018-02-27 17:42:17'});
INSERT INTO MST_DEPARTMENT (department_name,CREATED_DATE,LAST_UPDATE) VALUES ('Loading',{ts '2018-01-19 00:00:00'},{ts '2018-02-27 17:42:17'});
INSERT INTO MST_DEPARTMENT (department_name,CREATED_DATE,LAST_UPDATE) VALUES ('Ticketing',{ts '2018-01-19 00:00:00'},{ts '2018-02-27 17:42:17'});

--rollback drop table MST_DEPARTMENT;