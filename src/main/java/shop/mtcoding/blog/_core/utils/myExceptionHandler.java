package shop.mtcoding.blog._core.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import shop.mtcoding.blog._core.utils.exception.*;

@ControllerAdvice
public class myExceptionHandler {

    @ExceptionHandler(Exception400.class)
    public String ex400(RuntimeException e, HttpServletRequest request){
        request.setAttribute("msg", e.getMessage());
        return "errors/400";
    }

    @ExceptionHandler(Exception401.class)
    public String ex401(RuntimeException e, HttpServletRequest request){
        request.setAttribute("msg", e.getMessage());
        return "errors/401";
    }

    @ExceptionHandler(Exception403.class)
    public String ex403(RuntimeException e, HttpServletRequest request){
        request.setAttribute("msg", e.getMessage());
        return "errors/403";
    }

    @ExceptionHandler(Exception404.class)
    public String ex404(RuntimeException e, HttpServletRequest request){
        request.setAttribute("msg", e.getMessage());
        return "errors/404";
    }

    @ExceptionHandler(Exception500.class)
    public String ex500(RuntimeException e, HttpServletRequest request){
        request.setAttribute("msg", e.getMessage());
        return "errors/500";
    }
}