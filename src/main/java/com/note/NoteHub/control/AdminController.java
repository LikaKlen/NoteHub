package com.note.NoteHub.control;

import com.note.NoteHub.dal.DataAccessLayer;
import com.note.NoteHub.models.Group;
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

}
