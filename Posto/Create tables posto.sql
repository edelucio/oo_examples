/*

	CRIADO POR EDEL�CIO LUCIANO
	DATA: 01/05/2018 23:00
	
	ALTERADO POR LUCAS
	09/05/2018 13:00

	ALTERADO POR EDEL�CIO LUCIANO
	DATA: 10/05/2018 01:23

	ALTERADO POR LUCAS
	14/05/2018 13:00

	ALTERADO POR LUCAS
	14/05/2018 14:28

*/

USE BD_POSTO;

-- -----------------------------------------------------
-- TABLE POSTO
-- -----------------------------------------------------
CREATE TABLE POSTO (
	ID_POSTO					INT				NOT NULL,
	NOME_FANTASIA				VARCHAR(50)		NULL,
	RAZAO_SOCIAL				VARCHAR(50)		NULL,
	CNPJ						VARCHAR(14)		NULL,
	TELEFONE					VARCHAR(18)		NULL,
	CPF_GERENTE					VARCHAR(11)		NULL,

	CONSTRAINT	PK_POSTO		PRIMARY KEY	(ID_POSTO),
	CONSTRAINT	UK_CNPJ_POSTO	UNIQUE (CNPJ)	
);

-- -----------------------------------------------------
-- TABLE DEPARTAMENTO
-- -----------------------------------------------------
CREATE TABLE DEPARTAMENTO (
	ID_DEPARTAMENTO				INT				NOT NULL,
	DESCRICAO					VARCHAR(30)		NULL,
	EMPREGADO_MATRICULA			INT

	CONSTRAINT PK_DEPARTAMENTO PRIMARY KEY (ID_DEPARTAMENTO),
);

-- -----------------------------------------------------
-- TABLE EMPREGADO
-- -----------------------------------------------------
CREATE TABLE EMPREGADO (
	MATRICULA					INT				NOT NULL,
	CPF							VARCHAR(11)		NULL,
	RG							VARCHAR(15)		NULL,
	NOME						VARCHAR(50)		NULL,
	DATA_NASCIMENTO				DATE			NULL,
	SEXO						VARCHAR(1)		NULL,
	NOME_MAE					VARCHAR(50)		NULL,
	NOME_PAI					VARCHAR(50)		NULL,
	LOTACAO						INT				NULL,
	GERENTE						INT				NULL,
	CARGO						VARCHAR(30)		NULL,
	POSTO						INT				NOT NULL,
														
	CONSTRAINT	PK_MATRICULA	PRIMARY KEY	(MATRICULA),
	CONSTRAINT	UK_CPF_EMPREGADO UNIQUE		(CPF),							 
	CONSTRAINT	FK_LOTACAO		FOREIGN KEY	(LOTACAO) REFERENCES DEPARTAMENTO
);

-- ADICIONANDO RELA��O ENTRE 'POSTO' E 'EMPREGADO'
ALTER TABLE POSTO 
	ADD CONSTRAINT	FK_CPF_GERENTE	FOREIGN KEY	(CPF_GERENTE) REFERENCES EMPREGADO (CPF);


-- -----------------------------------------------------
-- TABLE DEPENDENTE_EMPREGADO
-- -----------------------------------------------------
CREATE TABLE DEPENDENTE_EMPREGADO (
	ID_DEP_EMP				INT				NOT NULL,
	NOME					VARCHAR(45)		NULL,
	CPF						VARCHAR(11)		NULL,
	GRAU_PARENTESCO			VARCHAR(45)		NULL,
	SEXO					VARCHAR(1)		NULL,
	DATA_NASCIMENTO			DATE			NULL,
	EMPREGADO_MATRICULA		INT				NOT NULL,
	
	CONSTRAINT	PK_ID_DEPENDENTE_EMPREGADO	PRIMARY KEY	(ID_DEP_EMP),
	CONSTRAINT	FK_EMPREGADO_MATRICULA		FOREIGN KEY	(EMPREGADO_MATRICULA) REFERENCES EMPREGADO
);

-- -----------------------------------------------------
-- TABLE CLIENTE
-- -----------------------------------------------------
CREATE TABLE CLIENTE (
	ID_CLIENTE					INT				NOT NULL,
	TIPO						VARCHAR(1)		NULL,
	NOME						VARCHAR(50)		NULL,
	NOME_FANTASIA				VARCHAR(50)		NULL,
	RAZAO_SOCIAL				VARCHAR(50)		NULL,
	ENDERECO					VARCHAR(50)		NULL,
	TELEFONE					VARCHAR(18)		NULL,
	NUMERO_CNH					VARCHAR(12)		NULL,
	CPF_CNPJ					VARCHAR(14)		NULL,
	
	CONSTRAINT	PK_CLIENTE		PRIMARY KEY (ID_CLIENTE),
	CONSTRAINT	UK_CPF_CNPJ		UNIQUE (CPF_CNPJ)
);
  

-- -----------------------------------------------------
-- TABLE CONTA_BANCO
-- -----------------------------------------------------
CREATE TABLE CONTA_BANCO (
	ID_CONTA_BANCO			INT				NOT NULL,
	BANCO					VARCHAR(3)		NULL,
	AGENCIA					VARCHAR(5)		NULL,
	CONTA_CORRENTE			VARCHAR(12)		NULL,
	ID_CLIENTE				INT				NULL,
	ID_POSTO				INT				NULL,
	
	CONSTRAINT		PK_CONTA_BANCO		PRIMARY KEY		(ID_CONTA_BANCO),								
	CONSTRAINT		FK_CONTA_CLIENTE	FOREIGN KEY		(ID_CLIENTE) REFERENCES		CLIENTE (ID_CLIENTE),
	CONSTRAINT		FK_CONTA_POSTO		FOREIGN KEY		(ID_POSTO) REFERENCES		POSTO (ID_POSTO)
);

-- -----------------------------------------------------
-- TABLE DEPENDENTE_PF
-- -----------------------------------------------------
CREATE TABLE DEPENDENTE_PF (
	ID_DEP_PF					INT				NOT NULL,
	NOME						VARCHAR(50)		NULL,
	ENDERECO					VARCHAR(50)		NULL,
	TELEFONE					VARCHAR(18)		NULL,
	NUMERO_CNH					VARCHAR(12)		NULL,
	CPF							VARCHAR(11)		NULL,
	ID_CLIENTE					INT				NOT NULL,
	
	CONSTRAINT	PK_DEPENDENTE_PF PRIMARY KEY (ID_DEP_PF),
	CONSTRAINT	UK_DEPENDENTE_CPF UNIQUE (CPF),
	CONSTRAINT	FK_CLIENTE		 FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTE (ID_CLIENTE)
);

-- -----------------------------------------------------
-- TABLE ABASTECIMENTO
-- -----------------------------------------------------
CREATE TABLE ABASTECIMENTO (
	ID_ABASTECIMENTO		INT				NOT NULL,
	DATA_ABASTECIMENTO		DATE			NULL,
	DATA_VENCIMENTO			DATE			NULL,
	DATA_PAGAMENTO			DATE			NULL,
	VALOR					DECIMAL(7,2)	NULL,
	TIPO_PAGAMENTO			VARCHAR(18)		NULL,
	ID_POSTO				INT				NULL,
	ID_FRENTISTA			INT				NULL,
	CPF_CNPJ_CLIENTE		VARCHAR(14)		NULL,
	ID_DEPENDENTE			INT				NULL,
	NUM_CNH_DEPENDENTE		VARCHAR(12)		NULL,
	
	CONSTRAINT		PK_ABASTECIMENTO PRIMARY KEY (ID_ABASTECIMENTO),
	CONSTRAINT		FK_POSTO		 FOREIGN KEY (ID_POSTO)		 REFERENCES	POSTO (ID_POSTO),
	CONSTRAINT		FK_FRENTISTA	 FOREIGN KEY (ID_FRENTISTA)	 REFERENCES	EMPREGADO (MATRICULA),
	CONSTRAINT		FK_CLIENTE_ABAST FOREIGN KEY (CPF_CNPJ_CLIENTE)	 REFERENCES	CLIENTE (CPF_CNPJ),
	CONSTRAINT		FK_DEPENDENTE_PF FOREIGN KEY (ID_DEPENDENTE) REFERENCES DEPENDENTE_PF (ID_DEP_PF)
);
  
-- -----------------------------------------------------
-- TABLE FIDELIDADE
-- -----------------------------------------------------
CREATE TABLE FIDELIDADE (
  ID_FIDELIDADE				INT				NOT NULL,
  DATA_HORA					DATETIME		NULL,
  QTD_PONTOS				INT				NULL,
  ID_ABASTECIMENTO			INT				NULL,
   							CONSTRAINT		PK_FIDELIDADE
							PRIMARY KEY		(ID_FIDELIDADE),
							CONSTRAINT		FK_ABASTECIMENTO
							FOREIGN KEY		(ID_ABASTECIMENTO)
							REFERENCES		ABASTECIMENTO (ID_ABASTECIMENTO)
);