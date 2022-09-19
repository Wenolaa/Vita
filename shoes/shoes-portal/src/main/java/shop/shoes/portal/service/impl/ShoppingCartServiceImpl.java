package shop.shoes.portal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.shoes.portal.mapper.ShoppingCartMapper;
import shop.shoes.portal.model.ShoppingCart;
import shop.shoes.portal.service.IShoppingCartService;
import shop.shoes.portal.service.IUserService;
import shop.shoes.portal.service.ServiceException;

import java.util.List;

@Service
@Slf4j
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements IShoppingCartService {

    @Autowired
    IUserService userService;
    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @Override
    public List<ShoppingCart> getMyShoppingCarts() {
        List<ShoppingCart> list = shoppingCartMapper.getShoppingCart();
        log.debug("找到當前用戶購物車{}", list.size());

        return list;
    }

    @Override
    public void remove(String shoesName, String size) {
        int rows = shoppingCartMapper.deleteShoes(shoesName,size);
        if(rows!=1) {
            throw new ServiceException("伺服器忙碌中，刪除失敗!");
        }
    }
}
