package snippets.jee.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import snippets.jee.dto.PageBean;
import snippets.jee.entity.City;
import snippets.jee.entity.District;
import snippets.jee.entity.House;
import snippets.jee.entity.Province;
import snippets.jee.service.HouseService;
import snippets.jee.service.LocationService;
import snippets.jee.util.CommonUtil;

@Controller
public class HomeController {

    private static final int CODE_LENGTH = 4;

    @Autowired
    private LocationService locationService;
    @Autowired
    private HouseService houseService;

    @GetMapping({"/", "/home"})
    public String toIndex(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size, Model model) {
        PageBean<House> pageBean = houseService.listHousesByPage(page, size);

        model.addAttribute("houseList", pageBean.getDataModel());
        model.addAttribute("currentPage", pageBean.getCurrentPage());
        model.addAttribute("totalPage", pageBean.getTotalPage());

        return "index";
    }

    @RequestMapping(value="/")
    public String home() {
        return "home";
    }

    @GetMapping("/cities")
    @ResponseBody
    public List<City> getCities (@ModelAttribute("province") Province province, int id, @ModelAttribute("provinceList") ArrayList<Province> provinceList) {
        if (provinceList == null) {
            return Collections.emptyList();
        }
        if (province == null) {
            return Collections.emptyList();
        }
        return province.getCities();
    }

    @GetMapping("/districts")
    @ResponseBody
    public List<District> getDistricts (City city) {
        return locationService.listAllDistrictsByCity(city);
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
