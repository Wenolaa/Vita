package shop.shoes.portal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class SecurityTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void passwordEncoderTest() {
        String pwd = passwordEncoder.encode("123456");
        System.out.println(pwd);
    }

}
