package shop.shoes.portal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import shop.shoes.portal.mapper.ShoesDetailMapper;
import shop.shoes.portal.model.ShoesDetail;
import shop.shoes.portal.model.ShoppingCart;
import shop.shoes.portal.vo.R;

import java.util.List;

@RestController
@Slf4j
public class HomeController {

    @GetMapping("/index_shoes.html")
    public ModelAndView index() {
        return new ModelAndView("index_shoes");
    }

    @GetMapping("/index_coming.html")
    public ModelAndView indexComing() {
        return new ModelAndView("index_coming");
    }
}
