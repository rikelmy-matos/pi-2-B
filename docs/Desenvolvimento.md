# Guia de Desenvolvimento

## Configuração do Ambiente

### Pré-requisitos
- Java 17+
- Maven 3.6+
- Python 3.8+
- Git

### Setup Inicial

```bash
# Clone o repositório
git clone <url-do-repo>
cd pi-2-a

# Backend
cd EcoColeta/server
mvn clean install

# Frontend
cd ../../EcoColeta_FlaskClient
pip install -r requirements.txt
```

## Executando o Sistema

### 1. Iniciar Backend
```bash
cd EcoColeta/server
mvn spring-boot:run
```
✅ API disponível em: http://localhost:8080/api

### 2. Iniciar Frontend
```bash
cd EcoColeta_FlaskClient
python app.py
```
✅ Interface web em: http://localhost:5000

## Desenvolvimento

### Backend (Spring Boot)

**Estrutura de camadas:**
- `Controller` → Endpoints REST
- `Service` → Lógica de negócio
- `Repository` → Acesso a dados
- `Model` → Entidades JPA

**Adicionando novo endpoint:**
1. Criar método no `Controller`
2. Implementar lógica no `Service`
3. Atualizar documentação OpenAPI

### Frontend (Flask)

**Estrutura MVC:**
- `app.py` → Rotas e controllers
- `templates/` → Views (Jinja2)
- `static/` → CSS e assets

**Adicionando nova página:**
1. Criar rota em `app.py`
2. Criar template em `templates/`
3. Adicionar estilos em `static/styles.css`

## Testes

### Backend
```bash
cd EcoColeta/server
mvn test
```

### Frontend
```bash
cd EcoColeta_FlaskClient
python -m pytest  # se configurado
```

## Build para Produção

### Backend
```bash
mvn clean package
java -jar target/ecocoleta-server-*.jar
```

### Frontend
```bash
# Usar gunicorn ou similar
pip install gunicorn
gunicorn -w 4 -b 0.0.0.0:5000 app:app
```

## Troubleshooting

### Problemas Comuns

**Backend não inicia:**
- Verificar Java 17+ instalado
- Porta 8080 disponível
- Dependências Maven baixadas

**Frontend não conecta:**
- Backend rodando na porta 8080
- URL da API configurada corretamente
- Dependências Python instaladas

**Banco de dados:**
- H2 Console: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:ecocoleta`
- User: `sa`, Password: (vazio)