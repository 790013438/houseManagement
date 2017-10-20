package snippets.jee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value="/")
    public String home() {
        return "home";
    }

    @GetMapping("/toLogin")
    public String toLogin () {
        return "login";
    }

    @GetMapping("/toReg")
    public String toReg() {
        return "register";
    }
}
