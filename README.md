# EcoColeta - Sistema de Coleta Seletiva

Sistema completo para gerenciamento de pontos de coleta seletiva, desenvolvido como monorepo com backend Spring Boot e frontend Flask.

## 📁 Estrutura do Projeto

```
pi-2-a/
├── EcoColeta/server/          # Backend Spring Boot
├── EcoColeta_FlaskClient/     # Frontend Flask
└── docs/                      # Documentação
```

## 🚀 Tecnologias

### Backend (Spring Boot)
- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- H2 Database
- OpenAPI/Swagger
- Maven

### Frontend (Flask)
- Python 3.8+
- Flask
- Jinja2 Templates
- CSS3

## ⚡ Início Rápido

### 1. Backend (Spring Boot)

```bash
cd EcoColeta/server
mvn spring-boot:run
```

**Endpoints disponíveis:**
- API: `http://localhost:8080/api`
- Swagger UI: `http://localhost:8080/swagger-ui.html`

### 2. Frontend (Flask)

```bash
cd EcoColeta_FlaskClient
pip install -r requirements.txt
python app.py
```

**Acesso:** `http://localhost:5000`

## 📋 Funcionalidades

### Backend API
- ✅ CRUD de pontos de coleta
- ✅ Filtros por tipo de resíduo
- ✅ Estatísticas do sistema
- ✅ Documentação OpenAPI
- ✅ Tratamento de exceções

### Frontend Web
- ✅ Interface para visualizar pontos
- ✅ Formulário para cadastro
- ✅ Listagem com filtros
- ✅ Detalhes do ponto
- ✅ Design responsivo

## 🔧 Configuração

### Variáveis de Ambiente

**Backend:**
- `SERVER_PORT`: Porta do servidor (padrão: 8080)
- `DB_URL`: URL do banco H2

**Frontend:**
- `FLASK_ENV`: Ambiente Flask
- `API_BASE_URL`: URL da API backend

### Banco de Dados

O sistema utiliza H2 em memória com dados de exemplo pré-carregados.

## 📖 Documentação Detalhada

- [Requisitos do Sistema](docs/Requisitos.md)
- [Documentação do Backend](docs/Server.md)
- [Documentação do Frontend](docs/Cliente_Flask.md)
- [Arquitetura do Sistema](docs/Arquitetura.md)
- [Guia de Desenvolvimento](docs/Desenvolvimento.md)

## 🤝 Contribuição

1. Fork o projeto
2. Crie uma branch para sua feature
3. Commit suas mudanças
4. Push para a branch
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT.