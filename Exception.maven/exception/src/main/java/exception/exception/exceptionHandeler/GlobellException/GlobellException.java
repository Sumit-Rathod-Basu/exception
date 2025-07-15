package exception.exception.exceptionHandeler.GlobellException;

//import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobellException
{
                            @ExceptionHandler(IllegalArgumentException.class)
                            public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
                                return ResponseEntity.badRequest().body("Valiation are faild:"+ex.getMessage());    
                            }
                            
}
