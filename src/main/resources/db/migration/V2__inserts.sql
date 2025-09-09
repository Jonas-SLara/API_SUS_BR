-- Insere dados nas tabelas principais.
-- Os IDs serão gerados automaticamente pelo banco de dados.

-- Inserindo dados na tabela doenca
INSERT INTO doenca (nome, descricao) VALUES
    ('COVID-19', 'Infecção respiratória viral causada por um coronavírus.'),
    ('Influenza', 'Doença infecciosa aguda do sistema respiratório.'),
    ('Sarampo', 'Infecção viral que causa febre alta e erupções cutâneas.'),
    ('Dengue', 'Doença viral transmitida por mosquitos.'),
    ('Febre Amarela', 'Doença viral grave transmitida por mosquitos.');
    ('Caxumba', 'Infecção viral que afeta as glândulas salivares.')
-- Inserindo dados na tabela vacina
INSERT INTO vacina (nome) VALUES
    ('Vacina da COVID-19'),
    ('Vacina da Influenza'),
    ('Vacina Tríplice Viral'),
    ('Vacina contra a Dengue'),
    ('Vacina contra a Febre Amarela');

-- Inserindo dados na tabela cidade
INSERT INTO cidade (nome, codigo_ibge, populacao, estado) VALUES
    ('São Paulo', '3550308', 12396372, 'SP'),
    ('Rio de Janeiro', '3304557', 6710000, 'RJ'),
    ('Belo Horizonte', '3106200', 2521000, 'MG'),
    ('Brasília', '5300108', 3094325, 'DF'),
    ('Manaus', '1302603', 2219580, 'AM');

-- Inserindo dados na tabela faixa_etaria
INSERT INTO faixa_etaria (descricao, idade_min, idade_max) VALUES
    ('Crianças (0-11)', 0, 11),
    ('Adolescentes (12-19)', 12, 19),
    ('Adultos Jovens (20-39)', 20, 39),
    ('Adultos (40-59)', 40, 59),
    ('Idosos (60+)', 60, 120);

-- Insere dados nas tabelas de relacionamento, usando os IDs que serão gerados.
-- O banco de dados vai atribuir os IDs 1, 2, 3... em ordem de inserção.

-- Inserindo dados na tabela vacina_doenca
INSERT INTO vacina_doenca (id_doenca, id_vacina) VALUES
    (1, 1), -- COVID-19 -> Vacina da COVID-19
    (2, 2), -- Influenza -> Vacina da Influenza
    (3, 3), -- Sarampo -> Vacina Tríplice Viral
    (4, 4), -- Dengue -> Vacina contra a Dengue
    (5, 5), -- Febre Amarela -> Vacina contra a Febre Amarela
    (6, 3); -- Caxumba -> Vacina Tríplice Viral

-- Inserindo dados na tabela estrutura_hospitalar
INSERT INTO estrutura_hospitalar (tipo, quantidade, id_cidade) VALUES
    ('LEITO_CLINICO', 500, 1), -- São Paulo
    ('LEITO_CIRURGICO', 200, 1), -- São Paulo
    ('LEITO_CLINICO', 350, 2), -- Rio de Janeiro
    ('LEITO_PEDIATRICO', 80, 2), -- Rio de Janeiro
    ('LEITO_OBSERVACAO', 100, 3); -- Belo Horizonte

-- Inserindo dados na tabela epidemia
INSERT INTO epidemia (id_doenca, id_cidade, data_pesquisa, obitos, casos) VALUES
    (1, 1, '2023-01-15', 1500, 50000), -- COVID-19 em São Paulo
    (2, 2, '2023-02-20', 80, 15000), -- Influenza no Rio de Janeiro
    (4, 5, '2023-03-10', 50, 8000), -- Dengue em Manaus
    (1, 3, '2023-04-05', 500, 25000), -- COVID-19 em Belo Horizonte
    (3, 1, '2023-05-01', 5, 500); -- Sarampo em São Paulo
    (6, 2, '2023-06-01', 0, 20000) -- Caxumba em Rio de Janeiro

-- Inserindo dados na tabela cobertura
INSERT INTO cobertura (id_vacina, id_cidade, id_faixa_etaria, data_pesquisa, populacao_alvo, vacinados, porcentagem_cobertura) VALUES
    (1, 1, 5, '2023-06-01', 1000000, 850000, 85.00), -- Vacina COVID-19 em SP para Idosos
    (2, 2, 1, '2023-06-05', 500000, 480000, 96.00), -- Vacina Influenza no RJ para Crianças
    (3, 3, 2, '2023-06-10', 300000, 280000, 93.33), -- Vacina Tríplice Viral em BH para Adolescentes
    (4, 5, 3, '2023-06-15', 400000, 250000, 62.50), -- Vacina Dengue em Manaus para Adultos Jovens
    (5, 4, 4, '2023-06-20', 200000, 195000, 97.50); -- Vacina Febre Amarela em Brasília para Adultos
    
-- Inserindo dados na tabela admin (UUIDs serão gerados automaticamente)
INSERT INTO admin (email, senha) VALUES
    ('admin@exemplo.com', 'senha_hash_123'),
    ('gerente@exemplo.com', 'senha_hash_456');
