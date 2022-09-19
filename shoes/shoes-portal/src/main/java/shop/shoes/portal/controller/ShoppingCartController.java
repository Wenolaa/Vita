package shop.shoes.portal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.shoes.portal.mapper.ShoppingCartMapper;
import shop.shoes.portal.model.ShoesDetail;
import shop.shoes.portal.model.ShoppingCart;
import shop.shoes.portal.service.IShoesService;
import shop.shoes.portal.service.IShoppingCartService;
import shop.shoes.portal.service.ServiceException;
import shop.shoes.portal.vo.R;
import shop.shoes.portal.vo.ShoesDetailVo;

import java.util.List;

@RestController
@RequestMapping("/shoppingcart")
@Slf4j
public class ShoppingCartController {

    @Autowired
    IShoppingCartService shoppingCartService;
    @Autowired
    IShoesService shoesService;

    @GetMapping("")
    public R<List<ShoppingCart>> cartDetail() {
        List<ShoppingCart> shoppingCartList = shoppingCartService.getMyShoppingCarts();
        return R.ok(shoppingCartList);
    }

    @GetMapping("/remove")
    public R remove(String shoesName, String size) {
        try {
            shoppingCartService.remove(shoesName,size);
            return R.created("刪除成功!");
        } catch (ServiceException e) {
            log.error("加入失敗!", e);
            return R.failed(e);
        }
    }

}
