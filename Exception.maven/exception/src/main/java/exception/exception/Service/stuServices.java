package exception.exception.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import exception.exception.Mapper.mapper;
import exception.exception.model.Student;
import exception.exception.repository.studentinterface;
import exception.exception.utility.Userdto;

@Service
public class stuServices {


@Autowired
private studentinterface studentrepo;

@Autowired
private mapper mp;
public ResponseEntity<ResponseEntity<Userdto>> getdata() {

     

ResponseEntity<Userdto> std=ResponseEntity.ok(mp.toUserdto((Student) studentrepo.findAll()));


return ResponseEntity.ok(std);
}

public ResponseEntity<Userdto> saveStudent(Userdto student) 
{

    
    //  convert   userdto to student entity
    Student std=mp.toStudent(student);

    Student saveStudent= studentrepo.save(std);

    Userdto  dto=mp.toUserdto(saveStudent);

    return ResponseEntity.ok(dto);
    //return ResponseEntity.ok(studentrepo.save(student));
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
           public ResponseEntity<?> updateStudent(Long id ,Student student){
            if (studentrepo.existsById(id))
            {
                student.setID(id);
              
                studentrepo.save(student);
                return ResponseEntity.ok(studentrepo.findById(id).orElse(null));
            }
            else 
             {
               throw new IllegalArgumentException("Negative age not allowed!");
             }

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
 public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed!");
        }
        return a / b;
    }
}










