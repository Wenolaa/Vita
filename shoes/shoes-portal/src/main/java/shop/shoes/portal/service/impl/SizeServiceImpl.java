package shop.shoes.portal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.shoes.portal.mapper.SizeMapper;
import shop.shoes.portal.model.Size;
import shop.shoes.portal.service.ISizeService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class SizeServiceImpl extends ServiceImpl<SizeMapper, Size> implements ISizeService {

    @Autowired
    SizeMapper sizeMapper;

    private final ConcurrentHashMap<String, Size> size2SizeMap = new ConcurrentHashMap<>();

    @Override
    public List<Size> getSize() {
        List<Size> sizes = sizeMapper.getSize();
        sizes.forEach(size -> size2SizeMap.put(size.getSize(), size));
        log.debug("load sizes {}", sizes);
        log.debug("load sizeMap {}", size2SizeMap);
        return sizes;
    }

    @Override
    public Map<String, Size> getSize2SizeMap() {
        if(size2SizeMap.isEmpty()) {
            getSize();
        }
        return size2SizeMap;
    }
}
