package shop.shoes.portal.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.WebAttributes;
import shop.shoes.portal.model.User;
import shop.shoes.portal.mapper.UserMapper;
import shop.shoes.portal.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import shop.shoes.portal.service.ServiceException;
import shop.shoes.portal.vo.RegisterVo;
import shop.shoes.portal.vo.RenewVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shop
 * @since 2022-05-18
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails getUserDetails(String username) {
        User user = userMapper.findUserByUsername(username);
        if (user==null) {
            return null;
        }

        UserDetails u = org.springframework.security.core.userdetails
                .User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities("/user/get")
                .build();
        return u;
    }

    @Override
    public void register(RegisterVo registerVo) {
        if(registerVo==null) {
            throw ServiceException.unprocesableEntity("表單數據為空!");
        }
        String existPhone = userMapper.findUserByPhone(registerVo.getPhone());
        if(existPhone != null) {
            log.info("手機號碼已註冊過!");
            throw ServiceException.unprocesableEntity("手機號碼已註冊過!");
        }
        User user = new User();
        user.setUsername(registerVo.getUsername());
        user.setBirthday(registerVo.getBirthday());
        user.setEmail(registerVo.getEmail());
        user.setPhone(registerVo.getPhone());
        user.setPassword(passwordEncoder.encode(registerVo.getPassword()));
        System.out.println("註冊會員:"+user);
        log.debug("註冊會員:"+user);

        int rows = userMapper.insert(user);
        if(rows!=1) {
            throw new ServiceException("伺服器忙碌中，註冊失敗!");
        }
    }
    protected final void saveException(RegisterVo registerVo, HttpServletRequest request,
                                       AuthenticationException exception) {
        User u = userMapper.findUserByUsername(registerVo.getPhone());
        if (u!=null) {
            request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
        }
        else {
            HttpSession session = request.getSession(false);

            if (session != null) {
                request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION,
                        exception);
            }
        }
    }

    @Override
    public String currentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
            return username;
        }
        throw ServiceException.unprocesableEntity("還沒有登入!");
    }

    @Override
    public void update(RenewVo renewVo) {
        if(renewVo==null) {
            throw ServiceException.unprocesableEntity("表單數據為空!");
        }
        User u = userMapper.findUserByUsername(renewVo.getUsername());
        if(u==null) {
            throw ServiceException.unprocesableEntity("查無此帳號!");
        }
        int rows = userMapper.updateUser(u.getUsername(),passwordEncoder.encode(renewVo.getPassword()));
        if(rows!=1) {
            throw new ServiceException("伺服器忙碌中，更新失敗!");
        }

    }

}
