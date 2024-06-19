package com.note.NoteHub.service;

import com.note.NoteHub.dal.DataAccessLayer;
import com.note.NoteHub.dto.SignupRequest;
import com.note.NoteHub.models.Teacher;
import com.note.NoteHub.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
    private final DataAccessLayer dataAccessLayer;

    @Autowired
    public UserDetailsServiceImpl(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }

    public String newTeacher(SignupRequest signupRequest) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(signupRequest.getFirstName());
        teacher.setLastName(signupRequest.getLastName());
        teacher.setPatronymic(signupRequest.getPatronymic());
        teacher.setPhoneNumber(signupRequest.getPhoneNumber());
        teacher.setEmail(signupRequest.getEmail());
        teacher.setPassword(signupRequest.getPassword());
        return dataAccessLayer.newTeacherToDatabase(teacher);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Teacher teacher = dataAccessLayer.getTeacherFromDatabaseByEmail(email);
        if (teacher == null) return null;
        return UserDetailsImpl.build(teacher);
    }

    public Teacher loadUserEntityByUsername(String email) throws UsernameNotFoundException {
        return dataAccessLayer.getTeacherFromDatabaseByEmail(email);
    }
}