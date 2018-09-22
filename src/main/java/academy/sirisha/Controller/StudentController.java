package academy.sirisha.Controller;

import academy.sirisha.Entity.Student;
import academy.sirisha.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value="student")
public class StudentController {
    @Autowired
    private StudentService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAll(){
    return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,value = "{id}")
    public Student findOne(@PathVariable("id") String id){
    return service.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student create(@RequestBody Student student){
        return service.create(student);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "{id}")
    public Student update(@PathVariable("id") String id,@RequestBody Student student){
        return service.update(id,student);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "{id}")
    public void delete(@PathVariable("id") String id,@RequestBody Student student){
    service.delete(id);
    }
}
