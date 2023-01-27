package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
    @Autowired
    StudentRepository studentrepository;
    public String add_Student(Student student){
        return studentrepository.addStudent(student);
    }
    public Student get_Student(int admnNo){
       return studentrepository.getStudent(admnNo);
    }
    public String update_Student(int id, int age){
       return studentrepository.updateStudent(id,age);
    }
    public String delete_Student(int admnNo){
      return studentrepository.deleteStudent(admnNo);
    }
    public Student get_Student(String name){
      return studentrepository.getStudent(name);
    }
}
