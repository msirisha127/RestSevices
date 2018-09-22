package academy.sirisha.Service;


import academy.sirisha.Entity.Student;
import academy.sirisha.Exception.ResourceNotFoundException;
import academy.sirisha.Exception.StudentNotFoundException;
import academy.sirisha.Repository.StudentRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class StudentServiceImpTest {

    @Autowired
    StudentService servicek;
    @MockBean
    private StudentRepository repository;

    @TestConfiguration
    static class StudentServiceImpTestConfig{
        @Bean
        public StudentService getService(){
            return  new StudentServiceImp();
        }
    }
    private List<Student> stu;
    @Before
   public void setup(){
        Student s=new Student();
        s.setId("siri-id");
        s.setName("siri");
        s.setBranch("CSE");
        s.setEmail("siri.gmail.com");
        stu= Collections.singletonList(s);


        Mockito.when(repository.findAll()).
                thenReturn(stu);
        Mockito.when(repository.findById(s.getId()))
                .thenReturn(Optional.of(s));
        Mockito.when(repository.save(s1)).thenReturn(s1);
    }
    @After
    public void cleanup(){

    }



    @Test
    public void findAll() throws Exception {
        List<Student> student=servicek.findAll();
        Assert.assertEquals("Student list should match",stu,student);
    }

    @Test
    public void findOne() throws Exception {
        Student student=servicek.findOne(stu.get(0).getId());
        Assert.assertEquals("student should match",stu.get(0),student);
    }
    @Test(expected = StudentNotFoundException.class)
    public void findOneNotFound() throws Exception {
        Student student=servicek.findOne("abcdef");

    }

    Student s1=new Student();
    @Test
    public void create() throws Exception {

        s1.setId("avi-id");
        s1.setName("Avi");
        s1.setBranch("CSE");
        s1.setEmail("avi@gmail.com");
        Student student=servicek.create(s1);
        Assert.assertEquals("Create student",s1,student);
        System.out.println(student);

    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}