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


    @GetMapping("/get/group/{id}")
    public ResponseEntity getGroupById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getGroupById(id));
    }
    @GetMapping("get/materials")
    public ResponseEntity getGroups(){
        return ResponseEntity.ok(dataAccessLayer.getGroups());
    }

}
