package com.example.APITesting.EntityDefinition;

import com.example.APITesting.Aspect.Loggable;
import com.example.APITesting.EntityDefinition.StudentEntity;
import com.example.APITesting.EntityDefinition.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class APIInit {

    private final StudentRepository repository;
   // static Logger LOGGER = LoggerFactory.getLogger(APIInit.class);

    APIInit(StudentRepository repository)
    {
        this.repository = repository;
    }
    @Loggable
    @GetMapping("/student")
    List<StudentEntity> getAllStudentData()
    {

        //return repository.findAll().toString();
        return repository.findAll();
    }

    //gets the record of a student of specific id
    @GetMapping("/student/{id}")
    StudentEntity getStudentData(@PathVariable long id)
    {

        if(repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            return null;
    }

    //deletes all records
    @DeleteMapping("/student")
    String deleteAll()
    {

        return "delete all student";
    }

    //delete a certain record
    @DeleteMapping("/student/{id}")
    String deleteOne(@PathVariable long id)
    {

        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return "deleting student with id " + id;
        }
        else
        {
            return "record does not exist";
        }
    }

    //adds single record
    @PostMapping("/student")
    StudentEntity addNewStudent(@RequestBody StudentEntity requestBody)
    {
       System.out.println(requestBody.getId());
       System.out.println(requestBody.getName());
       System.out.println(requestBody.getBranch());
        return repository.save(new StudentEntity(requestBody.getName(),requestBody.getBranch()));
    }

    //change data about a present record
    @PutMapping("/student/{id}")
    StudentEntity updateStudentRecord(@PathVariable long id, @RequestBody StudentEntity requestBody)
    {
         repository.findById(id).map(
                 employee->{
                     employee.setName(requestBody.getName());
                     employee.setBranch(requestBody.getBranch());
                     return repository.save(employee);
                 }
         ).orElseGet(()->{
             requestBody.setId(id);
             return repository.save(requestBody);
         });
         return requestBody;
    }



}
