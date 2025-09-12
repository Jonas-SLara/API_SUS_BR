-- CONSULTA 1
--listar os nomes das cidades com o nome da doenca com
--o número de óbitos e de casos EM TODO O HISTÓRICO
SELECT c.nome, d.nome,
SUM(e.casos) AS total_obitos,
SUM(e.obitos)
FROM cidade c INNER JOIN epidemia e
ON e.id_cidade = c.id
INNER JOIN doenca d
ON d.id = e.id_doenca
GROUP BY(c.nome, d.nome)
ORDER BY c.nome;

-- CONSULTA 2
--listar os nomes das cidades com o nome da doenca com
--o número de óbitos e de casos em um mes e ano específico
SELECT c.nome, d.nome,
SUM(e.casos) AS total_casos,
SUM(e.obitos) AS total_obitos,
EXTRACT(YEAR FROM e.data_pesquisa) AS ano,
EXTRACT(MONTH FROM e.data_pesquisa) AS mes
FROM cidade c INNER JOIN epidemia e
ON e.id_cidade = c.id
INNER JOIN doenca d
ON d.id = e.id_doenca
WHERE EXTRACT(YEAR FROM e.data_pesquisa) = 2023
	AND EXTRACT(MONTH FROM e.data_pesquisa) = 3
GROUP BY(c.nome, d.nome, ano, mes)
ORDER BY c.nome;

--CONSULTA 3
--listar as vacinas desenvolvidas com as doencas para quais são
--aplicaveis
SELECT 
v.nome AS vacina_nome, 
d.nome AS doenca_nome FROM
vacina v INNER JOIN vacina_doenca vd
ON v.id = vd.id_vacina
INNER JOIN doenca d
ON d.id = vd.id_doenca
GROUP BY(vacina_nome, doenca_nome)
ORDER BY v.nome;

--CONSULTA 4
--listar as faixas