# Arquitetura do Sistema EcoColeta

## Visão Geral

O EcoColeta é estruturado como um **monorepo** contendo:

```
Backend (Spring Boot) ←→ Frontend (Flask) ←→ Usuário
       ↓
   Banco H2 (em memória)
```

## Componentes

### 🔧 Backend - Spring Boot
**Localização:** `EcoColeta/server/`

**Responsabilidades:**
- API REST para gerenciamento de pontos de coleta
- Validação de dados e regras de negócio
- Persistência em banco H2
- Documentação OpenAPI/Swagger

**Tecnologias:**
- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- H2 Database
- Bean Validation
- Maven

### 🎨 Frontend - Flask
**Localização:** `EcoColeta_FlaskClient/`

**Responsabilidades:**
- Interface web para usuários finais
- Consumo da API REST do backend
- Renderização de templates
- Validação de formulários

**Tecnologias:**
- Python 3.8+
- Flask
- Jinja2
- HTML5/CSS3
- Requests (HTTP client)

## Fluxo de Dados

1. **Usuário** acessa interface Flask
2. **Frontend** faz requisições HTTP para API Spring Boot
3. **Backend** processa dados e consulta banco H2
4. **Resposta** retorna via JSON para o frontend
5. **Interface** renderiza dados para o usuário

## Comunicação

- **Protocolo:** HTTP/HTTPS
- **Formato:** JSON
- **Porta Backend:** 8080 (padrão)
- **Porta Frontend:** 5000 (padrão)

## Segurança

- Validação de entrada (Bean Validation)
- Sanitização de dados
- Tratamento de exceções
- Headers de segurança HTTP

## Escalabilidade

- Backend stateless (pode ser replicado)
- Banco H2 pode ser substituído por PostgreSQL/MySQL
- Frontend pode ser servido via nginx em produção
- API preparada para cache e load balancing