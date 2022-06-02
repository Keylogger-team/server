package org.gs;

import org.gs.Services.TaskService;
import org.gs.entity.Task;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/clients/toDoList")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class TaskController {
    @Inject TaskService taskService;

    @GET
    public List<Task> getListTask(@QueryParam("person") Long id){
        return taskService.getListTask(id);
    }

    @POST
    public Task addTask(@Valid Task newTask){
        return taskService.addTask(newTask);
    }

    @DELETE
    public Response deleteTask(@QueryParam("person") Long person){
        return taskService.deleteTask(person);
    }

}
