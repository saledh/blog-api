create table TENANT (
    ID INT NOT NULL AUTO_INCREMENT,
    DESCRIPTION VARCHAR(30) NOT NULL,
    constraint TENANT_PK PRIMARY KEY (ID)
);

insert into TENANT (DESCRIPTION) values ('System Tenant');