package shop.shoes.portal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import shop.shoes.portal.service.IUserService;
import shop.shoes.portal.vo.RegisterVo;
import shop.shoes.portal.vo.RenewVo;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    IUserService userService;

    @Test
    public void getUserDetails() {
        UserDetails user = userService.getUserDetails("test1");
        System.out.println(user);
    }

    @Test
    public void registerTests() {
        RegisterVo registerVo = new RegisterVo();
        registerVo.setUsername("Yoba");
        registerVo.setPassword("2020");
        registerVo.setBirthday("2020-20-20");
        registerVo.setEmail("111@gmail.com");
        registerVo.setPhone("0912333333");
        userService.register(registerVo);

        System.out.println("OK!");
    }

    @Test
    @WithMockUser(username = "test1", password = "1107")
    public void testCurrentUsername() {
        String username = userService.currentUsername();
        System.out.println(username);
    }

    @Test
    public void testUpdate() {
        RenewVo renewVo = new RenewVo();
        renewVo.setUsername("test5");
        renewVo.setPassword("555");
        userService.update(renewVo);

        System.out.println("OK!");
    }

}
