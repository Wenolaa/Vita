package shop.shoes.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import shop.shoes.portal.model.ShoesDetail;
import shop.shoes.portal.model.ShoppingCart;
import shop.shoes.portal.vo.ShoesDetailVo;

import java.util.List;

public interface IShoesService extends IService<ShoesDetail> {

    List<ShoesDetail> getMyShoes();

    void addShoes(ShoesDetailVo shoesDetailVo);

}
