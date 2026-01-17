package com.subhamoy.RestApp.service;

import com.subhamoy.RestApp.dto.Person;

import java.util.List;

public interface PersonService {
   List<Person> getAllPersonData();

   List<Person> filterDataBasedOnGen(List<Person> personList);
}
