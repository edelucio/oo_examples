-------------------------------------------------------------------------
/* CONSULTA 1
 A primeira consulta deve apresentar para cada posto os abastecimentos a serem cobrados para seus clientes que
 realizaram o pagamento por convênio. A consulta deverá constar: CNPJ, razão social e os dados bancários do Posto, 
 identificação do cliente e seus dados bancários, data do abastecimento, valor do abastecimento e vencimento do pagamento. 
*/
 -------------------------------------------------------------------------
USE BD_POSTO;

SELECT	[CNPJ POSTO] = P.CNPJ,
		[RAZÃO SOCIAL POSTO] = P.RAZAO_SOCIAL,
		[BANCO POSTO] = B.BANCO,
		[AGÊNCIA POSTO] = B.AGENCIA,
		[CONTA POSTO] = B.CONTA_CORRENTE,
		[NOME FANTASIA CLIENTE] = C.NOME_FANTASIA,
		[BANCO CLIENTE] = B1.BANCO,
		[AGÊNCIA CLIENTE] = B1.AGENCIA,
		[CONTA CLIENTE] = B1.CONTA_CORRENTE,
		[DATA ABASTECIMENTO] = A.DATA_ABASTECIMENTO,
		[DATA VENCIMENTO] = A.DATA_VENCIMENTO,
		[DATA PAGAMENTO] = A.DATA_PAGAMENTO,
		[VALOR DO ABASTECIMENTO] = A.VALOR
		FROM ABASTECIMENTO A	INNER JOIN POSTO P ON A.ID_POSTO = P.ID_POSTO
								INNER JOIN CONTA_BANCO B ON B.ID_POSTO = P.ID_POSTO
								INNER JOIN CLIENTE C ON C.CPF_CNPJ = A.CPF_CNPJ_CLIENTE
								INNER JOIN CONTA_BANCO B1 ON B1.ID_CLIENTE = C.ID_CLIENTE
								WHERE A.TIPO_PAGAMENTO LIKE 'CONVENIO' AND C.TIPO = 'J';

-------------------------------------------------------------------------
/* CONSULTA 2
 A segunda consulta deve apresentar por mês para cada cliente: a quantidade de abastecimentos, valor abastecido
 e a quantidade de pontos do programa fidelidade. Informar os dados cadastrais mais pertinentes para essa última
 consulta.
*/
-------------------------------------------------------------------------

SELECT	[MÊS] = MONTH(A.DATA_ABASTECIMENTO),
		[CLIENTE] = C.NOME, 	
		[CPF] = C.CPF_CNPJ,
		[QTD ABASTECIMENTO] = COUNT(A.ID_ABASTECIMENTO),
		[VALOR ABASTECIMENTO] = SUM(A.VALOR),
		[QTD PONTOS] = SUM(F.QTD_PONTOS)
	    FROM CLIENTE C
	    INNER JOIN ABASTECIMENTO A 
			ON A.CPF_CNPJ_CLIENTE = C.CPF_CNPJ
	    INNER JOIN FIDELIDADE F
	        ON F.ID_ABASTECIMENTO = A.ID_ABASTECIMENTO
	    WHERE C.TIPO = 'F'
	    GROUP BY C.NOME, C.CPF_CNPJ, MONTH(A.DATA_ABASTECIMENTO)
	    --ORDER BY C.NOME ASC

		UNION

		SELECT	[MÊS] = MONTH(A.DATA_ABASTECIMENTO),
		[CLIENTE] = D.NOME, 	
		[CPF] = D.CPF,
		[QTD ABASTECIMENTO] = COUNT(A.ID_ABASTECIMENTO),
		[VALOR ABASTECIMENTO] = SUM(A.VALOR),
		[QTD PONTOS] = SUM(F.QTD_PONTOS)
	    FROM DEPENDENTE_PF D
	    INNER JOIN ABASTECIMENTO A 
			ON A.ID_DEPENDENTE = D.ID_DEP_PF
	    INNER JOIN FIDELIDADE F
	        ON F.ID_ABASTECIMENTO = A.ID_ABASTECIMENTO
		GROUP BY D.NOME, D.CPF, MONTH(A.DATA_ABASTECIMENTO);
