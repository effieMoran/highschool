package com.effie.Repository;

import com.effie.model.Student;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by effie on 11/21/15.
 */
@Repository
public class StudentRepository {
    private Map<Integer, Student> students = new HashMap<Integer, Student>();

    @PostConstruct
    public void setup(){
        students.put(1, new Student("Effie","Moran","TSP"));
        students.put(2, new Student("Miguel","Vargas","ISI"));
        students.put(3, new Student("Agustin","Olivello","IQ"));
    }

    public List<Student> findAll(){
        return new ArrayList<Student>(students.values());
    }

    public Student find(int id){
        return students.get(id);
    }

    public void update(int id, Student student){
        students.put(id, student);
    }

    public void delete(int id){
        students.remove(id);
    }

    public void save(Student student){students.put(student.getFileNumber(), student);
    }
}
