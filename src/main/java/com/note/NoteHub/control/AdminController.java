package com.note.NoteHub.control;

import com.note.NoteHub.dal.DataAccessLayer;
import com.note.NoteHub.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@Slf4j
@RequestMapping("/authorized")
public class AdminController {
    private final DataAccessLayer dataAccessLayer;
    @Autowired
    public AdminController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }
    //Group
    @PostMapping("/new/group")
    public ResponseEntity<String> newGroup(@RequestBody Group group) {
        try {
            dataAccessLayer.createGroup(group);
            return ResponseEntity.ok("Группа была успешно создана");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка создания группы: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/group/{id}")
    public ResponseEntity deleteGroupById(@PathVariable("id") long id){
        dataAccessLayer.deleteGroupById(id);
        return ResponseEntity.ok("Группа была успешно удалена");
    }
    @PutMapping("/update/group/{id}")
    public ResponseEntity updateGroupById(@PathVariable("id") long id, @RequestBody Group updatedGroup){
        dataAccessLayer.updateGroupById(id, updatedGroup);
        return ResponseEntity.ok("Группа была успешно отредактирована");
    }
    //Parent
    @PostMapping("/new/parent")
    public ResponseEntity<String> newParent(@RequestBody Parent parent) {
        try {
            dataAccessLayer.createParent(parent);
            return ResponseEntity.ok("Родитель был успешно создан");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка создания родителя: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/parent/{id}")
    public ResponseEntity deleteParentById(@PathVariable("id") long id){
        dataAccessLayer.deleteParentById(id);
        return ResponseEntity.ok("Родитель был успешно удален");
    }
    @PutMapping("/update/parent/{id}")
    public ResponseEntity updateParentById(@PathVariable("id") long id, @RequestBody Parent updatedParent){
        dataAccessLayer.updateParentById(id, updatedParent);
        return ResponseEntity.ok("Родитель был успешно отредактирован");
    }
    //review
    @PostMapping("/new/review")
    public ResponseEntity<String> newReview(@RequestBody Review review) {
        try {
            dataAccessLayer.createReview(review);
            return ResponseEntity.ok("Отзыв был успешно создан");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка создания отзыва: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/review/{id}")
    public ResponseEntity deleteReviewById(@PathVariable("id") long id){
        dataAccessLayer.deleteReviewById(id);
        return ResponseEntity.ok("Отзыв был успешно удален");
    }
    @PutMapping("/update/review/{id}")
    public ResponseEntity updateReviewById(@PathVariable("id") long id, @RequestBody Review updatedReview){
        dataAccessLayer.updateReviewById(id, updatedReview);
        return ResponseEntity.ok("Отзыв была успешно отредактирован");
    }
    //specialization
    @PostMapping("/new/specialization")
    public ResponseEntity<String> newSpecialization(@RequestBody Specialization specialization) {
        try {
            dataAccessLayer.createSpecialization(specialization);
            return ResponseEntity.ok("Специализация была успешно создана");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка создания специализации: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/specialization/{id}")
    public ResponseEntity deleteSpecializationById(@PathVariable("id") long id){
        dataAccessLayer.deleteSpecializationById(id);
        return ResponseEntity.ok("Специализация была успешно удалена");
    }
    @PutMapping("/update/specialization/{id}")
    public ResponseEntity updateSpecializationById(@PathVariable("id") long id, @RequestBody Specialization updatedSpecialization){
        dataAccessLayer.updateSpecializationById(id, updatedSpecialization);
        return ResponseEntity.ok("Специализация была успешно отредактирована");
    }
    //student
    @PostMapping("/new/student")
    public ResponseEntity<String> newStudent(@RequestBody Student student) {
        try {
            dataAccessLayer.createStudent(student);
            return ResponseEntity.ok("Студент был успешно создан");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка создания студента: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/student/{id}")
    public ResponseEntity deleteStudentById(@PathVariable("id") long id){
        dataAccessLayer.deleteStudentById(id);
        return ResponseEntity.ok("Студент был успешно удален");
    }
    @PutMapping("/update/student/{id}")
    public ResponseEntity updateStudentById(@PathVariable("id") long id, @RequestBody Student updatedStudent){
        dataAccessLayer.updateStudentById(id, updatedStudent);
        return ResponseEntity.ok("Студент был успешно отредактирован");
    }
    //teacher
    @PostMapping("/new/teacher")
    public ResponseEntity<String> newTeacher(@RequestBody Teacher teacher) {
        try {
            dataAccessLayer.newTeacherToDatabase(teacher);
            return ResponseEntity.ok("Преподаватель был успешно создан");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка создания реподавателя: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/teacher/{id}")
    public ResponseEntity deleteTeacherById(@PathVariable("id") long id){
        dataAccessLayer.deleteTeacherById(id);
        return ResponseEntity.ok("Преподаватель был успешно удален");
    }
    @PutMapping("/update/teacher/{id}")
    public ResponseEntity updateTeacherById(@PathVariable("id") long id, @RequestBody Teacher updatedTeacher){
        dataAccessLayer.updateTeacherById(id, updatedTeacher);
        return ResponseEntity.ok("Преподаватель был успешно отредактирован");
    }
}
