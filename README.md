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

## Tecnologias

**Backend:** Java 21, Spring Boot, Spring Web, Spring Data JPA, Hibernate, SQLite, Maven.

**Frontend:** React, Vite, JavaScript, SCSS.

## Roadmap

A próxima etapa é evoluir o dashboard e a experiência de gerenciamento dos projetos antes de adicionar autenticação, tecnologias e diário de desenvolvimento.
