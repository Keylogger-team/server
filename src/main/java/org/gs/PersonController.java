package org.gs;

import org.gs.Services.PersonService;
import org.gs.entity.Person;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {

    @Inject
    PersonService personService;

    @GET
    public List<Person> getAll() {
        return personService.getPerson();
    }

    @POST
    public Person addPerson(Person newPerson){
        return personService.addPerson(newPerson);
    }

    @Path("/{id}")
    @DELETE
    public String deleteType(Long id){
        return personService.deletePerson(id);
    }
}
