package exception.exception.Controller;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.service.annotation.DeleteExchange;

import exception.exception.Service.stuServices;
import exception.exception.model.Student;
import exception.exception.utility.Userdto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;






@RestController
public class exceptioncontroller 
{
     

    @Autowired
    private stuServices  stu;
     @GetMapping("/getdata")  
     public   ResponseEntity<ResponseEntity<Userdto>> FindAll()
     {     // stu.getdata();
        return stu.getdata();
     }

  
@PostMapping("/add")
  public ResponseEntity<ResponseEntity<Userdto>> saveStudent(@RequestBody Userdto Student )
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
        public ResponseEntity<?>  updateStudents(@ PathVariable Long id ,@RequestBody Student student)  {
          return ResponseEntity.ok(stu.updateStudent(id,student));
        }
        @PatchMapping("/partialUpdate/{id}")
        public ResponseEntity<ResponseEntity<Student>> partialUpdate(@PathVariable Long id,@RequestBody  Student student)
        {
          return ResponseEntity.ok(stu.updatedata(id,student));
        }
        

        @GetMapping("/getdata1/{id}")
        public ResponseEntity<String> getcal(@PathVariable   Integer id)
        {
          int a = 10;
          int b = 0;  
           if (b == 0) {
              throw new IllegalArgumentException("Division by zero is not allowed");
          } 
          return ResponseEntity.ok("This is a get method");

        }

         @GetMapping("/divide/{a}/{b}")
    public ResponseEntity<String> divide(
            @PathVariable int a,
            @PathVariable int b) {
        int result = stu.divide(a,b);
        return ResponseEntity.ok("Result: " + result);
    }



}