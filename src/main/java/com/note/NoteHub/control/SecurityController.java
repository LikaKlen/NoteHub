package com.note.NoteHub.control;

import com.note.NoteHub.NoteHubApplication;
import com.note.NoteHub.dto.SigninRequest;
import com.note.NoteHub.dto.SignupRequest;
import com.note.NoteHub.security.JwtCore;
import com.note.NoteHub.service.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:8080")
public class SecurityController {

    private final UserDetailsServiceImpl userService;

    @Autowired
    public SecurityController(UserDetailsServiceImpl userService) {
        this.userService = userService;
    }
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtCore jwtCore;

    @PostMapping("/signup")
    ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        if (signupRequest.getFirstName() == null || signupRequest.getFirstName().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Поле 'Имя' не может быть пустым");
        }
        if (signupRequest.getLastName() == null || signupRequest.getLastName().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Поле 'Фамилия' не может быть пустым");
        }
        if (signupRequest.getPatronymic() == null || signupRequest.getPatronymic().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Поле 'Отчество' не может быть пустым");
        }
        if (signupRequest.getPhoneNumber() == null || signupRequest.getPhoneNumber().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Поле 'Номер телефона' не может быть пустым");
        }
        if (signupRequest.getEmail() == null || signupRequest.getEmail().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Поле 'Почта' не может быть пустым");
        }
        if (signupRequest.getPassword() == null || signupRequest.getPassword().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Поле 'Пароль' не может быть пустым");
        }
        String serviceResult = userService.newTeacher(signupRequest);
        if (serviceResult == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка при обработке запроса");
        }
        return ResponseEntity.ok("Регистрация успешна");
    }

    @PostMapping("/signin")
    ResponseEntity<?> signin(@RequestBody SigninRequest signinRequest) {

        UserDetails teacher = userService.loadUserByUsername(signinRequest.getEmail());

        String hashedPassword = passwordEncoder.encode(signinRequest.getPassword());

//        if (!Objects.equals(teacher.getUsername(), signinRequest.getEmail())) {//
//            SecurityController.log.info("Поле 'Почта' пустое");
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
        if (Objects.equals(teacher, null) || !passwordEncoder.matches(signinRequest.getPassword(), teacher.getPassword())) {
            SecurityController.log.info("Ошибка авторизации пользователя ");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        String jwt = jwtCore.generateToken(teacher);

        NoteHubApplication.currentTeacher = userService.loadUserEntityByUsername(signinRequest.getEmail());
        SecurityController.log.info("Вход прошёл успешно");
        return ResponseEntity.ok(jwt);
    }
}
