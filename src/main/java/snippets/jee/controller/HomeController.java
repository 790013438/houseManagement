package snippets.jee.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import snippets.jee.entity.User;
import snippets.jee.service.UserService;

@Controller
public class HomeController {

    @SuppressWarnings("unused")
    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value="/")
    public String home() {
        return "home";
    }

    @GetMapping("/hello")
    public String foo (User user, Model model) {
        model.addAttribute("name", "tigger");
        List<String> fruitList = Arrays.asList("香蕉", "李子", "桃子");
        model.addAttribute("fruits", fruitList);
        return "home";
    }
}
