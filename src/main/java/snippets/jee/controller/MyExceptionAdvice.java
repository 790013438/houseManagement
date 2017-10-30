package snippets.jee.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionAdvice {

    @ExceptionHandler({ExecutionException.class})
    public String toException (Model model) {
        return "error/hint";
    }
}
