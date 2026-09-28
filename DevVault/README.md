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

# ⚠️ Configuração importante

A porta `8080` estava ocupada pelo Apache do XAMPP.

O processo identificado foi:

```text
httpd.exe
```

Por isso o backend foi configurado para utilizar:

```text
8081
```

Configuração atual:

```properties
server.port=8081
```

Não é necessário desligar o Apache do XAMPP para executar o DevVault.

---

# ▶️ Como executar

## 1. Backend

Abra um terminal:

```powershell
cd C: \DevVault\backend
```

Execute:

```powershell
.\mvnw.cmd spring-boot:run
```

O backend deverá ficar disponível em:

```text
http://localhost:8081
```

Mantenha esse terminal aberto.

---

# 2. Frontend

Abra outro terminal:

```powershell
cd C:\DevVault\frontend
```

Caso seja a primeira execução:

```powershell
npm install
```

Depois:

```powershell
npm run dev
```

O Vite deverá disponibilizar o frontend em:

```text
http://localhost:5173
```

---

# 🧪 Teste rápido

Depois de iniciar os dois servidores:

### Frontend

Acesse:

```text
http://localhost:5173
```

### Backend

A API deverá responder através de:

```text
http://localhost:8081/api
```

### Fluxo esperado

```text
Usuário
   ↓
React
   ↓
Fetch
   ↓
Spring Boot
   ↓
Service
   ↓
Repository
   ↓
SQLite
```

---

# 🛠️ Roadmap

## Fase 1 — Estrutura inicial

**Status: concluída**

- [x] Criar estrutura do projeto
- [x] Configurar Java 21
- [x] Configurar Spring Boot
- [x] Configurar Maven
- [x] Configurar SQLite
- [x] Configurar JPA/Hibernate
- [x] Criar entidades
- [x] Criar repositories
- [x] Criar services
- [x] Criar controllers
- [x] Criar DTOs
- [x] Criar frontend React
- [x] Conectar frontend ao backend

---

# Fase 2 — CRUD completo

**Status: parcialmente concluída**

### Projetos

- [x] Criar projeto
- [x] Listar projetos
- [x] Persistir projetos
- [ ] Editar projeto
- [ ] Excluir projeto
- [ ] Página individual do projeto

### Tarefas

- [x] Estrutura de tarefas
- [x] Criar tarefa
- [x] Listar tarefas
- [x] Excluir tarefa
- [ ] Editar tarefa
- [ ] Alterar status diretamente pela interface
- [ ] Alterar prioridade pela interface

---

# Fase 3 — Dashboard

**Status: parcialmente concluída**

Implementar uma dashboard mais completa.

### Indicadores

- [ ] Total de projetos
- [ ] Projetos planejados
- [ ] Projetos em andamento
- [ ] Projetos concluídos
- [ ] Total de tarefas
- [ ] Tarefas pendentes
- [ ] Tarefas em andamento
- [ ] Tarefas concluídas

### Visualizações

- [ ] Gráficos
- [ ] Progresso dos projetos
- [ ] Distribuição de tarefas
- [ ] Atividade recente

---

# Fase 4 — Tecnologias

Adicionar tecnologias utilizadas nos projetos.

Exemplos:

```text
Java
Spring Boot
React
JavaScript
Python
Node.js
MySQL
SQLite
Docker
Git
```

Cada projeto poderá possuir várias tecnologias.

Exemplo:

```text
DevVault

Java
Spring Boot
React
SQLite
Maven
```

---

# Fase 5 — Autenticação

Adicionar sistema de usuários.

### Cadastro

- [ ] Criar usuário
- [ ] Nome
- [ ] Email
- [ ] Senha
- [ ] Validação

### Login

- [ ] Login
- [ ] Logout
- [ ] JWT
- [ ] Proteção das rotas
- [ ] Expiração do token

### Segurança

- [ ] Hash de senhas
- [ ] Spring Security
- [ ] Autorização
- [ ] Validação de requisições

---

# Fase 6 — Perfil

Criar uma área de perfil do desenvolvedor.

Informações possíveis:

```text
Nome
Username
Email
Bio
GitHub
LinkedIn
Website
```

Também poderá apresentar:

```text
Projetos
Tecnologias
Tarefas concluídas
Projetos concluídos
```

---

# Fase 7 — Diário de desenvolvimento

Adicionar um sistema de registros.

A ideia é permitir que o desenvolvedor registre:

```text
Data
Título
Descrição
Projeto
```

Exemplo:

```text
28/09/2026

Integração SQLite

Configurei o SQLite e conectei o banco ao Spring Data JPA.
```

Isso transforma o DevVault em uma ferramenta não apenas de gerenciamento, mas também de acompanhamento da evolução dos projetos.

---

# Fase 8 — Pesquisa e filtros

Adicionar pesquisa e filtros.

### Projetos

Filtrar por:

```text
Nome
Status
Tecnologia
Data
```

### Tarefas

Filtrar por:

```text
Status
Prioridade
Projeto
Data
```

Adicionar também:

```text
Campo de pesquisa
Ordenação
Paginação
```

---

# Fase 9 — Melhorias de UI/UX

A interface inicial deverá evoluir para uma interface de portfólio.

Implementar:

- [ ] Design mais refinado
- [ ] Responsividade
- [ ] Animações
- [ ] Feedback visual
- [ ] Loading states
- [ ] Empty states
- [ ] Mensagens de sucesso
- [ ] Mensagens de erro
- [ ] Modais
- [ ] Confirmação antes de exclusões
- [ ] Componentização do React

---

# Fase 10 — Validação e tratamento de erros

Backend:

- [ ] Validar requests
- [ ] Validar campos obrigatórios
- [ ] Retornar HTTP 400 corretamente
- [ ] Retornar HTTP 404 corretamente
- [ ] Tratamento global de exceções
- [ ] Mensagens de erro padronizadas

Frontend:

- [ ] Mostrar erros da API
- [ ] Mostrar mensagens de sucesso
- [ ] Impedir envio de formulários inválidos
- [ ] Loading durante requisições
- [ ] Tratamento de falha de conexão

---

# Fase 11 — Testes

Criar testes automatizados.

### Backend

- [ ] Testes dos services
- [ ] Testes dos controllers
- [ ] Testes dos repositories
- [ ] Testes de integração

### Frontend

- [ ] Testes dos componentes
- [ ] Testes de interação
- [ ] Testes das chamadas da API

---

# Fase 12 — Documentação da API

Adicionar:

```text
Swagger / OpenAPI
```

Documentar:

- endpoints
- parâmetros
- requests
- responses
- códigos HTTP
- autenticação

A API deverá permitir que outro desenvolvedor consiga entender e testar o backend sem precisar analisar o código-fonte.

---

# Fase 13 — Docker

Docker poderá ser adicionado posteriormente como opção.

A ideia não é tornar Docker obrigatório para executar o projeto.

O projeto continuará podendo ser executado localmente com:

```text
Java
Maven
Node
NPM
```

Docker será uma alternativa para facilitar ambientes padronizados.

---

# Fase 14 — Preparação para portfólio

Antes da versão final:

- [ ] Revisar código
- [ ] Remover código desnecessário
- [ ] Padronizar nomes
- [ ] Melhorar arquitetura
- [ ] Adicionar testes
- [ ] Adicionar Swagger
- [ ] Criar screenshots
- [ ] Criar GIF/demo
- [ ] Melhorar README
- [ ] Adicionar seção de arquitetura
- [ ] Adicionar tecnologias
- [ ] Adicionar instruções de instalação
- [ ] Adicionar exemplos da API
- [ ] Criar versão final da interface
- [ ] Fazer deploy

---

# 🧰 Tecnologias

## Backend

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?style=for-the-badge&logo=springboot)

![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven)

![SQLite](https://img.shields.io/badge/SQLite-003B57?style=for-the-badge&logo=sqlite)

## Frontend

![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react)

![Vite](https://img.shields.io/badge/Vite-646CFF?style=for-the-badge&logo=vite)

![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript)

![CSS](https://img.shields.io/badge/CSS-1572B6?style=for-the-badge&logo=css3)

---

# 📚 Conceitos demonstrados

O projeto pretende demonstrar conhecimentos em:

- Programação Orientada a Objetos
- Java
- Spring Boot
- REST API
- HTTP
- CRUD
- MVC
- DTO
- Service Layer
- Repository Pattern
- JPA
- Hibernate
- SQLite
- React
- Componentização
- JavaScript
- Comunicação entre frontend e backend
- Persistência de dados
- Validação
- Tratamento de exceções
- Autenticação
- Segurança
- Testes automatizados
- Documentação de API
- Git
- GitHub
- Docker

---

# 🔄 Fluxo de desenvolvimento

O fluxo principal da aplicação será:

```text
                    USUÁRIO
                       │
                       ▼
                  INTERFACE
                    REACT
                       │
                       ▼
                  REST API
                       │
                       ▼
               SPRING CONTROLLER
                       │
                       ▼
                  SERVICE
                       │
                       ▼
                 REPOSITORY
                       │
                       ▼
                    SQLITE
```

---

# 💾 Persistência

O DevVault utiliza SQLite justamente para manter uma infraestrutura simples.

O projeto não depende de um servidor de banco externo.

Após executar o backend, o banco fica armazenado localmente em:

```text
backend/data/devvault.db
```

Isso torna o projeto fácil de:

- clonar
- executar
- testar
- estudar
- demonstrar

---

# 🚧 Próxima etapa recomendada

Depois da implementação inicial, a evolução do DevVault deve seguir aproximadamente esta ordem:

```text
CRUD completo
      ↓
Dashboard completo
      ↓
Página de detalhes do projeto
      ↓
Tecnologias
      ↓
Pesquisa e filtros
      ↓
Autenticação
      ↓
Perfil
      ↓
Diário de desenvolvimento
      ↓
Validações
      ↓
Testes
      ↓
Swagger
      ↓
UI/UX final
      ↓
Portfólio
```

---

# 🎯 Objetivo da versão final

A versão final do DevVault deverá ser uma aplicação completa na qual um desenvolvedor consiga entrar na própria conta e administrar seu ambiente de desenvolvimento.

O sistema deverá permitir:

```text
┌───────────────────────────────────────┐
│              DEVVAULT                 │
├───────────────────────────────────────┤
│                                       │
│  Projetos                             │
│  ├── Criar                            │
│  ├── Editar                           │
│  ├── Excluir                          │
│  └── Acompanhar                       │
│                                       │
│  Tarefas                              │
│  ├── Criar                            │
│  ├── Priorizar                        │
│  ├── Alterar status                   │
│  └── Concluir                         │
│                                       │
│  Tecnologias                          │
│  └── Associar ao projeto              │
│                                       │
│  Dashboard                            │
│  └── Estatísticas                     │
│                                       │
│  Diário                                │
│  └── Registrar desenvolvimento         │
│                                       │
│  Perfil                                │
│  └── Informações do desenvolvedor     │
│                                       │
└───────────────────────────────────────┘
```

---

# 👨‍💻 Desenvolvimento

Projeto desenvolvido como aplicação de estudo e portfólio, com foco em desenvolvimento **Full Stack** utilizando Java no backend e React no frontend.

---

# 📄 Licença

Este projeto está em desenvolvimento para fins de estudo, prática e portfólio.
