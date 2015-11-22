package com.effie.Controller;

import com.effie.Repository.StudentRepository;
import com.effie.exception.RestException;
import com.effie.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/rest")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/students", method= RequestMethod.POST)
    public void save(@RequestBody Student student){
        studentRepository.save(student);
    }

    @RequestMapping(value = "/students", method=RequestMethod.GET)
    public List<Student> list() {
        return studentRepository.findAll();
    }

    @RequestMapping(value="/students/{id}", method=RequestMethod.GET)
    public Student get(@PathVariable("id") int id) {
        Student student = studentRepository.find(id);
        if (student == null) {
            throw new RestException(1, "User not found!", "User with id: " + id + " not found in the system");
        }
        return student;
    }

    @RequestMapping(value="/students/{id}", method=RequestMethod.PUT)
    public void update(@PathVariable("id") int id, @RequestBody Student student) {
        studentRepository.update(id, student);
    }

    @RequestMapping(value="/students/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        studentRepository.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/", method= RequestMethod.POST)
    public void save(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String career) {
        Student student = new Student(firstname, lastname, career);
        studentRepository.save(student);
    }


    //Update first name
    @RequestMapping(value = "/students/", method= RequestMethod.PUT)
    public void save(@RequestParam int id,@RequestParam String firstname) {
        Student student = studentRepository.find(id);
        student.setFirstname(firstname);
        studentRepository.save(student);
    }



}
