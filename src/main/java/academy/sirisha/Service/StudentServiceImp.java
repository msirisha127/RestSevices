package academy.sirisha.Service;


import academy.sirisha.Entity.Student;
import academy.sirisha.Exception.ResourceNotFoundException;
import academy.sirisha.Exception.StudentNotFoundException;
import academy.sirisha.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service


public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository repository;

@Transactional
    public List<Student> findAll() {
    return (List<Student>) repository.findAll();
    }

   @Transactional
    public Student findOne(String id) {
   Optional <Student> student= repository.findById(id);
    if(!student.isPresent()){
        throw new StudentNotFoundException("Employee with id  "+id +"    Not found");
    }
    else {
        return student.get();
    }
    }

    @Transactional
    public Student create(Student student) {
        Optional <Student> student1=repository.findByEmail(student.getEmail());
        if(student1.isPresent()){
            throw new ResourceNotFoundException("Employee with emailId  "+student.getEmail() +"  Already exists");
        }
        else{
            return repository.save(student);
        }

    }

    @Transactional
    public Student update(String id, Student student) {
      Optional  <Student> existing= repository.findById(id);
        if(!existing.isPresent()){
            throw new ResourceNotFoundException("Employee with id  "+id +"    Not found");
        }
        else {
            return repository.save(student);
        }
    }

    @Transactional
    public void delete(String id) {
        Optional  <Student> existing= repository.findById(id);

        if(!existing.isPresent()){
            throw new ResourceNotFoundException("Employee with id  "+id +"    Not found");
        }
        else {
            repository.delete(existing.get());
        }
    }
}
