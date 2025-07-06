package exception.exception.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import exception.exception.model.Student;
import exception.exception.repository.studentinterface;

@Service
public class stuServices {


@Autowired
private studentinterface studentrepo;

public ResponseEntity<List<Student>> getdata() {
          return   ResponseEntity.ok(studentrepo.findAll());
}

public ResponseEntity<Student> saveStudent(Student student) {

    return ResponseEntity.ok(studentrepo.save(student));
}

public boolean deletedata(Long id) {
            Optional<Student> std=studentrepo.findById(id);
            if (std.isPresent()) {
                studentrepo.deleteById(id);
                return true;
            }
           else{
                return false;
            }

           }
           public ResponseEntity<Student> updateStudent(Long id ,Student student) {
            if (studentrepo.existsById(id))
            {
                student.setID(id);
              
                return ResponseEntity.ok(studentrepo.save(student));
            }
           return null;

           }
           
           public ResponseEntity<Student> updatedata(Long id,Student user)
           {
          
            Student existingUser = studentrepo.findById(id).orElse(null);
        if (existingUser != null) {
            if (user.getname() != null) {
                existingUser.setname(user.getname());
            }
            if (user.getemail() != null) {
                existingUser.setemail(user.getemail());
            }
           
           
            if (user.getPhone() != null) {
                existingUser.setPhoe(user.getPhone());
            }
           
            return ResponseEntity.ok(studentrepo.save(existingUser));
           }
        return  null;
           




}
}










