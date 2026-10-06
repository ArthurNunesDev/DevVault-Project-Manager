# 🚀 DevVault

> Sistema full stack para gerenciamento de projetos e tarefas, desenvolvido com Java/Spring Boot e React.

O DevVault foi criado como um projeto de portfólio para demonstrar uma aplicação Java moderna com API REST, persistência de dados, frontend separado e uma estrutura preparada para execução local e publicação futura.

## ✨ Funcionalidades

- CRUD completo de projetos
- CRUD completo de tarefas
- Associação de tarefas aos projetos
- Status e prioridades para projetos e tarefas
- Datas de vencimento
- Dashboard com contadores
- Validação de dados na API
- Tratamento padronizado de erros HTTP
- Endpoint de health check
- Persistência local com SQLite
- Perfil de produção preparado para PostgreSQL
- CORS configurável por variável de ambiente
- Frontend React/Vite separado do backend
- Build do frontend preparado para GitHub Pages
- Dockerfile para o backend
- GitHub Actions para validação automática do backend

## 🧱 Tecnologias

### Backend
- Java 21
- Spring Boot 3.5.5
- Spring Web
- Spring Data JPA
- Hibernate
- Bean Validation
- SQLite
- PostgreSQL
- Maven

### Frontend
- React
- Vite
- JavaScript
- SCSS

## 📁 Estrutura

```text
DevVault-Project-Manager/
├── .github/
│   └── workflows/
│       ├── backend-ci.yml
│       └── deploy-pages.yml
├── backend/
│   ├── data/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/devvault/
│   │   │   │   ├── config/
│   │   │   │   ├── controller/
│   │   │   │   ├── dto/
│   │   │   │   ├── entity/
│   │   │   │   ├── repository/
│   │   │   │   └── service/
│   │   │   └── resources/
│   │   └── test/
│   ├── Dockerfile
│   └── pom.xml
├── frontend/
│   ├── src/
│   ├── .env.example
│   ├── package.json
│   └── vite.config.js
└── README.md
```

## ▶️ Como executar localmente

### 1. Pré-requisitos
- Java 21
- Node.js 20+
- npm

Não é necessário instalar SQLite separadamente. O driver JDBC já faz parte do backend.

### 2. Backend

No Windows:

```powershell
cd backend
.\mvnw.cmd spring-boot:run
```

No Linux/macOS:

```bash
cd backend
mvn spring-boot:run
```

A API ficará disponível em:

```text
http://localhost:8081
```

Health check:

```text
GET http://localhost:8081/api/health
```

Resposta esperada:

```json
{
  "status": "ok",
  "service": "devvault-api"
}
```

### 3. Frontend

Em outro terminal:

```powershell
cd frontend
npm install
npm run dev
```

O frontend ficará disponível em:

```text
http://localhost:5173
```

Por padrão, o frontend usa:

```text
http://localhost:8081/api
```

Para alterar a API, copie `.env.example` para `.env` e ajuste `VITE_API_URL`.

## 🗄️ Banco de dados

### Desenvolvimento

O perfil padrão é `local` e utiliza SQLite:

```text
backend/data/devvault.db
```

O arquivo é criado automaticamente na primeira execução e não deve ser versionado.

### Produção

O perfil `prod` está preparado para PostgreSQL por meio das variáveis:

```text
SPRING_PROFILES_ACTIVE=prod
PGHOST=
PGPORT=
PGDATABASE=
PGUSER=
PGPASSWORD=
```

A aplicação também aceita `PORT` para ambientes de hospedagem que fornecem a porta dinamicamente.

## 🌐 CORS

As origens permitidas são configuradas por:

```text
CORS_ALLOWED_ORIGINS
```

Localmente, o padrão é:

```text
http://localhost:5173
```

Para uma publicação futura, basta informar as origens reais separadas por vírgula.

## 🐳 Docker

O backend possui um `Dockerfile` próprio e pode ser construído com:

```bash
cd backend
docker build -t devvault-backend .
docker run --rm -p 8081:8081 devvault-backend
```

Para usar PostgreSQL no container, configure as variáveis de ambiente do perfil `prod`.

## 🧪 Testes

Os testes do backend podem ser executados com:

```powershell
cd backend
.\mvnw.cmd test
```

O GitHub Actions executa essa validação automaticamente quando alterações do backend são enviadas para a branch `main` ou em pull requests.

## 📦 Publicação futura

O projeto **não depende de nenhum serviço online para funcionar localmente**.

A estrutura, porém, já está preparada para uma publicação futura:

```text
React/Vite
   ↓
Frontend hospedado
   ↓ HTTPS
Spring Boot
   ↓
PostgreSQL
```

O workflow `deploy-pages.yml` também deixa o frontend preparado para GitHub Pages. Caso seja utilizado, a variável de repositório `VITE_API_URL` deve apontar para a API pública.

Nenhum serviço externo, banco online ou conta de hospedagem é necessário para estudar, clonar ou executar o projeto.

## 🔌 Principais endpoints

| Método | Endpoint | Função |
|---|---|---|
| GET | `/api/health` | Verifica a API |
| GET | `/api/projects` | Lista projetos |
| GET | `/api/projects/{id}` | Busca projeto |
| POST | `/api/projects` | Cria projeto |
| PUT | `/api/projects/{id}` | Atualiza projeto |
| DELETE | `/api/projects/{id}` | Remove projeto |
| GET | `/api/tasks` | Lista tarefas |
| GET | `/api/tasks/{id}` | Busca tarefa |
| POST | `/api/tasks` | Cria tarefa |
| PUT | `/api/tasks/{id}` | Atualiza tarefa |
| DELETE | `/api/tasks/{id}` | Remove tarefa |
| GET | `/api/dashboard` | Retorna indicadores |

## 🎯 Objetivo do projeto

O DevVault serve como projeto de portfólio para demonstrar:

- desenvolvimento backend com Java e Spring Boot;
- criação de APIs REST;
- persistência com JPA/Hibernate;
- uso de banco relacional;
- integração entre frontend e backend;
- organização de um projeto full stack;
- configuração por ambiente;
- testes automatizados;
- preparação para containerização e deploy.

## 📌 Status

**Concluído como projeto de portfólio base.**

Novas funcionalidades podem ser adicionadas futuramente, mas o repositório atual já possui estrutura suficiente para ser clonado, configurado e executado por outra pessoa.
