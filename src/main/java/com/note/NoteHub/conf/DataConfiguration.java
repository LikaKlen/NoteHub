package com.note.NoteHub.conf;

import com.note.NoteHub.dal.DataAccessLayer;
import com.note.NoteHub.models.Teacher;
import com.note.NoteHub.security.TokenFilter;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
public class DataConfiguration {
    private final SessionFactory sessionFactory;

    @Autowired
    public DataConfiguration(EntityManager entityManager) {
        Session session = entityManager.unwrap(Session.class);
        this.sessionFactory = session.getSessionFactory();
    }

    @Bean
    public Teacher teacher(){
        return new Teacher();
    }

    @Bean
    public DataAccessLayer dataAccessLayer() {
        return new DataAccessLayer(sessionFactory);
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}
