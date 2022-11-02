package ru.zubarev.springcourse.FirstSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.zubarev.springcourse.FirstSecurityApp.models.Person;
import ru.zubarev.springcourse.FirstSecurityApp.repositories.PersonRepository;
import ru.zubarev.springcourse.FirstSecurityApp.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Optional<Person> foundedPerson= personRepository.findByUsername(username);
     if (foundedPerson.isEmpty())
         throw new UsernameNotFoundException("User not found");
     else return new PersonDetails(foundedPerson.get());
    }
}
