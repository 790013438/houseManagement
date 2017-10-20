package snippets.jee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import snippets.jee.entity.User;
import snippets.jee.service.UserService;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String doLogin (@Valid User user, Errors errors, HttpServletRequest request, Model model) {
        String viewName = "login";
        if (!errors.hasErrors()) {
            user.setIpAddress(request.getRemoteAddr());
            if (userService.login(user)) {
                request.getSession().setAttribute("user", user);
                return "redirect: home";
            }
            model.addAttribute("hint", "用户名或密码错误");
        }
        model.addAttribute("hint", "请输入有效的登录信息");
        return viewName;
    }

    @PostMapping("/reg")
    public String doReg (User user, Model model) {
        String viewName = "register";
        if (userService.register(user)) {
            return "redirect: toLogin";
        }
        model.addAttribute("hint", "注册失败请尝试更换一个用户名");
        return viewName;
    }

    @GetMapping("/logout")
    public String doLogout (HttpSession session) {
        session.invalidate();
        return "redirect:home";
    }
}
