package org.gs.Services;

import org.gs.entity.Person;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class PersonService {

    public List<Person> getPerson() {
        return Person.listAll();
    }

    @Transactional
    public Person addPerson(Person newPerson){
        newPerson.persist();
        return newPerson;
    }

    @Transactional
    public String deletePerson(Long id){
        Person.deleteById(id);
        return "ok";
    }
}
