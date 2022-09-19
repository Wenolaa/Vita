package shop.shoes.portal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import shop.shoes.portal.model.ShoppingCart;

import java.util.List;

@Repository
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {

    @Delete("DELETE FROM shoppingcart WHERE shoesName=#{shoesName} and size=#{size}")
    int deleteShoes(String shoesName, String size);

    @Select("SELECT * FROM shoppingcart")
    List<ShoppingCart> getShoppingCart();

    @Insert("INSERT INTO shoppingcart (id,shoesName,price,size) VALUES (null,#{shoesName},#{price},#{size})")
    int addShoes(String shoesName, int price, String size);

}
