package gothraxz.Simple.CV.creator.userManagement.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import gothraxz.Simple.CV.creator.userManagement.person.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
