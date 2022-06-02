package org.gs.Services;

import org.gs.entity.Task;
import org.gs.exceptions.KeyloggerException;

import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

@Singleton
public class TaskService {

    public List<Task> getListTask(Long id){
        return id == null ? getAll() : getListTaskById(id);
    }

    private List<Task> getAll(){
        return Task.listAll();
    }

    public List<Task> getListTaskById(Long id){
        return Task.find("person_id = ?1", id).list(); //все таски пользователя
    }

    @Transactional
    public Task addTask(Task task){
        try {
            task.persistAndFlush();
        }catch (PersistenceException e){
            if(e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                throw new KeyloggerException(e.getCause().getCause().getMessage());
            }
            throw e;
        }
        return task;
    }

    @Transactional
    public Response deleteTask(Long person){
        try {
            Task.delete("person_id = ?1", person);
        }catch (PersistenceException e){
            if(e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                throw new KeyloggerException(e.getCause().getCause().getMessage());
            }
            throw e;
        }
        return Response.status(Response.Status.OK).build();
    }
}
