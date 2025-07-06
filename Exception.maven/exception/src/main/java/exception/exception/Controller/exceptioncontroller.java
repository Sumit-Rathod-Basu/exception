package exception.exception.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import exception.exception.Service.stuServices;
import exception.exception.model.Student;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;






@RestController
public class exceptioncontroller 
{
     

    @Autowired
    private stuServices  stu;
     @GetMapping("/getdata")  
     public   ResponseEntity<List<Student>> FindAll()
     {     // stu.getdata();
        return stu.getdata();
     }

  
@PostMapping("/add")
  public ResponseEntity<ResponseEntity<Student>> saveStudent(@RequestBody Student Student )
  {
   // stu.saveStudent(Student);
    return ResponseEntity.ok(stu.saveStudent(Student));
  }


  @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id)
    {
       Boolean deleted = stu.deletedata(id);
       if (deleted)
       {
        return  "Deleted Successfully at is is  " + id  ;
       }
         else
       {
        return "Student with id " + id + " not found." ;
         }
      }
        @PutMapping("/upadte/{id}")
        public ResponseEntity<ResponseEntity<Student>>  updateStudents(@ PathVariable Long id ,@RequestBody Student student) {
          return ResponseEntity.ok(stu.updateStudent(id,student));
        }
        @PatchMapping("/partialUpdate/{id}")
        public ResponseEntity<ResponseEntity<Student>> partialUpdate(@PathVariable Long id,@RequestBody  Student student)
        {
          return ResponseEntity.ok(stu.updatedata(id,student));
        }


}