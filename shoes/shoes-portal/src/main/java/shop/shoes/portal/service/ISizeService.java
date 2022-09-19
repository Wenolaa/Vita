package shop.shoes.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import shop.shoes.portal.model.Size;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shop
 * @since 2022-05-18
 *
 */
public interface ISizeService extends IService<Size> {

    List<Size> getSize();
    Map<String, Size> getSize2SizeMap();
}
