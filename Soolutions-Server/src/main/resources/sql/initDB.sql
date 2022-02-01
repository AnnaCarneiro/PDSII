CREATE TABLE SOOLUTION(
    ID            				VARCHAR2(4000) NOT NULL,
    DESCRIPTION          		VARCHAR2(4000) NOT NULL,
    CAUSA           			VARCHAR2(4000) NOT NULL,
    SOLUTION			        VARCHAR2(4000) NOT NULL,
    STATUS           			VARCHAR2(50),
   CONSTRAINT PK_SOOLUTION PRIMARY KEY (ID)
 );

 INSERT INTO SOOLUTION VALUES('10', 'Falha ao selecionar ', 'Falha de programação', 'Corrigido na versão 3.06.1776', 'FIXED');
 INSERT INTO SOOLUTION VALUES('20', 'Falha ao adicionar ', 'Falha de programação', 'Corrigido na versão 3.06.1771', 'FIXED');
 INSERT INTO SOOLUTION VALUES('30', 'Mensagem estranha ', 'Falta de teste', 'Corrigido na versão 3.06.1750', 'FIXED');
 INSERT INTO SOOLUTION VALUES('40', 'Aviso duplicado de', 'Indefinido', 'Não ocorreu mais', 'UNDEFINED');