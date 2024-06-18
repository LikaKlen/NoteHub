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
public class UserDetailsServiceImpl implements UserDetailsService {
        private final DataAccessLayer dataAccessLayer;

    @Autowired
    public UserDetailsServiceImpl(DataAccessLayer dataAccessLayer) {
            this.dataAccessLayer = dataAccessLayer;
        }

        public String newTeacher(SignupRequest signupRequest) {
            Teacher teacher = new Teacher();

            teacher.setTeacherId(signupRequest.getTeacherId());
            teacher.setFirstName(signupRequest.getFirstName());

            teacher.setLastName(signupRequest.getLastName());

            teacher.setPatronymic(signupRequest.getPatronymic());
            teacher.setEmail(signupRequest.getEmail());

            teacher.setPhoneNumber(signupRequest.getPhoneNumber());
            teacher.setPhoneNumber(signupRequest.getPhoneNumber());

            teacher.setPassword(signupRequest.getPassword());

            return dataAccessLayer.newUserToDatabase(teacher);
        }
        @Override
        public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
            Teacher teacher = dataAccessLayer.getUserFromDatabaseByUsername(userName);
            if (teacher == null) return null;
            return UserDetailsImpl.build(teacher);
        }
        public Teacher loadUserEntityByUsername(String Email) throws UsernameNotFoundException {
            return dataAccessLayer.getUserFromDatabaseByUsername(userName);
        }
}
