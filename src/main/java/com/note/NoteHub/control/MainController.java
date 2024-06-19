package com.note.NoteHub.control;

import com.note.NoteHub.dal.DataAccessLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/unauthorized")
public class MainController {
    private final DataAccessLayer dataAccessLayer;
    @Autowired
    public MainController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }

    //Group
    @GetMapping("/get/group/{id}")
    public ResponseEntity getGroupById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getGroupById(id));
    }
    @GetMapping("get/groups")
    public ResponseEntity getGroups(){
        return ResponseEntity.ok(dataAccessLayer.getGroups());
    }
    //Parent
    @GetMapping("/get/parent/{id}")
    public ResponseEntity getParentById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getParentById(id));
    }
    @GetMapping("get/parents")
    public ResponseEntity getParents(){
        return ResponseEntity.ok(dataAccessLayer.getParents());
    }
    //Review
    @GetMapping("/get/review/{id}")
    public ResponseEntity getReviewById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getReviewById(id));
    }
    @GetMapping("get/reviews")
    public ResponseEntity getReviews(){
        return ResponseEntity.ok(dataAccessLayer.getReviews());
    }
    //Specialization
    @GetMapping("/get/specialization/{id}")
    public ResponseEntity getSpecializationById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getSpecializationById(id));
    }
    @GetMapping("get/specializations")
    public ResponseEntity getSpecializations(){
        return ResponseEntity.ok(dataAccessLayer.getSpecializations());
    }
    //Student
    @GetMapping("/get/student/{id}")
    public ResponseEntity getStudentById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getStudentById(id));
    }
    @GetMapping("get/students")
    public ResponseEntity getStudents(){
        return ResponseEntity.ok(dataAccessLayer.getStudents());
    }
    //Teacher
    @GetMapping("/get/teacher/{id}")
    public ResponseEntity getTeacherById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getTeacherById(id));
    }
    @GetMapping("get/teachers")
    public ResponseEntity getTeachers(){
        return ResponseEntity.ok(dataAccessLayer.getTeachers());
    }

}
