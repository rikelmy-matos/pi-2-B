# Backend - Spring Boot

> **Localização:** `EcoColeta/server/`  
> **Tecnologia:** Java 17 + Spring Boot 3.x

## Melhorias Implementadas

### Validações Robustas
- Validação de coordenadas geográficas
- Validação de formato de telefone brasileiro
- Validação de tamanho de campos
- Mensagens de erro personalizadas em português

### Tratamento de Exceções
- Handler global de exceções
- Respostas de erro padronizadas
- Validação de parâmetros de entrada

### Documentação da API
- Swagger/OpenAPI configurado
- Descrições detalhadas dos endpoints
- Exemplos de uso
- Esquemas de dados documentados

### Otimizações
- Consultas JPA otimizadas com FETCH JOIN
- Transações read-only para consultas
- Uso de Streams para filtros
- Validação de existência antes de operações

## Endpoints da API

### Tipos de Resíduos
- `GET /api/types` — Lista tipos de resíduos com descrições

### Pontos de Coleta
- `GET /api/points` — Lista pontos (filtros: type, lat, lng, radiusKm)
- `GET /api/points/{id}` — Detalhes de um ponto específico
- `POST /api/points` — Cadastra novo ponto
- `PUT /api/points/{id}` — Atualiza ponto existente
- `DELETE /api/points/{id}` — Remove ponto

### Estatísticas
- `GET /api/stats` — Estatísticas gerais do sistema

## Tipos de Resíduos Suportados
- **PAPER**: Papel (jornais, revistas, papelão)
- **PLASTIC**: Plástico (garrafas PET, embalagens)
- **GLASS**: Vidro (garrafas, potes, frascos)
- **METAL**: Metal (latas de alumínio, ferro, aço)
- **ORGANIC**: Orgânico (restos de comida, cascas)
- **ELECTRONIC**: Eletrônico (celulares, computadores)
- **BATTERY**: Bateria (pilhas e baterias)
- **OIL**: Óleo (óleo de cozinha usado)

## Acesso
- **API**: `http://localhost:8080/api`
- **Swagger**: `http://localhost:8080/swagger-ui.html`
- **H2 Console**: `http://localhost:8080/h2-console`
  - JDBC URL: `jdbc:h2:mem:ecocoleta`
  - Username: `sa`
  - Password: (vazio)

## Como Executar

```bash
cd EcoColeta/server
mvn spring-boot:run
```

## Estrutura do Código

```
src/main/java/br/ecocoleta/server/
├── config/          # Configurações (OpenAPI, DataSeeder)
├── controller/      # Controllers REST
├── dto/            # Data Transfer Objects
├── exception/      # Tratamento de exceções
├── model/          # Entidades JPA
├── repository/     # Repositórios Spring Data
└── service/        # Lógica de negócio
```
