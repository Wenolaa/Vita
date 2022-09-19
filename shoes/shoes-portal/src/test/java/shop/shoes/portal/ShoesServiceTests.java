package shop.shoes.portal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import shop.shoes.portal.model.ShoesDetail;
import shop.shoes.portal.model.ShoppingCart;
import shop.shoes.portal.model.Size;
import shop.shoes.portal.service.IShoesService;
import shop.shoes.portal.service.ISizeService;
import shop.shoes.portal.vo.ShoesDetailVo;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class ShoesServiceTests {

    @Autowired
    IShoesService shoesService;

    @Autowired
    ISizeService sizeService;

    @Test
    public void getMyShoes() {
        List<ShoesDetail> shoesDetails = shoesService.getMyShoes();
        shoesDetails.forEach(shoesDetail -> System.out.println(shoesDetail));
    }

    @Test
    public void getSize2SizeMap() {
        Map<String, Size> map = sizeService.getSize2SizeMap();
        map.forEach((size, sizes)->System.out.println(size+":"+sizes));
    }


    @Test
    public void insertTests() {
        ShoesDetailVo shoesDetailVo = new ShoesDetailVo();
        shoesDetailVo.setShoesName("Air Jordan 1");
        shoesDetailVo.setPrice(5800);
        shoesDetailVo.setSize("28");
        shoesService.addShoes(shoesDetailVo);

        System.out.println("OK!");
    }

}
