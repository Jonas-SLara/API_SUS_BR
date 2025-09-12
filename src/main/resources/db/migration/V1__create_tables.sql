-- Tabela para armazenar informações sobre doenças
CREATE TABLE IF NOT EXISTS doenca (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    descricao VARCHAR(255) NOT NULL,
    nome VARCHAR(100) NOT NULL
);

-- Tabela para armazenar informações sobre vacinas
CREATE TABLE IF NOT EXISTS vacina (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(100) NOT NULL
);

-- RELAÇÃO DE DOENÇAS E VACINAS É N PARA N
CREATE TABLE IF NOT EXISTS vacina_doenca(
	id_doenca BIGINT NOT NULL REFERENCES doenca(id),
	id_vacina BIGINT NOT NULL REFERENCES vacina(id),
    --chave composta
	PRIMARY KEY(id_doenca, id_vacina)
);

-- Tabela para armazenar informações sobre as cidades
CREATE TABLE IF NOT EXISTS cidade (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(40) NOT NULL,
    codigo_ibge VARCHAR(7) UNIQUE NOT NULL,
    populacao INT NOT NULL,
    estado VARCHAR(2) NOT NULL
);

-- Tabela para armazenar informações sobre a estrutura hospitalar
CREATE TABLE IF NOT EXISTS estrutura_hospitalar (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    tipo VARCHAR(50) NOT NULL,
    quantidade INT CHECK (quantidade >= 0),
    id_cidade BIGINT NOT NULL REFERENCES cidade(id),
    -- Restrição CHECK para os tipos de leitos
    CONSTRAINT valid_leito_tipo CHECK (
        tipo IN (
            'LEITO_CLINICO',
            'LEITO_CIRURGICO',
            'LEITO_OBSTETRICO',
            'LEITO_PEDIATRICO',
            'LEITO_OBSERVACAO'
        )
    )
);

-- Tabela para armazenar informações sobre faixas etárias
CREATE TABLE IF NOT EXISTS faixa_etaria (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    descricao VARCHAR(50),
    idade_min INT NOT NULL,
    idade_max INT NOT NULL,
    CONSTRAINT idade_min_menor_max CHECK (idade_min <= idade_max)
);

-- Tabela para registrar informações sobre epidemias
CREATE TABLE IF NOT EXISTS epidemia (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_doenca BIGINT NOT NULL REFERENCES doenca(id),
    id_cidade BIGINT NOT NULL REFERENCES cidade(id),
    data_pesquisa DATE NOT NULL,
    obitos INT CHECK (obitos >= 0),
    casos INT CHECK (casos >= 0),
    CONSTRAINT data_unica_por_cidade UNIQUE (id_cidade, id_doenca, data_pesquisa)
);

-- Tabela para registrar a cobertura vacinal
CREATE TABLE IF NOT EXISTS cobertura (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_vacina BIGINT NOT NULL REFERENCES vacina(id),
    id_cidade BIGINT NOT NULL REFERENCES cidade(id),
    id_faixa_etaria BIGINT NOT NULL REFERENCES faixa_etaria(id),
    data_pesquisa DATE NOT NULL,
    populacao_alvo INT CHECK (populacao_alvo >= 0),
    vacinados INT CHECK (vacinados >= 0),
    porcentagem_cobertura DECIMAL(5,3),
    CONSTRAINT unique_cobertura UNIQUE (
        id_vacina, id_cidade, id_faixa_etaria, data_pesquisa)
);

-- Tabela para usuários administradores
CREATE TABLE IF NOT EXISTS admin (
    id UUID PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    email VARCHAR(255) UNIQUE,
    senha VARCHAR(255)
);