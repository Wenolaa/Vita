package shop.shoes.portal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import shop.shoes.portal.mapper.UserMapper;
import shop.shoes.portal.service.IUserService;
import shop.shoes.portal.service.ServiceException;
import shop.shoes.portal.vo.R;
import shop.shoes.portal.vo.RegisterVo;
import shop.shoes.portal.vo.RenewVo;

@RestController
@Slf4j
public class SystemController {

    @Autowired
    IUserService userService;
    @Autowired
    UserMapper userMapper;

    @GetMapping("/login_shoes.html")
    public ModelAndView loginForm() {
        return new ModelAndView("login_shoes");
    }

    @GetMapping("/register_shoes.html")
    public ModelAndView register() {
        return new ModelAndView("register_shoes");
    }

    @PostMapping("/register_shoes")
    public R register(@Validated RegisterVo registerVo, BindingResult bindingResult) {
        log.debug("得到登入表單:{}", registerVo);
        if(bindingResult.hasErrors()) {
            String error = bindingResult.getFieldError().getDefaultMessage();
            return R.unprocesableEntity(error);
        }
        if(! registerVo.getPassword().equals(registerVo.getConfirm())){
            return R.unprocesableEntity("確認密碼不一致!");
        }
        try {
            userService.register(registerVo);
            return R.created("註冊成功!");
        } catch (ServiceException e) {
            log.error("註冊失敗!", e);
            return R.failed(e);
        }
    }
    @GetMapping("/register_shoes")
    public ModelAndView registers(@Validated RegisterVo registerVo, ModelMap model) {
        String existPhone = userMapper.findUserByPhone(registerVo.getPhone());
        if(existPhone.length() != 0) {
            model.put("message","手機號碼已註冊!");
            return new ModelAndView("message");
        }else {
            model.put("message","註冊成功!");
            return new ModelAndView("message");
        }
    }

    @GetMapping("/renew.html")
    public ModelAndView update() {
        return new ModelAndView("renew");
    }

    @PostMapping("/renew")
    public R update(@Validated RenewVo renewVo, BindingResult bindingResult) {
        log.debug("得到登入表單:{}", renewVo);
        if(bindingResult.hasErrors()) {
            String error = bindingResult.getFieldError().getDefaultMessage();
            return R.unprocesableEntity(error);
        }
        try {
            userService.update(renewVo);
            return R.created("修改成功!");
        } catch (ServiceException e) {
            log.error("修改失敗!", e);
            return R.failed(e);
        }
    }

    @GetMapping("/shoppingcart.html")
    public ModelAndView shoppingcart() { return new ModelAndView("shoppingcart"); }

    @GetMapping("/payment.html")
    public ModelAndView payment() { return new ModelAndView("payment"); }

    @GetMapping("/order.html")
    public ModelAndView order() { return new ModelAndView("order"); }

}
