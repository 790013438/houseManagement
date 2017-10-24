package snippets.jee.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import snippets.jee.entity.City;
import snippets.jee.entity.District;
import snippets.jee.entity.Province;
import snippets.jee.service.LocationService;
import snippets.jee.util.CommonUtil;

@Controller
public class HomeController {

    private static final int CODE_LENGTH = 4;

    @Autowired
    private LocationService locationService;

    @GetMapping({"/", "/home"})
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value="/")
    public String home() {
        return "home";
    }

    @GetMapping("/cities")
    @ResponseBody
    public List<City> getCities (Province province) {
        return locationService.listAllCitiesByProvince(province);
    }

    @GetMapping("/districts")
    @ResponseBody
    public List<District> getDistricts (City city) {
        return locationService.listAllDistrictsByCity(city);
    }

    @GetMapping("/toLogin")
    public String toLogin () {
        return "login";
    }

    @GetMapping(value = "/code", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public BufferedImage getCode (HttpServletResponse resp, HttpSession session) throws IOException {
        String code = CommonUtil.generateCode(CODE_LENGTH);
        session.setAttribute("code", code);
        return CommonUtil.generatedCodeImage(code, 80, 30);
    }

    @GetMapping("/toReg")
    public String toReg() {
        return "register";
    }

    @GetMapping("toPub")
    public String toPub() {
        return "pub";
    }
}
