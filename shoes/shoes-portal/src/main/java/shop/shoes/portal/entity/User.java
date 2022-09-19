package shop.shoes.portal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private LocalDate birthday;
    private String phone;
}
