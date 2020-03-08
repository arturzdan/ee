CREATE sequence "FLOWER_SG"

CREATE TABLE "TB_FLOWERS"(
    "ID_FLOWER" LONG PRIMARY KEY,
    "NAME" VARCHAR(50) NOT NULL,
    "COUNT" INT NOT NULL,
    "VALUE" NUMBER(15, 7) NOT NULL
)

insert into "TB_FLOWERS" values (FLOWER_SG.nextval, 'Ficus', 1000, 50);
insert into "TB_FLOWERS" values (FLOWER_SG.nextval, 'Cactus', 1000, 50);
insert into "TB_FLOWERS" values (FLOWER_SG.nextval, 'Aloe', 1000, 50);
