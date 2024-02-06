//package ma.ip.exceptions;
//
//import lombok.extern.log4j.Log4j2;
//import ma.ip.dto.responses.GenericResponse;
//import ma.ip.enums.ErrorStatus;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.nio.file.AccessDeniedException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@ControllerAdvice
//@Log4j2
//public class ControllerAdvisor extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<GenericResponse> handleGenericException(Exception e) {
//        GenericResponse result = new GenericResponse();
//        log.error("Handling Technical Error Exception " + e.getLocalizedMessage());
//        //e.printStackTrace();
//        result.setError(true);
//        result.setAlert(false);
//        result.setStatusCode(String.valueOf(ErrorStatus.TECHNICAL_ERROR.code()));
//        result.setDescription(e.getLocalizedMessage() != null ? e.getLocalizedMessage() : ErrorStatus.TECHNICAL_ERROR.description());
//        result.setDescriptionForCustomer(ErrorStatus.TECHNICAL_ERROR.description());
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
//    }
//
//
////    @ExceptionHandler(feign.RetryableException.class)
////    public ResponseEntity<GenericResponse> handleCustomerException(feign.RetryableException e) {
////        GenericResponse result = new GenericResponse();
////        result.setError(true);
////        result.setAlert(false);
////        log.error("Handling TimeOut Exception " + e.getLocalizedMessage());
////        //e.printStackTrace();
////        result.setStatusCode(String.valueOf(HttpStatus.REQUEST_TIMEOUT.value()));
////        result.setDescription(e.getLocalizedMessage() != null ? e.getLocalizedMessage() : ErrorStatus.TECHNICAL_ERROR.description());
////        result.setDescriptionForCustomer(ErrorStatus.TECHNICAL_ERROR.description());
////        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
////    }
//
//    @ExceptionHandler(CustomerException.class)
//    public ResponseEntity<GenericResponse> handleCustomerException(CustomerException e) {
//        GenericResponse result = new GenericResponse();
//        result.setError(true);
//        result.setAlert(e.isAlert());
//        log.error("Handling Customer Exception " + e.getLocalizedMessage());
//        //e.printStackTrace();
//        result.setStatusCode(e.getCode());
//        result.setDescription(e.getMessage());
//        result.setDescriptionForCustomer(e.getMessage());
//        return ResponseEntity.status(HttpStatus.OK).body(result);
//    }
//
//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<GenericResponse> handleAccessDeniedException(AccessDeniedException e) {
//        GenericResponse result = new GenericResponse();
//        log.error("Access Denied Exception " + e.getLocalizedMessage());
//        //e.printStackTrace();
//        result.setDescription(ErrorStatus.FORBIDDEN_ERROR.description());
//        result.setDescriptionForCustomer(ErrorStatus.FORBIDDEN_ERROR.description());
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
//    }
//
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        GenericResponse result = new GenericResponse();
//        result.setStatusCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
//        result.setError(true);
//        result.setAlert(false);
//        log.error("Method Argument Not Valid Exception " + e.getLocalizedMessage());
//        //e.printStackTrace();
//        List<String> errors = new ArrayList<>();
//        e.getBindingResult().getAllErrors().forEach((error) -> {
//            String errorMessage = error.getDefaultMessage();
//            errors.add(errorMessage);
//        });
//        String errorDesc = errors.stream().collect(Collectors.joining(";"));
//        result.setDescription(errorDesc);
//        result.setDescriptionForCustomer(errorDesc);
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
//    }
//}
