package snippets.jee.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import snippets.jee.util.CommonUtil;

@Controller
public class HomeController {

    private static final int CODE_LENGTH = 4;

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

    @GetMapping("/code")
    public void getCode (HttpServletResponse resp, HttpSession session) throws IOException {
        String code = CommonUtil.generateCode(CODE_LENGTH);
        session.setAttribute("code", code);
        resp.setContentType("image/png");
        BufferedImage codeImage = CommonUtil.generatedCodeImage(code, 80, 30);
        ImageIO.write(codeImage, "PNG", resp.getOutputStream());
    }

    @GetMapping("/toReg")
    public String toReg() {
        return "register";
    }
}
