package shop.shoes.portal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.shoes.portal.model.ShoesDetail;
import shop.shoes.portal.service.IShoesService;
import shop.shoes.portal.service.ServiceException;
import shop.shoes.portal.vo.R;
import shop.shoes.portal.vo.ShoesDetailVo;

import java.util.List;

@RestController
@RequestMapping("/index_shoes")
@Slf4j
public class ShoesDetailController {

    @Autowired
    IShoesService shoesService;

    @GetMapping("")
    public R<List<ShoesDetail>> shoesDetail() {
        List<ShoesDetail> shoesDetail = shoesService.getMyShoes();
        return R.ok(shoesDetail);
    }

    @GetMapping("/add")
    public R addShoes(@Validated ShoesDetailVo shoesDetailVo) {
        log.debug("得到購物車表單:{}", shoesDetailVo);
        try {
            shoesService.addShoes(shoesDetailVo);
            return R.created("加入成功!");
        } catch (ServiceException e) {
            log.error("加入失敗!", e);
            return R.failed(e);
        }
    }

}
