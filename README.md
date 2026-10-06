# 🚀 DevVault

> Sistema full stack para gerenciamento de projetos e tarefas voltado para desenvolvedores.

## Status

🟡 **Em desenvolvimento**

### Implementado

- [x] Java 21 + Spring Boot
- [x] Maven
- [x] SQLite local
- [x] REST API
- [x] CRUD de projetos
- [x] CRUD de tarefas
- [x] Dashboard com contadores
- [x] React + Vite
- [x] Migração de CSS para SCSS
- [x] SCSS organizado em variáveis, base, layout e componentes
- [x] Frontend conectado ao backend em `localhost:8081`
- [x] Persistência local em `backend/data/devvault.db`

### Próximas etapas

- [ ] Melhorar o Dashboard
- [ ] Página completa de detalhes do projeto
- [ ] Tecnologias por projeto
- [ ] Pesquisa e filtros
- [ ] Perfil do desenvolvedor
- [ ] Diário de desenvolvimento
- [ ] Autenticação e JWT
- [ ] Validações e tratamento visual de erros
- [ ] Testes automatizados
- [ ] Swagger/OpenAPI
- [ ] Melhorias de UI/UX e responsividade
- [x] Configuração do frontend para deploy Vite/Vercel
- [ ] Deploy

## Arquitetura

```
React + Vite
     ↓
REST API
     ↓
Spring Boot
     ↓
Spring Data JPA / Hibernate
     ↓
SQLite
```

## Estrutura

```
DevVault/
├── backend/
│   ├── data/
│   ├── src/main/java/com/devvault/
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── repository/
│   │   └── service/
│   └── pom.xml
├── frontend/
│   ├── src/
│   │   ├── styles.scss
│   │   └── styles/
│   ├── package.json
│   └── vite.config.js
└── README.md
```

## Execução

### Backend

```powershell
cd backend
.\mvnw.cmd spring-boot:run
```

Backend: `http://localhost:8081`

### Frontend

```powershell
cd frontend
npm install
npm run dev
```

Frontend: `http://localhost:5173`

### Deploy do frontend

O frontend React/Vite está preparado para publicação separada no Vercel.

No projeto da Vercel:
- **Root Directory:** `frontend`
- **Framework Preset:** Vite
- **Build Command:** `npm run build`
- **Output Directory:** `dist`
- **Environment Variable:** `VITE_API_URL`

Em produção, `VITE_API_URL` deve apontar para a URL pública do backend Spring Boot, por exemplo:

`VITE_API_URL=https://seu-backend.exemplo.com/api`

Para desenvolvimento local, `frontend/.env.example` mantém `http://localhost:8081/api`.

A Vercel permite configurar variáveis por ambiente; após alterar uma variável, é necessário fazer um novo deploy.

## Tecnologias

**Backend:** Java 21, Spring Boot, Spring Web, Spring Data JPA, Hibernate, SQLite, Maven.

**Frontend:** React, Vite, JavaScript, SCSS.

## Roadmap

A próxima etapa é evoluir o dashboard e a experiência de gerenciamento dos projetos antes de adicionar autenticação, tecnologias e diário de desenvolvimento.
