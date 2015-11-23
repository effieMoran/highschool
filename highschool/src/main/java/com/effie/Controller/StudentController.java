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
    @RequestMapping(value = "/students/{id}/firstname/{firstname}", method= RequestMethod.PUT)
    public void saveFirstName(@PathVariable int id,@PathVariable String firstname) {
        Student student = studentRepository.find(id);
        student.setFirstname(firstname);
        studentRepository.save(student);
    }

    //Update last name
    @RequestMapping(value = "/students/{id}/lastname/{lastname}", method= RequestMethod.PUT)
    public void saveLastname(@PathVariable int id, @PathVariable String lastname) {
        Student student = studentRepository.find(id);
        student.setFirstname(lastname);
        studentRepository.save(student);
    }

    //Update career
    @RequestMapping(value = "/students/{id}/career/{career}", method= RequestMethod.PUT)
    public void saveCareer(@PathVariable int id, @PathVariable String career) {
        Student student = studentRepository.find(id);
        student.setFirstname(career);
        studentRepository.save(student);
    }

    //Update subject

    //See only subjects
    @RequestMapping(value = "/students/{id}/subjects", method= RequestMethod.GET)
    public int getSubjects(@PathVariable("id") int id) {
        Student student = studentRepository.find(id);
        if (student == null) {
            throw new RestException(1, "User not found!", "User with id: " + id + " not found in the system");
        }
        return student.getSubjectsApproved();
    }

    //See only first name
    @RequestMapping(value = "/students/{id}/firstname", method= RequestMethod.GET)
    public String getFirstName(@PathVariable("id") int id) {
        Student student = studentRepository.find(id);
        if (student == null) {
            throw new RestException(1, "User not found!", "User with id: " + id + " not found in the system");
        }
        return student.getFirstname();
    }
    //See only last name
    @RequestMapping(value = "/students/{id}/lastname", method= RequestMethod.GET)
    public String getLastName(@PathVariable("id") int id) {
        Student student = studentRepository.find(id);
        if (student == null) {
            throw new RestException(1, "User not found!", "User with id: " + id + " not found in the system");
        }
        return student.getLastname();
    }

    //See only career
    @RequestMapping(value = "/students/{id}/carrer", method= RequestMethod.GET)
    public String getCareer(@PathVariable("id") int id) {
        Student student = studentRepository.find(id);
        if (student == null) {
            throw new RestException(1, "User not found!", "User with id: " + id + " not found in the system");
        }
        return student.getCareer();
    }

}
