# API_SUS_BR
> @Jonas-SLara

Desenvolvimento de uma API sobre dados de saúde pública do Portal de  Dados aberto do governo e do DataSus para análise de cobertura vacinal, casos por doença e leitos clínicos, a ídei principal está em transformar dados brutos do governo em uma api pública acessível e de interesse para gestores e pesquisadores

## Sumário
> [**Funcionalidades**](#funcionalidades)

> [**Regras**](#regras)

> [**Modelo ER**](#modelo-er)

> [**Requisitos e Deploy Local**](#requisitos-e-tutorial-de-deploy-local)

## Funcionalidades

  - [ ] **Consulta Epidemiológica por Região:** A API permitirá a consulta de casos e óbitos de doenças específicas por município.
  - [ ] **Visualização e Análise de Cobertura Vacinal:** Serão disponibilizados dados de cobertura de vacinas por faixa etária em cada munícipio.
  - [ ] **Análise de Infraestrutura de Saúde:** O projeto fornecerá dados detalhados sobre a infraestrutura hospitalar, permitindo a consulta do número de leitos de UTI de cada tipo por município
  - [ ] **Autenticação e Autorização administrativa** existirá um usuário administrador com credenciais autenticadas. Esse usuário será responsável pela manutenção de dados através de endpoints restritos.
  - [ ] **Consulta Populacional** A API poderá entregar dados de consultas sobre a população de cada município e da faixa etária correspondente

## Regras
  - [ ] **Autenticação Pública por Chave de API:** Para acessar os endpoints, os usuários públicos deverão enviar uma chave de API válida no cabeçalho de cada requisição.
  - [ ] **Paginação de Dados:** Para consultas que retornam grandes volumes de dados a API páginara os resultados, 50 mais ou menos
  - [ ] **Validação para novos dados** os dados de tipos de leitos, tipos de doenças devem ser validados na camada de banco de dados
  - [ ] **Dados Anuais e mensais** os dados da cobertura vacinal, consultas epidemiológicas e Consultas Populacionais podem ser filtrados por mes e ano de coleta de dados, sendo o ano uma média de todos os meses daquele ano

## modeloER
  ![imagem do modelo er](docs/modeloER.png)
  
## Requisitos e tutorial de Deploy Local
