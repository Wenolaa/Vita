package shop.shoes.portal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import shop.shoes.portal.model.ShoesDetail;
import shop.shoes.portal.vo.ShoesDetailVo;

import java.util.List;

@Repository
public interface ShoesDetailMapper extends BaseMapper<ShoesDetail> {

    @Select("SELECT d.id, d.shoesName, d.shoesColor, d.price, s.size " +
            "FROM shoesdetail d INNER JOIN shoesize s ON d.id=s.shoesdetailid")
    List<ShoesDetail> getMyShoes();

}
