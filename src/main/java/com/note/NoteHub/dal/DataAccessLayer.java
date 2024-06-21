package com.note.NoteHub.dal;

import com.note.NoteHub.models.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.List;

@Getter
public class DataAccessLayer {
    private final SessionFactory sessionFactory;

    @Autowired
    public DataAccessLayer(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    Session session = null;

//Group
    public void createGroup(Group newGroup) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newGroup);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteGroupById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Group group = session.get(Group.class, id);
        session.remove(group);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public Group getGroupById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Group group = session.get(Group.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return group;
    }
    public List<Group>getGroups(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Group> query = builder.createQuery(Group.class);
        Root<Group> root = query.from(Group.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }
    public void updateGroupById(Long id, Group updatedGroup){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Group group = session.get(Group.class, id);
        group.setGroupName(updatedGroup.getGroupName());
        session.merge(group);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    //Specialization
    public void createSpecialization(Specialization newSpecialization) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newSpecialization);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteSpecializationById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Specialization specialization = session.get(Specialization.class, id);
        session.remove(specialization);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public Specialization getSpecializationById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Specialization specialization = session.get(Specialization.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return specialization;
    }
    public List<Specialization> getSpecializations(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Specialization> query = builder.createQuery(Specialization.class);
        Root<Specialization> root = query.from(Specialization.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }
    public void updateSpecializationById(Long id, Specialization updatedSpecialization){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Specialization specialization = session.get(Specialization.class, id);
        specialization.setSpecializationName(updatedSpecialization.getSpecializationName());
        session.merge(specialization);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    //Parent
    public void createParent(Parent newParent) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newParent);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteParentById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Parent parent = session.get(Parent.class, id);
        session.remove(parent);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public Parent getParentById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Parent parent = session.get(Parent.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return parent;
    }
    public List<Parent> getParents(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Parent> query = builder.createQuery(Parent.class);
        Root<Parent> root = query.from(Parent.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }
    public void updateParentById(Long id, Parent updatedParent){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Parent parent = session.get(Parent.class, id);
        parent.setFirstName(updatedParent.getFirstName());
        parent.setLastName(updatedParent.getLastName());
        parent.setPatronymic(updatedParent.getPatronymic());
        parent.setPhoneNumber(updatedParent.getPhoneNumber());
        parent.setEmail(updatedParent.getEmail());
        session.merge(parent);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    //Student
    public void createStudent(Student newStudent) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newStudent);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteStudentById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.remove(student);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public Student getStudentById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return student;
    }
    public List<Student> getStudentByGroupId(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        Predicate groupIdPredicate = builder.equal(root.get("group").get("groupId"), id);
        query.select(root).where(groupIdPredicate);
        return session.createQuery(query).getResultList();
    }
    public List<Student> getStudentBySpecializationId(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        Predicate specializationIdPredicate = builder.equal(root.get("specialization").get("specializationId"), id);
        query.select(root).where(specializationIdPredicate);
        return session.createQuery(query).getResultList();
    }
    public List<Student> getStudents(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }
    public void updateStudentById(Long id, Student updatedStudent){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setPatronymic(updatedStudent.getPatronymic());
        student.setAge(updatedStudent.getAge());
        student.setPhoneNumber(updatedStudent.getPhoneNumber());
        student.setEmail(updatedStudent.getEmail());
        student.setSpecialization(updatedStudent.getSpecialization());
        student.setGroup(updatedStudent.getGroup());
        student.setParent(updatedStudent.getParent());//?
        session.merge(student);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    //Review
    public void createReview(Review newReview) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newReview);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteReviewById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Review review = session.get(Review.class, id);
        session.remove(review);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public Review getReviewById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Review review = session.get(Review.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return review;
    }
    public List<Review> getReviewByStudentId(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Review> query = builder.createQuery(Review.class);
        Root<Review> root = query.from(Review.class);
        Predicate studentIdPredicate = builder.equal(root.get("student").get("studentId"), id);
        query.select(root).where(studentIdPredicate);
        return session.createQuery(query).getResultList();
    }

    public List<Review> getReviews(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Review> query = builder.createQuery(Review.class);
        Root<Review> root = query.from(Review.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }
    public void updateReviewById(Long id, Review updatedReview){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Review review = session.get(Review.class, id);
        review.setShortDescription(updatedReview.getShortDescription());
        review.setDateTime(updatedReview.getDateTime());
        review.setStudent(updatedReview.getStudent());
        session.merge(review);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    //Teacher
    public String newTeacherToDatabase(Teacher teacher) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        String firstName = teacher.getFirstName();
        String lastName = teacher.getLastName();
        String patronymic = teacher.getPatronymic();
        String email = teacher.getEmail();

        // Check if the firstname is empty
        if (firstName == null || firstName.trim().isEmpty()) {
            return "Имя преподавателя не может быть пустым";
        }

        Query query = session
                .createQuery("FROM Teacher where email = :email")
                .setParameter("email", email);
        Teacher teacherFrom = (Teacher) query.uniqueResult();

        if (teacherFrom != null) {
            return "Данная почта уже зарегистрирована";
        }
        String hashedPassword = BCrypt.hashpw(teacher.getPassword(),BCrypt.gensalt());
        teacher.setPassword(hashedPassword);

        session.persist(teacher);
        session.getTransaction().commit();
        session.close();
        return "Новый преподаватель добавлен в базу данных";
    }

    /////////////////////////////////////////////////////////////////////
    public Teacher getTeacherFromDatabaseByEmail(String email){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session
                .createQuery("FROM Teacher where email = :email")
                .setParameter("email", email);
        Teacher teacherFrom = (Teacher) query.uniqueResult();
        if (teacherFrom == null) {
            return null;
        }
        return teacherFrom;
    }
    public Teacher getTeacherById(Long id){
        session=sessionFactory.openSession();
        session.beginTransaction();
        Teacher teacher=session.get(Teacher.class,id);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
        return teacher;
    }
    public List<Teacher> getTeachers(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Teacher> query = builder.createQuery(Teacher.class);
        Root<Teacher> root = query.from(Teacher.class);
        query.select(root);
        List<Teacher> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public  void updateTeacherById(Long id, Teacher updatedUser){
        session=sessionFactory.openSession();
        session.beginTransaction();
        Teacher teacher=session.get(Teacher.class,id);
        teacher.setFirstName(updatedUser.getFirstName());
        teacher.setLastName(updatedUser.getLastName());
        teacher.setPatronymic(updatedUser.getPatronymic());
        teacher.setEmail(updatedUser.getEmail());
        teacher.setPhoneNumber(updatedUser.getPhoneNumber());
        teacher.setPassword(updatedUser.getPassword());
        session.merge(teacher);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
    }
    public void deleteTeacherById(Long id){
        session=sessionFactory.openSession();
        session.beginTransaction();
        Teacher user=session.get(Teacher.class,id);
        session.remove(user);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
    }
}
