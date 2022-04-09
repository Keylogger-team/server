package org.gs.Services;

import org.gs.entity.Person;
import org.gs.exceptions.KeyloggerException;

import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.gs.config.Values.*;

@Singleton
public class PersonService {

    public List<Person> getPerson() {
        return Person.listAll();
    }

    @Transactional
    public Person addPerson(Person newPerson){
        try {
            Person temp = Person.find("mail", newPerson.getMail()).firstResult();
            if (temp == null)
                newPerson.persistAndFlush();
            else throw new KeyloggerException(MESSAGE_EMAIL);
        }catch (PersistenceException e){
            throw e;
        }
        return newPerson;
    }

    @Transactional
    public Response deletePerson(Long id){
        try {
            Person.delete("id", id);
        }catch (PersistenceException e) {
            if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                throw new KeyloggerException(e.getCause().getCause().getMessage());
            }
            throw e;
        }
        return Response.status(Response.Status.OK).build();
    }
}
