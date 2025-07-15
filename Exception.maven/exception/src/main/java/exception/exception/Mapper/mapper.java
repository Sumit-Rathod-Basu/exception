package exception.exception.Mapper;



import org.mapstruct.Mapper;

import exception.exception.model.Student;
import exception.exception.utility.Userdto;

@Mapper(componentModel = "spring")
public interface mapper {

    Student toStudent(Userdto dto);

    Userdto toUserdto(Student saveStudent);

    
}
