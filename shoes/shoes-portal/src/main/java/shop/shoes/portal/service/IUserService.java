package shop.shoes.portal.service;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import shop.shoes.portal.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import shop.shoes.portal.vo.RegisterVo;
import shop.shoes.portal.vo.RenewVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shop
 * @since 2022-05-18
 *
 */
public interface IUserService extends IService<User> {

    UserDetails getUserDetails(String username);

    void register(RegisterVo registerVo);

    String currentUsername();

    void update(RenewVo renewVo);

}
