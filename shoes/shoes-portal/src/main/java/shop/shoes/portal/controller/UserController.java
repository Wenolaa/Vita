package shop.shoes.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.shoes.portal.model.User;
import shop.shoes.portal.service.IUserService;

@RestController
@RequestMapping("/portal/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/get")
    @PreAuthorize("hasAnyAuthority('/user/get')")
    public User get(Integer id) {
        return userService.getById(id);
    }

}
