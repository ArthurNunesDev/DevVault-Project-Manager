# 🚀 DevVault

> Sistema web para gerenciamento de projetos e tarefas voltado para desenvolvedores.

O **DevVault** é uma aplicação full stack desenvolvida com **Java + Spring Boot + SQLite** no backend e **React + Vite** no frontend.

O objetivo do projeto é centralizar projetos de desenvolvimento, tarefas, prioridades e informações de acompanhamento em uma interface única, servindo também como um projeto completo de portfólio para demonstrar conhecimentos em **Java, APIs REST, banco de dados, React, arquitetura de software e desenvolvimento full stack**.

---

## 📌 Status do projeto

🟡 **Em desenvolvimento**

A estrutura principal da aplicação já está funcionando.

### Atualmente funcionando

- [x] Backend Spring Boot
- [x] Java 21
- [x] Maven
- [x] Banco SQLite
- [x] Criação automática das tabelas
- [x] API REST de projetos
- [x] API REST de tarefas
- [x] API do dashboard
- [x] CRUD básico de projetos
- [x] CRUD básico de tarefas
- [x] React + Vite
- [x] Comunicação React → Spring Boot
- [x] Dashboard inicial
- [x] Criação de projetos pela interface
- [x] Persistência local dos dados
- [x] Separação entre frontend e backend
- [x] Configuração para execução local

### Ainda precisa ser implementado

- [ ] Autenticação de usuários
- [ ] Login e cadastro
- [ ] JWT
- [ ] Usuários e permissões
- [ ] Página de detalhes do projeto
- [ ] Tecnologias utilizadas em cada projeto
- [ ] Filtros e pesquisa
- [ ] Sistema de desenvolvimento/andamento
- [ ] Diário de desenvolvimento
- [ ] Melhorias no dashboard
- [ ] Validações mais completas
- [ ] Tratamento visual de erros
- [ ] Testes automatizados
- [ ] Swagger/OpenAPI
- [ ] Documentação completa da API
- [ ] Responsividade aprimorada
- [ ] Melhorias gerais de UI/UX
- [ ] Docker como opção de execução
- [ ] Preparação final para portfólio

---

# 🧠 Objetivo

O DevVault foi pensado para funcionar como um **gerenciador pessoal de projetos para desenvolvedores**.

A ideia é permitir que um desenvolvedor consiga:

1. Criar projetos.
2. Definir o estado atual de cada projeto.
3. Criar tarefas.
4. Definir prioridades.
5. Acompanhar o progresso.
6. Visualizar estatísticas.
7. Registrar informações sobre o desenvolvimento.
8. Organizar as tecnologias utilizadas.
9. Acompanhar projetos concluídos e em andamento.

A aplicação também tem como objetivo demonstrar a construção de um sistema completo, desde o banco de dados até a interface.

---

# 🏗️ Arquitetura

O projeto utiliza uma arquitetura dividida em duas aplicações principais:

```text
                    DEVVAULT
                       │
          ┌────────────┴────────────┐
          │                         │
      FRONTEND                  BACKEND
          │                         │
      React/Vite              Spring Boot
          │                         │
          │                     REST API
          │                         │
          └────────────┬────────────┘
                       │
                     SQLite
                       │
                 devvault.db
```

## Frontend

Tecnologias principais:

- React
- Vite
- JavaScript
- CSS
- Fetch API

Responsável pela interface e interação com o usuário.

## Backend

Tecnologias principais:

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Maven

Responsável pela lógica da aplicação e disponibilização da API REST.

## Banco de dados

O projeto utiliza:

**SQLite**

A escolha do SQLite foi feita para manter o projeto simples de executar localmente.

Não é necessário:

- PostgreSQL
- MySQL
- servidor de banco separado
- VM
- configuração de infraestrutura

Os dados ficam armazenados em um único arquivo:

```text
backend/data/devvault.db
```

---

# 📁 Estrutura do projeto

```text
DevVault/
│
├── backend/
│   │
│   ├── data/
│   │   └── devvault.db
│   │
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── devvault/
│   │   │   │           │
│   │   │   │           ├── controller/
│   │   │   │           ├── dto/
│   │   │   │           ├── entity/
│   │   │   │           ├── repository/
│   │   │   │           ├── service/
│   │   │   │           └── DevVaultApplication.java
│   │   │   │
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   │
│   │   └── test/
│   │
│   └── pom.xml
│
├── frontend/
│   │
│   ├── src/
│   │   ├── App.jsx
│   │   ├── main.jsx
│   │   └── styles.css
│   │
│   ├── index.html
│   ├── package.json
│   └── vite.config.js
│
├── .gitignore
└── README.md
```

---

# ☕ Backend

## Java

O backend utiliza:

```text
Java 21
```

A aplicação principal está em:

```text
backend/src/main/java/com/devvault/DevVaultApplication.java
```

O Spring Boot é responsável por inicializar toda a aplicação.

---

# 📦 Dependências principais

O `pom.xml` utiliza:

### Spring Web

Responsável pela criação da API REST.

### Spring Data JPA

Responsável pela comunicação entre as entidades Java e o banco de dados.

### SQLite JDBC

Responsável pela conexão com o banco SQLite.

### Hibernate Community Dialects

Permite utilizar o SQLite através do Hibernate.

### Validation

Utilizado para validação dos dados recebidos pela API.

### Spring Boot Test

Será utilizado para os testes automatizados do backend.

---

# 🗄️ Banco de dados

O banco utilizado atualmente é:

```text
SQLite
```

Arquivo:

```text
backend/data/devvault.db
```

A configuração está em:

```text
backend/src/main/resources/application.properties
```

Atualmente o backend utiliza:

```properties
spring.datasource.url=jdbc:sqlite:./data/devvault.db
```

O Hibernate também está configurado para atualizar a estrutura do banco automaticamente:

```properties
spring.jpa.hibernate.ddl-auto=update
```

Isso permite que as tabelas sejam criadas/atualizadas conforme as entidades do sistema.

---

# 📊 Entidades atuais

## Project

Representa um projeto de desenvolvimento.

Um projeto possui informações como:

- nome
- descrição
- status
- data de criação
- data de atualização

### Status disponíveis

```text
PLANNED
IN_PROGRESS
COMPLETED
```

---

## Task

Representa uma tarefa pertencente a um projeto.

Uma tarefa possui informações como:

- título
- descrição
- status
- prioridade
- projeto relacionado
- datas de criação/atualização

### Status disponíveis

```text
TODO
IN_PROGRESS
DONE
```

### Prioridades

```text
LOW
MEDIUM
HIGH
```

---

# 🧩 Camadas do Backend

O backend está dividido em responsabilidades.

## Controller

Responsável pelos endpoints HTTP.

```text
controller/
```

Atualmente existem controllers para:

- projetos
- tarefas
- dashboard
- tratamento de exceções

---

## DTO

Responsável pelos objetos utilizados na comunicação da API.

```text
dto/
```

Existem DTOs para:

- criação de projetos
- criação de tarefas
- resposta de projetos
- resposta de tarefas
- dashboard

---

## Entity

Representa as entidades persistidas no banco.

```text
entity/
```

Atualmente:

```text
Project
Task
```

---

## Repository

Responsável pelo acesso aos dados.

```text
repository/
```

Atualmente:

```text
ProjectRepository
TaskRepository
```

---

## Service

Responsável pela lógica de negócio.

```text
service/
```

Atualmente:

```text
ProjectService
TaskService
DashboardService
```

---

# 🌐 API REST

O backend fornece endpoints para comunicação com o frontend.

## Projetos

Endpoint principal:

```text
/api/projects
```

Operações planejadas/implementadas:

```text
GET    /api/projects
POST   /api/projects
GET    /api/projects/{id}
PUT    /api/projects/{id}
DELETE /api/projects/{id}
```

---

# 📝 Tarefas

Endpoint:

```text
/api/tasks
```

Operações:

```text
GET
POST
PUT
DELETE
```

As tarefas são relacionadas aos projetos.

---

# 📈 Dashboard

Endpoint:

```text
/api/dashboard
```

O dashboard fornece informações agregadas da aplicação.

A ideia é utilizar esses dados para mostrar informações como:

```text
Total de projetos
Projetos em andamento
Projetos concluídos
Total de tarefas
Tarefas pendentes
Tarefas concluídas
```

---

# ⚛️ Frontend

O frontend foi desenvolvido utilizando:

```text
React
Vite
JavaScript
CSS
```

Localização:

```text
frontend/
```

A aplicação atualmente possui um dashboard inicial para gerenciamento dos projetos e tarefas.

---

# 🔌 Comunicação Frontend → Backend

O frontend utiliza a API REST do Spring Boot.

Atualmente o backend está configurado na porta:

```text
8081
```

Portanto:

```text
Frontend
http://localhost:5173

        ↓

Backend
http://localhost:8081

        ↓

SQLite
devvault.db
```

A URL utilizada pelo React deve ser:

```javascript
const API_URL = "http://localhost:8081/api";
```

---

# ✅ Funcionalidades já testadas

Durante a configuração do projeto foram realizados os seguintes testes:

### Backend

- Java identificado e funcionando.
- Maven configurado.
- Maven Wrapper configurado.
- Dependências baixadas.
- Projeto compilado.
- Spring Boot iniciado.
- Hibernate inicializado.
- SQLite inicializado.
- API disponibilizada.

### Frontend

- Node/NPM funcionando.
- Vite iniciado.
- React carregando.
- Frontend acessando a API.
- Criação de projetos funcionando.

### Banco

O SQLite está sendo utilizado para persistência local.

Isso significa que os dados não ficam apenas na memória da aplicação.

Ao reiniciar o backend, os dados permanecem no arquivo:

```text
devvault.db
```

---
