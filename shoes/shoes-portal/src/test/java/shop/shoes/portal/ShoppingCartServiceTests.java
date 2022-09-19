package shop.shoes.portal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.shoes.portal.model.ShoppingCart;
import shop.shoes.portal.service.IShoppingCartService;

import java.util.List;

@SpringBootTest
public class ShoppingCartServiceTests {

    @Autowired
    IShoppingCartService shoppingCartService;

    @Test
    public void ShoppingCartTests() {
        List<ShoppingCart> list = shoppingCartService.getMyShoppingCarts();
        list.forEach(shoppingCart -> System.out.println(shoppingCart));
    }

    @Test
    public void deleteTests() {
        String shoesName = "Air Jordan 1";
        String size = "27";
        shoppingCartService.remove(shoesName,size);

        System.out.println("ok!");
    }

}
