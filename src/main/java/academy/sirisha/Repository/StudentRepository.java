package academy.sirisha.Repository;


import academy.sirisha.Entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student,String>{


    Optional <Student> findByEmail(String email);
}
