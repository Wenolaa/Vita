package shop.shoes.portal;

import shop.shoes.portal.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.shoes.portal.model.User;

@SpringBootTest
class ShoesPortalApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void userMapperTests() {
        User user = userMapper.selectById(2);
        System.out.println(user);
    }

}
