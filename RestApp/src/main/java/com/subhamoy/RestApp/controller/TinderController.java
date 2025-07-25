//this is used to create  API

package com.subhamoy.RestApp.controller;

import com.subhamoy.RestApp.dto.Person;
import com.subhamoy.RestApp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TinderController {
   @Autowired
   PersonService personService;

   @GetMapping("/getPersons")
   public List<Person> getAllPerson(){
      List<Person> allPersonData = personService.getAllPersonData();
      List<Person> filterData = personService.filterDataBasedOnGen(allPersonData);
      return filterData;
   }
  @PostMapping("/create-person")
   public Person createUser(@RequestBody Person person){
      return person;
   }

   @DeleteMapping("/create-person")
   public Person deletUser(@RequestBody Person person)
   {
      return person;
   }
}
