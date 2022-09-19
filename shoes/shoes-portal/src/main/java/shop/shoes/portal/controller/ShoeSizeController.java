package shop.shoes.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.shoes.portal.model.ShoesDetail;
import shop.shoes.portal.model.ShoppingCart;
import shop.shoes.portal.model.Size;
import shop.shoes.portal.service.IShoppingCartService;
import shop.shoes.portal.service.ISizeService;
import shop.shoes.portal.vo.R;

import java.util.List;

@RestController
@RequestMapping("/size")
public class ShoeSizeController {

    @Autowired
    ISizeService sizeService;

    @GetMapping("")
    public R<List<Size>> size() {
        List<Size> sizeList = sizeService.getSize();
        return R.ok(sizeList);
    }
}
