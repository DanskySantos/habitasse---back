package com.project.habitasse.security.person.repository;


import com.project.habitasse.security.person.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	Person findRoleByNome(String roleName);

	UserDetails findByEmail(String login);
}
