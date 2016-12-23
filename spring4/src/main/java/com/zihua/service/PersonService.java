package com.zihua.service;

import com.zihua.dao.PersonDao;
import com.zihua.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zihua on 16-12-22.
 */

@Service
public class PersonService {

    @Autowired private PersonDao personDao;
    public List<Person> getPersons(){
        return personDao.getPersons();

    }

    public void addPerson(Person person){
        personDao.addPerson(person);
    }

    public void updatePerson(Person person){
        personDao.updatePerson(person);
    }


    public void deletePersonById(String id) {
        personDao.deletePersonById(id);

    }

    public Person getPersonById(String id) {
        return personDao.getPersonById(id);
    }
}
