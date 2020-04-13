CREATE SEQUENCE PESSOA_SEQ;

CREATE TABLE PESSOA(
    "ID_PESSOA"                 NUMBER(19, 0) NOT NULL,
    "NOME"                      VARCHAR(50)   NOT NULL,
    "LOGRADOURO"                VARCHAR(50),
    "NUMERO"                    VARCHAR(50),
    "COMPLEMENTO"               VARCHAR(50),
    "BAIRRO"                    VARCHAR(50),
    "CEP"                       VARCHAR(50),
    "CIDADE"                    VARCHAR(50),
    "ESTADO"                    VARCHAR(50),
    "ATIVO"                     BOOLEAN       NOT NULL,
    CONSTRAINT PESSOA_PK PRIMARY KEY (ID_PESSOA)
);

INSERT INTO PESSOA (ID_PESSOA, NOME, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO, ATIVO) VALUES (PESSOA_SEQ.nextval, 'Vinicius', 'Quadra 425', '40', 'Casa', 'Laranjeiras', '73025-047', 'São Paulo', 'São Paulo', true);
INSERT INTO pessoa (ID_PESSOA, NOME, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO, ATIVO) values (PESSOA_SEQ.nextval, 'João Silva', 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO pessoa (ID_PESSOA, NOME, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO, ATIVO) values (PESSOA_SEQ.nextval, 'Maria Rita', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-12', 'Ribeirão Preto', 'SP', true);
INSERT INTO pessoa (ID_PESSOA, NOME, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO, ATIVO) values (PESSOA_SEQ.nextval, 'Pedro Santos', 'Rua da Bateria', '23', null, 'Morumbi', '54.212-12', 'Goiânia', 'GO', true);
INSERT INTO pessoa (ID_PESSOA, NOME, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO, ATIVO) values (PESSOA_SEQ.nextval, 'Ricardo Pereira', 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-12', 'Salvador', 'BA', true);
INSERT INTO pessoa (ID_PESSOA, NOME, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO, ATIVO) values (PESSOA_SEQ.nextval, 'Josué Mariano', 'Av Rio Branco', '321', null, 'Jardins', '56.400-12', 'Natal', 'RN', true);
INSERT INTO pessoa (ID_PESSOA, NOME, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO, ATIVO) values (PESSOA_SEQ.nextval, 'Pedro Barbosa', 'Av Brasil', '100', null, 'Tubalina', '77.400-12', 'Porto Alegre', 'RS', true);
INSERT INTO pessoa (ID_PESSOA, NOME, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO, ATIVO) values (PESSOA_SEQ.nextval, 'Henrique Medeiros', 'Rua do Sapo', '1120', 'Apto 201', 'Centro', '12.400-12', 'Rio de Janeiro', 'RJ', true);
INSERT INTO pessoa (ID_PESSOA, NOME, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO, ATIVO) values (PESSOA_SEQ.nextval, 'Carlos Santana', 'Rua da Manga', '433', null, 'Centro', '31.400-12', 'Belo Horizonte', 'MG', true);
INSERT INTO pessoa (ID_PESSOA, NOME, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO, ATIVO) values (PESSOA_SEQ.nextval, 'Leonardo Oliveira', 'Rua do Músico', '566', null, 'Segismundo Pereira', '38.400-00', 'Uberlândia', 'MG', true);
INSERT INTO pessoa (ID_PESSOA, NOME, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO, ATIVO) values (PESSOA_SEQ.nextval, 'Isabela Martins', 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '99.400-12', 'Manaus', 'AM', true);
