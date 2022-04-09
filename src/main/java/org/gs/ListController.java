package org.gs;

import org.gs.Services.ListService;
import org.gs.entity.ListNote;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/clients/list")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ListController {
    @Inject
    ListService listService;

    @GET
    public List<ListNote> getLists(@QueryParam("person") Long id) {
        return listService.getListNotes(id);
    }

    @POST
    public ListNote addList(@Valid ListNote note){
        return listService.addNote(note);
    }

    @Path("/{id}")
    @DELETE
    public Response deleteList(Long id){
        return listService.deleteNote(id);
    }
}
