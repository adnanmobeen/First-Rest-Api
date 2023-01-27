package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class StudentController {

    @Autowired
    StudentService studentservice;

    @PostMapping("/add_student")
   public ResponseEntity addStudent(@RequestBody Student student){
        String s= studentservice.add_Student(student);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @GetMapping("/get_student/{admnNo}")
    public ResponseEntity getStudent(@PathVariable("admnNo") int admnNo){
       Student student =  studentservice.get_Student(admnNo);
       return new ResponseEntity<>(student,HttpStatus.FOUND);
    }
    @PutMapping("/update_student")
    public ResponseEntity updateStudent(@RequestParam("id") int id,@RequestParam("age") int age){
        String updated =  studentservice.update_Student(id,age);
        if(updated == null) return new ResponseEntity<>("No data found",HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updated,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete_student/{admnNo}")
     public ResponseEntity deleteStudent(@PathVariable("admnNo") int admnNo){
        String deleted = studentservice.delete_Student(admnNo);
        if(deleted == null) return new ResponseEntity<>("Nothing to delete",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(deleted,HttpStatus.ACCEPTED);
     }

    @GetMapping("/get_students/{name}")
    public ResponseEntity getStudent(@PathVariable("name") String name){
       Student get = studentservice.get_Student(name);
       return new ResponseEntity<>(get,HttpStatus.FOUND);
    }
}
