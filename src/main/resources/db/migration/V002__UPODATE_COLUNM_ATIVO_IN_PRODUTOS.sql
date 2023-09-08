update produtos set ativo = null;

alter table PRODUTOS ALTER COLUMN ATIVO  TYPE varchar(6);


update produtos set ativo = true;