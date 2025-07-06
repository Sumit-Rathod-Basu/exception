package exception.exception.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import exception.exception.model.Student;

public interface studentinterface  extends JpaRepository<Student,Long> {

   // String findBy(Long id, String entity);

    //String findBy(Long id, String entity);

}
