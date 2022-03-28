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

    public String getPersonByMail(String mail){
        Person temp = Person.find("mail", mail).firstResult();
        if(temp != null){
            return "Error";
        } else return "ok";
    }

    @Transactional
    public Person addPerson(Person newPerson){
        String response = getPersonByMail(newPerson.getMail());
        if(response == "ok") {
            newPerson.persist();
            return newPerson;
        }else return null;
    }

    @Transactional
    public String deletePerson(Long id){
        Person.deleteById(id);
        return "ok";
    }
}
