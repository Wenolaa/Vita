package shop.shoes.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import shop.shoes.portal.model.ShoppingCart;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shop
 * @since 2022-05-18
 *
 */
public interface IShoppingCartService extends IService<ShoppingCart> {

    List<ShoppingCart> getMyShoppingCarts();

    void remove(String shoesName, String size);
}
