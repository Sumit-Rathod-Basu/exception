package exception.exception.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@getter
@setter
@Entity
@Table(name = "student")
public class Student {
    
        @jakarta.persistence.Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;


        private String name;
        private String email;
        private String phone;   
        
        public Long getID() {
            return Id;
        }                       

        public void setID(Long Id)
        {
                this.Id=Id;
        }

        public String getname()
        {
                return name;
        }



        public void  setname(String N)
        {
              this.name=N;
        }

        public String getemail()
        {
                     return  email;  
        }

        public void setemail(String E)
        {
                this.email=E;
        }

        public String getPhone()
        {
                return phone;
        }

        public void setPhoe(String P)
        {
                this.phone=P;
        }

        public boolean existsById(Long id2) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'existsById'");
        }

}
