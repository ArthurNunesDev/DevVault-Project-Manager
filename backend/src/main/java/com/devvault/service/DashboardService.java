package com.devvault.service;
import com.devvault.dto.*; import com.devvault.entity.*; import com.devvault.repository.*; import org.springframework.stereotype.Service;
@Service public class DashboardService {
 private final ProjectRepository projects; private final TaskRepository tasks;
 public DashboardService(ProjectRepository p,TaskRepository t){projects=p;tasks=t;}
 public DashboardResponse get(){var ps=projects.findAll();var ts=tasks.findAll();return new DashboardResponse(ps.size(),ps.stream().filter(p->p.getStatus()==ProjectStatus.PLANNED).count(),ps.stream().filter(p->p.getStatus()==ProjectStatus.IN_PROGRESS).count(),ps.stream().filter(p->p.getStatus()==ProjectStatus.COMPLETED).count(),ts.size(),ts.stream().filter(t->t.getStatus()==TaskStatus.TODO).count(),ts.stream().filter(t->t.getStatus()==TaskStatus.IN_PROGRESS).count(),ts.stream().filter(t->t.getStatus()==TaskStatus.DONE).count());}
}
