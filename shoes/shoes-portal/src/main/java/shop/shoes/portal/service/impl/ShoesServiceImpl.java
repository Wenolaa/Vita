package shop.shoes.portal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.shoes.portal.mapper.ShoesDetailMapper;
import shop.shoes.portal.mapper.ShoppingCartMapper;
import shop.shoes.portal.model.ShoesDetail;
import shop.shoes.portal.model.Size;
import shop.shoes.portal.service.IShoesService;
import shop.shoes.portal.service.ISizeService;
import shop.shoes.portal.service.ServiceException;
import shop.shoes.portal.vo.ShoesDetailVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ShoesServiceImpl extends ServiceImpl<ShoesDetailMapper, ShoesDetail> implements IShoesService {

    @Autowired
    ShoesDetailMapper shoesDetailMapper;
    @Autowired
    ISizeService sizeService;
    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @Override
    public List<ShoesDetail> getMyShoes() {
        List<ShoesDetail> list = shoesDetailMapper.getMyShoes();
        log.debug("登入首頁商品{}", list.size());

        for(ShoesDetail s: list) {
            List<Size> size = sizeNameToSize(s.getSize());
            s.setSizes(size);
        }
        log.debug("!list"+list);
        return list;
    }

    private List<Size> sizeNameToSize(String size) {
        String[] sizeName = size.split(",ww");
        List<Size> sizes = new ArrayList<>();
        Map<String, Size> sizeMap = sizeService.getSize2SizeMap();
        for(String sizesN: sizeName) {
            sizes.add(sizeMap.get(sizesN));
        }
        log.debug("!sizes"+sizes);
        return sizes;
    }


    @Override
    public void addShoes(ShoesDetailVo shoesDetailVo) {
        if(shoesDetailVo==null) {
            throw ServiceException.unprocesableEntity("表單數據為空!");
        }
        String shoesName = shoesDetailVo.getShoesName();
        int price = shoesDetailVo.getPrice();
        String size = shoesDetailVo.getSize();

        int rows = shoppingCartMapper.addShoes(shoesName, price, size);
        if(rows!=1) {
            throw new ServiceException("伺服器忙碌中，加入失敗!");
        }
    }


}
