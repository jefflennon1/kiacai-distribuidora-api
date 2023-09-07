CREATE TABLE PRODUTOS(
   ID SERIAL PRIMARY KEY,
   SKU VARCHAR(10) UNIQUE,
   NOME VARCHAR(200) NOT NULL,
   DESCRICAO VARCHAR(500),
   CATEGORIA_ID INTEGER,
   UNIDADE_MEDIDA_ID INTEGER,
   VALOR DOUBLE PRECISION,
   ATIVO INTEGER,
   SALDO_EM_ESTOQUE DOUBLE PRECISION
);


CREATE TABLE CATEGORIAS(
	ID SERIAL PRIMARY KEY,
	NOME VARCHAR(200) NOT NULL,
	DESCRICAO VARCHAR(500)
); 

ALTER TABLE PRODUTOS
ADD CONSTRAINT fk_categoria_produto
 FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIAS (ID);
 
  
 INSERT INTO CATEGORIAS (NOME, DESCRICAO)
 VALUES ('CREMES', 'CREMES PERSONALIZADOS');
 
 INSERT INTO CATEGORIAS (NOME, DESCRICAO)
 VALUES ('AÇAI PURO', 'AÇAI PURO DA TERRA');
 
 INSERT INTO CATEGORIAS (NOME, DESCRICAO)
 VALUES ('VASILHAS', 'INSUMO DE VASILHA');
 
 
 
 
CREATE TABLE UNIDADES_DE_MEDIDA(
	ID SERIAL PRIMARY KEY, 
	DESCRICAO VARCHAR(500)
); 

ALTER TABLE PRODUTOS
ADD CONSTRAINT fk_unidade_medida_produto
FOREIGN KEY (UNIDADE_MEDIDA_ID) REFERENCES UNIDADES_DE_MEDIDA (ID);
 
INSERT INTO UNIDADES_DE_MEDIDA (DESCRICAO) VALUES ('Unidade');
INSERT INTO UNIDADES_DE_MEDIDA (DESCRICAO) VALUES ('Quilograma');
INSERT INTO UNIDADES_DE_MEDIDA (DESCRICAO) VALUES ('Grama');
INSERT INTO UNIDADES_DE_MEDIDA (DESCRICAO) VALUES ('Litro');
INSERT INTO UNIDADES_DE_MEDIDA (DESCRICAO) VALUES ('Mililitro');
INSERT INTO UNIDADES_DE_MEDIDA (DESCRICAO) VALUES ('Metro');
INSERT INTO UNIDADES_DE_MEDIDA (DESCRICAO) VALUES ('Centímetro');
INSERT INTO UNIDADES_DE_MEDIDA (DESCRICAO) VALUES ('Milímetro');




 
 
 
 INSERT INTO PRODUTOS (SKU, NOME, DESCRICAO, CATEGORIA_ID,
  UNIDADE_MEDIDA_ID, VALOR, ATIVO, SALDO_EM_ESTOQUE)
 VALUES
  ('A2305', 'CREME DE CHOCOLATE COM MORANGO', 'CREME FEITO DE CHOCOLATE 50% COM MORANGO DA FRUTA.',
  1, 2 , 20.50, 1, 300.25 );
   
 INSERT INTO PRODUTOS (SKU, NOME, DESCRICAO, CATEGORIA_ID,
  UNIDADE_MEDIDA_ID, VALOR, ATIVO, SALDO_EM_ESTOQUE)
 VALUES
  ('A2306', 'CREME NINHO COM NUTELA', 'CREME FEITO A BASE DE NUTELA 100% E LEITE NINHO PURO',
  1, 2, 50.01, 1, 700.85 );
  
   
 INSERT INTO PRODUTOS (SKU, NOME, DESCRICAO, CATEGORIA_ID,
  UNIDADE_MEDIDA_ID, VALOR, ATIVO, SALDO_EM_ESTOQUE)
 VALUES
  ('X1254A', 'AÇAI PURO', 'AÇAI PURO VINDO DIRETAMENTE DO PARÁ',
  2, 2, 22.35, 1, 125.13 );
  
   
 INSERT INTO PRODUTOS (SKU, NOME, DESCRICAO, CATEGORIA_ID,
  UNIDADE_MEDIDA_ID, VALOR, ATIVO, SALDO_EM_ESTOQUE)
 VALUES
  ('C4256', 'VASILHA EM ISOPOR 50 ML', 'VASILHA EM ISOPOR, CAPACIDADE DE 50 ML',
  3, 1, 300, 1, 1500 );

