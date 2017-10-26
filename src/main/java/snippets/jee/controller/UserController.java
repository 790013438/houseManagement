package snippets.jee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import snippets.jee.dto.CheckResult;
import snippets.jee.dto.UserLoginDTO;
import snippets.jee.entity.User;
import snippets.jee.service.UserService;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/check")
    @ResponseBody
    public CheckResult checkUsername (String username) {
        boolean valid = userService.checkUnique(username);
        return new CheckResult(username, valid,
                valid ? "用户名可用" : "用户名已被使用",
                valid ? "ok.png" : "no.png");
    }

    @GetMapping("/toLogin")
    public String toLogin (Model model) {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        model.addAttribute("user", userLoginDTO);

        return "login";
    }

    @PostMapping("/login")
    public String doLogin (@Valid @ModelAttribute("user")UserLoginDTO user, Errors errors, HttpServletRequest request, Model model) {
        String codeFromServer = (String)request.getSession().getAttribute("code");
        if (!codeFromServer.equalsIgnoreCase(user.getCode())) {
            model.addAttribute("hint", "请输入正确的验证码");
            return "login";
        }
        if (errors.hasErrors()) {
            model.addAttribute("hint", "请输入有效的登录信息");
            return "login";
        }
        user.setIpAddress(request.getRemoteAddr());
        if (!userService.login(user)) {
            model.addAttribute("hint", "用户名或密码错误");
            return "login";
        }
        request.getSession().setAttribute("userId", user.getId());
        request.getSession().setAttribute("userRealname", user.getRealname());
        return "redirect: home";
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
