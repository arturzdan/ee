CREATE sequence "USER_SG"

CREATE TABLE "TB_USER"
(
    "ID_USER" LONG PRIMARY KEY,
    "TYPE" VARCHAR2 CHECK("TYPE" IN ('USER', 'ADMIN')),
    "LOGIN" VARCHAR2(20 CHAR) NOT NULL,
    "PASSWORD" VARCHAR2(20 CHAR) NOT NULL,
    "LAST_NAME" VARCHAR2(50 CHAR) NOT NULL,
    "FIRST_NAME" VARCHAR2(50 CHAR) NOT NULL,
    "MIDDLE_NAME" VARCHAR2(50 CHAR),
    "ADDRESS" VARCHAR2(50 CHAR) NOT NULL,
    "MOBILE" VARCHAR2(50 CHAR) NOT NULL,
    "DISCOUNT" INT NOT NULL,
    "MONEY" NUMBER(15, 6) NOT NULL
);

insert into "TB_USER" values (USER_SG.nextval, 'ADMIN', 'admin', 'admin', '-', '-', '-', '-', 0, 0,'-');