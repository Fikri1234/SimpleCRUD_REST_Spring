--liquibase formatted sql

USE [app_data]
GO

--changeset Fikri:13 context:dev labels:create_OAUTH_CLIENT_DETAILS 
--comment: create table OAUTH_CLIENT_DETAILS

CREATE TABLE OAUTH_CLIENT_DETAILS (
  CLIENT_ID VARCHAR(255) PRIMARY KEY,
  RESOURCE_IDS VARCHAR(255),
  CLIENT_SECRET VARCHAR(255),
  SCOPE VARCHAR(255),
  AUTHORIZED_GRANT_TYPES VARCHAR(255),
  WEB_SERVER_REDIRECT_URI VARCHAR(255),
  AUTHORITIES VARCHAR(255),
  ACCESS_TOKEN_VALIDITY INTEGER,
  REFRESH_TOKEN_VALIDITY INTEGER,
  ADDITIONAL_INFORMATION VARCHAR(4096),
  AUTOAPPROVE VARCHAR(255)
);

--rollback drop OAUTH_CLIENT_DETAILS;


--changeset Fikri:14 context:dev labels:create_OAUTH_CLIENT_TOKEN 
--comment: create table OAUTH_CLIENT_TOKEN

CREATE TABLE OAUTH_CLIENT_TOKEN (
  TOKEN_ID VARCHAR(255),
  TOKEN VARBINARY(8000),
  AUTHENTICATION_ID VARCHAR(255) PRIMARY KEY,
  USER_NAME VARCHAR(255),
  CLIENT_ID VARCHAR(255)
);

--rollback drop table OAUTH_CLIENT_TOKEN;


--changeset Fikri:15 context:dev labels:create_OAUTH_ACCESS_TOKEN
--comment: create table OAUTH_ACCESS_TOKEN

CREATE TABLE OAUTH_ACCESS_TOKEN (
  TOKEN_ID VARCHAR(255),
  TOKEN VARBINARY(8000),
  AUTHENTICATION_ID VARCHAR(255) PRIMARY KEY,
  USER_NAME VARCHAR(255),
  CLIENT_ID VARCHAR(255),
  AUTHENTICATION VARBINARY(8000),
  REFRESH_TOKEN VARCHAR(255)
);

--rollback drop table OAUTH_ACCESS_TOKEN;


--changeset Fikri:16 context:dev labels:create_OAUTH_REFRESH_TOKEN 
--comment: create table OAUTH_REFRESH_TOKEN

CREATE TABLE OAUTH_REFRESH_TOKEN (
  TOKEN_ID VARCHAR(255),
  TOKEN VARBINARY(8000),
  AUTHENTICATION VARBINARY(8000)
);

--rollback drop table OAUTH_REFRESH_TOKEN;


--changeset Fikri:17 context:dev labels:create_OAUTH_CODE
--comment: create table OAUTH_CODE

CREATE TABLE OAUTH_CODE (
  CODE VARCHAR(255),
  AUTHENTICATION VARBINARY(8000)
);

--rollback drop table OAUTH_CODE;


--changeset Fikri:18 context:dev labels:create_OAUTH_APPROVALS 
--comment: create table OAUTH_APPROVALS

CREATE TABLE OAUTH_APPROVALS (
  USERID VARCHAR(255),
  CLIENTID VARCHAR(255),
  SCOPE VARCHAR(255),
  STATUS VARCHAR(10),
  EXPIRESAT timestamp,
  LASTMODIFIEDAT timestamp
);

--rollback drop table OAUTH_APPROVALS;


--changeset Fikri:19 context:dev labels:insert_OAUTH_CLIENT_DETAILS 
--comment: insert table OAUTH_CLIENT_DETAILS

INSERT INTO OAUTH_CLIENT_DETAILS(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
 VALUES ('spring-security-oauth2-read-client', 'resource-server-rest-api', /*spring-security-oauth2-read-client-password1234*/'$2a$04$WGq2P9egiOYoOFemBRfsiO9qTcyJtNRnPKNBl5tokP7IP.eZn93km', 'read', 'password,authorization_code,refresh_token,implicit', 'USER', 1800, 3600);
INSERT INTO OAUTH_CLIENT_DETAILS(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
 VALUES ('spring-security-oauth2-read-write-client', 'resource-server-rest-api',
 /*spring-security-oauth2-read-write-client-password1234*/'$2a$04$soeOR.QFmClXeFIrhJVLWOQxfHjsJLSpWrU1iGxcMGdu.a5hvfY4W', 'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', 1800, 3600);

--rollback delete from OAUTH_CLIENT_DETAILS;