# Frontend - Flask

> **Localização:** `EcoColeta_FlaskClient/`  
> **Tecnologia:** Python 3.8+ + Flask

Interface web para consumir a API REST do backend Spring Boot.

## Requisitos
- Python 3.10+
- Dependências do `requirements.txt`

## Como Executar

```bash
cd EcoColeta_FlaskClient
pip install -r requirements.txt
python app.py
```

**Acesso:** http://localhost:5000

## Estrutura do Código

```
EcoColeta_FlaskClient/
├── static/          # CSS e assets estáticos
├── templates/       # Templates Jinja2
├── app.py          # Aplicação Flask principal
└── requirements.txt # Dependências Python
```

## Páginas Disponíveis

- **Home** (`/`) - Lista tipos de resíduos
- **Pontos** (`/points`) - Lista pontos com filtros
- **Novo Ponto** (`/points/new`) - Formulário de cadastro
- **Detalhes** (`/points/<id>`) - Visualização detalhada
- **Editar** (`/points/<id>/edit`) - Formulário de edição

## Funcionalidades
- **Listar Tipos** (home)
- **Filtrar Pontos** por tipo e/ou proximidade (lat, lng, raio Km)
- **CRUD** de pontos (criar, visualizar, editar, remover)

## Dependências

- Backend Spring Boot deve estar rodando na porta 8080
- Conexão HTTP para consumo da API REST
- Templates respondem a diferentes tamanhos de tela
