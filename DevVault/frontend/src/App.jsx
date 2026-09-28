import { useEffect, useState } from "react";

const API = "http://localhost:8081/api";

const emptyProject = {
  name: "",
  description: "",
  status: "PLANNED",
  githubUrl: "",
  demoUrl: "",
};

const emptyTask = {
  title: "",
  description: "",
  priority: "MEDIUM",
  status: "TODO",
  dueDate: "",
};

function App() {
  const [dashboard, setDashboard] = useState(null);
  const [projects, setProjects] = useState([]);
  const [selected, setSelected] = useState(null);
  const [tasks, setTasks] = useState([]);
  const [projectForm, setProjectForm] = useState(emptyProject);
  const [taskForm, setTaskForm] = useState(emptyTask);
  const [message, setMessage] = useState("");

  async function loadDashboard() {
    const response = await fetch(`${API}/dashboard`);
    setDashboard(await response.json());
  }

  async function loadProjects() {
    const response = await fetch(`${API}/projects`);
    setProjects(await response.json());
  }

  async function selectProject(project) {
    setSelected(project);
    const response = await fetch(`${API}/projects/${project.id}/tasks`);
    setTasks(await response.json());
  }

  useEffect(() => {
    loadDashboard();
    loadProjects();
  }, []);

  async function createProject(event) {
    event.preventDefault();

    const response = await fetch(`${API}/projects`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(projectForm),
    });

    if (!response.ok) {
      setMessage("Não foi possível criar o projeto.");
      return;
    }

    setProjectForm(emptyProject);
    setMessage("Projeto criado.");
    await loadProjects();
    await loadDashboard();
  }

  async function deleteProject(id) {
    await fetch(`${API}/projects/${id}`, { method: "DELETE" });
    if (selected?.id === id) {
      setSelected(null);
      setTasks([]);
    }
    await loadProjects();
    await loadDashboard();
  }

  async function createTask(event) {
    event.preventDefault();
    if (!selected) return;

    const response = await fetch(`${API}/projects/${selected.id}/tasks`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(taskForm),
    });

    if (!response.ok) {
      setMessage("Não foi possível criar a tarefa.");
      return;
    }

    setTaskForm(emptyTask);
    setMessage("Tarefa criada.");
    await selectProject(selected);
    await loadProjects();
    await loadDashboard();
  }

  async function deleteTask(id) {
    await fetch(`${API}/tasks/${id}`, { method: "DELETE" });
    await selectProject(selected);
    await loadProjects();
    await loadDashboard();
  }

  return (
    <main className="app">
      <header className="header">
        <div>
          <span className="eyebrow">DEVELOPER WORKSPACE</span>
          <h1>DevVault</h1>
          <p>Seus projetos, tarefas e progresso em um só lugar.</p>
        </div>
      </header>

      {message && <div className="message">{message}</div>}

      {dashboard && (
        <section className="stats">
          <Stat title="Projetos" value={dashboard.totalProjects} />
          <Stat
            title="Em desenvolvimento"
            value={dashboard.inProgressProjects}
          />
          <Stat title="Concluídos" value={dashboard.completedProjects} />
          <Stat title="Tarefas pendentes" value={dashboard.todoTasks} />
        </section>
      )}

      <section className="layout">
        <div className="panel">
          <div className="panel-header">
            <div>
              <span className="eyebrow">PROJETOS</span>
              <h2>Meus projetos</h2>
            </div>
          </div>

          <div className="project-list">
            {projects.length === 0 && (
              <p className="muted">Nenhum projeto criado ainda.</p>
            )}

            {projects.map((project) => (
              <article
                key={project.id}
                className={`project ${selected?.id === project.id ? "active" : ""}`}
                onClick={() => selectProject(project)}
              >
                <div>
                  <h3>{project.name}</h3>
                  <p>{project.description || "Sem descrição."}</p>
                </div>

                <div className="project-footer">
                  <span className={`badge ${project.status.toLowerCase()}`}>
                    {statusLabel(project.status)}
                  </span>
                  <span>{project.taskCount} tarefas</span>
                  <button
                    className="danger"
                    onClick={(event) => {
                      event.stopPropagation();
                      deleteProject(project.id);
                    }}
                  >
                    Excluir
                  </button>
                </div>
              </article>
            ))}
          </div>
        </div>

        <aside className="panel form-panel">
          <span className="eyebrow">NOVO PROJETO</span>
          <h2>Criar projeto</h2>

          <form onSubmit={createProject}>
            <input
              placeholder="Nome do projeto"
              value={projectForm.name}
              onChange={(e) =>
                setProjectForm({ ...projectForm, name: e.target.value })
              }
              required
            />

            <textarea
              placeholder="Descrição"
              value={projectForm.description}
              onChange={(e) =>
                setProjectForm({ ...projectForm, description: e.target.value })
              }
            />

            <select
              value={projectForm.status}
              onChange={(e) =>
                setProjectForm({ ...projectForm, status: e.target.value })
              }
            >
              <option value="PLANNED">Planejado</option>
              <option value="IN_PROGRESS">Em desenvolvimento</option>
              <option value="COMPLETED">Concluído</option>
            </select>

            <input
              placeholder="URL do GitHub"
              value={projectForm.githubUrl}
              onChange={(e) =>
                setProjectForm({ ...projectForm, githubUrl: e.target.value })
              }
            />

            <input
              placeholder="URL da demonstração"
              value={projectForm.demoUrl}
              onChange={(e) =>
                setProjectForm({ ...projectForm, demoUrl: e.target.value })
              }
            />

            <button className="primary">Criar projeto</button>
          </form>
        </aside>
      </section>

      {selected && (
        <section className="panel tasks-panel">
          <div className="panel-header">
            <div>
              <span className="eyebrow">PROJETO SELECIONADO</span>
              <h2>{selected.name}</h2>
            </div>
          </div>

          <div className="tasks-layout">
            <div className="task-list">
              {tasks.length === 0 && (
                <p className="muted">Nenhuma tarefa neste projeto.</p>
              )}

              {tasks.map((task) => (
                <article className="task" key={task.id}>
                  <div>
                    <h3>{task.title}</h3>
                    <p>{task.description || "Sem descrição."}</p>
                  </div>
                  <div className="task-footer">
                    <span className="badge">
                      {priorityLabel(task.priority)}
                    </span>
                    <span>{statusLabel(task.status)}</span>
                    <button
                      className="danger"
                      onClick={() => deleteTask(task.id)}
                    >
                      Excluir
                    </button>
                  </div>
                </article>
              ))}
            </div>

            <form className="task-form" onSubmit={createTask}>
              <h3>Nova tarefa</h3>

              <input
                placeholder="Título"
                value={taskForm.title}
                onChange={(e) =>
                  setTaskForm({ ...taskForm, title: e.target.value })
                }
                required
              />

              <textarea
                placeholder="Descrição"
                value={taskForm.description}
                onChange={(e) =>
                  setTaskForm({ ...taskForm, description: e.target.value })
                }
              />

              <select
                value={taskForm.priority}
                onChange={(e) =>
                  setTaskForm({ ...taskForm, priority: e.target.value })
                }
              >
                <option value="LOW">Baixa</option>
                <option value="MEDIUM">Média</option>
                <option value="HIGH">Alta</option>
              </select>

              <select
                value={taskForm.status}
                onChange={(e) =>
                  setTaskForm({ ...taskForm, status: e.target.value })
                }
              >
                <option value="TODO">A fazer</option>
                <option value="IN_PROGRESS">Em andamento</option>
                <option value="DONE">Concluída</option>
              </select>

              <input
                type="date"
                value={taskForm.dueDate}
                onChange={(e) =>
                  setTaskForm({ ...taskForm, dueDate: e.target.value })
                }
              />

              <button className="primary">Adicionar tarefa</button>
            </form>
          </div>
        </section>
      )}
    </main>
  );
}

function Stat({ title, value }) {
  return (
    <div className="stat">
      <span>{title}</span>
      <strong>{value}</strong>
    </div>
  );
}

function statusLabel(status) {
  return (
    {
      PLANNED: "Planejado",
      IN_PROGRESS: "Em andamento",
      COMPLETED: "Concluído",
      TODO: "A fazer",
      DONE: "Concluída",
    }[status] ?? status
  );
}

function priorityLabel(priority) {
  return (
    {
      LOW: "Baixa",
      MEDIUM: "Média",
      HIGH: "Alta",
    }[priority] ?? priority
  );
}

export default App;
