CREATE sequence FLOWER_SG

CREATE TABLE TB_FLOWERS(ID INT PRIMARY KEY, NAME VARCHAR(255), COUNT VARCHAR(255), VALUE VARCHAR(255))

insert into TB_FLOWERS values (FLOWER_SG.nextval, 'Ficus', 1000, 50);
insert into TB_FLOWERS values (FLOWER_SG.nextval, 'Cactus', 1000, 50);
insert into TB_FLOWERS values (FLOWER_SG.nextval, 'Aloe', 1000, 50);
