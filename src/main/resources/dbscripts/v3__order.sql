CREATE sequence "ORDER_SG"

CREATE TABLE "TB_ORDER"
(
    "ID_ORDER" INT PRIMARY KEY,
    "ID_USER" INT NOT NULL,
    FOREIGN KEY ("ID_USER") REFERENCES "TB_USER" ("ID"),
    "STATUS" VARCHAR2 CHECK("STATUS" IN ('OPEN', 'PAID', 'CLOSED','CANCELLED')),
    "ITEMS" INT,
    "OPEN_DATE" DATE,
    "CLOSE_DATE" DATE,
    "DISCOUNT" INT NOT NULL,
    "VALUE" NUMBER(10, 2) NOT NULL
);