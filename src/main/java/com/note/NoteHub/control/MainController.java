package com.note.NoteHub.control;

import com.note.NoteHub.dal.DataAccessLayer;
import com.note.NoteHub.models.Review;
import com.note.NoteHub.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/authorized")
public class MainController {
    private final DataAccessLayer dataAccessLayer;
    @Autowired
    public MainController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }

    //Group
    @GetMapping("group/{id}")
    public ResponseEntity getGroupById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getGroupById(id));
    }
    @GetMapping("groups")
    public ResponseEntity getGroups(){
        return ResponseEntity.ok(dataAccessLayer.getGroups());
    }
    //Parent
    @GetMapping("parent/{id}")
    public ResponseEntity getParentById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getParentById(id));
    }
    @GetMapping("parents")
    public ResponseEntity getParents(){
        return ResponseEntity.ok(dataAccessLayer.getParents());
    }
    //Review
    @GetMapping("review/{id}")
    public ResponseEntity getReviewById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getReviewById(id));
    }
    @GetMapping("reviewByStudentId")
    public List<Review> getReviewByStudentId(@RequestParam Long id) {
        return dataAccessLayer.getReviewByStudentId(id);
    }

    @GetMapping("reviews")
    public ResponseEntity getReviews(){
        return ResponseEntity.ok(dataAccessLayer.getReviews());
    }
    //Specialization
    @GetMapping("specialization/{id}")
    public ResponseEntity getSpecializationById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getSpecializationById(id));
    }
    @GetMapping("specializations")
    public ResponseEntity getSpecializations(){
        return ResponseEntity.ok(dataAccessLayer.getSpecializations());
    }
    //Student
    @GetMapping("student/{id}")
    public ResponseEntity getStudentById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getStudentById(id));
    }
    @GetMapping("studentByGroupId")
    public List<Student> getStudentByGroupId(@RequestParam Long id) {
        return dataAccessLayer.getStudentByGroupId(id);
    }
    @GetMapping("studentBySpecializationId")
    public List<Student> getStudentBySpecializationId(@RequestParam Long id) {
        return dataAccessLayer.getStudentBySpecializationId(id);
    }
    @GetMapping("students")
    public ResponseEntity getStudents(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String group
    ) {
        List<Student> students = dataAccessLayer.getStudents();

        if (firstName != null && !firstName.isEmpty()) {
            students = students.stream()
                    .filter(student -> student.getFirstName().toLowerCase().contains(firstName.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (lastName != null && !lastName.isEmpty()) {
            students = students.stream()
                    .filter(student -> student.getLastName().toLowerCase().contains(lastName.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (group != null && !group.isEmpty()) {
            students = students.stream()
                    .filter(student -> student.getGroup().getGroupName().toLowerCase().contains(group.toLowerCase()))
                    .collect(Collectors.toList());
        }

        return ResponseEntity.ok(students);
    }

    //Teacher
    @GetMapping("teacher/{id}")
    public ResponseEntity getTeacherById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getTeacherById(id));
    }
    @GetMapping("teachers")
    public ResponseEntity getTeachers(){
        return ResponseEntity.ok(dataAccessLayer.getTeachers());
    }

}
