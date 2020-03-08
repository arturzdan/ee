CREATE TABLE TB_ORDER(
                       ID INT PRIMARY KEY,
                       ID_USER INT,
                       STATUS VARCHAR2 CHECK(STATUS IN ('OPEN', 'PAID', 'CLOSED', 'CANCELLED')),
                       OPEN_DATE DATA,
                       CLOSE_DATE DATA,
                       PRIMARY KEY (ID),
                       FOREIGN KEY (ID_USER) REFERENCES TB_USER(ID)
);