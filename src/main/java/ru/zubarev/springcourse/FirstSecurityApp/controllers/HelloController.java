package ru.zubarev.springcourse.FirstSecurityApp.controllers;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.zubarev.springcourse.FirstSecurityApp.models.Person;
import ru.zubarev.springcourse.FirstSecurityApp.security.PersonDetails;

@Controller
@RequestMapping()
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(){
      return "hello";
    }
@GetMapping("/showuserinfo")
public String showUserInfo(){
Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
   PersonDetails personDetails=(PersonDetails)authentication.getPrincipal();
    System.out.println(personDetails.getPerson());
    return "/hello";
}
}
