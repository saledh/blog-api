create table USER (
    ID INT NOT NULL AUTO_INCREMENT,
    TENANT_ID INT NOT NULL,
    EMAIL VARCHAR(50) NOT NULL,
    PWD VARCHAR(50) NOT NULL,

    constraint USER_PK PRIMARY KEY(ID),
    constraint TENANT_FK_1 FOREIGN KEY(TENANT_ID) REFERENCES TENANT(ID)
);

insert into USER (TENANT_ID, EMAIL, PWD) values (1 ,'admin@guglielmo.biz', 'password');
