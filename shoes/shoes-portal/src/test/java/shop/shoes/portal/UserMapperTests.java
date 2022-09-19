package shop.shoes.portal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.shoes.portal.mapper.UserMapper;
import shop.shoes.portal.model.User;

@SpringBootTest
public class UserMapperTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void findUserByUsernameTests() {
        User user = userMapper.findUserByUsername("test1");
        System.out.println(user);
    }

    @Test
    public void updateUserTests() {
        String username = "test1";
        String password = "1211";
        int rows = userMapper.updateUser(username,password);
        System.out.println(rows);
    }

}
