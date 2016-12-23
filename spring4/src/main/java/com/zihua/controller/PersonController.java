package com.zihua.controller;

import com.google.gson.Gson;
import com.zihua.entity.Person;
import com.zihua.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zihua on 16-12-22.
 */
@Controller
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/getPersons")
    @ResponseBody
    public List<Person> getPersons() {
        return personService.getPersons();

    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/addPerson",method = RequestMethod.POST)
    public void addPerson(@Validated Person person) {
        personService.addPerson(person);
    }

    @RequestMapping(value = "/updatePerson")
    public void updatePerson(Person person) {
        personService.addPerson(person);
    }

    @RequestMapping(value = "/deletePersonById")
    public void deletePersonById(String id) {
        personService.deletePersonById(id);
    }

    @RequestMapping(value = "/getPersonById")
    @ResponseBody
    public Person getPersonById(String id){
        return personService.getPersonById(id);
    }
}
