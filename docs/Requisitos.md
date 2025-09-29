# EcoColeta - Documento de Requisitos

> **Projeto:** Sistema de Coleta Seletiva (Monorepo)  
> **Backend:** Spring Boot | **Frontend:** Flask

## Stakeholders (fictícios)
- **Carla Ribeiro** — Gestora Ambiental da Prefeitura (sponsor, define prioridades).
- **João Lima** — Cidadão usuário (consulta pontos próximos).
- **Marta Souza** — Administradora de pontos (cadastra/atualiza locais).
- **Equipe de TI Municipal** — Operação e manutenção do sistema.
- **ONG VerdeVivo** — Parceira que fornece novos pontos e campanhas.

## Escopo (visão geral)
Sistema cliente-servidor simples para **cadastro** e **consulta** de pontos de coleta seletiva, com filtros por **tipo de resíduo** e por **proximidade geográfica**.

## Requisitos Funcionais (RF)
1. **RF01 — Listar Tipos de Resíduo**: o sistema deve disponibilizar os tipos aceitos (papel, plástico, vidro, metal, orgânico, eletrônico, bateria e óleo) para facilitar a consulta e o cadastro.
2. **RF02 — Consultar Pontos por Tipo**: o cidadão deve conseguir buscar pontos filtrando por um tipo de resíduo específico.
3. **RF03 — Consultar Pontos por Proximidade**: o cidadão deve poder informar latitude, longitude e raio (Km) para retornar pontos dentro da área.
4. **RF04 — Cadastrar Ponto de Coleta**: o administrador deve poder cadastrar um novo ponto informando nome, endereço, coordenadas, tipos aceitos, horário e contato.
5. **RF05 — Atualizar/Remover Ponto**: o administrador deve poder atualizar dados de um ponto e removê-lo quando necessário.

## Requisitos Não Funcionais (RNF)
1. **RNF01 — Desempenho**: para consultas típicas (≤ 5.000 pontos em memória), a resposta deve ocorrer em até 500ms em hardware padrão de desenvolvimento.
2. **RNF02 — Usabilidade**: API com documentação via Swagger/OpenAPI e nomenclatura REST clara.
3. **RNF03 — Confiabilidade**: dados de exemplo devem ser carregados automaticamente no start (semente) para garantir testabilidade.
4. **RNF04 — Portabilidade**: o servidor deve rodar com Java 17+ e Maven, sem dependência de serviços externos obrigatórios.
5. **RNF05 — Segurança Básica**: validação de entrada (Bean Validation) e rejeição de payloads inválidos com códigos HTTP apropriados.

## Restrições
- Sem persistência obrigatória entre execuções. Uso de **H2 em memória** para simplificar.
- Comunicação via **HTTP/JSON**.

## Casos de Uso (resumo)
- **UC01**: Cidadão consulta tipos e pontos perto de sua localização.
- **UC02**: Administrador cadastra/atualiza/remove ponto.
- **UC03**: Cliente CLI consome as APIs (demonstração cliente-servidor).

## Arquitetura Resumida
- **Servidor**: Spring Boot (Web, Validation, Data JPA, H2), camadas Controller → Service → Repository.
- **Cliente**: Java 17 console usando `java.net.http.HttpClient`.
- **Modelo**: `CollectionPoint { id, name, address, latitude, longitude, acceptedTypes[], hours, phone }`.

## Endpoints
- `GET /api/types`
- `GET /api/points?type={WASTE}&lat={LAT}&lng={LNG}&radiusKm={KM}`
- `POST /api/points`
- `PUT /api/points/{id}`
- `GET /api/points/{id}`
- `DELETE /api/points/{id}`

## Estratégia de Teste Manual
- Verificar `/swagger-ui.html` e chamar `GET /api/types`.
- Consultar `GET /api/points?type=GLASS`.
- Consultar `GET /api/points?lat=-23.55&lng=-46.63&radiusKm=5`.
- Criar e atualizar ponto via POST/PUT.
