package academy.sirisha.Service;


import academy.sirisha.Entity.Student;



import java.util.List;

public interface StudentService {
     List<Student> findAll();


     Student findOne(String id);

     Student create( Student student);

     Student update( String id,Student student);

     void delete(String id);
}
