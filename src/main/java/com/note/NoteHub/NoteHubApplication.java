package com.note.NoteHub;

import com.note.NoteHub.models.Teacher;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NoteHubApplication {
	public static ApplicationContext context;
	public static Teacher currentTeacher;

	public static void main(String[] args) {
		SpringApplication.run(NoteHubApplication.class, args);
	}

}
