package shop.shoes.portal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import shop.shoes.portal.model.Size;

import java.util.List;

@Repository
public interface SizeMapper extends BaseMapper<Size> {

    @Select("SELECT * FROM shoesize;")
    List<Size> getSize();

}
