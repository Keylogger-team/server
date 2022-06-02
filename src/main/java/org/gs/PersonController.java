package org.gs;

import org.gs.Services.PersonService;
import org.gs.entity.Person;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
@Consumes("application/json")
public class PersonController {

    @Inject
    PersonService personService;

    @GET
    public List<Person> getAll() {
        return personService.getPerson();
    }

    @POST
    public Person addPerson(@Valid Person newPerson){
        return personService.addPerson(newPerson);
    }

    @Path("/{id}")
    @DELETE
    public Response deletePerson(Long id){
        return personService.deletePerson(id);
    }
}
