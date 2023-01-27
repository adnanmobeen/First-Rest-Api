package com.avengers.studentManagement;

import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer,Student> db = new HashMap<>();

    public String addStudent(Student student){
        int admnNo = student.getAdmnNo();
        db.put(admnNo,student);
        return "student added successfully";
    }
    public Student getStudent(int admnNo){
        return db.get(admnNo);
    }
    public String updateStudent(int id, int age){
        if(!db.containsKey(id)) return null;
        db.get(id).setAge(age);
        return "info updated successfully";
    }
    public String deleteStudent(int admnNo){
        if(!db.containsKey(admnNo)){
            return null;
        }
        db.remove(admnNo);
        return "Student deleted successfully";
    }
    public Student getStudent(String name){
        int key=0;
        for(int a:db.keySet()){
            if(db.get(a).getName().equals(name)){
                key = a;
                break;
            }
        }
        return db.get(key);
    }
}
